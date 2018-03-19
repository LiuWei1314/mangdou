package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BaseAdapter;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.fwb.R;

import java.util.List;

/**
 * Created by Administrator on 2017/12/27.
 */
public class RoomDetailAdapter extends BaseAdapter<RoomDetailResponse.RoomReplyBean, BaseViewHolder> {
    public RoomDetailAdapter(@Nullable List<RoomDetailResponse.RoomReplyBean> data) {
        super(R.layout.item_room_detail, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RoomDetailResponse.RoomReplyBean item) {
        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getUser_head()).into((ImageView) helper.getView(R.id.civ_head));
        helper.setText(R.id.tv_name, item.getUser_name())
              .setText(R.id.tv_content, item.getUser_reply());
    }
}
