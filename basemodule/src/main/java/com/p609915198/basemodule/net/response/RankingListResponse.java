package com.p609915198.basemodule.net.response;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class RankingListResponse {

    /**
     * room_id : 1
     * room_number : 10
     * user_name : 新用户
     * room_name : 7y10101010
     * cover_image : uploads/20160918/1155465fenjxam.jpg
     * frequency : 7
     */

    private int room_id;
    private String room_number;
    private String user_name;
    private String room_name;
    private String cover_image;
    private String frequency;

    public int getRoom_id() { return room_id;}

    public void setRoom_id(int room_id) { this.room_id = room_id;}

    public String getRoom_number() { return room_number;}

    public void setRoom_number(String room_number) { this.room_number = room_number;}

    public String getUser_name() { return user_name;}

    public void setUser_name(String user_name) { this.user_name = user_name;}

    public String getRoom_name() { return room_name;}

    public void setRoom_name(String room_name) { this.room_name = room_name;}

    public String getCover_image() { return cover_image;}

    public void setCover_image(String cover_image) { this.cover_image = cover_image;}

    public String getFrequency() { return frequency;}

    public void setFrequency(String frequency) { this.frequency = frequency;}
}
