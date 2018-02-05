package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-4.
 */
public class ChangeUserInfoRequest {
    private int age;// (可选) 年龄
    private String bank;// (可选) 银行卡
    private String bank_name;// (可选) 银行卡名称
    private String city;// (可选) 城市
    private String head;// (可选) 头像文件
    private String name;// (可选) 名称
    private int sex;// (可选) 性别 (1:男 2:女 3:保密)
    private String user_id;// 用户ID
    private double volley;// (可选) 余额
    private String wechat;// (可选) 微信
    private String wechat_name;// (可选) 微信名称
    private String words;// (可选) 简语
    private String zhi_fu_bao;// (可选) 支付宝
    private String zhi_fu_bao_name;// (可选) 支付宝名称

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public double getVolley() {
        return volley;
    }

    public void setVolley(double volley) {
        this.volley = volley;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getWechat_name() {
        return wechat_name;
    }

    public void setWechat_name(String wechat_name) {
        this.wechat_name = wechat_name;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getZhi_fu_bao() {
        return zhi_fu_bao;
    }

    public void setZhi_fu_bao(String zhi_fu_bao) {
        this.zhi_fu_bao = zhi_fu_bao;
    }

    public String getZhi_fu_bao_name() {
        return zhi_fu_bao_name;
    }

    public void setZhi_fu_bao_name(String zhi_fu_bao_name) {
        this.zhi_fu_bao_name = zhi_fu_bao_name;
    }
}
