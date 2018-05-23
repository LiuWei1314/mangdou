package com.p609915198.fwb.mvp.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ApiException;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.response.AdResponse;
import com.p609915198.basemodule.net.response.RoomsMoreResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.entity.local.AdHolderView;
import com.p609915198.fwb.mvp.contract.RechargeContract;
import com.p609915198.fwb.mvp.di.component.DaggerRechargeComponent;
import com.p609915198.fwb.mvp.di.module.RechargeModule;
import com.p609915198.fwb.mvp.presenter.RechargePresenter;
import com.p609915198.fwb.mvp.ui.adapter.RechargeAdapter;
import com.p609915198.fwb.utils.PayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Function;

/**
 * 充值界面
 */
public class RechargeActivity extends BaseActivity<RechargePresenter> implements RechargeContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.tv_money) TextView mTvMoney;
    @BindView(R.id.rv) RecyclerView mRv;
    @BindView(R.id.ad_header) ConvenientBanner mAdHeader;

    @Inject Api mApi;

    private double money;
    private RechargeAdapter mAdapter;
    private List<Integer> data = Arrays.asList(6, 18, 50, 118, 218, 488, 618, 998);

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerRechargeComponent
                .builder()
                .baseComponent(baseComponent)
                .rechargeModule(new RechargeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_recharge;
    }

    @Override
    public void initData() {
        mTvCenter.setText("忙豆充值");
        mTvCenter.setVisibility(View.VISIBLE);

        money = getIntent().getDoubleExtra("money", 0);
        if (0 != money) {
            mTvMoney.setText("当前余额不足，还差" + money + "忙豆");
        }

        init("19");// 加载广告

        mAdapter = new RechargeAdapter(data);
        mAdapter.setOnItemClickListener((adapter, view, position) -> PayUtil.buy(this, mApi, getSupportFragmentManager(), Double.valueOf(data.get(position))));
        mRv.setLayoutManager(new GridLayoutManager(this, 2));
        mRv.setAdapter(mAdapter);
    }

    public void init(String labelId) {
        mApi.roomsMore(labelId)
            .compose(RxUtils.bindToLifecycle(this))
            .map((Function<HttpResult<List<RoomsMoreResponse>>, List<RoomsMoreResponse>>) listHttpResult -> {
                if (listHttpResult.getCode() != 200) {
                    throw new ApiException(listHttpResult.getMsg());
                }
                if (null != listHttpResult.getAd() && !TextUtils.isEmpty(listHttpResult.getAd().getSelf_ad())) {
                    setAdHeaderView(listHttpResult.getAd());
                }
                return listHttpResult.getResult();
            })
            .subscribe();
    }

    public void setAdHeaderView(AdResponse adData) {
        List<AdResponse> data = new ArrayList<>();
        data.add(adData);
        mAdHeader.setPages(() -> new AdHolderView(), data)
                 .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                 .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                 .setOnItemClickListener(position -> {
                     // TODO: 2017-9-22
                 });
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
        }
    }
}
