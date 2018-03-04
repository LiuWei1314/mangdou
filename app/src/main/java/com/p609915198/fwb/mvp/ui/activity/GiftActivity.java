package com.p609915198.fwb.mvp.ui.activity;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.GiftContract;
import com.p609915198.fwb.mvp.di.component.DaggerGiftComponent;
import com.p609915198.fwb.mvp.di.module.GiftModule;
import com.p609915198.fwb.mvp.presenter.GiftPresenter;

/**
 * 我的礼物
 * Created by Administrator on 2018/3/4.
 */
public class GiftActivity extends BaseActivity<GiftPresenter> implements GiftContract.View {

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerGiftComponent
                .builder()
                .baseComponent(baseComponent)
                .giftModule(new GiftModule(this)) //请将GiftModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_gift;
    }

    @Override
    protected void initData() {

    }
}
