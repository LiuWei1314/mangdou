package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.AnchorDetailResponse;
import com.p609915198.basemodule.net.response.AnchorListResponse;
import com.p609915198.basemodule.widget.CircleImageView;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.AnchorDetailContract;
import com.p609915198.fwb.mvp.di.component.DaggerAnchorDetailComponent;
import com.p609915198.fwb.mvp.di.module.AnchorDetailModule;
import com.p609915198.fwb.mvp.presenter.AnchorDetailPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 主播详情
 * Created by Administrator on 2017/11/10.
 */
public class AnchorDetailActivity extends BaseActivity<AnchorDetailPresenter> implements AnchorDetailContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.civ_head) CircleImageView civHead;
    @BindView(R.id.tv_name) TextView tvName;
    @BindView(R.id.tv_subscribe) TextView tvSubscribe;
    @BindView(R.id.tv_fans) TextView tvFans;
    @BindView(R.id.tv_introduce) TextView tvIntroduce;
    @BindView(R.id.rv) RecyclerView rv;
    @BindView(R.id.tv_zhuanji) TextView tvZhuanji;
//    @BindView(R.id.tv_more) TextView tvMore;

    private AnchorListResponse.DataBean mDataBean;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerAnchorDetailComponent
                .builder()
                .baseComponent(baseComponent)
                .anchorDetailModule(new AnchorDetailModule(this)) //请将AnchorDetailModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_anchor_detail;
    }

    @Override
    protected void initData() {
        tvCenter.setText("主播详情");
        tvCenter.setVisibility(View.VISIBLE);

        mDataBean = (AnchorListResponse.DataBean) getIntent().getSerializableExtra("DataBean");
        if (null != mDataBean) {
            Glide.with(this).load(UrlConstant.IMG_ADDRESS + mDataBean.getUser_head()).into(civHead);
            tvName.setText(mDataBean.getUser_name());
            tvIntroduce.setText(mDataBean.getUser_summary());

            mPresenter.init(mDataBean.getUser_id());
        }
    }

    @OnClick({R.id.tv_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
        }
    }

    @Override
    public void setAdapter(BaseQuickAdapter adapter) {
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void setViews(AnchorDetailResponse response) {

    }
}
