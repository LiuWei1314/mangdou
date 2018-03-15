package com.p609915198.fwb.mvp.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.PlayListContract;
import com.p609915198.fwb.mvp.di.component.DaggerPlayListComponent;
import com.p609915198.fwb.mvp.di.module.PlayListModule;
import com.p609915198.fwb.mvp.presenter.PlayListPresenter;
import com.p609915198.fwb.mvp.ui.activity.ListDownloadActivity;
import com.p609915198.fwb.mvp.ui.adapter.PlayListAdapter;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/12/25.
 */
public class PlayListFragment extends BaseFragment<PlayListPresenter> implements PlayListContract.View {
    @BindView(R.id.tv_total_num) TextView mTvTotalNum;
    @BindView(R.id.tv_list_download) TextView mTvListDownload;
    @BindView(R.id.tv_choose) TextView mTvChoose;
    @BindView(R.id.rv) RecyclerView mRv;

    public static PlayListFragment newInstance(RoomDetailResponse response, String roomId) {
        Bundle args = new Bundle();
        args.putSerializable("data", response);
        args.putString("roomId", roomId);
        PlayListFragment fragment = new PlayListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerPlayListComponent
                .builder()
                .baseComponent(baseComponent)
                .playListModule(new PlayListModule(this)) //请将PlayListModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_play_list;
    }

    @Override
    protected void initData() {
        RoomDetailResponse data = (RoomDetailResponse) getArguments().getSerializable("data");
        String roomId = getArguments().getString("roomId", "");
        if (null != data) {
            mPresenter.initView(data, roomId);
            mPresenter.getData(data, roomId);

            mTvListDownload.setOnClickListener(view -> {
                Intent intent = new Intent(mActivity, ListDownloadActivity.class);
                intent.putExtra("roomId", roomId);
                launchActivity(intent);
            });
        }
    }

    @Override
    public Activity getActivityImpl() {
        return mActivity;
    }

    @Override
    public void setAdapter(PlayListAdapter adapter) {
        mRv.setLayoutManager(new LinearLayoutManager(mActivity));
        mRv.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST));
        mRv.setAdapter(adapter);
    }

    @Override
    public void setTotalNum(int num) {
        mTvTotalNum.setText("共" + num + "集");
    }

    @Override
    public RecyclerView getRV() {
        return mRv;
    }
}
