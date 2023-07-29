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
    
    <title>My JSP 'SelectDuty.jsp' starting page</title>
    
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
	  		$("#searchForm").attr("action","${path }/duty/SelectDuty?nowpage="+nowpage);
	          $("#searchForm").submit();
	  	}
	  	function update(a,b){
	  		window.location.href="${path}/duty/UpdateDuty?dutyid="+a;
	  	}
	  	function jinyong(dutyid){
	 		  $.ajax({
	 			url:"${path }/du_close.action",
	 			data:{"dutyid":dutyid},
	 			type:"post",
	 			dataType:"json",
	 			success:function(data){
	 				if(data.state==0){				
	 					layer.alert(data.message, {icon: 5});
	 				}else{
	 					window.location.href="${path}/duty/SelectDuty?nowpage=${page.nowpage}";
	 				 }
	 			}
	 			
	 		})
	 	}
	 	function qiyong(dutyid){
	 		  $.ajax({
	 			url:"${path }/du_open.action",
	 			data:{"dutyid":dutyid},
	 			type:"post",
	 			dataType:"json",
	 			success:function(data){	 
	 				if(data.state==1){
	 				window.location.href="${path}/duty/SelectDuty?nowpage=${page.nowpage}";			
	 				}				
	 			}
	 			
	 		})
	 	}
	  </script>
  </head>
  
  <body>
  	<h3></h3>
    <div align="center">
    	<form action="${path }/duty/SelectDuty" method="post" id="searchForm" class="form-inline" role="form">
    		<%-- 职务&nbsp;<input type="text" name="dutyname" value="${map.dutyname }"/>&nbsp;
    		部门&nbsp;<input type="text" name="departname" value="${map.departname }"/>&nbsp;
    		<input type="submit" value="查询" class="btn btn-info "/> --%>
    		
    		<div class="form-group">
				职务
				<input type="text" class="form-control" id="name"  name="dutyname" value="${map.dutyname }"
					   placeholder="请输入职务名称">
			</div>
			&nbsp;&nbsp;&nbsp;
			<div class="form-group">
				部门
				<input type="text" class="form-control" id="name"  name="departname" value="${map.departname }"
					   placeholder="请输入部门名称">
			</div>
			<input type="submit" value="查询"class="btn btn-info"/>    		
    	</form>
    </div>
    <div>
    	<table class="table table-bordered table-hover table-striped">
    		<tr align="center">
    			<td>序号</td><td>职务</td><td>部门</td><td>操作</td>
    		</tr>
    		<c:if test="${!empty list }">
    			<c:forEach items="${list }" var="map" varStatus="vas">
    				<tr align="center">
		    			<td>${vas.count+(page.nowpage-1)*6 }</td>
		    			<td>${map.duty_name }</td>
		    			<td>${map.depart_name }</td>
		    			<td>
		    				<c:if test="${map.state==0}">
			    				<input type="button" onclick="update('${map.duty_id}')" id="alter" value="修改" class="btn btn-info "/>
			    				<input type="button" onclick="jinyong(${map.duty_id})"  value="禁用" class="btn btn-danger "/>
		    				</c:if>
		    				<c:if test="${map.state==1}">
		    					<input type="button" onclick="qiyong(${map.duty_id})" value="启用" class="btn btn-danger "/></a>
		    				</c:if>
		    			</td>
    				</tr>
    			</c:forEach>
    		</c:if>
    		<tr align="center">
    			<td>
    				<a href="${path }/duty/UpdateDuty"><input type="button" value="添加" class="btn btn-success"/></a>
    			</td>
    			<td colspan="3">
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
