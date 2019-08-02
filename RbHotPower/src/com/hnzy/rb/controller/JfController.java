package com.hnzy.rb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnzy.rb.datasource.DataSourceContextHolder;
import com.hnzy.rb.datasource.DataSourceType;
import com.hnzy.rb.pojo.Jf;
import com.hnzy.rb.service.JfService;
@Controller
@RequestMapping("JfCon")
public class JfController {
	@Autowired
	public JfService jfService;

	@RequestMapping("jf")
	public void jf(){
		DataSourceContextHolder.setDbType(DataSourceType.ds);
	List<Jf> jfList=jfService.jfSel();
	
	}
	
}
