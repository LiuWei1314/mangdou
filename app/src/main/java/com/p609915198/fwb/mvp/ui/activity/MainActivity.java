package com.p609915198.fwb.mvp.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.MainContract;
import com.p609915198.fwb.mvp.di.component.DaggerMainComponent;
import com.p609915198.fwb.mvp.di.module.MainModule;
import com.p609915198.fwb.mvp.presenter.MainPresenter;

import java.util.ArrayList;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mark.liu on 2017-8-17.
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    @BindView(R.id.fragment) FrameLayout mFragment;
    @BindView(R.id.tv_home_page) TextView mTvHomePage;
    @BindView(R.id.ll_home_page) LinearLayout mLlHomePage;
    @BindView(R.id.tv_listen) TextView mTvListen;
    @BindView(R.id.ll_listen) LinearLayout mLlListen;
    @BindView(R.id.iv_listen_util) ImageView mIvListenUtil;
    @BindView(R.id.tv_discover) TextView mTvDiscover;
    @BindView(R.id.ll_discover) LinearLayout mLlDiscover;
    @BindView(R.id.tv_mine) TextView mTvMine;
    @BindView(R.id.ll_mine) LinearLayout mLlMine;
    @BindView(R.id.iv_home_page) ImageView mIvHomePage;
    @BindView(R.id.iv_listen) ImageView mIvListen;
    @BindView(R.id.iv_discover) ImageView mIvDiscover;
    @BindView(R.id.iv_mine) ImageView mIvMine;

    @BindColor(R.color.main_text_selected) int textSelectColor;
    @BindColor(R.color.main_text) int textColor;

    @BindBitmap(R.mipmap.ic_home_play) Bitmap icPlay;
    @BindBitmap(R.mipmap.ic_pause) Bitmap icPause;
    @BindBitmap(R.mipmap.ic_home) Bitmap icHome;
    @BindBitmap(R.mipmap.ic_home_selected) Bitmap icHomeSelected;
    @BindBitmap(R.mipmap.ic_listen) Bitmap icListen;
    @BindBitmap(R.mipmap.ic_listen_selected) Bitmap icListenSelected;
    @BindBitmap(R.mipmap.ic_mine) Bitmap icMine;
    @BindBitmap(R.mipmap.ic_mine_selected) Bitmap icMineSelected;
    @BindBitmap(R.mipmap.ic_discover) Bitmap icDiscover;
    @BindBitmap(R.mipmap.ic_discover_selected) Bitmap icDiscoverSelected;

    private int mCrrPosition = 0;// 当前下标位置
    private long time = 0;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerMainComponent
                .builder()
                .baseComponent(baseComponent)
                .mainModule(new MainModule(this)) //请将MainModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mPresenter.initPage();
    }

    @OnClick(value = {R.id.ll_home_page, R.id.ll_discover, R.id.iv_listen_util, R.id.ll_listen, R.id.ll_mine})
    public void PageClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home_page:
                changeView(0);
                break;
            case R.id.ll_listen:
                changeView(1);
                break;
            case R.id.iv_listen_util:
                if (null != AppConfig.getPlayService().getPlayingAudio()) {
                    if (null != AppConfig.getRoomId() && null != AppConfig.getRoomDetail() &&
                            null != AppConfig.getAudioCache()) {
                        Intent intent = new Intent(this, PlayActivity.class);
                        intent.putExtra("audioList", (ArrayList) AppConfig.getAudioCache());
                        intent.putExtra("audio", AppConfig.getPlayService().getPlayingAudio());
                        intent.putExtra("roomId", AppConfig.getRoomId());
                        intent.putExtra("roomDetail", AppConfig.getRoomDetail());
                        launchActivity(intent);
                    }
                } else {
                    showToast("没有正在播放的节目！");
                }
                break;
            case R.id.ll_discover:
                changeView(2);
                break;
            case R.id.ll_mine:
                changeView(3);
                break;
        }
    }

    private void changeView(int position) {
        if (mCrrPosition != position) {
            switch (position) {
                case 0:
                    mIvHomePage.setImageBitmap(icHomeSelected);
                    mIvListen.setImageBitmap(icListen);
                    mIvDiscover.setImageBitmap(icDiscover);
                    mIvMine.setImageBitmap(icMine);
                    mTvHomePage.setTextColor(textSelectColor);
                    mTvListen.setTextColor(textColor);
                    mTvDiscover.setTextColor(textColor);
                    mTvMine.setTextColor(textColor);
                    break;
                case 1:
                    mIvHomePage.setImageBitmap(icHome);
                    mIvListen.setImageBitmap(icListenSelected);
                    mIvDiscover.setImageBitmap(icDiscover);
                    mIvMine.setImageBitmap(icMine);
                    mTvHomePage.setTextColor(textColor);
                    mTvListen.setTextColor(textSelectColor);
                    mTvDiscover.setTextColor(textColor);
                    mTvMine.setTextColor(textColor);
                    break;
                case 2:
                    mIvHomePage.setImageBitmap(icHome);
                    mIvListen.setImageBitmap(icListen);
                    mIvDiscover.setImageBitmap(icDiscoverSelected);
                    mIvMine.setImageBitmap(icMine);
                    mTvHomePage.setTextColor(textColor);
                    mTvListen.setTextColor(textColor);
                    mTvDiscover.setTextColor(textSelectColor);
                    mTvMine.setTextColor(textColor);
                    break;
                case 3:
                    mIvHomePage.setImageBitmap(icHome);
                    mIvListen.setImageBitmap(icListen);
                    mIvDiscover.setImageBitmap(icDiscover);
                    mIvMine.setImageBitmap(icMineSelected);
                    mTvHomePage.setTextColor(textColor);
                    mTvListen.setTextColor(textColor);
                    mTvDiscover.setTextColor(textColor);
                    mTvMine.setTextColor(textSelectColor);
                    break;
            }
            mPresenter.replaceFragment(mCrrPosition, position);// 更换fragment
            mCrrPosition = position;
        }
    }

    /**
     * 双击返回桌面
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - time > 1000)) {
                Toast.makeText(this, "再按一次返回桌面", Toast.LENGTH_SHORT).show();
                time = System.currentTimeMillis();
            } else {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}