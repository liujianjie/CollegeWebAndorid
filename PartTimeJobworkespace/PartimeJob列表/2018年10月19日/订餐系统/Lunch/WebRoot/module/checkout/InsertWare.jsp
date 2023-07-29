<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core"	prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insertWare.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		$(document).reday(function(){
			$("#addBtn").click(function(){
				$.ajax({
					url:"${path}/library_selectW.action",
					data:$("#form").serialize(),
					type:"post",
					dataType:"json",
					success:function(data){
		                  		if(data=='true'){
		                     		alert(data.message);
		                     		window.location.href="${path}/library_insertWare.action";
		                  	}
		               }
				});
			});
		});
	</script>
  </head>
  
  <body>
    <form id="form" method="post">
    	<div class="form-group">
			出库人<input value="${oper.emp_user }"/>
		</div>
    	<input type="button" id="addBtn"value="保存"/>
    </form>
  </body>
</html>
