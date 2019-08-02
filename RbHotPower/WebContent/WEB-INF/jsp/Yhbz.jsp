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
				width : 100,
				align : 'center'
			}, {
				width : 120,
				align : 'center'
			},
			{
				width : 100,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			}, {
				width : 90,
				align : 'center'
			}, {
				width : 120,
				align : 'center'
			}
			, {
				width : 100,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			}, {
				width : 150,
				align : 'center'
			}, {
				width : 100,
				align : 'center'
			} , {
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
    var html ="";
	$.ajax({ 
		        url:"findBzxx.action",
				async : false,
				dataType : "json",
				data : {
					"xqName" : xqName,
					"rbLyName" : buildNo,
					"cellNo" : cellNo,
					"houseNo" : houseNo,
					"houseNo" : houseNo,
				},
				success : function(data) {
					$("#RbInfo").empty();
					var d=data.bz;
					   $(".inp").val(d);  
				}

			})
		}
 
//搜索
function Upbz(){
    var   xqName = $('#xqNameId').val();
    var   buildNo=$('#buildNoId').val();
    var   cellNo=$('#cellNoId').val();
    var   houseNo=$('#houseNoId').val();
    var   bz=$('#bz').val();
    var html ="";
	$.ajax({ 
		        url:"Upbz.action",
				async : false,
				dataType : "json",
				data : {
					"xqName" : xqName,
					"rbLyName" : buildNo,
					"cellNo" : cellNo,
					"houseNo" : houseNo,
					"houseNo" : houseNo,
					"bz" : bz,
				},
				success : function(data) {
					$("#RbInfo").empty();
					var d=data.str;
					   $(".inp").val(d);  
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
			<option value=0>--选择楼栋号--</option>
		</select>
	&nbsp;&nbsp;&nbsp;
		<label for="cellNoId">单元号</label> 
		<select name="cellNo" id="cellNoId">
			<option value=0>--选择单元号--</option>
		</select>

	户号：<input type="text" name="houseNo" id="houseNoId" value="${houseNo}"  />

    <input class="btn btn-success" type="button" onclick="searchInfo()" value="搜索" style="background-color:#2B919D;border:1px" >
    <hr>
     &nbsp;&nbsp;&nbsp;备注内容：<input class="inp" type="text" id="bz" size="80px">&nbsp;&nbsp;&nbsp;
    <input type="button" class="btn btn-success" onclick="Upbz()"value="提交" style="background-color:#2B919D;border:1px">

</body>
</html>