<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'test.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	
<style >
	

</style>


<script type="text/javascript">

	function test(){
		alert("text...");
		var td=document.getElementById("aa");
		alert(td.innerText);
	}
</script>

	</head>

	<body>
	
	<table border="1">
		<tr>
			<td id="aa">啊啊</td>
		</tr>
	</table>
	
		
		<span id="span1" ondblclick="f1(this)" style="">aaa</span>
		
		<input  type="button" value="点击" onclick="test()" onblur="">
		
		<script type="text/javascript">
			function f1(sp1){
						//alert("进来");
				sp1.style.display="none";
				document.getElementById("ipt1").style.display="inline";
				document.getElementById("ipt1").select();
			}
			
			function tijiao(ipt){
				$.post("",{},function(data){
					
				},"json");
			}
			
			
	function aaa(){
		alert("aaa");
	}
		</script>
		
	</body>
</html>
