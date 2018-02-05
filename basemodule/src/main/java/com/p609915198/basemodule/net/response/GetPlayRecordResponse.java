package com.p609915198.basemodule.net.response;

import java.util.List;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class GetPlayRecordResponse {

    /**
     * room_id : 213
     * room_cover : audio/20170114/034626shy0rkmv.jpg
     * room_blurcover : 20170114034626584110blur.jpg
     * room_price : 0.00
     * room_frequency : 381406
     * room_like : 0
     * room_name : 黄金瞳
     * last_update : 2017-01-14(连载中)
     * user_name : 刘忙
     * play_record : [{"datetime":"2017-04-29 01:13:21","audio_id":"235","sort":"217","audio_set":"185","audio_name":"黄金瞳成品第185集.mp3","audio_sum":null,"audio_path":"20170114/11224038kyprfm.mp3","filesize":"8.81M","audio_length":"00:19:14","audio_free":"0","price":"0.19","is_buy":1},{"datetime":"2017-05-08 17:16:28","audio_id":"235","sort":"217","audio_set":"185","audio_name":"黄金瞳成品第185集.mp3","audio_sum":null,"audio_path":"20170114/11224038kyprfm.mp3","filesize":"8.81M","audio_length":"00:19:14","audio_free":"0","price":"0.19","is_buy":1},{"datetime":"2017-05-22 00:46:07","audio_id":"235","sort":"217","audio_set":"185","audio_name":"黄金瞳成品第185集.mp3","audio_sum":null,"audio_path":"20170114/11224038kyprfm.mp3","filesize":"8.81M","audio_length":"00:19:14","audio_free":"0","price":"0.19","is_buy":1},{"datetime":"2017-05-22 00:51:49","audio_id":"235","sort":"217","audio_set":"185","audio_name":"黄金瞳成品第185集.mp3","audio_sum":null,"audio_path":"20170114/11224038kyprfm.mp3","filesize":"8.81M","audio_length":"00:19:14","audio_free":"0","price":"0.19","is_buy":1},{"datetime":"2017-05-22 18:38:04","audio_id":"235","sort":"217","audio_set":"185","audio_name":"黄金瞳成品第185集.mp3","audio_sum":null,"audio_path":"20170114/11224038kyprfm.mp3","filesize":"8.81M","audio_length":"00:19:14","audio_free":"0","price":"0.19","is_buy":1},{"datetime":"2017-06-29 21:40:13","audio_id":"213","sort":"195","audio_set":"163","audio_name":"黄金瞳成品第163集.mp3","audio_sum":null,"audio_path":"20170114/111158cko01dg4.mp3","filesize":"9.26M","audio_length":"00:20:14","audio_free":"0","price":"0.19","is_buy":1},{"datetime":"2017-06-29 21:40:13","audio_id":"19","sort":"13","audio_set":"1","audio_name":"黄金瞳成品第001集.mp3","audio_sum":null,"audio_path":"20170114/0609493v2w6mak.mp3","filesize":"9.68M","audio_length":"00:21:09","audio_free":"1","price":"0.00","is_buy":1},{"datetime":"2017-06-29 21:40:14","audio_id":"21","sort":"15","audio_set":"3","audio_name":"黄金瞳成品第003集.mp3","audio_sum":null,"audio_path":"20170114/060949z2bth0i6.mp3","filesize":"8.86M","audio_length":"00:19:22","audio_free":"1","price":"0.00","is_buy":1},{"datetime":"2017-08-30 17:28:15","audio_id":"233","sort":"215","audio_set":"183","audio_name":"黄金瞳成品第183集.mp3","audio_sum":null,"audio_path":"20170114/112240lo3ctnf7.mp3","filesize":"8.9M","audio_length":"00:19:26","audio_free":"0","price":"0.19","is_buy":1}]
     */

    private String room_id;
    private String room_cover;
    private String room_blurcover;
    private String room_price;
    private String room_frequency;
    private String room_like;
    private String room_name;
    private String last_update;
    private String user_name;
    private List<PlayRecordBean> play_record;

    public String getRoom_id() { return room_id;}

    public void setRoom_id(String room_id) { this.room_id = room_id;}

    public String getRoom_cover() { return room_cover;}

    public void setRoom_cover(String room_cover) { this.room_cover = room_cover;}

    public String getRoom_blurcover() { return room_blurcover;}

    public void setRoom_blurcover(String room_blurcover) { this.room_blurcover = room_blurcover;}

    public String getRoom_price() { return room_price;}

    public void setRoom_price(String room_price) { this.room_price = room_price;}

    public String getRoom_frequency() { return room_frequency;}

    public void setRoom_frequency(String room_frequency) { this.room_frequency = room_frequency;}

    public String getRoom_like() { return room_like;}

    public void setRoom_like(String room_like) { this.room_like = room_like;}

    public String getRoom_name() { return room_name;}

    public void setRoom_name(String room_name) { this.room_name = room_name;}

    public String getLast_update() { return last_update;}

    public void setLast_update(String last_update) { this.last_update = last_update;}

    public String getUser_name() { return user_name;}

    public void setUser_name(String user_name) { this.user_name = user_name;}

    public List<PlayRecordBean> getPlay_record() { return play_record;}

    public void setPlay_record(List<PlayRecordBean> play_record) { this.play_record = play_record;}

    public static class PlayRecordBean {
        /**
         * datetime : 2017-04-29 01:13:21
         * audio_id : 235
         * sort : 217
         * audio_set : 185
         * audio_name : 黄金瞳成品第185集.mp3
         * audio_sum : null
         * audio_path : 20170114/11224038kyprfm.mp3
         * filesize : 8.81M
         * audio_length : 00:19:14
         * audio_free : 0
         * price : 0.19
         * is_buy : 1
         */

        private String datetime;
        private String audio_id;
        private String sort;
        private String audio_set;
        private String audio_name;
        private Object audio_sum;
        private String audio_path;
        private String filesize;
        private String audio_length;
        private String audio_free;
        private String price;
        private int is_buy;

        public String getDatetime() { return datetime;}

        public void setDatetime(String datetime) { this.datetime = datetime;}

        public String getAudio_id() { return audio_id;}

        public void setAudio_id(String audio_id) { this.audio_id = audio_id;}

        public String getSort() { return sort;}

        public void setSort(String sort) { this.sort = sort;}

        public String getAudio_set() { return audio_set;}

        public void setAudio_set(String audio_set) { this.audio_set = audio_set;}

        public String getAudio_name() { return audio_name;}

        public void setAudio_name(String audio_name) { this.audio_name = audio_name;}

        public Object getAudio_sum() { return audio_sum;}

        public void setAudio_sum(Object audio_sum) { this.audio_sum = audio_sum;}

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
}
