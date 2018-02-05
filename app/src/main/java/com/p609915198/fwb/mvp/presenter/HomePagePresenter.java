package com.p609915198.fwb.mvp.presenter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.HomePageContract;
import com.p609915198.fwb.mvp.ui.adapter.TabPageIndicatorAdapter;
import com.p609915198.fwb.mvp.ui.fragment.ClassifyFragment;
import com.p609915198.fwb.mvp.ui.fragment.HostFragment;
import com.p609915198.fwb.mvp.ui.fragment.HotFragment;
import com.p609915198.fwb.mvp.ui.fragment.QualityFragment;
import com.p609915198.fwb.utils.TabLayoutUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
public class HomePagePresenter extends BasePresenter<HomePageContract.Model, HomePageContract.View> {
    private TabPageIndicatorAdapter mAdapter;
    private List<Fragment> mFragmentList;

    @Inject
    public HomePagePresenter(HomePageContract.Model model, HomePageContract.View rootView) {
        super(model, rootView);
    }

    public void initViewPager(FragmentManager fragmentManager) {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(HotFragment.newInstance());
        mFragmentList.add(ClassifyFragment.newInstance());
        mFragmentList.add(QualityFragment.newInstance());
        mFragmentList.add(HostFragment.newInstance());
//        mFragmentList.add(RadioFragment.newInstance());
//        mAdapter = new TabPageIndicatorAdapter(fragmentManager, mFragmentList, new String[]{"热门", "分类", "精品", "主播", "广播"});
        mAdapter = new TabPageIndicatorAdapter(fragmentManager, mFragmentList, new String[]{"热门", "分类", "精品", "主播"});
        mRootView.setFragmentPagerAdapter(mAdapter);
    }

    public void reflex(final TabLayout tabLayout) {
        TabLayoutUtil.reflex(tabLayout, 17);
    }
}
