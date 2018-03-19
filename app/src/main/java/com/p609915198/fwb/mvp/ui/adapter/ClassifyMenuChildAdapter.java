package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BaseAdapter;
import com.p609915198.basemodule.net.response.SecondaryCategoryResponse;
import com.p609915198.fwb.R;

import java.util.List;

/**
 * Created by mark.liu on 2017-9-21.
 */
public class ClassifyMenuChildAdapter extends BaseAdapter<SecondaryCategoryResponse, BaseViewHolder> {

    public ClassifyMenuChildAdapter(@Nullable List<SecondaryCategoryResponse> data) {
        super(R.layout.item_classify_menu_child, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SecondaryCategoryResponse item) {
        helper.setText(R.id.tv, item.getCategory_secondary_name());
    }
}
