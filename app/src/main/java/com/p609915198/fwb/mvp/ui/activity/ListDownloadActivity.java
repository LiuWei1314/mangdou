package com.p609915198.fwb.mvp.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.arialyy.aria.core.Aria;
import com.jakewharton.rxbinding2.widget.RxCompoundButton;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.ListDownloadContract;
import com.p609915198.fwb.mvp.di.component.DaggerListDownloadComponent;
import com.p609915198.fwb.mvp.di.module.ListDownloadModule;
import com.p609915198.fwb.mvp.presenter.ListDownloadPresenter;
import com.p609915198.fwb.mvp.ui.adapter.ListDownloadAdapter1;
import com.p609915198.fwb.mvp.ui.adapter.ListDownloadAdapter2;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.p609915198.basemodule.net.UrlConstant.DOWNLOAD_ADDRESS;

/**
 * 批量下载
 */
public class ListDownloadActivity extends BaseActivity<ListDownloadPresenter> implements ListDownloadContract.View {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.tv_total_num) TextView tvTotalNum;
    @BindView(R.id.tv_choose) TextView tvChoose;
    @BindView(R.id.rv_1) RecyclerView rv1;
    @BindView(R.id.rv_2) RecyclerView rv2;
    @BindView(R.id.cb_choose_all) CheckBox cbChooseAll;
    @BindView(R.id.tv_download) TextView tvDownload;

    private ListDownloadAdapter1 mAdapter1;
    private ListDownloadAdapter2 mAdapter2;
    private String roomId;
    private RoomDetailResponse data;

    @Inject Api mApi;

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerListDownloadComponent
                .builder()
                .baseComponent(baseComponent)
                .listDownloadModule(new ListDownloadModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_list_download;
    }

    @Override
    public void initData() {
        tvCenter.setText("批量下载");
        tvCenter.setVisibility(View.VISIBLE);
        tvRight.setText("查看下载");
        tvRight.setVisibility(View.VISIBLE);

        RxCompoundButton.checkedChanges(cbChooseAll).subscribe(aBoolean -> {
            if (null != mAdapter2) {
                mAdapter2.setCheck(aBoolean);
            }
        });

        roomId = getIntent().getStringExtra("roomId");
        data = (RoomDetailResponse) getIntent().getSerializableExtra("data");
        if (!TextUtils.isEmpty(roomId)) {
            getTotalPage();

            getData(0, 20, roomId);
        }
    }

    public void getTotalPage() {
        mApi.audioList(0, 20, roomId, AppConfig.getUserId())
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<List<Audio>>() {
                        @Override
                        protected void onNext(List<Audio> audioRespons) {
                            if (!audioRespons.isEmpty()) {
                                int totalCount = audioRespons.get(0).getAudio_sum();
                                tvTotalNum.setText("共" + totalCount + "集");

                                List<String> data = new ArrayList<>();
                                int totalPage = totalCount % 20 == 0 ? totalCount / 20 : totalCount / 20 + 1;
                                for (int i = 0; i < totalPage; i++) {
                                    int start = i * 20 + 1;
                                    int end = (i + 1) * 20 > totalCount ? totalCount : (i + 1) * 20;
                                    data.add(start + "~" + end);
                                }
                                mAdapter1 = new ListDownloadAdapter1(data, totalCount);
                                mAdapter1.setCallBack(position -> {
                                    tvChoose.setText("选集(" + data.get(position) + ")");
                                    getData(position, 20, roomId);
                                    cbChooseAll.setChecked(false);
                                });
                                rv1.setLayoutManager(new GridLayoutManager(ListDownloadActivity.this, 4));
                                rv1.setAdapter(mAdapter1);
                            }
                        }
                    },
                    this,
                    false
            ));
    }

    public void getData(int page, int pageSize, String roomId) {
        mApi.audioList(page, pageSize, roomId, AppConfig.getUserId())
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<List<Audio>>() {
                        @Override
                        protected void onNext(List<Audio> audioRespons) {
                            if (!audioRespons.isEmpty()) {
                                mAdapter2 = new ListDownloadAdapter2(audioRespons);
                                rv2.setLayoutManager(new LinearLayoutManager(ListDownloadActivity.this));
                                rv2.addItemDecoration(new DividerItemDecoration(ListDownloadActivity.this, DividerItemDecoration.VERTICAL_LIST));
                                rv2.setAdapter(mAdapter2);

                                rv1.setVisibility(View.GONE);
                            }
                        }
                    },
                    this,
                    true
            ));
    }

    @OnClick({R.id.tv_left, R.id.tv_download, R.id.tv_choose, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.tv_download:
                download();
                break;
            case R.id.tv_choose:
                if (rv1.getVisibility() == View.GONE) {
                    rv1.setVisibility(View.VISIBLE);
                } else {
                    rv1.setVisibility(View.GONE);
                }
                break;
            case R.id.tv_right:
                launchActivity(new Intent(this, MyDownloadActivity.class));
                break;
        }
    }

    public void download() {
        showToast("开始批量下载！");
        List<Boolean> list = mAdapter2.getCheck();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)) {
                Audio audio = mAdapter2.getData().get(i);

                Aria.download(this)
                    .load(UrlConstant.AUDIO_ADDRESS + audio.getAudio_path().replace("\\", ""))     //读取下载地址
                    .setFilePath(DOWNLOAD_ADDRESS + "/" + audio.getAudio_name() + ".mp3") //设置文件保存的完整路径
                    .setExtendField(JSONObject.toJSONString(audio))
                    .start();   //启动下载
            }
        }
    }
}
