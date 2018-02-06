package com.p609915198.basemodule.net.response;

import java.io.Serializable;

/**
 * 音频
 * Created by mark.liu on 2017-11-6.
 */
public class Audio implements Serializable {
    /**
     * audio_set : 21
     * audio_id : 35989
     * sort : 35854
     * audio_sum : 199
     * audio_name : 閾佹帉鏃犳晫021.mp3
     * audio_path : 20170916/151714zdmkpn72.mp3
     * filesize : 8.29M
     * audio_length : 00:18:06
     * audio_free : 1
     * price : 0.00
     * is_buy : 0
     */

    private String datetime;
    private String audio_set;
    private String audio_id;
    private String sort;
    private String audio_sum;
    private String audio_name;
    private String audio_path;
    private String filesize;
    private String audio_length;
    private String audio_free;
    private String price;
    private int is_buy;

    private String username;// 用户名
    private String url;// 专辑图片
    private String introduce;// 专辑简介

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAudio_set() { return audio_set;}

    public void setAudio_set(String audio_set) { this.audio_set = audio_set;}

    public String getAudio_id() { return audio_id;}

    public void setAudio_id(String audio_id) { this.audio_id = audio_id;}

    public String getSort() { return sort;}

    public void setSort(String sort) { this.sort = sort;}

    public String getAudio_sum() { return audio_sum;}

    public void setAudio_sum(String audio_sum) { this.audio_sum = audio_sum;}

    public String getAudio_name() { return audio_name;}

    public void setAudio_name(String audio_name) { this.audio_name = audio_name;}

    public String getAudio_path() { return audio_path;}

    public void setAudio_path(String audio_path) { this.audio_path = audio_path;}

    public String getFilesize() { return filesize;}

    public void setFilesize(String filesize) { this.filesize = filesize;}

    public String getAudio_length() { return audio_length;}

    public void setAudio_length(String audio_length) { this.audio_length = audio_length;}

    public String getAudio_free() { return audio_free;}

    public void setAudio_free(String audio_free) { this.audio_free = audio_free;}

    public String getPrice() { return price;}

    public void setPrice(String price) { this.price = price;}

    public int getIs_buy() { return is_buy;}

    public void setIs_buy(int is_buy) { this.is_buy = is_buy;}
}
