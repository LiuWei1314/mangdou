package com.p609915198.basemodule.net.response;

/**
 * Created by Administrator on 2018/1/10.
 */
public class ChargeResponse {
    /**
     * code : 200
     * msg : ok
     * danhao : 2018011050100575
     * pay_price : 0
     */

    private int code;
    private String msg;
    private String danhao;
    private int pay_price;

    public int getCode() { return code;}

    public void setCode(int code) { this.code = code;}

    public String getMsg() { return msg;}

    public void setMsg(String msg) { this.msg = msg;}

    public String getDanhao() { return danhao;}

    public void setDanhao(String danhao) { this.danhao = danhao;}

    public int getPay_price() { return pay_price;}

    public void setPay_price(int pay_price) { this.pay_price = pay_price;}
}
