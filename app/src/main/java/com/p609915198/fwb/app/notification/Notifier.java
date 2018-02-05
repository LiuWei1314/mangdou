package com.p609915198.fwb.app.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.RemoteViews;

import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.constants.Extras;
import com.p609915198.fwb.app.receive.StatusBarReceiver;
import com.p609915198.fwb.app.service.PlayService;
import com.p609915198.fwb.mvp.ui.activity.SplashActivity;

public class Notifier {
    private static final int NOTIFICATION_ID = 0x111;
    private static PlayService playService;
    private static NotificationManager notificationManager;

    public static void init(PlayService playService) {
        Notifier.playService = playService;
        notificationManager = (NotificationManager) playService.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public static void showPlay(Audio music) {
        playService.startForeground(NOTIFICATION_ID, buildNotification(playService, music, true));
    }

    public static void showPause(Audio music) {
        playService.stopForeground(false);
        notificationManager.notify(NOTIFICATION_ID, buildNotification(playService, music, false));
    }

    public static void cancelAll() {
        notificationManager.cancelAll();
    }

    private static Notification buildNotification(Context context, Audio music, boolean isPlaying) {
        Intent intent = new Intent(context, SplashActivity.class);
        intent.putExtra(Extras.EXTRA_NOTIFICATION, true);
        intent.setAction(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.logo)
                .setCustomContentView(getRemoteViews(context, music, isPlaying));
        Notification notification = builder.build();
        notification.flags = Notification.FLAG_NO_CLEAR;
        return notification;
    }

    private static RemoteViews getRemoteViews(Context context, Audio music, boolean isPlaying) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification);
        remoteViews.setImageViewResource(R.id.iv_icon, R.mipmap.logo);
        remoteViews.setTextViewText(R.id.tv_title, music.getAudio_name());
        remoteViews.setTextViewText(R.id.tv_subtitle, TextUtils.isEmpty(music.getUsername()) ? "" : music.getUsername());

        Intent playIntent = new Intent(StatusBarReceiver.ACTION_STATUS_BAR);
        playIntent.putExtra(StatusBarReceiver.EXTRA, StatusBarReceiver.EXTRA_PLAY_PAUSE);
        PendingIntent playPendingIntent = PendingIntent.getBroadcast(context, 0, playIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setImageViewResource(R.id.iv_play_pause, getPlayIconRes(isPlaying));
        remoteViews.setOnClickPendingIntent(R.id.iv_play_pause, playPendingIntent);

        Intent nextIntent = new Intent(StatusBarReceiver.ACTION_STATUS_BAR);
        nextIntent.putExtra(StatusBarReceiver.EXTRA, StatusBarReceiver.EXTRA_NEXT);
        PendingIntent nextPendingIntent = PendingIntent.getBroadcast(context, 1, nextIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.iv_next, nextPendingIntent);

        Intent preIntent = new Intent(StatusBarReceiver.ACTION_STATUS_BAR);
        preIntent.putExtra(StatusBarReceiver.EXTRA, StatusBarReceiver.EXTRA_CLOSE);
        PendingIntent closePendingIntent = PendingIntent.getBroadcast(context, 2, preIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.iv_close, closePendingIntent);

        return remoteViews;
    }

    private static int getPlayIconRes(boolean isPlaying) {
        return isPlaying ? R.mipmap.ic_notification_pause : R.mipmap.ic_notification_play;
    }
}