package com.p609915198.fwb.mvp.di.component;import com.p609915198.basemodule.di.component.BaseComponent;import com.p609915198.basemodule.di.scope.ActivityScope;import com.p609915198.fwb.mvp.di.module.ExpenseModule;import com.p609915198.fwb.mvp.ui.activity.ExpenseActivity;import dagger.Component;@ActivityScope@Component(modules = ExpenseModule.class, dependencies = BaseComponent.class)public interface ExpenseComponent {    void inject(ExpenseActivity activity);}