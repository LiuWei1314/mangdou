package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.MyAwardResponse;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
public class MyRewardAdapter extends BaseQuickAdapter<MyAwardResponse, BaseViewHolder> {

    public MyRewardAdapter(@Nullable List<MyAwardResponse> data) {
        super(R.layout.item_my_reward, data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyAwardResponse item) {
        ImageView iv = helper.getView(R.id.cv_head);
        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getRoom_cover()).into(iv);

        helper.setText(R.id.tv, item.getAward_time() + " 我打赏了该专辑 " + item.getAward_quantity() + "元")
              .setText(R.id.tv_title, item.getRoom_name())
              .setText(R.id.tv_content, item.getRoom_summary());
    }
}
