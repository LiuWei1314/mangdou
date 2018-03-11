package com.p609915198.fwb.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.MyReceiveAwardResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.MyReceiveRewardContract;
import com.p609915198.fwb.mvp.di.component.DaggerMyReceiveRewardComponent;
import com.p609915198.fwb.mvp.di.module.MyReceiveRewardModule;
import com.p609915198.fwb.mvp.presenter.MyReceiveRewardPresenter;
import com.p609915198.fwb.mvp.ui.activity.ColumnActivity;
import com.p609915198.fwb.mvp.ui.adapter.MyReceiveRewardAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 我收到的打赏
 */
public class MyReceiveRewardFragment extends BaseFragment<MyReceiveRewardPresenter> implements MyReceiveRewardContract.View {
    @BindView(R.id.rv) RecyclerView rv;
    @Inject Api mApi;

    public static MyReceiveRewardFragment newInstance() {
        Bundle args = new Bundle();
        MyReceiveRewardFragment fragment = new MyReceiveRewardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull BaseComponent baseComponent) {
        DaggerMyReceiveRewardComponent
                .builder()
                .baseComponent(baseComponent)
                .myReceiveRewardModule(new MyReceiveRewardModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my_receive_reward;
    }

    @Override
    public void initData() {
        mApi.myReceiveAward(AppConfig.getUserId(), 0, 100)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<List<MyReceiveAwardResponse>>() {
                        @Override
                        protected void onNext(List<MyReceiveAwardResponse> responseList) {
                            MyReceiveRewardAdapter adapter = new MyReceiveRewardAdapter(responseList);
                            adapter.setOnItemClickListener((adapter1, view, position) -> {
                                Intent intent = new Intent(mActivity, ColumnActivity.class);
                                intent.putExtra("roomId", responseList.get(position).getRoom_id());
                                launchActivity(intent);
                            });
                            rv.setLayoutManager(new LinearLayoutManager(mActivity));
                            rv.setAdapter(adapter);
                        }
                    },
                    mActivity,
                    false
            ));
    }
}
