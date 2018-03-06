package com.p609915198.fwb.mvp.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.widget.autolayout.AutoTabLayout;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.RewardContract;
import com.p609915198.fwb.mvp.di.component.DaggerRewardComponent;
import com.p609915198.fwb.mvp.di.module.RewardModule;
import com.p609915198.fwb.mvp.presenter.RewardPresenter;
import com.p609915198.fwb.mvp.ui.fragment.MyReceiveRewardFragment;
import com.p609915198.fwb.mvp.ui.fragment.MyRewardFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的打赏
 * Created by Administrator on 2018/3/4.
 */
public class RewardActivity extends BaseActivity<RewardPresenter> implements RewardContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.tab_layout) AutoTabLayout mTabLayout;
    @BindView(R.id.view_pager) ViewPager mViewPager;

    private RewardAdapter mColumnAdapter;
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerRewardComponent
                .builder()
                .baseComponent(baseComponent)
                .rewardModule(new RewardModule(this)) //请将rewardModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_reward;
    }

    @Override
    protected void initData() {
        tvCenter.setText("我的打赏");
        tvCenter.setVisibility(View.VISIBLE);

        mFragmentList.add(MyRewardFragment.newInstance());
        mFragmentList.add(MyReceiveRewardFragment.newInstance());
        mColumnAdapter = new RewardAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mColumnAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        reflex(mTabLayout, 50);
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {killMyself();}

    public void reflex(final TabLayout tabLayout, int dp) {
        //了解源码得知 线的宽度是根据 tabView的宽度来设置的
        tabLayout.post(() -> {
            try {
                //拿到tabLayout的mTabStrip属性
                LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);
                int dp10 = ConvertUtils.dp2px(dp);
                for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                    View tabView = mTabStrip.getChildAt(i);
                    //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                    Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                    mTextViewField.setAccessible(true);
                    TextView mTextView = (TextView) mTextViewField.get(tabView);
                    tabView.setPadding(0, 0, 0, 0);
                    //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                    int width = 0;
                    width = mTextView.getWidth();
                    if (width == 0) {
                        mTextView.measure(0, 0);
                        width = mTextView.getMeasuredWidth();
                    }
                    //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                    params.width = width;
                    params.leftMargin = dp10;
                    params.rightMargin = dp10;
                    tabView.setLayoutParams(params);
                    tabView.invalidate();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private static final class RewardAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments;
        private static final String[] titles = new String[]{"我的打赏", "我收到的打赏"};

        public RewardAdapter(FragmentManager fm, List<Fragment> fragments) {
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
