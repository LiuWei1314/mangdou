package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.AlreadyBuyResponse;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

public class AlreadyBuyAdapter extends BaseQuickAdapter<AlreadyBuyResponse, BaseViewHolder> {
    public AlreadyBuyAdapter(@Nullable List<AlreadyBuyResponse> data) {
        super(R.layout.item_already_buy, data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, AlreadyBuyResponse item) {
        helper.setText(R.id.tv_menu1, item.getRoom_name())
                .setText(R.id.tv_menu2, item.getRoom_summary())
                .addOnClickListener(R.id.tv_share)
                .addOnClickListener(R.id.tv_comments);

        ImageView iv = helper.getView(R.id.iv_img);
        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getRoom_cover()).into(iv);
    }
}