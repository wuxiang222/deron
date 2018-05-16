package com.wux.service;

import com.wux.entity.Menus;
import com.wux.dao.MenusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/5/12.
 */
@Service
public class MenusServiceImpl implements MenusService {
    @Autowired
    private MenusDao menusDao;
    @Override
    public Menus findMenus(Integer id) {
        return menusDao.findMenus(id);
    }

    @Override
    public List<Menus> findAll() {
        return menusDao.findAll();
    }@Override
    public List<Menus> findPage(Integer page, Integer rows) {
        return menusDao.findPage((page-1)*rows, rows);
    }

    @Override
    public void addMenus(Menus menus) {
        menusDao.addMenus(menus);
    }

    @Override
    public void removeMenus(Integer id) {
        menusDao.removeMenus(id);
    }

    @Override
    public void modifyMenus(Menus menus) {
        menusDao.modifyMenus(menus);
    }

    @Override
    public Integer count() {
        return menusDao.count();
    }
}
