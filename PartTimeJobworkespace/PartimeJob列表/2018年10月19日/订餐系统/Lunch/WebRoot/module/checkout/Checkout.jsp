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
    
    <title>My JSP 'checkout.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
	<script type="text/javascript">
		$(document).ready(function(){
			$("#addBtn").click(function(){
				$.ajax({
					url:"${path}/library_insertWare.action", 
					data:{"empid":$("#empid").val()},
					type:"post",
					dataType:"json",
					success:function(data){
					  //alert(11);
                  		alert(data.message);
                  		window.location.href="${path}/dc/Warehouse";
		           }
				});
			});
		});
		function goTo(page){
          		$("#searchForm").attr("action","${path }/dc/Warehouse?nowpage="+page);
          		$("#searchForm").submit();
       		} 
	
	</script>
  </head>
  
  <body class="table table-striped">
   	<div>
   		
   		 <form action="${path }/dc/Warehouse"  method="post" id="searchForm">
    		<%-- 材料名称:<input type="text" id="caterialname" name="caterialname" value="${cailao.caterial_name}"/>
    		<input class="btn btn-success" type="submit" value="查询"/> --%>
    		<%-- <a href="${path }/library_insertWare.action">新增出库详情表</a> --%>
    		<a class="btn btn-primary" data-toggle="modal" data-target="#myModal">新增出库详情表</a>
    		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"aria-hidden="true">
			 <div class="modal-dialog">
				 <div class="modal-content">
				    	<div class="form-group">
							出库人<input  name="empuser" id="empuser" value="${userinfo.emp_user }" type="text"/>
							<input  name="empid" id="empid" value="${userinfo.emp_id }" type="hidden"/>
						</div>
				    	<input type="button" id="addBtn"value="保存"/>
				 	</div>
			 	</div>
	 		</div>
    	</form>
   	</div>
     <div class="table table-bordered">
    	<table class="table table-striped">
		    <tr>
		    	<th>出库人员姓名</th>
		    	<th>出库日期</th>
		    	<th>出库编号</th>
		    	<th>出库详情</th>
		    	
		    </tr>
     	<c:if test="${!empty ren}"> 
    		<c:forEach items="${ren }" var="cai" varStatus="vars">
    			<tr>
	    			<td>${cai.emp_user}</td>
	    			<%-- <td>
	    				<form  action="${path }/dc/UpdateWarehouse" method="post">
							<input type="hidden" name="caterialid" id="caterialid" value="${cai.caterial_id }">
							<input type="text" name="number" value="${cai.number }"/>
							<input type="submit"  value="提交">
						</form> 
						
	    			</td> --%>
	    			<td>${cai.date}</td>
	    			<%-- <td>${cai.listid}${cai}</td> --%><%--显示出编号 --%>
	    			<td>${cai.listidinfo }</td>
	    			${cai.warehouse_id}
	    			<td>
	    			  <c:if test="${cai.outstate!=1 }">
	    			     <a href="${path}/library_findLibraryMaterials.action?warehouseid=${cai.warehouse_id}">出库</a>
	    			     <a href="${path}/library_confimOut.action?warehouseid=${cai.warehouse_id}">确定出库</a>
	    			  </c:if>
	    			  <a href="${path}/library_findLibraryMaterials2.action?warehouseid=${cai.warehouse_id}">详情查看</a>
	    			</td>
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
    </div>
  </body>
</html>
