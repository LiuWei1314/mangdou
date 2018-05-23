package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BaseAdapter;
import com.p609915198.fwb.R;

import java.util.List;

/**
 * Created by mark.liu on 2018-4-18.
 */
public class RechargeAdapter extends BaseAdapter<Integer, BaseViewHolder> {

    public RechargeAdapter(@Nullable List<Integer> data) {
        super(R.layout.item_recharge, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        helper.setText(R.id.tv_money, item + "元")
              .setText(R.id.tv_mangdou, item + "忙豆");
    }
}
