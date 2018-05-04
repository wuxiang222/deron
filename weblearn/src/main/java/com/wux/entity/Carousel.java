package com.wux.entity;

import java.io.Serializable;

/**
 * Created by wuxiang
 * on 2018/4/20.
 */
/*id int unsigned primary key auto_increment,#轮播图id
realname VARCHAR(100),#图片名称
imgurl varchar(200),#图片对应的链接
description varchar(1024),#描述
onstatus tinyint #轮播状态*/

public class Carousel implements Serializable {
    private Integer id;
    private String realname;
    private String imgurl;
    private String description;
    private Boolean onstatus;

    public Carousel() {
    }

    public Carousel(Integer id, String realname, String imgurl, String description, Boolean onstatus) {
        this.id = id;
        this.realname = realname;
        this.imgurl = imgurl;
        this.description = description;
        this.onstatus = onstatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getOnstatus() {
        return onstatus;
    }

    public void setOnstatus(Boolean onstatus) {
        this.onstatus = onstatus;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", description='" + description + '\'' +
                ", onstatus=" + onstatus +
                '}';
    }
}
