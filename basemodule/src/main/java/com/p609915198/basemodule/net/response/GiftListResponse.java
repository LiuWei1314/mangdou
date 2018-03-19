package com.p609915198.basemodule.net.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class GiftListResponse implements Parcelable {

    /**
     * gift_cover :
     * gift_name : 玫瑰花
     * gift_id : 1
     * gift_price : 50
     */

    private String gift_cover;
    private String gift_name;
    private String gift_id;
    private double gift_price;

    public String getGift_cover() { return gift_cover;}

    public void setGift_cover(String gift_cover) { this.gift_cover = gift_cover;}

    public String getGift_name() { return gift_name;}

    public void setGift_name(String gift_name) { this.gift_name = gift_name;}

    public String getGift_id() { return gift_id;}

    public void setGift_id(String gift_id) { this.gift_id = gift_id;}

    public double getGift_price() {
        return gift_price;
    }

    public void setGift_price(double gift_price) {
        this.gift_price = gift_price;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.gift_cover);
        dest.writeString(this.gift_name);
        dest.writeString(this.gift_id);
        dest.writeDouble(this.gift_price);
    }

    public GiftListResponse() {}

    protected GiftListResponse(Parcel in) {
        this.gift_cover = in.readString();
        this.gift_name = in.readString();
        this.gift_id = in.readString();
        this.gift_price = in.readDouble();
    }

    public static final Parcelable.Creator<GiftListResponse> CREATOR = new Parcelable.Creator<GiftListResponse>() {
        @Override
        public GiftListResponse createFromParcel(Parcel source) {return new GiftListResponse(source);}

        @Override
        public GiftListResponse[] newArray(int size) {return new GiftListResponse[size];}
    };
}
