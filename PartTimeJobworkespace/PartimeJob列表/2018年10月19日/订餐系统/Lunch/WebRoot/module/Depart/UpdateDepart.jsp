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
    
    <title>My JSP 'UpdateDepart.jsp' starting page</title>
    
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
  		
  		
  		$("#departname").blur(function(){
  			var reg = /^[ ]+$/;
  			var name=$("#departname").val();
  			
  			if(name==''||reg.test(name)){
  				$("#departWrong").html("不能为空");
  			}else{
  				$.ajax({
	               url:"${path}/depart/CheckDepart",
	               data:{"departname":this.value,"departid":$("#departid").val()},
	               type:"post",
	               dataType:"json",//返回类型，以什么格式解析success:function(data)
	               success:function(data){
	               console.log(data);
	                  if(data.state==1){
	                      $("#departWrong").html("该部门名已存在");
	                      $("#add").attr("disabled","disabled");
	                  }else{
	                  	  $("#departWrong").html("该部门名可用");                     
	                      $("#add").removeAttr("disabled");
	                  }
	               }
	            });
  			}	
  		});
  		$("#add").click(function(){
  			var reg = /^[ ]+$/;
  			var name=$("#departname").val();
  			var desc=$("#departdesc").val();
  			if(name==''||desc==''||reg.test(name)||reg.test(desc)){
  				//alert("输入框不能为空");
  				 layer.alert("输入框不能为空", {icon: 5});
  			}else{
  				$.ajax({
	               url:"${path}/depart/InsertDepart",
	               data:$("#form").serialize(),
	               type:"post",
	               dataType:"json",
	               success:function(data){
	                  if(data.state=='true'){
	                     layer.alert(data.message, {icon: 6});
		                 setTimeout("window.location.href='${path}/depart/SelectDepart'",900);
	                     //alert(data.message);
	                     
	                     //window.location.href="${path}/depart/SelectDepart";
	                  }
	               }
	            });
  			} 			
  		});
  		$("#back").click(function(){
  			window.location.href="${path}/depart/SelectDepart";
  		})
  	})
  </script>
  </head>
  
  <body>
    <form  id="form">
    	<input type="hidden" name="departid" id="departid" value="${map.depart_id }"/>
    	<table class="table  table-hover table-striped">
    		<tr align="center">
    			<td width="20%"> </td>
    			<td width="60%">部门&nbsp;<input type="text" name="departname" id="departname" value="${map.depart_name }" class="form-control"  style="width:50%;display:inline;"/></td>  			
    			<td width="20%"><span id="departWrong"></span></td>
    		</tr>
    		<tr align="center" >
    			<td colspan="3">职责
    				&nbsp;&nbsp;&nbsp;<textarea class="form-control" rows="5" cols="" style="width:50%" name="departdesc" id="departdesc" value="${map.depart_desc }">${map.depart_desc }</textarea>
    			</td>
    			  			
    		</tr>
    		<tr align="center">
    			<td  colspan="3">
    				<input type="button"  value="完成" id="add" class="btn btn-info "/>
    				<input type="button" value="返回" id="back"  class="btn btn-primary "/>
    			</td>  			
    		</tr>
    	</table>
    </form>
  </body>
</html>
