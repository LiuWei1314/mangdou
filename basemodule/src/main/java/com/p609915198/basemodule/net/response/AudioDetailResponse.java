package com.p609915198.basemodule.net.response;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class AudioDetailResponse {

    /**
     * room_name : 音乐背景
     * gift_data : {"user_name":"小里","gift_cover":""}
     * title : 小里的专辑
     */

    private String room_name;
    private GiftDataBean gift_data;
    private String title;

    public String getRoom_name() { return room_name;}

    public void setRoom_name(String room_name) { this.room_name = room_name;}

    public GiftDataBean getGift_data() { return gift_data;}

    public void setGift_data(GiftDataBean gift_data) { this.gift_data = gift_data;}

    public String getTitle() { return title;}

    public void setTitle(String title) { this.title = title;}

    public static class GiftDataBean {
        /**
         * user_name : 小里
         * gift_cover :
         */

        private String user_name;
        private String gift_cover;

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getGift_cover() { return gift_cover;}

        public void setGift_cover(String gift_cover) { this.gift_cover = gift_cover;}
    }
}
