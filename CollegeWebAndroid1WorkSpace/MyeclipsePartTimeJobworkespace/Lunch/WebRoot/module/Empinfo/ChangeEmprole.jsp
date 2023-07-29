<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>My JSP 'ChangeEmprole.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
	*{
		margin:0 auto;
		padding-left:10px;
		list-style:none;
	}
</style>
  </head>
  <body>
    <div id="ddiv">
  	   <form action="${path }/dc/InsertEmpRo" id="form" method="post">
  	       <input type="hidden" name="empaccountid" value="${empaccountid}"/>
  	       <center><h3>员工名:${empname}</h3></center>
  	       <ul>
  	         <c:forEach items="${roleinfo}" var="map">
  	         
  	            <li>
  	              <input type="checkbox" name="roleid"
  	              <c:forEach items="${oneemprole}" var="one"> 
	  	              <c:if test="${map.role_id eq one.role_id}">checked="checked"</c:if>
	  	          </c:forEach>
	  	                 value="${map.role_id }"/>${map.role_name }
  	            </li>
  	          
  	         </c:forEach>
  	       </ul>
  	       <div id="all">
  	       <input class="btn btn-info" type="submit" value="提交" id="btn"/>
  	       <a href="${path }/dc/ShowAllEmp"><button type="button" class="btn btn-info" >关闭</button></a>
  	       </div>
  	   </form>
  	</div>	
  </body>
</html>
