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
	


	
	
	
</style>
 <script type="text/javascript">



</script>

</head>
<body>

	<div id="increasedis" class="clearfix" style="overflow-x: hidden;height:1000px;">
		

		<div class="mws-panel grid_8 "
			style="width: 98%; padding-left: 12px; margin: 0px 0px 10px 0px; min-width:650px">
			<div class="mws-panel-header">
				<span class="mws-i-24 i-table-1">信息</span>
			</div>
			
			<div id="xincreate_table_body" class="mws-panel-body"

				style="overflow:scroll !important; height: 590px;">
				<table class="mws-table" style="width:150%;">

					<thead>
						<tr>
							<th class="table-th-css"></th>
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
	
	<script>
	var list=window.parent.list;
	var xq=window.parent.xq; 
	var ld=window.parent.ld;
	var dy=window.parent.dy;
	var sztlist = [];
	
	
	/* 小区 */
	if(xq != undefined && ld == undefined && dy == undefined){
		for(var i = 0 ; i < list.length ; i ++){
			if(xq == list[i].xqm){
				sztlist.push(list[i]);
			}
		}
		tbodydis("",sztlist);
		sztlist = [];
	}
	
	/* 楼栋 */
	if(ld != undefined && xq != undefined && dy == undefined){
		for(var i = 0 ; i < list.length ; i ++){
			if(xq == list[i].xqm && ld == list[i].ldh){
				sztlist.push(list[i]);
			}
		}
		tbodydis("",sztlist);
		sztlist = [];
	}
	
	/* 单元 */
	if(dy != undefined && ld != undefined && xq != undefined){
		for(var i = 0 ; i < list.length ; i ++){
			if(xq == list[i].xqm && ld == list[i].ldh && dy == list[i].dyh){
				sztlist.push(list[i]);
			}
		}
		tbodydis("",sztlist);
		sztlist = [];
	}
	//表格写入函数
	 function tbodydis(oldlist,newlist){

	 	var current = 1;
		var xinwordList = [];
		jsArrChange(newlist);
	 	function jsArrChange(json){
			for (var i = 0 ; i < json.length ; i ++) {
				var arr1 = [];
				arr1[0] = json[i].id;
				arr1[1] = json[i].yhbh;
				arr1[2] = json[i].yhxm;
				arr1[3] = json[i].fpdz;
				arr1[4] = json[i].ldh;
				arr1[5] = json[i].dyh;
				arr1[6] = json[i].hh;
				arr1[7] = json[i].sdwd;
				arr1[8] = json[i].snwd;
				if(json[i].ms=="01"){
					arr1[9]="制热"
				}else{
					arr1[9]="制冷"
				}
				
				arr1[10] = json[i].yydl;
				arr1[11] = json[i].syje;
				if(json[i].dw=="03"){
					arr1[12]="高档"
				}
				if(json[i].dw=="02"){
					arr1[12]="中档"
				}
				if(json[i].dw=="01"){
					arr1[12]="低档"
				}
				if(json[i].dw=="00"){
					arr1[12]="停止"
				}
				arr1[13] = json[i].gdtime;
				arr1[14] = json[i].zdtime;
				arr1[15] = json[i].ddtime;
				arr1[16] = json[i].dgdtime;
				arr1[17] = json[i].dzdtime;
				arr1[18] = json[i].dddtime;
				
				arr1[19] = json[i].time;
				arr1[20] = json[i].mj;
				arr1[21] = json[i].lxdh;
				if(json[i].jf=="01"){
					arr1[22]="允许计费"
				}
				if(json[i].jf=="00"){
					arr1[22]="禁止计费"
				}
				
				
				
				if(json[i].kg=="01"){
					arr1[23]="自动运行"
				}
				if(json[i].kg=="00"){
					arr1[23]="强制关闭"
				}
				if(json[i].bj=="00"){
					arr1[24]="正常"
				}
				if(json[i].bj=="01"){
					arr1[24]="开盖"
				}
				if(json[i].bj=="03"){
					arr1[24]="盗热嫌疑"
				}
				if(json[i].bj=="04"){
					arr1[24]="通讯异常"
				}
				arr1[25] = json[i].bz;
				arr1[26] = json[i].xqm;
				arr1[27] = json[i].jj;
				xinwordList.push(arr1);
			};
		}
	 	
	 	function pageInit(currentPage, pagesize) {
	 		current = currentPage; //将当前页存储全局变量
	 		var p = (newlist.length)/pagesize;
	 		pageCount = Math.ceil(p); //一共分多少页
	 		currentNum.innerHTML = currentPage;
	 		num.innerHTML = newlist.length + "条";
	 		pages.innerHTML = pageCount;
	 		var startRow = (currentPage - 1) * pagesize; //开始显示的行
	 		var endRow = currentPage * pagesize - 1; //结束显示的行
	 		var endRow = (endRow > newlist.length) ? newlist.length : endRow; //如果结束行数大于总数目，显示总数目，否则结束行
	 		
	 		var html = "";
	 	/* 	var opt = []; */
	 		for(var i = 0; i < xinwordList.length; i++) {
	 			if(i >= startRow && i <= endRow) { //通过间隔分隔数组
	 				if(i%2 == 1){
	 					html += "<tr class='gradeX odd'>";
	 				}else if(i%2 == 0){
	 					html += "<tr class='gradeX even'>";
	 				}
	 				html += "<td><input type='checkbox' value='' name='check'/></td>";

					for (var j = 0 ; j <xinwordList[i].length ; j ++) {
						if(j==0||j==26||j==27){

	                    	html += "<td style='display:none;'>" + xinwordList[i][j] + "</td>";
	    				}else{

	                        html += "<td>" + xinwordList[i][j] + "</td>"
	    				}
					}
	 			}
	 		}
	 		
	 		xinword_body.innerHTML = html;

	 		var classname = "";
	 		$("table tbody td").hover(function() {
	 			classname = $(this).parent().attr("class");
	 			$(this).parent().removeClass(classname).addClass("blue");
	 			$("table tbody tr").find('td:eq(' + $(this).index() + ')').addClass('blue')
	 		}, function() {
	 			$(this).parent().removeClass("blue").addClass(classname);
	 			$("table tbody tr").find('td:eq(' + $(this).index() + ')').removeClass('blue')
	 		});
	 		
	 	}
	 	
	 	select.onchange = function(ev) {
	 		pageInit(1, this.value);
	 	}
	 	first.onclick = function() {
	 		pageInit(1, select.value);
	 	}
	 	end.onclick = function() {
	 		pageInit(pageCount, select.value);
	 	}

	 	next.onclick = function() {
	 		var curr = current + 1;
	 		if(curr > pageCount) {
	 			return
	 		}
	 		pageInit(curr, select.value);
	 	}

	 	last.onclick = function() {
	 		var curr = current - 1;
	 		if(curr < 1) {
	 			return
	 		}
	 		pageInit(curr, select.value);
	 	}
	 	pageInit(1, 15);

	 }
	
	</script>
	
</body>
</html>