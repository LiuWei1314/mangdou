package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.SearchResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.mvp.contract.SearchContract;
import com.p609915198.fwb.mvp.ui.adapter.SearchAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@ActivityScope
public class SearchPresenter extends BasePresenter<SearchContract.Model, SearchContract.View> {
    @Inject SearchAdapter mSearchAdapter;
    @Inject List<SearchResponse> mList;
    @Inject Api mApi;

    @Inject
    public SearchPresenter(SearchContract.Model model, SearchContract.View rootView) {
        super(model, rootView);
    }

    public void initViews() {
        mRootView.setAdapter(mSearchAdapter);
    }

    public void search(String content) {
        mApi.search(content, 0, 30)
            .compose(RxUtils.bindToLifecycle(mRootView))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<List<SearchResponse>>() {
                        @Override
                        protected void onNext(List<SearchResponse> listHttpResult) {
                            if (listHttpResult.isEmpty()) {
                                mRootView.showToast("搜索结果为空！");
                                return;
                            }
                            mList.clear();
                            mList.addAll(listHttpResult);
                            mSearchAdapter.notifyDataSetChanged();
                        }
                    },
                    mRootView.getActivity()
            ));
    }
}
