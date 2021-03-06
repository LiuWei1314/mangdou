package com.p609915198.fwb.mvp.ui.activity;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.FileUtils;
import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.ClearContract;
import com.p609915198.fwb.mvp.di.component.DaggerClearComponent;
import com.p609915198.fwb.mvp.di.module.ClearModule;
import com.p609915198.fwb.mvp.presenter.ClearPresenter;
import com.p609915198.fwb.utils.CacheUtil;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;

/**
 * 缓存清除
 */
public class ClearActivity extends BaseActivity<ClearPresenter> implements ClearContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.tv_internal_cache) TextView mTvInternalCache;
    @BindView(R.id.rl_internal_cache) RelativeLayout mRlInternalCache;
    @BindView(R.id.tv_sd_card_cache) TextView mTvSdCardCache;
    @BindView(R.id.rl_sd_card_cache) RelativeLayout mRlSdCardCache;

    @Override
    public void setupActivityComponent(@NonNull BaseComponent baseComponent) {
        DaggerClearComponent
                .builder()
                .baseComponent(baseComponent)
                .clearModule(new ClearModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_clear;
    }

    @Override
    public void initData() {
        mTvCenter.setVisibility(View.VISIBLE);
        mTvCenter.setText("缓存清理");

        mTvInternalCache.setText(FileUtils.getDirSize(CacheUtil.getInternalCacheDirectory(this, null)));
        mTvSdCardCache.setText(FileUtils.getDirSize(UrlConstant.DOWNLOAD_AUDIO_ADDRESS));
    }

    @OnClick({R.id.tv_left, R.id.rl_internal_cache, R.id.rl_sd_card_cache})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                killMyself();
                break;
            case R.id.rl_internal_cache:
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("确定要清理缓存吗？")
                        .setPositiveButton("确定", (dialog, which) -> {
                            FileUtils.deleteAllInDir(CacheUtil.getInternalCacheDirectory(this, null));
                            showToast("清除成功！");
                            mTvInternalCache.setText(FileUtils.getDirSize(CacheUtil.getInternalCacheDirectory(this, null)));
                        })
                        .setNegativeButton("取消", (dialog, which) -> dialog.dismiss())
                        .show();
                break;
            case R.id.rl_sd_card_cache:
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("确定要清理音频吗？")
                        .setPositiveButton("确定", (dialog, which) -> {
                            FileUtils.deleteAllInDir(UrlConstant.DOWNLOAD_AUDIO_ADDRESS);
                            showToast("清除成功！");
                            mTvSdCardCache.setText(FileUtils.getDirSize(UrlConstant.DOWNLOAD_AUDIO_ADDRESS));
                        })
                        .setNegativeButton("取消", (dialog, which) -> dialog.dismiss())
                        .show();
                break;
        }
    }
}
