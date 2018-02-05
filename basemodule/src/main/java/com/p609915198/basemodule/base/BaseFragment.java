package com.p609915198.basemodule.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.trello.rxlifecycle2.components.support.RxFragment;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends IPresenter> extends RxFragment {
    protected final String TAG = this.getClass().getSimpleName();
    protected BaseActivity mActivity;
    private Unbinder mUnbinder;
    @Inject protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutRes(), container, false);
        // 绑定到butterknife
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
        // 如果要使用eventbus请将此方法返回true
        if (useEventBus()) {
            // 注册到事件主线
            EventBus.getDefault().register(this);
        }
        setupFragmentComponent(BaseApplication.getBaseComponent());
        initData();
    }

    /**
     * 提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
     *
     * @param baseComponent 父组件
     */
    protected abstract void setupFragmentComponent(BaseComponent baseComponent);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();// 释放资源
        }
        // 如果要使用eventbus请将此方法返回true
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        this.mPresenter = null;
        this.mActivity = null;
        this.mUnbinder = null;
    }

    /**
     * 是否使用eventBus,默认为使用(false)，
     */
    protected boolean useEventBus() {
        return false;
    }

    /**
     * 加载xml布局文件
     */
    @LayoutRes
    protected abstract int getLayoutRes();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    public void launchActivity(@NonNull Intent intent) {
        ActivityUtils.startActivity(mActivity, intent);
    }

    public void killMyself() {
        ActivityUtils.finishActivity(mActivity);
    }

    public void showToast(String msg) {
        ToastUtils.showLong(msg);
    }

    public void showToast(int resId) {
        ToastUtils.showShort(resId);
    }
}
