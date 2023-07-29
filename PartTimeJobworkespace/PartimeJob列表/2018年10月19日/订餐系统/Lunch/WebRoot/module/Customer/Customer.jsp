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
    
    <title>My JSP 'Customer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css">
  <script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
  <style type="text/css">
  #box{
  	width:100%;
  	margin:0 auto;
  	
  }
  tr>td{
  	text-align:center;
  }
  .input-group{
		width:200px;
		padding:20px;
		float:left;
	}
  </style>
 <script type="text/javascript">
function goTo(i){
			$("#form1").attr("action","${path }/dc/CustomerInfo?nowpage="+i);
			$("#form1").submit();
}
</script>
  </head>
  
  <body>
  <div >
  <form action="${path }/dc/CustomerInfo" method="post" id="form1" class="bs-example bs-example-form" role="form">
   <div class="input-group" style="margin-left:120px">
 		<span class="input-group-addon">顾客名</span>
  		<input type="text" name="customername" value="${map.customername }" class="form-control" style="width:200px"> 
  </div>
  <div class="input-group">
  	   <span class="input-group-addon">用户名</span>
  		<input type="text" name="customeruser" value="${map.customeruser }" class="form-control" style="width:200px">
  </div>
  <div class="input-group" style="float:left">
  	<input type="submit" value="查询" class="btn btn-info">
  </div>
  </form>
  </div>
<div id="box">
   <table class="table table-bordered table-hover table-striped">
   		<caption><center><h1>顾客信息</h1></center></caption>
   		<thead>
   			<tr class="success">
	   			<th>序号</th>
	   			<th>姓名</th>
	   			<th>出生年月</th>
	   			<th>性别</th>
	   			<th>手机号</th>
	   			<th>用户名</th>
	   			<!-- <th>密码</th> -->
	   			<th>地址</th>
	   			<!-- <th>操作</th> -->
   			</tr>
   		</thead>
   		<tbody>
   			<c:forEach items="${customerinfo}" var="customer" varStatus="var">
   			<tr>
   				<td>${var.count }</td>
   				<td>${customer.customer_name}</td>
   				<td>${customer.customer_birthday}</td>
   				<td><c:if test="${customer.sex eq 0}">男</c:if><c:if test="${customer.sex eq 1}">女</c:if></td>
   				<td>${customer.customer_phone}</td>
   				<td>${customer.customer_account_name}</td>
   				<%-- <td>${customer.customer_pwd}</td> --%>
   				<td>${customer.customer_city}${customer.customer_province}${customer.customer_district}${customer.customer_add}<input type="hidden" value="${customer.customer_id}"></td>
   				<%-- <td><input type="button" value="不去查看" class="btn btn-warning form-control"><input type="hidden" value="${customer.customer_id}"></td> --%>
   			<tr>
   			</c:forEach>
   		</tbody>
   		<tfoot>
   			<tr>
   			<td colspan="11" id="pagenum">
  				<a href="javascript:goTo(1)">首页</a>
  			 	<c:if test="${page.nowpage!=1 }">
  		   		<a href="javascript:goTo(${page.nowpage-1 })">上一页</a>
  				</c:if>
  				<c:if test="${page.nowpage!=page.sumpage and page.sumpage!=0}">
  		 		<a href="javascript:goTo(${page.nowpage+1 })">下一页</a>
  				</c:if>
  				 <a href="javascript:goTo(${page.sumpage})">尾页</a>
  		 		<span>当前${page.nowpage }页</span>
  				<%-- <a href="javascript:goTo($('#topage').val())">转到</a>
  				<input type="text" id="topage" value="${page.nowpage }" style="width:30px;">页--%>
  				<span>共${page.sumpage }页</sapn>
  	 			<span id="lastspan">共${page.sumcount }条记录</span>
  			</td>
   		</tr>
   		</tfoot>
   </table>
   </div>
  </body>
</html>
