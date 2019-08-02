<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title></title>
<link href="../css/fixed_table_rc.css" type="text/css" rel="stylesheet"	media="all" />
<link href="../css/bootstrap.css" type="text/css" rel="stylesheet"	/>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script	src="https://meetselva.github.io/fixed-table-rows-cols/js/sortable_table.js"
	type="text/javascript"></script>
<script src="../js/fixed_table_rc.js" type="text/javascript"></script>
<style>
html, body {
	font-family: Arial, ​​sans-serif;
	font-size: 14px;
	margin: 0;
	padding: 0;
	background-color: #f2f2f2;
}

div.container {
	padding: 5px 10px;
	width: 2330px;
	margin: 10px auto;
}

.ft_container thead tr {
	background: url(../img/secai.png);
}
</style>
	<script>
	$(function () {
		
		$('#fixed_hdr2').fxdHdrCol({
			fixedCols: 0,
			width: "100%",
			height: 700,
			colModal: [
			{ width: 50, align: 'center' },
			{ width: 90, align: 'center' },
			{ width: 120, align: 'center' },
			{ width: 120, align: 'center' },
			{ width: 200, align: 'center' },
			/* { width: 150, align: 'center' }, */
			/* { width: 70, align: 'center' },
			{ width: 100, align: 'center' },
			{ width: 150, align: 'center' }, */
			{ width: 150, align: 'center' },
			{ width: 150, align: 'center' },
			{ width: 150, align: 'center' }
			],
			sort: true
		});
		
	});
	</script>
<script type="text/javascript">
//查询通讯状态
function QgTS(){
	var ckbs=$("#qgInfo input[type=checkbox]:checked");
	if(ckbs.length==0){
		alert("请选择要查询的区管");
		return false;
	}
	if(ckbs.length>1){
		alert("对不起一次只能选择一个");
		return false;
	}
	var id=ckbs.val();
	$.ajax({
		url:"/RbHotPower/QgCon/QgTS.action",
		async:false,
		dataType:"json",
		data:{
			"ids":id
		},
		success:function(data){
			msg=data;
				if(msg=="0"){
					alert("查询区管接收指令成功!")
					window.location.reload(); 
				}
				if(msg=="1"){
					alert("查询失败!")
					window.location.reload(); 
				}
				if(msg=="2"){
					alert("集中器不在线!");
					window.location.reload();
				}
				
			}
			
		});
		 
}
//实时热表数据
function SsRb(){
	var ckbs=$("#qgInfo input[type=checkbox]:checked");
	if(ckbs.length==0){
		alert("请选择要抄的区管");
		return false;
	}
	if(ckbs.length>1){
		alert("对不起一次只能选择一个");
		return false;
	}
	var id=ckbs.val();
	$.ajax({
		url:"/RbHotPower/QgCon/SsRb.action",
		async:false,
		dataType:"json",
		data:{
			"ids":id
		},
		success:function(data){
				msg=data;
				if(msg=="0"){
					alert("群抄热表接收指令成功!")
					window.location.reload(); 
				}
				if(msg=="1"){
					alert("群抄热表失败!")
					window.location.reload(); 
				}
				if(msg=="2"){
					alert("集中器不在线!")
					window.location.reload(); 
				}
				
			}
			
		});
}

function CxRbId(){
	var ckbs=$("#qgInfo input[type=checkbox]:checked");
	if(ckbs.length==0){
		alert("请选择要查询的区管");
		return false;
	}
	if(ckbs.length>1){
		alert("对不起一次只能选择一个");
		return false;
	}
	var id=ckbs.val();
	$.ajax({
		url:"/RbHotPower/QgCon/CxRbId.action",
		async:false,
		dataType:"json",
		data:{
			"ids":id
		},
		success:function(data){
				msg=data.js;
				if(msg=="0"){
					alert("查询热表地址接收指令成功!")
					window.location.reload(); 
				}
				if (msg=="2"){
					alert("集中器不在线!")
					window.location.reload(); 
				}
				if(msg=="1"){
					alert("查询热表失败!")
					window.location.reload(); 
				}
				
			}
			
		});
}
function add(){
	var ckbs=$("#qgInfo input[type=checkbox]:checked");
   /*  var   xgRb=$('#xgRb').val();
    var   jgRb=$('#jgRb').val(); */
    /* var re = /^[0-9]+.?[0-9]*$/;
  　　if (!re.test(xgRb)) {
	　　　　alert("请输入数字");
	　　　　document.getElementById(xgRb).value = "";
	　　　　return false;
	}
  if(xgRb.length>14){
	  alert("长度小于14")
	  document.getElementById(xgRb).value = "";
	  return false;
  }
    if (!re.test(jgRb)) {
	　　　　alert("请输入数字");
　　　　	  document.getElementById(jgRb).value = "";
　　　　		return false;
	}
    
    if(jgRb.length>14){
    	  document.getElementById(jgRb).value = "";
  	  alert("长度小于14")
  	  return false;
    } */
	var apiContentStr;
	if(ckbs.length==0){
		alert("请选择要添加的热表");
		return false;
	}
	var id=ckbs.val();
	var apiContentStr="";
   			$.ajax({
   				url:"/RbHotPower/QgCon/addRb.action",
   				async:false,
   				dataType:"json",
   				data:{	
   					/* "ids":apiContentStr, */
   					/* "xgRb":xgRb,
   					"jgRb":jgRb, */
   					"qgId":id,
   				},
   				success:function(data){
   					msg=data.js
   					if(msg=="0"){
   						alert("接收指令成功!")
   						window.location.reload(); 
   					}
   					if(msg=="1"){
   						alert(" 读热表失败!")
   						window.location.reload(); 
   					}
   					
   					if(msg=="2"){
   					    alert(" 集中器不在线");
   					 window.location.reload(); 
   					}
   				
   				}
   				
   			});
}

