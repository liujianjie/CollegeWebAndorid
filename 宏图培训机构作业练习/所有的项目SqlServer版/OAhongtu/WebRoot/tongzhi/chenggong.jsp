<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chenggong.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<script type="text/javascript">
$(function(){
	var i = 2;
	var ipt=$("ipt").val();
	setInterval(function(){
		if (i == 0) {
			if(ipt==1){
				location.href="xiebaolei/list1.action";
			}else if(ipt==2){
				location.href="xiebaolei/list2.action";
			}
			
		}
		document.getElementById("test").innerHTML = i;
		i--;
	}, 1000);
});

</script>

  </head>
  
  <body>
   	<input type="hidden" id="ipt" value="${num }">
    <b>发布成功</b>
    <br/>
    <span id="test">3</span>秒后返回上一页
    
   
  </body>
</html>
