<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.invalidate();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>提示</title>
	</head>
	<script type="text/javascript">
	window.onload = function() {
		parent.location.href = "UserCon/index.action";
		var index = parent.layer.getFrameIndex(window.name);
		top.layer.close(index);
	}
</script>
	<body>
	
	</body>
</html>