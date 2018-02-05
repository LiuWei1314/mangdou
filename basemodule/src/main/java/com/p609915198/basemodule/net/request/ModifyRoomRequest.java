package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-4.
 */
public class ModifyRoomRequest {
    private String room_cover;// (可选) 专辑封面
    private int room_id;// 专辑ID
    private String room_name;// (可选) 专辑名称
    private String room_summary;// 	(可选) 专辑简介

    public String getRoom_cover() {
        return room_cover;
    }

    public void setRoom_cover(String room_cover) {
        this.room_cover = room_cover;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_summary() {
        return room_summary;
    }

    public void setRoom_summary(String room_summary) {
        this.room_summary = room_summary;
    }
}
