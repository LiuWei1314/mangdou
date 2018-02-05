package com.p609915198.fwb.mvp.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.response.CategoryResponse;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */
public class ClassifyAdapter extends BaseQuickAdapter<CategoryResponse, BaseViewHolder> {
    public static final int[] icons = new int[]{R.mipmap.ic_child, R.mipmap.ic_love, R.mipmap.ic_life,
            R.mipmap.ic_earn_money, R.mipmap.ic_tuijian, R.mipmap.ic_listen_friend, R.mipmap.ic_host};

    public ClassifyAdapter(List<CategoryResponse> data) {
        super(R.layout.item_classify, data);
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
    }
}
