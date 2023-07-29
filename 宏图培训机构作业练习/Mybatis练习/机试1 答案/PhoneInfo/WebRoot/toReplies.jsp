<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'toReplies.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1><s:property value="%{info.title}"/> </h1>
    <p>发表于：<s:date name="info.reportTime" format="yyyy-MM-dd hh:mm:ss"/> </p>
    <p><s:property value="%{info.content}"/></p>
    <h2>读者回应：</h2>
    <s:iterator id="rep" value="%{info.replieies}">
    <div>
    	<p>发表于：<s:date name="%{#rep.replytime}" format="yyyy-MM-dd hh:mm:ss"/></p>
    	<p><s:property value="%{#rep.content}"/> </p>
    </div>
    </s:iterator>
    
    <p>快速回复(200字以内)：</p>
    <s:form action="addRep.action" method="post">
    <s:hidden name="replies.infoId" value="%{info.id}"/>
    <s:textarea name="replies.content"></s:textarea>
    <s:submit value="提交"/><a href="infos.action">返回首页</a>
    </s:form>
  </body>
</html>
