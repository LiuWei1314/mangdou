package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
public class ListDownloadAdapter2 extends BaseQuickAdapter<Audio, BaseViewHolder> {

    public ListDownloadAdapter2(@Nullable List<Audio> data) {
        super(R.layout.item_play_list, data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, Audio item) {
        helper.setText(R.id.tv_title, item.getAudio_name().replace(".mp3", ""))
              .addOnClickListener(R.id.rl);
    }
}
