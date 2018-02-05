package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-4.
 */
public class SecondaryRoomsRequest {
    private int page;//	第几页
    private int pagesize;//	页大小
    private int secondary_id;//	子分类ID

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getSecondary_id() {
        return secondary_id;
    }

    public void setSecondary_id(int secondary_id) {
        this.secondary_id = secondary_id;
    }
}
