package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.SecondaryCategoryResponse;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * 二级界面
 * Created by Administrator on 2017/12/21 0021.
 */
public class SecondaryCategoryAdapter extends BaseQuickAdapter<SecondaryCategoryResponse, BaseViewHolder> {
    public SecondaryCategoryAdapter(@Nullable List<SecondaryCategoryResponse> data) {
        super(R.layout.item_rooms_more, data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, SecondaryCategoryResponse item) {
        helper.setText(R.id.tv_index, String.valueOf(helper.getLayoutPosition() + 1))
              .setText(R.id.tv_menu1, item.getCategory_secondary_name());

        Glide.with(mContext)
             .load(UrlConstant.IMG_ADDRESS + item.getCover_image())
             .into((ImageView) helper.getView(R.id.iv_img));
    }
}
