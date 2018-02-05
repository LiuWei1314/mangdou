package com.p609915198.basemodule.net.response;

import java.io.Serializable;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class AnchorMoreResponse implements Serializable {

    /**
     * user_summary : 标语就是个性签名
     * user_id : 26
     * user_name : 刘忙
     * user_head : 20161110144925416607.png
     */

    private String user_summary;
    private String user_id;
    private String user_name;
    private String user_head;

    public String getUser_summary() { return user_summary;}

    public void setUser_summary(String user_summary) { this.user_summary = user_summary;}

    public String getUser_id() { return user_id;}

    public void setUser_id(String user_id) { this.user_id = user_id;}

    public String getUser_name() { return user_name;}

    public void setUser_name(String user_name) { this.user_name = user_name;}

    public String getUser_head() { return user_head;}

    public void setUser_head(String user_head) { this.user_head = user_head;}
}
