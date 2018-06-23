package com.p609915198.fwb.mvp.ui.activity;import android.app.Activity;import android.support.v7.widget.LinearLayoutManager;import android.support.v7.widget.RecyclerView;import android.text.TextUtils;import android.view.View;import android.widget.EditText;import android.widget.ImageView;import android.widget.TextView;import com.p609915198.basemodule.base.BaseActivity;import com.p609915198.basemodule.di.component.BaseComponent;import com.p609915198.basemodule.net.Api;import com.p609915198.basemodule.net.response.HotKeywordsResponse;import com.p609915198.fwb.R;import com.p609915198.fwb.mvp.contract.SearchContract;import com.p609915198.fwb.mvp.di.component.DaggerSearchComponent;import com.p609915198.fwb.mvp.di.module.SearchModule;import com.p609915198.fwb.mvp.presenter.SearchPresenter;import com.p609915198.fwb.mvp.ui.adapter.SearchAdapter;import com.p609915198.fwb.mvp.ui.adapter.SearchRecordAdapter;import com.p609915198.fwb.utils.ACache;import com.p609915198.fwb.widget.flowLayout.TagAdapter;import com.p609915198.fwb.widget.flowLayout.TagFlowLayout;import java.util.ArrayList;import javax.inject.Inject;import butterknife.BindView;import butterknife.OnClick;/** * 搜索 * Created by Administrator on 2018/1/9 0009. */public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchContract.View {    @BindView(R.id.tv_left) TextView mTvLeft;    @BindView(R.id.tv_center) TextView mTvCenter;    @BindView(R.id.iv_right) ImageView mIvRight;    @BindView(R.id.tv_right) TextView mTvRight;    @BindView(R.id.et_search) EditText mEtSearch;    @BindView(R.id.tv_search) TextView mTvSearch;    @BindView(R.id.flow_layout) TagFlowLayout mFlowLayout;    @BindView(R.id.rv) RecyclerView mRv;    @Inject Api mApi;    /**     * 搜索记录     */    public static final String SEARCH_RECORD = "SearchRecord";    private SearchRecordAdapter mSearchAdapter;    private ArrayList<String> searchRecord = new ArrayList<>();    @Override    protected void setupActivityComponent(BaseComponent baseComponent) {        DaggerSearchComponent                .builder()                .baseComponent(baseComponent)                .searchModule(new SearchModule(this)) //请将SearchModule()第一个首字母改为小写                .build()                .inject(this);    }    @Override    protected int getLayoutRes() {        return R.layout.activity_search;    }    @Override    protected void initData() {        mTvCenter.setText("搜索");        mTvCenter.setVisibility(View.VISIBLE);        mPresenter.initViews();        if (null == ACache.get(this).getAsObject(SEARCH_RECORD)) {            ACache.get(this).put(SEARCH_RECORD, searchRecord);        } else {            searchRecord.addAll((ArrayList) ACache.get(this).getAsObject(SEARCH_RECORD));        }        mSearchAdapter = new SearchRecordAdapter(searchRecord);        mSearchAdapter.setOnItemClickListener((adapter, view, position) -> mPresenter.search(searchRecord.get(position)));        mSearchAdapter.setOnItemChildClickListener((adapter, view, position) -> {            switch (view.getId()) {                case R.id.iv_delete:                    searchRecord.remove(position);                    ACache.get(this).put(SEARCH_RECORD, searchRecord);                    mSearchAdapter.notifyDataSetChanged();                    break;            }        });        mRv.setLayoutManager(new LinearLayoutManager(this));        mRv.setAdapter(mSearchAdapter);    }    @OnClick({R.id.tv_left, R.id.tv_search})    public void onViewClicked(View view) {        switch (view.getId()) {            case R.id.tv_left:                killMyself();                break;            case R.id.tv_search:                String content = mEtSearch.getText().toString();                if (TextUtils.isEmpty(content) || TextUtils.isEmpty(content.trim())) {                    showToast("输入的内容不能为空！");                    return;                }                mPresenter.search(content);                break;        }    }    @Override    public void setAdapter(SearchAdapter adapter) {        mRv.setLayoutManager(new LinearLayoutManager(this));        mRv.setAdapter(adapter);    }    @Override    public void setAdapter(TagAdapter adapter) {        mFlowLayout.setOnTagClickListener((view, position, parent) -> {            HotKeywordsResponse item = (HotKeywordsResponse) adapter.getItem(position);            mPresenter.search(item.getKeywords());            return true;        });        mFlowLayout.setAdapter(adapter);    }    @Override    public Activity getActivity() {        return this;    }    @Override    public void freshSearchRecord(String content) {        for (String item : searchRecord) {            if (item.equals(content)) {                return;            }        }        searchRecord.add(content);        ACache.get(this).put(SEARCH_RECORD, searchRecord);        mSearchAdapter.notifyDataSetChanged();    }}