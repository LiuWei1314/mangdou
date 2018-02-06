package com.p609915198.fwb.mvp.ui.activity;

import android.support.annotation.NonNull;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.di.component.DaggerMySubscribeComponent;
import com.p609915198.fwb.mvp.di.module.MySubscribeModule;
import com.p609915198.fwb.mvp.contract.MySubscribeContract;
import com.p609915198.fwb.mvp.presenter.MySubscribePresenter;

/**
 * 订阅
 * Created by Administrator on 2018/2/6.
 */
public class MySubscribeActivity extends BaseActivity<MySubscribePresenter> implements MySubscribeContract.View {

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerMySubscribeComponent
                .builder()
                .baseComponent(baseComponent)
                .MySubscribeModule(new MySubscribeModule(this)) //请将MySubscribeModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.id;
    }

    @Override
    protected void initData() {

    }
}
