package com.zhiyou100.video.web.controller.front;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.FrontUserService;
import com.zhiyou100.video.utils.MailUtil;

@Controller
public class frontUser {
    @Autowired
	FrontUserService fs;
	
   
    @RequestMapping(value="/front/index.action",method=RequestMethod.GET)
	public String login(){
		return "/front/index";  
   }
    
    @RequestMapping(value="/front/user/regist.action",method=RequestMethod.POST)
    @ResponseBody
	public String regist(User u){
    	User um = fs.findUserByEmail(u.getEmail());
    	if(um == null){
    		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
        	fs.regist(u);
        	//System.out.println(11);
    		return "success";  
    	}else{
    		return "fail";  
    	}
    	
   }
    

    @RequestMapping(value="/front/user/login.action",method=RequestMethod.POST)
    @ResponseBody
	public String loginin(User u,HttpSession session ){
    	//System.out.println(u);
    	u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
    	 User um  =fs.loginin(u);
    	session.setAttribute("list",um );
    	//System.out.println(list);
    	if(um !=null ){
    		return "success"; 
    	}
		return "fail";  
   }
	
    
    @RequestMapping(value="/front/user/index.action",method=RequestMethod.GET)
   	public String login11(HttpSession session,HttpSession se){
		User u= (User) session.getAttribute("list");
        String email = u.getEmail();
       // System.out.println(email);
        User um = fs.findUserByEmail(email);
       // System.out.println(um);
        email = um.getEmail();
       int id = um.getId();
        se.setAttribute("user", um);
        se.setAttribute("lll", email);
        se.setAttribute("id", id);
   		return "/front/user/index";  
      }

    @RequestMapping(value="/front/user/profile.action",method=RequestMethod.GET)
   	public String log(HttpSession session,HttpSession se){
		  		
    	return "/front/user/profile";  
      }
    
    @RequestMapping(value="/front/user/profile.action",method=RequestMethod.POST)
   	public String update(User u){
    	 
    	 fs.updateUser(u);
    	 
        // System.out.println(u);
   		return "redirect:/front/user/index.action";  
      }

     //********改密码**************************************
    
    @RequestMapping(value="/front/user/password1.action")
    @ResponseBody
   	public String pword(String password,HttpSession session){
    	//System.out.println(password);
    	String email = (String) session.getAttribute("lll");
    	password = DigestUtils.md5DigestAsHex(password.getBytes());
        List<User> list = fs.findUserByPasswordAndEmail(password,email);
        if(list.size() !=0){
        	return "success";  
        }
    	return "fail";  
      }
    
    @RequestMapping(value="/front/user/password.action",method=RequestMethod.GET)
   	public String password(){
    	return "/front/user/password";  
      }
    
    @RequestMapping(value="/front/user/password.action",method=RequestMethod.POST)
    @ResponseBody
   	public String password(String oldPassword,String newPassword,HttpSession session){
    	oldPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
    	newPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
    	String email = (String) session.getAttribute("lll");
    	fs.updatePwd22(oldPassword, email,newPassword);
    	//System.out.println(oldPassword+"-----"+newPassword+"+++++"+email);
   		return "success";  
      }

 // ********忘记密码**************************************
    @RequestMapping(value="/front/forgetpwd.action",method=RequestMethod.GET)
    public String forgetpwd(){
    	
    	//System.out.println(11);
    	return "/front/user/forget_pwd";  
    }
    @RequestMapping(value="/front/forgetpwd.action",method=RequestMethod.POST)
    public String forgetPWD(String email,String captcha){
    	
         User us = fs.selectByEmailAndCaptcha(email,captcha);
    	if(us != null){
    		return "/front/user/reset_pwd";
    	}else{
    		return "redirect:/forgetpwd.action";
    	}
    }
    
    // ********发邮件**************************************
    @RequestMapping(value="/front/sendemail.action")
    @ResponseBody
    public String sendMail(String email,HttpSession session) throws Exception{
    	//System.out.println(email);
    	Random  d = new Random();
    	String captcha = "";
    	for(int i=0;i<5;i++){
    	int num = d.nextInt(10);
    	captcha += num+"";
    	}
    	fs.insertChptcha(email,captcha);
    	MailUtil.send(email, "验证码", captcha);
        User us =	fs.findUserByEmail(email);
        session.setAttribute("email", email);
       // System.out.println(us.getCaptcha());
    	if(us.getCaptcha().equals(captcha)){
    		return "success";  
    	}else{
    		return "false"; 
    	}
    }
    
    // ********重置密码**************************************
    @RequestMapping(value="/front/resetpwd.action",method=RequestMethod.POST)
    public String updatepwd(String password,String email,HttpSession session){
    	email = (String) session.getAttribute("email");
    	password = DigestUtils.md5DigestAsHex(password.getBytes());
    	//System.out.println(password+"++++"+email);
    	fs.updatePwd(password,email);
    	return "redirect:/front/index.action";  
    }
    
    
  /*  上传图片**********************************************/
    @RequestMapping(value="/front/user/avatar.action",method=RequestMethod.GET)
    public String pic(){
    	
    	return "/front/user/avatar";  
    }
    
    @RequestMapping(value="/front/user/avatar.action",method=RequestMethod.POST)
    public String pic(User u, MultipartFile image_file,HttpSession session) throws IllegalStateException, IOException{
    	
    	//System.out.println(r);
    			//r.setR_updatetime(new Timestamp(System.currentTimeMillis()));
    			String str = UUID.randomUUID().toString().replaceAll("-", "");
    			String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
    			String fileName = str+"."+ext;
    			//System.out.println(fileName);
    			u.setId((Integer) session.getAttribute("id"));
    			//System.out.println(session.getAttribute("id"));
    			u.setHeadUrl(fileName);
    			fs.commitPic(u);
    			String path = "D:\\upload";
    			image_file.transferTo(new File(path+"\\"+fileName));
    	        return "redirect:/front/user/index.action";  
    }
    
  // ********内部退出**************************************
    @RequestMapping(value="/front/user/logout.action",method=RequestMethod.GET)
    public String logout(HttpSession session){
    	session.invalidate();
    	return "redirect:/front/index.action";  
    }
   
    
   // ***********************注册检查邮箱是否可用************
    @RequestMapping(value="/front/user/email.action")
    @ResponseBody
    public String checkMail(String email){
    	//System.out.println(email);
    	User us = fs.findUserByEmail(email);
    	if(us == null){
    		return "success";
    	}else{
    		return "fail";
    	}
    }
    
    /*@RequestMapping(value="/front/user/logout.action",method=RequestMethod.GET)
    public String logout11(HttpSession session){
    	//session.invalidate();
    	return "redirect:/front/index.action";  
    }*/
    
    
    
}

