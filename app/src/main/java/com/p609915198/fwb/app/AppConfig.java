package com.p609915198.fwb.app;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.fwb.app.constants.PreferenceKeyConstants;
import com.p609915198.fwb.app.service.PlayService;
import com.p609915198.fwb.mvp.ui.activity.LoginActivity;

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
     * 商户ID
     */
    public static final String WX_PARTNER_ID = "2088421932738607";
    /**
     * 支付宝应用公钥(SHA256withRsa)
     */
    public static final String RSA2_PRIVATE = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCT0jWgUeg/EI34MyTCJ67H/7wpSwgEkzP5Z40VUdm4qbe/j/MsOg37ILXbzkksOgAlyjy3YzKSzqssYr0kaNH8TbMlrpJ06W38YT7jAM5UzAMkIIQBEFt4PVIKPMUfeNFb2jaUM4B7yXzvx7F/0/5BdJocfuyT1JF/JiQLkeKSRPd/r6lh7CZ0Re08uDxzRtbz3W0JkVz+wUV8m9n7xgbfIXqpreKmYJ9t482Fduz14baEgLRHaRp9+tzk0gadAzKHirSq5/8OeM+1M2q0oiMx3n6pJWoIfBTr/DVzHUIrE0xpJDSeV6b2g3bmE4lMo+YQqt13XkcZkCwNlJsg0r+7AgMBAAECggEBAI5mrN56yT8nlXyK2FhpnghxJjSpYVn27NTQmqr1JMauSKMz61CpxJot0sOjH/6JCWdeQctwtmGS0nd5zzfp+pAR0gj0+YXC8f91Nv274wjxV/1PjZrwxQ06FXRjQoqk+xp/RqDSVG3rln3vY+D+uisYRvY4l3N6DYftmD/FE/1PFhdIVdJcFuJJIoeBgRDJMVi4MGBmUDZ+6V0NTQCR58BtdiAGMogk9ox2U6CJYz5ILxeuLFzAc5oVGBTJnjMNsVZhvfz6RGvY9gNOJFPGEXEqZFJZzkOcvSTkNhn3OENyT+ynRe779U07Y4qtAzxkOTOdi3JFh+fTRIyK5yIjdJECgYEA2MCVgs9tbU9J9FkRnje9a7LYuUy8pdFtz0AbNwNX7/sdjEgM3ZX3x156QzGNm1Lff9DquC4Z2CZgFqeViRs9CZ7II90fHfB+vMktHuKx/VKf3jtM0uXHiXyZKNa6BP1GR0LpwpE9cMYEcyLYiC3zIJFDRGGhKGY1N0GaKLQYhSUCgYEArpZdf177enRnH3LNwu+g7bUgmFtVOEwGYSB4+QHTVpElKaIXipLCZaBF3YF9+rW4Wk3FaQqSJ6i1DJucSVvOAikdT+P/B87kqi8Eu4QK32jgKJBu/bOlf3/DWSyW8Ac+rju/Jp0Gux6QDue2xHQQWr3lMGvibp3V3akVl3EBy18CgYAvi89AKpAucj4ew4sB0ehTP6AaxaJ8HTyhQca2gp0/ny4UH5ny4XrA2RCovK37bGpqd0GFtVcl+wUI8ynyMW9qNNJiS5cP0jl64AZtx/yTPRSkgw2PFah3mEVgl/mmLojECQGOFJ4NpuJC/1nQRYQXmMXQsjnPytvRiypt01OtoQKBgFTHvhWJOVOozR8Pb+4W0a49Q9vYllSlTn/B9hztjwQ9ra8/AHGRfQc+wk6jgFrL/f8UPyYYNQs/ONQriMRy6WJRNuPB0ummxZIDDShGIcWFtzzbjppyr45vq5xVM+LRkdWoO9XzcP5TBB/I1A8oUXzPNEnESgvvZ5ihcFO/U+C/AoGAapS8Gz0NsqMzt/pmGXmxh8BIZN7FRyCoeRLXHo3X+tDsa/1p9OOs1+q24yGayncs5sYAoXhdafkb5xGG3s0TBC23eV/O7DO+svB64bqWaI3D5fYndAx+OTFuxtvKjgv7qJ6aSowggWNLzfKfrucV0HS+ISKZZ2/1TzsHyysPL7I=";
    /**
     * 支付宝app_id
     */
    public static final String ALI_APP_ID = "2018013002113931";

    private PlayService mPlayService;
    private List<Audio> mAudioCaches = new ArrayList<>();
    private String mRoomId = "";
    private RoomDetailResponse mRoomDetail;
    // 推送设置
    private boolean push = SPUtils.getInstance().getBoolean(PreferenceKeyConstants.KEY_PUSH, false);
    // 流量保护
    private boolean flowProtect = SPUtils.getInstance().getBoolean(PreferenceKeyConstants.KEY_FLOW_PROTECT, false);

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
        return isLogin(true);
    }

    /**
     * @param toLoginActivity 是否跳转到LoginActivity
     */
    public static boolean isLogin(boolean toLoginActivity) {
        if (!TextUtils.isEmpty(getUserId())) {
            return true;
        } else {
            if (toLoginActivity) {
                Activity activity = ActivityUtils.getTopActivity();
                if (null != activity) {
                    activity.startActivity(new Intent(activity, LoginActivity.class));
                }
            }
            return false;
        }
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

    public static void setPush(boolean push) {
        SPUtils.getInstance().put(PreferenceKeyConstants.KEY_PUSH, push);
    }

    public static boolean getPush() {
        return getInstance().push;
    }

    public static void setFlowProtect(boolean flowProtect) {
        SPUtils.getInstance().put(PreferenceKeyConstants.KEY_FLOW_PROTECT, flowProtect);
    }

    public static boolean getFlowProtect() {
        return getInstance().flowProtect;
    }
}
