package com.p609915198.basemodule.base;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.di.component.BaseComponent;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by mark.liu on 2017-5-16.
 */
public abstract class BaseDaggerDialog<P extends IPresenter> extends Dialog {
    protected Context mContext;
    protected Activity mActivity;
    protected BaseApplication mApplication;
    @Inject
    protected P mPresenter;
    private ProgressDialog progressDialog;

    public BaseDaggerDialog(@NonNull Context context) {
        super(context);
        mContext = context;
        mActivity = (BaseActivity) mContext;
    }

    public BaseDaggerDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        mContext = context;
        mActivity = (BaseActivity) mContext;
    }

    protected BaseDaggerDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        mContext = context;
        mActivity = (BaseActivity) mContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (BaseApplication) BaseApplication.getContext();
        if (useEventBus())// 如果要使用eventbus请将此方法返回true
            EventBus.getDefault().register(this);// 注册到事件主线
        setContentView(getLayoutRes());
        ButterKnife.bind(this);// 绑定到butterknife
        setupDialogComponent(mApplication.getBaseComponent());// 依赖注入
        initData();
    }

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupDialogComponent(BaseComponent baseComponent);

    /**
     * 是否使用eventBus,默认为使用(false)，
     */
    protected boolean useEventBus() {
        return false;
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract void initData();

    public void launchActivity(@NonNull Intent intent) {ActivityUtils.startActivity(mActivity, intent);}

    public void killMyself() {
        ActivityUtils.finishActivity(mActivity, true);
    }

    public void showToast(String msg) {
        ToastUtils.showLong(msg);
    }

    public void showToast(int resId) {ToastUtils.showShort(resId);}
}
