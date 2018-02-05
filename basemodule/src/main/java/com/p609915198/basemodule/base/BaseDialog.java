package com.p609915198.basemodule.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * 基类Dialog，非Dagger2
 * Created by mark.liu on 2017-11-16.
 */
public abstract class BaseDialog extends Dialog {
    protected Context mContext;

    public BaseDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    public BaseDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 如果要使用eventbus请将此方法返回true
        if (useEventBus()) {
            // 注册到事件主线
            EventBus.getDefault().register(this);
        }

        View view = LayoutInflater.from(mContext).inflate(getLayoutRes(), null);
        ViewGroup.LayoutParams params = getLayoutParams();
        if (null != params) {
            setContentView(view, params);
        } else {
            setContentView(view);
        }

        // 绑定到butterknife
        ButterKnife.bind(this);
        initData();
    }

    protected ViewGroup.LayoutParams getLayoutParams() {
        return null;
    }

    /**
     * 是否使用eventBus,默认为使用(false)，
     */
    protected boolean useEventBus() {
        return false;
    }

    /**
     * 加载xml布局
     */
    @LayoutRes
    protected abstract int getLayoutRes();

    /**
     * 初始化方法
     */
    protected abstract void initData();

    public void launchActivity(@NonNull Intent intent) {
        ActivityUtils.startActivity((Activity) mContext, intent);
    }

    public void killMyself() {
        dismiss();
    }

    public void showToast(String msg) {
        ToastUtils.showLong(msg);
    }

    public void showToast(int resId) {
        ToastUtils.showShort(resId);
    }
}