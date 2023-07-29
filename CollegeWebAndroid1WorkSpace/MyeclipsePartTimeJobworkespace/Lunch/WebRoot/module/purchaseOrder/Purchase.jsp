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
	<script type="text/javascript">
		$(document).ready(function(){
			$("#addBtn").click(function(){
				var aaa=getJson();
				console.log(aaa);
				alert(aaa);
				$.ajax({
					url:"${path }/pur_updateAllLibraryMaterials.action",
					data:{"caterials":JSON.stringify(aaa),poid:$("#poid").val()},
					type:"post",
					dataType:"json",
					success:function(data){
						alert(data.message);
						window.location.href="${path}/pur_findPur.action";
					}
				}); 
			});

		});
		function getJson(){
			var jsonArray=new Array();
			/* $("#tb tr").each(function(){
				alert(0);
			}); */
			$("#tb tr").each(function(){
				var caterialid=$(this).find("input[name='caterialid']").val();
				var demand=$(this).find("input[name='demand']").val();
				var cknum=$(this).find("input[name='cknum']").val();
				var json={"caterialid":caterialid,cknum:cknum,"demand":demand};
				jsonArray.push(json);
				
			});
			return jsonArray;
	  }
		
	</script>
  </head>
  
  <body>
    <div class="table table-striped">
	  	 <form  id="repertory" method="post">
	  		<!-- <input type="submit"  class="btn btn-success" value="查询" /> -->
	  		<table class="table table-striped"  >
	  			<tr>
	  				<%-- <td>${map }
	  					id<span>${map.emp_id}<input type="text" value="${map.emp_id}" name="empid"/></span>
	  				</td> --%>
	  				    <input type="hidden" value="${map.poid}" id="warehouseid" name="warehouseid"/>
	  				<td>
	  					出库人<span>${map.emp_user}</span>
	  				</td>
	  				<td>
	  					领取人<select name="">
	  					 <c:forEach items="${list3 }" var="emp">
							 <option value="${emp.emp_id }">${emp.emp_name }</option>	  					 
	  					 </c:forEach>
	  					</select>
	  				</td>
	  				<td>
	  					出库日期<span>${map.date }<%-- <input type="text" value="${map.date}" name="date"/> --%></span>
	  				</td>
	  				<td>
	  					出库编号<span>${map.listid }<%-- <input type="text" value="${map.listid}" name="empid"/> --%></span>
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
							<input type="hidden" name="demand"  value="${li.demand }"/>
								 
							  
							
		  				</td>
		  				<td>
							<input type="hidden" name="caterialid" value=""/> 
							<input type="text" name="cknum"  value=""/>
		  				</td>
		  				<td>${li.unit}</td>
		  				<td>${li.univalent}</td>
		  				<td>${li.total }</td>
		  				
	  				</tr>
	  			</c:forEach>
	  		</tbody>
  	</table>
  		<input type="button" value="保存" name="addBtn" id="addBtn" class="btn btn-success">
  		<%-- <a href="${path }/library_updateLibraryMaterials.action" class="btn btn-success">提交</a> --%>
  </body>
</html>
