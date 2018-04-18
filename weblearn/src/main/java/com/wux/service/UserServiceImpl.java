package com.wux.service;

import com.wux.dao.UserDao;
import com.wux.entity.User;
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
    public User findUser(String name, String password) {
        return userDao.findUser(name, password);
    }

    @Override
    public List<User> findAll() {
        return findAll();
    }

    @Override
    public void addUser(User user) {
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
