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
					url:"${path}/pur_insertWare.action", 
					data:{"empid":$("#empid").val()},
					type:"post",
					dataType:"json",
					success:function(data){
					  //alert(11);
                  		alert(data.message);
                  		window.location.href="${path}/pur_findPurchaseOrder.action";
		           }
				});
			});
		});
		function goTo(page){
          		$("#searchForm").attr("action","${path }/pur_findPurchaseOrder.action?nowpage="+page);
          		$("#searchForm").submit();
       		}  
	
	</script>
  </head>
  
  <body class="table table-striped">
   	<div>
   		
   		  <form action="${path }/dc/Warehouse"  method="post" id="searchForm">
    		<a class="btn btn-primary" data-toggle="modal" data-target="#myModal">新增出库详情表</a>
    		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"aria-hidden="true">
			 <div class="modal-dialog">
				 <div class="modal-content">
				    	<div class="form-group">
							进库人<input  name="empuser" id="empuser" value="${userinfo.emp_user }" type="text"/>
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
			    	<th>进库人员姓名</th>
			    	<th>进库日期</th>
			    	<th>进库编号</th>
			    	<th>进库详情</th>
			    	
			    </tr>
	     	<c:if test="${!empty list}"> 
	    		<c:forEach items="${list }" var="cai" varStatus="vars">
	    			<tr>
		    			<td>${cai.emp_user}</td>
		    			
		    			<td>${cai.date}</td>
		    		
		    			<td>${cai.listidinfo }</td>
		    			${cai.poid}
		    			<td>
		    			  <c:if test="${cai.outstate!=1 }">
		    			     <a href="${path}/pur_findPur.action?poid=${cai.poid}">进库</a>
		    			     <a href="${path}/pur_confimOut.action?poid=${cai.poid}">确定进库</a>
		    			  </c:if>
		    			  <a href="${path}/pur_findPur2.action?poid=${cai.poid}">详情查看</a>
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
	  		</table>
	  		
  		
    </div>
  </body>
</html>
