package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.basemodule.widget.CircleImageView;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.RoomDetailContract;
import com.p609915198.fwb.mvp.di.component.DaggerRoomDetailComponent;
import com.p609915198.fwb.mvp.di.module.RoomDetailModule;
import com.p609915198.fwb.mvp.presenter.RoomDetailPresenter;
import com.p609915198.fwb.mvp.ui.adapter.RoomDetailAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作品详情
 * Created by Administrator on 2017/12/25.
 */
public class RoomDetailFragment extends BaseFragment<RoomDetailPresenter> implements RoomDetailContract.View {
    @BindView(R.id.tv_introduce) TextView mTvIntroduce;
    @BindView(R.id.civ_head) CircleImageView mCivHead;
    @BindView(R.id.tv_name) TextView mTvName;
    @BindView(R.id.tv_subscribe_hint) TextView mTvSubscribeHint;
    @BindView(R.id.tv_subscribe) TextView mTvSubscribe;
    @BindView(R.id.tv_common) TextView mTvCommon;
    @BindView(R.id.rv_common) RecyclerView mRvCommon;

    public static RoomDetailFragment newInstance(RoomDetailResponse response, String roomId) {
        Bundle args = new Bundle();
        args.putSerializable("data", response);
        args.putString("roomId", roomId);
        RoomDetailFragment fragment = new RoomDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerRoomDetailComponent
                .builder()
                .baseComponent(baseComponent)
                .roomDetailModule(new RoomDetailModule(this)) //请将RoomDetailModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_room_detail;
    }

    @Override
    protected void initData() {
        RoomDetailResponse data = (RoomDetailResponse) getArguments().getSerializable("data");
        String roomId = getArguments().getString("roomId", "");
        if (null != data) {
            mTvIntroduce.setText(data.getRoom_summary());
            Glide.with(this).load(UrlConstant.IMG_ADDRESS + data.getRoom_cover()).into(mCivHead);
            mTvName.setText(data.getUser_name());
            mTvSubscribeHint.setText("被" + data.getRoom_subscribe() + "人关注");
            mPresenter.initCommon(data);
        }
    }

    @OnClick({R.id.tv_subscribe, R.id.tv_common})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_subscribe:
                break;
            case R.id.tv_common:
                break;
        }
    }

    @Override
    public void setAdapter(RoomDetailAdapter adapter) {
        mRvCommon.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvCommon.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST));
        mRvCommon.setAdapter(adapter);
    }
}
