package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.MyReceiveAwardResponse;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/3/11.
 */
public class MyReceiveRewardAdapter extends BaseQuickAdapter<MyReceiveAwardResponse, BaseViewHolder> {

    public MyReceiveRewardAdapter(@Nullable List<MyReceiveAwardResponse> data) {
        super(R.layout.item_my_reward, data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyReceiveAwardResponse item) {
        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getRoom_cover()).into((ImageView) helper.getView(R.id.cv_head));
        helper.setText(R.id.tv, item.getAward_time() + " " + item.getUser_name() + " 打赏了我该章节" + item.getAward_quantity() + "元")
              .setText(R.id.tv_title, item.getRoom_name())
              .setText(R.id.tv_content, item.getRoom_summary());
    }
}
