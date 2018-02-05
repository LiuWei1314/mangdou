package com.p609915198.basemodule.net.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mark.liu on 2017-11-4.
 */
public class RoomDetailResponse implements Serializable {
    /**
     * room_number : 324719448653
     * room_summary : 一个灵岳城里的低阶小散修魏索，在交易的时候被人骗了，拿到了一个破损的低级法宝，可是这个不值一文的破损法宝里头，却有一个已经活了几万年的器灵...而且和几万年前相比，很多原本稀少的东西现在已经很多了，魏索先现，价值半颗下品灵石的火符的炼制材料现在就很多，…
     * room_price : 34.40
     * is_buy : 0
     * room_reply_quantity : 48
     * room_cover : audio/20170114/042408gmxej7ao.jpg
     * is_end : 1
     * room_plays : 78万
     * room_subscribe : 662
     * user_name : 刘忙
     * last_update : 2017-01-14(已完结)
     * room_blurcover : 20170114042408620901blur.jpg
     * room_frequency : 55840
     * room_name : 通天之路
     * room_category : 有声小说
     * user_id : 29
     * room_reply : [{"user_reply":"听完了，心情有些不舍\u2026\u2026","user_name":"","user_head":"20170531/151614r46dh98b.png"},{"user_reply":"购买之后还要每集下载下来吗？","user_name":"2017081810252515","user_head":"20170819083207391956.jpg"},{"user_reply":"怎么下载不了","user_name":"Z_1","user_head":"20170426/210443tnjy5z26.png"},{"user_reply":"怎么弄啊没弄明白听到450集就听不了了","user_name":"迷失的孤独","user_head":"20171008/103906razxflws.png"},{"user_reply":"为什么我上个月买过了，现在听还要付费！","user_name":"°C","user_head":"20170707/114916t5vrsqb3.png"}]
     * room_play_tour : 0
     */

    private String room_number;
    private String room_summary;
    private String room_price;
    private int is_buy;
    private int room_reply_quantity;
    private String room_cover;
    private String is_end;
    private String room_plays;
    private String room_subscribe;
    private String user_name;
    private String last_update;
    private String room_blurcover;
    private String room_frequency;
    private String room_name;
    private String room_category;
    private String user_id;
    private String room_play_tour;
    private List<RoomReplyBean> room_reply;

    public String getRoom_number() { return room_number;}

    public void setRoom_number(String room_number) { this.room_number = room_number;}

    public String getRoom_summary() { return room_summary;}

    public void setRoom_summary(String room_summary) { this.room_summary = room_summary;}

    public String getRoom_price() { return room_price;}

    public void setRoom_price(String room_price) { this.room_price = room_price;}

    public int getIs_buy() { return is_buy;}

    public void setIs_buy(int is_buy) { this.is_buy = is_buy;}

    public int getRoom_reply_quantity() { return room_reply_quantity;}

    public void setRoom_reply_quantity(int room_reply_quantity) { this.room_reply_quantity = room_reply_quantity;}

    public String getRoom_cover() { return room_cover;}

    public void setRoom_cover(String room_cover) { this.room_cover = room_cover;}

    public String getIs_end() { return is_end;}

    public void setIs_end(String is_end) { this.is_end = is_end;}

    public String getRoom_plays() { return room_plays;}

    public void setRoom_plays(String room_plays) { this.room_plays = room_plays;}

    public String getRoom_subscribe() { return room_subscribe;}

    public void setRoom_subscribe(String room_subscribe) { this.room_subscribe = room_subscribe;}

    public String getUser_name() { return user_name;}

    public void setUser_name(String user_name) { this.user_name = user_name;}

    public String getLast_update() { return last_update;}

    public void setLast_update(String last_update) { this.last_update = last_update;}

    public String getRoom_blurcover() { return room_blurcover;}

    public void setRoom_blurcover(String room_blurcover) { this.room_blurcover = room_blurcover;}

    public String getRoom_frequency() { return room_frequency;}

    public void setRoom_frequency(String room_frequency) { this.room_frequency = room_frequency;}

    public String getRoom_name() { return room_name;}

    public void setRoom_name(String room_name) { this.room_name = room_name;}

    public String getRoom_category() { return room_category;}

    public void setRoom_category(String room_category) { this.room_category = room_category;}

    public String getUser_id() { return user_id;}

    public void setUser_id(String user_id) { this.user_id = user_id;}

    public String getRoom_play_tour() { return room_play_tour;}

    public void setRoom_play_tour(String room_play_tour) { this.room_play_tour = room_play_tour;}

    public List<RoomReplyBean> getRoom_reply() { return room_reply;}

    public void setRoom_reply(List<RoomReplyBean> room_reply) { this.room_reply = room_reply;}

    public static class RoomReplyBean implements Serializable {
        /**
         * user_reply : 听完了，心情有些不舍……
         * user_name :
         * user_head : 20170531/151614r46dh98b.png
         */

        private String user_reply;
        private String user_name;
        private String user_head;

        public String getUser_reply() { return user_reply;}

        public void setUser_reply(String user_reply) { this.user_reply = user_reply;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getUser_head() { return user_head;}

        public void setUser_head(String user_head) { this.user_head = user_head;}
    }
}
