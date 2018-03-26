package com.p609915198.fwb.mvp.ui.activity;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.BangResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.basemodule.widget.autolayout.AutoTabLayout;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.BangContract;
import com.p609915198.fwb.mvp.di.component.DaggerBangComponent;
import com.p609915198.fwb.mvp.di.module.BangModule;
import com.p609915198.fwb.mvp.presenter.BangPresenter;
import com.p609915198.fwb.mvp.ui.fragment.AllBangFragment;
import com.p609915198.fwb.mvp.ui.fragment.HostBangFragment;
import com.p609915198.fwb.utils.TabLayoutUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 榜单
 */
public class BangActivity extends BaseActivity<BangPresenter> implements BangContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.tab_layout) AutoTabLayout tabLayout;
    @BindView(R.id.view_pager) ViewPager viewPager;

    @Inject Api mApi;

    private BangAdapter adapter;
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerBangComponent
                .builder()
                .baseComponent(baseComponent)
                .bangModule(new BangModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_bang;
    }

    @Override
    public void initData() {
        tvCenter.setText("榜单");
        tvCenter.setVisibility(View.VISIBLE);

        mApi.bang().compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<BangResponse>() {
                        @Override
                        protected void onNext(BangResponse response) {
                            if (response.isStatus()) {

                                mFragmentList.add(AllBangFragment.newInstance((ArrayList) response.getData().getNormal()));
                                mFragmentList.add(HostBangFragment.newInstance());
                                adapter = new BangAdapter(getSupportFragmentManager(), mFragmentList);
                                viewPager.setAdapter(adapter);
                                tabLayout.setupWithViewPager(viewPager);

                                TabLayoutUtil.reflex(tabLayout, 50);
                            }
                        }
                    },
                    this
            ));
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {
        killMyself();
    }

    private static final class BangAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments;
        private static final String[] titles = new String[]{"爱豆总榜", "主播榜"};

        public BangAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int arg0) {
            return mFragments.get(arg0);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
