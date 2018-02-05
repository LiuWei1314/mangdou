package com.p609915198.fwb.app.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.p609915198.fwb.app.constants.Actions;
import com.p609915198.fwb.app.notification.Notifier;
import com.p609915198.fwb.app.service.PlayService;

public class StatusBarReceiver extends BroadcastReceiver {
    public static final String ACTION_STATUS_BAR = "com.p609915198.fwb.app.STATUS_BAR_ACTIONS";
    public static final String EXTRA = "extra";
    public static final String EXTRA_CLOSE = "close";
    public static final String EXTRA_PRE = "pre";
    public static final String EXTRA_NEXT = "next";
    public static final String EXTRA_PLAY_PAUSE = "play_pause";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }

        String extra = intent.getStringExtra(EXTRA);
        if (TextUtils.equals(extra, EXTRA_NEXT)) {
            PlayService.startCommand(context, Actions.ACTION_MEDIA_NEXT);
        } else if (TextUtils.equals(extra, EXTRA_PLAY_PAUSE)) {
            PlayService.startCommand(context, Actions.ACTION_MEDIA_PLAY_PAUSE);
        } else if (TextUtils.equals(extra, EXTRA_PRE)) {
            PlayService.startCommand(context, Actions.ACTION_MEDIA_PREVIOUS);
        } else if (TextUtils.equals(extra, EXTRA_CLOSE)) {
            Notifier.cancelAll();
        }
    }
}