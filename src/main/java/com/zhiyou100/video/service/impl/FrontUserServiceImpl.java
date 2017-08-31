package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.UserExample;
import com.zhiyou100.video.model.UserExample.Criteria;
import com.zhiyou100.video.service.FrontUserService;

@Service
public class FrontUserServiceImpl implements FrontUserService{
    @Autowired
	UserMapper  um;
	@Override
	public void regist(User u) {
		// TODO Auto-generated method stub
		um.insertSelective(u);
	}
	
	@Override
	public User loginin(User u) {
		String email = u.getEmail();
		// TODO Auto-generated method stub
		String password = u.getPassword();
		return um.selectByemail(email,password);
	}

	@Override
	public User findUserByEmail(String email) {
		
		//System.out.println(um.findUserByEmail(email));
		return  um.findUserByEmail(email);
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		um.updateByPrimaryKeySelective(u);
	}

	@Override
	public void insertChptcha(String email, String captcha) {
		
		um.updateCaptchaByEmail(email,captcha);
	}

	@Override
	public User selectByEmailAndCaptcha(String email, String captcha) {
		// TODO Auto-generated method stub
		return um.selectByEmailAndCaptcha( email, captcha);
	}

	@Override
	public void updatePwd(String password, String email) {
		um.updatePWD(password,email);
		
	}

	@Override
	public void updatePwd22(String oldPassword, String email, String newPassword2) {
		um.updatePwd22( oldPassword, email, newPassword2);
	}

	@Override
	public void commitPic(User u) {
		um.updateByPrimaryKeySelective(u);
	}

	@Override
	public List<User> findUserByPasswordAndEmail(String password, String email) {
		UserExample us = new UserExample();
		us.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);
		return um.selectByExample(us);
	}

	

}
