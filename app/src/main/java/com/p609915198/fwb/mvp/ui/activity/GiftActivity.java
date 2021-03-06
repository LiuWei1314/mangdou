package com.p609915198.fwb.mvp.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.widget.autolayout.AutoTabLayout;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.GiftContract;
import com.p609915198.fwb.mvp.di.component.DaggerGiftComponent;
import com.p609915198.fwb.mvp.di.module.GiftModule;
import com.p609915198.fwb.mvp.presenter.GiftPresenter;
import com.p609915198.fwb.mvp.ui.fragment.MyGiftFragment;
import com.p609915198.fwb.mvp.ui.fragment.MyRewardGiftFragment;
import com.p609915198.fwb.utils.TabLayoutUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的礼物
 * Created by Administrator on 2018/3/4.
 */
public class GiftActivity extends BaseActivity<GiftPresenter> implements GiftContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.tab_layout) AutoTabLayout mTabLayout;
    @BindView(R.id.view_pager) ViewPager mViewPager;

    private GiftAdapter adapter;
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerGiftComponent
                .builder()
                .baseComponent(baseComponent)
                .giftModule(new GiftModule(this)) //请将GiftModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_gift;
    }

    @Override
    protected void initData() {
        tvCenter.setText("我的礼物");
        tvCenter.setVisibility(View.VISIBLE);

        mFragmentList.add(MyGiftFragment.newInstance());
        mFragmentList.add(MyRewardGiftFragment.newInstance());
        adapter = new GiftAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        TabLayoutUtil.reflex(mTabLayout, 50);
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {
        killMyself();
    }

    private static final class GiftAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments;
        private static final String[] titles = new String[]{"我的礼物", "我收到的礼物"};

        public GiftAdapter(FragmentManager fm, List<Fragment> fragments) {
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
