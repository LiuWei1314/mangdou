package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BaseAdapter;
import com.p609915198.basemodule.net.response.ZhuBoBangResponse;
import com.p609915198.fwb.R;

import java.util.List;

/**
 * Created by mark.liu on 2018-3-20.
 */
public class HostBangAdapter extends BaseAdapter<ZhuBoBangResponse.DataBean.NormalBean, BaseViewHolder> {
    public HostBangAdapter(@Nullable List<ZhuBoBangResponse.DataBean.NormalBean> data) {
        super(R.layout.item_host_bang, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhuBoBangResponse.DataBean.NormalBean item) {
        helper.setText(R.id.tv_name, item.getName())
              .setText(R.id.tv_num, String.valueOf(item.getFavor()));

        Glide.with(mContext).load(item.getImage_path()).into((ImageView) helper.getView(R.id.civ_head));

        switch (helper.getLayoutPosition()) {
            case 0:
                helper.setVisible(R.id.tv_index, false)
                      .setVisible(R.id.iv_index, true)
                      .setImageResource(R.id.iv_index, R.mipmap.ic_first);
                break;
            case 1:
                helper.setVisible(R.id.tv_index, false)
                      .setVisible(R.id.iv_index, true)
                      .setImageResource(R.id.iv_index, R.mipmap.ic_second);
                break;
            case 2:
                helper.setVisible(R.id.tv_index, false)
                      .setVisible(R.id.iv_index, true)
                      .setImageResource(R.id.iv_index, R.mipmap.ic_third);
                break;
            default:
                helper.setVisible(R.id.tv_index, true)
                      .setVisible(R.id.iv_index, false)
                      .setText(R.id.tv_index, String.valueOf(helper.getLayoutPosition() + 1));
                break;
        }
    }
}
