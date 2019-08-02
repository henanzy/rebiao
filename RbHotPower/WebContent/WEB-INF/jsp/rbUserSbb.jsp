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
			height: 510,
			colModal: [
			{ width: 100, align: 'center' },
			{ width: 100, align: 'center' },
			{ width: 200, align: 'center' },
			{ width: 80, align: 'center' },
			{ width: 150, align: 'center' },
			{ width: 190, align: 'center' },
			{ width: 190, align: 'center' },
			{ width: 170, align: 'center' },
			{ width: 180, align: 'center' },
			{ width: 170, align: 'center' },
			{ width: 180, align: 'center' },
			{ width: 180, align: 'center' },
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
 <script type="text/javascript">
 //搜索
function searchInfo(){
    var   xqName = $('#xqNameId').val();
    var   recordTime1=$('#recordTime1').val();
    var   recordTime2=$('#recordTime2').val();
    var html ="";
	$.ajax({ 
		        url:"SearFind.action",
				async : false,
				dataType : "json",
				data : {
					"xqName" : xqName,
					"recordTime1" : recordTime1,
					"recordTime2" : recordTime2,
				},
				success : function(data) {
					$("#RbInfo").empty();
					var d=data.rbUs;
					for(var i=0;i<d.length;i++){
						var cLIENTNAME=d[i].cLIENTNAME;
						var aDDRESS=d[i].aDDRESS;
						var mBUSID=d[i].rbUser.rbrlInfo.mBUSID;
						var mETERID=d[i].rbUser.rbrlInfo.mETERID;
						var mETERNLLJ=d[i].rbUser.rbrlInfo.mETERNLLJ;
						var mETERTJ =d[i].rbUser.rbrlInfo.mETERTJ ;
						var mETERLS=d[i].rbUser.rbrlInfo.mETERLS;
						var mETERGL=d[i].rbUser.rbrlInfo.mETERGL;
						var mETERJSWD=d[i].rbUser.rbrlInfo.mETERJSWD;	
						var mETERHSWD=d[i].rbUser.rbrlInfo.mETERHSWD;
						var mETERWC=d[i].rbUser.rbrlInfo.mETERWC;
						var data=FormatDate(d[i].rbUser.rbrlInfo.dDATE) ;
						var xqName=d[i].rbUser.rbrlInfo.tmeter.aREANAME;
						html+="<tr>";
						html+="<td class='text-center'>"+cLIENTNAME+"</td>";
						html+="<td class='text-center'>"+xqName+"</td>";
						html+="<td class='text-center'>"+aDDRESS+"</td>";
						html+="<td class='text-center'>"+mBUSID+"</td>";
						html+="<td class='text-center'>"+mETERID+"</td>";
						html+="<td class='text-center'>"+mETERNLLJ+"</td>";
						html+="<td class='text-center'>"+mETERTJ+"</td>";
						html+="<td class='text-center'>"+mETERLS+"</td>";
						html+="<td class='text-center'>"+mETERGL+"</td>";
						html+="<td class='text-center'>"+mETERJSWD+"</td>";
						html+="<td class='text-center'>"+mETERHSWD+"</td>";
						html+="<td class='text-center'>"+mETERWC+"</td>";
						html+="<td class='text-center' title='"+data+"'>"+data+"</td>";
						html+="</tr>";
						}
					  html+="</tbody>"
					  html+="</table>";
					  html+="</div>";
					$("#RbInfo").append(html);
				}

			})
		}
//时间转换
function FormatDate (strTime) {
    var date = new Date(strTime);
    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
}
</script>
	<script type="text/javascript">
	//导出
	function doExportExcel() {
		var xqName = $('#xqNameId').val();
		var recordTime1=$('#recordTime1').val();
		var recordTime2=$('#recordTime2').val();
		window.open("RbdoExportExcel.action?xqName=" + xqName
			+"&recordTime1="+ recordTime1+"&recordTime2="+ recordTime2);
	}
</script>
</head>
<body style="padding-left: 10px;">
 <ul class="nav nav-tabs">
<li> <a href="/HotPower/YhInfo/findYhNameList.action">锁闭阀数据报表</a></li>
<li><a href="/HotPower/RbsglController/sbSjbb.action">双系统热表数据</a></li>
<li class="active"><a href="#">单系统热表数据</a></li>
</ul>
		<label for="xqNameId">选择小区</label> 
		<select id="xqNameId" name="xqName">
			<c:if test="${!empty yhInfoList }">
			   <option>--选择小区名称--</option>
				<c:forEach items="${yhInfoList}" var="yhInfolist">
					<option>${yhInfolist.aREANAME}</option>
				</c:forEach>
			</c:if>
		</select>
		<label for="readMTime">选择时间:</label>
		  <input type="text" id="recordTime1" name="recordTime1" class="btn btn-success btn-block"  class="Wdate" onfocus="WdatePicker();" />
		-<input type="text" id="recordTime2"  name="recordTime2"  class="btn btn-success btn-block" class="Wdate" onfocus="WdatePicker();" />	
<input class="btn btn-success" type="button" onclick="searchInfo()" class="btn btn-success btn-block" value="搜索">
<input type="button" value="导出"class="btn btn-success" onclick="doExportExcel()" />
<hr>
<div class="dwrapper">
	<table id="fixed_hdr2">
	<thead style="color: white;">
	<tr height="35px" style="background: url(../img/secai.png);">
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