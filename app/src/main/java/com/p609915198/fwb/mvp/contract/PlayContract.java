package com.p609915198.fwb.mvp.contract;

import com.p609915198.basemodule.base.IModel;
import com.p609915198.basemodule.base.IView;

/**
 * Created by Administrator on 2017/12/26 0026.
 */
public interface PlayContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {

    }
}