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
  <script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="../js/biao.js"></script>
<link href="../css/main.css" rel="stylesheet" type="text/css" />
<link href="../css/bootstrap.css" rel="stylesheet">
	<script src="../js/main.js"></script>
	<link href="../css/fixed_table_rc.css" type="text/css" rel="stylesheet" media="all" />
	<script src="https://code.jquery.com/jquery.min.js" type="text/javascript"></script>
	<script src="https://meetselva.github.io/fixed-table-rows-cols/js/sortable_table.js" type="text/javascript"></script>
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
			height: 750,
			colModal: [
			{ width: 100, align: 'center' },
			{ width: 130, align: 'center' },
			{ width: 160, align: 'center' },
			{ width: 60, align: 'center' },
			{ width: 120, align: 'center' },
			{ width: 100, align: 'center' },
			{ width: 60, align: 'center' },
			{ width: 60, align: 'center' },
			{ width: 60, align: 'center' },
			{ width: 60, align: 'center' },
			{ width: 60, align: 'center' },
			{ width: 60, align: 'center' },
			{ width: 170, align: 'center' },
			],
			sort: true
		});
		
	});
	</script>

  <link href="../css/bootstrap.css" rel="stylesheet">
<script src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<link href="../css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<hr>
<div class="dwrapper">
	<table id="fixed_hdr2">
	<thead style="color: white;">
	<tr height="35px">
				<th>姓名</th>
				<th>小区名称</th>
				<th>用户地址</th>
				<th>通道号</th>
				<th>热表号</th>
				<th>累计热量</th>
				<th>瞬时流量</th>
				<th>流量</th>
				<th>功率</th>
				<th>进水温度</th>
				<th>回水温度</th>
				<th>温差</th>
				<th>实时时间</th>
     </tr>
  </thead>

  <tbody id="RbInfo">

		<c:forEach  var="r" items="${rbUs}" varStatus="status">
	 <tr <c:if test="${status.index%2==1 }">style="background-color:#eef3fa"</c:if>  >
					<td>${r.cLIENTNAME}</td>
					<td>${r.rbUser.rbrlInfo.tmeter.AREANAME}</td>
					<td>${r.aDDRESS}</td>
					<td>${r.rbUser.rbrlInfo.mBUSID}</td>
					<td>${r.rbUser.rbrlInfo.mETERID}</td>
					<td>${r.rbUser.rbrlInfo.mETERNLLJ}</td>
					<td>${r.rbUser.rbrlInfo.mETERTJ}</td>
					<td>${r.rbUser.rbrlInfo.mETERLS}</td>
					<td>${r.rbUser.rbrlInfo.mETERGL}</td>
					<td>${r.rbUser.rbrlInfo.mETERJSWD}</td>
					<td>${r.rbUser.rbrlInfo.mETERHSWD}</td>
					<td>${r.rbUser.rbrlInfo.mETERWC}</td>
					<td><fmt:formatDate value="${r.rbUser.rbrlInfo.dDATE}" pattern="yyyy-MM-dd HH:mm:ss" />
	 </tr>
	</c:forEach>
  </tbody>
</table>
</div>
</body>
</html>