<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 	<script type="text/javascript" src="../js/static/h-ui.admin/js/H-ui.admin.js"></script>
<link href="../css/fixed_table_rc.css" type="text/css" rel="stylesheet"	media="all" />
<link href="../css/bootstrap.css" type="text/css" rel="stylesheet"	/>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script> 

	<script type="text/javascript">

	window.onload = function() {
        window.open("/RbHotPower/RbCon/RbList.action","Conframe");
    }
	</script>
	<script type="text/javascript">
	function Rb(){
		 window.open("/RbHotPower/RbCon/RbList.action","Conframe");
	}
	</script>
</head>
<body>
<br>
<button  onclick="Rb()"  type="button" class="btn btn-success btn-block" style="background-color:#2B919D;border:1px" >缴费统计分析</button>
<button  onclick="Rb()"  type="button" class="btn btn-success btn-block" style="background-color:#2B919D;border:1px" >供热面积分析</button>

</body>
</html>