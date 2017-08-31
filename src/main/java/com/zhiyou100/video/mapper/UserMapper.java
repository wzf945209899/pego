package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User selectByemail(@Param("email")String email, @Param("password")String password);

	User findUserByEmail(String email);

	void updateCaptchaByEmail(@Param("email")String email,@Param("captcha") String captcha);

	User selectByEmailAndCaptcha(@Param("email")String email, @Param("captcha")String captcha);

	void updatePWD(@Param("password")String password,@Param("email") String email);

	void updatePwd22(@Param("newPassword2")String newPassword2, @Param("email")String email, @Param("oldPassword")String oldPassword);

	
	


}

	