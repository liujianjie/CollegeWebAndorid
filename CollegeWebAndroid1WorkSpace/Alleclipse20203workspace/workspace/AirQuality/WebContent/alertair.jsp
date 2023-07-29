<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改</title>
</head>
<body>
	<div align="center" style="width: 1200px">
	<h1 align="center">空气质量信息维护界面</h1>
	<form action="${pageContext.request.contextPath }/alertair.do" method="post" name="frm">
	<input type="hidden" id="a_id" name="a_id" value="${air.a_id }"> 
		<p>监测区域:
			<select name="d_id">
				<option value="1" ${air.d_id==1?'selected':'' }>西城区</option>
				<option value="2" ${air.d_id==2?'selected':'' }>东城区</option>
				<option value="3" ${air.d_id==3?'selected':'' }>海定区</option>
				<option value="4" ${air.d_id==4?'selected':'' }>丰台区</option>
				<option value="5" ${air.d_id==5?'selected':'' }>朝阳区</option>
			</select>
		</p>
		<p>
			监测日期:<input type="text" name="a_time" value="${air.a_time }">
		</p>
		<p>
			PM10值:<input type="text" name="a_pm10" value="${air.a_pm10 }">
		</p>
		<p>
			PM2.5值:<input type="text" name="a_pm25" value="${air.a_pm25 }">
		</p>
		<p>
			监测站:<input type="text" name="a_station" value="${air.a_station }">
		</p>
		<p>	最后修改时间:${air.a_latetime }</p>
		<p>
			<input type="submit" value="修改">
			<input type="button" value="删除"  onclick="del()">
			<input type="button" value="返回" onclick="history.back()">
		</p>
	</form>
	</div>
	<script type="text/javascript">
		function del(){
			var id = document.getElementById("a_id").value;
			var action = "${pageContext.request.contextPath }/delair.do?id="+id;
			document.frm.action=action;
			document.frm.submit();
		}
	</script>
</body>
</html>