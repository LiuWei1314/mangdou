package com.p609915198.basemodule.net.response;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class UserBaseInfoResponse {

    /**
     * user_summary : sdfsa
     * user_head : uploads/22/201610151201359819824250014953.jpg
     * user_name : 新用户
     * user_volley : 9999855.99
     * user_age : 1
     * user_sex : 1
     * user_phone : 1
     */

    private String user_summary;
    private String user_head;
    private String user_name;
    private String user_volley;
    private int user_age;
    private int user_sex;
    private String user_phone;

    public String getUser_summary() { return user_summary;}

    public void setUser_summary(String user_summary) { this.user_summary = user_summary;}

    public String getUser_head() { return user_head;}

    public void setUser_head(String user_head) { this.user_head = user_head;}

    public String getUser_name() { return user_name;}

    public void setUser_name(String user_name) { this.user_name = user_name;}

    public String getUser_volley() { return user_volley;}

    public void setUser_volley(String user_volley) { this.user_volley = user_volley;}

    public int getUser_age() { return user_age;}

    public void setUser_age(int user_age) { this.user_age = user_age;}

    public int getUser_sex() { return user_sex;}

    public void setUser_sex(int user_sex) { this.user_sex = user_sex;}

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
