package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.RoomsMoreResponse;
import com.p609915198.fwb.R;

import java.util.List;

public class RoomsMoreAdapter extends BaseQuickAdapter<RoomsMoreResponse, BaseViewHolder> {

    public RoomsMoreAdapter(@Nullable List<RoomsMoreResponse> data) {
        super(R.layout.item_rooms_more, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RoomsMoreResponse item) {
        helper.setText(R.id.tv_index, String.valueOf(helper.getLayoutPosition() + 1))
              .setText(R.id.tv_menu1, item.getRoom_name())
              .setText(R.id.tv_menu2, item.getUser_name())
              .setText(R.id.tv_menu3, item.getFrequency());

        ImageView iv = helper.getView(R.id.iv_img);
        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getCover_image()).into(iv);
    }
}