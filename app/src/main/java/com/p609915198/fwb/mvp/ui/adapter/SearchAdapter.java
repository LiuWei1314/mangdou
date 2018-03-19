package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BaseAdapter;
import com.p609915198.basemodule.net.response.SearchResponse;

import java.util.List;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
public class SearchAdapter extends BaseAdapter<SearchResponse, BaseViewHolder> {
    public SearchAdapter(@Nullable List<SearchResponse> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchResponse item) {

    }
}
