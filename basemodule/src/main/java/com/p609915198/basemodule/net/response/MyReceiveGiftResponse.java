package com.p609915198.basemodule.net.response;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class MyReceiveGiftResponse {
    /**
     * user_head : e.jpg
     * user_name : 小里
     * audio_set : 3
     * gift_cover :
     * gift_name : 玫瑰花
     * room_name : 音乐背景
     */

    private String user_head;
    private String user_name;
    private String audio_set;
    private String gift_cover;
    private String gift_name;
    private String room_name;

    public String getUser_head() { return user_head;}

    public void setUser_head(String user_head) { this.user_head = user_head;}

    public String getUser_name() { return user_name;}

    public void setUser_name(String user_name) { this.user_name = user_name;}

    public String getAudio_set() { return audio_set;}

    public void setAudio_set(String audio_set) { this.audio_set = audio_set;}

    public String getGift_cover() { return gift_cover;}

    public void setGift_cover(String gift_cover) { this.gift_cover = gift_cover;}

    public String getGift_name() { return gift_name;}

    public void setGift_name(String gift_name) { this.gift_name = gift_name;}

    public String getRoom_name() { return room_name;}

    public void setRoom_name(String room_name) { this.room_name = room_name;}
}
