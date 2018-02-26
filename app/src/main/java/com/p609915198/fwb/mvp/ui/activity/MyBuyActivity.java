package com.p609915198.fwb.mvp.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.MyBuyContract;
import com.p609915198.fwb.mvp.di.component.DaggerMyBuyComponent;
import com.p609915198.fwb.mvp.di.module.MyBuyModule;
import com.p609915198.fwb.mvp.presenter.MyBuyPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的购买
 * Created by Administrator on 2018/2/26.
 */
public class MyBuyActivity extends BaseActivity<MyBuyPresenter> implements MyBuyContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerMyBuyComponent
                .builder()
                .baseComponent(baseComponent)
                .myBuyModule(new MyBuyModule(this)) //请将MyBuyModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_my_buy;
    }

    @Override
    protected void initData() {
        tvCenter.setText("我的购买");
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {
        killMyself();
    }
}
