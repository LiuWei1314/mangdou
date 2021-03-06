package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.MangdouWxLoginResult;
import com.p609915198.basemodule.net.response.WXLoginResult;
import com.p609915198.basemodule.net.response.WXUserInfoResult;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.MyApplication;
import com.p609915198.fwb.app.events.LoginEvent;
import com.p609915198.fwb.app.events.WXLoginEvent;
import com.p609915198.fwb.mvp.contract.LoginContract;
import com.p609915198.fwb.mvp.di.component.DaggerLoginComponent;
import com.p609915198.fwb.mvp.di.module.LoginModule;
import com.p609915198.fwb.mvp.presenter.LoginPresenter;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

import static com.p609915198.basemodule.net.UrlConstant.DOWNLOAD_IMG_ADDRESS;

/**
 * Created by mark.liu on 2017-9-12.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.et_phone_num) EditText etPhoneNum;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.bt_login) Button btLogin;
    @BindView(R.id.tv_forget_password) TextView tvForgetPassword;

    @Inject Api mApi;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerLoginComponent
                .builder()
                .baseComponent(baseComponent)
                .loginModule(new LoginModule(this)) //请将LoginModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        tvCenter.setText("帐号密码登录");
        tvCenter.setVisibility(View.VISIBLE);
        tvRight.setText("注册");
        tvRight.setTextSize(16);
        tvRight.setTextColor(getResources().getColor(R.color.main_text_selected));
        tvRight.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.tv_left, R.id.tv_right, R.id.bt_login, R.id.tv_forget_password, R.id.iv_wechat_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.tv_right:
                launchActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.bt_login:
                String username = etPhoneNum.getText().toString();
                String password = etPassword.getText().toString();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    showToast("帐号或密码不能为空！");
                    return;
                }
                mPresenter.login(username, password);
                break;
            case R.id.tv_forget_password:
                launchActivity(new Intent(this, ForgetPasswordActivity.class));
                break;
            case R.id.iv_wechat_login:
                final SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "wechat_sdk_demo_test";
                MyApplication.getIWXAPI().sendReq(req);
                break;
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Intent getIntentImpl() {
        return getIntent();
    }

    @Override
    protected boolean useEventBus() {
        return true;
    }

    @Subscribe
    public void wxLogin(WXLoginEvent event) {
        mApi.wxLogin(event.code)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<WXLoginResult>() {
                        @Override
                        protected void onNext(WXLoginResult wxLoginResult) {
                            LogUtils.i(wxLoginResult);

                            if (TextUtils.isEmpty(wxLoginResult.getErrcode())) {
                                // 登录成功
                                getUserInfo(wxLoginResult.getAccess_token(), wxLoginResult.getOpenid());
                            } else {
                                ToastUtils.showShort("登录失败!");
                            }
                        }
                    },
                    this
            ));
    }

    public void getUserInfo(String accessToken, String openId) {
        mApi.wxUserInfo(accessToken, openId)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<WXUserInfoResult>() {
                        @Override
                        protected void onNext(WXUserInfoResult wxUserInfoResult) {
                            mangdouLogin(wxUserInfoResult.getOpenid(), wxUserInfoResult.getNickname(),
                                         wxUserInfoResult.getSex(), wxUserInfoResult.getHeadimgurl());
                        }
                    }
                    , this
            ));
    }

    public void mangdouLogin(String openId, String name, int sex, String headImgUrl) {
        OkHttpUtils.get().url(headImgUrl).build()
                   .execute(new FileCallBack(DOWNLOAD_IMG_ADDRESS, name + openId + ".png") {
                       @Override
                       public void onError(Call call, Exception e, int id) {

                       }

                       @Override
                       public void onResponse(File file, int id) {
                           Map<String, String> params = new HashMap<>();
                           params.put("wechat", openId);
                           params.put("name", name);
                           params.put("sex", String.valueOf(sex));
                           OkHttpUtils.post()
                                      .addFile("file", file.getName(), file)
                                      .url(UrlConstant.DOMAIN + UrlConstant.WX_LOGIN)
                                      .params(params)
                                      .build()
                                      .execute(new StringCallback() {
                                          @Override
                                          public void onError(Call call, Exception e, int id) {
                                              LogUtils.e(e.getMessage());
                                          }

                                          @Override
                                          public void onResponse(String response, int id) {
                                              MangdouWxLoginResult result = JSON.parseObject(response, MangdouWxLoginResult.class);

                                              showToast("登录成功！");
                                              AppConfig.setUserId(result.getResult().getUserid());
                                              EventBus.getDefault().post(new LoginEvent());
                                              killMyself();
                                          }
                                      });
                       }
                   });
    }
}
