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
    
    <title>My JSP 'OneroomOrder.jsp' starting page</title>
    
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
	<script language="javascript" src="${path }/resource/js/jquery-1.4.4.min.js"></script>
	<script language="javascript" src="${path }/resource/js/jquery.jqprint-0.3.js"></script>
	<style>
	.box{
		width:800px;
		vertical-align: venter;
		margin:0 auto;
	}
	</style>
	<script type="text/javascript">
	
		function reOneCookDe(orderdetailid,orderid){
			window.location.href="${path}/car_RemovecookDe.action?orderdetailid="+orderdetailid+"&orderid="+orderid;
		}

</script>
  </head>
  <body>
  <center><h1>欢迎来到网上订餐系统</h1></center>
  <center><h1>热菜详情界面</h1></center>
    <div class="box">
    	<table class="table">
    		<tr>
    			<th>订单编号：</th><td> ${roomorderlist[0].order_id }</td>
    			<th>订单时间</th><td>${roomorderlist[0].order_date }</td>
    			<th >总价金额</th><td>￥${roomorderlist[0].money }元</td>
    		</tr>
    		<tr>
    			<th>操作人</th><td>${roomorderlist[0].emp_name }</td>
    			<th>桌位：</th><td> ${roomorderlist[0].room_number }${roomorderlist[0].room_type }</td>
    			<th>大小</th><td>${roomorderlist[0].peo_count }人</td>
    		</tr>
    	</table>
    	<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
    	<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
    	<table class="table">
    		<tr>
    			<th>序号</th><th>详情编号</th><th>菜名</th><th>单价</th><th>数量</th><th>状态</th><th>操作</th>
    		</tr>
    		<c:if test="${!empty roomcooklist }">
    			<c:forEach items="${roomcooklist}" var="map" varStatus="i">
    				<tr>
    					<td>${i.count }</td>
	    				<td>${map.order_detail_id }</td>
	    				<td>${map.meal_name }</td>
	    				<td>${map.meal_price }</td>
	    				<td>${map.count }</td>
	    				<td>
		    			<c:choose>
			 				<c:when test="${map.state eq 0 }">未做</c:when>
			 				<c:when test="${map.state eq 1 }">完成</c:when>
			 				<c:when test="${map.state eq 2 }">正在做</c:when>
			 				<c:when test="${map.state eq 3 }">已上桌</c:when>
	 					</c:choose>
		    			</td>
		    			<td>
		    				<c:if test="${roomorderlist[0].state!=4}">
			    				<c:if test="${(map.state eq 0) and (map.meal_type eq '热菜')}"><input type="button" value="退菜" class="btn btn-danger" onclick="reOneCookDe('${map.order_detail_id }','${roomorderlist[0].order_id }')"></c:if>
		    				</c:if>
		    			</td>
    				</tr>
    			</c:forEach>
    		</c:if>
    	</table>
    </div>
    <!--打印内容结束-->
<!--endprint1-->
<c:if test="${flag eq 2 }">
	<a href="${path}/car_Jiezhang.action?orderid=${roomorderlist[0].order_id }&roomid=${roomorderlist[0].room_id }&flag=1""style="color:white;font-size: 20px;">
	<button class="btn btn-info">返回</button>
	</a> 
	</c:if>
	<c:if test="${flag!=2 }">
	<a href="${path }/car_OneroomOrder.action?orderid=${roomorderlist[0].order_id }&roomid=${roomorderlist[0].room_id }&flag=1""style="color:white;font-size: 20px;"><button class="btn btn-info">返回</button></a>
  	</c:if>
  </body>
</html>
