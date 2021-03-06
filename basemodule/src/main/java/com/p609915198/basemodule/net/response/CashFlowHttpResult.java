package com.p609915198.basemodule.net.response;

import java.util.List;

/**
 * Created by mark.liu on 2018-3-29.
 */
public class CashFlowHttpResult {

    /**
     * total : 15
     * per_page : 20
     * current_page : 1
     * last_page : 1
     * next_page_url : null
     * prev_page_url : null
     * from : 1
     * to : 15
     * data : [{"id":959074,"userid":53,"cash":"5.70","addtime":"2018-03-20 21:48:06","detail":"购买专辑《黄金瞳》下的音频花费5.7忙豆","type":1,"remark":null},{"id":956043,"userid":53,"cash":"1.90","addtime":"2018-03-20 01:20:12","detail":"购买专辑《黄金瞳》下的音频花费1.9忙豆","type":1,"remark":null},{"id":944917,"userid":53,"cash":"2.28","addtime":"2018-03-16 23:52:56","detail":"购买专辑《黄金瞳》下的音频花费2.28忙豆","type":1,"remark":null},{"id":930462,"userid":53,"cash":"1.52","addtime":"2018-03-13 00:13:53","detail":"购买专辑《黄金瞳》下的音频花费1.52忙豆","type":1,"remark":null},{"id":879028,"userid":53,"cash":"4.37","addtime":"2018-02-26 23:11:41","detail":"购买专辑《黄金瞳》下的音频花费4.37忙豆","type":1,"remark":null},{"id":871840,"userid":53,"cash":"3.80","addtime":"2018-02-24 21:35:26","detail":"购买专辑《黄金瞳》下的音频花费3.8忙豆","type":1,"remark":null},{"id":865479,"userid":53,"cash":"2.09","addtime":"2018-02-23 03:04:45","detail":"购买专辑《黄金瞳》下的音频花费2.09忙豆","type":1,"remark":null},{"id":853460,"userid":53,"cash":"2.09","addtime":"2018-02-19 00:02:39","detail":"购买专辑《黄金瞳》下的音频花费2.09忙豆","type":1,"remark":null},{"id":853192,"userid":53,"cash":"0.57","addtime":"2018-02-18 22:45:17","detail":"购买专辑《黄金瞳》下的音频花费0.57忙豆","type":1,"remark":null},{"id":655512,"userid":53,"cash":"2.09","addtime":"2017-12-16 00:05:30","detail":"购买专辑《黄金瞳》下的音频花费2.09忙豆","type":1,"remark":null},{"id":639106,"userid":53,"cash":"2.09","addtime":"2017-12-10 00:49:16","detail":"购买专辑《黄金瞳》下的音频花费2.09忙豆","type":1,"remark":null},{"id":225424,"userid":53,"cash":"3.99","addtime":"2017-05-21 21:13:16","detail":"购买专辑《黄金瞳》下的音频花费3.99忙豆","type":1,"remark":null},{"id":61800,"userid":53,"cash":"1.33","addtime":"2017-02-26 19:08:50","detail":"购买专辑《黄金瞳》下的音频花费1.33忙豆","type":1,"remark":null},{"id":43964,"userid":53,"cash":"0.76","addtime":"2017-02-16 23:16:21","detail":"购买专辑《黄金瞳》下的音频花费0.76忙豆","type":1,"remark":null},{"id":116,"userid":53,"cash":"1.71","addtime":"2017-01-18 13:08:08","detail":"购买专辑《黄金瞳》下的音频花费1.71忙豆","type":1,"remark":null}]
     */

    private int total;
    private int per_page;
    private int current_page;
    private int last_page;
    private Object next_page_url;
    private Object prev_page_url;
    private int from;
    private int to;
    private List<DataBean> data;

    public int getTotal() { return total;}

    public void setTotal(int total) { this.total = total;}

    public int getPer_page() { return per_page;}

    public void setPer_page(int per_page) { this.per_page = per_page;}

    public int getCurrent_page() { return current_page;}

    public void setCurrent_page(int current_page) { this.current_page = current_page;}

    public int getLast_page() { return last_page;}

    public void setLast_page(int last_page) { this.last_page = last_page;}

    public Object getNext_page_url() { return next_page_url;}

    public void setNext_page_url(Object next_page_url) { this.next_page_url = next_page_url;}

    public Object getPrev_page_url() { return prev_page_url;}

    public void setPrev_page_url(Object prev_page_url) { this.prev_page_url = prev_page_url;}

    public int getFrom() { return from;}

    public void setFrom(int from) { this.from = from;}

    public int getTo() { return to;}

    public void setTo(int to) { this.to = to;}

    public List<DataBean> getData() { return data;}

    public void setData(List<DataBean> data) { this.data = data;}

    public static class DataBean {
        /**
         * id : 959074
         * userid : 53
         * cash : 5.70
         * addtime : 2018-03-20 21:48:06
         * detail : 购买专辑《黄金瞳》下的音频花费5.7忙豆
         * type : 1
         * remark : null
         */

        private int id;
        private int userid;
        private String cash;
        private String addtime;
        private String detail;
        private int type;
        private Object remark;

        public int getId() { return id;}

        public void setId(int id) { this.id = id;}

        public int getUserid() { return userid;}

        public void setUserid(int userid) { this.userid = userid;}

        public String getCash() { return cash;}

        public void setCash(String cash) { this.cash = cash;}

        public String getAddtime() { return addtime;}

        public void setAddtime(String addtime) { this.addtime = addtime;}

        public String getDetail() { return detail;}

        public void setDetail(String detail) { this.detail = detail;}

        public int getType() { return type;}

        public void setType(int type) { this.type = type;}

        public Object getRemark() { return remark;}

        public void setRemark(Object remark) { this.remark = remark;}
    }
}
