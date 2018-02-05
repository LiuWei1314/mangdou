package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.SearchContract;
import com.p609915198.fwb.mvp.di.component.DaggerSearchComponent;
import com.p609915198.fwb.mvp.di.module.SearchModule;
import com.p609915198.fwb.mvp.presenter.SearchPresenter;
import com.p609915198.fwb.mvp.ui.adapter.SearchAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 搜索
 * Created by Administrator on 2018/1/9 0009.
 */
public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.bt_search) Button mBtSearch;
    @BindView(R.id.rv) RecyclerView mRv;
    @BindView(R.id.et_search) EditText mEditText;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerSearchComponent
                .builder()
                .baseComponent(baseComponent)
                .searchModule(new SearchModule(this)) //请将SearchModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_search;
    }

    @Override
    protected void initData() {
        mPresenter.initViews();
    }

    @OnClick({R.id.tv_left, R.id.bt_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.bt_search:
                String content = mEditText.getText().toString();
                if (TextUtils.isEmpty(content) || TextUtils.isEmpty(content.trim())) {
                    showToast("输入的内容不能为空！");
                    return;
                }
                mPresenter.search(content);
                break;
        }
    }

    @Override
    public void setAdapter(SearchAdapter adapter) {
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(adapter);
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
