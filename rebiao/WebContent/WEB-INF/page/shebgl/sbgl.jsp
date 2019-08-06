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


<script type="text/javascript" src="../js/sbgl.js"></script>



<style>

	/* 固定表头 */
	.table-th-css {
		position: relative !important;
		top: 0;
	}
	
	
	
	/* 搜索DIV */
	.search{
		display:block;
		width:99.8%;
		height:70px;
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
	#search_status_btn{
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
	
	/* 封盘按钮 */
	#operation_one_btn,
	#operation_all_btn{
		margin-top:8px;
		margin-left:20px;
		border:none;
		background-color:rgb(60,61,61);
		width:100px;
		height:24px;
		margin-right:6px;
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
	


	@media screen and (max-width:950px){
		.search{
			height:140px;
		}
		.search p{
			height:60px;
		}
	}
	
	
	
</style>
 <script type="text/javascript">
<%-- var YhList;



$.ajax({
		url : "<%=basePath%>Data/dataSbgl.action", 
		async : false,
		dataType : "json",
		data : {
			
		},
		success : function(data) {
			
			YhList=data.YhList;
			
		   
		}

	});
 --%>
</script>

</head>
<body>

	<div id="increasedis" class="clearfix" style="overflow-x: hidden;height:1000px;">
		
		<div class="mws-panel grid_8 "
			style="width: 98%; padding-left: 12px; margin: 0px 0px 10px 0px; min-width:650px">
			<div class="mws-panel-header">
				<span style="display:inline" class="mws-i-24 i-table-1">设备管理</span>&nbsp; &nbsp; &nbsp;<span id="xqspan" style="display:inline" ></span>
			</div>
			<p>
			<div class="search">
				<span style="font-size:14px;margin-left:20px;">小区名称  </span>
					<select id="xqm" >
                       	<option>--请选择小区--</option>
                       	<option>和四</option>
                       	<option>和五</option>
                       	<option>涧河小区</option>
                       	<option>交警队</option>
                       	<option>金盾小区</option>
                       	<option>联通家苑</option>
                       	<option>岭东小区</option>
                       	<option>三里桥小区</option>
                       	<option>市政小区</option>
                       	<option>舒北小区</option>
                       	<option>舒南小区</option>
                       	<option>文明路东区</option>
                       	<option>文明路南区</option>
                       	<option>文明路西区</option>
                       	<option>邮政小区</option>
                    </select>
                   
                    <span style="font-size:14px;margin-left:10px;">楼栋名称   </span>
					<select name="" id="xqm" >
                       	<option>--请选择楼栋--</option>
                       	<option>--1--</option>
                       	<option>--2--</option>
                       	<option>--3--</option>
                       	<option>--4--</option>
                       	<option>--5--</option>
                    </select>
                    <span style="font-size:14px;margin-left:10px;">单元号  </span>
					<select name="" id="xqm" >
                       	<option>--请选择单元--</option>
                       	<option>--1--</option>
                       	<option>--2--</option>
                       	<option>--3--</option>
                       	<option>--4--</option>
                       	<option>--5--</option>
                    </select>
                    	<input id="search_status_btn" type="submit" value="搜索" />
				<p>
					<span>选择开关：
						<select id="kg">
							<option value="FF">--选择开关--</option>
							<option value="01">自动运行</option>
							<option value="00">强制关闭</option>
						</select>
					</span>
					<span>选择是否计费：
						<select id="jf">
							<option value="FF">--是否计费--</option>
							<option value="01">允许计费</option>
							<option value="00">禁止计费</option>
						</select>
					</span>
					<span>选择季节：
						<select id="jj">
							<option value="FF">--选择季节--</option>
							<option value="00">夏季</option>
							<option value="01">冬季</option>
						</select>
					</span>
				
					<input id="search_status_btn" type="submit" style="size: 10px" value="读取热表" />

				</p>
			</div>
			<div id="xincreate_table_body" class="mws-panel-body"

				style="overflow:scroll !important; height: 590px;">
				<table class="mws-table" style="width:150%;">

					<thead>
						<tr>
							<th class="table-th-css"></th>
							<th class="table-th-css">用户姓名<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">小区名称<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">楼栋号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">单元号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">户号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">热表地址<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">累计热量<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">瞬时热量<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">累计流量<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">瞬时流量<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">进水温度<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">回水温度<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">温差<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">收费类型<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">仪表状态<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">工作时间<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">热表类型<span class="span-up"></span> <span class="span-down"></span></th>
							
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
</html>