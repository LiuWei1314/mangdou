package com.p609915198.basemodule.net.response;

import java.util.List;

/**
 * Created by mark.liu on 2018-3-21.
 */
public class ZhuBoBangResponse {
    /**
     * status : true
     * data : {"normal":[{"id":29,"name":"刘忙","images":"20170119193552235692.jpg","favor":1030292,"favor_cash":791892,"favor_gift":238400,"bang_price":1030292,"bang_price_format":"1,030,292","image_path":"http://www.liaoliaoy.com/listenbook/disk/20170119193552235692.jpg"},{"id":2462,"name":"原野","images":"2017020413201553286132.png","favor":2300,"favor_cash":0,"favor_gift":2300,"bang_price":2300,"bang_price_format":"2,300","image_path":"http://www.liaoliaoy.com/listenbook/disk/2017020413201553286132.png"},{"id":2541,"name":"晨诵无声","images":"2017020512310830959167.jpg","favor":1900,"favor_cash":400,"favor_gift":1500,"bang_price":1900,"bang_price_format":"1,900","image_path":"http://www.liaoliaoy.com/listenbook/disk/2017020512310830959167.jpg"},{"id":2540,"name":"大灰狼","images":"2017020512304020329895.png","favor":800,"favor_cash":200,"favor_gift":600,"bang_price":800,"bang_price_format":"800","image_path":"http://www.liaoliaoy.com/listenbook/disk/2017020512304020329895.png"},{"id":15108,"name":"猫爪","images":"2017051915284668565368.jpeg","favor":800,"favor_cash":500,"favor_gift":300,"bang_price":800,"bang_price_format":"800","image_path":"http://www.liaoliaoy.com/listenbook/disk/2017051915284668565368.jpeg"},{"id":34,"name":"微笑的苹果","images":"20170122150139452729.png","favor":501,"favor_cash":1,"favor_gift":500,"bang_price":501,"bang_price_format":"501","image_path":"http://www.liaoliaoy.com/listenbook/disk/20170122150139452729.png"},{"id":5760,"name":"有声墨眉","images":"20170222/083635lhawu7pb.png","favor":200,"favor_cash":200,"favor_gift":0,"bang_price":200,"bang_price_format":"200","image_path":"http://www.liaoliaoy.com/listenbook/disk/20170222/083635lhawu7pb.png"}]}
     */

    private boolean status;
    private DataBean data;

    public boolean isStatus() { return status;}

    public void setStatus(boolean status) { this.status = status;}

    public DataBean getData() { return data;}

    public void setData(DataBean data) { this.data = data;}

    public static class DataBean {
        private List<NormalBean> normal;

        public List<NormalBean> getNormal() { return normal;}

        public void setNormal(List<NormalBean> normal) { this.normal = normal;}

        public static class NormalBean {
            /**
             * id : 29
             * name : 刘忙
             * images : 20170119193552235692.jpg
             * favor : 1030292
             * favor_cash : 791892
             * favor_gift : 238400
             * bang_price : 1030292
             * bang_price_format : 1,030,292
             * image_path : http://www.liaoliaoy.com/listenbook/disk/20170119193552235692.jpg
             */

            private int id;
            private String name;
            private String images;
            private int favor;
            private int favor_cash;
            private int favor_gift;
            private int bang_price;
            private String bang_price_format;
            private String image_path;

            public int getId() { return id;}

            public void setId(int id) { this.id = id;}

            public String getName() { return name;}

            public void setName(String name) { this.name = name;}

            public String getImages() { return images;}

            public void setImages(String images) { this.images = images;}

            public int getFavor() { return favor;}

            public void setFavor(int favor) { this.favor = favor;}

            public int getFavor_cash() { return favor_cash;}

            public void setFavor_cash(int favor_cash) { this.favor_cash = favor_cash;}

            public int getFavor_gift() { return favor_gift;}

            public void setFavor_gift(int favor_gift) { this.favor_gift = favor_gift;}

            public int getBang_price() { return bang_price;}

            public void setBang_price(int bang_price) { this.bang_price = bang_price;}

            public String getBang_price_format() { return bang_price_format;}

            public void setBang_price_format(String bang_price_format) { this.bang_price_format = bang_price_format;}

            public String getImage_path() { return image_path;}

            public void setImage_path(String image_path) { this.image_path = image_path;}
        }
    }
}
