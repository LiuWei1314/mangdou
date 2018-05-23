package com.p609915198.fwb.mvp.ui.activity;

import android.support.annotation.NonNull;
import android.view.View;

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

import butterknife.OnClick;


public class TestActivity extends BaseActivity<TestPresenter> implements TestContract.View {

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

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8})
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
        }
    }
}
