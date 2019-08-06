<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>



<!-- Required Stylesheets -->
<link rel="stylesheet" type="text/css" href="../css/reset.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="../css/text.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="../css/fonts/ptsans/stylesheet.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/fluid.css"
	media="screen" />

<link rel="stylesheet" type="text/css" href="../css/mws.style.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="../css/icons/icons.css"
	media="screen" />

<!-- Demo and Plugin Stylesheets -->
<link rel="stylesheet" type="text/css" href="../css/demo.css"
	media="screen" />

<link rel="stylesheet" type="text/css"
	href="../plugins/colorpicker/colorpicker.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/jimgareaselect/css/imgareaselect-default.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/fullcalendar/fullcalendar.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/fullcalendar/fullcalendar.print.css" media="print" />
<link rel="stylesheet" type="text/css" href="../plugins/tipsy/tipsy.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/sourcerer/Sourcerer-1.2.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/jgrowl/jquery.jgrowl.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="../plugins/spinner/spinner.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/jui/jquery.ui.css"
	media="screen" />

<!-- Theme Stylesheet -->
<link rel="stylesheet" type="text/css" href="../css/mws.theme.css"
	media="screen" />

<!-- JavaScript Plugins -->

<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="../js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../js/layui/layui.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>
<script type="text/javascript"
	src="../plugins/jimgareaselect/jquery.imgareaselect.min.js"></script>
<script type="text/javascript"
	src="../plugins/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript" src="../plugins/jgrowl/jquery.jgrowl.js"></script>
<script type="text/javascript" src="../plugins/jquery.filestyle.js"></script>
<script type="text/javascript"
	src="../plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="../plugins/jquery.dataTables.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="../plugins/flot/excanvas.min.js"></script>
<![endif]-->
<script type="text/javascript" src="../plugins/flot/jquery.flot.min.js"></script>
<script type="text/javascript"
	src="../plugins/flot/jquery.flot.pie.min.js"></script>
<script type="text/javascript"
	src="../plugins/flot/jquery.flot.stack.min.js"></script>
<script type="text/javascript"
	src="../plugins/flot/jquery.flot.resize.min.js"></script>
<script type="text/javascript"
	src="../plugins/colorpicker/colorpicker.js"></script>
<script type="text/javascript" src="../plugins/tipsy/jquery.tipsy.js"></script>
<script type="text/javascript"
	src="../plugins/sourcerer/Sourcerer-1.2.js"></script>
<script type="text/javascript" src="../plugins/jquery.placeholder.js"></script>
<script type="text/javascript" src="../plugins/jquery.validate.js"></script>
<script type="text/javascript" src="../plugins/jquery.mousewheel.js"></script>
<script type="text/javascript" src="../plugins/spinner/ui.spinner.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>

<script type="text/javascript" src="../js/mws.js"></script>
<script type="text/javascript" src="../js/demo.js"></script>
<script type="text/javascript" src="../js/themer.js"></script>
<script type="text/javascript">

var yhInfo=${yhInfo};/* 用户信息和室内情况 */
var selTelByGd=${selTelByGd};/* 工单记录 */
var findCallByTel=${findCallByTel};/* 电话记录 */

var  telephone=${tel};/* 电话 */
if(telephone==null||telephone==null){
	telephone="";
}
/* alert(yhInfoj);
alert(findCallByTel);
alert(tel);
alert(selTelByGd); */
</script>
<script type="text/javascript">
var yhInfo;
var Tel;
var selTelByGd;
var findCallByTel;
var tel=$('#user_phone').val();
/* 根据地电话搜索 */

function bf(url){
	var url1=url.replace(/\\/g,"/");
	console.log(url) 
	$.ajax({
			url:"<%=basePath%>KfgdCon/geiYinpin.action",
			async:false,
			dataType:"json",
			data:{	
				"url":url,
			},
			success:function(data){
				
			}
			
		});	
}
function selByTel(){
	    tel=$('#user_phone').val();
  			$.ajax({
  				url:"SelLdtpByTel.action",
  				async:false,
  				dataType:"json",
  				data:{	
  					"tel":tel,
  				},
  				success:function(data){
  					yhInfo=data.yhInfo;
  					Tel=data.tel;
  					selTelByGd=data.selTelByGd;
  					findCallByTel=data.findCallByTel;
  				}
  				
  			});	
}

function addGd(){
	var xqNameId=$('#xqNameId').val();
	var buildNoId=$('#buildNoId').val();
	var cellNoId=$('#cellNoId').val();
	var houseNoId=$('#houseNoId').val();
	var telephoneId=$('#telephoneId').val();
	var visConId=$('#visConId').val();
	if(visConId==""){
		return false;
	}
	var tjNameId=$('#tjNameId').val();
	var tjTimeId=$('#tjTimeId').val();
		$.ajax({
			url:"<%=basePath%>KfgdCon/KzaddGd.action",
			type : "POST",
			async:false,
			dataType:"json",
			data:{	
				"xqName":xqNameId,
				"buildNo":buildNoId,
				"cellNo":cellNoId,
				"houseNo":houseNoId,
				"telephone":telephoneId,
				"visCon":visConId,
				"tjName":tjNameId,
				"tjTime":tjTimeId,
			},
			success:function(data){
				var suc=data.suc;
				if(suc==1){
					layer.msg("增加成功!");
				}
			}
			
		});	
}
</script>
<script type="text/javascript" src="../js/kehzl.js"></script>

