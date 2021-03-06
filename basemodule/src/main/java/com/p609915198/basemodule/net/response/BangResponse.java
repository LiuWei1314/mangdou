package com.p609915198.basemodule.net.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by mark.liu on 2018-3-20.
 */
public class BangResponse {
    private boolean status;
    private DataBean data;

    public boolean isStatus() { return status;}

    public void setStatus(boolean status) { this.status = status;}

    public DataBean getData() { return data;}

    public void setData(DataBean data) { this.data = data;}

    public static class DataBean {
        private List<NormalBean> normal;
        private List<CashBean> cash;
        private List<GiftBean> gift;

        public List<NormalBean> getNormal() { return normal;}

        public void setNormal(List<NormalBean> normal) { this.normal = normal;}

        public List<CashBean> getCash() { return cash;}

        public void setCash(List<CashBean> cash) { this.cash = cash;}

        public List<GiftBean> getGift() { return gift;}

        public void setGift(List<GiftBean> gift) { this.gift = gift;}

        public static class NormalBean implements Parcelable {
            /**
             * id : 1435
             * name : 铃屋什造
             * images : 20171212061728139766.jpg
             * used_favor : 131500
             * used_favor_cash : 107000
             * used_favor_gift : 24500
             * bang_price : 131500
             * bang_price_format : 131,500
             * image_path : http://www.liaoliaoy.com/listenbook/disk/20171212061728139766.jpg
             */

            private int id;
            private String name;
            private String images;
            private int used_favor;
            private int used_favor_cash;
            private int used_favor_gift;
            private int bang_price;
            private String bang_price_format;
            private String image_path;

            public int getId() { return id;}

            public void setId(int id) { this.id = id;}

            public String getName() { return name;}

            public void setName(String name) { this.name = name;}

            public String getImages() { return images;}

            public void setImages(String images) { this.images = images;}

            public int getUsed_favor() { return used_favor;}

            public void setUsed_favor(int used_favor) { this.used_favor = used_favor;}

            public int getUsed_favor_cash() { return used_favor_cash;}

            public void setUsed_favor_cash(int used_favor_cash) { this.used_favor_cash = used_favor_cash;}

            public int getUsed_favor_gift() { return used_favor_gift;}

            public void setUsed_favor_gift(int used_favor_gift) { this.used_favor_gift = used_favor_gift;}

            public int getBang_price() { return bang_price;}

            public void setBang_price(int bang_price) { this.bang_price = bang_price;}

            public String getBang_price_format() { return bang_price_format;}

            public void setBang_price_format(String bang_price_format) { this.bang_price_format = bang_price_format;}

            public String getImage_path() { return image_path;}

            public void setImage_path(String image_path) { this.image_path = image_path;}

            @Override
            public int describeContents() { return 0; }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeString(this.name);
                dest.writeString(this.images);
                dest.writeInt(this.used_favor);
                dest.writeInt(this.used_favor_cash);
                dest.writeInt(this.used_favor_gift);
                dest.writeInt(this.bang_price);
                dest.writeString(this.bang_price_format);
                dest.writeString(this.image_path);
            }

            public NormalBean() {}

            protected NormalBean(Parcel in) {
                this.id = in.readInt();
                this.name = in.readString();
                this.images = in.readString();
                this.used_favor = in.readInt();
                this.used_favor_cash = in.readInt();
                this.used_favor_gift = in.readInt();
                this.bang_price = in.readInt();
                this.bang_price_format = in.readString();
                this.image_path = in.readString();
            }

            public static final Parcelable.Creator<NormalBean> CREATOR = new Parcelable.Creator<NormalBean>() {
                @Override
                public NormalBean createFromParcel(Parcel source) {return new NormalBean(source);}

                @Override
                public NormalBean[] newArray(int size) {return new NormalBean[size];}
            };
        }

        public static class CashBean {
            /**
             * id : 1435
             * name : 铃屋什造
             * images : 20171212061728139766.jpg
             * used_favor : 131500
             * used_favor_cash : 107000
             * used_favor_gift : 24500
             * bang_price : 107000
             * bang_price_format : 107,000
             * image_path : http://www.liaoliaoy.com/listenbook/disk/20171212061728139766.jpg
             */

