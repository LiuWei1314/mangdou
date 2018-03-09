package com.p609915198.fwb.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.MyAwardResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.MyRewardContract;
import com.p609915198.fwb.mvp.di.component.DaggerMyRewardComponent;
import com.p609915198.fwb.mvp.di.module.MyRewardModule;
import com.p609915198.fwb.mvp.presenter.MyRewardPresenter;
import com.p609915198.fwb.mvp.ui.activity.ColumnActivity;
import com.p609915198.fwb.mvp.ui.adapter.MyRewardAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 我的打赏
 */
public class MyRewardFragment extends BaseFragment<MyRewardPresenter> implements MyRewardContract.View {
    @BindView(R.id.rv) RecyclerView rv;
    @Inject Api mApi;

    public static MyRewardFragment newInstance() {
        Bundle args = new Bundle();
        MyRewardFragment fragment = new MyRewardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull BaseComponent appComponent) {
        DaggerMyRewardComponent
                .builder()
                .baseComponent(appComponent)
                .myRewardModule(new MyRewardModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my_reward;
    }

    @Override
    public void initData() {
        mApi.myAward(AppConfig.getUserId(), 0, 100)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(new SubscriberOnNextListener<List<MyAwardResponse>>() {
                @Override
                protected void onNext(List<MyAwardResponse> myAwardResponses) {
                    MyRewardAdapter adapter = new MyRewardAdapter(myAwardResponses);
                    adapter.setOnItemClickListener((adapter1, view, position) -> {
                        Intent intent = new Intent(mActivity, ColumnActivity.class);
                        intent.putExtra("roomId", myAwardResponses.get(position).getRoom_id());
                        launchActivity(intent);
                    });
                    rv.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL));
                    rv.setLayoutManager(new LinearLayoutManager(mActivity));
                    rv.setAdapter(adapter);
                }
            }, mActivity, false));
    }
}