<style>

	/* 固定表头 */
	.table-th-css {
		position: relative !important;
		top: 0;
	}
	
	/* 电话输入框 */
	.mws-report {
		width: 98% !important;
		min-width: 170px;
		margin: 8px 1%;
		height: 80px;
		float: left;
		cursor: pointer;
		display: block;
		text-decoration: none;
		color: #323232;
	}
	
	/* 用户信息，室内情况input */
	#user_search_body .mws-form-row .user_input,
	#user_search_body .mws-form-row .indoor_input {
		width:300px;
	}
	
	
	/* 用户信息，室内情况label */
	#user_search_body .indoor_inform label,
	#user_search_body .user_inform label{
		width:100px;
	}
	
	/* 用户信息，室内情况背景图片 */
	#user_search_body .user_inform .mws-panel-body,
	#user_search_body .indoor_inform .mws-panel-body{
		background-image: url(../images/background/2.jpg);
	}
	#user_search_body .user_inform .mws-form-inline,
	#user_search_body .indoor_inform .mws-form-inline{
		height:426px;
		background:rgba(255,255,255,0.8);
	}
	
	/* 手机号错误字体 */
	#user_span{
		color:red;
		display:none;
	}
	
	
	/* 新增弹出按钮 */
	.keincrease {
		border:none;
		background-color:rgb(60,61,61);
		width:70px;
		height:30px;
		margin-left:50px;
		color:#fff;
		border-radius:4px;
	}
	
	
	
	
	/* thead排序按钮 */
	.span-up{
        border-style: solid;
        border-width: 0px 5px 5px 5px;
        border-color: transparent transparent black transparent;
        width: 0px;
        height: 0px;
        display: block;
        position: absolute;
        top: 14px;
       	right: 6px;
    }
    
    .span-down{
        border-style: solid;
        border-width: 5px 5px 0px 5px;
        border-color: black transparent transparent transparent;
        width: 0px;
        height: 0px;
        display: block;
        position: absolute;
        top: 20px;
        right: 6px;
    }
    
	
</style>



