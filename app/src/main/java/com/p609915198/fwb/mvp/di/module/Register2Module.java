package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.Register2Contract;
import com.p609915198.fwb.mvp.model.Register2Model;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/6.
 */
@Module
public class Register2Module {
    private Register2Contract.View view;

    /**
     * 构建Register2Module时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public Register2Module(Register2Contract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    Register2Contract.View provideRegister2View() {
        return this.view;
    }

    @ActivityScope
    @Provides
    Register2Contract.Model provideRegister2Model(Register2Model model) {
        return model;
    }
}