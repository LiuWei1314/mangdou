package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class GiveGiftRequest {
    private int audio_set;//	音频ID
    private int gift_id;//	礼物ID
    private int room_id;//	专辑ID
    private int user_id;//	用户ID

    public int getAudio_set() {
        return audio_set;
    }

    public void setAudio_set(int audio_set) {
        this.audio_set = audio_set;
    }

    public int getGift_id() {
        return gift_id;
    }

    public void setGift_id(int gift_id) {
        this.gift_id = gift_id;
    }

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
}
