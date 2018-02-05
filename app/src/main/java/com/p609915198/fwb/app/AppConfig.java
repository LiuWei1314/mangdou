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
     * 阿里rsaPriKey
     */
    public static final String ALI_RSA_PRI_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCT0jWgUeg/EI34MyTCJ67H/7wpSwgEkzP5Z40VUdm4qbe/j/MsOg37ILXbzkksOgAlyjy3YzKSzqssYr0kaNH8TbMlrpJ06W38YT7jAM5UzAMkIIQBEFt4PVIKPMUfeNFb2jaUM4B7yXzvx7F/0/5BdJocfuyT1JF/JiQLkeKSRPd/r6lh7CZ0Re08uDxzRtbz3W0JkVz+wUV8m9n7xgbfIXqpreKmYJ9t482Fduz14baEgLRHaRp9+tzk0gadAzKHirSq5/8OeM+1M2q0oiMx3n6pJWoIfBTr/DVzHUIrE0xpJDSeV6b2g3bmE4lMo+YQqt13XkcZkCwNlJsg0r+7AgMBAAECggEBAI5mrN56yT8nlXyK2FhpnghxJjSpYVn27NTQmqr1JMauSKMz61CpxJot0sOjH/6JCWdeQctwtmGS0nd5zzfp+pAR0gj0+YXC8f91Nv274wjxV/1PjZrwxQ06FXRjQoqk+xp/RqDSVG3rln3vY+D+uisYRvY4l3N6DYftmD/FE/1PFhdIVdJcFuJJIoeBgRDJMVi4MGBmUDZ+6V0NTQCR58BtdiAGMogk9ox2U6CJYz5ILxeuLFzAc5oVGBTJnjMNsVZhvfz6RGvY9gNOJFPGEXEqZFJZzkOcvSTkNhn3OENyT+ynRe779U07Y4qtAzxkOTOdi3JFh+fTRIyK5yIjdJECgYEA2MCVgs9tbU9J9FkRnje9a7LYuUy8pdFtz0AbNwNX7/sdjEgM3ZX3x156QzGNm1Lff9DquC4Z2CZgFqeViRs9CZ7II90fHfB+vMktHuKx/VKf3jtM0uXHiXyZKNa6BP1GR0LpwpE9cMYEcyLYiC3zIJFDRGGhKGY1N0GaKLQYhSUCgYEArpZdf177enRnH3LNwu+g7bUgmFtVOEwGYSB4+QHTVpElKaIXipLCZaBF3YF9+rW4Wk3FaQqSJ6i1DJucSVvOAikdT+P/B87kqi8Eu4QK32jgKJBu/bOlf3/DWSyW8Ac+rju/Jp0Gux6QDue2xHQQWr3lMGvibp3V3akVl3EBy18CgYAvi89AKpAucj4ew4sB0ehTP6AaxaJ8HTyhQca2gp0/ny4UH5ny4XrA2RCovK37bGpqd0GFtVcl+wUI8ynyMW9qNNJiS5cP0jl64AZtx/yTPRSkgw2PFah3mEVgl/mmLojECQGOFJ4NpuJC/1nQRYQXmMXQsjnPytvRiypt01OtoQKBgFTHvhWJOVOozR8Pb+4W0a49Q9vYllSlTn/B9hztjwQ9ra8/AHGRfQc+wk6jgFrL/f8UPyYYNQs/ONQriMRy6WJRNuPB0ummxZIDDShGIcWFtzzbjppyr45vq5xVM+LRkdWoO9XzcP5TBB/I1A8oUXzPNEnESgvvZ5ihcFO/U+C/AoGAapS8Gz0NsqMzt/pmGXmxh8BIZN7FRyCoeRLXHo3X+tDsa/1p9OOs1+q24yGayncs5sYAoXhdafkb5xGG3s0TBC23eV/O7DO+svB64bqWaI3D5fYndAx+OTFuxtvKjgv7qJ6aSowggWNLzfKfrucV0HS+ISKZZ2/1TzsHyysPL7I=";
    /**
     * 阿里rsaPubKey
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
