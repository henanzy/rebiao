<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>     


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
<!-- <script type="text/javascript" src="../js/jquery-1.9.js"></script> -->

<script type="text/javascript" src="../js/mws.js"></script>
<script type="text/javascript" src="../js/demo.js"></script>
<script type="text/javascript" src="../js/themer.js"></script>
<!-- <script type="text/javascript" src="../js/jquery.ztree.core.js"></script> -->

<script type="text/javascript" src="../js/demo.dashboard.js"></script>


 <script type="text/javascript">


function tongjfx2(){// 
	    window.open("<%=basePath%>KfgdCon/gdtj.action","Conframe");
	} 
function yhxx(){// 热表用户
	    window.open("<%=basePath%>yhInfoCon/findAll.action","Conframe");
	} 
function jzq(){//热表集中器 
	    window.open("<%=basePath%>JzqCon/find.action","Conframe");
	} 

function fp(){// 
	    window.open("<%=basePath%>FpCon/findFp.action","Conframe");
}

function glbxx(){// 
	    window.open("<%=basePath%>glb/findAll.action","Conframe");

	} 
function dj(){
	    window.open("<%=basePath%>DjCon/findDj.action","Conframe");
	} 
function canssz(){// 
	    window.open("<%=basePath%>user/canssz.action","Conframe");
	} 
	/* 知识库 */
function guojfg(){// 
	window.open("<%=basePath%>ZskCon/getQytl.action", "Conframe");
} 
function hangyzs(){// 
	window.open("<%=basePath%>ZskCon/getQytl.action", "Conframe");
} 
function xitsm(){// 
	window.open("<%=basePath%>ZskCon/getQytl.action", "Conframe");
} 
function wentjd(){// 
	window.open("<%=basePath%>ZskCon/getQytl.action", "Conframe");
} 
 	/* 员工定位 */
function shisdw(){// 
	window.open("<%=basePath%>user/shisdw.action","Conframe");
} 
function lisgj(){// 
	window.open("<%=basePath%>user/lisgj.action","Conframe");
} 

	/* 设备管理 */
function sbgl(){// 热表设备管理
	window.open("<%=basePath%>Data/sbgl.action","Conframe");
} 
	
function cggl(){// 
	window.open("<%=basePath%>cg/findAll.action","Conframe");
} 	

function jfgl(){// 
	window.open("<%=basePath%>jf/jfgl.action","Conframe");
}

function jfls(){// 
	window.open("<%=basePath%>jf/jfls.action","Conframe");
} 	


/*日志信息*/
function rzxx(){
	window.open("<%=basePath%>RzCon/find.action","Conframe");	
}
/*备注信息*/
<%-- function rzxx(){
	window.open("<%=basePath%>RzCon/find.action","Conframe");	
} --%>
/*备注信息*/
function bzxx(){//热表用户备注
	window.open("<%=basePath%>user/bzxx.action?bj=01","Conframe");	
}

function sjbb(){
	window.open("<%=basePath%>Data/sjbb.action","Conframe");	
}
/*异常信息*/
function ycxx(){
	window.open("<%=basePath%>YcCon/findyc.action","Conframe");	
}
/* 知识库 */
function qiytl(){// 
    window.open("<%=basePath%>user/qiytl.action?type=企业条例", "Conframe");
} 
function guojfg(){// 
	window.open("<%=basePath%>user/guojfg.action?type=国家法规", "Conframe");
} 
function hangyzs(){// 
	window.open("<%=basePath%>user/hangyzs.action?type=行业知识", "Conframe");
} 
function xitsm(){// 
	window.open("<%=basePath%>user/xitsm.action?type=系统说明", "Conframe");
} 
function wentjd(){// 
	window.open("<%=basePath%>user/wentjd.action?type=问题解答", "Conframe");
} 
 	/* 员工定位 */
