package com.p609915198.fwb.mvp.ui.activity;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.bumptech.glide.Glide;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.basemodule.widget.autolayout.AutoTabLayout;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.ColumnContract;
import com.p609915198.fwb.mvp.di.component.DaggerColumnComponent;
import com.p609915198.fwb.mvp.di.module.ColumnModule;
import com.p609915198.fwb.mvp.presenter.ColumnPresenter;
import com.p609915198.fwb.mvp.ui.adapter.ColumnAdapter;
import com.p609915198.fwb.mvp.ui.fragment.PlayListFragment;
import com.p609915198.fwb.mvp.ui.fragment.RoomDetailFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 专辑详情
 *
 * @author mark.liu
 *         Created by mark.liu on 2017-10-17.
 */
public class ColumnActivity extends BaseActivity<ColumnPresenter> implements ColumnContract.View {
    @BindColor(R.color.main_text_selected) int selectedColor;
    @BindColor(R.color.text66) int color;
    @BindColor(R.color.white) int white;
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.iv_column_detail) ImageView mIvColumnDetail;
    @BindView(R.id.tv_title) TextView mTvTitle;
    @BindView(R.id.tv_host) TextView mTvHost;
    @BindView(R.id.tv_classify) TextView mTvClassify;
    @BindView(R.id.tv_state) TextView mTvState;
    @BindView(R.id.tv_play_amount) TextView mTvPlayAmount;
    @BindView(R.id.tv_price) TextView mTvPrice;
    @BindView(R.id.tv_price_discounts) TextView mTvPriceDiscounts;
    @BindView(R.id.iv_share) ImageView mIvShare;
    @BindView(R.id.tv_share) TextView mTvShare;
    @BindView(R.id.ll_share) LinearLayout mLlShare;
    @BindView(R.id.rl_pay) RelativeLayout mRlPay;
    @BindView(R.id.tv_subscribe) TextView mTvSubscribe;
    @BindView(R.id.ll_subscribe) LinearLayout mLlSubscribe;
    @BindView(R.id.tv_buy) TextView mTvBuy;
    @BindView(R.id.ll_buy) LinearLayout mLlBuy;
    @BindView(R.id.tab_layout) AutoTabLayout mTabLayout;
    @BindView(R.id.view_pager) ViewPager mViewPager;

    private ColumnAdapter mColumnAdapter;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private String roomId;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerColumnComponent
                .builder()
                .baseComponent(baseComponent)
                .columnModule(new ColumnModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_column;
    }

    @Override
    protected void initData() {
        mTvCenter.setText("专辑详情");
        mTvCenter.setVisibility(View.VISIBLE);

        roomId = getIntent().getStringExtra("roomId");
        if (!TextUtils.isEmpty(roomId)) {
            mPresenter.getData(roomId);
        }
    }

    @Override
    public FragmentManager getFraManager() {
        return getSupportFragmentManager();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showViews(RoomDetailResponse roomDetailResponse, String roomId) {
        Glide.with(this).load(UrlConstant.IMG_ADDRESS + roomDetailResponse.getRoom_cover()).into(mIvColumnDetail);

        mTvTitle.setText(roomDetailResponse.getRoom_name());
        mTvHost.setText("主播:  " + roomDetailResponse.getUser_name());
        mTvClassify.setText("分类:  " + roomDetailResponse.getRoom_category());
        mTvPlayAmount.setText("播放量:  " + roomDetailResponse.getRoom_plays());
        mTvPrice.setText("价格:  " + roomDetailResponse.getRoom_price() + "忙豆");
        mTvSubscribe.setText("订阅(" + roomDetailResponse.getRoom_subscribe() + ")");
        mTvSubscribe.setOnClickListener(v -> subscribe());
        mTvState.setText("状态:  " + roomDetailResponse.getLast_update());

        if (!TextUtils.isEmpty(roomDetailResponse.getRoom_price()) && 0 != Double.valueOf(roomDetailResponse.getRoom_price())) {
            if (0 == roomDetailResponse.getIs_buy()) {
                // 未买
                mLlBuy.setOnClickListener(view -> buy(roomDetailResponse, roomId));
            } else if (1 == roomDetailResponse.getIs_buy()) {
                // 已买
                mLlBuy.setVisibility(View.GONE);
            }
        } else {
            mLlBuy.setVisibility(View.GONE);
        }

        mFragmentList.add(RoomDetailFragment.newInstance(roomDetailResponse, roomId));
        mFragmentList.add(PlayListFragment.newInstance(roomDetailResponse, roomId));
        mColumnAdapter = new ColumnAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mColumnAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        reflex(mTabLayout, 50);
    }

    @OnClick({R.id.tv_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
        }
    }

    /**
     * 订阅
     */
    private void subscribe() {
        if (AppConfig.isLogin()) {
            mPresenter.subcribe(roomId);
        } else {
            showToast("请先登录！");
        }
    }

    /**
     * 购买
     */
    private void buy(RoomDetailResponse roomDetailResponse, String roomId) {
        if (AppConfig.isLogin()) {
            mPresenter.buy(roomDetailResponse, roomId);
        } else {
            showToast("请先登录！");
        }
    }

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
}
