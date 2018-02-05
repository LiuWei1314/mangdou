package com.p609915198.basemodule.net.response;

import java.io.Serializable;

/**
 * Created by mark.liu on 2017-11-4.
 */
public class SecondaryCategoryResponse implements Serializable {
    /**
     * category_secondary_name : 英语
     * category_secondary_id : 1
     * cover_image : disk/a.jpg
     */

    private String category_secondary_name;
    private String category_secondary_id;
    private String cover_image;

    public String getCategory_secondary_name() { return category_secondary_name;}

    public void setCategory_secondary_name(String category_secondary_name) { this.category_secondary_name = category_secondary_name;}

    public String getCategory_secondary_id() { return category_secondary_id;}

    public void setCategory_secondary_id(String category_secondary_id) { this.category_secondary_id = category_secondary_id;}

    public String getCover_image() { return cover_image;}

    public void setCover_image(String cover_image) { this.cover_image = cover_image;}
}
