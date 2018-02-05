package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class HomeadRequest {
    //	轮播图位置	number	轮播图位置 （0：首页轮播 1：首页-分类-低部 2：首页-分类-顶部 3：首页-经典-顶部 4：首页-经典-底部
    // 5： 首页-热榜-低部 6：首页-热榜-顶部 7：首页-主播-底部
    // 8：首页-主播-顶部 9：作者详情的-最新作品 10： 作者详情的-经典作品）
    private int position;

    public HomeadRequest(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
