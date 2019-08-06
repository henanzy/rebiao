  <%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- Required Stylesheets -->
<link rel="stylesheet" type="text/css" href="../css/reset.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/text.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/fonts/ptsans/stylesheet.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/fluid.css" media="screen" />

<link rel="stylesheet" type="text/css" href="../css/mws.style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/icons/icons.css" media="screen" />

<!-- Demo and Plugin Stylesheets -->
<link rel="stylesheet" type="text/css" href="../css/demo.css" media="screen" />

<link rel="stylesheet" type="text/css" href="../plugins/colorpicker/colorpicker.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../plugins/jimgareaselect/css/imgareaselect-default.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../plugins/fullcalendar/fullcalendar.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../plugins/fullcalendar/fullcalendar.print.css" media="print" />
<link rel="stylesheet" type="text/css" href="../plugins/tipsy/tipsy.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../plugins/sourcerer/Sourcerer-1.2.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../plugins/jgrowl/jquery.jgrowl.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../plugins/spinner/spinner.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/jui/jquery.ui.css" media="screen" />

<!-- Theme Stylesheet -->
<link rel="stylesheet" type="text/css" href="../css/mws.theme.css" media="screen" />

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



<style>
	*{
		margin:0px;
		padding:0px;
	}
	html,body{
		width:100%;
		height:100%;
	}
	#bgimg{
		width:100%;
		height:100%;
		min-width:1300px;
		min-height:700px;
		background:url(../images/navi/bg_b.jpg) no-repeat;
		background-size:100% 100%;
		position:relative;
	}

	
	.navi_header{
		width:100%;
		height:50px;
		position:absolute;
		top:40px;
		text-align:center;
		
	}
	.navi_header p{
		font-family:Microsoft YaHei;
		font-size:40px;
	 	font-weight:bold; 
		color:#fff;
	}
	
	
	/* div.na_time{
		position:absolute;
		bottom:10px;
		left:45%;
		font-size:20px;
		color:#fff;
	}  */
		
	
	.navi_body{
		width:60%;
		min-width:900px;
		position:absolute;
		top:13%;
		left:20%;
		text-align:center;
	}
	
	.module{
		display:inline-block;
		width:200px;
		height:210px;
		border-radius:10px;
		padding-top:30px;
		text-align:center;
		margin-bottom:0px;
	}
	.module p{
		font-family:Microsoft YaHei;
		font-size:18px;
		font-weight:bold;
		color:rgba(255,255,255,0.7);
		margin-top:20px;
	}
	.module div{
		width:150px;
		height:150px;
		border-radius:30px;
		background-color:rgba(255,255,255,0.9);
		box-shadow: 0 0 20px rgba(0,0,0,0.4);
		margin:0px auto;
	}
	
	.module div img{
		width:70px;
		height:70px;
		margin-top:40px;
	}
	
	#warning{
		width:200px;
		height:50px;
		background-color:rgba(255,255,255,0.7);
		border-radius:10px;
		position:absolute;
		top:-50px;
		left:45%;
		color:#333;
		font-size:20px;
		text-align:center;
		line-height:50px;
	}
	
/* 	宽度 */
@media screen and (max-width:1800px){
		.navi_body{
			top:14%;
			left:20.5%;
		}
		
}
	@media screen and (max-width:1500px){
		.navi_body{
			top:14%;
			left:17%;
		}
		.module{
			width:180px;
		}
		.module div{
			width:120px;
			height:120px;
		}
		.module div img{
			margin-top:22px;
		}
	}
	@media screen and (max-width:1360px){
		.navi_body{
			left:16%;
		}
	}
	
	/* 高度 */
	@media screen and (max-height:800px){
		.navi_body{
			top:25%;
		}  
		.module{
			width:180px;
			height:150px;
			padding-top:4px;
		}
		.module p{
			margin-top:4px;
		}
		.module div{
			width:90px;
			height:90px;
		}
		.module div img{
			width:60px;
			height:60px;
			margin-top:18px;
		}
	}
	
</style>

