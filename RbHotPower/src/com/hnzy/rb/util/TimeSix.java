package com.hnzy.rb.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hnzy.rb.pojo.Rb;
import com.hnzy.rb.service.RbService;

import net.sf.ehcache.search.expression.And;
@Controller
public class TimeSix
{
	@Autowired
	private RbService rbservice;
	//热表异常
//		public void rbexp(){
//			Exp();
//			GHExp();
//		}
		//温差在20度以上，累计热量不累加，用户名字蓝色
		public void GHExp(){
			
			List<Rb> rb=rbservice.SelRbExp(); 
			for(int i=0;i<rb.size();i++){
				List<Rb> rbs=rbservice.SelRbEp(rb.get(i).getRbAd());
				if(rbs.size()>=2){
				if( rbs.get(0).getDiffTmp()!=null && rbs.get(0).getDiffTmp()>20){
						Double energy=rbs.get(0).getEnergy();
						Double energys=rbs.get(1).getEnergy();
						if(energy!=null&& energys!=null&&energy.equals(energys)){
							rbservice.UpExp(rb.get(i).getRbAd(),2);
					}
				}
				}
			}
		}
		//供水温度40度以上，回水温度30度以上，累计热量不累加红色
		public void Exp(){
			List<Rb> rb=rbservice.SelRbExp();
			for(int i=0;i<rb.size();i++){
				List<Rb> rbs=rbservice.SelRbEp(rb.get(i).getRbAd());
				if(rbs.size()>=2){
					if(rbs.get(0).getInTmp()!=null && rbs.get(0).getOutTmp()!=null&&rbs.get(0).getInTmp()>40&& rbs.get(0).getOutTmp()>30){
						Double energy=rbs.get(0).getEnergy();
						Double energys=rbs.get(1).getEnergy();
						if(energy!=null && energys!=null&&energy.equals(energys)){
							rbservice.UpExp(rb.get(i).getRbAd(),1);
						}
					  }
					}
				}
			}
}
