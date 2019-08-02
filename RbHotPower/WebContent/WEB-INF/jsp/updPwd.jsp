<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="../js/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="../js/static/h-ui.admin/css/H-ui.admin.css" />
</head>
<body>
	<div class="page-container">
		<form class="form form-horizontal" id="form-user-pwd"
			action="UpdaPwd.action" method="post">
		<input type="hidden" name="id" id="id" value="${admin.id}" />
		<div class="tip" style="color: red">${msg}</div>	
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>用户名:
				</label>
				<div style="float: left;" class="formControls col-5">
					<input type="text" class="input-text" id="username" name="username" value="${admin.userName}" />
				</div>
				
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>原密码:
				</label>
				<div style="float: left;" class="formControls col-5">
					<input type="password" class="input-text" id="password" name="password" value="${admin.passWord}" />
				</div>
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>新密码:
				</label>
				<div style="float: left;" class="formControls col-5">
					<input type="password" class="input-text" id="password1" name="password1" />
				</div>
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>确认密码:
				</label>
				<div style="float: left;" class="formControls col-5">
					<input type="password" class="input-text" id="password2" name="password2" />
				</div>
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;&nbsp;修&nbsp;改&nbsp;密&nbsp;码&nbsp;&nbsp;">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
