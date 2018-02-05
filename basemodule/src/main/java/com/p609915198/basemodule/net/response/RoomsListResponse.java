package com.p609915198.basemodule.net.response;


import java.io.Serializable;
import java.util.List;

/**
 * Created by mark.liu on 2017-9-21.
 */
public class RoomsListResponse implements Serializable{

    /**
     * label : 新品推荐
     * labelid : 19
     * data : [{"room_id":"538","room_number":"712644037971","room_name":"铁掌无敌王小军","frequency":"13858","cover_image":"audio/20170901/162943emibrqs7.jpg","user_name":"刘忙"},{"room_id":"213","room_number":"389688483482","room_name":"黄金瞳","frequency":"272148","cover_image":"audio/20170114/034626shy0rkmv.jpg","user_name":"刘忙"},{"room_id":"226","room_number":"392684192576","room_name":"天才相师","frequency":"189321","cover_image":"audio/20170114/041208l694xutn.jpg","user_name":"刘忙"},{"room_id":"229","room_number":"179893874936","room_name":"网游之纵横天下","frequency":"151628","cover_image":"audio/20170114/041644x0j75u6r.jpg","user_name":"刘忙"},{"room_id":"235","room_number":"998061186000","room_name":"史上最牛杂货铺","frequency":"142267","cover_image":"audio/20170114/042658nowqhk8x.jpg","user_name":"刘忙"},{"room_id":"497","room_number":"486992915218","room_name":"莫问魂归","frequency":"77799","cover_image":"audio/20170627/172233mtwrpsqi.jpg","user_name":"刘忙"}]
     */

    private String label;
    private String labelid;
    private List<DataBean> data;
    private int itemType;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public static class DataBean implements Serializable{
        /**
         * room_id : 538
         * room_number : 712644037971
         * room_name : 铁掌无敌王小军
         * frequency : 13858
         * cover_image : audio/20170901/162943emibrqs7.jpg
         * user_name : 刘忙
         */

        private String room_id;
        private String room_number;
        private String room_name;
        private String frequency;
        private String cover_image;
        private String user_name;

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }

        public String getRoom_number() {
            return room_number;
        }

        public void setRoom_number(String room_number) {
            this.room_number = room_number;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getFrequency() {
            return frequency;
        }

        public void setFrequency(String frequency) {
            this.frequency = frequency;
        }

        public String getCover_image() {
            return cover_image;
        }

        public void setCover_image(String cover_image) {
            this.cover_image = cover_image;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
    }
}
