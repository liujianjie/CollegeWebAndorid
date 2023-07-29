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
  <!-- border=0去除之间的空隙 -->
  <frameset rows="27%,*" frameborder="yes" border="0" framespacing="0" >
  	<frame src="qiantai_main/top.jsp" scrolling="no" />
  	<frameset cols="25%,*,15%,9%" frameborder="yes" border="0" framespacing="0">
  		<frame src="mold/qtlist" scrolling="no"/>
  		<frame src="goods/selstartshouyegoods" name="main" scrolling="no">
  		<frame src="qiantai_main/leftleft.jsp" scrolling="no">
  		<frame src="qiantai_main/leftleftleft.jsp" scrolling="no">
  	</frameset>
  </frameset>

</html>
