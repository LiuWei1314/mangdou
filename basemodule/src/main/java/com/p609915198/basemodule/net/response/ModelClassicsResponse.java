package com.p609915198.basemodule.net.response;

import java.util.List;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class ModelClassicsResponse {

    private List<SuperClassicsBean> super_classics;
    private List<GirlLoveBean> girl_love;
    private List<ClassicsRecommentBean> classics_recomment;
    private List<RankingListBean> ranking_list;
    private List<BoyLoveBean> boy_love;

    public List<SuperClassicsBean> getSuper_classics() { return super_classics;}

    public void setSuper_classics(List<SuperClassicsBean> super_classics) { this.super_classics = super_classics;}

    public List<GirlLoveBean> getGirl_love() { return girl_love;}

    public void setGirl_love(List<GirlLoveBean> girl_love) { this.girl_love = girl_love;}

    public List<ClassicsRecommentBean> getClassics_recomment() { return classics_recomment;}

    public void setClassics_recomment(List<ClassicsRecommentBean> classics_recomment) { this.classics_recomment = classics_recomment;}

    public List<RankingListBean> getRanking_list() { return ranking_list;}

    public void setRanking_list(List<RankingListBean> ranking_list) { this.ranking_list = ranking_list;}

    public List<BoyLoveBean> getBoy_love() { return boy_love;}

    public void setBoy_love(List<BoyLoveBean> boy_love) { this.boy_love = boy_love;}

    public static class SuperClassicsBean {
        /**
         * room_id : 1
         * room_name : 7y77777
         * frequency : 8
         * room_number : 7
         * user_name : 新用户
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         */

        private int room_id;
        private String room_name;
        private String frequency;
        private String room_number;
        private String user_name;
        private String cover_image;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}
    }

    public static class GirlLoveBean {
        /**
         * room_id : 1
         * frequency : 7
         * user_name : 新用户
         * room_name : 7y10101010
         * room_number : 10
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         */

        private int room_id;
        private String frequency;
        private String user_name;
        private String room_name;
        private String room_number;
        private String cover_image;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}
    }

    public static class ClassicsRecommentBean {
        /**
         * room_id : 1
         * frequency : 7
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * room_number : 8
         * room_name : 7y88888
         * user_name : 新用户
         */

        private int room_id;
        private String frequency;
        private String cover_image;
        private String room_number;
        private String room_name;
        private String user_name;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}
    }

    public static class RankingListBean {
        /**
         * room_id : 1
         * user_name : 新用户
         * room_number : 8
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * frequency : 7
         * room_name : 7y88888
         */

        private int room_id;
        private String user_name;
        private String room_number;
        private String cover_image;
        private String frequency;
        private String room_name;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}
    }

    public static class BoyLoveBean {
        /**
         * room_id : 1
         * room_name : 7y99999
         * frequency : 6
         * user_name : 新用户
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * room_number : 9
         */

        private int room_id;
        private String room_name;
        private String frequency;
        private String user_name;
        private String cover_image;
        private String room_number;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}
    }
}
