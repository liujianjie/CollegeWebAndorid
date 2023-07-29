<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function changeimage()
{	document.myform.showimages.src=document.myform.pic.value;}
</script>
<style type="text/css">
	body{
		font-size:9pt;
		font-family:Arial;}
	ul{
		list-style:none;}
	li{
		margin:10px;
		padding-left:400px;}
	input{
		color:#00008B;
		background-color:#ADD8E6;
		border:1px solid #00008B;}
</style>
</head>
<body>
 ${requestScope.success }<br/>
 <img src="${pageContext.request.contextPath}/appli/gbook.gif">
 <a href="${pageContext.request.contextPath}/appli/showMessage.jsp">查看评论</a>
 <img src="${pageContext.request.contextPath}/appli/weite.gif">
 <a href="${pageContext.request.contextPath}/appli/submit.jsp">我要评论</a>
 <br>
 <form action="${pageContext.request.contextPath}/MessagePane" method="post" name="myform">
 
	 <ul>
	 <li>昵称：<input type="text" value="peopleName" /></li>
	 <li>头像：<img title=点击选择头像 height=90 
	 src="${pageContext.request.contextPath}/appli/1.jpg" width=80 border=0 name=showimages>
	 
	 <select name="pic" onchange='changeimage();'>
	 	<option value="${pageContext.request.contextPath}/appli/1.jpg" selected>默认</option>
	 	<option value="${pageContext.request.contextPath}/appli/2.gif" >女孩</option>
	 	<option value="${pageContext.request.contextPath}/appli/3.jpg" >男孩</option>
	 	<option value="${pageContext.request.contextPath}/appli/4.jpg" >时尚</option>
	 	<option value="${pageContext.request.contextPath}/appli/6.png" >QQ</option>
	 </select>
	 </li>
	 <li>标题：<input type="text" value="Title"></li>
	 <li>评论：您读过这本书吗？请分享一下心得吧！不少于10个字<br>
	 <textarea name="message" rows="10" cols="40" wrap="hard"></textarea></li>
	 <li><input type="submit" value="提交">&nbsp;&nbsp;
	 	 <input type="reset" value="清除信息"></li>
	 </ul>
 </form>
</body>
</html>