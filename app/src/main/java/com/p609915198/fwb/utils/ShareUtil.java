package com.p609915198.fwb.utils;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;

import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.MyApplication;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.tauth.IUiListener;

import java.util.ArrayList;

/**
 * Created by mark.liu on 2018-4-13.
 */
public class ShareUtil {
    /**
     * 微信分享 ---------------------------------------------------------------------------
     */
    public static void wxShareText(String text, String description, int type) {
        WXTextObject textObject = new WXTextObject();
        textObject.text = text;

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObject;
        msg.description = description;

        wxShare(msg, buildTransaction("text"), type);
    }

    public static void wxShareMusic(String title, String description, String imgUrl, String musicUrl, int type) {
        WXMusicObject music = new WXMusicObject();
        music.musicUrl = musicUrl;

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = music;
        msg.title = title;
        msg.description = description;
        wxShare(msg, buildTransaction("music"), type);
    }

    private static void wxShare(WXMediaMessage msg, String transaction, int type) {
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.message = msg;
        req.transaction = transaction;
        req.scene = type;
        MyApplication.getIWXAPI().sendReq(req);
    }

    public static String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }


    /**
     * QQ分享 ---------------------------------------------------------------------------
     */
    public static void shareQQText(Activity context, String title, String summary, String imgUrl, IUiListener qqShareListener) {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        shareQQ(params, context, title, summary, imgUrl, "", qqShareListener);
    }

    public static void shareQQMusic(Activity context, String title, String summary, String imgUrl, String musicUrl, IUiListener qqShareListener) {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_AUDIO);
        shareQQ(params, context, title, summary, imgUrl, musicUrl, qqShareListener);
    }

    private static void shareQQ(Bundle params, Activity context, String title, String summary, String imgUrl, String musicUrl, IUiListener qqShareListener) {
        params.putString(QQShare.SHARE_TO_QQ_TITLE, title);
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, summary);
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, AppConfig.QQ_SHARE_TARGET_URL);
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, imgUrl);
        if (!TextUtils.isEmpty(musicUrl)) {
            params.putString(QQShare.SHARE_TO_QQ_AUDIO_URL, musicUrl);
        }
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "忙豆听书");

        MyApplication.getTencent().shareToQQ(context, params, qqShareListener);
    }


    /**
     * QQ空间分享------------------------------------------------------------------------------
     */
    public static void shareQQZonText(Activity context, String title, String summary, String imgUrl, IUiListener qqShareListener) {
        final Bundle params = new Bundle();
        params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneShare.SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
        shareQZon(params, context, title, summary, imgUrl, null, qqShareListener);
    }

    public static void shareQQZonMusic(Activity context, String title, String summary, String imgUrl, String musicUrl, IUiListener qqShareListener) {
        final Bundle params = new Bundle();
        params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneShare.SHARE_TO_QZONE_TYPE_NO_TYPE);
        shareQZon(params, context, title, summary, imgUrl, musicUrl, qqShareListener);
    }

    private static void shareQZon(Bundle params, Activity context, String title, String summary, String imgUrl, String musicUrl, IUiListener qqShareListener) {
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, title);//必填
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, summary);//选填
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, AppConfig.QQ_SHARE_TARGET_URL);//必填
        if (!TextUtils.isEmpty(musicUrl)) {
            params.putString(QzoneShare.SHARE_TO_QQ_AUDIO_URL, musicUrl);
        }
        if (!TextUtils.isEmpty(imgUrl)) {
            ArrayList<String> imgList = new ArrayList<>();
            imgList.add(imgUrl);
            params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, imgList);
        }
        MyApplication.getTencent().shareToQzone(context, params, qqShareListener);
    }
}
