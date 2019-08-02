<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
	$(function() {

		$('#fixed_hdr2').fxdHdrCol({
			fixedCols : 0,
			width : "100%",
			height : 700,
			colModal : [ {
				width : 50,
				align : 'center'
			}, {
				width : 120,
				align : 'center'
			}, {
				width : 120,
				align : 'center'
			}, {
				width : 150,
				align : 'center'
			}, {
				width : 120,
				align : 'center'
			}, {
				width : 170,
				align : 'center'
			}, {
				width : 150,
				align : 'center'
			}, {
				width : 170,
				align : 'center'
			}, {
				width : 170,
				align : 'center'
			}, {
				width : 170,
				align : 'center'
			}, {
				width : 170,
				align : 'center'
			},{
				width : 170,
				align : 'center'
			}],
			sort : true
		});

	});
</script>

<title>集中器管理</title>
<script type="text/javascript">
//更新所管理的区管ID
function UpQg(){
	var ckbs=$("#JzqInfo input[type=checkbox]:checked");
	if(ckbs.length==0){
		alert("请选择要查询的集中器");
		return false;
	}
	if(ckbs.length>1){
		alert("对不起一次只能查询一个");
		return false;
	}
	 var id=ckbs.val();
	 var jzqId=ckbs.parent().next().text();
	 var jzqIp=ckbs.parent().next().next().text();
	 var jzqPort=ckbs.parent().next().next().next().next().next().text();
	 
	$.ajax({
		url:"/HotPower/JzqsController/UpQg.action",
		async:false,
		dataType:"json",
		data:{
			"jzqId":jzqId,
			"jzqIp":jzqIp,
			"jzqPort":jzqPort
		},
		success:function(data){
			msg=data;
			if(msg=="0"){
				alert("更新成功!")
				window.location.reload(); 
			}
			if(msg=="1"){
				alert("更新失败!")
				window.location.reload(); 
			}
			if(msg=="2"){
				alert("超时!");
				window.location.reload(); 
			}
			if(msg=="3"){
				alert("集中器不在线!");
				window.location.reload();
			}
		}
	});
	
	
}
//查询集中器状态
function Cxzt(){
	var ckbs=$("#JzqInfo input[type=checkbox]:checked");
	if(ckbs.length==0){
		alert("请选择要查询的集中器");
		return false;
	}
	if(ckbs.length>1){
		alert("对不起一次只能查询一个");
		return false;
	}
	 var id=ckbs.val();
	 var jzqId=ckbs.parent().next().text();
	 var jzqIp=ckbs.parent().next().next().text();
	 var jzqPort=ckbs.parent().next().next().next().next().next().text();
	 
	$.ajax({
		url:"/RbHotPower/jzqCon/Cxzt.action",
		async:false,
		dataType:"json",
		data:{
			"jzqId":jzqId,
			"jzqIp":jzqIp,
			"jzqPort":jzqPort
		},
		success:function(data){
			msg=data;
			if(msg=="0"){
				alert("查询成功!")
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
 </script>
</head>
<body>
 <div>
 <div class="panel-heading">集中器管理</div>
<button type="button" class="btn btn-success" onclick="Cxzt()" style="background-color:#2B919D;border:1px">查询状态</button>
<div class="panel-body"  style="width: 99%; height: 85%; position: absolute; overflow:auto;">
		<div class="dwrapper">
		<table id="fixed_hdr2">
			<thead style="color: white;">
				<tr>
					<TH></TH>
					<th>集中器ID</th>
					<th>集中器IP</th>
					<th>小区名称</th>
					<th>端口号</th>
					<th>集中器心跳</th>
					<th>换热站名字</th>
					<th>安装位置</th>
					<th>记录时间</th>
					<th>区管ID</th>
					<th>备注</th>
				</tr>
			</thead>

			<tbody id="JzqInfo">

				<c:forEach var="jzq" items="${jzqlist}" varStatus="status">
					<tr>
					<td><input  type="checkbox" value="${jzq.jzq.id }" name="selected"  /></td>
						<td>${jzq.jzq.jzqId}</td>
						<td>${jzq.jzq.jzqIp}</td>
						<td>${jzq.xqName}</td>
						<td>${jzq.jzq.jzqPort }</td>
						<td>${jzq.jzq.jzqxt }</td>
						<td>${jzq.jzq.hesName}</td>
						<td>${jzq.jzq.installAd}</td>
					<td><fmt:formatDate value="${jzq.jzq.updateTime }"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${jzq.qgID }</td>
						<td>无</td>
					</tr>
				</c:forEach>
		</table>
		</div>
    </div>
	</div>
</body>
</html>