package com.p609915198.basemodule.net.response;

import java.util.List;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class ModelLiveResponse {

    /**
     * broadcast_live : {"user_id":1,"user_summary":1,"user_name":1,"user_head":1}
     * super_star : [{"user_summary":"sdfsa","user_id":"26","user_name":"新用户","user_head":"uploads/22/201610151201359819824250014953.jpg"},{"user_summary":"23423","user_id":"28","user_name":"新用户","user_head":"uploads/22/xiao_tou_xiang.png"},{"user_summary":"sadfs","user_id":"27","user_name":"新用户","user_head":"uploads/22/xiao_tou_xiang.png"}]
     * radio_play : [{"user_id":"27","user_head":"uploads/22/xiao_tou_xiang.png","user_name":"新用户","user_summary":"sadfs"},{"user_id":"26","user_head":"uploads/22/201610151201359819824250014953.jpg","user_name":"新用户","user_summary":"sdfsa"}]
     * super_live : [{"user_summary":"sadfs","user_name":"新用户","user_id":"27","user_head":"uploads/22/xiao_tou_xiang.png"},{"user_summary":"sdfsa","user_name":"新用户","user_id":"26","user_head":"uploads/22/201610151201359819824250014953.jpg"},{"user_summary":"23423","user_name":"新用户","user_id":"28","user_head":"uploads/22/xiao_tou_xiang.png"}]
     */

    private BroadcastLiveBean broadcast_live;
    private List<SuperStarBean> super_star;
    private List<RadioPlayBean> radio_play;
    private List<SuperLiveBean> super_live;

    public BroadcastLiveBean getBroadcast_live() { return broadcast_live;}

    public void setBroadcast_live(BroadcastLiveBean broadcast_live) { this.broadcast_live = broadcast_live;}

    public List<SuperStarBean> getSuper_star() { return super_star;}

    public void setSuper_star(List<SuperStarBean> super_star) { this.super_star = super_star;}

    public List<RadioPlayBean> getRadio_play() { return radio_play;}

    public void setRadio_play(List<RadioPlayBean> radio_play) { this.radio_play = radio_play;}

    public List<SuperLiveBean> getSuper_live() { return super_live;}

    public void setSuper_live(List<SuperLiveBean> super_live) { this.super_live = super_live;}

    public static class BroadcastLiveBean {
        /**
         * user_id : 1
         * user_summary : 1
         * user_name : 1
         * user_head : 1
         */

        private int user_id;
        private int user_summary;
        private int user_name;
        private int user_head;

        public int getUser_id() { return user_id;}

        public void setUser_id(int user_id) { this.user_id = user_id;}

        public int getUser_summary() { return user_summary;}

        public void setUser_summary(int user_summary) { this.user_summary = user_summary;}

        public int getUser_name() { return user_name;}

        public void setUser_name(int user_name) { this.user_name = user_name;}

        public int getUser_head() { return user_head;}

        public void setUser_head(int user_head) { this.user_head = user_head;}
    }

    public static class SuperStarBean {
        /**
         * user_summary : sdfsa
         * user_id : 26
         * user_name : 新用户
         * user_head : uploads/22/201610151201359819824250014953.jpg
         */

        private String user_summary;
        private String user_id;
        private String user_name;
        private String user_head;

        public String getUser_summary() { return user_summary;}

        public void setUser_summary(String user_summary) { this.user_summary = user_summary;}

        public String getUser_id() { return user_id;}

        public void setUser_id(String user_id) { this.user_id = user_id;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getUser_head() { return user_head;}

        public void setUser_head(String user_head) { this.user_head = user_head;}
    }

    public static class RadioPlayBean {
        /**
         * user_id : 27
         * user_head : uploads/22/xiao_tou_xiang.png
         * user_name : 新用户
         * user_summary : sadfs
         */

        private String user_id;
        private String user_head;
        private String user_name;
        private String user_summary;

        public String getUser_id() { return user_id;}

        public void setUser_id(String user_id) { this.user_id = user_id;}

        public String getUser_head() { return user_head;}

        public void setUser_head(String user_head) { this.user_head = user_head;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getUser_summary() { return user_summary;}

        public void setUser_summary(String user_summary) { this.user_summary = user_summary;}
    }

    public static class SuperLiveBean {
        /**
         * user_summary : sadfs
         * user_name : 新用户
         * user_id : 27
         * user_head : uploads/22/xiao_tou_xiang.png
         */

        private String user_summary;
        private String user_name;
        private String user_id;
        private String user_head;

        public String getUser_summary() { return user_summary;}

        public void setUser_summary(String user_summary) { this.user_summary = user_summary;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getUser_id() { return user_id;}

        public void setUser_id(String user_id) { this.user_id = user_id;}

        public String getUser_head() { return user_head;}

        public void setUser_head(String user_head) { this.user_head = user_head;}
    }
}
