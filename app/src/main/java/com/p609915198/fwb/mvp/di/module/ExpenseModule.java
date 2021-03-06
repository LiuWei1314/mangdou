package com.p609915198.fwb.mvp.di.module;


import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.ExpenseContract;
import com.p609915198.fwb.mvp.model.ExpenseModel;

import dagger.Module;
import dagger.Provides;


@Module
public class ExpenseModule {
    private ExpenseContract.View view;

    /**
     * 构建ExpenseModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ExpenseModule(ExpenseContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ExpenseContract.View provideExpenseView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ExpenseContract.Model provideExpenseModel(ExpenseModel model) {
        return model;
    }
}