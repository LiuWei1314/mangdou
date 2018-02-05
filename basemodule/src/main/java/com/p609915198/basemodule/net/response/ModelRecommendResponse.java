package com.p609915198.basemodule.net.response;

import java.util.List;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class ModelRecommendResponse {

    private List<ShortRecommentBean> short_recomment;
    private List<NewRecommentBean> new_recomment;
    private List<ClassicsRecommentBean> classics_recomment;
    private List<PayRecommentBean> pay_recomment;
    private List<LongRecommentBean> long_recomment;

    public List<ShortRecommentBean> getShort_recomment() { return short_recomment;}

    public void setShort_recomment(List<ShortRecommentBean> short_recomment) { this.short_recomment = short_recomment;}

    public List<NewRecommentBean> getNew_recomment() { return new_recomment;}

    public void setNew_recomment(List<NewRecommentBean> new_recomment) { this.new_recomment = new_recomment;}

    public List<ClassicsRecommentBean> getClassics_recomment() { return classics_recomment;}

    public void setClassics_recomment(List<ClassicsRecommentBean> classics_recomment) { this.classics_recomment = classics_recomment;}

    public List<PayRecommentBean> getPay_recomment() { return pay_recomment;}

    public void setPay_recomment(List<PayRecommentBean> pay_recomment) { this.pay_recomment = pay_recomment;}

    public List<LongRecommentBean> getLong_recomment() { return long_recomment;}

    public void setLong_recomment(List<LongRecommentBean> long_recomment) { this.long_recomment = long_recomment;}

    public static class ShortRecommentBean {
        /**
         * room_id : 1
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * user_name : 新用户
         * room_number : 8
         * frequency : 7
         * room_name : 7y88888
         */

        private int room_id;
        private String cover_image;
        private String user_name;
        private String room_number;
        private String frequency;
        private String room_name;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}
    }

    public static class NewRecommentBean {
        /**
         * room_id : 1
         * user_name : 新用户
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * room_name : 7y88888
         * frequency : 7
         * room_number : 8
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

    public static class ClassicsRecommentBean {
        /**
         * room_id : 1
         * frequency : 7
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * room_name : 7y88888
         * user_name : 新用户
         * room_number : 8
         */

        private int room_id;
        private String frequency;
        private String cover_image;
        private String room_name;
        private String user_name;
        private String room_number;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}
    }

    public static class PayRecommentBean {
        /**
         * room_id : 1
         * room_number : 8
         * frequency : 7
         * user_name : 新用户
         * room_name : 7y88888
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         */

        private int room_id;
        private String room_number;
        private String frequency;
        private String user_name;
        private String room_name;
        private String cover_image;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}
    }

    public static class LongRecommentBean {
        /**
         * room_id : 1
         * frequency : 7
         * cover_image : uploads/20160918/1155465fenjxam.jpg
         * user_name : 新用户
         * room_number : 8
         * room_name : 7y88888
         */

        private int room_id;
        private String frequency;
        private String cover_image;
        private String user_name;
        private String room_number;
        private String room_name;

        public int getRoom_id() { return room_id;}

        public void setRoom_id(int room_id) { this.room_id = room_id;}

        public String getFrequency() { return frequency;}

        public void setFrequency(String frequency) { this.frequency = frequency;}

        public String getCover_image() { return cover_image;}

        public void setCover_image(String cover_image) { this.cover_image = cover_image;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}

        public String getRoom_number() { return room_number;}

        public void setRoom_number(String room_number) { this.room_number = room_number;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}
    }
}
