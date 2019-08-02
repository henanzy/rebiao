<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>首页</title>
</head>

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
			height : 800,
			colModal : [ 
				{
				width : 80,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			},
			{
				width : 50,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			}, {
				width : 50,
				align : 'center'
			},  {
				width : 50,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			}, {
				width : 70,
				align : 'center'
			}, {
				width : 70,
				align : 'center'
			}, {
				width : 70,
				align : 'center'
			}, {
				width : 70,
				align : 'center'
			}, {
				width : 70,
				align : 'center'
			}, {
				width : 70,
				align : 'center'
			}
			, {
				width : 70,
				align : 'center'
			}, {
				width : 70,
				align : 'center'
			}, {
				width : 150,
				align : 'center'
			}, {
				width : 70,
				align : 'center'
			}, {
				width : 180,
				align : 'center'
			}, {
				width : 70,
				align : 'center'
			} 
			/* , {
				width : 180,
				align : 'center'
			}   */
],
			sort : true
		});

	});
	</script>
<body>

	<div class="dwrapper">
		<table id="fixed_hdr2">
			<thead style="color: white;">
				<tr height="35px">
				<th>用户姓名</th>
				<th>小区名称</th>
				<th>楼栋号</th>
				<th>楼宇名称</th>
				<th>单元号</th>
				<th>户号</th>
				<th>热表编号</th>
				<th>累计热量</th>
				<th>瞬时热量</th>
				<th>累计流量</th>
				<th>瞬时流量</th>
				<th>进水温度</th>
				<th>回水温度</th>
				<th>温差</th>
				<th>收费类型</th>
				<th>仪表状态</th>
				<th>工作时间</th>
				<th>更新时间</th>
				<th>热表类型</th>
				<!-- <th>实时时间</th> -->
				</tr>
			</thead>
			<tbody id="SearchId">
				<c:forEach var="rb" items="${rbList}" varStatus="status">
				<tr <c:if test="${status.index%2==1 }">style="background-color:#eef3fa"</c:if> data-toggle="modal"
				data-target="#add">
				<c:choose>
				<c:when test="${rb.rbExp==1}">
				<td title="${rb.yh.bz}"><font color="red">${rb.yh.yhName}</font></td>
				</c:when>
				<c:when test="${rb.rbExp==2}">
				<td title="${rb.yh.bz}"><font color="blue">${rb.yh.yhName}</font></td>
				</c:when>
				<c:otherwise>
				<%-- <td title="${rb.yh.bz}">${rb.yh.yhName}</td> --%>
				<td title="${rb.yh.bz}">${rb.yh.yhName}</td>
				</c:otherwise>
				</c:choose>
				
					<td>${rb.yh.xqName}</td>
					<td>${rb.yh.buildNO}</td>
					<td>${rb.yh.rbLyName}</td>
					<td>${rb.yh.cellNO}</td>
					<td>${rb.yh.houseNO}</td>
					<td>${rb.rbAd}</td>
					<%-- <td>${rb.energy}</td>
					<td>${rb.power}</td>
					<td>${rb.energyLj}</td>
					<td>${rb.flow}</td> --%>
					<c:choose>
					<c:when test="${rb.energy==999.00}">
					<td><font color="red">${rb.energy}</font></td>
					</c:when>
				    <c:otherwise>
				    <td>${rb.energy}</td>
				    </c:otherwise>
					</c:choose>
					<%-- <td>${rb.energy}</td> --%>
					<c:choose>
					<c:when test="${rb.power==999.00}">
					<td><font color="red">${rb.power}</font></td>
					</c:when>
				    <c:otherwise>
				    <td>${rb.power}</td>
				    </c:otherwise>
					</c:choose>
					
					<%-- <td>${rb.energyLj}</td> --%>
					<c:choose>
					<c:when test="${rb.energyLj==999.00}">
					<td><font color="red">${rb.energyLj}</font></td>
					</c:when>
				    <c:otherwise>
				    <td>${rb.energyLj}</td>
				    </c:otherwise>
					</c:choose>
					<c:choose>
					<c:when test="${rb.flow==999.00}">
					<td><font color="red">${rb.flow}</font></td>
					</c:when>
				    <c:otherwise>
				    <td>${rb.flow}</td>
				    </c:otherwise>
					</c:choose>
					<td>${rb.inTmp}</td>
					<td>${rb.outTmp}</td>
					<td>${rb.diffTmp}</td>
					<c:choose>
					<c:when test="${rb.yh.rbfl==0}">
					<td>流量</td>
					</c:when>
					<c:otherwise>
					<td>面积</td>
					</c:otherwise>
					</c:choose>
					<c:choose>
   					<c:when test="${rb.status=='正常'}">
   					<td>${rb.status}</td>
   					</c:when>
   					<c:otherwise>
   					<td><font color="red">${rb.status}</font></td> 
   					</c:otherwise>
   					</c:choose>
					<%-- <td>${rb.status}</td> --%>
					<td>${rb.operTime}</td>
					<td><fmt:formatDate value="${rb.recordTime}" pattern="yyyy-MM-dd HH:mm:ss" /> 
					<td>${rb.rbType}</td>
					<%-- 	<td>${rb.readMTime}</td> --%>
				</tr>
			</c:forEach>
		</table> 
	</div>

</body>
</html>