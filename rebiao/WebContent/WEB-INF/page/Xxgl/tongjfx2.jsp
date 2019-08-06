
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

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

<script type="text/javascript" src="../plugins/jimgareaselect/jquery.imgareaselect.min.js"></script>
<script type="text/javascript" src="../plugins/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript" src="../plugins/jgrowl/jquery.jgrowl.js"></script>
<script type="text/javascript" src="../plugins/jquery.filestyle.js"></script>
<script type="text/javascript" src="../plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="../plugins/jquery.dataTables.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="../plugins/flot/excanvas.min.js"></script>
<![endif]-->
<script type="text/javascript" src="../plugins/flot/jquery.flot.min.js"></script>
<script type="text/javascript" src="../plugins/flot/jquery.flot.time.min.js"></script>
<script type="text/javascript" src="../plugins/flot/jquery.flot.pie.min.js"></script>
<script type="text/javascript" src="../plugins/flot/jquery.flot.stack.min.js"></script>
<script type="text/javascript" src="../plugins/flot/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="../plugins/colorpicker/colorpicker.js"></script>
<script type="text/javascript" src="../plugins/tipsy/jquery.tipsy.js"></script>
<script type="text/javascript" src="../plugins/sourcerer/Sourcerer-1.2.js"></script>
<script type="text/javascript" src="../plugins/jquery.placeholder.js"></script>
<script type="text/javascript" src="../plugins/jquery.validate.js"></script>
<script type="text/javascript" src="../plugins/jquery.mousewheel.js"></script>
<script type="text/javascript" src="../plugins/spinner/ui.spinner.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>

<script type="text/javascript" src="../js/mws.js"></script>
<script type="text/javascript" src="../js/demo.js"></script>
<script type="text/javascript" src="../js/themer.js"></script>

<!-- flot图形总图输入 -->
<!-- <script type="text/javascript" src="../js/demo.charts.js"></script> -->
<script type="text/javascript" src="../js/tongjfx2.js"></script>
<!-- flot图形输入 -->

