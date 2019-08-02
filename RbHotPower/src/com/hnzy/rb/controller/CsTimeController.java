package com.hnzy.rb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnzy.rb.pojo.CsTime;
import com.hnzy.rb.service.CsTimeService;

@Controller
@RequestMapping("CsTimeCon")
public class CsTimeController
{
	@Autowired
	private CsTimeService csTimeService;
    private List<CsTime> CsTimeList;
	private CsTime csTime;
	@RequestMapping("CsMe")
	public String CsMe(HttpServletRequest request){
		//获取抄表设定的时间
		List<CsTime> csTime=csTimeService.findCsTime();
		request.setAttribute("csTime",csTime.get(1).getCstime());
		request.setAttribute("csTime1",csTime.get(2).getCstime());
		return "CsMe";
	   }
		//更新抄表设定的时间
    	@RequestMapping("updCsTime")
		public String updCsTime(String csTime,String csTime1){
			csTimeService.updCsTime(csTime);
			csTimeService.updCsTime1(csTime1);
			return "CbSuccess";	
		}
}
