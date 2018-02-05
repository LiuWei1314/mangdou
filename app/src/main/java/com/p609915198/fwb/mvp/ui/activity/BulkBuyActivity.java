package com.p609915198.fwb.mvp.ui.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.BulkBuyContract;
import com.p609915198.fwb.mvp.di.component.DaggerBulkBuyComponent;
import com.p609915198.fwb.mvp.di.module.BulkBuyModule;
import com.p609915198.fwb.mvp.presenter.BulkBuyPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 批量购买
 * Created by Administrator on 2017/11/2.
 */
public class BulkBuyActivity extends BaseActivity<BulkBuyPresenter> implements BulkBuyContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.tv_blues) TextView mTvBlues;
    @BindView(R.id.tv_choose_blues) TextView mTvChooseBlues;
    @BindView(R.id.iv_choose_blues) ImageView mIvChooseBlues;
    @BindView(R.id.rv) RecyclerView mRv;
    @BindView(R.id.tv_total_money) TextView mTvTotalMoney;
    @BindView(R.id.tv_choosed_blues) TextView mTvChoosedBlues;
    @BindView(R.id.tv_buy_all) TextView mTvBuyAll;
    @BindView(R.id.tv_buy_choose) TextView mTvBuyChoose;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerBulkBuyComponent
                .builder()
                .baseComponent(baseComponent)
                .bulkBuyModule(new BulkBuyModule(this)) //请将BulkBuyModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_bulk_buy;
    }

    @Override
    protected void initData() {
        mTvCenter.setText("批量购买");
    }

    @OnClick({R.id.tv_left, R.id.tv_right, R.id.tv_choose_blues, R.id.tv_buy_all, R.id.tv_buy_choose})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.tv_right:
                // TODO: 2017/11/2 全选本业
                break;
            case R.id.tv_buy_all:
                // TODO: 2017/11/2 购买全集
                break;
            case R.id.tv_buy_choose:
                // TODO: 2017/11/2 购买选中
                break;
        }
    }

    @Override
    public void setAdapter(BaseQuickAdapter adapter) {
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this, 1));
        mRv.setAdapter(adapter);
    }
}
