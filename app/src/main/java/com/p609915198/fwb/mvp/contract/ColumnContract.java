package com.p609915198.fwb.mvp.contract;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import com.p609915198.basemodule.base.IModel;
import com.p609915198.basemodule.base.IView;
import com.p609915198.basemodule.net.response.ChargeResponse;
import com.p609915198.basemodule.net.response.PayWXResponse;
import com.p609915198.basemodule.net.response.RoomDetailResponse;

import io.reactivex.Observable;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-10-17.
 */
public interface ColumnContract {
    /**
     * 对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
     */
    interface View extends IView {
        FragmentManager getFraManager();

        Activity getActivity();

        void showViews(RoomDetailResponse roomDetailResponse, String roomId);
    }

    /**
     * Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
     */
    interface Model extends IModel {
        Observable<RoomDetailResponse> roomDetail(String roomId, String userId);

        Observable subscribeRoom(String roomId, String userId);

        Observable<ChargeResponse> topupNew(String key);

        Observable<PayWXResponse> payWx(double valley, String danhao);
    }
}