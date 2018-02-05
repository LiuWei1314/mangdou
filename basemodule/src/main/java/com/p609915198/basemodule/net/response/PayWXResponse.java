package com.p609915198.basemodule.net.response;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/13.
 */
public class PayWXResponse implements Serializable {
    /**
     * appid : wx52bb78a8cc1ea4f2
     * noncestr : 3hdlld4cyta6xs8dx3o2cxubcyhfx1lh
     * package : Sign=WXPay
     * partnerid : 1417645402
     * prepayid : wx20180114190348a8afd6e5530958205169
     * timestamp : 1515927828
     * sign : 62CCCEC34BCE1DA22C81D4C01C3C3441
     */

    private String appid;
    private String noncestr;
    private String partnerid;
    private String prepayid;
    private String timestamp;
    private String sign;

    public String getAppid() { return appid;}

    public void setAppid(String appid) { this.appid = appid;}

    public String getNoncestr() { return noncestr;}

    public void setNoncestr(String noncestr) { this.noncestr = noncestr;}

//    public String getPackageX() { return packageX;}
//
//    public void setPackageX(String packageX) { this.packageX = packageX;}

    public String getPartnerid() { return partnerid;}

    public void setPartnerid(String partnerid) { this.partnerid = partnerid;}

    public String getPrepayid() { return prepayid;}

    public void setPrepayid(String prepayid) { this.prepayid = prepayid;}

    public String getTimestamp() { return timestamp;}

    public void setTimestamp(String timestamp) { this.timestamp = timestamp;}

    public String getSign() { return sign;}

    public void setSign(String sign) { this.sign = sign;}
}
