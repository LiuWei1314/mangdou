package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class AnchorDetailRequest {
    private int user_id;//	用户名称

    public AnchorDetailRequest(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