<style>

	/* 固定表头 */
	.table-th-css {
		position: relative !important;
		top: 0;
	}
	
	
	/* 电话呼入呼出统计报表，各种状态工单统计表搜索div */
	.call-search,
	.word-search{
		display:block;
		width:99.8%;
		height:40px;
		background-color:#ccc;
		margin:0px auto;
		font-size:12px;
	}
	
	.call-search p,
	.word-search p{
		line-height:40px;
	}
	
	.call-search p input,
	.word-search p input{
		height:18px;
		width:120px;
		border:none;
		border-radius:4px;
		padding-left:4px;
	}
	
	/* 搜索开始结束时间 */
	.call_time,
	.word_time{
		margin-left:20px;
	}
	
	/* 搜索状态 */
	.call_type,
	.word_type{
		margin-left:30px
	}
	.call_type select,
	.word_type select{
		width:100px;
		height:18px;
		border:none;
		border-radius:4px;
		padding-left:6px;
	}
	
	/* 搜索导出框 */
	p ._btn input{
		width:50px;
		height:18px;
		background-color:#fff;
		margin-left:30px
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

<script type="text/javascript">
	$(document).ready(function() {
		
	});
</script>

</head>
 <script type="text/javascript">
var xinwordListj = ${xinwordList};
var TjMap = ${TjMap};

var djCountJson = ${djCountJson};
var wcCountJson = ${wcCountJson};
var callCountJson = ${callCountJson};
var findCallJson = ${findCallJson};

var TjMap1 = ${TjMap1};


</script>
<body>

	<div id="" class="clearfix" style="overflow-x: hidden;">
	
		
		<div style="margin-top:20px">
			<div class="mws-panel grid_8"
				style="width:48%;min-width: 500px;">
				<div class="mws-panel-header">
					<span class="mws-i-24 i-graph">近7日每日电话呼入数量曲线图</span>
				</div>
				<div class="mws-panel-body">
					<div class="mws-panel-content">
						<div id="iphone-call" style="width: 100%; height: 300px;"></div>
					</div>
				</div>
			</div>
	
	
			<div class="mws-panel grid_8" style="width:48%;min-width: 500px">
				<div class="mws-panel-header">
					<span class="mws-i-24 i-bar-graph">近7日每日工单提交量及完成量情况</span>
				</div>
				<div class="mws-panel-body">
					<div class="mws-panel-content">
						<div id="wordorder-completed" style="width: 100%; height: 300px;"></div>
					</div>
				</div>
			</div>
	
			<div class="mws-panel grid_4" style="width: 48%; min-width: 450px">
				<div class="mws-panel-header">
					<span class="mws-i-24 i-chart">全部工单状态占比饼状图</span>
				</div>
				<div class="mws-panel-body">
					<div class="mws-panel-content">
						<div id="all-word-status" style="width: 400px; height: 300px;"></div>
					</div>
				</div>
			</div>
		</div>



		<div class="mws-panel grid_4" style="width: 48%; min-width: 450px">
			<div class="mws-panel-header">
				<span class="mws-i-24 i-chart">逾期工单状态占比饼状图</span>
			</div>
			<div class="mws-panel-body">
				<div class="mws-panel-content">
					<div id="late-work" style="width: 400px; height: 300px;"></div>
				</div>
			</div>
		</div>


		<div class="mws-panel grid_8 "
			style="width: 98%;padding-left:14px; margin: 0px 0px 30px 0px; min-width:800px">
			<div class="mws-panel-header">
				<span class="mws-i-24 i-table-1">电话呼入呼出统计报表</span>
			</div>
			<div class="call-search">
				<p>
					<span class="call_time">开始时间：<input type="date" name="start_time" value="2019-02-16" /> — 结束时间：<input type="date" name="end_time" value="" max="" /></span>
					<span class="call_type">类型：
						<select>
							<option value="all">全部</option>
							<option value="in">呼入</option>
							<option value="out">呼出</option>
						</select>
					</span>
					<span class="_btn"><input id="call_search_btn" type="submit" value="搜索" /></span>
					<span class="_btn">
						<a download="电话呼入呼出统计报表" id="callexcelOut" href="#"><input id="call_export_btn" type="button" value="导出" /></a>
					</span>
				</p>
			</div>
			<div id="tongcall_table_body" class="mws-panel-body"
				style="overflow: auto !important; height: 400px;">
				<table class="mws-table" id="tongcall_table">
					<thead>
						<tr>
							<th class="table-th-css">序号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">时间<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">电话<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">呼入/呼出<span class="span-up"></span> <span class="span-down"></span></th>
						</tr>
					</thead>
					<tbody id="tongcall_body">
						
					</tbody>
				</table>
			</div>
		</div>



		<div class="mws-panel grid_8 "
			style="width: 98%;min-width: 800px">
			<div class="mws-panel-header">
				<span class="mws-i-24 i-table-1">各种状态工单统计表</span>
			</div>
			<div class="word-search">
				<p>
					<span class="word_time">开始时间：<input type="date" name="start_word_time" value="2019-02-16" /> — 结束时间：<input type="date" name="end_word_time" value="" max="" /></span>
					<span class="word_type">类型：
						<select>
							<option value="全部">全部</option>
							<option value="逾期工单">逾期工单</option>
							<option value="未审核">未审核</option>
							<option value="审核通过">审核通过</option>
							<option value="回退修改">回退修改</option>
							<option value="作废">作废</option>
							<option value="已接单">已接单</option>
							<option value="已处理">已处理</option>
							<option value="已回访">已回访</option>
						</select>
					</span>
					<span class="_btn"><input id="word_search_btn" type="submit" value="搜索" /></span>
					<span class="_btn">
						<a download="各种状态工单统计表" id="wordexcelOut" href="#"><input id="word_export_btn" type="button" value="导出" /></a>
					</span>
				</p>
			</div>
			<div id="tongword_table_body" class="mws-panel-body"
				style="overflow: auto !important; height: 400px;">
				<table class="mws-table" id="tongword_table">
					<thead>
						<tr>
							<th class="table-th-css">工单号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">来访电话<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">用户姓名<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">小区<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">楼栋<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">单元<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">户号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">来访内容<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">登记人<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">登记时间<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">工单状态<span class="span-up"></span> <span class="span-down"></span></th>
						</tr>
					</thead>
					<tbody id="tongword_body">
						
						
					</tbody>
				</table>
			</div>
		</div>




	</div>

</body>
</html>