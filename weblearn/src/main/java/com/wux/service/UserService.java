package com.wux.service;

import com.wux.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/4/18.
 */
public interface UserService {
    // 根据用户名查询
    User findUserByName(String name);
    // 根据用户名和密码查询
    User findUser(String name, String password);
    // 查询所有用户
    List<User> findAll();
    // 增加用户
    void addUser(User user);
    // 删除用户
    void removeUser(Integer id);
    // 修改用户
    void modifyUser(User user);
}
