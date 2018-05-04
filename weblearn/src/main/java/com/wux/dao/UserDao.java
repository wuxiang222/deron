package com.wux.dao;

import com.wux.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/4/18.
 */
@Repository
public interface UserDao {
    // 根据用户名查询
    User findUserByName(@Param("name") String name);
    // 根据用户名和密码查询
    User findUser(@Param("name") String name, @Param("password") String password);
    // 查询所有用户
    List<User> findAll();
    // 增加用户
    void addUser(User user);
    // 删除用户
    void removeUser(@Param("id")Integer id);
    // 修改用户
    void modifyUser(User user);
}
