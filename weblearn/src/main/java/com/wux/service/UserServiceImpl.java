package com.wux.service;

import com.wux.dao.UserDao;
import com.wux.entity.User;
import com.wux.util.MD5Util;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/4/18.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }
    @Override
    @RequiresRoles("admin")
    public User findUser(String name, String password) {
        return userDao.findUser(name, password);
    }

    @Override
    public List<User> findAll() {
        return findAll();
    }

    @Override
    public void addUser(User user) {
        // 生成盐
        String salt = MD5Util.getSalt(4);

        userDao.addUser(user);
    }

    @Override
    public void removeUser(Integer id) {
        userDao.removeUser(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.modifyUser(user);
    }
}
