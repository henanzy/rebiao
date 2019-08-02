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
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
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
					width : 70,
					align : 'center'
				}, {
					width : 70,
					align : 'center'
				}, {
					width : 70,
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
					width : 110,
					align : 'center'
				}, {
					width : 70,
					align : 'center'
				}, {
					width : 70,
					align : 'center'
				}, {
					width : 150,
					align : 'center'
				}, {
					width : 150,
					align : 'center'
				}  
],
			sort : true
		});

	});
	</script>
	<script type="text/javascript">
	/*页面加载就开始执行js*/
	$(document).ready(
		
			function() {
				$("#xqNameId").change(
						function() {
							$.get("findYhBuildNObyXqName.action?xqName="
									+ $("#xqNameId").val(), function(data) {
								var dd = data;
								var d = dd.xqlist;
								$("#buildNoId option:gt(0)").remove();
								$("#cellNoId option:gt(0)").remove();
								for (var i = 0; i < d.length; i++) {
									var buildNO = d[i].buildNO;

									var opt = "<option value='"+buildNO+"'>"
											+ buildNO + "</option>"
									$("#buildNoId").append(opt);
								}
							});
						});

				$("#buildNoId").change(
						function() {
							$.get("findYhCellNOByBuild.action?build="
									+ $("#buildNoId").val() + "&xqName="
									+ $("#xqNameId").val(), function(data) {
								var dd = data;
								var d = dd.cellList;
								$("#cellNoId option:gt(0)").remove();
								for (var i = 0; i < d.length; i++) {
									var cellNO = d[i].cellNO;
									var opt = "<option value='"+cellNO+"'>"
											+ cellNO + "</option>"
									$("#cellNoId").append(opt);
								}
							});
						});
			});
</script>
 <script type="text/javascript">
 //搜索
