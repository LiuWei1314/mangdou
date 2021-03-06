package com.p609915198.fwb.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.MySubscribeResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.ListenContract;
import com.p609915198.fwb.mvp.di.component.DaggerListenComponent;
import com.p609915198.fwb.mvp.di.module.ListenModule;
import com.p609915198.fwb.mvp.presenter.ListenPresenter;
import com.p609915198.fwb.mvp.ui.activity.AlreadyBuyActivity;
import com.p609915198.fwb.mvp.ui.activity.ColumnActivity;
import com.p609915198.fwb.mvp.ui.activity.HistoryActivity;
import com.p609915198.fwb.mvp.ui.activity.MyDownloadActivity;
import com.p609915198.fwb.mvp.ui.adapter.MySubscribeAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mark.liu on 2017-9-12.
 * 我听
 */
public class ListenFragment extends BaseFragment<ListenPresenter> implements ListenContract.View {
    @BindView(R.id.tv_download_size) TextView tvDownloadSize;
    @BindView(R.id.tv_history_size) TextView tvHistorySize;
    @BindView(R.id.tv_buy_size) TextView tvBuySize;
    @BindView(R.id.rv) RecyclerView rv;

    @Inject Api mApi;

    private List<MySubscribeResponse> data = new ArrayList<>();
    private MySubscribeAdapter mAdapter;

    public static ListenFragment newInstance() {
        Bundle args = new Bundle();
        ListenFragment fragment = new ListenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerListenComponent
                .builder()
                .baseComponent(baseComponent)
                .listenModule(new ListenModule(this)) //请将ListenModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_listen;
    }

    @Override
    protected void initData() {
        mAdapter = new MySubscribeAdapter(data);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(mActivity, ColumnActivity.class);
            intent.putExtra("roomId", data.get(position).getRoom_id());
            launchActivity(intent);
        });
        rv.setLayoutManager(new LinearLayoutManager(mActivity));
        rv.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST));
        rv.setAdapter(mAdapter);

        getData();
    }

    public void getData() {
        mApi.mySubscribe(AppConfig.getUserId(), 0, 100)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<List<MySubscribeResponse>>() {
                        @Override
                        protected void onNext(List<MySubscribeResponse> mySubscribeResponses) {
                            data.clear();
                            data.addAll(mySubscribeResponses);
                            mAdapter.notifyDataSetChanged();
                        }
                    },
                    mActivity, false
            ));
    }

    @OnClick({R.id.ll_download_size, R.id.ll_history_size, R.id.ll_buy_size})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_download_size:
                launchActivity(new Intent(mActivity, MyDownloadActivity.class));
                break;
            case R.id.ll_history_size:
                if (!AppConfig.isLogin()) {
                    showToast("请先登录！");
                    return;
                }
                launchActivity(new Intent(mActivity, HistoryActivity.class));
                break;
            case R.id.ll_buy_size:
                if (!AppConfig.isLogin()) {
                    showToast("请先登录！");
                    return;
                }
                launchActivity(new Intent(mActivity, AlreadyBuyActivity.class));
                break;
        }
    }
}
