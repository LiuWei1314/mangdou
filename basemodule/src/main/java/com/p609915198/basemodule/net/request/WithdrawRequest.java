package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class WithdrawRequest {
    private double price;//	提现金额
    private int user_id;//	用户ID
    private String withdraw_name;//	账号名称
    private String withdraw_number;//	提现账号
    private String withdraw_type;//	提现类型

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getWithdraw_name() {
        return withdraw_name;
    }

    public void setWithdraw_name(String withdraw_name) {
        this.withdraw_name = withdraw_name;
    }

    public String getWithdraw_number() {
        return withdraw_number;
    }

    public void setWithdraw_number(String withdraw_number) {
        this.withdraw_number = withdraw_number;
    }

    public String getWithdraw_type() {
        return withdraw_type;
    }

    public void setWithdraw_type(String withdraw_type) {
        this.withdraw_type = withdraw_type;
    }
}
