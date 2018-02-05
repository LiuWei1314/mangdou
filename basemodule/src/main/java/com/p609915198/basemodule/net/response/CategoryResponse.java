package com.p609915198.basemodule.net.response;

import java.io.Serializable;

/**
 * Created by mark.liu on 2017-11-6.
 */
public class CategoryResponse implements Serializable {

    /**
     * category_id : 1
     * category_name : 有声小说
     */

    private String category_id;
    private String category_name;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() { return category_name;}

    public void setCategory_name(String category_name) { this.category_name = category_name;}
}
