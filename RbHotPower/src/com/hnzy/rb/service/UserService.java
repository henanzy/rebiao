package com.hnzy.rb.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hnzy.rb.pojo.Rb;
import com.hnzy.rb.pojo.UserLogin;

public interface UserService
{
	//根据用户名和密码查找用户
	public UserLogin findNamePwd(String userName,String passWord);
	//更新用户密码
	public void UpdaPwd(String passWord,int id);
	//添加用户
	public void addNamePwd(@Param("userName")String userName,@Param("passWord")String passWord);
	//根据用户名查找用户
	public UserLogin findName(@Param("userName")String userName);
}
