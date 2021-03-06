package com.p609915198.fwb.app;

import com.arialyy.aria.core.Aria;
import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.p609915198.basemodule.base.BaseApplication;
import com.p609915198.fwb.BuildConfig;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.tauth.Tencent;


/**
 * Created by Administrator on 2017/12/28 0028.
 */
public class MyApplication extends BaseApplication {
    private static Tencent sTencent;
    private static IWXAPI sIWXAPI;

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
        LogUtils.getConfig()
                .setLogHeadSwitch(false)
                .setBorderSwitch(false)
                // 日志开关
                .setLogSwitch(BuildConfig.LOG_DEBUG)
                // 设置TAG
                .setGlobalTag("BaseProject");
        // 崩溃日志
        CrashUtils.init();

        sTencent = Tencent.createInstance(AppConfig.QQ_APP_ID, this);

        sIWXAPI = WXAPIFactory.createWXAPI(this, AppConfig.WX_APP_ID, true);
        sIWXAPI.registerApp(AppConfig.WX_APP_ID);

        Aria.init(this);
    }

    public static Tencent getTencent() {
        return sTencent;
    }

    public static IWXAPI getIWXAPI() {
        return sIWXAPI;
    }
}
