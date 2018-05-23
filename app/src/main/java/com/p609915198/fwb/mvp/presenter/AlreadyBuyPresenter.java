package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.AlreadyBuyResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.AlreadyBuyContract;
import com.p609915198.fwb.mvp.ui.activity.ColumnActivity;
import com.p609915198.fwb.mvp.ui.adapter.AlreadyBuyAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/14.
 */
@ActivityScope
public class AlreadyBuyPresenter extends BasePresenter<AlreadyBuyContract.Model, AlreadyBuyContract.View> {
    @Inject Api mApi;

    private AlreadyBuyAdapter mAlreadyBuyAdapter;

    @Inject
    public AlreadyBuyPresenter(AlreadyBuyContract.Model model, AlreadyBuyContract.View rootView,
                               AlreadyBuyAdapter adapter) {
        super(model, rootView);
        this.mAlreadyBuyAdapter = adapter;
    }

    public void initData() {
        mApi.alreadyBuy(AppConfig.getUserId(), 0, 100)
            .compose(RxUtils.bindToLifecycle(mRootView))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<List<AlreadyBuyResponse>>() {
                        @Override
                        protected void onNext(List<AlreadyBuyResponse> alreadyBuyResponses) {
                            if (alreadyBuyResponses.isEmpty()) {
                                mRootView.showToast("暂无购买记录!");
                            } else {
                                mAlreadyBuyAdapter.setOnItemChildClickListener((adapter, view, position) -> {
                                    switch (view.getId()) {
                                        case R.id.tv_share:
                                            ToastUtils.showShort("分享");
                                            break;
                                        case R.id.tv_comments:
                                            ToastUtils.showShort("评论");
                                            break;
                                    }
                                });
                                mAlreadyBuyAdapter.setOnItemClickListener((adapter, view, position) -> {
                                    Intent intent = new Intent(mRootView.getActivity(), ColumnActivity.class);
                                    intent.putExtra("roomId", alreadyBuyResponses.get(position).getRoom_id());
                                    mRootView.launchActivity(intent);
                                });
                                mAlreadyBuyAdapter.replaceData(alreadyBuyResponses);
                            }
                        }
                    },
                    mRootView.getActivity(), false
            ));
    }
}
