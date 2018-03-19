package com.p609915198.fwb.mvp.ui.adapter;import android.support.annotation.Nullable;import android.widget.ImageView;import com.bumptech.glide.Glide;import com.chad.library.adapter.base.BaseViewHolder;import com.p609915198.basemodule.base.BaseAdapter;import com.p609915198.basemodule.net.UrlConstant;import com.p609915198.basemodule.net.response.GiftListResponse;import com.p609915198.fwb.R;import java.util.List;/** * Created by mark.liu on 2018-3-16. */public class GiftAdapter extends BaseAdapter<GiftListResponse, BaseViewHolder> {    private int position = 0;    private SelectListner mListner;    public GiftAdapter(@Nullable List<GiftListResponse> data) {        super(R.layout.item_gift, data);    }    @Override    protected void convert(BaseViewHolder helper, GiftListResponse item) {        ImageView ivGiftIc = helper.getView(R.id.iv_gift_ic);        Glide.with(mContext).load(UrlConstant.IMG_ADDRESS + item.getGift_cover()).into(ivGiftIc);        helper.setText(R.id.tv_gift_name, item.getGift_name())              .setText(R.id.tv_gift_price, item.getGift_price() + "忙豆")              .setOnClickListener(R.id.ll_gift, view -> {                  if (position != helper.getLayoutPosition()) {                      notifyItemChanged(position);                      position = helper.getLayoutPosition();                      notifyItemChanged(position);                      if (null != mListner) {                          mListner.callBack(helper.getLayoutPosition(), item);                      }                  }              });        if (helper.getLayoutPosition() == position) {            helper.setBackgroundRes(R.id.ll_gift, R.drawable.shape_gift_checked);        } else {            helper.setBackgroundRes(R.id.ll_gift, R.drawable.shape_gift_normal);        }    }    public int getSelectPosition() {        return position;    }    public void setListner(SelectListner listner) {        this.mListner = listner;    }    public interface SelectListner {        void callBack(int position, GiftListResponse item);    }}