
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>实时位置</title>



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

<link rel="stylesheet" href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css" />
<style>
	* {
	padding: 0px;
	border: 0px;
	margin: 0px;
}

ul li {
	list-style: none;
}

.dirlist_line {
	width: 100%;
	height: 36px;
	line-height: 36px;
	border-bottom: 2px solid #2b2d31;
	font-size: 16px;
	color: #2b2d31;
	position: relative;
	margin-bottom: 30px;
}


#maptext{
	width:220px;
	padding:10px;
	background-color:rgba(0,0,0,0.6);
	border-radius:10px;
	box-shadow:4px 4px 4px 4px rgba(0,0,0,0.3);
	font-size:14px;
    font-weight: bold;
	color:#fff;
    text-align:center;
	position:absolute;
	top:100px;
	right:100px;
}
#maptext p{
	height:26px;
	line-height:26px;
}
#maptext .mapnum{
	display:inline-block;
	width:20px;
	height:20px;
	background-color:#99ccff;
	margin-right:4px;
}


    #container {
      width: 100%;
      height: 863px;
      border-radius:20px;
    }
	.amap-icon img{
        width: 25px;
        height: 34px;
    }
  </style>
</head>

<body>

	<div id="" class="clearfix" style="overflow-x: hidden;width:96%;height:1000;min-width:1100px;">
		<div class="dirlist_line">
		员工定位 / 实时位置
		</div>
		
		<div id="container"></div>
		
		<!-- <div id="maptext">
			<p><span class="mapnum">1</span><span class="mappeo">张三	2019-04-28 15:12:34</span></p>
			<p><span class="mapnum">2</span><span class="mappeo">张三	2019-04-28 15:12:34</span></p>
			<p><span class="mapnum">3</span><span class="mappeo">张三	2019-04-28 15:12:34</span></p>
		</div> -->
		
	</div> 
	
<script src="https://webapi.amap.com/maps?v=1.4.14&key=ef9a51f031e725d524e057c1e62b103f"></script>
  <script src="https://a.amap.com/jsapi_demos/static/demo-center/js/demoutils.js"></script>
 
<script type="text/javascript" src="../js/shisdw.js"></script>
</body>
</html>