<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$.post("ht/photo!list.action",{},function(data){
				var list =data.list;
				var ul=$("<ul>");
				$.each(list,function(index,photo){
					var li=$("<li>",{
						"style":"width:20%;float:left"
					});
					
					var table=$("<table>");
					var tr1=$("<tr>");
					var td1=$("<td>");
					var img = $("<img>",{
						"src":photo.PSRC,
						"width":"200",
						"height":"160"
					});
					td1.append(img);
					tr1.append(td1);
					
					var tr2=$("<tr>",{
						"align":"center"
					});
					var td2=$("<td>",{
						"html":"<b>"+photo.PNAME+"</b>"
					});
					var a=$("<a>",{
						"html":" 下载",
						"href":"ht/photo!down.action?fname="+photo.PSRC
					});
					td2.append(a);
					tr2.append(td2);
					
					table.append(tr1);
					table.append(tr2);
					
					li.html(table);
					
					ul.append(li);
				});
				$("#showdiv").html(ul);
			},"json");
		});
	</script>
  </head>
  
  <body>
  <div id="showdiv" style="height:450px;"></div>
  <br/>
  <hr>
  <form action="ht/photo!add.action" method="post" enctype="multipart/form-data">
  	<input type="text" name="pnames"/><input type="file" name="photo"/>
  	<br/>
  	<input type="text" name="pnames"/><input type="file" name="photo"/>
  	<br/>
  	<input type="text" name="pnames"/><input type="file" name="photo"/>
  	<br/>
  	<input type="submit" value="上传"/>
  </form>
  </body>
</html>
