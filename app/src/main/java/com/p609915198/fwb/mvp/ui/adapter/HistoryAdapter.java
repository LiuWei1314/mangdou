package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.GetPlayRecordResponse;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/2/6.
 */
public class HistoryAdapter extends BaseQuickAdapter<GetPlayRecordResponse, BaseViewHolder> {
    public HistoryAdapter(@Nullable List<GetPlayRecordResponse> data) {
        super(R.layout.item_hot_center_2, data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, GetPlayRecordResponse item) {
        helper.setText(R.id.tv_menu1, item.getRoom_name())
              .setText(R.id.tv_menu2, item.getUser_name());

        ImageView iv = helper.getView(R.id.iv_img);
        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getRoom_blurcover()).into(iv);
    }
}
