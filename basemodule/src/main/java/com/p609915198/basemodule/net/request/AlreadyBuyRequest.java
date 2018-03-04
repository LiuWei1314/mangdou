package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class AlreadyBuyRequest {
    private String user_id;//	用户ID
    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
