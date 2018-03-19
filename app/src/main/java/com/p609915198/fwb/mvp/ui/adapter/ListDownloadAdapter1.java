package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BaseAdapter;
import com.p609915198.fwb.R;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
public class ListDownloadAdapter1 extends BaseAdapter<String, BaseViewHolder> {
    private int totalCount = 0;
    private int selectPosition = 0;
    private CallBack mCallBack;

    public ListDownloadAdapter1(@Nullable List<String> data, int totalCount) {
        super(R.layout.item_list_download_1, data);

        this.totalCount = totalCount;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv, item);

        if (selectPosition == helper.getLayoutPosition()) {
            helper.setTextColor(R.id.tv, mContext.getResources().getColor(R.color.white))
                  .setBackgroundColor(R.id.tv, mContext.getResources().getColor(R.color.main_color));
        } else {
            helper.setTextColor(R.id.tv, mContext.getResources().getColor(R.color.text33))
                  .setBackgroundColor(R.id.tv, mContext.getResources().getColor(R.color.white));
        }

        helper.setOnClickListener(R.id.tv, v -> {
            selectPosition = helper.getLayoutPosition();
            notifyDataSetChanged();
            if (null != mCallBack) {
                mCallBack.select(selectPosition);
            }
        });
    }

    public void setCallBack(CallBack callBack) {
        mCallBack = callBack;
    }

    public interface CallBack {
        void select(int position);
    }
}
