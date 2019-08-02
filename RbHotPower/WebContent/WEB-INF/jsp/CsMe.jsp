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
<title>用户注册</title>

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
			action="updCsTime.action" method="post">
				<div class="tip" style="color: red">${msg}</div>	
			   <div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>第一次抄表时间设定(某时刻):
				</label>
				<div style="float: left;" class="formControls col-3">
					<input type="text" class="input-text" id="csTime" size="10px" name="csTime" value="${csTime}" />
				</div>
				</div>	
				 <div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>第二次抄表时间设定(某时刻):
				</label>
				<div style="float: left;" class="formControls col-3">
					<input type="text" class="input-text" id="csTime1" size="10px" name="csTime1" value="${csTime1}" />
				</div>
				<div id="v3" style="float: left; margin-left: 20px;"></div>
					</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;时&nbsp;间&nbsp;设&nbsp;定&nbsp;">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
