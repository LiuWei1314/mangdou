package com.p609915198.fwb.mvp.ui.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.fwb.R;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Administrator on 2018/1/8.
 */
public class PayDialog extends BaseBottomDialog {
    ImageView ivClose;
    TextView tvMoney;
    TextView tvBean;
    ImageView ivAli;
    ImageView ivAliPay;
    ImageView ivWx;
    ImageView ivWxPay;
    Button btPay;

    private int payWay = 0;// 0 = 支付宝支付 | 1 = 微信支付
    private PayListener mPayListener;
    private RoomDetailResponse mRoomDetailResponse;
    private double money;

    public static PayDialog newInstance(RoomDetailResponse roomDetailResponse) {
        Bundle args = new Bundle();
        args.putSerializable("roomDetailResponse", roomDetailResponse);
        PayDialog fragment = new PayDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_pay;
    }

    @Override
    public void bindView(View v) {
        initViews(v);
        initData();
        initEvents();
    }

    public void initViews(View view) {
        ivClose = view.findViewById(R.id.iv_close);
        tvMoney = view.findViewById(R.id.tv_money);
        tvBean = view.findViewById(R.id.tv_bean);
        ivAli = view.findViewById(R.id.iv_ali);
        ivAliPay = view.findViewById(R.id.iv_ali_pay);
        ivWx = view.findViewById(R.id.iv_wx);
        ivWxPay = view.findViewById(R.id.iv_wx_pay);
        btPay = view.findViewById(R.id.bt_pay);
    }

    private void initData() {
        mRoomDetailResponse = (RoomDetailResponse) getArguments().getSerializable("roomDetailResponse");
        if (null != mRoomDetailResponse) {
            money = Double.valueOf(mRoomDetailResponse.getRoom_price());
            tvMoney.setText("￥" + money + "元");
            tvBean.setText(money + "忙豆");
        }
    }

    private void initEvents() {
        btPay.setOnClickListener(view -> {
            if (null != mPayListener) {
                mPayListener.pay(money, payWay);
            }
        });
        ivAliPay.setOnClickListener(view -> {
            if (0 != payWay) {
                ivAliPay.setImageResource(R.mipmap.ic_checked_pay);
                ivWxPay.setImageResource(R.mipmap.ic_normal_pay);
                payWay = 0;
            }
        });
        ivWxPay.setOnClickListener(view -> {
            if (1 != payWay) {
                ivWxPay.setImageResource(R.mipmap.ic_checked_pay);
                ivAliPay.setImageResource(R.mipmap.ic_normal_pay);
                payWay = 1;
            }
        });
        ivClose.setOnClickListener(view -> dismiss());
    }

    public void setPayListener(PayListener payListener) {
        mPayListener = payListener;
    }

    public interface PayListener {
        void pay(double money, int payWay);
    }
}
