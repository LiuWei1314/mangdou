package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class GiveGiftRequest {
    private String audio_set;//	音频ID
    private String gift_id;//	礼物ID
    private String room_id;//	专辑ID
    private String user_id;//	用户ID
    private int count;

    public String getAudio_set() {
        return audio_set;
    }

    public void setAudio_set(String audio_set) {
        this.audio_set = audio_set;
    }

    public String getGift_id() {
        return gift_id;
    }

    public void setGift_id(String gift_id) {
        this.gift_id = gift_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
