package com.wux.controller;

import com.wux.entity.User;
import com.wux.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

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
    public ModelAndView login(String name, String password){
        ModelAndView modelAndView = new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        token.setRememberMe(true);
        try {
            subject.login(token);
            modelAndView.setViewName("redirect:/index.jsp");
            return modelAndView;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            modelAndView.setViewName("redirect: ../login.jsp");
            return modelAndView;
        }
    }

    //注销
    @RequestMapping("logout")
    public ModelAndView logout(){
        return new ModelAndView("redirect: /login.jsp");
    }

    // 修改信息
    public void removeUser(Integer id) {
        userService.removeUser(id);
    }

}
