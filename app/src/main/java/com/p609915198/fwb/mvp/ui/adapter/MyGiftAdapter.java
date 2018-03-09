package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.MyGiftResponse;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
public class MyGiftAdapter extends BaseQuickAdapter<MyGiftResponse, BaseViewHolder> {
    public MyGiftAdapter(@Nullable List<MyGiftResponse> data) {
        super(R.layout.item_my_gift, data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyGiftResponse item) {
        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getUser_head()).into((ImageView) helper.getView(R.id.civ_head));
        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getGift_cover()).into((ImageView) helper.getView(R.id.civ_room_cover));

        helper.setText(R.id.tv_1, "我给" + item.getUser_name() + "送了" + item.getGift_name())
              .setText(R.id.tv_2, item.getAudio_name());
    }
}
