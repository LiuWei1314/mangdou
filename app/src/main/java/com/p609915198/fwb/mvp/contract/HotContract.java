package com.p609915198.fwb.mvp.contract;


import com.p609915198.basemodule.base.IModel;
import com.p609915198.basemodule.base.IView;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.basemodule.net.response.RoomsListResponse;
import com.p609915198.basemodule.net.response.RoomsMoreResponse;
import com.p609915198.fwb.mvp.ui.adapter.HotAdapter;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by mark.liu on 2017-9-12.
 */
public interface HotContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void setAdapter(HotAdapter adapter);

        void setAdHeaderView(List<HomeAdResponse> adData);

        void setAdFooterView(List<HomeAdResponse> adData);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<List<RoomsListResponse>> getData(int labelType);

        Observable<List<HomeAdResponse>> getAdData(int position);

        Observable<HttpResult<List<RoomsMoreResponse>>> roomsMore(String labelid);
    }
}