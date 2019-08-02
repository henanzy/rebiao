package com.hnzy.rb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ztCon")
public class ZtreeRbController
{

	//跳转到页面
	@RequestMapping("RbMe")
	public String RbMe(){
		return "RbMe";
	}
}
