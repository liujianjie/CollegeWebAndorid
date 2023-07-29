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
    
    <title>My JSP 'Purchare.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	
	 $(function(){
          
       });
       function goTo(page){
          $("#searchForm").attr("action","${path }/dc/Purchase?nowpage="+page);
          $("#searchForm").submit();
       } 
	</script>
  </head>
  
  <body class="table table-striped">
    <div>
		<form action="${path}/dc/Purchase" method="post" id="searchForm"/>
			货物单价:<input type="text" name="univalent" value="${xiangqing.univalent}"/>
			<input class="btn btn-success" type="submit" value="查询"/>
		</form>
	</div>
    
    	<div class="table table-bordered">
    		<table class="table table-striped">
    	<tr>
    		<th>材料名称</th>
    		<th>材料数量</th>
    		<th>备用数量</th>
    		<th>进货数量</th>
    		<th>总价</th>
    		<th>货物单价</th>
    	</tr>
     <c:if test="${!empty list}"> 
    	
    		<c:forEach items="${list }" var="pur" varStatus="vars">
    			<tr>
    				<td>${pur.caterial_name}</td>
    				<td>${pur.sum}</td>
    				<td>${pur.margin}</td>
    				<td>${pur.quantity}</td>
    				<td>${pur.total }</td>
    				<td>${pur.univalent }</td>
    				
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
