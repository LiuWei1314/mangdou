package com.p609915198.fwb.mvp.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.UserBaseInfoResponse;
import com.p609915198.basemodule.widget.CircleImageView;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.events.LoginEvent;
import com.p609915198.fwb.mvp.contract.MineContract;
import com.p609915198.fwb.mvp.di.component.DaggerMineComponent;
import com.p609915198.fwb.mvp.di.module.MineModule;
import com.p609915198.fwb.mvp.presenter.MinePresenter;
import com.p609915198.fwb.mvp.ui.activity.FeedBackActivity;
import com.p609915198.fwb.mvp.ui.activity.GeneralSettingsActivity;
import com.p609915198.fwb.mvp.ui.activity.GiftActivity;
import com.p609915198.fwb.mvp.ui.activity.HistoryActivity;
import com.p609915198.fwb.mvp.ui.activity.LoginActivity;
import com.p609915198.fwb.mvp.ui.activity.MyDownloadActivity;
import com.p609915198.fwb.mvp.ui.activity.MySubscribeActivity;
import com.p609915198.fwb.mvp.ui.activity.MyWalletActivity;
import com.p609915198.fwb.mvp.ui.activity.RewardActivity;
import com.p609915198.fwb.mvp.ui.activity.TitleActivity;
import com.p609915198.fwb.mvp.ui.dialog.PhoneDialog;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mark.liu on 2017-9-12.
 * 我的
 */
public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.View {
    @BindView(R.id.civ_head) CircleImageView mCivHead;
    @BindView(R.id.tv_name) TextView mTvName;
    @BindView(R.id.iv_vip) ImageView mIvVip;
    @BindView(R.id.iv_title) ImageView mIvTitle;
    @BindView(R.id.tv_care) TextView mTvCare;
    @BindView(R.id.tv_fans) TextView mTvFans;
    @BindView(R.id.tv_history) TextView mTvHistory;
    @BindView(R.id.tv_subscribe) TextView mTvSubscribe;
    @BindView(R.id.tv_download) TextView mTvDownload;
    @BindView(R.id.ll_login) LinearLayout llLogin;
    @BindView(R.id.tv_3) TextView tv3;
    @BindView(R.id.tv_5) TextView tv5;
    @BindView(R.id.tv_6_1) TextView tv61;
    @BindView(R.id.tv_6_2) TextView tv62;
    @BindView(R.id.tv_7) TextView tv7;
    @BindView(R.id.tv_8) TextView tv8;
    @BindView(R.id.tv_9) TextView tv9;

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerMineComponent
                .builder()
                .baseComponent(baseComponent)
                .mineModule(new MineModule(this)) //请将MineModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData() {
        if (AppConfig.isLogin()) {
            mPresenter.initUserInfo();
        } else {
            mCivHead.setImageResource(R.mipmap.ic_head);
            mTvName.setText("未登录");
        }
    }

    @OnClick({R.id.ll_login})
    public void loginClicked(View view) {
        if (!AppConfig.isLogin()) {
            launchActivity(new Intent(mActivity, LoginActivity.class));
        }
    }

    @OnClick({R.id.tv_subscribe, R.id.tv_history, R.id.tv_download})
    public void mySubscribe(View view) {
        switch (view.getId()) {
            case R.id.tv_subscribe:
                if (!AppConfig.isLogin()) {
                    showToast("请先登录！");
                    return;
                }
                launchActivity(new Intent(mActivity, MySubscribeActivity.class));
                break;
            case R.id.tv_history:
                if (!AppConfig.isLogin()) {
                    showToast("请先登录！");
                    return;
                }
                launchActivity(new Intent(mActivity, HistoryActivity.class));
                break;
            case R.id.tv_download:
                launchActivity(new Intent(mActivity, MyDownloadActivity.class));
                break;
        }
    }

    @OnClick({R.id.tv_3, R.id.tv_5, R.id.tv_6_1, R.id.tv_6_2, R.id.tv_7, R.id.tv_8, R.id.tv_history})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.tv_7) {
            new PhoneDialog(mActivity).show();
            return;
        }

        if (!AppConfig.isLogin()) {
            showToast("请先登录！");
            return;
        }
        switch (view.getId()) {
            case R.id.tv_3:
                launchActivity(new Intent(mActivity, TitleActivity.class));
                break;
//            case R.id.tv_4:
//                launchActivity(new Intent(mActivity, AlreadyBuyActivity.class));
//                break;
            case R.id.tv_5:
                launchActivity(new Intent(mActivity, MyWalletActivity.class));
                break;
            case R.id.tv_6_1:
                launchActivity(new Intent(mActivity, GiftActivity.class));
                break;
            case R.id.tv_6_2:
                launchActivity(new Intent(mActivity, RewardActivity.class));
                break;
            case R.id.tv_8:
                launchActivity(new Intent(mActivity, FeedBackActivity.class));
                break;
        }
    }

    @Override
    protected boolean useEventBus() {
        return true;
    }

    @Subscribe
    public void login(LoginEvent loginEvent) {
        initData();
    }

    @OnClick(R.id.tv_9)
    public void setClick(View view) {
        launchActivity(new Intent(mActivity, GeneralSettingsActivity.class));
    }

    @Override
    public Activity getActivityImpl() {
        return mActivity;
    }

    @Override
    public void showUserInfo(UserBaseInfoResponse response) {
        Glide.with(this).load(UrlConstant.IMG_ADDRESS + response.getUser_head()).into(mCivHead);
        mTvName.setText(TextUtils.isEmpty(response.getUser_name()) ? "" : response.getUser_name());
    }
}
