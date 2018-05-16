package com.wux.controller;

import com.wux.entity.User;
import com.wux.service.UserService;
import com.wux.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping("regist")
    public String register(User user,String captcha, HttpServletRequest request){
        String code = (String)request.getSession().getAttribute("code");
        System.out.println(code);
        if (code.equals(captcha)) {
            System.out.println("注册验证码输入正确");
            String salt = MD5Util.getSalt(4); user.setSalt(salt);
            String md5 = MD5Util.getMD5(user.getPassword(), salt); user.setPassword(md5);
            userService.addUser(user);
            return "redirect:/login.jsp";
        }
        return "redirect:/regist.jsp";
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


    // 修改信息
    public void removeUser(Integer id) {
        userService.removeUser(id);
    }

}
