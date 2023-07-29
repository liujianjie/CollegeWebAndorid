<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'json.jsp' starting page</title>
    
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
			$.ajax({
				  url:"ht2/execute",
				  type:"post",
				  data:"",
				  dataType:"json",
				  success:function(data){
				  	var list=data.list;
					alert(list[0]);	
					var table=$("<table>",{
						"cellspacing":"1.5",
						"align":"center",
						"width":"60%",
						"bgcolor":"purple"
					});
					var tr=$("<tr>",{
						"align":"center",
						"bgcolor":"#ffffff"
					});
					for(var i=0;i<list.length;i++){
						var text=list[i];
						var td=$("<td>",{
							"text":text
						});
						tr.append(td);
					}
					table.append(tr);
					$("#showdiv").html(table);
				  }
			});
// 			$.post("ht2/execute",{uname:"张三"},function(data){
// 				//alert(data.uname);
// 				var list=data.list;
// 				alert(list[0]);	
// 				var table=$("<table>",{
// 					"cellspacing":"1.5",
// 					"align":"center",
// 					"width":"60%",
// 					"bgcolor":"purple"
// 				});
// 				var tr=$("<tr>",{
// 					"align":"center",
// 					"bgcolor":"#ffffff"
// 				});
// 				for(var i=0;i<list.length;i++){
// 					var text=list[i];
// 					var td=$("<td>",{
// 						"text":text
// 					});
// 					tr.append(td);
// 				}
// 				table.append(tr);
// 				$("#showdiv").html(table);

// 			},"json");
		});
	</script>
  </head>
  
  <body>
    <div id="showdiv"></div>
  </body>
</html>
