<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../css/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="../js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="../js/jquery.ztree.core.js"></script>
	<SCRIPT type="text/javascript">	
	 $(function () {
		   init();
		 });
		 function init() {
		   builePlanTree();
		 }
		var zNodes =[${buf}];
		
		 function builePlanTree() {
			 
			    var setting = {
			    		   check:{
			                   enable:true
			               },
			     view: {
			       showIcon: true//设置 zTree 是否显示节点的图标。
			       },
			     data: {
			       simpleData: {
			         enable: true
			        }
			    },
			    callback: {
			    	 beforeCheck:beforeModuleCheck,
			     onClick: zTreeOnClick
			  }
			};
		
			    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
			    function beforeModuleCheck(treeId, treeNode) {

                    return true;

           }
			     function zTreeOnClick(event, treeId, treeNode) {
			            var treeObj = $.fn.zTree.getZTreeObj("treeDemo"); 
			            var sNodes = treeObj.getSelectedNodes();
                          if (sNodes.length > 0) 
                          {
                        	  //判断是否有父类
                        	  var node = sNodes[0].getParentNode();
                        	  if(node==null){

                        		 window.open("/RbHotPower/RbCon/findRb.action?xqName="+sNodes[0].name,"Conframe");
                        	  }else{
                        		  //判断是否有子类 
                        		  var childNodes = treeObj.transformToArray(sNodes);
                        		  if(childNodes.length!=1){

                        			  window.open("/RbHotPower/RbCon/findRb.action?xqName="+node.name+"&rbLyName="+sNodes[0].name,"Conframe");
                        		  }
                        		  else{
                        			 var parentNode = sNodes[0].getParentNode(); 
                        			 var parentno=parentNode.getParentNode();

                        			 window.open("/RbHotPower/RbCon/findRb.action?xqName="+parentno.name+"&rbLyName="+node.name+"&cellNO="+sNodes[0].name,"Conframe");
                        		  }
                        	  }
                          }
			     };
			 }
	</SCRIPT>
</HEAD>
<BODY>

		<ul id="treeDemo" class="ztree"></ul>
	
</BODY>

</html>