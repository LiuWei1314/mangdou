package com.p609915198.fwb.mvp.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.CashFlowHttpResult;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.ExpenseContract;
import com.p609915198.fwb.mvp.di.component.DaggerExpenseComponent;
import com.p609915198.fwb.mvp.di.module.ExpenseModule;
import com.p609915198.fwb.mvp.presenter.ExpensePresenter;
import com.p609915198.fwb.mvp.ui.adapter.ExpenseAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 消费记录
 */
public class ExpenseActivity extends BaseActivity<ExpensePresenter> implements ExpenseContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.rv) RecyclerView rv;

    @Inject Api mApi;

    private ExpenseAdapter mAdapter;
    private List<CashFlowHttpResult.DataBean> data = new ArrayList<>();
    private int currentPage = 1;

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerExpenseComponent
                .builder()
                .baseComponent(baseComponent)
                .expenseModule(new ExpenseModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_expense;
    }

    @Override
    public void initData() {
        tvCenter.setText("消费记录");
        tvCenter.setVisibility(View.VISIBLE);

        mAdapter = new ExpenseAdapter(data);
        mAdapter.setOnLoadMoreListener(() -> getData(currentPage), rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        rv.setAdapter(mAdapter);

        getData(currentPage);
    }

    public void getData(int page) {
        mApi.cashFlow(AppConfig.getUserId(), "1,2,3,", page)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                               new SubscriberOnNextListener<CashFlowHttpResult>() {
                                   @Override
                                   protected void onNext(CashFlowHttpResult cashFlowHttpResult) {
                                       if (null != cashFlowHttpResult.getData() && !cashFlowHttpResult.getData().isEmpty()) {
                                           mAdapter.addData(cashFlowHttpResult.getData());
                                       }
                                       if (currentPage < cashFlowHttpResult.getLast_page()) {
                                           currentPage++;
                                           mAdapter.loadMoreComplete();
                                       } else {
                                           mAdapter.loadMoreEnd();
                                       }
                                   }
                               }, this
                       )
            );
    }

    @OnClick(R.id.tv_left)
    public void onViewClicked() {killMyself();}
}
