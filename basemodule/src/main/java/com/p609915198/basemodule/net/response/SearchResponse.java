package com.p609915198.basemodule.net.response;import android.os.Parcel;import android.os.Parcelable;/** * Created by mark.liu on 2017-11-6. */public class SearchResponse implements Parcelable {    /**     * room_name : 7y10101010     * room_number : 10     * frequency : 7     * room_id : 1     * cover_image : uploads/20160918/1155465fenjxam.jpg     * user_name : 新用户     */    private String room_name;    private String room_number;    private String frequency;    private int room_id;    private String cover_image;    private String user_name;    public String getRoom_name() { return room_name;}    public void setRoom_name(String room_name) { this.room_name = room_name;}    public String getRoom_number() { return room_number;}    public void setRoom_number(String room_number) { this.room_number = room_number;}    public String getFrequency() { return frequency;}    public void setFrequency(String frequency) { this.frequency = frequency;}    public int getRoom_id() { return room_id;}    public void setRoom_id(int room_id) { this.room_id = room_id;}    public String getCover_image() { return cover_image;}    public void setCover_image(String cover_image) { this.cover_image = cover_image;}    public String getUser_name() { return user_name;}    public void setUser_name(String user_name) { this.user_name = user_name;}    @Override    public int describeContents() { return 0; }    @Override    public void writeToParcel(Parcel dest, int flags) {        dest.writeString(this.room_name);        dest.writeString(this.room_number);        dest.writeString(this.frequency);        dest.writeInt(this.room_id);        dest.writeString(this.cover_image);        dest.writeString(this.user_name);    }    public SearchResponse() {}    protected SearchResponse(Parcel in) {        this.room_name = in.readString();        this.room_number = in.readString();        this.frequency = in.readString();        this.room_id = in.readInt();        this.cover_image = in.readString();        this.user_name = in.readString();    }    public static final Parcelable.Creator<SearchResponse> CREATOR = new Parcelable.Creator<SearchResponse>() {        @Override        public SearchResponse createFromParcel(Parcel source) {return new SearchResponse(source);}        @Override        public SearchResponse[] newArray(int size) {return new SearchResponse[size];}    };}