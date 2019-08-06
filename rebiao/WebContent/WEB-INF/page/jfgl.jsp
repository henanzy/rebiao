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
	
	
	
	/* 搜索DIV */
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
	
	.dirlist{
		display:inline-block;
		width:22%;
		min-width:200px;
		height:80px;
		line-height:36px;
		margin-left:30px;
		border: 2px solid #2b2d31;
		background-color:rgba(255,255,255,0.6);
		border-radius:8px;
		box-shadow:6px 6px 6px 0 #ccc; 
		color:#2b2d31;
		text-align:center;
		position:relative;
		margin-bottom:20px;
		
	}
	.dirlist .dirlist_img{
		width:45%;
		height:100%;
		float:left;
	}
	.dirlist .dirlist_img img{
		width:55px;
		height:60px;
		margin:5px auto;
	}
	.dirlist_text{
		width:55%;
		height:100%;
		background-color:#eee;
		float:left;
		border-radius:10px;
	}
	.dirlist_text .text-n{
		height:45%;
		color:orange;
		font-size:24px;		
		padding-top:6px;
	}
	.dirlist_text .text{
		height:40%;
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
 var jrbs=0;
 var jfje=0;
 var bzjrbs=0;
 var bzjfje=0;
 var dj;
 var al;var by; var bj; var bn;
 $.ajax({
		url : "<%=basePath%>jf/Search.action", 
		async : false,
		dataType : "json",
		data : {
			
		},
		success : function(data) {
			
			jfList=data.jfs;
			jrbs=data.jrbs;
			jfje=data.jfje;
			bzjrbs=data.bzjrbs;
			bzjfje=data.bzjfje;
		    dj=data.dj;
		    console.log(jfje) 
		    
		    
		    for(var i = 0; i < dj.length; i++) {
				if(dj[i].ssms=="按量"){
					al=dj[i].dj
				}
				if(dj[i].ssms=="包月"){
					by=dj[i].dj
				}
				if(dj[i].ssms=="包季"){
					bj=dj[i].dj
				}
				if(dj[i].ssms=="包年"){
					bn=dj[i].dj
				}
		}
		}

	});

</script>

</head>
<body>
    
	<div id="increasedis" class="clearfix" style="overflow-x: hidden;height:900px;">
		<div class="dirlist">
			<div class="dirlist_img">
				<img src="../images/background/col.png" />
			</div>
			<div class="dirlist_text">
				<p class="today_p text-n"></p>
				<p class="text">今日缴费笔数</p>
			</div>
		</div>
		<div class="dirlist">
			<div class="dirlist_img">
				<img src="../images/background/col1.png" />
			</div>
			<div class="dirlist_text">
				<p class="today_m text-n"></p>
				<p class="text">今日缴费总金额</p>
			</div>
		</div>
		<div class="dirlist">
			<div class="dirlist_img">
				<img src="../images/background/col.png" />
			</div>
			<div class="dirlist_text">
				<p class="week_p text-n"></p>
				<p class="text">本周缴费笔数</p>
			</div>
		</div>
		<div class="dirlist">
			<div class="dirlist_img">
				<img src="../images/background/col1.png" />
			</div>
			<div class="dirlist_text">
				<p class="week_m text-n"></p>
				<p class="text">本周缴费总金额</p>
			</div>
		</div>

		<div class="mws-panel grid_8 "
			style="width: 98%; padding-left: 12px; margin: 0px 0px 10px 0px; min-width:650px">
			<div class="mws-panel-header">
				<span class="mws-i-24 i-table-1">缴费管理</span>
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

					<input id="search_btn" type="submit" value="搜索" />
					<input id="pay_btn" type="submit" value="缴费" />
					<input id="export_btn" type="button" value="导出" /></a>
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
							<th class="table-th-css">更新时间<span class="span-up"></span> <span class="span-down"></span></th>
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
		

		
		
		<div id="pay_word">
			<div class="mws-panel grid_4"
				style="min-width: 500px; margin: 40px 30%;">
				<div class="mws-panel-header" style="width: 682px;margin-left:-52px;">
					<span class="mws-i-24 i-pencil">用户缴费</span> <span class="close"></span>
				</div>
				<div class="mws-panel-body" style="width: 700px;height: 550px;margin-left:-50px;">
					<form id="myform" class="mws-form" action="<%=basePath%>jf/update.action"  method="post">
						<div class="mws-form-inline">
						
						  
							<input type="hidden" class="mws-textinput "
							name="id" value="" />
							

							<div class="mws-form-row" style="height:40px;padding-top:20px;">
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;用户名：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
											name="yhm" value="" />
									</div>
								</div>
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;小区名：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
											name="xqm" value="" />
									</div>
								</div>
								
							</div>
							
							<div class="mws-form-row" style="height:40px;">
								
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;楼栋号：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
											name="ldh" value="" />
									</div>
								</div>
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;单元号：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
											name="dyh" value="" />
									</div>
								</div>
							</div>
							
							<div class="mws-form-row" style="height:40px;">
								
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;户号：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
											name="hh" value="" />
									</div>
								</div>
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;业主编号：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
											name="yzbh" value="" />
									</div>
								</div>
								
							</div>
							
							<div class="mws-form-row" style="height:40px;">
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;联系方式：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
											name="lxfs" value="" />
									</div>
								</div>
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;用户面积：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
											name="yhmj" value="" />
									</div>
								</div>
									
							</div>
							
							<div class="mws-form-row" style="height:40px;">
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="radio" name="type" value="1"/> <span> 按量 </span>
										<input type="radio" name="type" value="0"/> <span> 包月 </span>
										<input type="radio" name="type" value="3"/> <span> 包季 </span>
										<input type="radio" name="type" value="4"/> <span> 包年 </span>
									</div>
								</div>
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;选择月份：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<select  style="width:100px;height:31px;">
											<option value="">-选择月份-</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
										</select>
									</div>
								</div>
							</div>
  							
  							<div class="mws-form-row" style="height:40px;margin-top:-10px;">
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;开始时间：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="date" name="startTime" class="mws-textinput pay_input" value="" />
									</div>
								</div>
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;结束时间：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										
										<input type="date" name="endTime" class="mws-textinput pay_input" value="" max="" />
									</div>
								</div>
									
							</div>
							
							<div class="mws-form-row" style="height:40px;">
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;供热时间：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
												name="grsj" value="" />
									</div>
								</div>
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;预交金额：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
											name="jfje"  id="jfje" value="" />
									</div>
								</div>
									
							</div>
							
							<div class="mws-form-row" style="height:40px;">
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;剩余金额：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
												name="syje" value="" />
									</div>
								</div>
								<div style="display:inline-block;width:320px;">
									<label >&emsp;&emsp;合计金额：</label>
	
									<div class="mws-form-item large" style="display:inline-block;margin-left:0px;">
										<input type="text" class="mws-textinput pay_input" readonly="readonly"
											name="hjje" value="" />
									</div>
								</div>
									
							</div>
							
							
  							
						</div>
						<input type="button" id="pay_com_btn"
							class="mws-button black" onclick="jf()" value="确认缴费" />
						<input type="button" id="reset_btn" class="mws-button black" value="重置" />
					</form>
				</div>
			</div>
		</div>
		
		
		
	</div>
	
	
</body>
<script type="text/javascript" src="../js/jfgl.js"></script>
</html>