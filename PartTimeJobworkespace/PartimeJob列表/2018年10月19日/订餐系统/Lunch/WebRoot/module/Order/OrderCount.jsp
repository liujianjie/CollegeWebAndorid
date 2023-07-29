<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'OrderCount.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="${path }/resource/css/bootstrap.min.css">
	
<style>
#tab td{	
	text-align:center;
	vertical-align:middle;
}

</style>
<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${path }/resource/js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>

  </head>
  
  <body>
  <div align="center">
  	<h1 center="center">订单统计</h1>
  	<form action="${path }/c_findAll.action" method="post">
  		起始时间&nbsp;&nbsp;<input type="text" name="date1"class="form-control" style="width:200px;display:inline;" placeholder="请输入时间" onClick="WdatePicker({Date:'%y-%M-%d'})"  value="${date1 }"/>
  		<span width="40%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
  		截止时间&nbsp;&nbsp;<input type="text" name="date2"class="form-control" style="width:200px;display:inline;" placeholder="请输入时间" onClick="WdatePicker({Date:'%y-%M-%d'})" value="${date2 }"/>
  		<select name=" date3" class="form-control" style="width:200px;display:inline;">
  			<option value="" <c:if test="${empty date3}"> selected='selected'</c:if>>所有</option>
  			<option value="1" <c:if test="${date3==1}"> selected='selected'</c:if> > 最近一天</option>
  			<option value="30" <c:if test="${date3==30 }"> selected='selected'</c:if>>最近一月</option>
  		</select>
  		<input type="submit" class="btn btn-info" value="查询"/>
  	</form>
  	</div>
  	<h1></h1>
  	<table class="table table-bordered table-hover table-striped" id="tab">
  		<tr><td rowspan="2" >日期</td><td colspan="3">线上</td><td colspan="2">现场</td><td rowspan="2">全部完成</td><td rowspan="2">总收入</td></tr>
  		<tr><td>未完成</td><td>已取消</td><td>完成</td><td>未完成</td><td>完成</td></tr>
  		<c:forEach items="${list1 }" var="map">
  			<tr>
  				<td><c:if test="${empty map.date}">0</c:if>${map.date }</td>
  				<td><c:if test="${empty map.s5 }">0</c:if> ${map.s5 }</td>
  				<td><c:if test="${empty map.s4 }">0</c:if>${map.s4 }</td>
  				<td><c:if test="${empty map.s1 }">0</c:if>${map.s1 }</td>
  				<td><c:if test="${empty map.s6 }">0</c:if>${map.s6 }</td>
  				<td><c:if test="${empty map.s2 }">0</c:if>${map.s2 }</td>
  				<td><c:if test="${empty map.s3 }">0</c:if>${map.s3 }</td>
  				<td><c:if test="${empty map.money }">0</c:if>${map.money }</td>
  			</tr>
  		</c:forEach>
  		<tr>
	  		<td>总计</td>
	  		<td><c:if test="${empty list2[0].s5}">0</c:if>${ list2[0].s5}</td>
	  		<td><c:if test="${empty list2[0].s4}">0</c:if>${ list2[0].s4}</td>
	  		<td><c:if test="${empty list2[0].s1}">0</c:if>${ list2[0].s1}</td>
	  		<td><c:if test="${empty list2[0].s6}">0</c:if>${ list2[0].s6}</td>
	  		<td><c:if test="${empty list2[0].s2}">0</c:if>${ list2[0].s2}</td>
	  		<td><c:if test="${empty list2[0].s3}">0</c:if>${ list2[0].s3}</td>
	  		<td><c:if test="${empty list2[0].money}">0</c:if>${ list2[0].money}</td>
  		</tr>
  	</table>
    </div>
  </body>
</html>
