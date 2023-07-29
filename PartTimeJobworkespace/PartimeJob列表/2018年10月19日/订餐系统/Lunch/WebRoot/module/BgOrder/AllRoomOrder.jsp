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
    
    <title>My JSP 'AllRoomorder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.min.css">
	<script type="text/javascript" src="${path }/resource/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path}/resource/js/jquery-2.1.4.min.js"></script></head>
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script>
	  	function goTo(nowpage){
	  		$("#searchForm").attr("action","${path }/bgO_showAllRoomOrder.action?nowpage="+nowpage);
	        $("#searchForm").submit();
	  	}
	  	
	</script>
   
  <body>	
  <form action="${path }/bgO_showAllRoomOrder.action" method="post" id="searchForm">
  	  <div class="btn-group" >
  	  	<label class="btn btn-primary">
 			
			<input type="radio" name="state" id="option0" value="" <c:if test="${state=='' }">checked="checked"</c:if>> 全部订单
		</label>
		<%-- <label class="btn btn-primary">
			<input type="radio" name="state" id="option1" value="0" <c:if test="${state==0 }">checked="checked"</c:if>> 客户订单
		</label> --%>
		<label class="btn btn-primary">
			<input type="radio" name="state" id="option2" value="1" <c:if test="${state==1 }">checked="checked"</c:if> > 可上桌
		</label>
		<label class="btn btn-primary">
			<input type="radio" name="state" id="option3" value="4" <c:if test="${state==4 }">checked="checked"</c:if>> 完成订单
		</label>
		<label class="btn btn-primary">
			<input type="radio" name="state" id="option4" value="5" <c:if test="${state==5}">checked="checked"</c:if>> 取消订单
		</label>
	  </div>
	  <div align="center">
	    		<table style="width:300px">
	    			<tr align="center">
	    				<td><h4>房间或桌位</h4></td>
	    				<td><input type="text" class="form-control" style="width:150px" name="roomnumber" value="${roomMap.roomnumber }"/></td>
	    				<td><input type="submit" value="查询" class="btn btn-info "/></td>
	    			</tr>
	    		</table>  		    		
	  </div>
  </form>
  <div>
    <table class="table  table-hover " id="tab">
    	<tr align="center" >
    		<td>订单编号</td>
    		<td>下单时间</td>
    		<td>房间</td>
    		<td>订单详情</td>
    		<td>操作人</td>
    		<td>操作时间</td>
    		<td>金额</td>
    		<td>付款方式</td>
    		<td>状态</td>
    	</tr>
    	<c:if test="${!empty ROlist }">
    		<c:forEach items="${ROlist }" var="map">
    			<tr align="center" class="alert alert-success">
		    		<td>${map.order_id }</td>
		    		<td class="time">${map.order_date }</td>
		    		
		    		<td>${map.room_number}${map.room_type}</td>
		    		<td><a href="${path}/car_OnlyLookroom.action?orderid=${map.order_id }&roomid=${map.room_id }&flag=1"><button class="btn btn-primary">查看</button></a></td>
		    		<td>${map.emp_name }</td>
		    		<td>${map.date }</td>
		    		<td>${map.money }</td>
		    		<td>现场支付</td>
		    		<td>
		    			<c:if test="${map.state<2}">
		    				<span name="state" style="display:none">1</span>
		    			</c:if>		    			
		    			<c:choose>
		    				<c:when test="${map.state==0 }">未处理</c:when>
		    				<c:when test="${map.state==1 }">已接单</c:when>
		    				<c:when test="${map.state==4}">已完成</c:when>
		    				<c:when test="${map.state==5 }">已取消</c:when>
		    			</c:choose>
		    			
		    		</td>
		    	</tr>
    		</c:forEach>
    	</c:if>
    	<tr align="center" >
    		
    		<td colspan="10">
    			每页${page.pagecount }条&nbsp;&nbsp;总共${page.sumcount }条&nbsp;&nbsp;
			          第${page.nowpage }页 &nbsp;&nbsp;总共${page.sumpage }页&nbsp;&nbsp;
			    <a href="javascript:goTo(1)">首页</a>&nbsp;&nbsp;
			    <c:if test="${page.nowpage!=1 }">
			    	<a href="javascript:goTo(${page.nowpage-1 })">上一页</a>&nbsp;&nbsp;
			    </c:if>
			    <c:if test="${page.nowpage!=page.sumpage }">
			    	<a href="javascript:goTo(${page.nowpage+1 })">下一页</a>&nbsp;&nbsp;
			    </c:if>
			    <a href="javascript:goTo(${page.sumpage })">尾页</a>
    		</td>
    	</tr>
    </table>
  </div>
  </body>
</html>
