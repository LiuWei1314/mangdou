package com.p609915198.basemodule.net.response;

/**
 * 巅峰称号
 * Created by Administrator on 2017/12/25.
 */
public class TopResponse {

    /**
     * status : true
     * data : {"img_url":"http://www.liaoliaoy.com/listenbook/disk/headimg.png","brand":"用户","dou":"0.00","next_brand_dou":188,"percent":0,"vip_level":0}
     */

    private boolean status;
    private DataBean data;

    public boolean isStatus() { return status;}

    public void setStatus(boolean status) { this.status = status;}

    public DataBean getData() { return data;}

    public void setData(DataBean data) { this.data = data;}

    public static class DataBean {
        /**
         * img_url : http://www.liaoliaoy.com/listenbook/disk/headimg.png
         * brand : 用户
         * dou : 0.00
         * next_brand_dou : 188
         * percent : 0
         * vip_level : 0
         */

        private String img_url;
        private String brand;
        private double dou;
        private int next_brand_dou;
        private int percent;
        private int vip_level;

        public String getImg_url() { return img_url;}

        public void setImg_url(String img_url) { this.img_url = img_url;}

        public String getBrand() { return brand;}

        public void setBrand(String brand) { this.brand = brand;}

        public double getDou() {
            return dou;
        }

        public void setDou(double dou) {
            this.dou = dou;
        }

        public int getNext_brand_dou() { return next_brand_dou;}

        public void setNext_brand_dou(int next_brand_dou) { this.next_brand_dou = next_brand_dou;}

        public int getPercent() { return percent;}

        public void setPercent(int percent) { this.percent = percent;}

        public int getVip_level() { return vip_level;}

        public void setVip_level(int vip_level) { this.vip_level = vip_level;}
    }
}
