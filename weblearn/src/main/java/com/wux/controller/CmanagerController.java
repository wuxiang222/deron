package com.wux.controller;

import com.google.code.kaptcha.servlet.KaptchaExtend;
import com.wux.entity.Cmanager;
import com.wux.service.CmanagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("cmanager")
public class CmanagerController {
	@Autowired
	private CmanagerService cmanagerService;
	@Autowired  // 验证码处理对象
	private KaptchaExtend kaptchaExtend;
//	private String codeString;
	// 注册管理员
	@RequestMapping("regist")
	public String regist(Cmanager cmanager, String enCode, HttpServletRequest req){
		String codeString = (String)req.getSession().getAttribute("code");
		System.out.println(codeString);
		if (codeString!=null && codeString.equals(enCode)) {
			cmanagerService.registCmanager(cmanager);
			req.getSession().removeAttribute("code");
			return "redirect:/back/login.jsp";
		}
		return "redirect:/back/regist.jsp";
	}

	// 登录管理员
	@RequestMapping("login")
	public String login(String username, String password, String enCode, HttpServletRequest req, HttpSession session){
		String codeString = (String)req.getSession().getAttribute("code");
		if (codeString.equals(enCode)) {
			Cmanager cmanager = cmanagerService.showCmanagerByUsername(username, password, session);
			System.out.println(cmanager);
			if (cmanager != null) {
				UsernamePasswordToken token = new UsernamePasswordToken(username, password);
				token.setRememberMe(true);
				Subject subject = SecurityUtils.getSubject();
				try {
					subject.login(token);
					return "redirect:/back/main.jsp";
				} catch (AuthenticationException e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/back/login.jsp";
		
	}
	
}
