package com.p609915198.fwb.mvp.ui.activity;

import com.p609915198.basemodule.base.BaseActivity;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.RewardContract;
import com.p609915198.fwb.mvp.di.component.DaggerRewardComponent;
import com.p609915198.fwb.mvp.di.module.RewardModule;
import com.p609915198.fwb.mvp.presenter.RewardPresenter;

/**
 * 我的打赏
 * Created by Administrator on 2018/3/4.
 */
public class RewardActivity extends BaseActivity<RewardPresenter> implements RewardContract.View {

    @Override
    protected void setupActivityComponent(BaseComponent baseComponent) {
        DaggerRewardComponent
                .builder()
                .baseComponent(baseComponent)
                .rewardModule(new RewardModule(this)) //请将rewardModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_reward;
    }

    @Override
    protected void initData() {

    }
}
