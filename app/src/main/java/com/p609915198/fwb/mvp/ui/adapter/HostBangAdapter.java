package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BaseAdapter;
import com.p609915198.basemodule.net.response.BangResponse;
import com.p609915198.fwb.R;

import java.util.List;

/**
 * Created by mark.liu on 2018-3-20.
 */
public class HostBangAdapter extends BaseAdapter<BangResponse.DataBean.NormalBean, BaseViewHolder> {
    public HostBangAdapter(@Nullable List<BangResponse.DataBean.NormalBean> data) {
        super(R.layout.item_host_bang, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BangResponse.DataBean.NormalBean item) {

    }
}
