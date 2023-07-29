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
    
    <title>My JSP 'LibraryMaterials.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
    <div class="table table-striped">
	  	 <form  id="repertory" method="post">
	  		<!-- <input type="submit"  class="btn btn-success" value="查询" /> -->
	  		<table class="table table-striped"  >
	  			<tr>
	  				<%-- <td>
	  				    <input type="text" value="${map2.warehouse_id}" id="warehouseid" name="warehouseid" readonly="readonly"/>
	  					id<span>${map2.emp_id}<input type="text" value="${map2.emp_id}" name="empid" readonly="readonly"/></span>
	  				</td> --%>
	  				<td>
	  					进库人<span>${map2.emp_user}</span>
	  				</td>
	  				<td>
	  					进库日期<span>${map2.date }</span>
	  				</td>
	  				<td>
	  					进库编号<span>${map2.listid }</span>
	  				</td>
	  				<td>
	  				   <input class="btn btn-primary" type="button" onclick="javascript:window.history.back(-1);" value="返回"/>
	  				</td>
	  			</tr>
	  		</table>
	  	 </form>
  	 </div>
  	 
  	<table class="table table-striped">
	  		<tr>
	  			<th>材料名称</th>
	  			<th>材料余量</th>
	  			<th>进库量</th>
	  			<th>单位</th>
	  			<th>材料单价</th>
	  			<th>材料总价</th>
	  		</tr>
	  		
	  		<tbody id="tb">
	  			<c:forEach items="${list }" var="li" varStatus="vars">
	  				<tr>
	  					<td>${li.caterial_name}</td>
		  				<td>
		  					${li.demand }
							<input type="hidden" name="demand"  value="${li.demand }" readonly="readonly"/>
								 
							  
							
		  				</td>
		  				<td>
							<input type="hidden" name="caterialid" value="${li.caterial_id }" readonly="readonly"/> 
							<input type="text" name="cknum"  value="${li.ck_num }" readonly="readonly"/>
		  				</td>
		  				<td>${li.unit}</td>
		  				<td>${li.univalent}</td>
		  				<td>${li.total }</td>
		  				
	  				</tr>
	  			</c:forEach>
	  		</tbody>
  	</table>
  		<!-- <input type="button" value="保存" name="addBtn" id="addBtn" class="btn btn-success" > -->
  		
  </body>
</html>
