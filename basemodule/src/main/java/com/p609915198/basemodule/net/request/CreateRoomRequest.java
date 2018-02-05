package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-4.
 */
public class CreateRoomRequest {
    private int category_id;//分类ID
    private String room_cover;//	专辑封面
    private String room_name;//	专辑名称
    private String room_summary;//	专辑简介
    private int user_id;//	用户ID

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getRoom_cover() {
        return room_cover;
    }

    public void setRoom_cover(String room_cover) {
        this.room_cover = room_cover;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
