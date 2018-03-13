package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2018-3-13.
 */
public class TopupNewRequest {
    private String user_id;
    private String volley;
    private String type;// 0=冲值|1=打赏|2=礼物

    public TopupNewRequest(String user_id, String volley, String type) {
        this.user_id = user_id;
        this.volley = volley;
        this.type = type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVolley() {
        return volley;
    }

    public void setVolley(String volley) {
        this.volley = volley;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
