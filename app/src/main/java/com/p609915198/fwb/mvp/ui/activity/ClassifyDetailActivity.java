package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.response.CategoryResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.ClassifyDetailContract;
import com.p609915198.fwb.mvp.di.component.DaggerClassifyDetailComponent;
import com.p609915198.fwb.mvp.di.module.ClassifyDetailModule;
import com.p609915198.fwb.mvp.presenter.ClassifyDetailPresenter;
import com.p609915198.fwb.mvp.ui.adapter.SecondaryCategoryAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 分类详情
 * Created by Administrator on 2017/11/14.
 */
public class ClassifyDetailActivity extends BaseActivity<ClassifyDetailPresenter> implements ClassifyDetailContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.rv) RecyclerView mRv;

    private CategoryResponse mCategoryResponse;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerClassifyDetailComponent
                .builder()
                .baseComponent(baseComponent)
                .classifyDetailModule(new ClassifyDetailModule(this)) //请将ClassifyDetailModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_classify_detail;
    }

    @Override
    protected void initData() {
        mCategoryResponse = (CategoryResponse) getIntent().getSerializableExtra("CategoryResponse");
        if (null != mCategoryResponse) {
            mTvCenter.setText(mCategoryResponse.getCategory_name());
            mTvCenter.setVisibility(View.VISIBLE);

            mPresenter.secondCategory(mCategoryResponse.getCategory_id());
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void setAdapter(SecondaryCategoryAdapter adapter) {
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRv.setAdapter(adapter);
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {killMyself();}
}
