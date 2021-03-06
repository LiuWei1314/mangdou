package com.p609915198.fwb.mvp.ui.activity;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.arialyy.aria.core.Aria;
import com.blankj.utilcode.util.LogUtils;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.TestContract;
import com.p609915198.fwb.mvp.di.component.DaggerTestComponent;
import com.p609915198.fwb.mvp.di.module.TestModule;
import com.p609915198.fwb.mvp.presenter.TestPresenter;
import com.p609915198.fwb.utils.ShareUtil;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.p609915198.basemodule.net.UrlConstant.DOWNLOAD_AUDIO_ADDRESS;


public class TestActivity extends BaseActivity<TestPresenter> implements TestContract.View {
    @BindView(R.id.btn1) Button mBtn1;
    @BindView(R.id.btn2) Button mBtn2;
    @BindView(R.id.btn3) Button mBtn3;
    @BindView(R.id.btn4) Button mBtn4;
    @BindView(R.id.btn5) Button mBtn5;
    @BindView(R.id.btn6) Button mBtn6;
    @BindView(R.id.btn7) Button mBtn7;
    @BindView(R.id.btn8) Button mBtn8;
    @BindView(R.id.btn9) Button mBtn9;
    @BindView(R.id.pb_download) ProgressBar mPbDownload;

    @Inject Api mApi;

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerTestComponent
                .builder()
                .baseComponent(baseComponent)
                .testModule(new TestModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_test;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                ShareUtil.wxShareText("测试", "测试啊啊啊啊", SendMessageToWX.Req.WXSceneSession);
                break;
            case R.id.btn2:
                ShareUtil.wxShareText("测试", "测试啊啊啊啊", SendMessageToWX.Req.WXSceneTimeline);
                break;
            case R.id.btn3:
                ShareUtil.wxShareMusic("测试", "测试啊啊啊啊", "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif", "http://static.liaoliaoy.com/audio/20171215/1840156agrj0ob.mp3", SendMessageToWX.Req.WXSceneSession);
                break;
            case R.id.btn4:
                ShareUtil.wxShareMusic("测试", "测试啊啊啊啊", "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif", "http://static.liaoliaoy.com/audio/20171215/1840156agrj0ob.mp3", SendMessageToWX.Req.WXSceneTimeline);
                break;
            case R.id.btn5:
                ShareUtil.shareQQText(this, "测试", "测试啊啊啊啊", "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif", new IUiListener() {
                    @Override
                    public void onComplete(Object o) {

                    }

                    @Override
                    public void onError(UiError uiError) {
                        LogUtils.i(uiError.errorDetail + "|" + uiError.errorMessage + "|" + uiError.errorCode);
                    }

                    @Override
                    public void onCancel() {

                    }
                });
                break;
            case R.id.btn6:
                ShareUtil.shareQQMusic(this, "测试", "测试啊啊啊啊", "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif", "http://static.liaoliaoy.com/audio/20171215/1840156agrj0ob.mp3", new IUiListener() {
                    @Override
                    public void onComplete(Object o) {

                    }

                    @Override
                    public void onError(UiError uiError) {
                        LogUtils.i(uiError.errorDetail + "|" + uiError.errorMessage + "|" + uiError.errorCode);
                    }

                    @Override
                    public void onCancel() {

                    }
                });
                break;
            case R.id.btn7:
                ShareUtil.shareQQZonText(this, "测试", "测试啊啊啊啊",
                                         "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif", new IUiListener() {
                            @Override
                            public void onComplete(Object o) {

                            }

                            @Override
                            public void onError(UiError uiError) {
                                LogUtils.i(uiError.errorDetail + "|" + uiError.errorMessage + "|" + uiError.errorCode);
                            }

                            @Override
                            public void onCancel() {

                            }
                        });
                break;
            case R.id.btn8:
                ShareUtil.shareQQZonMusic(this, "测试", "测试啊啊啊啊", "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif",
                                          "http://static.liaoliaoy.com/audio/20171215/1840156agrj0ob.mp3", new IUiListener() {
                            @Override
                            public void onComplete(Object o) {

                            }

                            @Override
                            public void onError(UiError uiError) {
                                LogUtils.i(uiError.errorDetail + "|" + uiError.errorMessage + "|" + uiError.errorCode);
                            }

                            @Override
                            public void onCancel() {

                            }
                        });
                break;
            case R.id.btn9:
                Aria.download(this)
                    .load("http://static.liaoliaoy.com/audio/20170120/1805233hc1ye86.mp3")     //读取下载地址
                    .setFilePath(DOWNLOAD_AUDIO_ADDRESS + "1805233hc1ye86.mp3") //设置文件保存的完整路径
                    .start();   //启动下载
                break;
        }
    }
}
