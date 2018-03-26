package com.p609915198.fwb.mvp.ui.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.fwb.R;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Administrator on 2018/1/8.
 */
public class PayDialog extends BaseBottomDialog {
    private ImageView ivClose;
    private TextView tvMoney;
    private TextView tvBean;
    private ImageView ivAli;
    private ImageView ivAliPay;
    private ImageView ivWx;
    private ImageView ivWxPay;
    private Button btPay;

    private int payWay = 0;// 0 = 支付宝支付 | 1 = 微信支付
    private PayListener mPayListener;
    private double money;

    public static PayDialog newInstance(double money) {
        Bundle args = new Bundle();
        args.putDouble("money", money);
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
        money = getArguments().getDouble("money", 0);
        tvMoney.setText("￥" + money + "元");
        tvBean.setText(money + "忙豆");
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
