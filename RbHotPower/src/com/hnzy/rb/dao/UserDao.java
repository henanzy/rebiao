package com.hnzy.rb.dao;


import org.apache.ibatis.annotations.Param;

import com.hnzy.rb.base.BaseDao;
import com.hnzy.rb.pojo.UserLogin;

public interface UserDao extends BaseDao<UserLogin>
{
	//根据用户名和密码查找用户
	public UserLogin findNamePwd(@Param("userName")String userName,@Param("passWord")String passWord);
	//更新用户密码
	public void UpdaPwd(@Param("passWord")String passWord,@Param("id")int id);
	//添加用户
	public void addNamePwd(@Param("userName")String userName,@Param("passWord")String passWord);
	//根据用户名查找用户
	public UserLogin findName(@Param("userName")String userName);

}
