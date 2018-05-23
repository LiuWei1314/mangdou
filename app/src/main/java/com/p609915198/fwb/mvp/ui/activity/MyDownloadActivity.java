package com.p609915198.fwb.mvp.ui.activity;

import android.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arialyy.annotations.Download;
import com.arialyy.annotations.DownloadGroup;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupTask;
import com.arialyy.aria.core.download.DownloadTask;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.MyDownloadContract;
import com.p609915198.fwb.mvp.di.component.DaggerMyDownloadComponent;
import com.p609915198.fwb.mvp.di.module.MyDownloadModule;
import com.p609915198.fwb.mvp.presenter.MyDownloadPresenter;
import com.p609915198.fwb.mvp.ui.adapter.DownloadAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的下载
 * Created by Administrator on 2018/2/26.
 */
public class MyDownloadActivity extends BaseActivity<MyDownloadPresenter> implements MyDownloadContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.rv) RecyclerView rv;
    @BindView(R.id.tv_all_continue) TextView mTvAllContinue;
    @BindView(R.id.tv_all_clean) TextView mTvAllClean;

    private DownloadAdapter mAdapter;
    private List<DownloadEntity> mAudioList = new ArrayList<>();

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerMyDownloadComponent
                .builder()
                .baseComponent(baseComponent)
                .myDownloadModule(new MyDownloadModule(this)) //请将MyDownloadModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_my_download;
    }

    @Override
    protected void initData() {
        tvCenter.setVisibility(View.VISIBLE);
        tvCenter.setText("我的下载");

        mAdapter = new DownloadAdapter(mAudioList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        rv.setAdapter(mAdapter);
        if (null != Aria.download(this).getTaskList()) {
            mAudioList.clear();
            mAudioList.addAll(Aria.download(this).getTaskList());
            mAdapter.notifyDataSetChanged();
        }
    }

    @OnClick({R.id.tv_all_continue, R.id.tv_all_clean, R.id.tv_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.tv_all_continue:
                if (null != Aria.download(this).getAllNotCompletTask() && Aria.download(this).getAllNotCompletTask().isEmpty()) {
                    // 全部下载完毕
                    mTvAllContinue.setText("全部继续");
                    Aria.download(this).resumeAllTask();
                } else {
                    // 还有未下完
                    mTvAllContinue.setText("全部暂停");
                    Aria.download(this).stopAllTask();
                }
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.tv_all_clean:
                if (null != Aria.download(this).getTaskList() && !Aria.download(this).getTaskList().isEmpty()) {
                    new AlertDialog.Builder(this)
                            .setTitle("确认删除所有音频？")
                            .setPositiveButton("确定", (dialogInterface, i) -> {
                                for (DownloadEntity entity : Aria.download(this).getTaskList()) {
                                    Aria.download(this).load(entity.getUrl()).removeRecord();
                                }
                                Aria.download(this).removeAllTask(true);
                                mAudioList.clear();
                                mAdapter.notifyDataSetChanged();
                            })
                            .setNegativeButton("取消", (dialogInterface, i) -> dialogInterface.dismiss())
                            .show();
                }
                break;
        }
    }

    @Download.onTaskRunning
    void running(DownloadTask task) {
        mAudioList.clear();
        mAudioList.addAll(Aria.download(this).getTaskList());
        if (null != Aria.download(this).getTaskList()) {
            for (int i = 0; i < Aria.download(this).getTaskList().size(); i++) {
                DownloadEntity entity = Aria.download(this).getTaskList().get(i);
                if (task.getKey().equals(entity.getUrl())) {
                    ProgressBar progressBar = (ProgressBar) mAdapter.getViewByPosition(rv, i, R.id.pb_download);
                    if (null != progressBar) {
                        progressBar.setProgress(task.getPercent());
                    }
                }
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Download.onTaskComplete
    void taskComplete(DownloadTask task) {
        mAudioList.clear();
        mAudioList.addAll(Aria.download(this).getTaskList());
        mAdapter.notifyDataSetChanged();
    }

    @DownloadGroup.onTaskComplete
    void taskComplete(DownloadGroupTask task) {
        mTvAllContinue.setText("全部继续");
    }
}
