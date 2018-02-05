package com.p609915198.fwb.mvp.ui.adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.request.SecondaryCategoryRequest;
import com.p609915198.basemodule.net.response.CategoryResponse;
import com.p609915198.basemodule.net.response.SecondaryCategoryResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.ui.activity.RoomsMoreActivity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */
public class ClassifyMenuAdapter extends BaseQuickAdapter<CategoryResponse, BaseViewHolder> {
    public static final int[] icons = new int[]{R.mipmap.ic_book, R.mipmap.ic_bg};
    private Api api;

    public ClassifyMenuAdapter(@Nullable List<CategoryResponse> data, Api mApi) {
        super(R.layout.item_classify_menu, data);
        this.api = mApi;
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryResponse item) {
        helper.setText(R.id.tv, item.getCategory_name());

        if (helper.getAdapterPosition() <= icons.length - 1) {
            Drawable nav_up3 = mContext.getResources().getDrawable(icons[helper.getAdapterPosition()]);
            nav_up3.setBounds(0, 0, nav_up3.getMinimumWidth(), nav_up3.getMinimumHeight());
            TextView tv = helper.getView(R.id.tv);
            tv.setCompoundDrawables(null, nav_up3, null, null);
        }

        SecondaryCategoryRequest request = new SecondaryCategoryRequest();
        request.setCategory_id(item.getCategory_id());
        request.setLength(6);
        api.secondaryCategory(request)
           .subscribe(new ProgressSubscriber<>(
                   new SubscriberOnNextListener<List<SecondaryCategoryResponse>>() {
                       @Override
                       protected void onNext(List<SecondaryCategoryResponse> secondaryCategoryResponses) {
                           RecyclerView recyclerView = helper.getView(R.id.rv);
                           GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
                           gridLayoutManager.setSmoothScrollbarEnabled(true);
                           gridLayoutManager.setAutoMeasureEnabled(true);
                           recyclerView.setLayoutManager(gridLayoutManager);
                           recyclerView.setNestedScrollingEnabled(false);
                           recyclerView.setHasFixedSize(true);
                           ClassifyMenuChildAdapter adapter = new ClassifyMenuChildAdapter(secondaryCategoryResponses);
                           adapter.setOnItemClickListener((adapter1, view, position) -> {
                               Intent intent = new Intent(mContext, RoomsMoreActivity.class);
                               intent.putExtra("labelId", adapter.getData().get(position).getCategory_secondary_id());
                               intent.putExtra("label", adapter.getData().get(position).getCategory_secondary_name());
                               mContext.startActivity(intent);
                           });
                           recyclerView.setAdapter(adapter);
                       }
                   },
                   mContext, false
           ));
    }
}
