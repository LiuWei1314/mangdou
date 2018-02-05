package com.p609915198.fwb.mvp.ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseDaggerDialog;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.PlayBuyContract;
import com.p609915198.fwb.mvp.di.component.DaggerPlayBuyComponent;
import com.p609915198.fwb.mvp.di.module.PlayBuyModule;
import com.p609915198.fwb.mvp.presenter.PlayBuyPresenter;

import butterknife.BindView;

/**
 * 确认购买/播放购买余额不足/立即购买批量购买/批量购买余额不足
 * Created by Administrator on 2017/11/2.
 */
public class PlayBuyDialog extends BaseDaggerDialog<PlayBuyPresenter> implements PlayBuyContract.View {
    @BindView(R.id.tv_show) TextView mTvShow;
    @BindView(R.id.tv_series) TextView mTvSeries;
    @BindView(R.id.tv_money) TextView mTvMoney;
    @BindView(R.id.tv_buy_now) TextView mTvBuyNow;
    @BindView(R.id.tv_bulk_buy) TextView mTvBulkBuy;
    @BindView(R.id.tv_hint) TextView mTvHint;

    public PlayBuyDialog(@NonNull Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void setupDialogComponent(BaseComponent baseComponent) {
        DaggerPlayBuyComponent
                .builder()
                .baseComponent(baseComponent)
                .playBuyModule(new PlayBuyModule(this)) //请将PlayBuyModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.dialog_play_buy;
    }

    @Override
    protected void initData() {

    }
}
