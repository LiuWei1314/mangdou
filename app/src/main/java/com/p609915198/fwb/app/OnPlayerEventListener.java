package com.p609915198.fwb.app;

import com.p609915198.basemodule.net.response.Audio;

/**
 * 歌曲操作回调
 */
public interface OnPlayerEventListener {

    /**
     * 切换歌曲
     */
    void onChange(Audio audio);

    /**
     * 继续播放
     */
    void onPlayerStart();

    /**
     * 暂停播放
     */
    void onPlayerPause();

    /**
     * 更新进度
     */
    void onPublish(int progress);

    /**
     * 缓冲百分比
     */
    void onBufferingUpdate(int percent);

    /**
     * 更新定时停止播放时间
     */
    void onTimer(long remain);

    void onAudioListUpdate();
}