<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>首页</title>
</head>
<body>
	<h1 align="center">空气质量监测信息库</h1>
	<p align="center">按区域查询
		<select id="selid" >
			<option value="0" ${option==0?'selected':'' }>不限</option>
			<option value="1" ${option==1?'selected':'' }>西城区</option>
			<option value="2" ${option==2?'selected':'' }>东城区</option>
			<option value="3" ${option==3?'selected':'' }>海定区</option>
			<option value="4" ${option==4?'selected':'' }>丰台区</option>
			<option value="5" ${option==5?'selected':'' }>朝阳区</option>
		</select> 
		<input type="button" value="查找" onclick="tjsel()"/>
		<a href="addair.jsp">添加空气质量监测</a>
	</p>
	<table width="80%" align="center">
		<tr align="center">
			<td><b>序号</b></td>
			<td><b>区域</b></td>
			<td><b>监测时间</b></td>
			<td><b>PM10数据</b></td>
			<td><b>PM2.5数据</b></td>
			<td><b>监测站</b></td>
		</tr>
		<c:forEach items="${list }" var="air" varStatus="i">
			<tr align="center">
				<td>${i.index }</td>
				<td>${air.dis.d_name }</td>
				<td>${air.a_time }</td>
				<td>${air.a_pm10 }</td>
				<td>${air.a_pm25 }</td>
				<td>${air.a_station }</td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
		function tjsel(){
			var sel = document.getElementById("selid");
			var index = sel.selectedIndex;
			var val = sel.options[index].value;
			//拿到值去后台查询
			location.href="${pageContext.request.contextPath }/sellistofdid.do?did="+val;
		}
	</script>
</body>
</html>