function drop(){
	var ckbs=$("#qgInfo input[type=checkbox]:checked");
	var apiContentStr;
	if(ckbs.length==0){
		alert("请选择要删除的热表");
		return false;
	}
	var ids=[];
	$.each(ckbs,function(index,data){
		ids[index]=$(data).val();
	})
	var apiContentStr="";
	for(var i=0;i<ids.length;i++){
   			 apiContentStr=ids[i];
   			$.ajax({
   				url:"/RbHotPower/QgCon/dropRb.action",
   				async:false,
   				dataType:"json",
   				data:{	
   					"ids":apiContentStr,
   				},
   				success:function(data){
   					msg=data.js
   					if(msg=="0"){
   						alert("删除接收数据成功!")
   						window.location.reload(); 
   					}
   					if(msg=="1"){
   						alert(" 删除失败!")
   						window.location.reload(); 
   					}		
   					if(msg=="2"){
   					    alert(" 集中器不在线");
   					 window.location.reload(); 
   					}
   				}	
   			});
   	}	
}

function xgQgId(){
	var ckbs=$("#qgInfo input[type=checkbox]:checked");
    var qgId=$('#qgId').val();
    var re = /^[0-9]+.?[0-9]*$/;
    if (!re.test(qgId)) {
	　　　　alert("请输入数字");
	　　　　document.getElementById(qgId).value = "";
	　　　　return false;
	}
	var apiContentStr;
	if(ckbs.length==0){
		alert("请选择要修改的区管");
		return false;
	}
	var ids=[];
	$.each(ckbs,function(index,data){
		ids[index]=$(data).val();
	})
	var apiContentStr="";
	for(var i=0;i<ids.length;i++){
   			 apiContentStr=ids[i];
   			$.ajax({
   				url:"/RbHotPower/QgCon/xgQgId.action",
   				async:false,
   				dataType:"json",
   				data:{	
   					"ids":apiContentStr,
   					"xgQgId":qgId,
   				},
   				success:function(data){
   					msg=data.js
   					if(msg=="0"){
   						alert("修改区管接收指令成功!")
   						window.location.reload(); 
   					}
   					if(msg=="1"){
   						alert("修改区管表失败!")
   						window.location.reload(); 
   					}
   					if(msg=="2"){
   						alert("集中器不在线");
   						window.location.reload(); 
   					}
   				}
   				
   			});
   	}	
}
</script>
</head>
<body>
 <div>区管管理</div>
<p>
<button class="btn btn-success" onclick="QgTS()" style="background-color:#2B919D;border:1px">查询区管状态</button>
 <button type="button" class="btn btn-success" onclick="SsRb()" style="background-color:#2B919D;border:1px">实时热表数据</button>
<button type="button" class="btn btn-success" onclick="CxRbId()" style="background-color:#2B919D;border:1px">查询热表地址</button>
<!-- 旧地址：<input type="text" size="10px" id="jgRb"> 新地址：<input type="text" size="10px" id="xgRb"> -->
<button  type="button" class="btn btn-success" onclick="add()" style="background-color:#2B919D;border:1px" >添加热表地址</button>
<button  type="button" class="btn btn-success" onclick="drop()" style="background-color:#2B919D;border:1px" >删除热表地址</button>
<input type="text" size="10px" id="qgId"><button  type="button" class="btn btn-success" onclick="xgQgId()" style="background-color:#2B919D;border:1px" >更改区管ID</button>
<div class="dwrapper">

<table id="fixed_hdr2">
	<thead style="color: white;">
      <tr>
      				<th></th>
					<th >区管ID</th>
					<th >所属集中器</th>
					<th >小区名称</th>
					<th >安装位置</th>
					<th >更新时间</th>
					<th >集中器心跳</th>
					<th >区管分类</th>
     </tr>
  </thead>

  <tbody id="qgInfo">
		<c:forEach var="qg" items="${qglist}" varStatus="status">

					<tr>
					<td><input type="checkbox" value="${qg.qgID}" name="selected"  /></td>
						<td>${qg.qgID}</td>
						<td>${qg.jzqID}</td>
						<td>${qg.xqName }</td>
						<td>${qg.installAd}</td>
						<td><fmt:formatDate value="${qg.recordTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${qg.jzq.jzqxt}</td>
						
						<c:if test="${qg.qgFl==1}">
						<td>单系统</td>
						</c:if>
						<c:if test="${qg.qgFl==2}">
						<td>双系统</td>
						</c:if>
					</tr>
				</c:forEach>
  </tbody>
</table>
</div>
</body>
</html>