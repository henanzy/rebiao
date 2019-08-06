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


<script type="text/javascript" src="../js/sjbb.js"></script>

<!-- 侧边树状图 -->
<link rel="stylesheet" type="text/css" href="../css/treecss/jquery.treemenu.css" />
<script type="text/javascript" src="../js/treejs/jquery.treemenu.js"></script>


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
	
#demo_menu2 {
	width: 36px;
	height: 32px;
	position: fixed;
	top: 0;
	right: 0px;
	background-color: #2B2D31;
	border-radius: 4px;
	z-index: 999;
}

#demo_menu2 img {
	display: block;
	width: 28px;
	height: 22px;
	margin: 5px auto;
}

#demo_menu3 {
	display: none; 
	width : 150px;
	height: 500px;
	border-radius:10px;
	background-color: #444;
	position: absolute;
	top: 0px;
	right: 0px;
	z-index: 999;
}

.tree {
	color: #46CFB0;
	width: 140px;
	margin: 10px auto;
}

.tree li, .tree li>a, .tree li>span {
	padding: 4pt;
	border-radius: 4px;
}

.tree li a {
	color: #46CFB0;
	text-decoration: none;
	line-height: 20pt;
	border-radius: 4px;
}

.tree li a:hover {
	background-color: #34BC9D;
	color: #fff;
}

.active {
	background-color: #34495E;
	color: white;
}

.active a {
	color: #fff;
}

.tree li a.active:hover {
	background-color: #34BC9D;
}
	
.xqname,.ldname,.dyname{
	background:url("../images/background/cir.png") no-repeat left center;
}

.xqname:hover,.ldname:hover,.dyname:hover{
	background:url("../images/background/cirf.png") no-repeat left center;
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
 var list; 


 $.ajax({
		url : "<%=basePath%>Data/searchInfo.action", 
		async : false,
		dataType : "json",
		data : {
			
		},
		success : function(data) {
			
			list=data.list;
			
		   
		}

	});
 
</script>

</head>
<body>

	<div id="increasedis" class="clearfix" style="overflow: hidden;height:1000px;">
		

		<div id="demo_menu3">
			<ul class="tree">

			</ul>
		</div>

		<div class="mws-panel grid_8 "
			style="width: 98%; padding-left: 12px; margin: 0px 0px 10px 0px; min-width:650px">
			<div class="mws-panel-header">
				<span class="mws-i-24 i-table-1" style="display:inline">设备管理</span>&nbsp; &nbsp; &nbsp;
				<span id="xqspan" style="display:inline" ></span>
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
					<span>开始时间：
						<input type="date" id="startTime"  style="width:120px" value="" />
					</span>
					<span>结束时间
						<input type="date" id="endTime" style="width:120px" value="" />
					</span>
					
										
					
					

					<input id="search_btn" type="submit" value="搜索" />
					
				</p>
				
			</div>
			<div id="xincreate_table_body" class="mws-panel-body"

				style="overflow:scroll !important; height: 590px;">
				<table class="mws-table" style="width:150%;">

					<thead>
						<tr>
							
							<th class="table-th-css">用户编号<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">用户姓名<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">风盘地址</th>
							<th class="table-th-css">楼栋<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">单元<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">户号<span class="span-up"></span> <span class="span-down"></span></th>							
							<th class="table-th-css">设定温度<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">出风温度<span class="span-up"></span> <span class="span-down"></span></th>							
							<th class="table-th-css">模式<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">已用当量<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">剩余费用<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">档位<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">制冷高档<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">制冷中档<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">制冷低档<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">制热高档<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">制热中档<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">制热低档<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">采集时间<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">用户面积<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">用户电话<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">计费状态<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">运行状态<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">报警信息<span class="span-up"></span> <span class="span-down"></span></th>
							<th class="table-th-css">备注<span class="span-up"></span> <span class="span-down"></span></th>
							
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
	
	<script type="text/javascript">

		
		
		
		//* /侧面树图
		 var xqlilst = [];
		 for(var i = 0 ; i < list.length ; i ++){
			 if(xqlilst.indexOf(list[i].xqm) == -1){
				 xqlilst.push(list[i].xqm);
			 }
		 }
		 for(var j = 0; j < xqlilst.length; j++) {
				$(".tree").append("<li class='xq xqli"+j+"'><a class='xqname' href='#about'>&nbsp;&nbsp;"+xqlilst[j]+"</a></li>");
		}
		

		 var ldlist = [];
		 var ldl = [];
		 for(var x = 0 ; x < xqlilst.length ; x ++){
			 for(var i = 0 ; i < list.length ; i ++){
				 if( xqlilst[x] == list[i].xqm && ldl.indexOf(list[i].ldh) == -1){
					 ldl.push(list[i].ldh);
				 }
			 }
			 ldlist.push(ldl);
			 ldl = [];
		 }
		 
		 for(var j = 0; j < ldlist.length; j++) {
			 $(".xqli"+j).append("<ul></ul>");
			 for(var i = 0; i < ldlist[j].length; i++){
				 $(".xqli"+j).children("ul").append("<li class='ld'><a class='ldname' href='#'>&nbsp;&nbsp;&nbsp;"+ldlist[j][i]+"</a></li>");
			 }
		 } 
		
		 var dylist = [];
		 var ldlic = $(".ld");
		 $(".ld").each(function(i){
			$(this).addClass("ldli"+i);
			 
		 });
		 for(var y = 0 ; y < ldlic.length ; y ++){
			 var xqlddy = [];
			 var aldhtml = $(".ldli"+y).children("a.ldname").html();
			 aldhtml = aldhtml.replace(/&nbsp;/ig, "");
			 var axqhtml = $(".ldli"+y).parent().parent().children("a.xqname").html();
			 axqhtml = axqhtml.replace(/&nbsp;/ig, "");
			 for(var i = 0 ; i < list.length ;i ++){
				 if(axqhtml == list[i].xqm && aldhtml == list[i].ldh && xqlddy.indexOf(list[i].dyh)){
					 xqlddy.push(list[i].dyh);
				 }
			 }
			 if(xqlddy.length > 0){
				 $(".ldli"+y).append("<ul></ul>"); 
				 for(var a = 0 ; a < xqlddy.length ;a ++){
					 $(".ldli"+y).children("ul").append("<li class='dy'><a class='dyname' href='#job1'>&nbsp;&nbsp;&nbsp;&nbsp;"+xqlddy[a]+"</a></li>");
				 }
			 }
			
		 } 
		
		
		 
		
		$("#demo_menu2").mouseenter(function() {
			$("#demo_menu3").fadeIn(500);
		});
		
		$("#demo_menu3").mouseleave(function(){
			$("#demo_menu3").fadeOut(500);
		});
	        
		$(".tree").treemenu({
			delay: 300
		}).openActive();
		 
	        
	        
	</script>
	
</body>
</html>