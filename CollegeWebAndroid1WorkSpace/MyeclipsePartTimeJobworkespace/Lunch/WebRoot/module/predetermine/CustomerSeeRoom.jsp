<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CustomerSeeRoom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#fanhui").click(function(){
				window.open("${path}/module/Login/Menu.jsp","_top");
			});
		});
		function cancel(preid,customerid){
			$.ajax({
				url:"${path}/pre_customerCansel.action?",
				data:{"preid":preid},
				dataType:"json",
				type:"post",
				success:function(data){
					alert(data.message);
					window.location.href="${path}/pre_seeCustomerRoom.action?customerid="+customerid;
				}
			});
		}
	</script>
  </head>
  
  <body>
  	<div style="text-align:center;font-size:30px" >我的预订信息</div>
  <div>
    <table class="table table-bordered table-hover table-striped">
    	<tr>
    		<th>序号</th>
    		<th>顾客姓名</th>
    		<th>预定日期</th>
    		<th>预定时间段</th>
    		<th>预定桌房号</th>
    		<th>下单时间</th>
    		<th>预定状态</th>
    		<th>操作</th>
    	</tr>
	    <c:forEach items="${listCustomer }" var="list" varStatus="vars">
	    	<tr>
	    		<td>${vars.count }</td>
	    		<td>${list.customer_name }</td>
	    		<td>${list.pre_date }</td>
	    		<td>${list.pre_frame }</td>
	    		<td>${list.room_number }${list.room_type }</td>
	    		<td>${list.pre_time }</td>
	    		<td>${list.pre_state }</td>
	    		<td>
	    			<c:if test="${list.pre_state=='正常预订' }">
	    				<input type="button" onclick="cancel('${list.pre_id}','${list.customer_id }')" value="取消预定" class="btn btn-info"/>
	    			</c:if>
	    		</td>
	    	</tr>
	    </c:forEach>
   </table>
  </div>
<input type="image" value="返回" src="${path }/resource/img/返回.jpg" id="fanhui"/>
  </body>
</html>
