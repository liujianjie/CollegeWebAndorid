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
	
	<p><button onclick="testJson()">测试JSon</button></p>
</form>
<script type="text/javascript">
	function testJson(){
		var id = 3;
		$.ajax({
			url: "${pageContext.request.contextPath }/user/"+id,
			type: "get",
			dateType:"json",
			success:function(data){
				alert(data.username);
				console.log(data.username);
			}
			
		});
	}
</script>
</body>
</html>