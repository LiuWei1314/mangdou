package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.HotKeywordsResponse;
import com.p609915198.basemodule.net.response.SearchResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.mvp.contract.SearchContract;
import com.p609915198.fwb.mvp.ui.activity.SearchResultActivity;
import com.p609915198.fwb.mvp.ui.adapter.HotKeywordsAdapter;
import com.p609915198.fwb.widget.flowLayout.TagAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@ActivityScope
public class SearchPresenter extends BasePresenter<SearchContract.Model, SearchContract.View> {

    @Inject Api mApi;

    @Inject
    public SearchPresenter(SearchContract.Model model, SearchContract.View rootView) {
        super(model, rootView);
    }

    public void initViews() {
        mApi.hotKeywords(10)
            .compose(RxUtils.bindToLifecycle(mRootView))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<List<HotKeywordsResponse>>() {
                        @Override
                        protected void onNext(List<HotKeywordsResponse> hotKeywordsResponses) {
                            TagAdapter adapter = new HotKeywordsAdapter(hotKeywordsResponses, mRootView.getActivity());
                            mRootView.setAdapter(adapter);
                        }
                    }, mRootView.getActivity()
            ));
    }

    public void search(String content) {
        mApi.search(content, 0, 30)
            .compose(RxUtils.bindToLifecycle(mRootView))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<ArrayList<SearchResponse>>() {
                        @Override
                        protected void onNext(ArrayList<SearchResponse> listHttpResult) {
                            mRootView.freshSearchRecord(content);
                            if (listHttpResult.isEmpty()) {
                                mRootView.showToast("搜索结果为空！");
                                return;
                            }
                            Intent intent = new Intent(mRootView.getActivity(), SearchResultActivity.class);
                            intent.putParcelableArrayListExtra("data", listHttpResult);
                            mRootView.launchActivity(intent);
                        }
                    },
                    mRootView.getActivity()
            ));
    }
}
