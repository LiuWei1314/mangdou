package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.QualityContract;
import com.p609915198.fwb.mvp.model.QualityModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mark.liu on 2017-9-15.
 */
@Module
public class QualityModule {
    private QualityContract.View view;

    /**
     * 构建QualityModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public QualityModule(QualityContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    QualityContract.View provideQualityView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    QualityContract.Model provideQualityModel(QualityModel model) {
        return model;
    }
}