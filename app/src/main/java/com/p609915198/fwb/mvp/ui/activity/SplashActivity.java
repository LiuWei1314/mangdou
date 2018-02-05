package com.p609915198.fwb.mvp.ui.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.app.service.PlayService;
import com.p609915198.fwb.mvp.contract.SplashContract;
import com.p609915198.fwb.mvp.di.component.DaggerSplashComponent;
import com.p609915198.fwb.mvp.di.module.SplashModule;
import com.p609915198.fwb.mvp.presenter.SplashPresenter;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

import static com.p609915198.basemodule.net.UrlConstant.SPLASH_IMG;

/**
 * Created by mark.liu on 2017-9-12.
 */
public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {
    @BindView(R.id.iv) ImageView iv;

    private ServiceConnection mPlayServiceConnection;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerSplashComponent
                .builder()
                .baseComponent(baseComponent)
                .splashModule(new SplashModule(this)) //请将SplashModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        Observable.just(this)
                  .doOnSubscribe(disposable -> Glide.with(SplashActivity.this).load(SPLASH_IMG).into(iv))
                  .flatMap((Function<SplashActivity, ObservableSource<?>>) splashActivity -> {
                      if (AppConfig.getPlayService() == null) {
                          return Observable.timer(2, TimeUnit.SECONDS)
                                           .doOnSubscribe(disposable -> startService())
                                           .doOnNext(aLong -> bindService());
                      } else {
                          return Observable.just(0).doOnNext(integer -> {
                              startMainActivity();
                              killMyself();
                          });
                      }
                  })
                  .subscribe();
    }

    private void startService() {
        Intent intent = new Intent(this, PlayService.class);
        startService(intent);
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setClass(this, PlayService.class);
        mPlayServiceConnection = new PlayServiceConnection();
        bindService(intent, mPlayServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private class PlayServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            final PlayService playService = ((PlayService.PlayBinder) service).getService();
            AppConfig.setPlayService(playService);
            startMainActivity();
            killMyself();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    }

    private void startMainActivity() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.putExtras(getIntent());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        launchActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onDestroy() {
        if (mPlayServiceConnection != null) {
            unbindService(mPlayServiceConnection);
        }
        super.onDestroy();
    }
}
