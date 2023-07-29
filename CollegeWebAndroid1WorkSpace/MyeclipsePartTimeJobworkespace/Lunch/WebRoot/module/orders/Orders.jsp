<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Orders.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
		$(function(){
          
       });
        function goTo(page){
          $("#searchForm").attr("action","${path }/dc/Orders?nowpage="+page);
          $("#searchForm").submit();
       } 
	</script>
  </head>
  
   <body class="table table-striped">
 	
 	<div>
 		<form action="${path}/dc/Orders" method="post" id="searchForm">
    		顾客姓名:<input type="text" name="customername" value="${tongji.customername}" />
    		<button class="btn btn-success" type="submit" class="btn" >查询</button>
    	</form>
 	</div>
    <div id="content" class="table table-bordered">
    	<table class="table table-striped">
    		<tr>
    		<th >员工姓名</th>
    		<th >客户姓名</th>
    		<th >房间名称</th>	
    		<th >日期</th>	
    		<th >菜品名称</th>	
    		<th >订单数量</th>	
    		<th>菜品单价</th>
    		<th >菜品总价</th>	

    	</tr>
    	
    	<c:if test="${!empty list}" >
    		<c:forEach items="${list }" var="ord" varStatus="vars">
    			<tr>
    				<%-- //<td>${vars.count }</td> --%>
    				<td>${ord.emp_name}</td>
    				<td>${ord.customer_name}</td>
    				<td>${ord.room_number}</td>
    				<td>${ord.order_date}</td>
    				<td>${ord.order_content}</td>
    				<td>${ord.order_count}</td>
    				<td>${ord.meal_price}</td>
    				<td>${ord.price}</td>
    			</tr>
    		</c:forEach>
    	
    	</c:if>
    
    	<td colspan="12" id="pagenum" style="text-align: center">
  				<a href="javascript:goTo(1)">首页</a>
  			 	<c:if test="${page.nowpage!=1 }">
  		   		<a href="javascript:goTo(${page.nowpage-1 })">上一页</a>
  				</c:if>
  				<c:if test="${page.nowpage!=page.sumpage }">
  		 		<a href="javascript:goTo(${page.nowpage+1 })">下一页</a>
  				</c:if>
  				 <a href="javascript:goTo(${page.sumpage})">尾页</a>
  		 		<span>当前${page.nowpage }页</span>
  				<a href="javascript:goTo($('#topage').val())">转到</a>
  				<input type="text" id="topage" value="${page.nowpage }" style="width:30px;">页
  		 		<span>共${page.sumpage }页</sapn>
  	 			<span id="lastspan">共${page.sumcount }条记录</span>
  			</td>
    	</table>
    	
    </div>
 		
  </body>
</html>
