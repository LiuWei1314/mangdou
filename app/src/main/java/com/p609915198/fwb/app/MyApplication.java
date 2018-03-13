package com.p609915198.fwb.app;import com.blankj.utilcode.util.CrashUtils;import com.blankj.utilcode.util.LogUtils;import com.blankj.utilcode.util.Utils;import com.p609915198.basemodule.base.BaseApplication;import com.p609915198.fwb.BuildConfig;import com.vondear.rxtools.RxTool;/** * Created by Administrator on 2017/12/28 0028. */public class MyApplication extends BaseApplication {    @Override    public void onCreate() {        super.onCreate();        Utils.init(this);        LogUtils.getConfig()                .setLogHeadSwitch(false)                .setBorderSwitch(false)                // 日志开关                .setLogSwitch(BuildConfig.LOG_DEBUG)                // 设置TAG                .setGlobalTag("BaseProject");        // 崩溃日志        CrashUtils.init();////        ShareConfig config = ShareConfig.instance()////                                        .wxId(AppConfig.WX_APP_ID)////                                        .wxSecret(AppConfig.WX_SECRET);////        ShareManager.init(config);//////        final IWXAPI msgApi = WXAPIFactory.createWXAPI(this, null);//        // 将该app注册到微信//        msgApi.registerApp(AppConfig.WX_APP_ID);        RxTool.init(this);    }}