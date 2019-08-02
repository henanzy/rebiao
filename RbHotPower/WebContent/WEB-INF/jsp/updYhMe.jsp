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
<title>修改用户信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="../js/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="../js/static/h-ui.admin/css/H-ui.admin.css" />
</head>
<body>
	<div class="page-container">
		<form class="form form-horizontal" id="form-user-pwd"
			action="UpSbxx.action" method="post">
		<input type="hidden" name="id" id="id" value="${rb.yh.id}" />
		<%-- <div class="tip" style="color: red">${msg}</div> --%>	
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>用户名:
				</label>
				<div style="float: left;" class="formControls col-5">
					<input type="text" class="input-text" id="yhName" name="yhName" value="${rb.yh.yhName}" />
				</div>
				
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>小区名称:
				</label>
				<div style="float: left;" class="formControls col-5">
					<input type="text" class="input-text" id="xqName" name="xqName" value="${rb.yh.xqName}" readonly/>
				</div>
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>楼栋号:
				</label>
				<div style="float: left;" class="formControls col-5">
					<input type="text" class="input-text" id="rbLyName" name="rbLyName" value="${rb.yh.rbLyName}" readonly/>
				</div>
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>单元号:
				</label>
				<div style="float: left;" class="formControls col-5">
					<input type="text" class="input-text" id="cellNO" name="cellNO" value="${rb.yh.cellNO}" readonly />
				</div>
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>户号:
				</label>
				<div style="float: left;" class="formControls col-5">
					<input type="text" class="input-text" id="houseNO" name="houseNO" value="${rb.yh.houseNO}" readonly/>
				</div>
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>热表编号:
				</label>
				<div style="float: left;" class="formControls col-5">
					<input type="text" class="input-text" id="rbAd" name="rbAd" value="${rb.yh.rbAd}" />
				</div>
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
				<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>热表收费类型:
				</label>
				<div style="float: left;" class="formControls col-5">
				<c:choose>
				<c:when test="${userName=='董娇茹'}">
				<c:choose>
				<c:when test="${rb.yh.rbfl==0}">
				<select id="rbfl" name="rbfl">
				<option selected="selected">流量</option>
				<option>面积</option>
				</select>
				</c:when>
				<c:otherwise>
				<select id="rbfl" name="rbfl">
				<option>流量</option>
				<option selected="selected">面积</option>
				</select>
				</c:otherwise>
				</c:choose>
				</c:when>
				<c:otherwise>
				<c:choose>
				<c:when test="${rb.yh.rbfl==0}">
				<select id="rbfl" name="rbfl"  disabled="disabled">
				<option selected="selected">流量</option>
				<option>面积</option>
				</select>
				</c:when>
				<c:otherwise>
				<select id="rbfl" name="rbfl"  disabled="disabled">
				<option>流量</option>
				<option selected="selected">面积</option>
				</select>
				</c:otherwise>
				</c:choose>
				</c:otherwise>
				</c:choose>
				</div>
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
				<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"> <span
					class="c-red">*</span>用户备注信息:
				</label>
				<div style="float: left;" class="formControls col-5">
					<input type="text" class="input-text" id="bz" name="bz" value="${rb.yh.bz}" />
				</div>
				<div id="v3" style="float: left; margin-left: 20px;"></div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="button" onclick="sub()"
						value="&nbsp;&nbsp;提&nbsp;交&nbsp;信&nbsp;息&nbsp;&nbsp;">
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	function sub(){
		debugger;
	$("#rbfl").removeAttr("disabled");
	  $("#form-user-pwd").submit(); 
	}
	</script>
</body>
</html>
