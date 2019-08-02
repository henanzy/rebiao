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

<title>操作日志</title>
</head>
<script type="text/javascript" src="../js/static/h-ui.admin/js/H-ui.admin.js"></script>
<link href="../css/fixed_table_rc.css" type="text/css" rel="stylesheet"	media="all" />
<link href="../css/bootstrap.css" type="text/css" rel="stylesheet"	/>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script	src="https://meetselva.github.io/fixed-table-rows-cols/js/sortable_table.js"
	type="text/javascript"></script>
<script src="../js/fixed_table_rc.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/layer/2.4/layer.js"></script>
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
				width : 100,
				align : 'center'
			}, {
				width : 500,
				align : 'center'
			},
			{
				width : 200,
				align : 'center'
			}
],
			sort : true
		});

	});
	</script>
	
	 <script type="text/javascript">
 //搜索
function searchInfo(){
    var cz = $('#cz').val();
    var html ="";
	$.ajax({ 
		        url:"SelCzList.action",
				async : false,
				dataType : "json",
				data : {
					"cz" : cz,
				},
				success : function(data) {
					$("#rzList").empty();
					var d=data.RzList;
					for(var i=0;i<d.length;i++){
						var czr=d[i].czr;
						var cz=d[i].cz;
						var czsj=d[i].czsj;
						html+="<tr>";
						html+="<td class='text-center'>"+czr+"</td>";
						html+="<td class='text-center'>"+cz+"</td>";
						html+="<td class='text-center' title='"+czsj+"'>"+czsj+"</td>";
						html+="</tr>";
						}
					  html+="</tbody>"
					  html+="</table>";
					  html+="</div>";
					$("#rzList").append(html);
				}

			})
		}
//时间转换
function FormatDate (strTime) {
    var date = new Date(strTime);
    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
}
</script>
<body>

	<div class="dwrapper">
	操作内容模糊查询：<input type="text" name="cz" id="cz"><input class="btn btn-success"  type="button" onclick="searchInfo()" style="background-color:#2B919D;border:1px" value="搜索">
		<table id="fixed_hdr2">
			<thead style="color: white;">
				<tr height="35px">
				<th>操作人</th>
				<th>操作日志</th>
				<th>操作时间</th>
				</tr>
			</thead>
			<tbody id="rzList">
				<c:forEach var="rb" items="${RzList}" varStatus="status">
			         <tr>
					<td>${rb.czr}</td>
					<td>${rb.cz}</td>
					<td><fmt:formatDate value="${rb.czsj}" pattern="yyyy-MM-dd HH:mm:ss" />
				    </tr>
					</c:forEach>
		</table> 
	</div>

</body>
</html>