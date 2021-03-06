package com.p609915198.fwb.mvp.ui.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.p609915198.basemodule.net.response.HotKeywordsResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.widget.flowLayout.FlowLayout;
import com.p609915198.fwb.widget.flowLayout.TagAdapter;

import java.util.List;

/**
 * Created by mark.liu on 2018-5-30.
 */
public class HotKeywordsAdapter extends TagAdapter<HotKeywordsResponse> {
    private Context mContext;

    public HotKeywordsAdapter(List<HotKeywordsResponse> datas, Context context) {
        super(datas);
        this.mContext = context;
    }

    @Override
    public View getView(FlowLayout parent, int position, HotKeywordsResponse hotKeywordsResponse) {
        TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.layout_tag_adapter, null, false);
        tv.setText(hotKeywordsResponse.getKeywords());
        return tv;
    }
}
