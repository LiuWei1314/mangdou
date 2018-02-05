package com.p609915198.basemodule.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends IPresenter> extends RxAppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();
    private final static String LAYOUT_LINEAR_LAYOUT = "LinearLayout";
    private final static String LAYOUT_FRAME_LAYOUT = "FrameLayout";
    private final static String LAYOUT_RELATIVE_LAYOUT = "RelativeLayout";
    private Unbinder mUnbinder;
    @Inject protected P mPresenter;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        if (name.equals(LAYOUT_FRAME_LAYOUT)) {
            view = new AutoFrameLayout(context, attrs);
        } else if (name.equals(LAYOUT_LINEAR_LAYOUT)) {
            view = new AutoLinearLayout(context, attrs);
        } else if (name.equals(LAYOUT_RELATIVE_LAYOUT)) {
            view = new AutoRelativeLayout(context, attrs);
        }
        return view;
    }

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        if (useEventBus()) {
            // 如果要使用eventbus请将此方法返回true
            EventBus.getDefault().register(this);
        }
        // 绑定到butterknife
        mUnbinder = ButterKnife.bind(this);
        // 依赖注入
        setupActivityComponent(BaseApplication.getBaseComponent());
        // 初始化
        initData();
    }

    /**
     * 提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
     *
     * @param baseComponent 父组件
     */
    protected abstract void setupActivityComponent(BaseComponent baseComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            // 释放资源
            mPresenter.onDestroy();
        }
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
        // 如果要使用eventbus请将此方法返回true
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        mPresenter = null;
        mUnbinder = null;
    }

    /**
     * 是否使用eventBus
     *
     * @return false = 不使用(默认) , true = 使用
     */
    protected boolean useEventBus() {
        return false;
    }

    /**
     * 加载xml布局文件
     *
     * @return xml文件id
     */
    @LayoutRes
    protected abstract int getLayoutRes();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 跳转activity
     */
    public void launchActivity(@NonNull Intent intent) {ActivityUtils.startActivity(this, intent);}

    /**
     * 结束自己
     */
    public void killMyself() {
        ActivityUtils.finishActivity(this, true);
    }

    public void showToast(String msg) {
        ToastUtils.showLong(msg);
    }

    public void showToast(int resId) {ToastUtils.showShort(resId);}
}