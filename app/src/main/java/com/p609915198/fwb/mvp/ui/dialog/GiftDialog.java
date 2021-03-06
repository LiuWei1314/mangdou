package com.p609915198.fwb.mvp.ui.dialog;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.net.response.GiftListResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.ui.adapter.GiftAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.shaohui.bottomdialog.BottomDialog;

/**
 * Created by mark.liu on 2018-3-16.
 */
public class GiftDialog extends BottomDialog implements View.OnClickListener {
    @BindView(R.id.rv_gift) RecyclerView rvGift;
    @BindView(R.id.tv_1) TextView tv1;
    @BindView(R.id.iv_add) ImageView ivAdd;
    @BindView(R.id.tv_num) TextView tvNum;
    @BindView(R.id.iv_remove) ImageView ivRemove;
    @BindView(R.id.tv_charge) TextView tvCharge;

    private GiftAdapter mGiftAdapter;
    private List<GiftListResponse> mList;
    private ChargeListen mChargeListen;

    public static GiftDialog newInstance(ArrayList<GiftListResponse> mList, ChargeListen listen) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("data", mList);
        GiftDialog fragment = new GiftDialog();
        fragment.mChargeListen = listen;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_gift;
    }

    @Override
    public void bindView(View v) {
        rvGift = v.findViewById(R.id.rv_gift);
        tv1 = v.findViewById(R.id.tv_1);
        ivAdd = v.findViewById(R.id.iv_add);
        tvNum = v.findViewById(R.id.tv_num);
        ivRemove = v.findViewById(R.id.iv_remove);
        tvCharge = v.findViewById(R.id.tv_charge);

        mList = getArguments().getParcelableArrayList("data");
        if (null != mList) {
            tv1.setText(caculate(mList.get(0).getGift_price(), Integer.valueOf(tvNum.getText().toString())));

            mGiftAdapter = new GiftAdapter(mList);
            mGiftAdapter.setListner((position, item) -> tv1.setText(caculate(item.getGift_price(), Integer.valueOf(tvNum.getText().toString()))));
            rvGift.setLayoutManager(new GridLayoutManager(getActivity(), 4));
            rvGift.setAdapter(mGiftAdapter);

            ivAdd.setOnClickListener(this::onClick);
            ivRemove.setOnClickListener(this::onClick);
            tvCharge.setOnClickListener(this::onClick);
        }
    }

    @Override
    public void onClick(View view) {
        int num = Integer.valueOf(tvNum.getText().toString());
        switch (view.getId()) {
            case R.id.iv_add:
                num++;
                tvNum.setText(String.valueOf(num));
                if (null != mList) {
                    GiftListResponse gift = mList.get(mGiftAdapter.getSelectPosition());
                    tv1.setText(caculate(gift.getGift_price(), num));
                }
                break;
            case R.id.iv_remove:
                if (num <= 1) {
                    ToastUtils.showLong("数量不能小于1！");
                    return;
                }
                num--;
                tvNum.setText(num + "");

                if (null != mList) {
                    GiftListResponse gift = mList.get(mGiftAdapter.getSelectPosition());
                    tv1.setText(caculate(gift.getGift_price(), num));
                }
                break;
            case R.id.tv_charge:
                if (null != mChargeListen) {
                    mChargeListen.charge(num, mGiftAdapter.getData().get(mGiftAdapter.getSelectPosition()));
                }
                break;
        }
    }

    public String caculate(double price, int count) {
        return "总金额：" + price * count + " 忙豆";
    }

    public interface ChargeListen {
        void charge(int num, GiftListResponse data);
    }
}
