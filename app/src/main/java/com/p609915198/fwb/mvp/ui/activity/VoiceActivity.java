package com.p609915198.fwb.mvp.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.VoiceContract;
import com.p609915198.fwb.mvp.di.component.DaggerVoiceComponent;
import com.p609915198.fwb.mvp.di.module.VoiceModule;
import com.p609915198.fwb.mvp.presenter.VoicePresenter;

import butterknife.BindView;


/**
 * 有声书
 *
 * @author mark.liu
 *         Created by mark.liu on 2017-10-17.
 */
public class VoiceActivity extends BaseActivity<VoicePresenter> implements VoiceContract.View {
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_center) TextView mTvCenter;
    @BindView(R.id.iv_right) ImageView mIvRight;
    @BindView(R.id.rv) RecyclerView mRv;

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerVoiceComponent
                .builder()
                .baseComponent(baseComponent)
                .voiceModule(new VoiceModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_voice;
    }

    @Override
    protected void initData() {
        mTvLeft.setText("有声书");
        mTvLeft.setOnClickListener(v -> killMyself());
    }
}
