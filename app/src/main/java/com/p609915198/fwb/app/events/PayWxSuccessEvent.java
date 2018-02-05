package com.p609915198.fwb.app.events;

import com.tencent.mm.opensdk.modelbase.BaseResp;

/**
 * Created by Administrator on 2018/1/23.
 */
public class PayWxSuccessEvent {
    public BaseResp mBaseResp;

    public PayWxSuccessEvent(BaseResp mBaseResp) {
        this.mBaseResp = mBaseResp;
    }
}
