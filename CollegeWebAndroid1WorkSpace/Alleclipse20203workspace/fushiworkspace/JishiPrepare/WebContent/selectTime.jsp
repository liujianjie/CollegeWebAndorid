<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询时间段是否在工作</title>
<script src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<p>查询时间段是否在工作</p>
	<p>请输入时间段：<input type="text" name="datetime" id="datetime"/></p>
	<p><button onclick="getResult()">查询</button> </p>
	<p>查询结果：<span id="result"></span></p>
	
	<script type="text/javascript">
		function getResult(){
			var datet = $("#datetime").val();
			$.ajax({
				url: "${pageContext.request.contextPath }/selectByAjax",
				type: "post",
				data: {datetime:datet},
				success:function(data){
					console.log(data);
					$('#result').html(data);
				}
			});
		}
	</script>
</body>
</html>