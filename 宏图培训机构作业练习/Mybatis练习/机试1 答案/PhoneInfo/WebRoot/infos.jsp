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
    
    <title>My JSP 'infos.jsp' starting page</title>
    
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
    <h1 align="center" style="margin-top: 80px;">
			手机资讯
		</h1>
		
		<table align="center" width="70%" >
			<tr align="center">
				<th class="title">
					序号
				</th>
				<th class="title" align="center">
					标题
				</th>
				<th class="title" align="center">
					回复/查看
				</th>
				<th class="title" align="center">
					发表时间
				</th>
				<th class="title" align="center">
					最新回复
				</th>
			</tr>
			<s:iterator id="info" value="%{infos}" status="ind">
			<tr>
				<td> <s:property value="%{#ind.count}"/> </td>
				<td> <a href="torep.action?infoId=<s:property value='%{#info.id}'/>"><s:property value="%{#info.title}"/></a> </td>
				<td> <s:property value="%{#info.replyCount}"/>/<s:property value="%{#info.viewCount}"/> </td>
				<td> <s:date name="%{#info.reportTime}" format="yyyy-MM-dd HH:mm:ss"/> </td>
				<td> <s:date name="%{#info.lastposttime}" format="yyyy-MM-dd HH:mm:ss"/> </td>
			</tr>
			</s:iterator>
			</table>
  </body>
</html>
