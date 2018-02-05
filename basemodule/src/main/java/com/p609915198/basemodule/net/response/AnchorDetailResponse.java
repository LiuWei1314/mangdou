package com.p609915198.basemodule.net.response;

import java.util.List;

/**
 * Created by mark.liu on 2017-11-4.
 */
public class AnchorDetailResponse {
    /**
     * user_info : {"user_head":"20170119193552235692.jpg","user_summary":"刘忙全部作品！欢迎关注！您的每一份支持，都是运行下去的最强动力！感谢各位老铁的支持。亲们的支持，是刘忙继续下去的力量和动力！拜谢！！！","user_name":"刘忙"}
     * news_works : [{"room_id":"220","room_name":"流氓高手","room_cover":"audio/20170114/040149b5wozfh9.jpg","room_views":"38575","user_name":"刘忙"},{"room_id":"214","room_name":"史上第一混乱","room_cover":"audio/20170114/0348235378e6c4.jpg","room_views":"34483","user_name":"刘忙"},{"room_id":"604","room_name":"大王饶命","room_cover":"audio/20171228/130401jyg3qumo.jpg","room_views":"91946","user_name":"刘忙"},{"room_id":"605","room_name":"一念永恒","room_cover":"audio/20171228/130429zvf92j75.jpg","room_views":"137285","user_name":"刘忙"},{"room_id":"207","room_name":"超级教师","room_cover":"audio/20170114/043818mrz9be2u.jpg","room_views":"32497","user_name":"刘忙"},{"room_id":"233","room_name":"通天之路","room_cover":"audio/20170114/042408gmxej7ao.jpg","room_views":"80517","user_name":"刘忙"},{"room_id":"227","room_name":"天才医生","room_cover":"audio/20170114/041341uzpij7ym.jpg","room_views":"65599","user_name":"刘忙"},{"room_id":"222","room_name":"捉鬼这些年1","room_cover":"audio/20170114/040536sbgi48tm.png","room_views":"20763","user_name":"刘忙"},{"room_id":"497","room_name":"莫问魂归","room_cover":"audio/20170627/172233mtwrpsqi.jpg","room_views":"134403","user_name":"刘忙"},{"room_id":"213","room_name":"黄金瞳","room_cover":"audio/20170114/034626shy0rkmv.jpg","room_views":"521730","user_name":"刘忙"},{"room_id":"217","room_name":"老千的巅峰1","room_cover":"audio/20170114/035639i5d36yu0.jpg","room_views":"10542","user_name":"刘忙"},{"room_id":"226","room_name":"天才相师","room_cover":"audio/20170114/041208l694xutn.jpg","room_views":"336087","user_name":"刘忙"},{"room_id":"231","room_name":"兄弟我在义乌的发财史1","room_cover":"audio/20170114/0419568aqkmi2c.jpg","room_views":"9565","user_name":"刘忙"},{"room_id":"215","room_name":"混世小农民","room_cover":"audio/20171206/102757pqz0ja2f.jpg","room_views":"62221","user_name":"刘忙"},{"room_id":"228","room_name":"铁梨花","room_cover":"audio/20170210/032157csdb3fpy.jpg","room_views":"6771","user_name":"刘忙"},{"room_id":"216","room_name":"解密传奇","room_cover":"audio/20170114/0354053h8mztrk.jpg","room_views":"7348","user_name":"刘忙"},{"room_id":"238","room_name":"折腾岁月1新版","room_cover":"audio/20170114/043016a0ksm9cy.jpg","room_views":"12275","user_name":"刘忙"},{"room_id":"235","room_name":"史上最牛杂货铺","room_cover":"audio/20170114/042658nowqhk8x.jpg","room_views":"202686","user_name":"刘忙"},{"room_id":"234","room_name":"妖孽歪传","room_cover":"audio/20170114/042514to9efimn.jpg","room_views":"82746","user_name":"刘忙"},{"room_id":"211","room_name":"行脚商人的奇闻异录","room_cover":"audio/20170114/034253a1uk8w6j.jpg","room_views":"35119","user_name":"刘忙"},{"room_id":"210","room_name":"废柴道士1","room_cover":"audio/20170114/034113uncabedz.jpg","room_views":"51629","user_name":"刘忙"},{"room_id":"221","room_name":"蒙氏法医馆","room_cover":"audio/20170114/040307r0fhib6t.jpg","room_views":"6632","user_name":"刘忙"},{"room_id":"514","room_name":"废柴道士2","room_cover":"audio/20170708/1443479vygz5ws.jpg","room_views":"23169","user_name":"刘忙"},{"room_id":"223","room_name":"史上第一混搭","room_cover":"audio/20170114/04065150ikmrfq.jpg","room_views":"85780","user_name":"刘忙"},{"room_id":"224","room_name":"谁都别惹我","room_cover":"audio/20170114/0408500f6wvds9.jpg","room_views":"70204","user_name":"刘忙"},{"room_id":"230","room_name":"我就是妖怪","room_cover":"audio/20170114/041833z9wr7gs8.jpg","room_views":"58196","user_name":"刘忙"},{"room_id":"219","room_name":"刘老六传奇","room_cover":"audio/20170114/035953hsnl6a4v.jpg","room_views":"52596","user_name":"刘忙"},{"room_id":"236","room_name":"折腾岁月1经典版","room_cover":"audio/20170114/042933h2pl6fr8.jpg","room_views":"6452","user_name":"刘忙"},{"room_id":"523","room_name":"废柴道士3","room_cover":"audio/20170729/121913onc1jpqf.jpg","room_views":"14673","user_name":"刘忙"},{"room_id":"237","room_name":"折腾岁月2","room_cover":"audio/20170114/043148h3yvqfw1.jpg","room_views":"6170","user_name":"刘忙"}]
     * classics_works : [{"room_id":"220","room_name":"流氓高手","room_cover":"audio/20170114/040149b5wozfh9.jpg","room_views":"38575","user_name":"刘忙"},{"room_id":"214","room_name":"史上第一混乱","room_cover":"audio/20170114/0348235378e6c4.jpg","room_views":"34483","user_name":"刘忙"},{"room_id":"604","room_name":"大王饶命","room_cover":"audio/20171228/130401jyg3qumo.jpg","room_views":"91946","user_name":"刘忙"},{"room_id":"605","room_name":"一念永恒","room_cover":"audio/20171228/130429zvf92j75.jpg","room_views":"137285","user_name":"刘忙"},{"room_id":"207","room_name":"超级教师","room_cover":"audio/20170114/043818mrz9be2u.jpg","room_views":"32497","user_name":"刘忙"},{"room_id":"233","room_name":"通天之路","room_cover":"audio/20170114/042408gmxej7ao.jpg","room_views":"80517","user_name":"刘忙"},{"room_id":"227","room_name":"天才医生","room_cover":"audio/20170114/041341uzpij7ym.jpg","room_views":"65599","user_name":"刘忙"},{"room_id":"222","room_name":"捉鬼这些年1","room_cover":"audio/20170114/040536sbgi48tm.png","room_views":"20763","user_name":"刘忙"},{"room_id":"497","room_name":"莫问魂归","room_cover":"audio/20170627/172233mtwrpsqi.jpg","room_views":"134403","user_name":"刘忙"},{"room_id":"213","room_name":"黄金瞳","room_cover":"audio/20170114/034626shy0rkmv.jpg","room_views":"521730","user_name":"刘忙"},{"room_id":"217","room_name":"老千的巅峰1","room_cover":"audio/20170114/035639i5d36yu0.jpg","room_views":"10542","user_name":"刘忙"},{"room_id":"226","room_name":"天才相师","room_cover":"audio/20170114/041208l694xutn.jpg","room_views":"336087","user_name":"刘忙"},{"room_id":"231","room_name":"兄弟我在义乌的发财史1","room_cover":"audio/20170114/0419568aqkmi2c.jpg","room_views":"9565","user_name":"刘忙"},{"room_id":"215","room_name":"混世小农民","room_cover":"audio/20171206/102757pqz0ja2f.jpg","room_views":"62221","user_name":"刘忙"},{"room_id":"228","room_name":"铁梨花","room_cover":"audio/20170210/032157csdb3fpy.jpg","room_views":"6771","user_name":"刘忙"},{"room_id":"216","room_name":"解密传奇","room_cover":"audio/20170114/0354053h8mztrk.jpg","room_views":"7348","user_name":"刘忙"},{"room_id":"238","room_name":"折腾岁月1新版","room_cover":"audio/20170114/043016a0ksm9cy.jpg","room_views":"12275","user_name":"刘忙"},{"room_id":"235","room_name":"史上最牛杂货铺","room_cover":"audio/20170114/042658nowqhk8x.jpg","room_views":"202686","user_name":"刘忙"},{"room_id":"234","room_name":"妖孽歪传","room_cover":"audio/20170114/042514to9efimn.jpg","room_views":"82746","user_name":"刘忙"},{"room_id":"211","room_name":"行脚商人的奇闻异录","room_cover":"audio/20170114/034253a1uk8w6j.jpg","room_views":"35119","user_name":"刘忙"},{"room_id":"210","room_name":"废柴道士1","room_cover":"audio/20170114/034113uncabedz.jpg","room_views":"51629","user_name":"刘忙"},{"room_id":"221","room_name":"蒙氏法医馆","room_cover":"audio/20170114/040307r0fhib6t.jpg","room_views":"6632","user_name":"刘忙"},{"room_id":"514","room_name":"废柴道士2","room_cover":"audio/20170708/1443479vygz5ws.jpg","room_views":"23169","user_name":"刘忙"},{"room_id":"223","room_name":"史上第一混搭","room_cover":"audio/20170114/04065150ikmrfq.jpg","room_views":"85780","user_name":"刘忙"},{"room_id":"224","room_name":"谁都别惹我","room_cover":"audio/20170114/0408500f6wvds9.jpg","room_views":"70204","user_name":"刘忙"},{"room_id":"230","room_name":"我就是妖怪","room_cover":"audio/20170114/041833z9wr7gs8.jpg","room_views":"58196","user_name":"刘忙"},{"room_id":"219","room_name":"刘老六传奇","room_cover":"audio/20170114/035953hsnl6a4v.jpg","room_views":"52596","user_name":"刘忙"},{"room_id":"236","room_name":"折腾岁月1经典版","room_cover":"audio/20170114/042933h2pl6fr8.jpg","room_views":"6452","user_name":"刘忙"},{"room_id":"523","room_name":"废柴道士3","room_cover":"audio/20170729/121913onc1jpqf.jpg","room_views":"14673","user_name":"刘忙"},{"room_id":"237","room_name":"折腾岁月2","room_cover":"audio/20170114/043148h3yvqfw1.jpg","room_views":"6170","user_name":"刘忙"}]
     */

