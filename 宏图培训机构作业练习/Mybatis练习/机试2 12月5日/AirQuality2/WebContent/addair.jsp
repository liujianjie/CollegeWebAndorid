<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加</title>
</head>
<body>
	<h1 align="center">添加空气质量信息</h1>
	<div align="center" style="width: 1200px">
	<form action="${pageContext.request.contextPath }/addair.do" method="post">
		<p>监测区域:
			<select name="d_id">
				<option value="0">请选择</option>
				<option value="1">西城区</option>
				<option value="2">东城区</option>
				<option value="3">海定区</option>
				<option value="4">丰台区</option>
				<option value="5">朝阳区</option>
			</select>
		</p>
		<p>
			监测日期:<input type="text" name="a_time">
		</p>
		<p>
			PM10值:<input type="text" name="a_pm10">
		</p>
		<p>
			PM2.5值:<input type="text" name="a_pm25">
		</p>
		<p>
			监测站:<input type="text" name="a_station">
		</p>
		<p>
			<input type="submit" value="保存">
			<input type="reset" value="重置 ">
			<input type="button" value="取消" onclick="history.back()">
		</p>
	</form>
	</div>
</body>
</html>