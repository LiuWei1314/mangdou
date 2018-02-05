package com.p609915198.fwb.mvp.contract;

import android.app.Activity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.p609915198.basemodule.base.IModel;
import com.p609915198.basemodule.base.IView;
import com.p609915198.basemodule.net.response.AnchorDetailResponse;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/11/10.
 */
public interface AnchorDetailContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void setAdapter(BaseQuickAdapter adapter);

        Activity getActivity();

        void setViews(AnchorDetailResponse response);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<AnchorDetailResponse> anchorDetail(String userId);
    }
}