<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Picture.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path}/resource/js/jquery-2.1.4.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<script type="text/javascript">
 	$(document).reday(function(){
 	
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
    			}  
 	
 	});
 		
 	
 	</script>
  </head>
  
  <body>
    <form action="${path }/upload_pictureinfo.action" method="post" enctype="multipart/form-data">
    	<input type="file" name="upf"/>
    
 	<input type="submit" value="上传" id="btn" onclick="click()">
    </form> 
    <form id= "uploadForm" action="${path }/upload_pictureinfo.action" method="post" enctype="multipart/form-data">  
	      <p >指定文件名： <input type="text" name="fileFileName" value= ""/></p >  
	      <p >上传文件： <input type="file" name="file"/></p>  
	      <input type="button" value="上传" onclick="doUpload()" />  
		</form> 
  </body>
</html>
