package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;
import android.os.Environment;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.PlayListContract;
import com.p609915198.fwb.mvp.ui.activity.PlayActivity;
import com.p609915198.fwb.mvp.ui.adapter.PlayListAdapter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.Call;

/**
 * Created by Administrator on 2017/12/25.
 */
@FragmentScope
public class PlayListPresenter extends BasePresenter<PlayListContract.Model, PlayListContract.View> {
    private PlayListAdapter mPlayListAdapter;
    private List<Audio> mAudios = new ArrayList<>();
    private int currentPage = 0;// 当前页数
    private int pageSize = 20;// 每页级数

    @Inject
    public PlayListPresenter(PlayListContract.Model model, PlayListContract.View rootView) {
        super(model, rootView);
    }

    public void initView(RoomDetailResponse data, String roomId) {
        mPlayListAdapter = new PlayListAdapter(mAudios);
        mPlayListAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.rl:
                    play(mAudios, mAudios.get(position), roomId, data);
                    break;
            }
        });
        // 滑动最后一个Item的时候回调onLoadMoreRequested方法
        mPlayListAdapter.setOnLoadMoreListener(() -> getData(data, roomId), mRootView.getRV());
        mRootView.setAdapter(mPlayListAdapter);
    }

    public void getData(RoomDetailResponse data, String roomId) {
        mModel.audioList(currentPage, pageSize, roomId, AppConfig.getUserId())
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<List<Audio>>() {
                          @Override
                          protected void onNext(List<Audio> audioRespons) {
                              mPlayListAdapter.loadMoreEnd();
                              if (!audioRespons.isEmpty()) {
                                  for (Audio au : audioRespons) {
                                      au.setUsername(data.getUser_name());
                                      au.setUrl(data.getRoom_cover());
                                  }
                                  mAudios.addAll(audioRespons);
                                  mPlayListAdapter.notifyDataSetChanged();

                                  currentPage++;
                              } else {
                                  mRootView.showToast("已经到最后一页了！");
                              }
                          }
                      },
                      mRootView.getActivityImpl(),
                      false
              ));
    }

    public void play(List<Audio> audioList, Audio audio, String roomId, RoomDetailResponse data) {
        if ("0".equals(audio.getAudio_free())) {
            // 收费
            if ("0".equals(audio.getIs_buy())) {
                // 已买
                if (null != AppConfig.getPlayService()) {
                    Intent intent = new Intent(mRootView.getActivityImpl(), PlayActivity.class);
                    intent.putExtra("audioList", (ArrayList) audioList);
                    intent.putExtra("audio", audio);
                    intent.putExtra("roomId", roomId);
                    intent.putExtra("roomDetail", data);
                    mRootView.launchActivity(intent);
                }
            } else {
                // 未买
                if (AppConfig.isLogin()) {
                    ToastUtils.showShort("请先购买！");
                } else {
                    ToastUtils.showShort("请先登录！");
                }
            }
        } else {
            // 免费
            if (null != AppConfig.getPlayService()) {
                Intent intent = new Intent(mRootView.getActivityImpl(), PlayActivity.class);
                intent.putExtra("audioList", (ArrayList) audioList);
                intent.putExtra("audio", audio);
                intent.putExtra("roomId", roomId);
                intent.putExtra("roomDetail", data);
                mRootView.launchActivity(intent);
            }
        }
    }
}