function searchInfo(){
    var   xqName = $('#xqNameId').val();
    var   buildNo=$('#buildNoId').val();
    var   cellNo=$('#cellNoId').val();
    var   houseNo=$('#houseNoId').val();
    var   recordTime1=$('#recordTime1').val();
    var   recordTime2=$('#recordTime2').val();
    var html ="";
	$.ajax({ 
		        url:"searchRbsljj.action",
				async : false,
				dataType : "json",
				data : {
					"xqName" : xqName,
					"buildNo" : buildNo,
					"cellNo" : cellNo,
					"houseNo" : houseNo,
					"recordTime1" : recordTime1,
					"recordTime2" : recordTime2,
				},
				success : function(data) {
					$("#RbInfo").empty();
					var d=data.findList;
					for(var i=0;i<d.length;i++){
						var yhName=d[i].yh.yhName;
						var xqName=d[i].yh.xqName;
						var buildNo=d[i].yh.buildNO;
						var cellNo=d[i].yh.cellNO;
						var houseNo =d[i].yh.houseNO ;
						var rbfl=d[i].yh.rbfl;
						var rbAd=d[i].rbAd;
						var energy=d[i].energy;	
						var power=d[i].power;
						var flow=d[i].flow;
						var inTmp=d[i].inTmp;
						var outTmp=d[i].outTmp;	
						var diffTmp=d[i].diffTmp;
						var operTime=d[i].operTime ;
						var energyLj=d[i].energyLj;
						var readMTime=FormatDate(d[i].readMTime) ;
						var recordTime=FormatDate(d[i].recordTime) ;
						var status=d[i].status;
						if(status==undefined){
							   status='';
						    }
						var bz=d[i].yh.bz;
						html+="<tr>";
						html+="<td class='text-center' title="+bz+">"+yhName+"</td>";
						html+="<td class='text-center'>"+xqName+"</td>";
						html+="<td class='text-center'>"+buildNo+"</td>";
						html+="<td class='text-center'>"+cellNo+"</td>";
						html+="<td class='text-center'>"+houseNo+"</td>";
						html+="<td class='text-center'>"+rbAd+"</td>";
						html+="<td class='text-center'>"+energy+"</td>";
						html+="<td class='text-center'>"+power+"</td>";
						html+="<td class='text-center'>"+energyLj+"</td>";
						html+="<td class='text-center'>"+flow+"</td>";
						html+="<td class='text-center'>"+inTmp+"</td>";
						html+="<td class='text-center'>"+outTmp+"</td>";
						html+="<td class='text-center'>"+diffTmp+"</td>";
						if(status==undefined){
							   status='';
						    }
						  html+="<td class='text-center'>"+status+"</td>";
					/* 	html+="<td class='text-center'>"+status+"</td>"; */
						if(rbfl==0){
							html+="<td class='text-center'>流量</td>";
						}else{
							html+="<td class='text-center'>面积</td>";
						}
						
						html+="<td class='text-center' title='"+operTime+"'>"+operTime+"</td>";
						html+="<td class='text-center' title='"+recordTime+"'>"+recordTime+"</td>";
						html+="<td class='text-center' title='"+readMTime+"'>"+readMTime+"</td>";
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
		var buildNo = $('#buildNoId').val();
		var cellNo = $('#cellNoId').val();
		var houseNo = $('#houseNoId').val();
		var recordTime1=$('#recordTime1').val();
		var recordTime2=$('#recordTime2').val();
		window.open("RbdoExportExcel.action?xqName=" + xqName + "&buildNo="
				+ buildNo + "&cellNo=" + cellNo + "&houseNo=" + houseNo
			+"&recordTime1="+ recordTime1+"&recordTime2="+ recordTime2);
	}
</script>
<body>
		<label for="xqNameId">选择小区</label> 
		<select id="xqNameId" name="xqName">
			<c:if test="${!empty yhInfoList }">
			   <option>--选择小区名称--</option>
				<c:forEach items="${yhInfoList}" var="yhInfolist">
					<option>${yhInfolist.xqName}</option>
				</c:forEach>
			</c:if>
		</select>
		&nbsp;&nbsp;&nbsp;

		<label for="buildNoId">楼栋号</label>
		 <select name="buildNo" id="buildNoId">
			<option value=0>--选择楼栋号--</option>
		</select>
	&nbsp;&nbsp;&nbsp;
		<label for="cellNoId">单元号</label> 
		<select name="cellNo" id="cellNoId">
			<option value=0>--选择单元号--</option>
		</select>

	户号：<input type="text" name="houseNo" id="houseNoId" value="${houseNo}"  />
		<label for="readMTime">选择时间:</label>
		  <input type="text" id="recordTime1" name="recordTime1" class="Wdate" onfocus="WdatePicker();" />
		-<input type="text" id="recordTime2"  name="recordTime2"  class="Wdate" onfocus="WdatePicker();" />	
		
		<input class="btn btn-success" type="button" onclick="searchInfo()" value="搜索" style="background-color:#2B919D;border:1px" >
		<input type="button" value="导出"class="btn btn-success" onclick="doExportExcel()" style="background-color:#2B919D;border:1px"  />
	<div class="dwrapper">
		<table id="fixed_hdr2">
			<thead style="color: white;">
				<tr height="35px">
				<th>用户姓名</th>
				<th>小区名称</th>
				<th>楼栋号</th>
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
				<th>仪表状态</th>
				<th>收费类型</th>
				<th>工作时间</th>
				<th>更新时间</th>
				<th>实时时间</th>
				</tr>
			</thead>
			<tbody id="RbInfo">
				<c:forEach var="rb" items="${rbList}" varStatus="status">
				<tr <c:if test="${status.index%2==1 }">style="background-color:#eef3fa"</c:if> data-toggle="modal"
				data-target="#add">
					<td title="${rb.yh.bz}">${rb.yh.yhName}</td>
					<td>${rb.yh.xqName}</td>
					<td>${rb.yh.buildNO}</td>
					<td>${rb.yh.cellNO}</td>
					<td>${rb.yh.houseNO}</td>
					<td>${rb.rbAd}</td>
					<td>${rb.energy}</td>
					<td>${rb.power}</td>
					<td>${rb.energyLj}</td>
					<td>${rb.flow}</td>
					<td>${rb.inTmp}</td>
					<td>${rb.outTmp}</td>
					<td>${rb.diffTmp}</td>
					<td>${rb.status}</td>
					<c:choose>
					<c:when test="${rb.yh.rbfl==0}">
					<td>流量</td>
					</c:when>
					<c:otherwise>
					<td>面积</td>
					</c:otherwise>
					</c:choose>
					<td>${rb.operTime}</td>
					<td><fmt:formatDate value="${rb.recordTime}" pattern="yyyy-MM-dd HH:mm:ss" />
					<td>${rb.readMTime}</td>
					<%-- <td><fmt:formatDate value="${rb.readMTime}" pattern="yyyy-MM-dd HH:mm:ss" /> --%>
				</tr>
			</c:forEach>
		</table> 
	</div>
</body>
</html>