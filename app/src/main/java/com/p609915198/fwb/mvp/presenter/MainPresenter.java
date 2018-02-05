package com.p609915198.fwb.mvp.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.MainContract;
import com.p609915198.fwb.mvp.ui.fragment.DiscoverFragment;
import com.p609915198.fwb.mvp.ui.fragment.HomePageFragment;
import com.p609915198.fwb.mvp.ui.fragment.ListenFragment;
import com.p609915198.fwb.mvp.ui.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by mark.liu on 2017-5-24.
 */
@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {
    private List<Fragment> mFragments = new ArrayList<>();

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View rootView) {
        super(model, rootView);
    }

    public void initPage() {
        mFragments.add(HomePageFragment.newInstance());
        mFragments.add(ListenFragment.newInstance());
        mFragments.add(DiscoverFragment.newInstance());
        mFragments.add(MineFragment.newInstance());

        // 默认显示HomePage
        FragmentTransaction transaction = ((AppCompatActivity) mRootView).getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment, mFragments.get(0));
        transaction.commitAllowingStateLoss();
    }

    public void replaceFragment(int from, int to) {
        if (null != mFragments.get(to)) {
            FragmentTransaction transaction = ((AppCompatActivity) mRootView).getSupportFragmentManager().beginTransaction();
            if (!mFragments.get(to).isAdded()) {    // 先判断是否被add过
                transaction.hide(mFragments.get(from)).add(R.id.fragment, mFragments.get(to)); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(mFragments.get(from)).show(mFragments.get(to)); // 隐藏当前的fragment，显示下一个
            }
            transaction.commitAllowingStateLoss();
        }
    }
}
