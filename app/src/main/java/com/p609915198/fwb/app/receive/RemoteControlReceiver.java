package com.p609915198.fwb.app.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;

import com.p609915198.fwb.app.constants.Actions;
import com.p609915198.fwb.app.service.PlayService;


/**
 * 耳机线控，仅在{@link android.os.Build.VERSION_CODES#KITKAT}以下有效，
 * 5.0以上被{@link android.support.v4.media.session.MediaSessionCompat}接管。
 * Created by hzwangchenyan on 2016/1/21.
 */
public class RemoteControlReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        KeyEvent event = intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
        if (event == null || event.getAction() != KeyEvent.ACTION_UP) {
            return;
        }

        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_MEDIA_PLAY:
            case KeyEvent.KEYCODE_MEDIA_PAUSE:
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
            case KeyEvent.KEYCODE_HEADSETHOOK:
                PlayService.startCommand(context, Actions.ACTION_MEDIA_PLAY_PAUSE);
                break;
            case KeyEvent.KEYCODE_MEDIA_NEXT:
                PlayService.startCommand(context, Actions.ACTION_MEDIA_NEXT);
                break;
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
                PlayService.startCommand(context, Actions.ACTION_MEDIA_PREVIOUS);
                break;
        }
    }
}