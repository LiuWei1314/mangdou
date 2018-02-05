package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.AnchorMoreResponse;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

public class AnchorMoreAdapter extends BaseQuickAdapter<AnchorMoreResponse, BaseViewHolder> {

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    public AnchorMoreAdapter(@Nullable List<AnchorMoreResponse> data) {
        super(R.layout.item_anchor_more, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AnchorMoreResponse item) {
        helper.setText(R.id.tv_name, item.getUser_name())
              .setText(R.id.tv_subscribe_hint, item.getUser_summary())
              .addOnClickListener(R.id.tv_subscribe);

        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getUser_head()).into((ImageView) helper.getView(R.id.civ_head));
    }
}