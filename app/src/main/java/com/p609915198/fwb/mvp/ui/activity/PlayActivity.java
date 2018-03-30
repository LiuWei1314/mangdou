package com.p609915198.fwb.mvp.ui.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.media.AudioManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
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
import com.p609915198.fwb.app.PlayModeEnum;
import com.p609915198.fwb.app.receive.RemoteControlReceiver;
import com.p609915198.fwb.mvp.contract.PlayContract;
import com.p609915198.fwb.mvp.di.component.DaggerPlayComponent;
import com.p609915198.fwb.mvp.di.module.PlayModule;
import com.p609915198.fwb.mvp.presenter.PlayPresenter;
import com.p609915198.fwb.mvp.ui.dialog.GiftDialog;
import com.p609915198.fwb.utils.DateUtil;
import com.p609915198.fwb.utils.PayUtil;
import com.p609915198.fwb.utils.SystemUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.p609915198.fwb.app.AppConfig.getPlayService;

/**
 * 播放界面
 * Created by Administrator on 2017/12/26 0026.
 */
public class PlayActivity extends BaseActivity<PlayPresenter> implements PlayContract.View, OnPlayerEventListener, SeekBar.OnSeekBarChangeListener {
    @BindView(R.id.tv_left) TextView tvLeft;
    @BindView(R.id.tv_center) TextView tvCenter;
    @BindView(R.id.iv_right) ImageView ivRight;
    @BindView(R.id.tv_right) TextView tvRight;
    @BindView(R.id.iv) ImageView iv;
    @BindView(R.id.iv_reward) ImageView ivReward;
    @BindView(R.id.iv_gift) ImageView ivGift;
    @BindView(R.id.tv_current_time) TextView tvCurrentTime;
    @BindView(R.id.sb_progress) SeekBar sbProgress;
    @BindView(R.id.tv_total_time) TextView tvTotalTime;
    @BindView(R.id.iv_mode) ImageView ivMode;
    @BindView(R.id.iv_pre) ImageView ivPre;
    @BindView(R.id.iv_play) ImageView ivPlay;
    @BindView(R.id.iv_next) ImageView ivNext;
    @BindView(R.id.civ_head) CircleImageView civHead;
    @BindView(R.id.tv_user_name) TextView tvUserName;
    @BindView(R.id.tv_subscribe_hint) TextView tvSubscribeHint;
    @BindView(R.id.tv_subscribe) TextView tvSubscribe;
    @BindView(R.id.tv_audio_name) TextView tvAudioName;
    @BindView(R.id.tv_play_time) TextView tvPlayTime;

    @Inject Api mApi;

    private Audio mAudio;
    private String mRoomId;
    private RoomDetailResponse mRoomDetail;
    private List<Audio> mAudioList;
    private GiftDialog dialog;
    private AudioManager mAudioManager;
    private ComponentName mRemoteReceiver;
    private int mLastProgress;

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
        getPlayService().setListener(this);
        if (null != mAudioList && null != mAudio && null != mRoomId && null != getPlayService()) {
            if (getPlayService().isPlaying()) {
                ivPlay.setImageResource(R.mipmap.ic_pause);
                if (!mAudio.getAudio_id().equals(getPlayService().getPlayingAudio().getAudio_id())) {
                    play();
                }
            } else {
                play();
            }
        }
        if (null != mRoomDetail) {
            Glide.with(this).load(UrlConstant.IMG_ADDRESS + mRoomDetail.getRoom_cover()).into(iv);
            Glide.with(this).load(UrlConstant.IMG_ADDRESS + mRoomDetail.getRoom_cover()).into(civHead);
            tvUserName.setText(mRoomDetail.getUser_name());
            tvPlayTime.setText(mAudio.getAudio_length());
            tvAudioName.setText(mAudio.getAudio_name());
            tvSubscribeHint.setText("被" + mRoomDetail.getRoom_subscribe() + "人关注");
        }

