<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function check(){
			var file = document.getElementById("file").value;
			if(file == "" || file.length == 0){
				alert("请选择文件");
			}
			return true;
		}
	</script>
	<form action="${pageContext.request.contextPath }/fileUpload" method = "post" 
		enctype="multipart/form-data" onsubmit="return check()">
		<p>请选择文件：<input id="file" type="file" name="uploadfile" multiple="multiple" /></p>
		<p><input type="submit" value="上传"/>
	</form>
</body>
</html>