    private UserInfoBean user_info;
    private List<NewsWorksBean> news_works;
    private List<ClassicsWorksBean> classics_works;

    public UserInfoBean getUser_info() { return user_info;}

    public void setUser_info(UserInfoBean user_info) { this.user_info = user_info;}

    public List<NewsWorksBean> getNews_works() { return news_works;}

    public void setNews_works(List<NewsWorksBean> news_works) { this.news_works = news_works;}

    public List<ClassicsWorksBean> getClassics_works() { return classics_works;}

    public void setClassics_works(List<ClassicsWorksBean> classics_works) { this.classics_works = classics_works;}

    public static class UserInfoBean {
        /**
         * user_head : 20170119193552235692.jpg
         * user_summary : 刘忙全部作品！欢迎关注！您的每一份支持，都是运行下去的最强动力！感谢各位老铁的支持。亲们的支持，是刘忙继续下去的力量和动力！拜谢！！！
         * user_name : 刘忙
         */

        private String user_head;
        private String user_summary;
        private String user_name;

        public String getUser_head() { return user_head;}

        public void setUser_head(String user_head) { this.user_head = user_head;}

        public String getUser_summary() { return user_summary;}

        public void setUser_summary(String user_summary) { this.user_summary = user_summary;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}
    }

    public static class NewsWorksBean {
        /**
         * room_id : 220
         * room_name : 流氓高手
         * room_cover : audio/20170114/040149b5wozfh9.jpg
         * room_views : 38575
         * user_name : 刘忙
         */

