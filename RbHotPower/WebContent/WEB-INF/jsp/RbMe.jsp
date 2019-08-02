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
 	<script type="text/javascript" src="../js/static/h-ui.admin/js/H-ui.admin.js"></script>
<link href="../css/fixed_table_rc.css" type="text/css" rel="stylesheet"	media="all" />
<link href="../css/bootstrap.css" type="text/css" rel="stylesheet"	/>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script> 

	<script type="text/javascript">

	window.onload = function() {
        window.open("/RbHotPower/RbrlCon/findRbUser.action","Conframe");
    }
	</script>
	<script type="text/javascript">
	function Rb(xqName){
		 window.open("/RbHotPower/RbrlCon/SearFInfo.action?xqName="+xqName,"Conframe");
	}
	</script>
</head>
<body>
<br>
<ul id="123">
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('交警队')">交警队</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('金盾小区')">金盾小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('中原世纪苑')">金盾小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('瑞祥家园')">瑞祥家园</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('邮政局小区')">邮政局小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('百货楼小区')">百货楼小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('岭东小区')">岭东小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('文明路南区')">文明路南区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('三里桥小区')">三里桥小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('市政小区')">市政小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('文明路东区')">文明路东区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('和五小区')">和五小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('和四小区')">和四小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('涧河小区')">涧河小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('康乐小区')">康乐小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('文明路西区')">文明路西区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('秦岭小区')">秦岭小区</button></li>
<li><button type="button" class="btn btn-link btn-xs" onclick="Rb('中原世纪苑二期')">中原世纪苑二期</button></li>
</ul>
</body>
</html>