package com.p609915198.fwb.mvp.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.MySubscribeResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.MySubscribeContract;
import com.p609915198.fwb.mvp.di.component.DaggerMySubscribeComponent;
import com.p609915198.fwb.mvp.di.module.MySubscribeModule;
import com.p609915198.fwb.mvp.presenter.MySubscribePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的订阅
 * Created by Administrator on 2018/2/6.
 */
public class MySubscribeActivity extends BaseActivity<MySubscribePresenter> implements MySubscribeContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.rv) RecyclerView rv;

    @Inject Api mApi;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerMySubscribeComponent
                .builder()
                .baseComponent(baseComponent)
                .mySubscribeModule(new MySubscribeModule(this)) //请将MySubscribeModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_my_subscribe;
    }

    @Override
    protected void initData() {
        tvCenter.setText("我的订阅");
        mApi.mySubscribe(AppConfig.getUserId())
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<List<MySubscribeResponse>>() {
                        @Override
                        protected void onNext(List<MySubscribeResponse> mySubscribeResponses) {

                        }
                    },
                    this
            ));
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {
        killMyself();
    }
}
