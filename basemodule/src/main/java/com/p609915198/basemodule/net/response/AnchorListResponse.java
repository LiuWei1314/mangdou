package com.p609915198.basemodule.net.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mark.liu on 2017-9-22.
 */
public class AnchorListResponse implements Serializable{

    /**
     * label : 大神主播
     * labelid : 1
     * data : [{"user_id":"29","user_name":"刘忙","user_head":"20170119193552235692.jpg","user_summary":"刘忙全部作品！欢迎关注！您的每一份支持，都是运行下去的最强动力！感谢各位老铁的支持。亲们的支持，是刘忙继续下去的力量和动力！拜谢！！！"},{"user_id":"2462","user_name":"原野","user_head":"2017020413201553286132.png","user_summary":"邻家大哥！实力大神演播！"},{"user_id":"2540","user_name":"大灰狼","user_head":"2017020512304020329895.png","user_summary":"修真世界"},{"user_id":"2541","user_name":"晨诵无声","user_head":"2017020512310830959167.jpg","user_summary":"永生"},{"user_id":"31","user_name":"何其","user_head":"20170122150020700334.png","user_summary":"平稳顺畅，娓娓道来"}]
     */

    private String label;
    private String labelid;
    private List<DataBean> data;

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

    public static class DataBean implements Serializable{
        /**
         * user_id : 29
         * user_name : 刘忙
         * user_head : 20170119193552235692.jpg
         * user_summary : 刘忙全部作品！欢迎关注！您的每一份支持，都是运行下去的最强动力！感谢各位老铁的支持。亲们的支持，是刘忙继续下去的力量和动力！拜谢！！！
         */

        private String user_id;
        private String user_name;
        private String user_head;
        private String user_summary;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_head() {
            return user_head;
        }

        public void setUser_head(String user_head) {
            this.user_head = user_head;
        }

        public String getUser_summary() {
            return user_summary;
        }

        public void setUser_summary(String user_summary) {
            this.user_summary = user_summary;
        }
    }
}
