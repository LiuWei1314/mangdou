package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.response.AdResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.entity.local.AdHolderView;
import com.p609915198.fwb.mvp.contract.RoomsMoreContract;
import com.p609915198.fwb.mvp.di.component.DaggerRoomsMoreComponent;
import com.p609915198.fwb.mvp.di.module.RoomsMoreModule;
import com.p609915198.fwb.mvp.presenter.RoomsMorePresenter;
import com.p609915198.fwb.mvp.ui.adapter.RoomsMoreAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 推荐榜/免费榜/新品榜
 * Created by Administrator on 2017/11/9.
 */
public class RoomsMoreActivity extends BaseActivity<RoomsMorePresenter> implements RoomsMoreContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.rv) RecyclerView mRv;
    @BindView(R.id.convenientBanner) ConvenientBanner mConvenientBanner;

    @Inject RoomsMoreAdapter mRoomsMoreAdapter;
    @Inject RecyclerView.LayoutManager mLayoutManager;
    @Inject RecyclerView.ItemDecoration mItemDecoration;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerRoomsMoreComponent
                .builder()
                .baseComponent(baseComponent)
                .roomsMoreModule(new RoomsMoreModule(this)) //请将RoomsMoreModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_rooms_more;
    }

    @Override
    protected void initData() {
        mRv.setAdapter(mRoomsMoreAdapter);
        mRv.setLayoutManager(mLayoutManager);
        mRv.addItemDecoration(mItemDecoration);

        mTvCenter.setVisibility(View.VISIBLE);
        String label = getIntent().getStringExtra("label");
        if (!TextUtils.isEmpty(label)) {
            mTvCenter.setText(label);
        }

        String labelId = getIntent().getStringExtra("labelId");
        mPresenter.initData(labelId);
    }

    @Override
    public void setAdHeaderView(AdResponse adData) {
        List<AdResponse> data = new ArrayList<>();
        data.add(adData);
        mConvenientBanner.setPages(() -> new AdHolderView(), data)
                         .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                         .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                         .setOnItemClickListener(position -> {
                             // TODO: 2017-9-22
                         });
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {killMyself();}

    @Override
    public Activity getActivity() {
        return this;
    }
}
