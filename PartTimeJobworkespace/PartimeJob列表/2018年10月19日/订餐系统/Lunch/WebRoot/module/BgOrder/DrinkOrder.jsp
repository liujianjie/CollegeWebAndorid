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
    
    <title>My JSP 'DrinkOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.min.css">
	<script type="text/javascript" src="${path }/resource/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
  <script>
  	function changedetail(detailid){
  		window.location.href="${path}/bgO_changeDrinkO.action?detailid="+detailid;
  	}
  </script>
  </head>
  
  <body>
   <div>
   		<table class="table table-bordered table-hover table-striped">
   			<caption><center><h1>酒水订单</h1></center></caption>
   			<thead>
   				<tr>
   					<th>序号</th>
   					<th>外卖姓名或桌号</th>
   					<th>菜的类型</th>
   					<th>菜名</th>
   					<th>数量</th>
   					<th>下单时间</th>
   					<th>状态</th>
   					<th>操作</th>
   				</tr>
   			</thead>
   			<tbody>
   				<c:forEach items="${Drinklist }" var="d" varStatus="i">
   				<tr>
   					<td>${i.count }</td>
   					<td>${d.customer_name }${d.room_number }${d.room_type }</td>
   					<td>${d.meal_type }</td>
   					<td>${d.meal_name }</td>
   					<td>${d.count }</td>
   					<td>${d.order_date }</td>
   					<td>
   						<c:if test="${d.state eq 0 }">未完成</c:if>
   						<c:if test="${d.state eq 1 }">已完成</c:if>
   					</td>
   					<td><c:if test="${d.state eq 0 }"><input type="button" class="btn btn-info"value="完成" onclick="changedetail(${d.order_detail_id})"></c:if></td>
   					</tr>
   				</c:forEach>
   			</tbody>
   			<tfoot></tfoot>
   		</table>
   </div>
  </body>
</html>
