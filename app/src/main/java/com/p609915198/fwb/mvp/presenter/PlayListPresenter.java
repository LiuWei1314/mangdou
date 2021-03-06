package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.basemodule.net.response.TopResponse;
import com.p609915198.basemodule.net.response.UserBaseInfoResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.PlayListContract;
import com.p609915198.fwb.mvp.ui.activity.PlayActivity;
import com.p609915198.fwb.mvp.ui.activity.RechargeActivity;
import com.p609915198.fwb.mvp.ui.adapter.PlayListAdapter;
import com.p609915198.fwb.utils.PayUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/25.
 */
@FragmentScope
public class PlayListPresenter extends BasePresenter<PlayListContract.Model, PlayListContract.View> {
    private PlayListAdapter mPlayListAdapter;
    private List<Audio> mAudios = new ArrayList<>();
    private int currentPage = 0;// 当前页数
    private int pageSize = 20;// 每页级数

    @Inject Api mApi;

    @Inject
    public PlayListPresenter(PlayListContract.Model model, PlayListContract.View rootView) {
        super(model, rootView);
    }

    public void initView(RoomDetailResponse data, String roomId) {
        mPlayListAdapter = new PlayListAdapter(mAudios);
        mPlayListAdapter.setListener(audio -> buyAudio(Double.valueOf(audio.getPrice())));
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
                              if (!audioRespons.isEmpty()) {
                                  if (null != audioRespons.get(0)) {
                                      mRootView.setTotalNum(audioRespons.get(0).getAudio_sum());
                                  }

                                  for (Audio au : audioRespons) {
                                      if (null != au) {
                                          au.setUsername(data.getUser_name());
                                          au.setUrl(data.getRoom_cover());
                                      }
                                  }
                                  mAudios.addAll(audioRespons);

                                  currentPage++;
                                  mPlayListAdapter.loadMoreComplete();
                              } else {
                                  mRootView.showToast("已经到最后一页了！");
                                  mPlayListAdapter.loadMoreEnd();
                              }
                          }

                          @Override
                          public void onError(Throwable e) {
                              mPlayListAdapter.loadMoreFail();
                          }
                      },
                      mRootView.getActivityImpl(),
                      false
              ));
    }

    public void play(List<Audio> audioList, Audio audio, String roomId, RoomDetailResponse data) {
        if ("0".equals(audio.getAudio_free())) {
            // 收费
            if ("1".equals(audio.getIs_buy())) {
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
                    buyAudio(Double.valueOf(audio.getPrice()));
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

    private void buyAudio(double price) {
        mApi.userBaseInfo(AppConfig.getUserId())
            .compose(RxUtils.bindToLifecycle(mRootView))
            .subscribe(new ProgressSubscriber(new SubscriberOnNextListener<UserBaseInfoResponse>() {
                @Override
                protected void onNext(UserBaseInfoResponse userBaseInfoResponse) {
                    mApi.top(AppConfig.getUserId())
                        .compose(RxUtils.bindToLifecycle(mRootView))
                        .subscribe(new ProgressSubscriber(
                                new SubscriberOnNextListener<TopResponse>() {
                                    @Override
                                    protected void onNext(TopResponse response) {
                                        double volley = Double.valueOf(userBaseInfoResponse.getUser_volley());// 余额
                                        double reallyPrice = price;
                                        if (response.getData().getVip_level() >= 3) {
                                            switch (response.getData().getVip_level()) {
                                                case 0:
                                                case 1:
                                                case 2:
                                                    break;
                                                case 3:
                                                    reallyPrice *= 0.9;
                                                    // 9折
                                                    break;
                                                case 4:
                                                    // 8折
                                                    reallyPrice *= 0.8;
                                                    break;
                                                case 5:
                                                    // 7折
                                                    reallyPrice *= 0.7;
                                                    break;
                                            }
                                        }
                                        if (volley >= reallyPrice) {
                                            PayUtil.buy(mRootView.getActivityImpl(), mApi, ((Fragment) mRootView).getFragmentManager(), reallyPrice);
                                        } else {
                                            Intent intent = new Intent(mRootView.getActivityImpl(), RechargeActivity.class);
                                            intent.putExtra("money", reallyPrice - volley);
                                            mRootView.launchActivity(intent);
                                        }
                                    }
                                },
                                mRootView.getActivityImpl(),
                                false
                        ));
                }
            }, mRootView.getActivityImpl()));
    }
}
