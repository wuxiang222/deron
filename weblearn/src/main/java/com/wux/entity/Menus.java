package com.wux.entity;

import java.io.Serializable;

/**
 * deron.menus表
 * Created by wuxiang
 * on 2018/5/12.
 */
public class Menus implements Serializable{
    private Integer id;
    private String menuName;
    private Menus parent;
    private Integer orderId;
    private Integer authId;
    private String imgUrl;

    public Menus() {
    }

    public Menus(Integer id, String menuName, Menus parent, Integer orderId, Integer authId, String imgUrl) {
        this.id = id;
        this.menuName = menuName;
        this.parent = parent;
        this.orderId = orderId;
        this.authId = authId;
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Menus getParent() {
        return parent;
    }

    public void setParent(Menus parent) {
        this.parent = parent;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "MenusCCC{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", parent=" + parent +
                ", orderId=" + orderId +
                ", authId=" + authId +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
