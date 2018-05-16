package com.wux.service;

import com.wux.entity.Menus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/5/12.
 */
public interface MenusService {
    Menus findMenus(Integer id);
    List<Menus> findAll();
    List<Menus> findPage(Integer page, Integer rows);
    void addMenus(Menus menus);
    void removeMenus(Integer id);
    void modifyMenus(Menus menus);
    Integer count();
}