function shisdw(){// 
	window.open("<%=basePath%>user/shisdw.action","Conframe");
} 
function lisgj(){// 
	window.open("<%=basePath%>user/lisgj.action","Conframe");
} 
</script>
	 
	<style>
        ul.ac_kf li a{
	        border-radius:6px;
	        cursor:pointer;
        }
        ul.ac_kf li a:hover{
        	background-color:rgba(197,213,43,0.1);
        }
      
    </style>


<body>
  <div id="mws-wrapper">
       <!--  必要的标记，不要删除 -->
           <div id="mws-sidebar-stitch"></div>
           <div id="mws-sidebar-bg"></div>
           <!-- 左边侧栏包装器 -->
            <div id="mws-navigation">
            	<ul>
            <%-- 	<c:if test="${fl=='nhjk'}"> --%>
            	
                    <li class="active">
                    	<a href="#" class="mws-i-24 i-users">信息管理</a>
                          <ul class="ac_kf"> 

                    	        <li><a class="first-a" onclick="yhxx()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;用户信息</a></li>
                    
                    	        <li><a onclick="bzxx()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;用户备注</a></li>
                             	<li><a onclick="jzq()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;集中器信息</a></li>

                        </ul>
                    </li>
                    
                     <li class="active">
                    	<a href="#" class="mws-i-24 i-users">设备管理</a>
                          <ul class="ac_kf"> 

                    	        <li><a onclick="sbgl()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;设备管理</a></li>
                    	        <li><a onclick="cggl()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;层管管理</a></li>
                        	   

                        </ul>
                    </li>
                     <li class="active">
                    	<a href="#" class="mws-i-24 i-users">数据报表</a>
                          <ul class="ac_kf"> 
                    	   <li><a onclick="sjbb()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;数据报表</a></li>
                        </ul>
                    </li>
                     <%--  </c:if>
                      
                  
                     <c:if test="${fl=='czrz'}"> --%>
                     <li class="active">
                    	<a href="#" class="mws-i-24 i-users">日志管理</a>
                          <ul class="ac_kf"> 
                    	   <li><a onclick="rzxx()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;日志信息</a></li>
                        </ul>
                    </li>
                    <%-- </c:if>
                    <c:if test="${fl=='bjgl'}"> --%>
                     <li class="active">
                    	<a href="#" class="mws-i-24 i-users">异常信息</a>
                          <ul class="ac_kf"> 
                    	        <li><a onclick="ycxx()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;异常信息</a></li>
                        </ul>
                    </li>
                    <%-- </c:if>
                    <c:if test="${fl=='jfgl'}"> --%>
					 <!-- <li class="active">
                    	<a href="#" class="mws-i-24 i-cassette">缴费管理</a>
                          <ul class="ac_kf"> 
                    	        <li><a onclick="jfgl()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;缴费管理</a></li>
                    	        <li><a onclick="jfls()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;历史信息</a></li>
                    	 </ul>
                    </li> -->
					<%-- </c:if> --%>
                 <li class="active">
                    	<a href="#" class="mws-i-24 i-address-book-2">知识库</a>
                          <ul class="ac_kf"> 
                    	      <li><a onclick="qiytl()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;企业条例</a></li>
                        	    <li><a onclick="guojfg()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;国家法规</a></li>
                             	<li><a onclick="hangyzs()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;行业知识</a></li>
                             	<li><a onclick="xitsm()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;系统说明</a></li>
                             	<li><a onclick="wentjd()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;问题解答</a></li>
                             	
                        </ul>
                    </li>
                    
                    <li class="active">
                    	<a href="#" class="mws-i-24 i-cassette">员工定位</a>
                          <ul class="ac_kf"> 
                    	        <li><a onclick="shisdw()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;实时位置</a></li>
                    	        <li><a onclick="lisgj()" target="Conframel">&nbsp;&nbsp;&nbsp;&nbsp;历史轨迹</a></li>
                        </ul>
                    </li>
                     
                </ul>
               
            </div>
		
	</div>
	
	    
<script type="text/javascript">
		$(".ac_kf li a").click(function(){
			$(".ac_kf li a").css("cssText","color:#fff !important;");
			$(this).css("cssText","color:#C5D52B !important;");
		});
	
	
</script>
	
</body>
</html>