            private int id;
            private String name;
            private String images;
            private int used_favor;
            private int used_favor_cash;
            private int used_favor_gift;
            private int bang_price;
            private String bang_price_format;
            private String image_path;

            public int getId() { return id;}

            public void setId(int id) { this.id = id;}

            public String getName() { return name;}

            public void setName(String name) { this.name = name;}

            public String getImages() { return images;}

            public void setImages(String images) { this.images = images;}

            public int getUsed_favor() { return used_favor;}

            public void setUsed_favor(int used_favor) { this.used_favor = used_favor;}

            public int getUsed_favor_cash() { return used_favor_cash;}

            public void setUsed_favor_cash(int used_favor_cash) { this.used_favor_cash = used_favor_cash;}

            public int getUsed_favor_gift() { return used_favor_gift;}

            public void setUsed_favor_gift(int used_favor_gift) { this.used_favor_gift = used_favor_gift;}

            public int getBang_price() { return bang_price;}

            public void setBang_price(int bang_price) { this.bang_price = bang_price;}

            public String getBang_price_format() { return bang_price_format;}

            public void setBang_price_format(String bang_price_format) { this.bang_price_format = bang_price_format;}

            public String getImage_path() { return image_path;}

            public void setImage_path(String image_path) { this.image_path = image_path;}
        }

        public static class GiftBean implements Parcelable {
            /**
             * id : 1435
             * name : 铃屋什造
             * images : 20171212061728139766.jpg
             * used_favor : 131500
             * used_favor_cash : 107000
             * used_favor_gift : 24500
             * bang_price : 24500
             * bang_price_format : 24,500
             * image_path : http://www.liaoliaoy.com/listenbook/disk/20171212061728139766.jpg
             */

            private int id;
            private String name;
            private String images;
            private int used_favor;
            private int used_favor_cash;
            private int used_favor_gift;
            private int bang_price;
            private String bang_price_format;
            private String image_path;

            public int getId() { return id;}

            public void setId(int id) { this.id = id;}

            public String getName() { return name;}

            public void setName(String name) { this.name = name;}

            public String getImages() { return images;}

            public void setImages(String images) { this.images = images;}

            public int getUsed_favor() { return used_favor;}

            public void setUsed_favor(int used_favor) { this.used_favor = used_favor;}

            public int getUsed_favor_cash() { return used_favor_cash;}

            public void setUsed_favor_cash(int used_favor_cash) { this.used_favor_cash = used_favor_cash;}

            public int getUsed_favor_gift() { return used_favor_gift;}

            public void setUsed_favor_gift(int used_favor_gift) { this.used_favor_gift = used_favor_gift;}

            public int getBang_price() { return bang_price;}

            public void setBang_price(int bang_price) { this.bang_price = bang_price;}

            public String getBang_price_format() { return bang_price_format;}

            public void setBang_price_format(String bang_price_format) { this.bang_price_format = bang_price_format;}

            public String getImage_path() { return image_path;}

            public void setImage_path(String image_path) { this.image_path = image_path;}

            @Override
            public int describeContents() { return 0; }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeString(this.name);
                dest.writeString(this.images);
                dest.writeInt(this.used_favor);
                dest.writeInt(this.used_favor_cash);
                dest.writeInt(this.used_favor_gift);
                dest.writeInt(this.bang_price);
                dest.writeString(this.bang_price_format);
                dest.writeString(this.image_path);
            }

            public GiftBean() {}

            protected GiftBean(Parcel in) {
                this.id = in.readInt();
                this.name = in.readString();
                this.images = in.readString();
                this.used_favor = in.readInt();
                this.used_favor_cash = in.readInt();
                this.used_favor_gift = in.readInt();
                this.bang_price = in.readInt();
                this.bang_price_format = in.readString();
                this.image_path = in.readString();
            }

            public static final Parcelable.Creator<GiftBean> CREATOR = new Parcelable.Creator<GiftBean>() {
                @Override
                public GiftBean createFromParcel(Parcel source) {return new GiftBean(source);}

                @Override
                public GiftBean[] newArray(int size) {return new GiftBean[size];}
            };
        }
    }
}
