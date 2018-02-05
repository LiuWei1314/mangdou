package com.p609915198.fwb.mvp.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.DowloadAllBuyContract;
import com.p609915198.fwb.mvp.di.component.DaggerDowloadAllBuyComponent;
import com.p609915198.fwb.mvp.di.module.DowloadAllBuyModule;
import com.p609915198.fwb.mvp.presenter.DowloadAllBuyPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 已购批量下载
 * Created by Administrator on 2017/11/2.
 */
public class DowloadAllBuyActivity extends BaseActivity<DowloadAllBuyPresenter> implements DowloadAllBuyContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.tv_blues) TextView mTvBlues;
    @BindView(R.id.tv_choose_blues) TextView mTvChooseBlues;
    @BindView(R.id.iv_choose_blues) ImageView mIvChooseBlues;
    @BindView(R.id.rv) RecyclerView mRv;
    @BindView(R.id.tv_buy_all) TextView mTvBuyAll;
    @BindView(R.id.cb_choose_all) CheckBox mCbChooseAll;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerDowloadAllBuyComponent
                .builder()
                .baseComponent(baseComponent)
                .dowloadAllBuyModule(new DowloadAllBuyModule(this)) //请将DowloadAllBuyModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_dowload_all_buy;
    }

    @Override
    protected void initData() {
    }

    @OnClick({R.id.tv_left, R.id.tv_right, R.id.iv_choose_blues, R.id.cb_choose_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.tv_right:
                break;
            case R.id.iv_choose_blues:
                break;
            case R.id.cb_choose_all:
                break;
        }
    }
}
