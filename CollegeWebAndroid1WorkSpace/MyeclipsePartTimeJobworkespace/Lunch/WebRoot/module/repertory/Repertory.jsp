<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@	taglib	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Check.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script> 
	
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	$(document).ready(function(){
	
	/* function paging(page){
         window.location.href="${path }/meals_selectRepertory.action?nowpage="+page;
       }  */
	
	
	});
		 
       
      
      /*  
       function stop(obj){
	  		 if($(obj).val()=="禁用"){
	  				$(obj).val("启用");
		  			$(obj).prev().attr("disabled","disabled");
	  			}else{
	  				$(obj).val("禁用");
		  			$(obj).prev().removeAttr("disabled");
	  			} 
	  	} */
	</script>
  </head>
  
  <body>
  	 <div class="table table-striped">
	  	 <form  id="repertory" action="${path }/meals_selectRepertory.action" method="post">
	  	 	材料名称<input type="text" name="caterialname" value="${caterialname}"/>
	  		<input type="submit"  class="btn btn-success" value="查询" />
	  	 	
	  	 </form>
  	 </div>
  	<table class="table table-striped">
	  		<tr>
	  			<th>材料名称</th>
	  			<th>材料总数</th>
	  			<th>盘点剩余数量</th>
	  			<th>操作</th>
	  		</tr>
	  		<c:if test="${!empty  listRepertory}">
	  			<c:forEach items="${listRepertory }" var="rep" varStatus="vars">
	  				<tr>
	  					<td>${rep.caterial_name}</td>
		  				<td>${rep.sum}</td>
		  				<td>${rep.remainder}</td>
		  				<td>
		  					
		  					<!-- <input type="button" value="充足"/>
		  					 <input type="button" value="材料已用完" disabled="disabled"/> -->
		  					 <c:if test="${rep.sum<5}">
		  					 	
		  					  <input type="button" value="材料不足" disabled="disabled" class="btn btn-info "/>
		  					 </c:if>
		  					<c:if test="${rep.sum>5}">
		  					 	<input type="button" value="材料充足" class="btn btn-info"/>
		  					  
		  					 </c:if>
		  				</td>
	  				</tr>
	  			</c:forEach>
	  			
	  		</c:if>
  		<%-- <a href="javascript:paging(${page.nowpage+1 })">下一页</a> --%>
  		
  		
  			<td colspan="12" id="pagenum" style="text-align: center">
  				<a href="javascript:paging(1)">首页</a>
  			 	<c:if test="${page.nowpage!=1 }">
  		   		<%-- <a href="javascript:paging(${page.nowpage-1 })">上一页</a> --%>
  		   		<a href="${path }/meals_selectRepertory.action?nowpage=${page.nowpage-1 }">上一页</a>
  				</c:if>
  				<c:if test="${page.nowpage!=page.sumpage }">
  		 		<%-- <a href="javascript:paging(${page.nowpage+1 })">下一页</a> --%>
  		 		<a href="${path }/meals_selectRepertory.action?nowpage=${page.nowpage+1 }">下一页</a>
  		 		
  				</c:if>
  				<%--  <a href="javascript:paging(${page.sumpage})">尾页</a> --%>
  				 <a href="${path }/meals_selectRepertory.action?nowpage=${page.sumpage}">尾页</a>
  		 		<span>当前${page.nowpage }页</span>
  				<a href="javascript:paging($('#topage').val())">转到</a>
  				<input type="text" id="topage" value="${page.nowpage }" style="width:30px;">页
  		 		<span>共${page.sumpage }页</sapn>
  	 			<span id="lastspan">共${page.sumcount }条记录</span>
  			</td>
  	</table>
    
  </body>
</html>
