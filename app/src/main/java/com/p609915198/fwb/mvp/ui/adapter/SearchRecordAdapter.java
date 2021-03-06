package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BaseAdapter;
import com.p609915198.fwb.R;

import java.util.List;

/**
 * Created by mark.liu on 2018-6-1.
 */
public class SearchRecordAdapter extends BaseAdapter<String, BaseViewHolder> {
    public SearchRecordAdapter(@Nullable List<String> data) {
        super(R.layout.item_search_record, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_content, item)
              .addOnClickListener(R.id.iv_delete);
    }
}
