package com.zhiyou100.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.AdminMapper;
import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
	AdminMapper am;


	@Override
	public Admin login(String username, String password) {
		// TODO Auto-generated method stub
		return am.login(username,password);
	}

}
