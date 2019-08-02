<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ZYIS-H智慧供热平台</title>
<link rel="stylesheet" type="text/css" href="../css/admin-all.css" />
<link rel="stylesheet" type="text/css" href="../css/base.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="../css/jquery-ui-1.8.22.custom.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="../js/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
<script src="../js/jquery-1.9.2.js"></script>

</head>
<script type="text/javascript">
$(document).ready(function(){
    $("#zhu").mouseover(function(){
        $(this).stop();
        $(this).animate({width:160},400);
    })
    $("#zhu").mouseout(function(){
        $(this).stop();
        $(this).animate({width:30},300);
    });
});


function updPwd(title, url, w, h){
	layer_show(title, url, w, h);
}
function add(title, url, w, h){
	layer_show(title, url, w, h);
}
function tc(){
<%-- 	window.open("<%=basePath%>UserCon/toLogin.action"); --%>
	window.location='http://218.29.162.134:8093/HotPower';
}

</script>
<style type="text/css">
*{margin:0;padding:0;list-style-type:none; }
        #zhu{font-size: 16px;width:30px;height:140px; position: fixed;right:2px; overflow:hidden;z-index:9999; top:180px; background-color: #24CAB6;}
        #zhu ul{padding-left:30px;}
        #zhu p{border-bottom:1px solid #D4B4CE;font-size:20px;height:35px;line-height:40px ; width:1000px;background:#24CAB6;color:#fbfbfb; }
        #zhu li{height:35px;line-height:35px;font-size:14px;border-bottom:1px #D4B4CE dotted;right: 0px;position:inherit;background-color: #24CAB6;}
        #zhu li a{text-decoration:none;color:#fbfbfb;}
        #zhu .zu {background-color: #24CAB6;border:0px solid #D4B4CE;width:20px;height:270px;line-height:20px ;font-size:15px;position:absolute;text-align: center;top:10px}
        #zhu .zu a{color:#fbfbfb;text-decoration:none;}
</style>
<body>
	<div class="warp">
		<!--头部开始-->
		<div class="top_c">
			<div class="top-menu">
				<ul class="top-menu-nav">
			<%-- 	<li><a target="Conframel" href="<%=basePath%>ztCon/RbMe.action">首页</a></li> --%>
				<li><a target="Conframel" href="<%=basePath%>RbCon/ztreeMe.action">首页</a></li>
					<%-- <li><a  target="Conframel" href="<%=basePath%>RbCon/ztreeMe.action">双系统热表信息</a></li> --%>
					<li><a target="Conframel" href="<%=basePath%>RbCon/SbMe.action">设备维护</a></li>
				<%-- 	<li><a target="Conframel" href="<%=basePath%>RbrlCon/rbrlMe.action">单系统热表信息</a></li> --%>
					<li><a target="Conframel" href="<%=basePath%>RbCon/SbMeSbb.action">热表数据报表</a></i>
					<li><a target="Conframel" href="<%=basePath%>RbCon/SbYcjcMe.action">异常检测</a></li>
					<li><a target="Conframel" href="<%=basePath%>RbCon/SbxxgsMe.action">信息管理</a></li>
					<li><a target="Conframe" href="<%=basePath%>CsTimeCon/CsMe.action">抄表时间设定</a></li>
					<%-- <li><a href="#">系统参数设置<i class="tip-up"></i></a>
						<ul class="kidc">
							<li><a target="Conframe" onclick="add('用户注册','<%=basePath%>UserCon/addYh.action','600','300')">用户注册</a></li>
							<li><a target="Conframe" onclick="add('抄表时间设定','<%=basePath%>CsTimeCon/CsMe.action','600','300')">抄表时间设定</a></li>
						</ul>
					</li> --%>
				</ul>
			</div>
			<div class="bottom_c1 ">
			</div>
			<div class="top-nav">
				欢迎您！ <%=request.getSession().getAttribute("userName")%> &nbsp;&nbsp;&nbsp;&nbsp;<%-- <a onclick="updPwd('修改密码','<%=basePath%>UserCon/updPwd.action','600','400')">修改密码</a> --%> | <a href="#" onclick="tc()" style="color: white;">安全退出</a>
			</div>
		</div>
		<!--头部结束-->
		<!--左边菜单开始-->
		<div class="left_c left">
		<!-- 	<h1>盛润广场信息列表</h1> -->
		<h1></h1>
			<%-- 	<div class="acc">
				<iframe scrolling="no" width="100%"   name="Conframel" id="Conframel" src="<%=basePath %>ztCon/RbMe.action" frameborder="0" onload="this.height=0;var fdh=(this.Document?this.Document.body.scrollHeight:this.contentDocument.body.offsetHeight);this.height=(fdh>1700?fdh:1700)"></iframe>
			</div> --%>
			 <div class="acc">
				<iframe scrolling="no" width="100%"   name="Conframel" id="Conframel" src="<%=basePath %>ZtreeCont/ztree.action" frameborder="0" onload="this.height=0;var fdh=(this.Document?this.Document.body.scrollHeight:this.contentDocument.body.offsetHeight);this.height=(fdh>1700000?fdh:1700000)"></iframe>
			</div> 
		</div>
		<!--左边菜单结束-->
		<!--右边框架开始-->
		<div class="right_c">
			<div class="nav-tip" onClick="javascript:void(0)">&nbsp;</div>

		</div>
		<div class="Conframe">
			<iframe name="Conframe" id="Conframe" src="<%=basePath %>RbCon/find.action"></iframe>
		</div>
		<!--右边框架结束-->

		<!--底部开始-->
		<div class="bottom_c">Copyright &copy;2018-4月  河南众源系统工程有限公司
			版权所有</div>
		<!--底部结束-->
	</div>
	<c:if test="${userRole=='1001'}">
		<div id="zhu">
    <div class="zu" ><a href="" >智慧供热 平台</a></div>
     <ul>
   <!-- <P>IS-H智慧供热平台</P> -->
      <!--   <li><a>IS-H智慧供热平台</a><li> 
        <li><a>IS-H智慧供热平台</a><li>  -->
         <li><a href="http://218.29.162.134:8093/HotPower/home/index.action?userRole=${userRole}&userName=${userName}">智能入户管理系统</a></li> 
       <!--  <li><a href="http://192.144.169.217:8094/HotPower/home/index.action">智能入户管理系统</a></li> -->
     <!--   <li><a href="http://localhost:8080/RbHotPower/UserCon/index.action">热表集抄管理系统</a> -->
       <li><a href="http://218.29.162.134:8093/RbHotPower/UserCon/index.action?userRole=${userRole}&userName=${userName}">热表集抄管理系统</a></li>
        <li><a href="http://218.29.162.134:8093/HRZ/user/toLogin.action?userRole=${userRole}&userName=${userName}">换热站管理系统</a></li>
        <li><a href="http://218.29.162.134:8093/KFGL/user/login.action?userRole=${userRole}&userName=${userName}">客户服务管理系统</a></li>
  </ul>
</div>
  </c:if>
</body>
<script type="text/javascript" src="../js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../js/static/h-ui.admin/js/H-ui.admin.js"></script>
</html>