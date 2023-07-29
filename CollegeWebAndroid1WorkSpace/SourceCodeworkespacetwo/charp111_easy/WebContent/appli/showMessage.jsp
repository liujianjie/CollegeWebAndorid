<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body{
font-size:9pt;
}
 table{
   background-color:#FFF;
   border-top:2px solid #B3DE94;
   border-bottom:2px solid #B3DE94;
   color:#965;
   font:12px arial;
   text-align:left;
   width:800px;
   }
   tr{
   background-color:#eee;
   }
</style>

</head>
<body>
<img src="gbook.gif"><a href="showMessage.jsp">查看评论</a>
<img src="weite.gif"><a href="submit.jsp">我要评论</a>
<table>
<%

     List<String> list=(List<String>)application.getAttribute("Mess");
if (list!=null) {
for (int i=0;i<list.size();i++)
{
         String message=(String)list.get(i);
         out.println(message+"<br>");
 }
 }else{out.println("无信息");}

 %>
 </table>
</body>
</html>