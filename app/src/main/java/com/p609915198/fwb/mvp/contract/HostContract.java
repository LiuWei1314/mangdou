package com.p609915198.fwb.mvp.contract;

import android.app.Activity;

import com.p609915198.basemodule.base.IModel;
import com.p609915198.basemodule.base.IView;
import com.p609915198.basemodule.net.response.AnchorListResponse;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.fwb.mvp.ui.adapter.HostAdapter;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by mark.liu on 2017-9-15.
 */
public interface HostContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void setAdapter(HostAdapter adapter);

        Activity getActivityImpl();

        android.view.View getHeaderView();

        void setHeaderView(List<HomeAdResponse> data);

        android.view.View getFooterView();

        void setFooterView(List<HomeAdResponse> data);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<List<HomeAdResponse>> getAdData(int position);

        Observable<List<AnchorListResponse>> getData();
    }
}