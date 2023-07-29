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
    
    <title>My JSP 'UpdateDuty.jsp' starting page</title>
    
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
  <script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#dutyname").blur(function(){
  			var reg = /^[ ]+$/;
  			var name=$("#dutyname").val();
  			if(name==''||reg.test(name)){
  				$("#duty").html("不能为空");
  			}else{
  				$.ajax({
	               url:"${path}/duty/CheckDuty",
	               data:{"dutyname":this.value,"dutyid":$("#dutyid").val()},
	               type:"post",
	               dataType:"json",//返回类型，以什么格式解析success:function(data)
	               success:function(data){
	               console.log(data);
	                  if(data.state==1){
	                      //alert("职务名重复，请重新输入！");
	                      $("#duty").html("该职务名已存在");
	                      $("#add").attr("disabled","disabled");
	                  }else{ 
	                  	  $("#duty").html("该职务名可用");	                    
	                      $("#add").removeAttr("disabled");
	                  }
	               }
	            });
  			}
  			
  		
  		});
  		$("#add").click(function(){
  			var reg = /^[ ]+$/;
  			var name=$("#dutyname").val();
  			if(name==''||reg.test(name)||$("#departname").val()==''){
  				layer.alert("输入框不能为空", {icon: 5});
  				/* alert(1); */
  			}else{
  				$.ajax({
	               url:"${path}/duty/InsertDuty",
	               data:$("#form").serialize(),
	               type:"post",
	               dataType:"json",
	               success:function(data){
	                  if(data.state=='true'){
	                     /* alert(data.message);
	                     window.location.href="${path}/duty/SelectDuty"; */
	                     layer.alert(data.message, {icon: 6});
	                     setTimeout("window.location.href='${path}/duty/SelectDuty'",900);
	                     
	                  }
	               }
	            });
  			}
  			
  		});
  		$("#back").click(function(){
  			window.location.href="${path}/duty/SelectDuty";
  		})
  	})
  </script>
  </head>
  
  <body>
    <form id="form">
    	<input type="hidden" name="dutyid" id="dutyid" value="${map.duty_id }"/>
    	<%-- <input type="hidden" name="departid" value="${map.depart_id }"/> --%>
    	<table class="table table-hover table-striped" style="margin:150px auto">
    		
    		<tr align="center">
    			<td width="33%">职务</td>
    			<td width="33%">
    				<input type="type" name="dutyname"  id="dutyname" value="${map.duty_name }" class="form-control" style="width:400px;display:inline;"/>
    			</td>
    			<td width="33%"id="duty"></td>
    		</tr>
    		<tr align="center">
    			<td>部门</td>
    			<td>
    				<select name="departname" id="departname" class="form-control" style="width:400px;display:inline;">
    					<c:if test="${!empty list }"></c:if>
	    					<c:forEach items="${list }" var="depart">
	    						<option value="${depart.depart_name }" <c:if test="${map.depart_id==depart.depart_id }">selected='selected'</c:if> >
	    							${depart.depart_name }
	    						</option>
	    					</c:forEach>
    				</select>
    			</td>
    			<td></td>
    		</tr>
    		<tr align="center">
    			<td colspan="3">
    				<input type="button"  value="完成" id="add" class="btn btn-info "/>
    				<input type="button" value="返回" id="back" class="btn btn-primary"/>
    			</td>  			
    		</tr>
    	</table>
    </form>
  </body>
</html>
