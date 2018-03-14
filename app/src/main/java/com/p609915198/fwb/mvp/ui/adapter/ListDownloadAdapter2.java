package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
public class ListDownloadAdapter2 extends BaseQuickAdapter<Audio, BaseViewHolder> {
    private List<Boolean> checkList = new ArrayList<>();

    public ListDownloadAdapter2(@Nullable List<Audio> data) {
        super(R.layout.item_list_download_2, data);

        for (Audio audio : data) {
            checkList.add(false);
        }
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, Audio item) {
        helper.setText(R.id.tv_title, item.getAudio_name().replace(".mp3", ""))
              .setImageResource(R.id.iv_choose, checkList.get(helper.getLayoutPosition()) ? R.drawable.ic_checked : R.drawable.ic_buy)
              .setOnClickListener(R.id.iv_choose, v -> {
                  checkList.set(helper.getLayoutPosition(), !checkList.get(helper.getLayoutPosition()));
                  notifyItemChanged(helper.getLayoutPosition());
              });
    }

    public void setCheck(boolean check) {
        for (int i = 0; i < getData().size(); i++) {
            checkList.set(i, check);
        }
        notifyDataSetChanged();
    }

    public List<Boolean> getCheck() {
        return checkList;
    }
}
