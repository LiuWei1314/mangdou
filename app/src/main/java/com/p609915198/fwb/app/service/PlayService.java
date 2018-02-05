package com.p609915198.fwb.app.service;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.p609915198.basemodule.base.BaseService;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.OnPlayerEventListener;
import com.p609915198.fwb.app.constants.Actions;
import com.p609915198.fwb.app.manager.AudioFocusManager;
import com.p609915198.fwb.app.manager.MediaSessionManager;
import com.p609915198.fwb.app.notification.Notifier;
import com.p609915198.fwb.app.receive.NoisyAudioStreamReceiver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * 播放服务
 */
public class PlayService extends BaseService implements MediaPlayer.OnCompletionListener {
    private static final long TIME_UPDATE = 1000L;

    private static final int STATE_IDLE = 0;
    private static final int STATE_PREPARING = 1;
    private static final int STATE_PLAYING = 2;
    private static final int STATE_PAUSE = 3;

    private final List<Audio> mAudioList = AppConfig.getAudioCache();
    private Disposable mDisposable;
    private MediaPlayer mPlayer = new MediaPlayer();
    private OnPlayerEventListener mListener;
    private Audio mPlayingAudio;// 正在播放的歌曲[本地|网络]
    private int mPlayingPosition = -1;// 正在播放的本地歌曲的序号
    private int mPlayState = STATE_IDLE;
    private AudioFocusManager mAudioFocusManager;
    private MediaSessionManager mMediaSessionManager;
    private final NoisyAudioStreamReceiver mNoisyReceiver = new NoisyAudioStreamReceiver();
    private final IntentFilter mNoisyFilter = new IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY);

    private MediaPlayer.OnPreparedListener mPreparedListener = mp -> {
        if (isPreparing()) {
            start();
        }
    };

    @Override
    public void init() {
        mAudioFocusManager = new AudioFocusManager(this);
        mMediaSessionManager = new MediaSessionManager(this);
        mPlayer.setOnCompletionListener(this);
        Notifier.init(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new PlayBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            switch (intent.getAction()) {
                case Actions.ACTION_MEDIA_PLAY_PAUSE:
                    playPause();
                    break;
                case Actions.ACTION_MEDIA_NEXT:
                    next();
                    break;
                case Actions.ACTION_MEDIA_PREVIOUS:
                    prev();
                    break;
            }
        }
        return START_NOT_STICKY;
    }

    public static void startCommand(Context context, String action) {
        Intent intent = new Intent(context, PlayService.class);
        intent.setAction(action);
        context.startService(intent);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        next();
    }

    public void setListener(OnPlayerEventListener listener) {
        this.mListener = listener;
    }

    public void play(Audio music) {
        mPlayingAudio = music;
        try {
            mPlayer.reset();
            mPlayer.setDataSource(UrlConstant.AUDIO_ADDRESS + music.getAudio_path());
            mPlayer.prepareAsync();
            mPlayState = STATE_PREPARING;
            mPlayer.setOnPreparedListener(mPreparedListener);
            mPlayer.setOnBufferingUpdateListener(mBufferingUpdateListener);
            if (mListener != null) {
                mListener.onChange(music);
            }
            Notifier.showPlay(music);
            mMediaSessionManager.updateMetaData(mPlayingAudio);
            mMediaSessionManager.updatePlaybackState();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play(int position) {
        if (mAudioList.isEmpty()) {
            return;
        }

        if (position < 0) {
            position = mAudioList.size() - 1;
        } else if (position >= mAudioList.size()) {
            position = 0;
        }

        mPlayingPosition = position;
        Audio music = mAudioList.get(mPlayingPosition);
        play(music);
    }

    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
        @Override
        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            if (mListener != null) mListener.onBufferingUpdate(percent);
        }
    };

    void start() {
        if (!isPreparing() && !isPausing()) {
            return;
        }

        if (mAudioFocusManager.requestAudioFocus()) {
            mPlayer.start();
            mPlayState = STATE_PLAYING;

            Observable.interval(TIME_UPDATE, TimeUnit.MILLISECONDS)
                      .subscribe(aLong -> {
                                     if (isPlaying() && mListener != null) {
                                         mListener.onPublish(mPlayer.getCurrentPosition());
                                     }
                                 },
                                 throwable -> {},
                                 () -> {},
                                 disposable -> this.mDisposable = disposable);

            Notifier.showPlay(mPlayingAudio);
            mMediaSessionManager.updatePlaybackState();
            registerReceiver(mNoisyReceiver, mNoisyFilter);

            if (mListener != null) {
                mListener.onPlayerStart();
            }
        }
    }

    public void pause() {
        if (!isPlaying()) {
            return;
        }

        mPlayer.pause();
        mPlayState = STATE_PAUSE;
        if (null != mDisposable) {
            mDisposable.dispose();
        }
        Notifier.showPause(mPlayingAudio);
        mMediaSessionManager.updatePlaybackState();
        unregisterReceiver(mNoisyReceiver);
        if (mListener != null) {
            mListener.onPlayerPause();
        }
    }

    public void stop() {
        if (isIdle()) {
            return;
        }

        pause();
        mPlayer.reset();
        mPlayState = STATE_IDLE;
    }

    public void next() {
        if (mAudioList.isEmpty()) {
            return;
        }

        play(mPlayingPosition + 1);
    }

    public void prev() {
        if (mAudioList.isEmpty()) {
            return;
        }

        play(mPlayingPosition - 1);
    }

    public void quit() {
        stop();
        stopSelf();
    }

    /**
     * 跳转到指定的时间位置
     *
     * @param msec 时间
     */
    public void seekTo(int msec) {
        if (isPlaying() || isPausing()) {
            mPlayer.seekTo(msec);
            mMediaSessionManager.updatePlaybackState();
            if (mListener != null) {
                mListener.onPublish(msec);
            }
        }
    }

    public void playPause() {
        if (isPreparing()) {
            stop();
        } else if (isPlaying()) {
            pause();
        } else if (isPausing()) {
            start();
        } else {
            play(getPlayingPosition());
        }
    }

    public boolean isPlaying() {
        return mPlayState == STATE_PLAYING;
    }

    public boolean isPausing() {
        return mPlayState == STATE_PAUSE;
    }

    public boolean isPreparing() {
        return mPlayState == STATE_PREPARING;
    }

    public boolean isIdle() {
        return mPlayState == STATE_IDLE;
    }

    /**
     * 获取正在播放的本地歌曲的序号
     */
    public int getPlayingPosition() {
        return mPlayingPosition;
    }

    /**
     * 获取正在播放的歌曲[本地|网络]
     */
    public Audio getPlayingAudio() {
        return mPlayingAudio;
    }

    public int getAudioSessionId() {
        return mPlayer.getAudioSessionId();
    }

    public long getCurrentPosition() {
        if (isPlaying() || isPausing()) {
            return mPlayer.getCurrentPosition();
        } else {
            return 0;
        }
    }

    @Override
    public void onDestroy() {
        mPlayer.reset();
        mPlayer.release();
        mPlayer = null;
        mAudioFocusManager.abandonAudioFocus();
        mMediaSessionManager.release();
        Notifier.cancelAll();
        AppConfig.setPlayService(null);
        super.onDestroy();
    }

    public class PlayBinder extends Binder {
        public PlayService getService() {
            return PlayService.this;
        }
    }
}