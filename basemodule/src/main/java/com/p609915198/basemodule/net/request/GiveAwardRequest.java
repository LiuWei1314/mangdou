package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class GiveAwardRequest {
    private int room_id;//	房间ID
    private int user_id;//	用户ID
    private double volley;//	余额

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getVolley() {
        return volley;
    }

    public void setVolley(double volley) {
        this.volley = volley;
    }
}
