package com.p609915198.fwb.mvp.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.UserBaseInfoResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.events.PayEvent;
import com.p609915198.fwb.mvp.contract.MyWalletContract;
import com.p609915198.fwb.mvp.di.component.DaggerMyWalletComponent;
import com.p609915198.fwb.mvp.di.module.MyWalletModule;
import com.p609915198.fwb.mvp.presenter.MyWalletPresenter;
import com.p609915198.fwb.utils.PayUtil;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

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
    @BindView(R.id.tv_money) TextView tvMoney;
    @BindView(R.id.tv_charge) TextView tvCharge;
    @BindView(R.id.tv_charge_record) TextView tvChargeRecord;
    @BindView(R.id.tv_consume_record) TextView tvConsumeRecord;
    @BindView(R.id.et_charge) EditText etCharge;

    @Inject Api mApi;

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

        getData();
    }

    public void getData() {
        mApi.userBaseInfo(AppConfig.getUserId())
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<UserBaseInfoResponse>() {
                        @Override
                        protected void onNext(UserBaseInfoResponse response) {
                            tvMoney.setText("可用余额：" + response.getUser_volley() + "忙豆");
                        }
                    }, this
            ));
    }

    @OnClick({R.id.tv_left, R.id.tv_charge, R.id.tv_charge_record, R.id.tv_consume_record})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.tv_charge:
                String text = etCharge.getText().toString();
                if (TextUtils.isEmpty(text) || Double.valueOf(text) == 0) {
                    showToast("您的金额输入有误！");
                    return;
                }
                PayUtil.buy(this, mApi, getSupportFragmentManager(), Double.valueOf(text));
                break;
            case R.id.tv_charge_record:
                launchActivity(new Intent(this, ChargeFlowActivity.class));
                break;
            case R.id.tv_consume_record:
                launchActivity(new Intent(this, ExpenseActivity.class));
                break;
        }
    }

    @Override
    protected boolean useEventBus() {
        return true;
    }

    @Subscribe
    public void paySuccess(PayEvent event) {
        getData();
    }
}
