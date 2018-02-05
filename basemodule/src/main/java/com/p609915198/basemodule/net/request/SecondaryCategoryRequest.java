package com.p609915198.basemodule.net.request;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class SecondaryCategoryRequest {
    private String category_id;//	一级分类ID	number
    private int length;//	（可选）数据长度	number	决定获取列表的长度，默认3

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