        registerReceiver();
        initPlayMode();
        onChangeImpl(getPlayService().getPlayingAudio());
        setListener();
    }

    protected void setListener() {
        sbProgress.setOnSeekBarChangeListener(this);
    }

    private void onChangeImpl(Audio music) {
        if (music == null) {
            return;
        }

        sbProgress.setProgress((int) getPlayService().getCurrentPosition());
        sbProgress.setSecondaryProgress(0);
        sbProgress.setMax((int) DateUtil.string2Mills(music.getAudio_length()));
        mLastProgress = 0;
        tvCurrentTime.setText("00:00");
        tvTotalTime.setText(music.getAudio_length());
    }

    private void initPlayMode() {
        int mode = AppConfig.getInstance().getPlayMode();
        ivMode.setImageLevel(mode);
    }

    public void play() {
        AppConfig.setAudioCache(mAudioList);
        for (int i = 0; i < mAudioList.size(); i++) {
            if (mAudioList.get(i).getAudio_id().equals(mAudio.getAudio_id())) {
                getPlayService().play(i);
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

    @OnClick({R.id.tv_left, R.id.tv_subscribe, R.id.iv_play, R.id.iv_pre, R.id.iv_next, R.id.iv_reward, R.id.iv_gift, R.id.iv_mode,
            R.id.iv_fast_next, R.id.iv_fast_pre})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.tv_subscribe:
                ToastUtils.showShort("订阅");
                break;
            case R.id.iv_play:
                getPlayService().playPause();
                break;
            case R.id.iv_pre:
                getPlayService().prev();
                break;
            case R.id.iv_next:
                getPlayService().next();
                break;
            case R.id.iv_reward:
                reward();
                break;
            case R.id.iv_gift:
                gift();
                break;
            case R.id.iv_mode:
                switchPlayMode();
                break;
            case R.id.iv_fast_next:
                AppConfig.getPlayService().seekTo((int) (AppConfig.getPlayService().getCurrentPosition() + 15 * 1000));
                break;
            case R.id.iv_fast_pre:
                AppConfig.getPlayService().seekTo((int) (AppConfig.getPlayService().getCurrentPosition() - 15 * 1000));
                break;
        }
    }

    private void switchPlayMode() {
        PlayModeEnum mode = PlayModeEnum.valueOf(AppConfig.getInstance().getPlayMode());
        switch (mode) {
            case LOOP:
                mode = PlayModeEnum.SHUFFLE;
                showToast("随机播放");
                break;
            case SHUFFLE:
                mode = PlayModeEnum.SINGLE;
                showToast("单曲循环");
                break;
            case SINGLE:
                mode = PlayModeEnum.LOOP;
                showToast("列表循环");
                break;
        }
        AppConfig.getInstance().setPlayMode(mode.value());
        initPlayMode();
    }

    public void reward() {
        launchActivity(new Intent(this, BangActivity.class));
    }

    public void gift() {
        mApi.giftList()
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<List<GiftListResponse>>() {
                        @Override
                        protected void onNext(List<GiftListResponse> result) {
                            dialog = GiftDialog.newInstance((ArrayList<GiftListResponse>) result, (num, data) -> {
                                GiveGiftRequest request = new GiveGiftRequest();
                                request.setCount(num);
                                request.setGift_id(data.getGift_id());
                                request.setRoom_id(mRoomId);
                                request.setUser_id(AppConfig.getUserId());
                                request.setAudio_set(mAudio.getAudio_set());
                                mApi.giveGift(JSON.toJSONString(request))
                                    .compose(RxUtils.bindToLifecycle(PlayActivity.this))
                                    .subscribe(new ProgressSubscriber(
                                            new SubscriberOnNextListener<HttpResult>() {
                                                @Override
                                                protected void onNext(HttpResult result) {
                                                    if (result.getCode() == 201) {
                                                        showToast("您的余额不足！");

                                                        PayUtil.buy(PlayActivity.this, mApi, PlayActivity.this.getSupportFragmentManager(), data.getGift_price() * num);
                                                    } else if (result.getCode() == 200) {
                                                        showToast("赠送成功！");
                                                    }
                                                    dialog.dismiss();
                                                }
                                            }, PlayActivity.this
                                    ));
                            });
                            dialog.setDimAmount(0.4F);
                            dialog.show(getSupportFragmentManager());
                        }
                    }, this
            ));
    }


    @Override
    public void onChange(Audio audio) {
        if (null != tvPlayTime) {
            tvPlayTime.setText(audio.getAudio_length());
            tvAudioName.setText(audio.getAudio_name());
            this.mAudio = audio;
        }
        onChangeImpl(audio);
    }

    @Override
    public void onPlayerStart() {
        if (null != ivPlay) {
            ivPlay.setImageResource(R.mipmap.ic_pause);
        }
    }

    @Override
    public void onPlayerPause() {
        if (null != ivPlay) {
            ivPlay.setImageResource(R.mipmap.ic_home_play);
        }
    }

    @Override
    public void onPublish(int progress) {
        LogUtils.i("------------------------------"+progress);
        sbProgress.setProgress(progress);
        //更新当前播放时间
        if (progress - mLastProgress >= 1000) {
            tvCurrentTime.setText(formatTime(progress));
            mLastProgress = progress;
        }
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (getPlayService().isPlaying() || getPlayService().isPausing()) {
            int progress = seekBar.getProgress();
            getPlayService().seekTo(progress);
            tvCurrentTime.setText(formatTime(progress));
            mLastProgress = progress;
        } else {
            seekBar.setProgress(0);
        }
    }

    private String formatTime(long time) {
        return SystemUtils.formatTime("mm:ss", time);
    }
}
