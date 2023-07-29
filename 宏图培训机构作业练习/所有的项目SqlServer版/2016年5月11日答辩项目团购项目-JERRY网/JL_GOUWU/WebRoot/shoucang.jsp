<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>

  </head>
  
  <body>

<a href="javascript:void(0);" onclick="AddFavorite('http://blog.csdn.net/linlin2294592017','我的博客');">
                    收藏博客</a>
<script>
 function AddFavorite(sURL, sTitle) {
        try {
            window.external.addFavorite(sURL, sTitle);
        }
        catch (e) {
            try {
                window.sidebar.addPanel(sTitle, sURL, "");
            }
            catch (e) {
                alert("对不起当前浏览器不支持,加入收藏失败,请使用Ctrl+D进行添加");
            }
        }
    }
    </script>
  </body>
</html>
