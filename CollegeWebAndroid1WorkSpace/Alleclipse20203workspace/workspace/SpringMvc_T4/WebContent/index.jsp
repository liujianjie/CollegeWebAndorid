<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<form>
	<p>用户名：<input type="text" name="username" id="username"/></p>
	
	<p>密码：<input type="text" name="password" id="password"/></p>
	
	<p><button onclick="testJson()">测试交换</button></p>
</form>
<script type="text/javascript">
	function testJson(){
		var username = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			url: "${pageContext.request.contextPath }/testJson",
			type: "post",
			data: JSON.stringify({username:username, password:password}),
			contentType:"application/json;charset=UTF-8",
			dateType:"json",
			success:function(data){
				if(data != null){
					alert("您输入的用户名为"+data.username+"密码："+data.password);
				}
			}
			
		});
	}
</script>
</body>
</html>