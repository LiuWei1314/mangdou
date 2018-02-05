package com.p609915198.fwb.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.ChargeResponse;
import com.p609915198.basemodule.widget.autolayout.AutoTabLayout;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.aliPay.OrderInfoUtil2_0;
import com.p609915198.fwb.app.aliPay.PayResult;
import com.p609915198.fwb.mvp.contract.HomePageContract;
import com.p609915198.fwb.mvp.di.component.DaggerHomePageComponent;
import com.p609915198.fwb.mvp.di.module.HomePageModule;
import com.p609915198.fwb.mvp.presenter.HomePagePresenter;
import com.p609915198.fwb.mvp.ui.activity.PlayRecordActivity;
import com.p609915198.fwb.mvp.ui.activity.SearchActivity;
import com.p609915198.fwb.mvp.ui.adapter.TabPageIndicatorAdapter;

import java.util.Map;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mark.liu on 2017-9-12.
 * 主页
 */
public class HomePageFragment extends BaseFragment<HomePagePresenter> implements HomePageContract.View {
    @BindView(R.id.view_pager) ViewPager mViewPager;
    @BindView(R.id.tab_layout) AutoTabLayout mTabLayout;
    @BindView(R.id.tv_search) TextView mTvSearch;
    @BindView(R.id.iv_time) ImageView mIvTime;
    @BindView(R.id.iv_download) ImageView mIvDownload;

    @BindColor(R.color.main_text_selected) int textSelectColor;
    @BindColor(R.color.main_text) int textColor;

    private static final int SDK_PAY_FLAG = 1001;

    public static HomePageFragment newInstance() {
        Bundle args = new Bundle();
        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerHomePageComponent
                .builder()
                .baseComponent(baseComponent)
                .homePageModule(new HomePageModule(this)) //请将HomePageModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initData() {
        mPresenter.initViewPager(mActivity.getSupportFragmentManager());
    }

    @Override
    public void setFragmentPagerAdapter(TabPageIndicatorAdapter adapter) {
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);
        mPresenter.reflex(mTabLayout);
    }

    @OnClick({R.id.iv_time, R.id.iv_download, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_time:
                if (AppConfig.isLogin()) {
                    launchActivity(new Intent(mActivity, PlayRecordActivity.class));
                } else {
                    ToastUtils.showShort("请先登录！");
                }
                break;
            case R.id.iv_download:
                ToastUtils.showShort("下载");

                test();
                break;
            case R.id.tv_search:
                launchActivity(new Intent(mActivity, SearchActivity.class));
                break;
        }
    }

    @Inject Api mApi;

    public void test() {
        mApi.topupNew("{user_id=10,valley=0.01}")
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<ChargeResponse>() {
                        @Override
                        protected void onNext(ChargeResponse response) {
                            boolean rsa2 = false;
                            Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(0.01, response.getDanhao(),
                                                                                             "12", "asdf");
                            String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
                            String privateKey = AppConfig.ALI_RSA_PRI_KEY;
                            String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
                            final String orderInfo = orderParam + "&" + sign;
                            //异步处理
                            Runnable payRunnable = () -> {
                                //新建任务
                                PayTask alipay = new PayTask(mActivity);
                                //获取支付结果
                                Map<String, String> result = alipay.payV2(orderInfo, true);
                                Message msg = new Message();
                                msg.what = SDK_PAY_FLAG;
                                msg.obj = result;
                                mHandler.sendMessage(msg);
                            };
                            // 必须异步调用
                            Thread payThread = new Thread(payRunnable);
                            payThread.start();
                        }
                    },
                    mActivity, false
            ));
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(mActivity, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(mActivity, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
            }
        }
    };
}
