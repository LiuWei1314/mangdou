package com.p609915198.fwb.app.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.p609915198.fwb.app.constants.Actions;
import com.p609915198.fwb.app.service.PlayService;


/**
 * 来电/耳机拔出时暂停播放
 * Created by wcy on 2016/1/23.
 */
public class NoisyAudioStreamReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        PlayService.startCommand(context, Actions.ACTION_MEDIA_PLAY_PAUSE);
    }
}
