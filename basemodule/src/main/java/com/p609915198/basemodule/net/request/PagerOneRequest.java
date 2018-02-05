package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class PagerOneRequest {
    private int position;//	1:首页-推荐-底部广告 2:首页-分类-顶部广告广告 3:首页-经典-顶部广 4:首页-热榜-顶部	number

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
