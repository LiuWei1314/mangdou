package com.p609915198.fwb.mvp.contract;

import android.app.Activity;

import com.p609915198.basemodule.base.IModel;
import com.p609915198.basemodule.base.IView;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.basemodule.net.response.CategoryResponse;
import com.p609915198.fwb.mvp.ui.adapter.ClassifyAdapter;
import com.p609915198.fwb.mvp.ui.adapter.ClassifyMenuAdapter;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by mark.liu on 2017-9-12.
 */
public interface ClassifyContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void setAdHeaderView(List<HomeAdResponse> adData);

        void setAdapter(ClassifyMenuAdapter adapter);

        void setAdapter(ClassifyAdapter adapter);

        void setAdFooterView(List<HomeAdResponse> data);

        Activity getActivityImpl();
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<List<HomeAdResponse>> getAdData(int position);

        Observable<List<CategoryResponse>> getData();

        HomeAdResponse getFooterAdData();
    }
}