</head>
<body>

	<div id="" class="clearfix" style="overflow-x: hidden; height: 100%;">
	

		<div style="margin-top: 20px;">
			<!-- <form action="SelLdtpByTel.action" method="post" > -->
				<p class="mws-report" href="#" style="font-size: 14px;">
					<span class="mws-report-icon mws-ic ic-building"></span> 
						<span class="mws-report-content" style="margin-top: 16px;"> 
								<span class="mws-report-title"> 
									电话 <input id="user_phone" type="text" name="tel" placeholder="请输入查询号码" value="" /> 
										<input type="button" onclick="selByTel()" id="user_search" class="mws-button black" value="查询" />
										<span id="user_span"> * 手机号格式错误，请重新输入！</span>
								</span>  
						</span>
				</p>
		<!-- </form>  -->
		</div>
		
		<div style="clear: both;"></div>

		<div id="user_search_body"
			style="width: 100%; margin-top: 20px; display: none;">

			<div class="mws-panel grid_4 user_inform" style="min-width: 600px">
				<div class="mws-panel-header">
					<span class="mws-i-24 i-pencil">用户信息</span>
				</div>
				<div class="mws-panel-body">
					<form class="mws-form">
						<div class="mws-form-inline">
							<div class="mws-form-row" style="height:14px;">
								<label>&emsp;&emsp;用户姓名：</label>

								<div class="mws-form-item large">
									<input type="text" class="mws-textinput user_input" value=""
										readonly="readonly" />
								</div>
							</div>
							
							<div class="mws-form-row" style="height:14px;">
								<label>&emsp;&emsp;小区：</label>

								<div class="mws-form-item large">
									<input type="text" id ="xqNameId" class="mws-textinput user_input" value=""
										readonly="readonly" />
								</div>
							</div>

							<div class="mws-form-row" style="height:14px;">
								<label>&emsp;&emsp;楼栋：</label>
								<div class="mws-form-item large">
									<input type="text" id="buildNoId" class="mws-textinput user_input" value=""
										readonly="readonly" />
								</div>
							</div>

							<div class="mws-form-row" style="height:14px;">
								<label>&emsp;&emsp;单元：</label>
								<div class="mws-form-item large">
									<input type="text" id="cellNoId" class="mws-textinput user_input" value=""
										readonly="readonly" />
								</div>
							</div>

							<div class="mws-form-row" style="height:14px;">
								<label> &emsp;&emsp;户号：</label>
								<div class="mws-form-item large">
									<input type="text" id="houseNoId" class="mws-textinput user_input" value=""
										readonly="readonly" />
								</div>
							</div>

							<div class="mws-form-row" style="height:14px;">
								<label> &emsp;&emsp;面积：</label>
								<div class="mws-form-item large">
									<input type="text" id="heatAreaId" class="mws-textinput user_input" value=""
										readonly="readonly" />
								</div>
							</div>

							<div class="mws-form-row" style="height:14px;">
								<label> &emsp;&emsp;电话：</label>
								<div class="mws-form-item large">
									<input type="text" id="telephoneId" class="mws-textinput user_input" value=""
										readonly="readonly" />
								</div>
							</div>
							<div class="mws-form-row" style="height:60px;">
								<label> &emsp;&emsp;来访内容：</label>
								<div class="mws-form-item large">
									<textarea autofocus="autofocus" id="visConId"
										style="width: 300px; height: 70px; font-size: 13px; color: rgba(65, 65, 55, 0.8);"
										class="mws-textinput user_input" name="question">
									</textarea>

								</div>
							</div>

							<div class="mws-form-row" style="height:14px;">
								<label> &emsp;&emsp;登记人：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput user_input"
										name="regist" value="${UserName}" id="tjNameId"/>
								</div>
							</div>

							<div class="mws-form-row" style="height:14px;margin-bottom:40px;">
								<label> &emsp;&emsp;登记时间：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput user_input" readonly="readonly"
										name="registtime" id="tjTimeId" value="" />
									<input type="button" onclick="addGd()" id="ke_increase_btn" style="margin-left:20px;"
										class="mws-button black" value="新增工单" />
								</div>
							</div>
							
						</div>
						
					</form>
				</div>
			</div>



			<div class="mws-panel grid_4 indoor_inform" style="min-width: 600px">
				<div class="mws-panel-header">
					<span class="mws-i-24 i-pencil">室内情况</span>
				</div>
				<div class="mws-panel-body" style="height:426px;">
					<form class="mws-form">
						<div class="mws-form-inline">
							<div class="mws-form-row">
								<label>&emsp;&emsp;采集器编号：</label>

								<div class="mws-form-item large">
									<input type="text" class="mws-textinput indoor_input" value=""
										readonly="readonly" />
								</div>
							</div>

							<div class="mws-form-row">
								<label>&emsp;&emsp;阀门编号：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput indoor_input" value=""
										readonly="readonly" />
								</div>
							</div>

							<div class="mws-form-row">
								<label>&emsp;&emsp;室内温度：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput indoor_input" value=""
										readonly="readonly" />
								</div>
							</div>

							<div class="mws-form-row">
								<label> &emsp;&emsp;室外温度：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput indoor_input" value=""
										readonly="readonly" />
								</div>
							</div>

							<div class="mws-form-row">
								<label> &emsp;&emsp;管道温度：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput indoor_input" value=""
										readonly="readonly" />
								</div>
							</div>

							<div class="mws-form-row">
								<label> &emsp;&emsp;阀门开度：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput indoor_input" value=""
										readonly="readonly" />
								</div>
							</div>
							<div class="mws-form-row">
								<label>&emsp;&emsp;更新时间：</label>
								<div class="mws-form-item large">
									<input type="text" class="mws-textinput indoor_input" value=""
										readonly="readonly" />
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>


			<div class="mws-panel grid_8 "
				style="width: 48%; float: left; min-width: 600px">
				<div class="mws-panel-header">
					<span class="mws-i-24 i-table-1">来电记录</span>
				</div>
				<div id="kecall_table_body" class="mws-panel-body"
					style="overflow: auto !important; height: 400px;">
					<table class="mws-table">
						<thead>
							<tr>
								<th class="table-th-css">序号<span class="span-up"></span> <span
									class="span-down"></span></th>
								<th class="table-th-css">时间<span class="span-up"></span> <span
									class="span-down"></span></th>
								<th class="table-th-css">电话<span class="span-up"></span> <span
									class="span-down"></span></th>
								<th class="table-th-css">呼入/呼出<span class="span-up"></span>
									<span class="span-down"></span></th>
								<th class="table-th-css">录音<span class="span-up"></span> <span
									class="span-down"></span></th>
							</tr>
						</thead>
						<tbody id="kecall_body">


						</tbody>
					</table>
				</div>
			</div>
			<div class="mws-panel grid_8 "
				style="width: 48%; float: left; min-width: 600px">
				<div class="mws-panel-header">
					<span class="mws-i-24 i-table-1">工单记录</span>
				</div>
				<div id="keword_table_body" class="mws-panel-body"
					style="overflow: auto !important; height: 400px;">
					<table class="mws-table">
						<thead>
							<tr>
								<th class="table-th-css">工单号<span class="span-up"></span> <span
									class="span-down"></span></th>
								<th class="table-th-css">来访内容<span class="span-up"></span>
									<span class="span-down"></span></th>
								<th class="table-th-css">登记人<span class="span-up"></span> <span
									class="span-down"></span></th>
								<th class="table-th-css">登记时间<span class="span-up"></span>
									<span class="span-down"></span></th>
								<th class="table-th-css">工单状态<span class="span-up"></span>
									<span class="span-down"></span></th>
							</tr>
						</thead>
						<tbody id="keword_body">

						</tbody>
					</table>
				</div>
			</div>
			
		</div>
		
		
	</div>

</body>
</html>