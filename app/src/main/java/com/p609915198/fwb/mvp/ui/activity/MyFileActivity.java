package com.p609915198.fwb.mvp.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.MyFileContract;
import com.p609915198.fwb.mvp.di.component.DaggerMyFileComponent;
import com.p609915198.fwb.mvp.di.module.MyFileModule;
import com.p609915198.fwb.mvp.presenter.MyFilePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 个人资料
 * Created by Administrator on 2017/11/2.
 */
public class MyFileActivity extends BaseActivity<MyFilePresenter> implements MyFileContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.iv_heard) ImageView mIvHeard;
    @BindView(R.id.et_name) EditText mEtName;
    @BindView(R.id.et_introduce) EditText mEtIntroduce;
    @BindView(R.id.et_sex) EditText mEtSex;
    @BindView(R.id.et_birthday) EditText mEtBirthday;
    @BindView(R.id.et_place) EditText mEtPlace;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerMyFileComponent
                .builder()
                .baseComponent(baseComponent)
                .myFileModule(new MyFileModule(this)) //请将MyFileModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_my_file;
    }

    @Override
    protected void initData() {
        mTvCenter.setText("个人资料");
    }

    @OnClick({R.id.tv_left, R.id.et_name, R.id.et_introduce, R.id.et_sex, R.id.et_birthday, R.id.et_place})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.et_name:
                break;
            case R.id.et_introduce:
                break;
            case R.id.et_sex:
                break;
            case R.id.et_birthday:
                break;
            case R.id.et_place:
                break;
        }
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        ActivityUtils.startActivity(this, intent);
    }

    @Override
    public void killMyself() {
        finish();
    }
}