<script type="text/javascript">(function(window,document,scriptName,wigetname,url,scriptNode,originalNode){initScript=function(){scriptNode=document.createElement("script");originalNode=document.getElementsByTagName("script")[0];scriptNode.src=url;scriptNode.async=1;originalNode.parentNode.insertBefore(scriptNode,originalNode)};window["wpObjectName"]="wp";window["wp"]||(window["wp"]=function(){(window["wp"].arg=window["wp"].arg||[]).push(arguments)});window["wp"].l=+new Date();if(window.attachEvent){window.attachEvent("onload",initScript)}else{window.addEventListener("load",initScript,false)}}(window,document,"script","wp","http://www.4dsmart.cn/static/js/4dsmartwp.js"))</script>  	
<script>wp("init",{
      "flavor": "bubble",
      "positionMode": "absolute",
      "location": [
            "郑州市",
            "57083",
            "410102",
            "101180101"
      ],
      "geolocation": "disabled",
      "position": "top-right",
      "margin": "50px 50px",
      "theme": "black",
      "uuid": "6852381f-8f49-4330-9233-0323e0e9a4e8",
      "hash": "7EF7FDA3BD224E1F1F89DEFD7B812A61"
});		
wp("show");
</script>
</head>
<body>
	<div id="bgimg">
		<!-- <div id="bgcolor"></div> -->
		
		<!-- <div class="na_time">
		</div> -->
		
		<!-- 上面部分 -->
		<div class="navi_header">
			<p>三联热力 ZYIS-H 智慧供热平台</p>
		
		</div>
		
		
		
	   <!--  下面部分 -->
	   
	    <div class="navi_body">
	    
		    	<div class="nyzgl module">
		    		<div>
		    			<img src="../images/navi/nyzgl.png" />
		    		</div>
		    		<p>能源站管理</p>
		    	</div>
		    	
		    	<div class="rbjc module">
		    		<div>
		    			<img src="../images/navi/rbjc.png" />
		    		</div>
		    		<p>热表集抄</p>
		    	</div>
		    	
		    	<div class="nhjk module">
		    		<div>
		    			<img src="../images/navi/nhjk.png" />
		    		</div>
		    		<p>能耗监控</p>
		    	</div>
		    	
		    	<div class="nhfx module">
		    		<div>
		    			<img src="../images/navi/nhfx.png" />
		    		</div>
		    		<p>能耗分析</p>
		    	</div>
		    	
		    	<div class="kfgl module">
		    		<div>
		    			<img src="../images/navi/kfgl.png" />
		    		</div>
		    		<p>客服管理</p>
		    	</div>
		    	
		    	<div class="jfgl module">
		    		<div>
		    			<img src="../images/navi/jfgl.png" />
		    		</div>
		    		<p>缴费管理</p>
		    	</div>
		    	
		    	<div class="czrz module">
		    		<div>
		    			<img src="../images/navi/czrz.png" />
		    		</div>
		    		<p>操作日志</p>
		    	</div>
		    	
		    	<div class="bjgl module">
		    		<div>
		    			<img src="../images/navi/bjgl.png" />
		    		</div>
		    		<p>报警管理</p>
		    	</div>
		    	
		    	<div class="xtsz module">
		    		<div>
		    			<img src="../images/navi/xtsz.png" />
		    		</div>
		    		<p>系统设置</p>
		    	</div>
	    </div>
	    
	    <div id="warning">
	    	<p>模块升级中...!</p>
	    </div>
	
	</div>
	
	<script>
		
		
		/* function Autotime() {
		    setInterval(function () {
		    	var ntime  = getTime();
				$(".na_time").html(ntime);
		    }, 1000);
		}
		Autotime();  */
		
		$(".module").mouseover(function(){
			mouseoverfun(this);
		});
		$(".module").mouseleave(function(){
			mouseleavefun(this);
		});
		
		function mouseoverfun(p){
			$(p).children("div").css({"box-shadow":"0 0 60px rgba(255,255,255,0.9)","background-color":"rgba(0,0,0,0)"});
			$(p).children("p").css("color","#67B5FF");
		}
		function mouseleavefun(p){
			$(p).children("div").css({"box-shadow":"0 0 25px rgba(0,0,0,0.4)","background-color":"rgba(255,255,255,0.9)"});
			$(p).children("p").css("color","rgba(255,255,255,0.7)");
		}
		
		$(".kfgl").click(function(){
			window.location.href = "<%=basePath%>user/home.action";
		});
		$(".nyzgl").click(function(){
			anim();
		});
		$(".rbjc").click(function(){
			anim();
		});
		$(".nhjk").click(function(){
			window.location.href = "<%=basePath%>user/home.action?fl=nhjk";
		});
		$(".nhfx").click(function(){
			anim();
		});
		$(".jfgl").click(function(){
			window.location.href = "<%=basePath%>user/home.action?fl=jfgl";
		});
		$(".czrz").click(function(){
			window.location.href = "<%=basePath%>user/home.action?fl=czrz";
		});
		$(".bjgl").click(function(){
			window.location.href = "<%=basePath%>user/home.action?fl=bjgl";
		});
		$(".xtsz").click(function(){
			anim();
		});
		
		
		function anim(){
			$("#warning").animate({top:'100px'},500).delay(1000).animate({top:'-100px'},500);
		}
		
	
		function getTime() {  
			var nS = new Date();
		    var year=nS.getFullYear(); 
		    var mon = nS.getMonth()+1; 
		    if(mon < 10){
		    	mon = "0"+mon;
		    }
		    var day = nS.getDate(); 
		    if(day < 10){
		    	day = "0"+day;
		    }
		    var hours = nS.getHours(); 
		    if(hours < 10){
		    	hours = "0"+hours;
		    }
		    var minu = nS.getMinutes(); 
		    if(minu < 10){
		    	minu = "0"+minu;
		    }
		    var sec = nS.getSeconds(); 
		    if(sec < 10){
		    	sec = "0"+sec;
		    }
		     
		    return year+'-'+mon+'-'+day+' '+hours+': '+minu+': '+sec; 
		} 
		
		
	</script>
</body>

</html>