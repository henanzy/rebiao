package com.hnzy.rb.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.rb.dao.UserDao;
import com.hnzy.rb.pojo.Rb;
import com.hnzy.rb.pojo.UserLogin;
import com.hnzy.rb.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserDao userDao;

	@Override
	public UserLogin findNamePwd(String userName, String passWord)
	{
		return userDao.findNamePwd(userName, passWord);
	}

	@Override
	public void UpdaPwd(String passWord,int id)
	{
		userDao.UpdaPwd(passWord,id);
	}

	@Override
	public void addNamePwd(String userName, String passWord)
	{
		userDao.addNamePwd(userName, passWord);
	}

	@Override
	public UserLogin findName(String userName)
	{
		return userDao.findName(userName);
	}


}