        private String room_id;
        private String room_name;
        private String room_cover;
        private String room_views;
        private String user_name;

        public String getRoom_id() { return room_id;}

        public void setRoom_id(String room_id) { this.room_id = room_id;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getRoom_cover() { return room_cover;}

        public void setRoom_cover(String room_cover) { this.room_cover = room_cover;}

        public String getRoom_views() { return room_views;}

        public void setRoom_views(String room_views) { this.room_views = room_views;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}
    }

    public static class ClassicsWorksBean {
        /**
         * room_id : 220
         * room_name : 流氓高手
         * room_cover : audio/20170114/040149b5wozfh9.jpg
         * room_views : 38575
         * user_name : 刘忙
         */

        private String room_id;
        private String room_name;
        private String room_cover;
        private String room_views;
        private String user_name;

        public String getRoom_id() { return room_id;}

        public void setRoom_id(String room_id) { this.room_id = room_id;}

        public String getRoom_name() { return room_name;}

        public void setRoom_name(String room_name) { this.room_name = room_name;}

        public String getRoom_cover() { return room_cover;}

        public void setRoom_cover(String room_cover) { this.room_cover = room_cover;}

        public String getRoom_views() { return room_views;}

        public void setRoom_views(String room_views) { this.room_views = room_views;}

        public String getUser_name() { return user_name;}

        public void setUser_name(String user_name) { this.user_name = user_name;}
    }
}
