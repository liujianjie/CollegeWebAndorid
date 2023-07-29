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
    
    <title>My JSP 'SelectOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.min.css">	
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${path }/resource/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
			var date=new Date();
	  		var hour=Number(date.getHours());
  		
	  		$("#tab").find(".time").each(function(){
	  			var date1=$(this).html();
	  			var state=$(this).parent().find("span").html();
	  			
	  			var hour1=Number(date1.substring(11,13));
	  			if((hour1+2)<hour&&state==3){
	  				var orderid=$(this).prev().html();
	  				$.ajax({
		               url:"${path }/d_qrsh.action",
		               data:{"orderid":orderid},
		               type:"post",
		               dataType:"json",
		               success:function(data){
		                  if(data.state=='true'){
		                  	
		                     alert(orderid+''+data.message);
		                     window.location.href="${path}/order/SelectOrder?nowpage=${page.nowpage }&state="+$("input[type='radio']:checked").val();
		                  }
		               }
		            });
	  			}
	  		}) 
	  	});	
	  	function goTo(nowpage){
	  		$("#searchForm").attr("action","${path }/order/SelectOrder?nowpage="+nowpage);
	          $("#searchForm").submit();
	  	}
	  	
	</script>
  </head>
  
  <body>	
  <form action="${path }/order/SelectOrder" method="post" id="searchForm">
  	  <div class="btn-group" >
  	  	<label class="btn btn-primary">			
			<input type="radio" name="state" id="option0" value="" <c:if test="${state1==6}">checked="checked"</c:if>> 全部订单
		</label>
		<label class="btn btn-primary">
			<input type="radio" name="state" id="option1" value="0" <c:if test="${state1==0 }">checked="checked"</c:if>> 未处理
		</label>
		<label class="btn btn-primary">
			<input type="radio" name="state" id="option2" value="1" <c:if test="${state1==1 }">checked="checked"</c:if> >已接单
		</label>
		<label class="btn btn-primary">
			<input type="radio" name="state" id="option3" value="2" <c:if test="${state1==2 }">checked="checked"</c:if>> 已打包
		</label>
		<label class="btn btn-primary">
			<input type="radio" name="state" id="option4" value="3" <c:if test="${state1==3 }">checked="checked"</c:if>> 配送中
		</label>
		<label class="btn btn-primary">
			<input type="radio" name="state" id="option5" value="4" <c:if test="${state1==4 }">checked="checked"</c:if>> 已完成
		</label>
		<label class="btn btn-primary">
			<input type="radio" name="state" id="option6" value="5" <c:if test="${state1==5 }">checked="checked"</c:if>> 已取消
		</label>
	  </div>
	  <div align="center">
	    		<table style="width:250px">
	    			<tr align="center">
	    				<td><h4>顾客</h4></td>
	    				<td><input type="text" class="form-control" style="width:150px" name="customername" value="${info.customername }" placeholder="订单查询"/></td>
	    				<td><input type="submit" value="查询" class="btn btn-info "/></td>
	    			</tr>
	    		</table>  		    		
	  </div>
  </form>
  <div>
    <table class="table  table-striped " id="tab">
    	<tr align="center" >
    		<td>订单编号</td>
    		<td>下单时间</td>
    		<td>配送地址</td>
    		<td>订单详情</td>
    		<td>顾客</td><td>电话</td>
    		<td>金额</td><td>付款方式</td>
    		<td>配送人</td><td>状态</td>
    	</tr>
    	<c:if test="${!empty list }">
    		<c:forEach items="${list }" var="map">
    			<tr align="center" class="alert alert-info">
		    		<td>${map.order_id }</td>
		    		<td class="time">${map.order_date }</td>
		    		
		    		<td>${map.customer_add }</td>
		    		<td><a href="${path}/order/Detail?orderid=${map.order_id }&state=${map.state}"><input type="button" value="查看" class="btn btn-info"/></a></td>
		    		<td>${map.customer_name }</td><td>${map.customer_phone }</td>
		    		<td>${map.money }</td>
		    		<td>货到付款</td>
		    		<td>${map.emp_name }</td>
		    		<td>
		    			<c:if test="${map.state==3}">
		    				<span name="state" style="display:none">3</span>
		    			</c:if>		    			
		    			<c:choose>
		    				<c:when test="${map.state==0 }">未处理</c:when>
		    				<c:when test="${map.state==1 }">已接单</c:when>
		    				<c:when test="${map.state==2 }">已打包</c:when>
		    				<c:when test="${map.state==3 }">配送中</c:when>
		    				<c:when test="${map.state==4 }">已完成</c:when>
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
			    <c:if test="${!empty list }">
			    	<a href="javascript:goTo(1)">首页</a>&nbsp;&nbsp;
				    <c:if test="${page.nowpage!=1 }">
				    	<a href="javascript:goTo(${page.nowpage-1 })">上一页</a>&nbsp;&nbsp;
				    </c:if>
				    <c:if test="${page.nowpage!=page.sumpage }">
				    	<a href="javascript:goTo(${page.nowpage+1 })">下一页</a>&nbsp;&nbsp;
				    </c:if>
			    	<a href="javascript:goTo(${page.sumpage })">尾页</a>
			    </c:if>
    		</td>
    	</tr>
    </table>
  </div>
  </body>
</html>
