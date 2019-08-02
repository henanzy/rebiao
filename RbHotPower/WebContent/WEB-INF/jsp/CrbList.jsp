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

<title>设备管理</title>
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
					width : 40,
					align : 'center'
				},{
					width : 80,
					align : 'center'
				}, {
					width : 100,
					align : 'center'
				},
				{
					width : 50,
					align : 'center'
				},
				{
					width : 100,
					align : 'center'
				}, {
					width : 50,
					align : 'center'
				}, {
					width : 60,
					align : 'center'
				}, {
					width : 100,
					align : 'center'
				}, {
					width : 80,
					align : 'center'
				}, {
					width : 80,
					align : 'center'
				}, {
					width : 80,
					align : 'center'
				}, {
					width : 80,
					align : 'center'
				}, {
					width : 80,
					align : 'center'
				}, {
					width : 80,
					align : 'center'
				}
				, {
					width : 80,
					align : 'center'
				}, {
					width : 150,
					align : 'center'
				}, {
					width : 150,
					align : 'center'
				}, {
					width : 80,
					align : 'center'
				}, {
					width : 150,
					align : 'center'
				}, {
					width : 80,
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
						var yhName=d[i].yh.yhName;
						var xqName=d[i].yh.xqName;
						var buildNo=d[i].yh.buildNO;
						var rbLyName=d[i].yh.rbLyName;
						var cellNo=d[i].yh.cellNO;
						var houseNo =d[i].yh.houseNO ;
						var rbAd=d[i].rbAd;
						var qgId=d[i].qgId;
						var energy=d[i].energy;	
						var power=d[i].power;
						var flow=d[i].flow;
						var inTmp=d[i].inTmp;
						var outTmp=d[i].outTmp;	
						var diffTmp=d[i].diffTmp;
						var operTime=d[i].operTime ;
						var rbType=d[i].rbType ;
						var bz=d[i].yh.bz;
						var energyLj=d[i].energyLj;
						/* var readMTime=FormatDate(d[i].readMTime) ; */
						var recordTime=FormatDate(d[i].recordTime) ;
						var rbExp=d[i].rbExp;
						var status=d[i].status;
						
						html+="<tr>";
						html+="<td class='text-center'><input type='checkbox'  value='"+rbAd+"'/></td>";
						if(rbExp==1){
							html+="<td class='text-center' title='"+bz+"'><font color='red'>"+yhName+"</font></td>";
						}else if(rbExp==2){
							html+="<td class='text-center' title='"+bz+"'><font color='blue'>"+yhName+"</font></td>";	
						}else{
							html+="<td class='text-center' title='"+bz+"'>"+yhName+"</td>";
						}
					   
						html+="<td class='text-center'>"+xqName+"</td>";
						html+="<td class='text-center'>"+buildNo+"</td>";
						html+="<td class='text-center'>"+rbLyName+"</td>";
						html+="<td class='text-center'>"+cellNo+"</td>";
						html+="<td class='text-center'>"+houseNo+"</td>";
						html+="<td class='text-center'>"+rbAd+"</td>";
						if(energy==999.00){
							html+="<td class='text-center'><font color='red'>"+energy+"<font></td>";
						}else{
							html+="<td class='text-center'>"+energy+"</td>";	
						}
						if(power==999.00){
							html+="<td class='text-center'><font color='red'>"+power+"</font></td>";
						}else{
							html+="<td class='text-center'>"+power+"</td>";
						}
					/* 	html+="<td class='text-center'>"+power+"</td>"; */
						html+="<td class='text-center'>"+energyLj+"</td>";
						if(flow==999.00){
							html+="<td class='text-center'><font color='red'>"+flow+"</font></td>";
						}else{
							html+="<td class='text-center'>"+flow+"</td>";
						}
						/* html+="<td class='text-center'>"+flow+"</td>"; */
						html+="<td class='text-center'>"+inTmp+"</td>";
						html+="<td class='text-center'>"+outTmp+"</td>";
						html+="<td class='text-center'>"+diffTmp+"</td>";
					/* 	if(status==00){
							html+="<td class='text-center'>正常</td>";
						}else if(status==02){
							html+="<td class='text-center'>故障</td>";
						}else if(status==40){
							html+="<td class='text-center'>欠压</td>";
						}else{ */
							if(status==undefined){
								   status='';
								   html+="<td class='text-center'>"+status+"</td>";
							    }else if(status=='正常'){
							    	html+="<td class='text-center'>"+status+"</td>";
							    }else{
							    	html+="<td class='text-center'><font color='red'>"+status+"</font></td>";	
							    }
						
							
							    
						/* } */
					
						html+="<td class='text-center'>"+qgId+"</td>";
						html+="<td class='text-center' title='"+operTime+"'>"+operTime+"</td>";
						if(recordTime==null){
							html+="<td class='text-center' title='"+recordTime+"'>"+""+"</td>";
						}
						html+="<td class='text-center' title='"+recordTime+"'>"+recordTime+"</td>";
						html+="<td class='text-center' title='"+rbType+"'>"+rbType+"</td>";
						/* html+="<td class='text-center' title='"+readMTime+"'>"+readMTime+"</td>"; */
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
function drb(){
	var ckbs=$("#RbInfo input[type=checkbox]:checked");
	var apiContentStr;
	if(ckbs.length==0){
		alert("请选择要读取的热表");
		return false;
	}
	var ids=[];
	$.each(ckbs,function(index,data){
		ids[index]=$(data).val();
	})
	 var apiContentStr="";
	for(var i=0;i<ids.length;i++){
  			 apiContentStr=ids[i];
  				$.ajax({
  				url:"/RbHotPower/RbCon/rebInfo.action",
  				async:false,
  				dataType:"json",
  				data:{	
  					"ids":apiContentStr,
  				},
  				success:function(data){
  					msg=data.js
  					if(msg=="0"){
  						alert(data.rbId+"读热表接收指令成功!")
  					}
  					if(msg=="4"){
  					    alert(data.rbId+" 集中器不在线");
  					}
  					if(msg=="1"){
  						alert(data.rbId+" 读热表失败!")
  					}
  				}
  				
  			});
  	}	 
	searchInfo();
}
 function drop(){
		var ckbs=$("#RbInfo input[type=checkbox]:checked");
		var apiContentStr;
		if(ckbs.length==0){
			alert("请选择要删除的热表");
			return false;
		}
		var ids=[];
		$.each(ckbs,function(index,data){
			ids[index]=$(data).val();
		})
		var apiContentStr="";
		for(var i=0;i<ids.length;i++){
	   			 apiContentStr=ids[i];
	   			$.ajax({
	   				url:"/RbHotPower/RbCon/dropRb.action",
	   				async:false,
	   				dataType:"json",
	   				data:{	
	   					"ids":apiContentStr,
	   				},
	   				success:function(data){
	   					msg=data.js
	   					if(msg=="0"){
	   						alert(data.rbId+"读热表接收指令成功!")
	   					}
	   					if(msg=="1"){
	   						alert(data.rbId+" 读热表失败!")
	   					}
	   					if(msg=="2"){
	   						alert(data.rbId+" 数据失败");
	   					}
	   					if(msg=="3"){
	   						alert(data.rbId+" 超时")
	   					}
	   					if(msg=="4"){
	   					    alert(data.rbId+" 集中器不在线");
	   					}
	   					if(msg=="5"){
	   					    alert("该用户无权限!");
	   					}
	   				}
	   				
	   			});
	   	}	
		searchInfo();
	}
 
 function add(){
		var ckbs=$("#RbInfo input[type=checkbox]:checked");
	    var   xgRb=$('#xgRb').val();
	    var re = /^[0-9]+.?[0-9]*$/;
	    if (!re.test(xgRb)) {
		　　　　alert("请输入数字");
		　　　　document.getElementById(xgRb).value = "";
		　　　　return false;
		　　}
		var apiContentStr;
		if(ckbs.length==0){
			alert("请选择要添加的热表");
			return false;
		}
		var ids=[];
		$.each(ckbs,function(index,data){
			ids[index]=$(data).val();
		})
		var apiContentStr="";
		for(var i=0;i<ids.length;i++){
	   			 apiContentStr=ids[i];
	   			$.ajax({
	   				url:"/RbHotPower/RbCon/addRb.action",
	   				async:false,
	   				dataType:"json",
	   				data:{	
	   					"ids":apiContentStr,
	   					"xgRb":xgRb,
	   				},
	   				success:function(data){
	   					msg=data.js
	   					if(msg=="0"){
	   						alert(data.rbId+"读热表接收指令成功!")
	   					}
	   					if(msg=="1"){
	   						alert(data.rbId+" 读热表失败!")
	   					}
	   					if(msg=="2"){
	   						alert(data.rbId+" 数据失败");
	   					}
	   					if(msg=="4"){
	   					    alert(data.rbId+" 集中器不在线");
	   					}
	   				}
	   				
	   			});
	   	}	
		searchInfo();
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

	户号：<input type="text" size="10px" name="houseNo" id="houseNoId" value="${houseNo}"  />
选择收费类型：<select id="rbfl">
		<option value="2" >请选择收费方式</option>
		<option value="0" selected="selected">流量</option>
		<option value="1">面积</option>
		</select>
<input class="btn btn-success" type="button" onclick="searchInfo()" value="搜索" style="background-color:#2B919D;border:1px" >
<button type="button" class="btn btn-success" onclick="drb()" style="background-color:#2B919D;border:1px" >读取热表</button>
<!-- <input type="text" size="10px" id="xgRb"><button  type="button" class="btn btn-success" onclick="add()" style="background-color:#2B919D;border:1px" >添加热表地址</button> 
<button  type="button" class="btn btn-success" onclick="drop()" style="background-color:#2B919D;border:1px" >删除热表地址</button> -->
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
				<th>区管ID</th>
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
				<td class='text-center'><input type='checkbox'  value='${rb.rbAd}'/></td>
				<c:choose>
				<c:when test="${rb.rbExp==1}">
					<td title="${rb.yh.bz}"><font color="red">${rb.yh.yhName}</font></td>
				</c:when>
				<c:when test="${rb.rbExp==2}">
				<td title="${rb.yh.bz}"><font color="blue">${rb.yh.yhName}</font></td>
				</c:when>
				<c:otherwise>
				<td title="${rb.yh.bz}">${rb.yh.yhName}</td>
				</c:otherwise>
				</c:choose>
				
					<td>${rb.yh.xqName}</td>
					<td>${rb.yh.buildNO}</td>
					<td>${rb.yh.rbLyName}</td>
					<td>${rb.yh.cellNO}</td>
					<td>${rb.yh.houseNO}</td>
					<td>${rb.rbAd}</td>
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
					
				<%-- 	<td>${rb.energyLj}</td> --%>
					
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
					<%-- <td>${rb.flow}</td> --%>
					<td>${rb.inTmp}</td>
					<td>${rb.outTmp}</td>
					<td>${rb.diffTmp}</td>
					<c:choose>
   					<c:when test="${rb.status=='正常'}">
   					<td>${rb.status}</td>
   					</c:when>
   					<c:otherwise>
   					<td><font color="red">${rb.status}</font></td> 
   					</c:otherwise>
   					</c:choose>
					 <%-- <td>${rb.status}</td> --%>
					<td>${rb.qgId}</td>
					<td>${rb.operTime}</td>
				    <td><fmt:formatDate value="${rb.recordTime}" pattern="yyyy-MM-dd HH:mm:ss" />
					<td>${rb.rbType}</td>
					<%-- <td>${rb.readMTime}</td> --%>
				</tr>
			</c:forEach>
		</table> 
	</div>

</body>
</html>