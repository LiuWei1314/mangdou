package com.p609915198.fwb.app;

import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.fwb.app.service.PlayService;

import java.util.ArrayList;
import java.util.List;

import static com.p609915198.fwb.app.constants.PreferenceKeyConstants.KEY_USER_ID;

/**
 * APP数据配置
 * Created by Administrator on 2017/12/26 0026.
 */
public class AppConfig {
    /**
     * 微信app_id
     */
    public static final String WX_APP_ID = "wx52bb78a8cc1ea4f2";
    /**
     * 微信secret
     */
    public static final String WX_SECRET = "9fc3f16117330afa6b2475c8b5215cad";

    /**
     * 阿里rsaPriKey 应用公钥
     */
    public static final String ALI_RSA_PRI_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmd16/dApFxt3hWqiqzPut3/1VYnjDG8pM/YhdT7MgcrJCS6q6HbpU2/98oyD7NrkWOA5qWxf/QatSQkWJztVao1Exw5MNCLJB1Wa1uJC8ImnNSOPoQCd7LiDmweZsepgLxPo5gJG5AL8Ra+g3Y4sCkwvH72XaveCEEZa7bsLDfQIKly15Zz/4V/CpZcNEC24PlO9FLVU4iurBtLWrUS/A2efc/934GPjKSNsuK5v8ESyJiH0zX1DpGZZdiin9Nkwm2JfnBMvNRD0r5c9p9noiMKjf74Gs983H/EPfjh8SglzDCi9+eWeCZnLZ0pdTJVRlNaSgAm9FU4uhx+v3QlZAwIDAQAB";
    /**
     * 阿里rsaPubKey  支付宝公钥
     */
    public static final String ALI_RSA_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk9I1oFHoPxCN+DMkwieux/+8KUsIBJMz+WeNFVHZuKm3v4/zLDoN+yC1285JLDoAJco8t2Myks6rLGK9JGjR/E2zJa6SdOlt/GE+4wDOVMwDJCCEARBbeD1SCjzFH3jRW9o2lDOAe8l878exf9P+QXSaHH7sk9SRfyYkC5HikkT3f6+pYewmdEXtPLg8c0bW891tCZFc/sFFfJvZ+8YG3yF6qa3ipmCfbePNhXbs9eG2hIC0R2kaffrc5NIGnQMyh4q0quf/DnjPtTNqtKIjMd5+qSVqCHwU6/w1cx1CKxNMaSQ0nlem9oN25hOJTKPmEKrdd15HGZAsDZSbINK/uwIDAQAB";

    public static final String CALL_BACK_URL = "http://www.liaoliaoy.com/listenbook/apis/pay/notify_url.php";

    public static final String ALI_ID = "2018013002113931";
    /**
     * 合作者ID：2088421932738607
     * 商户账号：15381769255@163.com
     * 收款方名称：忙豆听书充值
     * 订单名称：忙豆听书
     */

    private PlayService mPlayService;
    private List<Audio> mAudioCaches = new ArrayList<>();
    private String mRoomId = "";
    private RoomDetailResponse mRoomDetail;

    private AppConfig() {
    }

    private static final class SingleHolder {
        private static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance() {
        return SingleHolder.INSTANCE;
    }

    public static String getUserId() {
        return SPUtils.getInstance().getString(KEY_USER_ID, "");
    }

    public static void setUserId(String userId) {
        SPUtils.getInstance().put(KEY_USER_ID, userId);
    }

    public static boolean isLogin() {
        return !TextUtils.isEmpty(getUserId());
    }

    public static List<Audio> getAudioCache() {
        return getInstance().mAudioCaches;
    }

    public static void setAudioCache(List<Audio> audioCache) {
        getInstance().mAudioCaches.clear();
        getInstance().mAudioCaches.addAll(audioCache);
    }

    public static void setRoomDetail(RoomDetailResponse roomDetail) {
        getInstance().mRoomDetail = roomDetail;
    }

    public static RoomDetailResponse getRoomDetail() {
        return getInstance().mRoomDetail;
    }

    public static void setRoomId(String roomId) {
        getInstance().mRoomId = roomId;
    }

    public static String getRoomId() {
        return getInstance().mRoomId;
    }

    public static PlayService getPlayService() {
        return getInstance().mPlayService;
    }

    public static void setPlayService(PlayService service) {
        getInstance().mPlayService = service;
    }
}
