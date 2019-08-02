package com.hnzy.rb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnzy.rb.datasource.DataSourceContextHolder;
import com.hnzy.rb.datasource.DataSourceType;
import com.hnzy.rb.pojo.Jf;
import com.hnzy.rb.pojo.RbJs;
import com.hnzy.rb.service.JfService;
import com.hnzy.rb.service.RbJsService;

@Controller
@RequestMapping("RbJsCon")
public class RbJsController {

	@Autowired
	private RbJsService rbJsService;
	@Autowired
	private JfService jfService;
	String rbfL;
	@RequestMapping("findRbJs")
	public String findRbJs(){
		List<RbJs> findRbJs=rbJsService.findRbJs();
		System.out.println(findRbJs);
         Jf jf=new Jf();
         String flow;
		for(int i=0;i<findRbJs.size();i++){
//			jf.setId(findRbJs.get(i).getYh().getId());
			if(findRbJs.get(i).getFlow()==null){
				flow="0";
			}else{
				flow=findRbJs.get(i).getFlow();
			}
			jf.setiNSTANT_FLOW(flow);//瞬时流量
			jf.setaCCUMULATE_FLOW(findRbJs.get(i).getEnergyLj());//累计流量
			jf.setmETER_CODE(findRbJs.get(i).getRbAd());//热表编号
			jf.setrEAD_TIME(findRbJs.get(i).getRecordTime());//抄表时间
			jf.setrEMARK(findRbJs.get(i).getBz());//备注
			jf.settHIS_VALUE(findRbJs.get(i).getEnergy());//本次表数
			jf.setlAST_VALUE(findRbJs.get(i).getBcBs());//上次表数
			jf.setrEAD_STATE("0");//远程抄表状态
			jf.setuSE_VALUE_KWH(findRbJs.get(i).getRlc());//热量差值
			if(findRbJs.get(i).getRbfl().equals("0")){
				rbfL="流量";
			}else{
				rbfL="面积";
			}
			jf.setsETTLE_TYPE(rbfL);//结算方式
			jf.setcYCLE("2019-2020");
//			jfService.updateJf(jf); //更新缴费系统
			
			DataSourceContextHolder.setDbType(DataSourceType.ds);
			jfService.insertJf(jf);//插入缴费系统
		    System.out.println(findRbJs);
		}
		return rbfL;
	}
}
