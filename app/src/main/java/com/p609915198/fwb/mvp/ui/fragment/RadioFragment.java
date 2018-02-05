package com.p609915198.fwb.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.blankj.utilcode.util.ActivityUtils;
import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.RadioContract;
import com.p609915198.fwb.mvp.di.component.DaggerRadioComponent;
import com.p609915198.fwb.mvp.di.module.RadioModule;
import com.p609915198.fwb.mvp.presenter.RadioPresenter;

/**
 * Created by mark.liu on 2017-9-15.
 * 广播
 */
public class RadioFragment extends BaseFragment<RadioPresenter> implements RadioContract.View {

    public static RadioFragment newInstance() {
        Bundle args = new Bundle();
        RadioFragment fragment = new RadioFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerRadioComponent
                .builder()
                .baseComponent(baseComponent)
                .radioModule(new RadioModule(this)) //请将RadioModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_radio;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        ActivityUtils.startActivity(mActivity, intent);
    }

    @Override
    public void killMyself() {

    }
}
