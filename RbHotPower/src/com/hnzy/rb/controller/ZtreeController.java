package com.hnzy.rb.controller;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hnzy.custompojo.VillageTreeNodes;
import com.hnzy.custompojo.villageXq;
import com.hnzy.rb.pojo.Village;
import com.hnzy.rb.service.VillageService;

@Controller
@RequestMapping("/ZtreeCont")
public class ZtreeController {

	@Autowired
	private VillageService villageService;
	private List<Village> villages;
	@RequestMapping("ztree")
	public String getVillageTreeMenu(HttpServletRequest request) {
		List<VillageTreeNodes> nodes = new ArrayList<VillageTreeNodes>();
		List<Village> xqList = this.villageService.findXQ();
		
		for (int i = 0; i < xqList.size(); i++) {
			String xqName = xqList.get(i).getXqName();
			VillageTreeNodes nodesXQ = new VillageTreeNodes();
			nodesXQ.setNodeId(i + 11);////i=0,11
			nodesXQ.setParentId(0);
			nodesXQ.setNodeName(xqName);
			nodes.add(nodesXQ);
			Village villageXQ = new Village();
			villageXQ.setXqName(xqName);
			List<Village> boList = this.villageService.findBOByXQ(villageXQ);
			for (int j = 0; j < boList.size(); j++) {
				String buildnO = boList.get(j).getRbLyName();
//				String buildNo=String.valueOf(buildnO);
				VillageTreeNodes nodesBO = new VillageTreeNodes();
				if (i > 0) {
					if (j > 0) {
						nodesBO.setNodeId((i + 110) * 100 + j);//id=110
					} else {
						nodesBO.setNodeId((i + 110) * 100);
					}
				} else if (j > 0) {
					nodesBO.setNodeId((i + 110) * 100 + j);
				} else {
					nodesBO.setNodeId((i + 110) * 100);
				}
				nodesBO.setParentId(i + 11); //i=0,11
				nodesBO.setNodeName(buildnO);
				nodes.add(nodesBO);
				Village villageBO = new Village();
				villageBO.setXqName(xqName);
				villageBO.setRbLyName(buildnO);
				List<Village> coList = this.villageService.findCOByXQAndBO(villageBO);
				for (int k = 0; k < coList.size(); k++) {
					String cellNO = coList.get(k).getCellNO();
					VillageTreeNodes nodesCO = new VillageTreeNodes();
					if (i > 0) {
						if (j > 0) {
							if (k > 0) {
								nodesCO.setNodeId(((i + 110) * 100 + j) * 10 + k);
							} else {
								nodesCO.setNodeId(((i + 110) * 100 + j) * 10);
							}
							nodesCO.setParentId((i + 110) * 100 + j); //i=0,j=0 110
						} else if (k > 0) {
							nodesCO.setNodeId((i + 110) * 1000 + k);
							nodesCO.setParentId((i + 110) * 100);
						} else {
							nodesCO.setNodeId((i + 110) * 1000);
							nodesCO.setParentId((i + 110) * 100);
						}
					} else if (j > 0) {
						if (k > 0) {
							nodesCO.setNodeId(((i + 110) * 100 + j) * 10 + k);
						} else {
							nodesCO.setNodeId(((i + 110) * 100 + j) * 10);
						}
						nodesCO.setParentId((i + 110) * 100 + j);
					} else if (k > 0) {
						nodesCO.setNodeId((i + 110) * 1000 + k);
						nodesCO.setParentId((i + 110) * 100);
					} else {
						nodesCO.setNodeId((i + 110) * 1000);
						nodesCO.setParentId((i + 110) * 100);
					}
					String cellnO=String.valueOf(cellNO);
					nodesCO.setNodeName(cellnO);
					nodes.add(nodesCO);
				}
			}
		}
		StringBuffer buf=new StringBuffer();
		for (int i = 0; i < nodes.size(); i++) {
			VillageTreeNodes villageNodes = nodes.get(i);
			buf.append("{id:" + villageNodes.getNodeId() + ",pId:"
					+ villageNodes.getParentId() + " ,name: \""+ villageNodes.getNodeName()  + "\"},");
		}
		buf.deleteCharAt(buf.length() - 1);
		request.setAttribute("buf", buf);
		return "ztree";
		}

//	@RequestMapping("findz")
//	public String findz(HttpServletRequest request, @Param("xqName") String xqName, @Param("buildNO") String buildNO,
//			@Param("cellNO") Integer cellNO) throws UnsupportedEncodingException{
//		if(xqName!=null){
//			xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
//		}
//		return "fm";
//	}

	public List<Village> getVillages() {
		return villages;
	}

	public void setVillages(List<Village> villages) {
		this.villages = villages;
	}

	@RequestMapping("findName")
	@ResponseBody
	public JSONObject findName(){
		JSONObject jsonObject=new JSONObject();
		List<Village> xqList = this.villageService.findXQ();
		jsonObject.put("xqList",xqList);
		return jsonObject;
	}
}
