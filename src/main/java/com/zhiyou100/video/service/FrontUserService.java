package com.zhiyou100.video.service;



import java.util.List;

import com.zhiyou100.video.model.User;

public interface FrontUserService {

	User findUserByEmail(String email);
	
	void regist(User u);

	User loginin(User u);

	void updateUser(User u);

	void insertChptcha(String email, String captcha);

	User selectByEmailAndCaptcha(String email, String captcha);

	void updatePwd(String password, String email);

	void updatePwd22(String oldPassword, String email, String newPassword2);

	void commitPic(User u);

	List<User> findUserByPasswordAndEmail(String password, String email);


	
	
	
}
