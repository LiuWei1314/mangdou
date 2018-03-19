package com.p609915198.fwb.mvp.ui.activity;

import android.content.ComponentName;
import android.media.AudioManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.liulishuo.magicprogresswidget.MagicProgressBar;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.request.GiveGiftRequest;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.basemodule.net.response.GiftListResponse;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.basemodule.widget.CircleImageView;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.OnPlayerEventListener;
import com.p609915198.fwb.app.receive.RemoteControlReceiver;
import com.p609915198.fwb.mvp.contract.PlayContract;
import com.p609915198.fwb.mvp.di.component.DaggerPlayComponent;
import com.p609915198.fwb.mvp.di.module.PlayModule;
import com.p609915198.fwb.mvp.presenter.PlayPresenter;
import com.p609915198.fwb.mvp.ui.dialog.GiftDialog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 播放界面
 * Created by Administrator on 2017/12/26 0026.
 */
public class PlayActivity extends BaseActivity<PlayPresenter> implements PlayContract.View, OnPlayerEventListener {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.iv) ImageView mIv;
    @BindView(R.id.progress_bar) MagicProgressBar mProgressBar;
    @BindView(R.id.iv_pre) ImageView mIvPre;
    @BindView(R.id.iv_play) ImageView mIvPlay;
    //    @BindView(R.id.fl_play) FrameLayout mFlPlay;
    @BindView(R.id.iv_next) ImageView mIvNext;
    @BindView(R.id.civ_head) CircleImageView mCivHead;
    @BindView(R.id.tv_user_name) TextView mTvUserName;
    @BindView(R.id.tv_subscribe_hint) TextView mTvSubscribeHint;
    @BindView(R.id.tv_subscribe) TextView mTvSubscribe;
    @BindView(R.id.tv_audio_name) TextView mTvAudioName;
    @BindView(R.id.tv_play_time) TextView mTvPlayTime;
    @BindView(R.id.iv_reward) ImageView ivReward;

    @Inject Api mApi;

    private Audio mAudio;
    private String mRoomId;
    private RoomDetailResponse mRoomDetail;
    private List<Audio> mAudioList;

    private AudioManager mAudioManager;
    private ComponentName mRemoteReceiver;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerPlayComponent
                .builder()
                .baseComponent(baseComponent)
                .playModule(new PlayModule(this)) //请将PlayModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_play;
    }

    @Override
    protected void initData() {
        mAudioList = (ArrayList) getIntent().getSerializableExtra("audioList");
        mAudio = (Audio) getIntent().getSerializableExtra("audio");
        mRoomId = getIntent().getStringExtra("roomId");
        mRoomDetail = (RoomDetailResponse) getIntent().getSerializableExtra("roomDetail");
        AppConfig.getPlayService().setListener(this);
        if (null != mAudioList && null != mAudio && null != mRoomId && null != AppConfig.getPlayService()) {
            if (AppConfig.getPlayService().isPlaying()) {
                mIvPlay.setImageResource(R.mipmap.ic_pause);
                if (!mAudio.getAudio_id().equals(AppConfig.getPlayService().getPlayingAudio().getAudio_id())) {
                    play();
                }
            } else {
                play();
            }
        }
        if (null != mRoomDetail) {
            Glide.with(this).load(UrlConstant.IMG_ADDRESS + mRoomDetail.getRoom_cover()).into(mIv);
            Glide.with(this).load(UrlConstant.IMG_ADDRESS + mRoomDetail.getRoom_cover()).into(mCivHead);
            mTvUserName.setText(mRoomDetail.getUser_name());
            mTvPlayTime.setText(mAudio.getAudio_length());
            mTvAudioName.setText(mAudio.getAudio_name());
            mTvSubscribeHint.setText("被" + mRoomDetail.getRoom_subscribe() + "人关注");
        }

        registerReceiver();
    }

    public void play() {
        AppConfig.setAudioCache(mAudioList);
        for (int i = 0; i < mAudioList.size(); i++) {
            if (mAudioList.get(i).getAudio_id().equals(mAudio.getAudio_id())) {
                AppConfig.getPlayService().play(i);
                break;
            }
        }
        AppConfig.setRoomDetail(mRoomDetail);
        AppConfig.setRoomId(mRoomId);
    }

    private void registerReceiver() {
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        mRemoteReceiver = new ComponentName(getPackageName(), RemoteControlReceiver.class.getName());
        mAudioManager.registerMediaButtonEventReceiver(mRemoteReceiver);
    }

    @OnClick({R.id.tv_left, R.id.tv_subscribe, R.id.iv_play, R.id.iv_pre, R.id.iv_next, R.id.iv_reward, R.id.iv_gift})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.tv_subscribe:
                ToastUtils.showShort("订阅");
                break;
            case R.id.iv_play:
                AppConfig.getPlayService().playPause();
                break;
            case R.id.iv_pre:
                AppConfig.getPlayService().prev();
                break;
            case R.id.iv_next:
                AppConfig.getPlayService().next();
                break;
            case R.id.iv_reward:
                reward();
                break;
            case R.id.iv_gift:
                gift();
                break;
        }
    }

    public void reward() {

    }

    public void gift() {
        mApi.giftList()
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<List<GiftListResponse>>() {
                        @Override
                        protected void onNext(List<GiftListResponse> result) {
                            GiftDialog dialog = GiftDialog.newInstance((ArrayList<GiftListResponse>) result, (num, data) -> giftNew(num, data));
                            dialog.setDimAmount(0.4F);
                            dialog.show(getSupportFragmentManager());
                        }
                    }, this
            ));
    }

    public void giftNew(int num, GiftListResponse data) {
        GiveGiftRequest request = new GiveGiftRequest();
        request.setCount(num);
        request.setGift_id(data.getGift_id());
        request.setRoom_id(mRoomId);
        request.setUser_id(AppConfig.getUserId());
        request.setAudio_set(mAudio.getAudio_set());
        mApi.giveGift(request)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<HttpResult>() {
                        @Override
                        protected void onNext(HttpResult result) {

                        }
                    }, this
            ));
    }

    @Override
    public void onChange(Audio audio) {
        if (null != mTvPlayTime) {
            mTvPlayTime.setText(audio.getAudio_length());
            mTvAudioName.setText(audio.getAudio_name());
            this.mAudio = audio;
        }
    }

    @Override
    public void onPlayerStart() {
        if (null != mIvPlay) {
            mIvPlay.setImageResource(R.mipmap.ic_pause);
        }
    }

    @Override
    public void onPlayerPause() {
        if (null != mIvPlay) {
            mIvPlay.setImageResource(R.mipmap.ic_home_play);
        }
    }

    @Override
    public void onPublish(int progress) {
        // TODO: 2017/12/29 0029
//        long total = TimeUtils
// .string2Millis(mAudio.getAudio_length(), new SimpleDateFormat("hh:MM:ss"));
//        LogUtils.i("progress / total:" + progress / total);
//        LogUtils.i("progress:" + progress);
//        LogUtils.i("total:" + total);
//        mMagicProgressBar.setSmoothPercent(progress / total);
    }

    @Override
    public void onBufferingUpdate(int percent) {

    }

    @Override
    public void onTimer(long remain) {

    }

    @Override
    public void onAudioListUpdate() {

    }
}
