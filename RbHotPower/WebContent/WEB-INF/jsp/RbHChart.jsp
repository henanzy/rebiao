<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../css/fmhistorypage.css" />
<link rel="stylesheet" type="text/css"
	href="../my-iconfont/1.0.8/iconfont.css" />
<style type="text/css">
.charts_grid {
	width: 60%;
	height: 60%;
	border: 1px solid #CCCCCC;
	margin: 10px;
}
h2{
padding-left: 50%;
padding-top: 0px;
margin-top: 0px;
}
</style>
<script src="../js/selectmenu.js"></script>
<script src="../jquery-1.4.4.min.js"></script>
<script src="../echarts-3.5.3/echarts.min.js"></script>
<script type="text/javascript" src="../js/static/h-ui.admin/js/H-ui.admin.js"></script>
<link href="../css/fixed_table_rc.css" type="text/css" rel="stylesheet"	media="all" />
<link href="../css/bootstrap.css" type="text/css" rel="stylesheet"	/>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script	src="https://meetselva.github.io/fixed-table-rows-cols/js/sortable_table.js"
	type="text/javascript"></script>
<script src="../js/fixed_table_rc.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/layer/2.4/layer.js"></script>
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
    var html ="";
	$.ajax({ 
		        url:"findBzxx.action",
				async : false,
				dataType : "json",
				data : {
					"xqName" : xqName,
					"buildNo" : buildNo,
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
					"buildNo" : buildNo,
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
		

function CUpbz(){
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
						"buildNo" : buildNo,
						"cellNo" : cellNo,
						"houseNo" : houseNo,
						"houseNo" : houseNo,
					},
					success : function(data) {
						$("#RbInfo").empty();
						var d=data.bz;
						   $(".inp").val(d);  
					}

				});
}
window.onload = function() {
	CUpbz();

  }
//时间转换
function FormatDate (strTime) {
    var date = new Date(strTime);
    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
}
</script>
</head>
<body>

&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;
         
         
          <% request.setCharacterEncoding("utf-8"); %>
          <% String xqName=new String(request.getParameter("xqName").getBytes("ISO8859-1"),"UTF-8");%>
          <% String cellNO=request.getParameter("cellNO"); %>
          <% String buildNO=request.getParameter("buildNO"); %>
          <% String houseNO=request.getParameter("houseNO"); %>
            <span style="padding-top: 2px; padding-left: 30px; margin-top: 2px;"> <a href="javascript:history.back(-1)">返回</a></span>
         &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;小区名字：<%=xqName %> &nbsp; 楼栋号：<%=buildNO %> &nbsp; 单元号：<%=cellNO %>&nbsp; 户号：<%=houseNO %>
<h2>历史数据</h2>
<div id="yhfmhistory" class="charts_grid" style="width: 1060px; height: 360px; margin: 0 auto"></div>
<hr>
<div style="width: 1060px; height: 360px; margin: 0 auto">
小区：<input type="text" id="xqNameId" value="<%=xqName %>">
楼栋：<input type="text" id="buildNoId" value="<%=buildNO %>">
单元：<input type="text" id="cellNoId" value="<%=cellNO %>">
户号：<input type="text" id="houseNoId" value="<%=houseNO %>">

&nbsp;&nbsp;&nbsp;<input class="btn btn-success" type="button" onclick="searchInfo()"  value="搜索" style="background-color:#2B919D;border:1px" >
<hr>
&nbsp;&nbsp;&nbsp;备注内容：<input class="inp" type="text" id="bz" size="80px">&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-success" onclick="Upbz()"value="提交" style="background-color:#2B919D;border:1px">
</div>
</body>
<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../echarts-3.5.3/echarts.min.js"></script>
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript">
window.onresize = function(){
myChart.resize();
}
</script>
<script type="text/javascript">
var date = new Date();
var time = date.toLocaleDateString();
var myChart = echarts.init(document.getElementById('yhfmhistory'));
var option = {
title: {
    text: '温控阀记录',   
    subtext: time
},
tooltip: {
    trigger: 'axis'
},
legend: {
    data:[] 
},
toolbox: {
    show: true,
    feature: {
        magicType: {type: ['line', 'bar']},
        saveAsImage: {}
    }
},
dataZoom: [
    {   type: 'slider', 
        start: 50,      
        end: 100       
    },
    {    type: 'inside',
        start: 50,  
        end: 100  
    }
],
xAxis:  {
    type: 'category',
    boundaryGap: false,
    data: []
},
yAxis: {
    type: 'value',
    axisLabel: {
        formatter: '{value} '
    },
    splitNumber:10
},
series: []
};
myChart.setOption(option);
myChart.showLoading();
var seriess=new Array();
var xAxiss=new Array();
var legends=new Array();
$.ajax({
	type:'GET',
	async: true,
	url:'historyLine.action',
	data:{RbAd:"${RbAd}"},
	dataType:'json',
	success:function(result) {
		console.log(result.xy);
	xAxiss=result.xy;
	 $.each(result.data, function(index, comment){
	   legends[index]=comment.name;
	        seriess.push({
            name: comment.name,
            type : 'line',
            data: comment.data,
            markPoint: {
            data: [
                {type: 'max', name: '最大值'},
                {type: 'min', name: '最小值'}
            ]
        },
            markLine: {
            data: [
                {type: 'average', name: '平均值'}
            ]
        }
           });
      });
      myChart.hideLoading();
	  myChart.setOption({
		    legend:{
		        data : legends
		    },
			xAxis : {
				data : xAxiss
			},
			series : seriess
		});
    },
	error : function(errorMsg) {
        myChart.hideLoading();
		alert("图表请求数据失败!");
	}
	});
</script>

</html>