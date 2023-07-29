<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'GoodsToAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<!-- <script type="text/javascript" src="../../resource/js/jquery.fileupload-image.js"></script>
	<script type="text/javascript" src="../../resource/js/jquery.fileupload.js"></script> -->
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		$(document).ready(function(){
		   $("#mealprice").ajaxStart(function(){
            console.log("异步开始了");
         }); 
		  	$("#mealname").blur(function(){
				$.ajax({
					url:"${path}/dc/CheckUserName",
					data:{"mealname":this.value,"mealid":$("#mealid").val()},
					type:"post",
					dataType:"json",
					success:function(data){
						if(data.state){
							$("#add").html("菜品名称已存在");
							$("#addBtn").attr("disabled","disabled");
						}else{
							$("#add").html("菜品名称没有问题");
							$("#addBtn").removeAttr("disabled");
						}
					}
				});
				
			});  
			
		/* 	  $("#addBtn").click(function(){
		            	$.ajax({
		               		url:"${path}/dc/InsertGoods",
		               		data:$("#form").serialize(),
		               		type:"post",
		               		dataType:"json",
		               		success:function(data){
		                  		if(data.state=='true'){
		                     		alert(data.message);
		                     		window.location.href="${path}/dc/Goods";
		                  		}
		               		}
		            	});
		         	});
				});
    		
    		    function doUpload() {  
			         var formData = new FormData($( "#uploadForm" )[0]);  
			         $.ajax({  
			              url: "${path }/upload_pictureinfo.action" ,  
			              type: "POST",  
			              data: formData,  
			              async: false,  
			              cache: false,  
			              contentType: false,  
			              processData: false,  
			              success: function (returndata) {  
			                  alert(returndata);  
			              },  
			              error: function (returndata) {  
			                  alert(returndata);  
			              }  
			         });  
    			}    */
    			 function doUpload() {  
			         var formData = new FormData($( "#uploadFormAct" )[0]);  
			         $.ajax({  
			              url: "${path }/Prcute_Upload.action" ,  
			              type: "POST",  
			              data: formData,  
			              async: false,  
			              cache: false,  
			              contentType: false,  
			              processData: false,  
			              success: function (returndata) {  
			                  alert(returndata); 
			                  $("input[name='filenameFileName']").removeAttr("value");
			                 $("input[name='filenameFileName']").attr("value",returndata);
			              },  
			              error: function (returndata) {  
			                  alert(returndata);  
			              }  
			         });  
    			} 
			 $("#addBtn").click(function(){
			 			var imageurl=doUpload();
			 			alert(imageurl);
		            	$.ajax({
		               		url:"${path}/dc/InsertGoods",
		               		data:{"mealid":$("#mealid").val(),"mealtype":$("#mealtype").val(),"mealname":$("#mealname").val(),"mealprice":$("#mealprice").val(),"mealdesc":$("#mealdesc").val(),"mealimage":$("input[name='filenameFileName']").val()},
		               		type:"post",
		               		dataType:"json",
		               		success:function(data){
		                  		if(data.state=='true'){
		                     		alert(data.message);
		                     		window.location.href="${path}/dc/Goods";
		                  		}
		               		}
		            	});
		         	});
				}); 
			
			
	</script>
  </head>
  
  <body >
      <form id="form" method="post" class="table table-striped" action="${path }/upload_pictureinfo.action" enctype="multipart/form-data">
  		<input type="hidden" name="mealid" id="mealid" value="${goods.meal_id }" class="table table-striped"/><br/>
  		<input  type="hidden" id="mealid" name="mealid" value="${goods.meal_id }" class="table table-striped"/><br/>
    	菜品类型:<input type="text" name="mealtype" id="mealtype" value="${goods.meal_type}" class="table table-striped"/>
    	菜品名称:<input type="text" name="mealname" id="mealname" value="${goods.meal_name}" class="table table-striped"/>
    			<span id="add"></span><br/>
    	菜品价格:<input type="text" name="mealprice" id="mealprice" value="${goods.meal_price}" class="table table-striped"/><br/>
    	菜品介绍:<input type="text" name="mealdesc" id="mealdesc" value="${goods.meal_desc }" class="table table-striped"/>
    	<form action="" id="uploadFormAct" >
			指定文件名 <input type="text" name="filenameFileName" value= ""/>    
			<input type="file" name="filename"/>
			<input type="button"  id="fileBtn" onclick="doUpload()" value="文件上传"/>
		</form>
    	<input type="button" id="addBtn" value="保存" class="btn btn-success">
    </form> 
	 
	 
		<%-- <form role="form">
		  <div class="form-group">
		    <label for="name"></label>
		    <input type="hidden" class="form-control" id="mealid" name="mealid" value="${goods.meal_id }" placeholder="">
		  </div>
		  <div class="form-group">
		    <label for="name">菜品类型:</label>
		    <input type="text" class="form-control" name="mealtype" id="mealtype" value="${goods.meal_type}" placeholder="请输入菜品类型">
		  </div>
		  <div class="form-group">
		    <label for="name">菜品名称:</label>
		    <input type="text" class="form-control" name="mealname" id="mealname" value="${goods.meal_name}" placeholder="请输入菜品名称">
		  </div>
		  <div class="form-group">
		    <label for="name">菜品价格:</label>
		    <input type="text" class="form-control" name="mealprice" id="mealprice" value="${goods.meal_price}" placeholder="请输入菜品价格">
		  </div>
		  <div class="form-group">
		    <label for="name">菜品介绍:</label>
		    <input type="text" class="form-control" name="mealdesc" id="mealdesc" value="${goods.meal_desc }" placeholder="请输入名称">
		  </div>
		  
		  <input type="button" id="addBtn" value="保存" class="btn btn-success">
		</form> --%>
	 
  </body>
</html>

			