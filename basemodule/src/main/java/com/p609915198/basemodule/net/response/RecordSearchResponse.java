package com.p609915198.basemodule.net.response;

import java.util.List;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class RecordSearchResponse {
    /**
     * 0 : 56215092
     * 1 : 34793
     * 2 : 0
     * 3 : 00:00:00
     * 4 : 2018-03-19 16:26:09
     * 5 : 36537
     * 6 : 604
     * 7 : 大王饶命
     * 8 : 0
     * 9 : 大王饶命001集（新故事，绝对好玩~求打赏，求订阅）.mp3
     * 10 : audio/20171228/130401jyg3qumo.jpg
     * id : 56215092
     * user_id : 34793
     * addtime : 0
     * addtime_str : 00:00:00
     * updated_at : 2018-03-19 16:26:09
     * audio_id : 36537
     * room_id : 604
     * room_name : 大王饶命
     * percent : 0
     * audio_name : 大王饶命001集（新故事，绝对好玩~求打赏，求订阅）.mp3
     * blurimages : audio/20171228/130401jyg3qumo.jpg
     * room_detail : {"room_price":"21.95","user_id":"29","room_cover":"audio/20171228/130401jyg3qumo.jpg","room_blurcover":"20171228130401136716blur.jpg","room_name":"大王饶命","user_name":"刘忙","room_number":"808321727177","room_frequency":"281216","room_subscribe":"1755","room_category":"有声小说","room_play_tour":"0","room_summary":" 每天中午12点左右更新！周一到五日更1集，周末日更两集。 春节努力正常更新，大过年的大家放松一下，我也努力让大家更开心！新年吉祥阖家幸福哦！制作老师也在辛苦的加班，在此感谢大家啦！ 刘忙最新微信：liumanggushi01（刘忙故事01） 论分钟数录制，一集相当于2.5章。定价都是接地气的。 特邀清晨老师制作配乐。 不定期爆发更新，期待支持，搞笑都市修真。 灵气复苏的时代，寂静生活碎掉了，仿佛雷霆贯穿长空，电光直射天心，雨沙沙地落下。 　　凡逆我们的终将死去，这就是法则。 　　\u2026\u2026 　　这是一个吕树依靠毒鸡汤成为大魔王的故事。","room_plays":"80万","last_update":"2017-12-16(连载中)","is_end":"0","room_reply_quantity":428,"is_buy":0,"room_reply":[{"user_head":"20170215/095350zg4y8jsx.png","user_name":"Angel丶豪爵✨","user_reply":"每天只更新一集有点太坑了吧忙哥？我们花着钱听还这么费劲呢啊？~"},{"user_head":"20171026110920824503.jpg","user_name":"血狼、","user_reply":"更新啊"},{"user_head":"20170426/210443tnjy5z26.png","user_name":"Z_1","user_reply":"失望装备删除app，等了一天才一集，"},{"user_head":"headimg.png","user_name":"想林","user_reply":"好久没爆发了"},{"user_head":"20170326183242784305.jpg","user_name":"芒果","user_reply":"之前说嗓子都哑了就一天一集，现在都多少天了，实在是不想这么说，但是你一天一集真是不厚道"}]}
     * audio_list : [{"audio_set":"1","audio_id":"36537","sort":"36384","audio_sum":"157","audio_name":"大王饶命001集（新故事，绝对好玩~求打赏，求订阅）.mp3","audio_path":"20171215/1840156agrj0ob.mp3","filesize":"0K","audio_length":"00:20:10","audio_free":"1","price":"0.00","is_buy":0}]
     */
    private String id;
    private String user_id;
    private String addtime;
    private String addtime_str;
    private String updated_at;
    private String audio_id;
    private String room_id;
    private String room_name;
    private String percent;
    private String audio_name;
    private String blurimages;
    private RoomDetailResponse room_detail;
    private List<Audio> audio_list;

    public String getId() { return id;}

    public void setId(String id) { this.id = id;}

    public String getUser_id() { return user_id;}

    public void setUser_id(String user_id) { this.user_id = user_id;}

    public String getAddtime() { return addtime;}

    public void setAddtime(String addtime) { this.addtime = addtime;}

    public String getAddtime_str() { return addtime_str;}

    public void setAddtime_str(String addtime_str) { this.addtime_str = addtime_str;}

    public String getUpdated_at() { return updated_at;}

    public void setUpdated_at(String updated_at) { this.updated_at = updated_at;}

    public String getAudio_id() { return audio_id;}

    public void setAudio_id(String audio_id) { this.audio_id = audio_id;}

    public String getRoom_id() { return room_id;}

    public void setRoom_id(String room_id) { this.room_id = room_id;}

    public String getRoom_name() { return room_name;}

    public void setRoom_name(String room_name) { this.room_name = room_name;}

    public String getPercent() { return percent;}

    public void setPercent(String percent) { this.percent = percent;}

    public String getAudio_name() { return audio_name;}

    public void setAudio_name(String audio_name) { this.audio_name = audio_name;}

    public String getBlurimages() { return blurimages;}

    public void setBlurimages(String blurimages) { this.blurimages = blurimages;}

    public RoomDetailResponse getRoom_detail() {
        return room_detail;
    }

    public void setRoom_detail(RoomDetailResponse room_detail) {
        this.room_detail = room_detail;
    }

    public List<Audio> getAudio_list() {
        return audio_list;
    }

    public void setAudio_list(List<Audio> audio_list) {
        this.audio_list = audio_list;
    }
}
