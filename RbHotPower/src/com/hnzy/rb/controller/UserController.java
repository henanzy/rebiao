package com.hnzy.rb.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hnzy.rb.pojo.Rz;
import com.hnzy.rb.pojo.UserLogin;
import com.hnzy.rb.service.RbService;
import com.hnzy.rb.service.RzService;
import com.hnzy.rb.service.UserService;
import com.hnzy.rb.util.MD5Util;
import com.hnzy.rb.util.PropertyUtil;
import com.hnzy.rb.util.StringUtil;

@RequestMapping("UserCon")
@Controller
public class UserController
{
	@Autowired
	public UserService userService;
	@Autowired
	public RbService rbService;
	@Autowired
	public RzService rzService;
	public List<UserLogin> UserList;
	private String msg;
	//返回到登录页面
	@RequestMapping("toLogin")
	public String toLogin(){
		return "login";
		
	}
    //登录
	@RequestMapping("login")
	public String login(HttpSession session ,HttpServletRequest request,UserLogin userLogin,String userName,String passWord){
		
		if(StringUtil.isNotEmpty(userLogin.getUserName())&&StringUtil.isNotEmpty(userLogin.getPassWord())){
			userLogin.setPassWord(MD5Util.string2MD5(userLogin.getPassWord()));
			userLogin=userService.findNamePwd(userLogin.getUserName(), userLogin.getPassWord());
			if(userLogin!=null){
				//日志
//				Rz rz=new Rz();
//				rz.setCz("用户："+userLogin.getUserName()+"登录成功");
//				rz.setCzr(userLogin.getUserName());
//				rz.setCzsj(new Date());
//				rzService.InsRz(rz);
//				request.getSession().setAttribute("UserName", userLogin.getUserName());
				session.setAttribute("userName", userLogin.getUserName());
				request.getSession().setAttribute("admin",userLogin);
				return "index";
			}else{
				msg=PropertyUtil.Informationerror;
			}
		}else{
			msg=PropertyUtil.Informationempty;	
		}
		request.setAttribute("msg",msg);
		return "login";
	}
	@RequestMapping("updPwd")
	public String updPwd(){
		return "updPwd";

	}
	//更新密码
	@RequestMapping("UpdaPwd")
	public String UpdaPwd(HttpServletRequest request,Integer id,String password1,String password2){
		String paswd1=MD5Util.string2MD5(password1);
		String paswd2=MD5Util.string2MD5(password2);
		if(paswd1.equals(paswd2)){
			userService.UpdaPwd(paswd1,id);
			return"Uppwdscs";
		}else{
			msg=PropertyUtil.InformationNoSame;
			request.setAttribute("msg", msg);
			return "updPwd";
		}
	}
	//跳转到添加用户界面
	@RequestMapping("addYh")
	public String addYh(){
		return "addYh";
	}
	



	//添加用户
	@RequestMapping("regist")
	public String regist(HttpServletRequest request,String userName,String passWord){
		if(StringUtil.isNotEmpty(userName)&& StringUtil.isNotEmpty(passWord)){
			String paswd=MD5Util.string2MD5(passWord);
			if(userService.findName(userName)!=null){
				msg=PropertyUtil.InformationName;
				request.setAttribute("msg", msg);
				return "addYh";
			}else{
				userService.addNamePwd(userName, paswd);
				return "addYhScs";
			}
		}else{
			    msg=PropertyUtil.Informationempty;
			    request.setAttribute("msg", msg);
			    return "addYh";
		   }
			
	}
	//跳转到主页面
	@RequestMapping(value="index")
	public String home(HttpServletRequest request,HttpSession session,String userRole,String userName) throws UnsupportedEncodingException{
		userName=new String(userName.getBytes("ISO-8859-1"),"utf-8")+"";
//		System.out.println("热表集抄---------userRole----"+userRole);
//		System.out.println("热表集抄---------userName----"+userName);
		request.setAttribute("userRole", userRole);
	    session.setAttribute("userName",userName);
		request.setAttribute("userName", userName);
		
		//日志
		Rz rz=new Rz();
		rz.setCz("热表系统，用户："+userName+"登录成功");
		rz.setCzr(userName);
		rz.setCzsj(new Date());
		rzService.InsRz(rz);
		return "index";
	}
	
	
	public UserService getUserService()
	{
		return userService;
	}
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	public List<UserLogin> getUserList()
	{
		return UserList;
	}
	public void setUserList(List<UserLogin> userList)
	{
		UserList = userList;
	}
	
	
}
