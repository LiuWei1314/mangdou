package com.p609915198.fwb.mvp.di.component;import com.p609915198.basemodule.di.component.BaseComponent;import com.p609915198.basemodule.di.scope.ActivityScope;import com.p609915198.fwb.mvp.di.module.SearchResultModule;import com.p609915198.fwb.mvp.ui.activity.SearchResultActivity;import dagger.Component;@ActivityScope@Component(modules = SearchResultModule.class, dependencies = BaseComponent.class)public interface SearchResultComponent {    void inject(SearchResultActivity activity);}