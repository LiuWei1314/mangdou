package com.p609915198.basemodule.net.response;

import java.util.List;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class ModelHotResponse {

    private List<HotSoaringBean> hot_soaring;
    private List<SuperHotBean> super_hot;
    private List<NewRankBean> new_rank;
    private List<PopularityRankBean> popularity_rank;
    private List<HotClassicsBean> hot_classics;

    public List<HotSoaringBean> getHot_soaring() { return hot_soaring;}

    public void setHot_soaring(List<HotSoaringBean> hot_soaring) { this.hot_soaring = hot_soaring;}

    public List<SuperHotBean> getSuper_hot() { return super_hot;}

    public void setSuper_hot(List<SuperHotBean> super_hot) { this.super_hot = super_hot;}

    public List<NewRankBean> getNew_rank() { return new_rank;}

    public void setNew_rank(List<NewRankBean> new_rank) { this.new_rank = new_rank;}

    public List<PopularityRankBean> getPopularity_rank() { return popularity_rank;}

    public void setPopularity_rank(List<PopularityRankBean> popularity_rank) { this.popularity_rank = popularity_rank;}

    public List<HotClassicsBean> getHot_classics() { return hot_classics;}

    public void setHot_classics(List<HotClassicsBean> hot_classics) { this.hot_classics = hot_classics;}

    public static class HotSoaringBean {
        /**
         * room_id : 1
         * user_name : 新用户
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * room_name : 7y77777
         * frequency : 8
         * room_number : 7
         */

        private int room_id;
        private String user_name;
        private String cover_image;
        private String room_name;
        private String frequency;
        private String room_number;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}
    }

    public static class SuperHotBean {
        /**
         * room_id : 1
         * room_number : 10
         * room_name : 7y10101010
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * frequency : 7
         * user_name : 新用户
         */

        private int room_id;
        private String room_number;
        private String room_name;
        private String cover_image;
        private String frequency;
        private String user_name;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}
    }

    public static class NewRankBean {
        /**
         * room_number : 7
         * frequency : 8
         * room_name : 7y77777
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * user_name : 新用户
         */

        private String room_number;
        private String frequency;
        private String room_name;
        private String cover_image;
        private String user_name;

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}
    }

    public static class PopularityRankBean {
        /**
         * room_id : 1
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * room_name : 7y77777
         * frequency : 8
         * room_number : 7
         * user_name : 新用户
         */

        private int room_id;
        private String cover_image;
        private String room_name;
        private String frequency;
        private String room_number;
        private String user_name;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}
    }

    public static class HotClassicsBean {
        /**
         * room_id : 1
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * room_number : 7
         * frequency : 8
         * user_name : 新用户
         * room_name : 7y77777
         */

        private int room_id;
        private String cover_image;
        private String room_number;
        private String frequency;
        private String user_name;
        private String room_name;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}
    }
}
