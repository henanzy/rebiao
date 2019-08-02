<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <title>三门峡热表集抄管理系统</title>
    <link rel="stylesheet" type="text/css" href="../css/base.css" />
    <link rel="stylesheet" type="text/css" href="../css/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
    <script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="../js/jquery.spritely-0.6.js"></script>
    <script type="text/javascript" src="../js/chur.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/login.css" />
  
</head>
<body>
    <div id="clouds" class="stage"></div>
    <div class="loginmain">
    </div>
<form action="login.action" id="myform" method="post">
    <div class="row-fluid">
        <h1>三门峡热表集抄管理系统</h1>
        <p>
            <label>帐&nbsp;&nbsp;&nbsp;号：<input type="text" id="userName" name="userName" /></label>
        </p>
        <p>
            <label>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="passWord" name="passWord" /></label>
        </p>
        <p class="pcode">
            <label>效验码：<input type="text" id="code" maxlength="5" class="code" value="e5g88" /><img src="../img/code.gif" alt="" class="imgcode" /><a href="#">下一张</a></label>
        </p>
        <p class="tip">${msg}</p>
        <hr/>

        <input type="submit" value=" 登 录 " class="btn btn-primary btn-large login" />
        &nbsp;&nbsp;&nbsp;<input type="button" value=" 取 消 " class="btn btn-large" />
    </div>
    </form>
</body>
</html>
