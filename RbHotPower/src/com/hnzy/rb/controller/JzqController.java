package com.hnzy.rb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnzy.rb.pojo.Qg;
import com.hnzy.rb.service.QgService;
import com.hnzy.socket.server.ServerSessionMap;
import com.hnzy.socket.util.CzUtil;
import com.hnzy.socket.util.MapUtils;

@RequestMapping("jzqCon")
@Controller
public class JzqController
{
	@Autowired
	private QgService qgServic;
	
	public List<Qg> jzqlist;
	private static Log log = LogFactory.getLog(JzqController.class);
	@RequestMapping("jzqList")
	public String jzqList(HttpServletRequest request){
		jzqlist=qgServic.findJzq();
		request.setAttribute("jzqlist", jzqlist);
		return "Jzqgl";
	}
	
	@RequestMapping("Cxzt")
	@ResponseBody 
	public String Cxzt(String jzqId,String jzqIp,String jzqPort){
		String pt = "/" + jzqIp + ":" + jzqPort;
		String ja = "F00A0100" + jzqId ;
		boolean sessionmap = cz(ja, pt);
		log.info("查询状态发送数据："+ja);
		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(sessionmap==true && MapUtils.getMapUtils().get("jzq")!=null && MapUtils.getMapUtils().get("jzq").equals(jzqId)){
			 MapUtils.getMapUtils().add("jzq", null);
			return "0";
		}else if(sessionmap==false){
			 MapUtils.getMapUtils().add("jzq", null);
			log.info("发送数据失败,集中器不在线");
			return "2";
		}else {
			 MapUtils.getMapUtils().add("jzq", null);
			return "1";
		}	
	}
	//抽取相同部分
	public boolean cz(String ja, String pt) {
		// 把十六进制数，转换为十进制相加
		int jia = CzUtil.FsZh(ja);
		// 十进制转换为十六进制
		String hex = Integer.toHexString(jia);
		// 截取相加结果后两位
		String je = null;
		for (int j = 0; j < hex.length() - 1; j++) {
			je = hex.charAt(hex.length() - 2) + "" + hex.charAt(hex.length() - 1);
		}
		String[] keys = new String[] { pt };
		String mString = ja + je + "FF";
		// 解码
		byte[] b = CzUtil.jm(mString);
		ServerSessionMap sessionMap = ServerSessionMap.getInstance();
		boolean sessionmap = sessionMap.sendMessage(keys, b);
		return sessionmap;

	}
}
