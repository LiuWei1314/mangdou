package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BaseAdapter;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.AnchorDetailResponse;
import com.p609915198.fwb.R;

import java.util.List;

/**
 * Created by mark.liu on 2018-5-22.
 */
public class AnchorDetailAdapter extends BaseAdapter<AnchorDetailResponse.ClassicsWorksBean, BaseViewHolder> {
    public AnchorDetailAdapter(@Nullable List<AnchorDetailResponse.ClassicsWorksBean> data) {
        super(R.layout.item_activity_detail, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AnchorDetailResponse.ClassicsWorksBean item) {
        helper.setText(R.id.tv_menu1, item.getRoom_name())
              .setText(R.id.tv_menu2, item.getUser_name())
              .setText(R.id.tv_menu3, item.getRoom_views());

        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getRoom_cover()).into((ImageView) helper.getView(R.id.iv_img));
    }
}
