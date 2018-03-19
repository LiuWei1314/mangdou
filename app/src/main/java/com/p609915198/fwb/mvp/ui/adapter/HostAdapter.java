package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BaseAdapter;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.AnchorListResponse;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by mark.liu on 2017-9-22.
 */
public class HostAdapter extends BaseAdapter<AnchorListResponse, BaseViewHolder> {
    public HostAdapter(@Nullable List<AnchorListResponse> data) {
        super(R.layout.item_works, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AnchorListResponse item) {
        helper.setText(R.id.tv_left, item.getLabel())
              .addOnClickListener(R.id.ll_more);
//                .addOnClickListener(R.id.tv_replace);

        RecyclerView recyclerView = helper.getView(R.id.rv);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 3);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(
                new BaseQuickAdapter<AnchorListResponse.DataBean, BaseViewHolder>(R.layout.item_hot_center_1, item.getData()) {
                    @Override
                    protected void convert(BaseViewHolder helper, AnchorListResponse.DataBean item) {
                        helper.setText(R.id.tv_menu1, item.getUser_name());
                        ImageView iv = helper.getView(R.id.iv_img);
                        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getUser_head()).into(iv);

                        LinearLayout ll = helper.getView(R.id.ll);
                        ll.setOnClickListener(v -> {
                            if (null != mCallBack) {
                                mCallBack.clickListener(item);
                            }
                        });
                    }

                    @Override
                    protected BaseViewHolder createBaseViewHolder(View view) {
                        AutoUtils.auto(view);// 屏幕适配
                        return super.createBaseViewHolder(view);
                    }
                }
        );
    }

    private CallBack mCallBack;

    public void setCallBack(CallBack callBack) {
        this.mCallBack = callBack;
    }

    public interface CallBack {
        void clickListener(AnchorListResponse.DataBean item);
    }
}
