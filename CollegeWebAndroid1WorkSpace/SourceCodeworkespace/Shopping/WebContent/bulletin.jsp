<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zuxia.model.BulletinInfo"%>
<%@page import="com.zuxia.dao.BulletinDao"%>
<%@page import="com.zuxia.util.DateTimeUtil"%>
<%
String id = request.getParameter("id");
if(null==id){
	response.sendRedirect("showBulletinList.jsp");
	return;
}
BulletinDao dao = new BulletinDao();
BulletinInfo item =dao.getBulletinInfo(Integer.parseInt(id)) ;
if(item==null){
	response.sendRedirect("showBulletinList.jsp");
	return;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
out.println("<base href=\""+basePath+"\">");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=item.getTitle()+"-"%>公告信息-在线销售旅游用品 登山攀岩器材、户外服装、户外桌椅、睡袋垫子、野营用品、野营帐篷、运动手表...</title>
	<link rel="stylesheet" href="common/css/common.css" type="text/css"></link>
	<style type="text/css">
	.div_bulletin {border: 1px solid #CCE3F1;padding:20px 10px 20px 10px;}
	.content {font-size: 14px;text-align: left;padding:10px;margin-left:auto;margin-right:auto;padding:10px 50px 10px 50px;}
	p{text-indent: 2em;word-spacing: 5px;line-height: 24px;}
	.title {font-size: 20px;margin-bottom:15px;text-align: center;font-weight: bold;}
	.info {font-size: 12px;margin: 3px;text-align: center;}
	</style>
</head>
<body>
	<iframe src="top_index.jsp" name="topFrame" width="100%" height="150px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
	<div id="middle_div">
	    <div class="sitemap">
			您现在所在的位置：<a target="_top" href="index.jsp">网站首页</a>&nbsp;&gt;&nbsp;
			<a href="showBulletinList.jsp?pageNo=1">网站公告</a>&nbsp;&gt;&nbsp;公告信息
		</div>
		<div class="div_bulletin">
			<div class="title"><%=item.getTitle()%></div>
			<div class="info">
				<%=DateTimeUtil.convertDate(item.getCreateTime())%>&nbsp;&nbsp;
				发布者：<%=item.getUser().getUserName()%>
			</div>
			<div class="content"><%=item.getContent()%></div>
		</div>
	</div>
	<iframe src="bottom_index.jsp" name="bottomFrame" width="100%" height="180px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
</body>
</html>