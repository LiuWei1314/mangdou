package com.p609915198.fwb.mvp.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.basemodule.net.response.UserBaseInfoResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.ListBuyContract;
import com.p609915198.fwb.mvp.di.component.DaggerListBuyComponent;
import com.p609915198.fwb.mvp.di.module.ListBuyModule;
import com.p609915198.fwb.mvp.presenter.ListBuyPresenter;
import com.p609915198.fwb.mvp.ui.adapter.ListDownloadAdapter1;
import com.p609915198.fwb.mvp.ui.adapter.ListDownloadAdapter2;
import com.p609915198.fwb.utils.DoubleUtils;
import com.p609915198.fwb.utils.PayUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;


public class ListBuyActivity extends BaseActivity<ListBuyPresenter> implements ListBuyContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.tv_total_num) TextView mTvTotalNum;
    @BindView(R.id.tv_choose) TextView mTvChoose;
    @BindView(R.id.rv_1) RecyclerView mRv1;
    @BindView(R.id.rv_2) RecyclerView mRv2;
    @BindView(R.id.tv_money_hint) TextView mTvMoneyHint;
    @BindView(R.id.tv_money) TextView mTvMoney;
    @BindView(R.id.tv_selected) TextView mTvSelected;
    @BindView(R.id.tv_buy_all) TextView mTvBuyAll;
    @BindView(R.id.tv_buy) TextView mTvBuy;

    private ListDownloadAdapter1 mAdapter1;
    private ListDownloadAdapter2 mAdapter2;
    private String roomId;
    private RoomDetailResponse data;

    @Inject Api mApi;

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerListBuyComponent
                .builder()
                .baseComponent(baseComponent)
                .listBuyModule(new ListBuyModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_list_buy;
    }

    @Override
    public void initData() {
        mTvCenter.setText("批量购买");
        mTvCenter.setVisibility(View.VISIBLE);

        roomId = getIntent().getStringExtra("roomId");
        data = (RoomDetailResponse) getIntent().getSerializableExtra("data");
        if (!TextUtils.isEmpty(roomId)) {
            getTotalPage();

            getData(0, 20, roomId);
        }
    }

    public void getTotalPage() {
        mApi.audioList(0, 20, roomId, AppConfig.getUserId())
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<List<Audio>>() {
                        @Override
                        protected void onNext(List<Audio> audioRespons) {
                            if (!audioRespons.isEmpty()) {
                                int totalCount = audioRespons.get(0).getAudio_sum();
                                mTvTotalNum.setText("共" + totalCount + "集");

                                List<String> data = new ArrayList<>();
                                int totalPage = totalCount % 20 == 0 ? totalCount / 20 : totalCount / 20 + 1;
                                for (int i = 0; i < totalPage; i++) {
                                    int start = i * 20 + 1;
                                    int end = (i + 1) * 20 > totalCount ? totalCount : (i + 1) * 20;
                                    data.add(start + "~" + end);
                                }
                                mAdapter1 = new ListDownloadAdapter1(data, totalCount);
                                mAdapter1.setCallBack(position -> {
                                    mTvChoose.setText("选集(" + data.get(position) + ")");
                                    getData(position, 20, roomId);
                                });
                                mRv1.setLayoutManager(new GridLayoutManager(ListBuyActivity.this, 4));
                                mRv1.setAdapter(mAdapter1);
                            }
                        }
                    },
                    this,
                    false
            ));
    }

    public void getData(int page, int pageSize, String roomId) {
        mApi.audioList(page, pageSize, roomId, AppConfig.getUserId())
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<List<Audio>>() {
                        @Override
                        protected void onNext(List<Audio> audioRespons) {
                            if (!audioRespons.isEmpty()) {
                                mAdapter2 = new ListDownloadAdapter2(audioRespons);
                                mAdapter2.setCheckListner(() -> changeViews());
                                mRv2.setLayoutManager(new LinearLayoutManager(ListBuyActivity.this));
                                mRv2.addItemDecoration(new DividerItemDecoration(ListBuyActivity.this, DividerItemDecoration.VERTICAL_LIST));
                                mRv2.setAdapter(mAdapter2);

                                mRv1.setVisibility(View.GONE);
                            }
                        }
                    },
                    this,
                    true
            ));
    }

    @OnClick({R.id.tv_left, R.id.tv_buy, R.id.tv_buy_all, R.id.tv_choose})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.tv_buy:
                buy();
                break;
            case R.id.tv_buy_all:
                buyAll();
                break;
            case R.id.tv_choose:
                if (mRv1.getVisibility() == View.GONE) {
                    mRv1.setVisibility(View.VISIBLE);
                } else {
                    mRv1.setVisibility(View.GONE);
                }
                break;
        }
    }

    public void changeViews() {
        List<Boolean> list = mAdapter2.getCheck();
        int checked = 0;
        double money = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)) {
                Audio audio = mAdapter2.getData().get(i);
                money += Double.valueOf(audio.getPrice());
                checked++;
            }
        }
        mTvMoney.setText(DoubleUtils.round(money) + "忙豆");
        mTvSelected.setText("已选" + checked + "集");
    }

    public void buy() {
        if (AppConfig.isLogin()) {
            mApi.userBaseInfo(AppConfig.getUserId())
                .compose(RxUtils.bindToLifecycle(this))
                .subscribe(new ProgressSubscriber(new SubscriberOnNextListener<UserBaseInfoResponse>() {
                    @Override
                    protected void onNext(UserBaseInfoResponse response) {
                        double volley = Double.valueOf(response.getUser_volley());// 余额
                        List<Boolean> list = mAdapter2.getCheck();
                        int money = 0;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i)) {
                                Audio audio = mAdapter2.getData().get(i);
                                money += Double.valueOf(audio.getPrice());
                            }
                        }
                        if (money == 0) {
                            // 如果算出来的价格为0就说明所选集数之和是免费的
                            ToastUtils.showShort("购买成功!");
                            killMyself();
                        } else {
                            if (volley >= money) {
                                PayUtil.buy(ListBuyActivity.this, mApi, getSupportFragmentManager(), DoubleUtils.round_d(money));
                            } else {
                                Intent intent = new Intent(ListBuyActivity.this, RechargeActivity.class);
                                intent.putExtra("money", money - volley);
                                launchActivity(intent);
                            }
                        }
                    }
                }, this));
        } else {
            showToast("请先登录！");
        }
    }

    public void buyAll() {
        if (AppConfig.isLogin()) {
            mApi.userBaseInfo(AppConfig.getUserId())
                .compose(RxUtils.bindToLifecycle(this))
                .subscribe(new ProgressSubscriber(new SubscriberOnNextListener<UserBaseInfoResponse>() {
                    @Override
                    protected void onNext(UserBaseInfoResponse response) {
                        double volley = Double.valueOf(response.getUser_volley());// 余额
                        double money = Double.valueOf(data.getRoom_price());// 价格
                        if (volley >= money) {
                            PayUtil.buy(ListBuyActivity.this, mApi, getSupportFragmentManager(), DoubleUtils.round_d(money));
                        } else {
                            Intent intent = new Intent(ListBuyActivity.this, RechargeActivity.class);
                            intent.putExtra("money", money - volley);
                            launchActivity(intent);
                        }
                    }
                }, this));
        } else {
            showToast("请先登录！");
        }
    }
}