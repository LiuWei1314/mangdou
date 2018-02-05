package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.RoomsListResponse;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by mark.liu on 2017-9-13.
 */
public class HotAdapter extends BaseQuickAdapter<RoomsListResponse, BaseViewHolder> {

    public HotAdapter(List<RoomsListResponse> data) {
        super(R.layout.item_works, data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, RoomsListResponse item) {
        helper.setText(R.id.tv_left, item.getLabel())
              .addOnClickListener(R.id.ll_more);
//                .addOnClickListener(R.id.tv_replace);

        RecyclerView recyclerView = helper.getView(R.id.rv);
        LinearLayoutManager layoutManager;
        if (0 == helper.getLayoutPosition()) {
            layoutManager = new GridLayoutManager(mContext, 3);
        } else {
            layoutManager = new LinearLayoutManager(mContext);
        }
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(createAdapter(item.getData(), helper.getLayoutPosition()));
    }

    public BaseQuickAdapter createAdapter(List<RoomsListResponse.DataBean> data, int type) {
        if (type == 0) {
            return new HotItemAdapter(R.layout.item_hot_center_1, data);
        } else {
            return new HotItemAdapter(R.layout.item_hot_center_2, data);
        }
    }

    public class HotItemAdapter extends BaseQuickAdapter<RoomsListResponse.DataBean, BaseViewHolder> {
        public HotItemAdapter(int layoutResId, @Nullable List<RoomsListResponse.DataBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected BaseViewHolder createBaseViewHolder(View view) {
            AutoUtils.auto(view);// 屏幕适配
            return super.createBaseViewHolder(view);
        }

        @Override
        protected void convert(BaseViewHolder helper, RoomsListResponse.DataBean item) {
            helper.setText(R.id.tv_menu1, item.getRoom_name());
            if (null != helper.getView(R.id.tv_menu2) && null != helper.getView(R.id.tv_menu3)) {
                helper.setText(R.id.tv_menu2, item.getUser_name())
                      .setText(R.id.tv_menu3, item.getFrequency());
            }

            ImageView iv = helper.getView(R.id.iv_img);
            Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getCover_image()).into(iv);

            LinearLayout ll = helper.getView(R.id.ll);
            ll.setOnClickListener(view -> {
                if (null != mCallBack) {
                    mCallBack.clickListener(item);
                }
            });
        }
    }

    private CallBack mCallBack;

    public void setClickListener(CallBack callBack) {
        this.mCallBack = callBack;
    }

    public interface CallBack {
        void clickListener(RoomsListResponse.DataBean item);
    }
}
