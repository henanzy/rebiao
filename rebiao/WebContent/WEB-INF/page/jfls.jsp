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
<script type="text/javascript" src="../js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../js/layui/layui.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>

<script type="text/javascript" src="../plugins/flot/jquery.flot.min.js"></script>
<script type="text/javascript" src="../js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../js/layui/layui.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>
<link rel="stylesheet" type="text/css" href="../js/layui/css/layui.css" media="screen" />
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


<style>

	/* 固定表头 */
	.table-th-css {
		position: relative !important;
		top: 0;
	}
	
	
	
	/* 新增搜索DIV */
	.search{
		display:block;
		width:99.8%;
		height:40px;
		background-color:#ccc;
		margin:0px auto;
		font-size:12px;
	}
	
	.search p{
		height:30px;
	}
	
	.search p select{
		width:120px;
		height:24px;
		border:none;
		border-radius:6px;
		padding-left:6px;
	}
	
	.search p span{
		color:#333;
		font-size:14px;
		margin-left:20px; 
	}
	.search span input{
		width:62px;
	} 
	/* 搜索按钮 */
	#search_btn,
	#pay_btn,
	#export_btn{
		margin-top:8px;
		margin-left:20px;
		border:none;
		background-color:rgb(60,61,61);
		width:60px;
		height:24px;
		margin-right:6px;
		color:#fff;
		border-radius:4px;
	}
	
	
	/* 缴费弹出框 */
	#pay_word{
		display:none;
		position: fixed;
		left: 0;
	    top:0;
	    right:0;
	    bottom:0;
	    z-index: 100; 
		background-color:rgba(0,0,0,0.6);
	}
	
	
	/* 缴费关闭按钮 */
	#pay_word .close{
		display:block;
		background-color:rgb(193,213,43);
		width:24px;
		height:24px;
		color: #fff;
    	border-radius: 13px;
		position:absolute;
		top:14px;
		right:20px;
		line-height: 24px;
   		text-align: center;
   		font-size: 18px;
	}
	
	#pay_word .close::before {
	    content: "\2716";
	}
	
	/* 缴费弹出框input */
	#pay_word .mws-form-row .pay_input {
		width:200px;
		margin-left:0px;
	}
	#pay_word .mws-form-row input[type="radio"]{
		width:16px;
		height:16px;
	}
	
	/* 缴费弹出框label */
	#pay_word .mws-form-row label{
		width:100px;
	}
	
	/* 缴费弹出框确认按钮 */
	#pay_word #pay_com_btn{
		position:relative;
		top:10px;
		left:38%;
	}
	/* 重置 */
	#pay_word #reset_btn{
		width:70px;
		position:relative;
		top:10px;
		left:42%;
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
	
	
	nav li,
	select{
		width:50px;
		height:24px;
		line-height:24px;
		border-radius:4px;
		background-color:rgba(43,45,49,0.8);
		color:#fff;
		cursor:pointer;
		text-align:center;
	}
	#curpage{
		width:120px;
	}
	
	/* td悬停样式 */
	.blue {
		background: #ccc;
	}
	
	#xincreate_table_body table{
		width:150%;
	}
	
	@media screen and (max-width:1300px){
		.search{
			height:80px;
		}
		.search p{
			width:650px;
			padding-top:8px;
			height:60px;
		}
		
	}
	
	@media screen and (max-width:1100px){
		#xincreate_table_body table{
			width:250%;
		}
	}
	
</style>
 <script type="text/javascript">
 var jfList; 

 $.ajax({
		url : "<%=basePath%>jf/findJfls.action", 
		async : false,
		dataType : "json",
		data : {
			
		},
		success : function(data) {
			
			jfList=data.jfs;
			
		
		}

	});
 
</script>

</head>
<body>

	<div id="increasedis" class="clearfix" style="overflow: hidden;height:900px;">
		
		<div class="mws-panel grid_8 "
			style="width: 98%; padding-left: 12px; margin: 0px 0px 10px 0px; min-width:650px">
			<div class="mws-panel-header">
				<span class="mws-i-24 i-table-1">设备管理</span>
			</div>
			<div class="search">
				<p>
					<span>选择小区：
						<select id="xq">
							<option value="">--小区名称--</option>
						</select>
					</span>
					<span>楼栋号：
						<select id="ldh">
							<option value="">--选择楼栋号--</option>
						</select>
					</span>
					<span>单元号：
						<select id="dyh">
							<option value="" >--选择单元号--</option>
						</select>
					</span>
					<span>户号：
						<input id="hh" type="text" value="" />
					</span>
					<span>缴费类型：
						<select id="jflx">
							<option value="" >--缴费类型--</option>
							<option value="按量" >按量</option>
							<option value="包月" >包月</option>
							<option value="包季" >包季</option>
							<option value="包年" >包年</option>
						</select>
					</span>
                    <span>开始时间：
						<input type="date" id="startTime"  style="width:120px" value="" />
					</span>
					<span>结束时间
						<input type="date" id="endTime" style="width:120px" value="" />
					</span>
					<input id="search_btn" type="submit" value="搜索" />
					
					<!-- <a download="缴费清单" id="wordexcelOut" href="#"> --><input id="export_btn" type="button" value="导出" /></a>
				</p>
			</div>
			<div id="xincreate_table_body" class="mws-panel-body"

				style="overflow:scroll !important; height: 590px;">
				<table class="mws-table" id="word_table" >

					<thead>
						<tr>
							<th class="table-th-css"></th>
							<th class="table-th-css">用户名<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">所属公司<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">小区名称<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">楼栋号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">单元号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">户号<span class="span-up"></span> <span class="span-down"></span></th>							
							<th class="table-th-css">缴费金额<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">剩余金额<span class="span-up"></span> <span class="span-down"></span></th>							
							<th class="table-th-css">已用金额<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">缴费录入<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">缴费类型<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">开始时间<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">结束时间<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">缴费时间<span class="span-up"></span> <span class="span-down"></span></th>
							
							<th class="table-th-css">合计金额<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">业主编号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">联系方式<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">用户面积<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">已用当量<span class="span-up"></span> <span class="span-down"></span></th>
							
						</tr>
					</thead>
					<tbody id="xinword_body">
						
				
					</tbody>
				</table>
			</div>
		</div>
		
		
		<nav style="width:100%;">
            <ul style="width:500px;display:flex;justify-content:space-between;margin:0 auto;" >
            	
                <li id="first">首页</li>
                <li id="last">上一页</li>
                <li id="next">下一页</li>
                <li id="end">尾页</li>   
                <li id="curpage">当前第<span id="currentNum" ></span>页 /共<span id='pages'></span>页</li>
                <li>共<span id="num"></span></li>
                
                    <select name="" id="select" >
                        <option value="10">10</option>
                        <option value="15"  selected = "selected">15</option>
                        <option value="20" >20</option>
                        <option value="25">25</option>
                        <option value="30">30</option>
                    </select>
                     
            </ul>
         </nav>
		

		
		
		
		
		
		
	</div>
	
	
</body>
<script type="text/javascript" src="../js/jfls.js"></script>
</html>