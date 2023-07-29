<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>【JERRY】官方购物网</title>

  </head>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"> 
  	<form action="goods/dange" method="post" name="frm">
  		
  	</form>
  	<script>
  		document.frm.submit();
  	</script>
  </body>
</html>
