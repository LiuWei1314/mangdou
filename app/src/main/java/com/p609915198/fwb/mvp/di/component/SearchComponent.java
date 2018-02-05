package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.SearchModule;
import com.p609915198.fwb.mvp.ui.activity.SearchActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@ActivityScope
@Component(modules = SearchModule.class, dependencies = BaseComponent.class)
public interface SearchComponent {
    void inject(SearchActivity activity);
}