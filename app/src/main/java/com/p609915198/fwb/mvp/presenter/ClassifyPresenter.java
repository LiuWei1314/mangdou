package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.CategoryResponse;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.fwb.mvp.contract.ClassifyContract;
import com.p609915198.fwb.mvp.ui.activity.ClassifyDetailActivity;
import com.p609915198.fwb.mvp.ui.adapter.ClassifyAdapter;
import com.p609915198.fwb.mvp.ui.adapter.ClassifyMenuAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
public class ClassifyPresenter extends BasePresenter<ClassifyContract.Model, ClassifyContract.View> {
    private ClassifyAdapter mClassifyAdapter;
    private ClassifyMenuAdapter mMenuAdapter;

    @Inject Api api;

    @Inject
    public ClassifyPresenter(ClassifyContract.Model model, ClassifyContract.View rootView, Api api) {
        super(model, rootView);
    }

    public void initHeaderAd(int position) {
        mModel.getAdData(position).subscribe(new ProgressSubscriber<>(
                new SubscriberOnNextListener<List<HomeAdResponse>>() {
                    @Override
                    protected void onNext(List<HomeAdResponse> homeAdRespons) {
                        mRootView.setAdHeaderView(homeAdRespons);
                    }
                },
                ((BaseFragment) mRootView).getActivity(),
                false
        ));
    }

    public void initView() {
        mModel.getData()
              .map(categoryListResponses -> {
                  if (categoryListResponses.size() >= 2) {
                      List<CategoryResponse> s = new ArrayList<>();
                      s.add(categoryListResponses.get(0));
                      s.add(categoryListResponses.get(1));
                      mMenuAdapter = new ClassifyMenuAdapter(s, api);
                      mMenuAdapter.setOnItemClickListener((adapter, view, position) -> {
                          Intent intent = new Intent(mRootView.getActivityImpl(), ClassifyDetailActivity.class);
                          intent.putExtra("CategoryResponse", s.get(position));
                          mRootView.launchActivity(intent);
                      });
                      mRootView.setAdapter(mMenuAdapter);

                      categoryListResponses.remove(s.get(0));
                      categoryListResponses.remove(s.get(1));
                  }
                  return categoryListResponses;
              })
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<List<CategoryResponse>>() {
                          @Override
                          protected void onNext(List<CategoryResponse> categoryListResponses) {
                              mClassifyAdapter = new ClassifyAdapter(categoryListResponses);
                              mClassifyAdapter.setOnItemClickListener((adapter, view, position) -> {
                                  Intent intent = new Intent(mRootView.getActivityImpl(), ClassifyDetailActivity.class);
                                  intent.putExtra("CategoryResponse", categoryListResponses.get(position));
                                  mRootView.launchActivity(intent);
                              });
                              mRootView.setAdapter(mClassifyAdapter);
                          }
                      },
                      ((BaseFragment) mRootView).getActivity(),
                      false
              ));
    }

    public void initFootAd(int position) {
        mModel.getAdData(position).subscribe(new ProgressSubscriber<>(
                new SubscriberOnNextListener<List<HomeAdResponse>>() {
                    @Override
                    protected void onNext(List<HomeAdResponse> homeAdRespons) {
                        mRootView.setAdFooterView(homeAdRespons);
                    }
                },
                ((BaseFragment) mRootView).getActivity(),
                false
        ));
    }
}
