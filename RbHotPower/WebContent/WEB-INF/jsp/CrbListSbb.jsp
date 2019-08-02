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
			height : 700,
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
					width : 90,
					align : 'center'
				}, {
					width : 50,
					align : 'center'
				}, {
					width : 50,
					align : 'center'
				}, {
					width : 100,
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
					width : 150,
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
				},
				/* {
					width : 150,
					align : 'center'
				}, */
				{
					width : 100,
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
    var   recordTime1=$('#recordTime1').val();
    var   recordTime2=$('#recordTime2').val();
    var   rbfl=$('#rbfl').val();
    var html ="";
	$.ajax({ 
		        url:"searchRbSbb.action",
				async : false,
				dataType : "json",
				data : {
					"xqName" : xqName,
					"buildNo" : buildNo,
					"cellNo" : cellNo,
					"houseNo" : houseNo,
					"recordTime1" : recordTime1,
					"recordTime2" : recordTime2,
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
						var resNum =d[i].yh.resNum ;
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
						 var rbType=d[i].rbType; 
						if(rbType==undefined){
							rbType="";
						}else{
						   rbType=d[i].rbType; 	
						}
						
						var recordTime=d[i].recordTime;
						
						var status=d[i].status;
						
						/* if(readMTime==undefined){
							 readMTime="";
						}else{
							 readMTime=FormatDate(d[i].readMTime) ;
						} */
						if(recordTime==undefined){
							 recordTime="";
						}else{
							 recordTime=FormatDate(d[i].recordTime) ;
						}
						var bz=d[i].yh.bz;
						var rbExp=d[i].rbExp;
						html+="<tr>";
						if(rbExp==1){
							html+="<td class='text-center' title="+bz+"><font color='red'>"+yhName+"</font></td>";
						}else if(rbExp==2){
							html+="<td class='text-center' title="+bz+"><font color='blue'>"+yhName+"</font></td>";
						}else{
							html+="<td class='text-center' title="+bz+">"+yhName+"</td>";
						}
						html+="<td class='text-center'>"+xqName+"</td>";
						html+="<td class='text-center'>"+buildNo+"</td>";
						html+="<td class='text-center'>"+rbLyName+"</td>";
						html+="<td class='text-center'>"+cellNo+"</td>";
						html+="<td class='text-center'>"+houseNo+"</td>";
						html+="<td class='text-center'>"+resNum+"</td>";
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
				
						if(energyLj==999.00){
							html+="<td class='text-center'><font color='red'>"+energyLj+"</font></td>";
						}else{
							html+="<td class='text-center'>"+energyLj+"</td>";
						}
						if(flow==999.00){
							html+="<td class='text-center'><font color='red'>"+flow+"</font></td>";
						}else{
							html+="<td class='text-center'>"+flow+"</td>";
						}
						html+="<td class='text-center'>"+inTmp+"</td>";
						html+="<td class='text-center'>"+outTmp+"</td>";
						html+="<td class='text-center'>"+diffTmp+"</td>";
						if(status==undefined){
							   status='';
							   html+="<td class='text-center'>"+status+"</td>";
						    }else if(status=='正常'){
						    	html+="<td class='text-center'>"+status+"</td>";
						    }else{
						    	html+="<td class='text-center'><font color='red'>"+status+"</font></td>";	
						    }
					
						/*	html+="<td class='text-center'>"+status+"</td>";
						 } */
						if(rbfl==0){
							html+="<td class='text-center'>流量</td>";
						}else if(rbfl==1){
							html+="<td class='text-center'>面积</td>";
						}else{
							html+="<td class='text-center'></td>";
						}
						
						html+="<td class='text-center' title='"+operTime+"'>"+operTime+"</td>";
						html+="<td class='text-center' title='"+recordTime+"'>"+recordTime+"</td>";
						
						html+="<td class='text-center' title='"+rbType+"'>"+rbType+"</td>";
						html+="<td class='text-center'>"+bz+"</td>";
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
function CbJc(obj){
    var  cb = obj;
    var  xqName = $('#xqNameId').val();
    var  buildNo=$('#buildNoId').val();
    var  cellNo=$('#cellNoId').val();
    var html ="";
	$.ajax({ 
		        url:"CbJc.action",
				async : false,
				dataType : "json",
				data : {
					"cb" : cb,
					"xqName":xqName,
					"rbLyName" : buildNo,
					"cellNo" : cellNo,
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
						var resNum =d[i].yh.resNum ;
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
						/* var readMTime=FormatDate(d[i].readMTime) ; */
						var recordTime=FormatDate(d[i].recordTime) ;
						var status=d[i].status;
						 var rbType=d[i].rbType; 
							if(rbType==undefined){
								rbType="";
							}else{
							   rbType=d[i].rbType; 	
							}
						var bz=d[i].yh.bz;
						var rbfl=d[i].yh.rbfl;
						var rbExp=d[i].rbExp;
						html+="<tr>";
						if(rbExp==1){
							html+="<td class='text-center' title="+bz+"><font color='red'>"+yhName+"</font></td>";
						}else if(rbExp==2){
							html+="<td class='text-center' title="+bz+"><font color='blue'>"+yhName+"</font></td>";
						}else{
							html+="<td class='text-center' title="+bz+">"+yhName+"</td>";
						}
						html+="<td class='text-center'>"+xqName+"</td>";
						html+="<td class='text-center'>"+buildNo+"</td>";
						html+="<td class='text-center'>"+rbLyName+"</td>";
						html+="<td class='text-center'>"+cellNo+"</td>";
						html+="<td class='text-center'>"+houseNo+"</td>";
						html+="<td class='text-center'>"+resNum+"</td>";
						html+="<td class='text-center'>"+rbAd+"</td>";
						/* html+="<td class='text-center'>"+energy+"</td>";
						html+="<td class='text-center'>"+power+"</td>";
						html+="<td class='text-center'>"+energyLj+"</td>";
						html+="<td class='text-center'>"+flow+"</td>"; */
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
						/* html+="<td class='text-center'>"+energyLj+"</td>"; */
						if(energyLj==999.00){
							html+="<td class='text-center'><font color='red'>"+energyLj+"</font></td>";
						}else{
							html+="<td class='text-center'>"+energyLj+"</td>";
						}
						if(flow==999.00){
							html+="<td class='text-center'><font color='red'>"+flow+"</font></td>";
						}else{
							html+="<td class='text-center'>"+flow+"</td>";
						}
						html+="<td class='text-center'>"+inTmp+"</td>";
						html+="<td class='text-center'>"+outTmp+"</td>";
						html+="<td class='text-center'>"+diffTmp+"</td>";
						/* if(status==00){
							html+="<td class='text-center'>正常</td>";
						}else if(status==02){
							html+="<td class='text-center'>故障</td>";
						}else if(status==40){
							html+="<td class='text-center'>欠压</td>";
						}else{ */
						/* 	if(status==undefined){
								   status='';
							    }
							html+="<td class='text-center'>"+status+"</td>"; */
						if(status==undefined){
							   status='';
							   html+="<td class='text-center'>"+status+"</td>";
						    }else if(status=='正常'){
						    	html+="<td class='text-center'>"+status+"</td>";
						    }else{
						    	html+="<td class='text-center'><font color='red'>"+status+"</font></td>";	
						    }
					
							/* }
						html+="<td class='text-center'>"+status+"</td>"; */
						if(rbfl==0){
							html+="<td class='text-center'>流量</td>";
						}else{
							html+="<td class='text-center'>面积</td>";
						}
						html+="<td class='text-center' title='"+operTime+"'>"+operTime+"</td>";
						html+="<td class='text-center' title='"+recordTime+"'>"+recordTime+"</td>";
						html+="<td class='text-center' title='"+rbType+"'>"+rbType+"</td>";
						html+="<td class='text-center'>"+bz+"</td>";
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
   function Sel(){
	    var  Sxx = $('#SxxId').val();
	    var html ="";
		$.ajax({ 
			        url:"findRbHis.action",
					async : false,
					dataType : "json",
					data : {
						"Sxx" : Sxx,
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
							var resNum =d[i].yh.resNum ;
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
							/* var readMTime=FormatDate(d[i].readMTime) ; */
							var recordTime=FormatDate(d[i].recordTime) ;
							var status=d[i].status;
							var rbExp=d[i].rbExp;
							 var rbType=d[i].rbType; 
								if(rbType==undefined){
									rbType="";
								}else{
								   rbType=d[i].rbType; 	
								}
							var bz=d[i].yh.bz;
							html+="<tr>";
							if(rbExp==1){
								html+="<td class='text-center' title="+bz+"><font color='red'>"+yhName+"</font></td>";
							}else if(rbExp==2){
								html+="<td class='text-center' title="+bz+"><font color='blue'>"+yhName+"</font></td>";
							}else{
								html+="<td class='text-center' title="+bz+">"+yhName+"</td>";
							}
							html+="<td class='text-center'>"+xqName+"</td>";
							html+="<td class='text-center'>"+buildNo+"</td>";
							html+="<td class='text-center'>"+rbLyName+"</td>";
							html+="<td class='text-center'>"+cellNo+"</td>";
							html+="<td class='text-center'>"+houseNo+"</td>";
							html+="<td class='text-center'>"+resNum+"</td>";
							html+="<td class='text-center'>"+rbAd+"</td>";
							/* html+="<td class='text-center'>"+energy+"</td>";
							html+="<td class='text-center'>"+power+"</td>";
							html+="<td class='text-center'>"+energyLj+"</td>";
							html+="<td class='text-center'>"+flow+"</td>"; */
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
							/* html+="<td class='text-center'>"+energyLj+"</td>"; */
							if(energyLj==999.00){
								html+="<td class='text-center'><font color='red'>"+energyLj+"</font></td>";
							}else{
								html+="<td class='text-center'>"+energyLj+"</td>";
							}
							
							
							if(flow==999.00){
								html+="<td class='text-center'><font color='red'>"+flow+"</font></td>";
							}else{
								html+="<td class='text-center'>"+flow+"</td>";
							}
							html+="<td class='text-center'>"+inTmp+"</td>";
							html+="<td class='text-center'>"+outTmp+"</td>";
							html+="<td class='text-center'>"+diffTmp+"</td>";
							/* html+="<td class='text-center'>"+status+"</td>"; */
						/* 	if(status==00){
								html+="<td class='text-center'>正常</td>";
							}else if(status==02){
								html+="<td class='text-center'>故障</td>";
							}else if(status==40){
								html+="<td class='text-center'>欠压</td>";
							}else{ */
							/* 	if(status==undefined){
									   status='';
								    }
								html+="<td class='text-center'>"+status+"</td>"; */
							if(status==undefined){
								   status='';
								   html+="<td class='text-center'>"+status+"</td>";
							    }else if(status=='正常'){
							    	html+="<td class='text-center'>"+status+"</td>";
							    }else{
							    	html+="<td class='text-center'><font color='red'>"+status+"</font></td>";	
							    }
						
							/* } */
							if(rbfl==0){
								html+="<td class='text-center'>流量</td>";
							}else if(rbfl==1){
								html+="<td class='text-center'>面积</td>";
							}else{
								html+="<td class='text-center'></td>";
							}
							html+="<td class='text-center' title='"+operTime+"'>"+operTime+"</td>";
							html+="<td class='text-center' title='"+recordTime+"'>"+recordTime+"</td>";
							/* html+="<td class='text-center' title='"+readMTime+"'>"+readMTime+"</td>"; */
								html+="<td class='text-center' title='"+rbType+"'>"+rbType+"</td>";
							html+="<td class='text-center'>"+bz+"</td>";
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
	  function GzSel(){
		    var  gzxx = $('#gzxxId').val();
		    var html ="";
			$.ajax({ 
				        url:"findRbGzxx.action",
						async : false,
						dataType : "json",
						data : {
							"gzxx" : gzxx,
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
								var resNum =d[i].yh.resNum ;
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
								 var rbType=d[i].rbType; 
									if(rbType==undefined){
										rbType="";
									}else{
									   rbType=d[i].rbType; 	
									}
								var recordTime=FormatDate(d[i].recordTime) ;
								var status=d[i].status;
								var bz=d[i].yh.bz;
								var rbExp=d[i].rbExp;
								html+="<tr>";
								if(rbExp==1){
									html+="<td class='text-center' title="+bz+"><font color='red'>"+yhName+"</font></td>";
								}else if(rbExp==2){
									html+="<td class='text-center' title="+bz+"><font color='blue'>"+yhName+"</font></td>";
								}else{
									html+="<td class='text-center' title="+bz+">"+yhName+"</td>";
								}
								/* html+="<td class='text-center' title="+bz+">"+yhName+"</td>"; */
								html+="<td class='text-center'>"+xqName+"</td>";
								html+="<td class='text-center'>"+buildNo+"</td>";
								html+="<td class='text-center'>"+rbLyName+"</td>";
								html+="<td class='text-center'>"+cellNo+"</td>";
								html+="<td class='text-center'>"+houseNo+"</td>";
								html+="<td class='text-center'>"+resNum+"</td>";
								html+="<td class='text-center'>"+rbAd+"</td>";
								/* html+="<td class='text-center'>"+energy+"</td>";
								html+="<td class='text-center'>"+power+"</td>";
								html+="<td class='text-center'>"+energyLj+"</td>";
								html+="<td class='text-center'>"+flow+"</td>"; */
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
								/* html+="<td class='text-center'>"+energyLj+"</td>"; */
								if(energyLj==999.00){
									html+="<td class='text-center'><font color='red'>"+energyLj+"</font></td>";
								}else{
									html+="<td class='text-center'>"+energyLj+"</td>";
								}
								if(flow==999.00){
									html+="<td class='text-center'><font color='red'>"+flow+"</font></td>";
								}else{
									html+="<td class='text-center'>"+flow+"</td>";
								}
								html+="<td class='text-center'>"+inTmp+"</td>";
								html+="<td class='text-center'>"+outTmp+"</td>";
								html+="<td class='text-center'>"+diffTmp+"</td>";
								/* html+="<td class='text-center'>"+status+"</td>"; */
							/* 	if(status==00){
									html+="<td class='text-center'>正常</td>";
								}else if(status==02){
									html+="<td class='text-center'>故障</td>";
								}else if(status==40){
									html+="<td class='text-center'>欠压</td>";
								}else{ */
								/* 	if(status==undefined){
										   status='';
									    }
									html+="<td class='text-center'>"+status+"</td>"; */
								if(status==undefined){
									   status='';
									   html+="<td class='text-center'>"+status+"</td>";
								    }else if(status=='正常'){
								    	html+="<td class='text-center'>"+status+"</td>";
								    }else{
								    	html+="<td class='text-center'><font color='red'>"+status+"</font></td>";	
								    }
							
								/* } */
								if(rbfl==0){
									html+="<td class='text-center'>流量</td>";
								}else if(rbfl==1){
									html+="<td class='text-center'>面积</td>";
								}else{
									html+="<td class='text-center'></td>";
								}
								html+="<td class='text-center' title='"+operTime+"'>"+operTime+"</td>";
								html+="<td class='text-center' title='"+recordTime+"'>"+recordTime+"</td>";
								/* html+="<td class='text-center' title='"+readMTime+"'>"+readMTime+"</td>"; */
									html+="<td class='text-center' title='"+rbType+"'>"+rbType+"</td>";
								html+="<td class='text-center'>"+bz+"</td>";
								html+="</tr>";
								}
							  html+="</tbody>"
							  html+="</table>";
							  html+="</div>";
							$("#RbInfo").append(html);
						}

					})
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
		var rbfl=$('#rbfl').val();
		window.open("RbdoExportExcel.action?xqName=" + xqName + "&buildNo="
				+ buildNo + "&cellNo=" + cellNo + "&houseNo=" + houseNo
			+"&recordTime1="+ recordTime1+"&recordTime2="+ recordTime2+"&rbfl="+rbfl);
	}
	
	//导出
	function doExportExcelGz() {
		   var  gzxx = $('#gzxxId').val();
		window.open("RbGzdoExportExcel.action?gzxx=" + gzxx);
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

	户号：<input type="text" size="5px" name="houseNo" id="houseNoId" value="${houseNo}"  />
		<label for="readMTime">选择时间:</label>
		  <input type="text" id="recordTime1" name="recordTime1" class="Wdate" onfocus="WdatePicker();" />
		-<input type="text" id="recordTime2"  name="recordTime2"  class="Wdate" onfocus="WdatePicker();" />	
		选择收费类型：<select id="rbfl">
		<option value="2" >请选择收费方式</option>
		<option value="0" selected="selected">流量</option>
		<option value="1">面积</option>
		</select>
		<input class="btn btn-success" type="button" onclick="searchInfo()" value="搜索" style="background-color:#2B919D;border:1px" >
		<input type="button" value="导出"class="btn btn-success" onclick="doExportExcel()" style="background-color:#2B919D;border:1px"  />
	<!-- 	<input type="button" value="热表结算"class="btn btn-success"  style="background-color:#2B919D;border:1px"  /> -->
		<p>
		<input class="btn btn-success" onclick="CbJc(0)" style="background-color:#2B919D;border:1px" type="button" value="今日抄表用户">
		<input class="btn btn-success" onclick="CbJc(1)" style="background-color:#2B919D;border:1px" type="button" value="今日未抄表用户">
		<label for="Sxx">信息搜索</label> 
		<select name="Sxx" id="SxxId">
		<option value="0">--请选择--</option>
		<option value="4">近一天</option>
		<option value="1">近三天</option>
		<option value="2">近五天</option>
		<option value="3">近一周</option>
		</select>
		<input type="button" class="btn btn-success" value="搜索" style="background-color:#2B919D;border:1px"  onclick="Sel()">
        <label for="gzxx">故障信息搜索</label> 
		<select name="gzxx" id="gzxxId">
		<option value="0">--请选择--</option>
		<option value="正常">正常</option>
		<option value="E2PROM损坏">E2PROM损坏</option>
		<option value="需要更换电池">需要更换电池</option>
		<option value="必须更换电池">必须更换电池</option>
		<option value="进回水温度传感器装反">进回水温度传感器装反</option>
		<option value="流量传感器内流向错误">流量传感器内流向错误</option>
		<option value="超声波发射器硬件错误">超声波发射器硬件错误</option>
		<option value="无有效超声波信息号">无有效超声波信息号</option>
		<option value="空管或者换能器故障">空管或者换能器故障</option>
		<option value="传感器和换能器之间通讯故障">传感器和换能器之间通讯故障</option>
		<option value="未知">未知</option>
		</select>
		<input type="button" class="btn btn-success" value="搜索" style="background-color:#2B919D;border:1px"  onclick="GzSel()">
		<input type="button" value="导出故障信息"class="btn btn-success" onclick="doExportExcelGz()" style="background-color:#2B919D;border:1px"  />
	<div class="dwrapper">
		<table id="fixed_hdr2">
			<thead style="color: white;">
				<tr height="35px">
				<th>用户姓名</th>
				<th>小区名称</th>
				<th>楼栋号</th>
				<th>楼宇号</th>
				<th>单元号</th>
				<th>户号</th>
				<th>住户号</th>
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
				<th>备注</th>
				</tr>
			</thead>
			<tbody id="RbInfo">
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
					<%-- <td title="${rb.yh.bz}">${rb.yh.yhName}</td> --%>
					<td>${rb.yh.xqName}</td>
					<td>${rb.yh.buildNO}</td>
					<td>${rb.yh.rbLyName}</td>
					<td>${rb.yh.cellNO}</td>
					<td>${rb.yh.houseNO}</td>
					<td>${rb.yh.resNum}</td>
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
   					<c:when test="${rb.status=='正常'}">
   					<td>${rb.status}</td>
   					</c:when>
   					<c:otherwise>
   					<td><font color="red">${rb.status}</font></td> 
   					</c:otherwise>
   					</c:choose>
					<c:choose>
					<c:when test="${rb.yh.rbfl==0}">
					<td>流量</td>
					</c:when>
					<c:when test="${rb.yh.rbfl==1}">
					<td>面积</td>
					</c:when>
					<c:otherwise>
					<td></td>
					</c:otherwise>
					</c:choose>
					<td>${rb.operTime}</td>
					<td><fmt:formatDate value="${rb.recordTime}" pattern="yyyy-MM-dd HH:mm:ss" />
					<td>${rb.rbType}</td>
					<td>${rb.yh.bz}</td>
					<%-- <td><fmt:formatDate value="${rb.readMTime}" pattern="yyyy-MM-dd HH:mm:ss" /> --%>
				</tr>
			</c:forEach>
		</table> 
	</div>

</body>
</html>