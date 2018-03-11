package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
public class ListDownloadAdapter1 extends BaseQuickAdapter<String, BaseViewHolder> {
    private int totalCount = 0;

    public ListDownloadAdapter1(@Nullable List<String> data, int totalCount) {
        super(R.layout.item_list_download_1, data);

        this.totalCount = totalCount;
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        int start = helper.getAdapterPosition() * 20 + 1;
        int end = (helper.getAdapterPosition() + 1) * 20 > totalCount ? totalCount : (helper.getAdapterPosition() + 1) * 20;
        helper.setText(R.id.tv, start + "~" + end);
    }
}
