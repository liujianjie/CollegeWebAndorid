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
    
    <title>My JSP 'SelectDepart.jsp' starting page</title>
    
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
   <script type="text/javascript"src="${path}/resource/layer/layer.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  	
  	});	
  	function goTo(nowpage){
  		$("#searchForm").attr("action","${path }/depart/SelectDepart?nowpage="+nowpage);
          $("#searchForm").submit();
  	}
    function jinyong(departid){
 		 $.ajax({
 			url:"${path }/de_close.action",
 			data:{"departid":departid},
 			type:"post",
 			dataType:"json",
 			success:function(data){
 				if(data.state==0){				
 					layer.alert(data.message, {icon: 5});
 				}else{
 				 
 				window.location.href="${path}/depart/SelectDepart?nowpage=${page.nowpage}";
 				 }
 			}
 			
 		})
 	}
 	function qiyong(departid){
 		 $.ajax({
 			url:"${path }/de_open.action",
 			data:{"departid":departid},
 			type:"post",
 			dataType:"json",
 			success:function(data){		
 				 if(data.state==1){
 					window.location.href="${path}/depart/SelectDepart?nowpage=${page.nowpage}";
 				 }
 			}
 			
 		})
 	}
  </script>
  </head>
  
  <body>
  <h3></h3>
  <form action="${path }/depart/SelectDepart" method="post" id="searchForm" class="form-inline" role="form">
  	<div align="center">
	  	<div class="form-group" >
			<label class="sr-only" for="name">名称</label>
			<input type="text" class="form-control" id="name" name="departname" value="${departname }"
				   placeholder="请输入部门名称">
			
		</div>
		<input type="submit" value="查询"class="btn btn-info"/>
	</div>
  </form>
  <div>
   	<table class="table table-bordered table-hover table-striped">
   		<tr align="center"><td>序号</td><td>名称</td><td>职责</td><td>操作</td></tr>
   		<c:if test="${!empty list }">
   			<c:forEach items="${list }" var="map" varStatus="vas">
   			<tr align="center">
	   			<td>${vas.count+(page.nowpage-1)*6 }</td>
	   			<td><a href="${path }/depart/SelectEmp?departid=${map.depart_id}&departname=${map.depart_name }">${map.depart_name }</a></td>
	   			<td>${map.depart_desc }</td>
	   			<td>
	   				<c:if test="${map.state==0}">
	   					<a href="${path }/depart/UpdateDepart?departid=${map.depart_id}"><input type="button" value="修改" class="btn btn-info"/></a>
	   					<input type="button" value="禁用" class="btn btn-danger" onclick="jinyong(${map.depart_id})"/>
	   				</c:if>
	   				<c:if test="${map.state==1}">
	   					<input type="button" value="启用" class="btn btn-danger" onclick="qiyong(${map.depart_id})"/>
	   				</c:if>
	   			</td>
   			</tr>
   			</c:forEach>
   		</c:if>
   		<tr align="center">
   			<td><a href="${path }/module/Depart/UpdateDepart.jsp"><input type="button" value="添加" class="btn btn-success"/></a></td>
	   		<td colspan="3">
	   			每页${page.pagecount }条&nbsp;&nbsp;总共${page.sumcount }条&nbsp;&nbsp;
		    	第${page.nowpage }页 &nbsp;&nbsp;总共${page.sumpage }页&nbsp;&nbsp;
		    	<c:if test="${!empty list}">
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
