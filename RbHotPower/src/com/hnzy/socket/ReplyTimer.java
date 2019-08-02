package com.hnzy.socket;

import java.util.Date;
import java.util.Timer;

public class ReplyTimer {

	private final Timer timer = new Timer();
	private final int min;
 
	public ReplyTimer(int minutes) {
		min=minutes;
	  }

	public void start() {
		Date date = new Date();
		//每个一小时执行一次
		timer.schedule(new ReplyTask(), date,  min * 60 * 1000);
	}
     public void stop(){
    	 timer.cancel();
    	 
     }
}
