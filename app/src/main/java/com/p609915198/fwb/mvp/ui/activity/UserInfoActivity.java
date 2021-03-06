package com.p609915198.fwb.mvp.ui.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.UserBaseInfoResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.basemodule.widget.CircleImageView;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.UserInfoContract;
import com.p609915198.fwb.mvp.di.component.DaggerUserInfoComponent;
import com.p609915198.fwb.mvp.di.module.UserInfoModule;
import com.p609915198.fwb.mvp.presenter.UserInfoPresenter;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 用户资料
 */
public class UserInfoActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.tv_user_name) TextView tvUserName;
    @BindView(R.id.tv_age) TextView tvAge;
    @BindView(R.id.rg_introduce) RadioGroup rgIntroduce;
    @BindView(R.id.tv_phone_number) TextView tvPhoneNumber;
    @BindView(R.id.civ_user_head) CircleImageView civUserHead;
    @BindView(R.id.rb_man) RadioButton rbMan;
    @BindView(R.id.rb_women) RadioButton rbWomen;

    @Inject Api mApi;

    public static final int TAKE_PHOTO = 1;
    public static final int CROP_PHOTO = 2;
    public static final int CHOOSE_PHOTO = 3;
    private Uri imageUri;
    private ImageView picture;

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerUserInfoComponent
                .builder()
                .baseComponent(baseComponent)
                .userInfoModule(new UserInfoModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_user_info;
    }

    @Override
    public void initData() {
        tvCenter.setText("个人资料");
        tvCenter.setVisibility(View.VISIBLE);

        mApi.userBaseInfo(AppConfig.getUserId())
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(new SubscriberOnNextListener<UserBaseInfoResponse>() {
                @Override
                protected void onNext(UserBaseInfoResponse response) {
                    tvAge.setText(response.getUser_age() + "");
                    tvPhoneNumber.setText(response.getUser_phone());
                    tvUserName.setText(response.getUser_name());

                    Glide.with(UserInfoActivity.this).load(UrlConstant.IMG_ADDRESS + response.getUser_head()).into(civUserHead);

                    if (response.getUser_sex() == 1) {
                        rbMan.setChecked(true);
                    } else {
                        rbWomen.setChecked(true);
                    }

                    rbMan.setOnCheckedChangeListener((buttonView, isChecked) -> {
                        if (isChecked) {
                            changeSex(1);
                        }
                    });
                    rbWomen.setOnCheckedChangeListener((buttonView, isChecked) -> {
                        if (isChecked) {
                            changeSex(2);
                        }
                    });
                }
            }, this, true));
    }

    public void changeSex(int sex) {
        Map<String, String> request = new HashMap<>();
        request.put("sex", String.valueOf(sex));
        request.put("user_id", AppConfig.getUserId());
        mApi.changeUserInfo(request)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(new SubscriberOnNextListener<HttpResult>() {
                @Override
                protected void onNext(HttpResult result) {
                    if (200 == result.getCode()) {
                        showToast("修改成功");
                    }
                }
            }, UserInfoActivity.this, false));
    }

    @OnClick({R.id.tv_left, R.id.civ_user_head, R.id.tv_user_name, R.id.tv_age, R.id.rg_introduce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.civ_user_head:
                Dialog d = new AlertDialog.Builder(this)
                        .setTitle("修改头像")
                        .setItems(new String[]{"拍照", "从相册选择"}, (dialog, which) -> {
                            if (0 == which) {
                                takePhoto();
                            } else {
                                choosePhone();
                            }
                        })
                        .setCancelable(true)
                        .create();
                d.setCanceledOnTouchOutside(true);
                d.show();
                break;
            case R.id.tv_user_name:
                View v = LayoutInflater.from(this).inflate(R.layout.layout_edittext, null, false);
                EditText et = v.findViewById(R.id.et);
                setUserInfo("修改昵称", v, (dialog, which) -> {
                    String name = et.getText().toString();
                    if (TextUtils.isEmpty(name)) {
                        showToast("昵称不能为空！");
                        return;
                    }
                    Map<String, String> request = new HashMap<>();
                    request.put("user_id", AppConfig.getUserId());
                    request.put("name", name);
                    mApi.changeUserInfo(request)
                        .compose(RxUtils.bindToLifecycle(UserInfoActivity.this))
                        .subscribe(new ProgressSubscriber(new SubscriberOnNextListener<HttpResult>() {
                            @Override
                            protected void onNext(HttpResult result) {
                                if (result.getCode() == 200) {
                                    showToast("修改成功");

                                    initData();
                                }
                            }
                        }, UserInfoActivity.this, true));
                });
                break;
            case R.id.tv_age:
                View vi = LayoutInflater.from(this).inflate(R.layout.layout_edittext, null, false);
                EditText et1 = vi.findViewById(R.id.et);
                et1.setInputType(InputType.TYPE_CLASS_NUMBER);
                setUserInfo("修改年龄", vi, (dialog, which) -> {
                    String age = et1.getText().toString();
                    if (TextUtils.isEmpty(age)) {
                        showToast("年龄不能为空！");
                        return;
                    }

                    Map<String, String> request = new HashMap<>();
                    request.put("user_id", AppConfig.getUserId());
                    request.put("age", age);
                    mApi.changeUserInfo(request)
                        .compose(RxUtils.bindToLifecycle(UserInfoActivity.this))
                        .subscribe(new ProgressSubscriber(new SubscriberOnNextListener<HttpResult>() {
                            @Override
                            protected void onNext(HttpResult result) {
                                if (result.getCode() == 200) {
                                    showToast("修改成功");

                                    initData();
                                }
                            }
                        }, UserInfoActivity.this, true));
                });
                break;
        }
    }

    public void setUserInfo(String title, View contentView, DialogInterface.OnClickListener clickListener) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setCancelable(true)
                .setPositiveButton("确认", clickListener)
                .setView(contentView)
                .setNegativeButton("取消", (dialog, which) -> { })
                .show();
    }

    private void takePhoto() {
        // 调用系统相机拍照，并创建一张jpg文件
        imageUri = Uri.fromFile(createImageFile("user_head.jpg"));
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        new RxPermissions(this)
                .request(Manifest.permission.CAMERA)
                .subscribe(aBoolean -> {
                    startActivityForResult(intent, TAKE_PHOTO); // 启动相机程序
                });
    }

    // 创建File对象，用于存储拍照后的图片
    private File createImageFile(String fileName) {
        File outputImage = new File(Environment.getExternalStorageDirectory(), fileName);
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputImage;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                phoneTake(resultCode);
                break;
            case CROP_PHOTO:
                phoneCrop(resultCode);
                break;
            case CHOOSE_PHOTO:
                phoneChoose(resultCode, data);
                break;
            default:
                break;
        }
    }

    // 拍照的回调
    private void phoneTake(int resultCode) {
        if (resultCode == RESULT_OK) {
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(imageUri, "image/*");
            intent.putExtra("scale", true);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            startActivityForResult(intent, CROP_PHOTO); // 启动裁剪程序
        }
    }

    // 裁剪的回调
    private void phoneCrop(int resultCode) {
        if (resultCode == RESULT_OK) {
            File file = new File(imageUri.getPath());
            uploadPhoto(file);
        }
    }

    // 从相册中选择照片：
    public void choosePhone() {
        imageUri = Uri.fromFile(createImageFile("choosephone.jpg"));
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra("crop", true);
        intent.putExtra("scale", true);
        startActivityForResult(intent, CHOOSE_PHOTO);
    }

    // 从相册中选取图片，再显示
    private void phoneChoose(int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri originalUri = data.getData();
            File file = uri2File(originalUri);
            uploadPhoto(file);
        }
    }

    private File uri2File(Uri uri) {
        String img_path;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
        if (actualimagecursor == null) {
            img_path = uri.getPath();
        } else {
            int actual_image_column_index = actualimagecursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualimagecursor.moveToFirst();
            img_path = actualimagecursor
                    .getString(actual_image_column_index);
        }
        File file = new File(img_path);
        return file;
    }

    /**
     * 图片上传
     */
    public void uploadPhoto(File file) {
        Map<String, String> params = new HashMap<>();
        params.put("user_id", AppConfig.getUserId());
        OkHttpUtils.post()
                   .addFile("head", file.getName(), file)
                   .url(UrlConstant.DOMAIN + UrlConstant.CHANGE_USER_INFO)
                   .params(params)
                   .build()
                   .execute(new StringCallback() {
                       @Override
                       public void onError(Call call, Exception e, int id) {
                           LogUtils.e(e.getMessage());
                       }

                       @Override
                       public void onResponse(String response, int id) {
                           LogUtils.i(response);
                       }
                   });
    }
}
