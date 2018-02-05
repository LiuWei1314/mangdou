package com.p609915198.basemodule.base;


import android.content.Context;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by mark on 2017/05/08.
 */
public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {
    protected final String TAG = this.getClass().getSimpleName();
    protected Context mContext;

    protected M mModel;
    protected V mRootView;

    public BasePresenter(M model, V rootView) {
        this.mModel = model;
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter(V rootView) {
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter() {
        onStart();
    }

    @Override
    public void onStart() {
        //如果要使用eventbus请将此方法返回true
        if (useEventBus()) {
            EventBus.getDefault().register(this);//注册eventbus
        }
        mContext = BaseApplication.getContext();
    }

    @Override
    public void onDestroy() {
        //如果要使用eventbus请将此方法返回true
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);//解除注册eventbus
        }
        if (mModel != null) {
            mModel.onDestroy();
            this.mModel = null;
        }
        this.mRootView = null;
    }

    /**
     * 是否使用eventBus,默认为使用(false)，
     *
     * @return
     */
    protected boolean useEventBus() {
        return false;
    }
}