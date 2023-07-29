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
    
    <title>My JSP 'SelectEmp.jsp' starting page</title>
    
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
  <script type="text/javascript">
  	$(document).ready(function(){
  	
  	});	
  	function goTo(nowpage){
  		$("#searchForm").attr("action","${path }/depart/SelectEmp?nowpage="+nowpage+"&departid=${depart}");
          $("#searchForm").submit();
  	}
  </script>
  </head>
  
  <body>
   <form action="${path }/depart/SelectEmp" method="post" id="searchForm"></form>
  <div>
    <table class="table table-bordered table-hover table-striped">
    	<tr align="center">
    		<td><a href="${path }/depart/SelectDepart"><input type="button" value="返回" class="btn btn-primary"/></a></td>
    		<td colspan="5">
    			<c:if test="${!empty list }">
    				${list[0].depart_name }
    			</c:if>
    			<c:if test="${empty list }">
    				${departname }
    			</c:if>
    			
    		</td>
    	</tr>
    	<tr align="center">
    		<td>序号</td><td>员工姓名</td><td>职务</td><td>性别</td><td>年龄</td><td>电话</td>
    	</tr>
    	<c:if test="${!empty list }">
    		<c:forEach items="${list }" var="map" varStatus="vas">
    			<tr align="center">
			    	<td>${vas.count+(page.nowpage-1)*6 }</td>
			    	<td>${map.emp_name }</td>
			    	<td>${map.duty_name }</td>
			    	<td>
			    		<c:if test="${map.sex ==1}">男</c:if>
			    		<c:if test="${map.sex ==0}">女</c:if>			    		
			    	</td>
			    	<td>${map.age }</td>
			    	<td>${map.phone }</td>
		    	</tr>
    		</c:forEach>   		
    	</c:if>
    	<tr align="center">
   			
	   		<td colspan="6">
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
