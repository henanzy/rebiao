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

<title>信息管理</title>
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
					width : 60,
					align : 'center'
				},{
					width : 80,
					align : 'center'
				}, {
					width : 100,
					align : 'center'
				}, {
					width : 50,
					align : 'center'
				},
				{
					width : 100,
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
				},  {
					width : 80,
					align : 'center'
				},{
					width : 70,
					align : 'center'
				}, {
					width : 150,
					align : 'center'
				}, {
					width : 70,
					align : 'center'
				} 
				/* , {
					width : 150,
					align : 'center'
				} */  
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
									/* var buildNO = d[i].buildNO; */
									var buildNO = d[i].rbLyName;
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
    var   rbfl=$('#rbfl').val();
    var html ="";
	$.ajax({ 
		        url:"searchRb.action",
				async : false,
				dataType : "json",
				data : {
					"xqName" : xqName,
					"rbLyName" : buildNo,
					"cellNo" : cellNo,
					"houseNo" : houseNo,
					"rbfl":rbfl,
				},
				success : function(data) {
					$("#RbInfo").empty();
					var d=data.findList;
					for(var i=0;i<d.length;i++){
						var id=d[i].yh.id;
						var yhName=d[i].yh.yhName;
						var xqName=d[i].yh.xqName;
						var buildNo=d[i].yh.buildNO;
						var rbLyName=d[i].yh.rbLyName;
						var cellNo=d[i].yh.cellNO;
						var houseNo =d[i].yh.houseNO ;
						var rbAd=d[i].rbAd;
						var energy=d[i].energy;	
						var power=d[i].power;
						var flow=d[i].flow;
						var inTmp=d[i].inTmp;
						var outTmp=d[i].outTmp;	
						var diffTmp=d[i].diffTmp;
						var operTime=d[i].operTime ;
						var rbType=d[i].rbType ;
						var energyLj=d[i].energyLj;
						/* var readMTime=FormatDate(d[i].readMTime) ; */
						var recordTime=FormatDate(d[i].recordTime) ;
						var rbExp=d[i].rbExp;
						var status=d[i].status;
						var rbfl=d[i].yh.rbfl;
					
						if(status==undefined){
							   status='';
						    }
						html+="<tr>";
						html+="<td class='text-center'><input type='checkbox'  value='"+id+"'/></td>";
						if(rbExp==1){
							html+="<td class='text-center' ><font color='red'>"+yhName+"</font></td>";
						}else if(rbExp==2){
							html+="<td class='text-center'><font color='blue'>"+yhName+"</font></td>";	
						}else{
							html+="<td class='text-center'>"+yhName+"</td>";
						}
					
						html+="<td class='text-center'>"+xqName+"</td>";
						html+="<td class='text-center'>"+buildNo+"</td>";
						html+="<td class='text-center'>"+rbLyName+"</td>";
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
						/* html+="<td class='text-center'>"+status+"</td>"; */
						/* if(status==00){
							html+="<td class='text-center'>正常</td>";
						}else if(status==02){
							html+="<td class='text-center'>故障</td>";
						}else if(status==40){
							html+="<td class='text-center'>欠压</td>";
						}else{ */
							if(status==undefined){
								   status='';
							    }
							    	html+="<td class='text-center'>"+status+"</td>";
							    
						/* } */
						if(rbfl==0){
							html+="<td class='text-center'>流量</td>";
						}else{
							html+="<td class='text-center'>面积</td>";
						}
						html+="<td class='text-center' title='"+operTime+"'>"+operTime+"</td>";
						html+="<td class='text-center' title='"+recordTime+"'>"+recordTime+"</td>";
						html+="<td class='text-center' title='"+rbType+"'>"+rbType+"</td>";
					/* 	html+="<td class='text-center' title='"+readMTime+"'>"+readMTime+"</td>"; */
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
function update(title, url, w, h){
	var ckbs=$("#RbInfo input[type=checkbox]:checked");
	if(ckbs.length==0){
		alert("请选择要读取的阀门ID");
		return false;
	}
	if(ckbs.length>1){
		alert("对不起一次只能选择一个");
		return false;
	}
	var id=ckbs.val();
	var url=url+"?id="+id;
	layer_show(title, url, w, h);
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
			<option value="">--选择楼栋号--</option>
		</select>
	&nbsp;&nbsp;&nbsp;
		<label for="cellNoId">单元号</label> 
		<select name="cellNo" id="cellNoId">
			<option value="">--选择单元号--</option>
		</select>

	户号：<input type="text" name="houseNo" id="houseNoId" value="${houseNo}"  />
选择收费类型：<select id="rbfl">
		<option value="2" >请选择收费方式</option>
		<option value="0" selected="selected">流量</option>
		<option value="1">面积</option>
		</select>
<input class="btn btn-success" type="button" onclick="searchInfo()" style="background-color:#2B919D;border:1px" value="搜索">
<button type="button" class="btn btn-success" style="background-color:#2B919D;border:1px" onclick="update('修改用户信息','<%=basePath%>RbCon/updYhMe.action','560','600')">修改信息</button>
<hr>
	<div class="dwrapper">
		<table id="fixed_hdr2">
			<thead style="color: white;">
				<tr height="35px">
				<th></th>
				<th>用户姓名</th>
				<th>小区名称</th>
				<th>楼栋号</th>
				<th>楼宇号</th>
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
				<th>热表类型</th>
				<!-- <th>实时时间</th> -->
				</tr>
			</thead>
			<tbody id="RbInfo">
				<c:forEach var="rb" items="${rbList}" varStatus="status">
				<tr <c:if test="${status.index%2==1 }">style="background-color:#eef3fa"</c:if> data-toggle="modal"
				data-target="#add">
				<td class='text-center'><input type='checkbox'  value='${rb.yh.id}'/></td>
				<c:choose>
				<c:when test="${rb.rbExp==1}">
					<td><font color="red">${rb.yh.yhName}</font></td>
				</c:when>
				<c:when test="${rb.rbExp==2}">
				<td><font color="blue">${rb.yh.yhName}</font></td>
				</c:when>
				<c:otherwise>
				<td>${rb.yh.yhName}</td>
				</c:otherwise>
				</c:choose>
				
					<td>${rb.yh.xqName}</td>
					<td>${rb.yh.buildNO}</td>
					<td>${rb.yh.rbLyName}</td>
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
					<%-- <td>${rb.status}</td> --%>
					<%-- <c:choose>
					<c:when test="${rb.status==02}">
					<td>故障</td>
					</c:when>
					<c:when test="${rb.status==00}">
					<td>正常</td>
					</c:when>
					<c:when test="${rb.status==40}">
					<td>欠压</td>
					</c:when>
					<c:otherwise> --%>
					 <td>${rb.status}</td>
					<%-- </c:otherwise>
					</c:choose> --%>
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
					<td>${rb.rbType}</td>
					<%-- <td>${rb.readMTime}</td> --%>
					<%-- <td><fmt:formatDate value="${rb.readMTime}" pattern="yyyy-MM-dd HH:mm:ss" /> --%>
				</tr>
			</c:forEach>
		</table> 
	</div>

</body>
</html>