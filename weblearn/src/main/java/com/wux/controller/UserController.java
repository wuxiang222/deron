package com.wux.controller;

import com.wux.entity.User;
import com.wux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wuxiang
 * on 2018/4/18.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    // 注册
    public void register(User user){

    }

    // 登录
    @RequestMapping("login")
    @ResponseBody
    public User login(String name, String password){
        return userService.findUser(name, password);
    }

    // 修改信息
    public void removeUser(Integer id) {
        userService.removeUser(id);
    }
    // 注销
    public void logout(){

    }
}
