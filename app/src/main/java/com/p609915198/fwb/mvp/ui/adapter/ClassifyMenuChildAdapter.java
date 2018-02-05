package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.response.SecondaryCategoryResponse;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by mark.liu on 2017-9-21.
 */
public class ClassifyMenuChildAdapter extends BaseQuickAdapter<SecondaryCategoryResponse, BaseViewHolder> {

    public ClassifyMenuChildAdapter(@Nullable List<SecondaryCategoryResponse> data) {
        super(R.layout.item_classify_menu_child, data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, SecondaryCategoryResponse item) {
        helper.setText(R.id.tv, item.getCategory_secondary_name());
    }
}
