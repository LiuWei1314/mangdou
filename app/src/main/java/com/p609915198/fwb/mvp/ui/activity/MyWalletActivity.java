package com.p609915198.fwb.mvp.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.MyWalletContract;
import com.p609915198.fwb.mvp.di.component.DaggerMyWalletComponent;
import com.p609915198.fwb.mvp.di.module.MyWalletModule;
import com.p609915198.fwb.mvp.presenter.MyWalletPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的钱包
 * Created by Administrator on 2018/3/4.
 */
public class MyWalletActivity extends BaseActivity<MyWalletPresenter> implements MyWalletContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerMyWalletComponent
                .builder()
                .baseComponent(baseComponent)
                .myWalletModule(new MyWalletModule(this)) //请将MyWalletModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_my_wallet;
    }

    @Override
    protected void initData() {
        tvCenter.setVisibility(View.VISIBLE);
        tvCenter.setText("我的钱包");
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {killMyself();}
}
