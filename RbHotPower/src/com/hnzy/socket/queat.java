package com.hnzy.socket;

import java.util.List;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hnzy.rb.pojo.CsTime;
import com.hnzy.rb.service.CsTimeService;


public class queat {
	@Autowired
	private CsTimeService csTimeService;
	public void queats(){
		 List<CsTime> csTime=csTimeService.findCsTime();
		int time1=csTime.get(1).getCstime();
		int time2=csTime.get(2).getCstime();
		String time="0 0 "+time1+","+time2+" * * ?";
		 SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
         Scheduler sche = null;
		try {
			sche = gSchedulerFactory.getScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         String job_name = "动态任务调度";
         System.out.println("【系统启动】开始(每1秒输出一次)...");
         QuartzManagerS.addJob(sche, job_name, QuartzJobExample.class, time);
	}
}
