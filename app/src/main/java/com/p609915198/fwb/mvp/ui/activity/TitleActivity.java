package com.p609915198.fwb.mvp.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.TopResponse;
import com.p609915198.basemodule.net.response.UserBaseInfoResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.basemodule.widget.CircleImageView;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.TitleContract;
import com.p609915198.fwb.mvp.di.component.DaggerTitleComponent;
import com.p609915198.fwb.mvp.di.module.TitleModule;
import com.p609915198.fwb.mvp.presenter.TitlePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 称号
 * Created by Administrator on 2018/3/4.
 */
public class TitleActivity extends BaseActivity<TitlePresenter> implements TitleContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.civ_head) CircleImageView civHead;
    @BindView(R.id.tv_name) TextView tvName;
    @BindView(R.id.ll_login) LinearLayout llLogin;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    @Inject Api mApi;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerTitleComponent
                .builder()
                .baseComponent(baseComponent)
                .titleModule(new TitleModule(this)) //请将TitleModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_title;
    }

    @Override
    protected void initData() {
        tvCenter.setText("巅峰称号");
        tvCenter.setVisibility(View.VISIBLE);

        mApi.userBaseInfo(AppConfig.getUserId())
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<UserBaseInfoResponse>() {
                        @Override
                        protected void onNext(UserBaseInfoResponse response) {
                            Glide.with(TitleActivity.this).load(UrlConstant.IMG_ADDRESS + response.getUser_head()).into(civHead);
                            tvName.setText(TextUtils.isEmpty(response.getUser_name()) ? "" : response.getUser_name());
                        }
                    },
                    this,
                    false
            ));

        mApi.top(AppConfig.getUserId())
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<TopResponse>() {
                        @Override
                        protected void onNext(TopResponse response) {
                            if (response.isStatus()) {
                                progressBar.setProgress(response.getData().getPercent());
                            }
                        }
                    },
                    this,
                    false
            ));
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {killMyself();}
}
