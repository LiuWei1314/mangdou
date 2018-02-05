package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-4.
 */
public class PublishAudioRequest {
    private String file;//	音频文件	string
    private int room_id;//	专辑ID	number
    private int user_id;//	用户ID	number

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
