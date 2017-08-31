package com.zhiyou100.video.web.interceptor;



import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.User;


public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
     //  预处理
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws IOException {
	    Admin us = (Admin) req.getSession().getAttribute("user");
	   // System.out.println(us);
	     if(us == null){
	    	   res.sendRedirect(req.getContextPath()+"/admin/user/login.action");
	    	   return false;
	     }else{
            return true;   	 
		  
	
	}
		// return true;
	     
	}

}
