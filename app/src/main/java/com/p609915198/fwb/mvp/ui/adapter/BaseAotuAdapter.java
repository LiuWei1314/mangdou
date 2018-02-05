package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * 屏幕适配基类Adapter
 * Created by Administrator on 2017/12/21 0021.
 */
public abstract class BaseAotuAdapter extends BaseQuickAdapter {

    public BaseAotuAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    public BaseAotuAdapter(@Nullable List data) {
        super(data);
    }

    public BaseAotuAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }
}
