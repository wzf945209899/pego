package com.zhiyou100.video.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminService as;
	
	@RequestMapping("/user/login.action")
	public String login(String loginName,String loginPwd,HttpSession session, HttpServletRequest request){
	String	pwd = DigestUtils.md5DigestAsHex(loginPwd.getBytes());
    Admin ad =as.login(loginName,pwd);
   // System.out.println(ad);
    if(ad == null){
    	  request.setAttribute("errorMessage", "用户名密码不匹配");
		return "/user/index";  
	}else {
		session.setAttribute("user",ad);
		return "forward:/video/videoList.action";
	  } 
   }
}

