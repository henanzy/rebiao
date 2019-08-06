
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>



<!-- Required Stylesheets -->
<link rel="stylesheet" type="text/css" href="../js/layui/css/layui.css" media="screen" />	
<script type="text/javascript" src="../js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../js/layui/layui.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>
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

<script type="text/javascript" src="../js/xitsm.js"></script>
<link rel="stylesheet" type="text/css" href="../css/xitsm.css" media="screen" />

</head>
<script type="text/javascript">
var zskList = ${zskList};


</script>
<body>

	<div id="" class="clearfix" style="overflow-x: hidden;width:96%;height:1000;min-width:1100px;">
		
		
		<div class="system_new">
			<div class="mws-panel grid_8 "
			style="width: 98%; padding-left: 12px; margin: 0px 0px 30px 0px; min-width:500px">
				<div class="mws-panel-header">
					<span class="mws-i-24 i-table-1">系统说明</span>
				</div>
				<div class="all_system_option">
					<input type="checkbox" name="check"/><span>全选</span>
					<input id="system_option_del" class="system_del" type="button" value="删除" />
					<input id="system_option_cr" type="button" value="新增" />
				</div>
				<div id="system_table_body" class="mws-panel-body"
					style="overflow: auto !important; height: 700px;">
					<table class="mws-table">
						<thead>
							<tr>
								<th class="table-th-css"></th>
								<th class="table-th-css">文章标题<span class="span-up"></span> <span class="span-down"></span></th>
								<th class="table-th-css">作者<span class="span-up"></span> <span class="span-down"></span></th>
								<th class="table-th-css">发布时间<span class="span-up"></span> <span class="span-down"></span></th>
								<th class="table-th-css">操作</th>
							</tr>
						</thead>
						<tbody id="system_body">
							
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="system_crea" style="min-width:1000px;overflow-x: hidden;">
			<div class="system_crea_body">
				<span class="close"></span>
				<h5>新增说明</h5>
				<form action="addZsk.action"  method="post">
					<p><label><span>文章标题：</span><input type="text" required="required" autofocus="autofocus" name="title" value="" /></label></p>
					<p><label><span>文章内容：</span><textarea required="required" name="contents"></textarea></label></p>
					<p><label><span>作者：</span><input required="required" type="text" name="author" value="" /></label></p>
					<p><label><span>发布时间：</span><input required="required" type="text" name="tm" value="" /></label></p>
					 <input type="hidden" name="zsktype" value="系统说明"/>
		            <p class="system_crea_p"><input id="system_crea_btn" type="submit" value="提交" /></p>
				
				</form>
			</div>
		</div>
		
		<div class="system_modify" style="min-width:1000px;overflow-x: hidden;">
			<div class="system_modify_body">
				<span class="close"></span>
				<h5>说明修改</h5>
				<form action="updateZsk.action" method="POST">
					<p><label><span>文章标题：</span><input class="system_modify_input" type="text" required="required" autofocus="autofocus" name="title" value="" /></label></p>
					<p><label><span>文章内容：</span><textarea class="system_modify_input" name="contents" required="required"></textarea></label></p>
					<p><label><span>作者：</span><input class="system_modify_input" required="required" type="text" name="author" value="" /></label></p>
					<p><label><span>发布时间：</span><input class="system_modify_input" required="required" readonly="readonly" type="text" name="tm" value="" /></label></p>
					<input type="hidden" name="zsktype" value="系统说明"/>
					<input class="system_modify_input"  readonly="readonly" type="hidden" name="Id" value="" />
					<p class="system_mod_p"><input id="system_mod_btn" type="submit" value="确定修改" /></p>
				</form>
			</div>
		</div>
		
		<div class="wz_look" style="min-width:1000px;overflow-x: hidden;">
			<div class="wz_look_body">
				<span class="close"></span>
					<div>
						<h5 class="wz_look_title"></h5>
						<p>
							作者：<span class="wz_look_autor"></span>
							发布时间：<span class="wz_look_time"></span>
						</p>
					</div>
					<p class="wz_look_content"></p>
					
			</div>
		</div>
		
		
	</div> 
	
	

</body>
</html>