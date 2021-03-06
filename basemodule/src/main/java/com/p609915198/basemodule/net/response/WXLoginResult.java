package com.p609915198.basemodule.net.response;

/**
 * Created by mark.liu on 2018-5-29.
 */
public class WXLoginResult {
    /**
     * access_token : ACCESS_TOKEN
     * expires_in : 7200
     * refresh_token : REFRESH_TOKEN
     * openid : OPENID
     * scope : SCOPE
     * unionid : o6_bmasdasdsad6_2sgVt7hMZOPfL
     */

    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid;

    /**
     * {"errcode":40029,"errmsg":"invalid code"}
     */
    private String errcode;
    private String errmsg;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getAccess_token() { return access_token;}

    public void setAccess_token(String access_token) { this.access_token = access_token;}

    public int getExpires_in() { return expires_in;}

    public void setExpires_in(int expires_in) { this.expires_in = expires_in;}

    public String getRefresh_token() { return refresh_token;}

    public void setRefresh_token(String refresh_token) { this.refresh_token = refresh_token;}

    public String getOpenid() { return openid;}

    public void setOpenid(String openid) { this.openid = openid;}

    public String getScope() { return scope;}

    public void setScope(String scope) { this.scope = scope;}

    public String getUnionid() { return unionid;}

    public void setUnionid(String unionid) { this.unionid = unionid;}

    @Override
    public String toString() {
        return "WXLoginResult{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", refresh_token='" + refresh_token + '\'' +
                ", openid='" + openid + '\'' +
                ", scope='" + scope + '\'' +
                ", unionid='" + unionid + '\'' +
                ", errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
