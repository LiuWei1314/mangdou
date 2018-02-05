package com.p609915198.fwb.mvp.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.PlayRecordContract;
import com.p609915198.fwb.mvp.di.component.DaggerPlayRecordComponent;
import com.p609915198.fwb.mvp.di.module.PlayRecordModule;
import com.p609915198.fwb.mvp.presenter.PlayRecordPresenter;

import butterknife.BindView;
import butterknife.OnClick;

import static com.p609915198.basemodule.widget.divider.DividerItemDecoration.VERTICAL_LIST;

/**
 * 播放记录
 * Created by Administrator on 2017/11/7.
 */
public class PlayRecordActivity extends BaseActivity<PlayRecordPresenter> implements PlayRecordContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.rv) RecyclerView mRv;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerPlayRecordComponent
                .builder()
                .baseComponent(baseComponent)
                .playRecordModule(new PlayRecordModule(this)) //请将PlayRecordModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_play_record;
    }

    @Override
    protected void initData() {
        mTvLeft.setText("");
        mTvCenter.setText("播放记录");
        mTvCenter.setVisibility(View.VISIBLE);
        mPresenter.getPlayRecordData();
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {
        killMyself();
    }

    @Override
    public void setAdapter(BaseQuickAdapter adapter) {
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this, VERTICAL_LIST));
        mRv.setAdapter(adapter);
    }
}
