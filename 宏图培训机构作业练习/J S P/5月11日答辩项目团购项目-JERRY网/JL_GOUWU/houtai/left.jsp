<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    <style>
    	#foot a{text-decoration: none;color: #8A2BE2 ;font-size:20px;vertical-align:center;}
    	#foot a:hover {color:#95361A;}
    	.leftstyle{
			border-style:solid; 
			border-width:1px;
			border-top-color:#FFFFE0;
			border-bottom-color:#ebebeb;
			border-right-color:#FFFFE0;
			border-left-color:#FFFFE0;
			background-color:#FFFFE0;
			height:50px;
			width:200px;

		}
		.leftstyle:hover{
			border-style:solid; 
			border-width:1px;
			border-top-color:#ebebeb;
			border-bottom-color:#ebebeb;
			border-right-color:#FFFFE0;
			border-left-color:#ebebeb;
			background-color:white;
			height:50px;
			width:200px;

		}
		 #wrap {
  			height:50px;
  			display:table;
 		}
 		#content {
  			vertical-align:middle;
  			display:table-cell;
 		}	
    </style>
  </head>
  
  <body>
    <table width="70%" align="right">
    	<tr align="center" height="50">
    		<td>
    				<div id="foot" class="leftstyle" class="selection">
    				<div id="wrap">
  					<div id="content">
  						<a href="mold?method=htlist" target="main">类型信息</a>
  					</div>
  					</div>
  					</div>
    			
  			</td>
    	</tr>
  		<tr align="center" height="50">
  			<td>
  				<div id="foot" class="leftstyle">
  				<div id="wrap">
  				<div id="content">
   					<a href="bottom?method=list" target="main">分类信息</a>
   				</div>
  				</div>
    			</div>
  			</td>
  		</tr>
  		<tr align="center" height="50" valign="middle">
  			<td >
  				<div id="foot" class="leftstyle">
  				<div id="wrap">
  				<div id="content">
    				<a href="bottom?method=toadd" target="main">添加分类</a>
    			</div>
  				</div>
    			</div>
  			</td>
  		</tr>
  		<tr align="center" height="50">
  			<td>
  				<div id="foot" class="leftstyle">
  				<div id="wrap">
  				<div id="content">
    				<a href="goods?method=list" target="main">商品信息</a>
    			</div>
  				</div>
    			</div>
  			</td>
  		</tr>
  		<tr align="center" height="50">
  			<td>
  				<div id="foot" align="center" class="leftstyle">
  				<div id="wrap">
  				<div id="content">
    				<a href="goods?method=toadd" target="main">添加商品</a>
    			</div>
  				</div>
    			</div>
  			</td>
  		</tr>
  		<tr align="center" height="50">
  			<td>
  				<div id="foot" align="center" class="leftstyle">
  				<div id="wrap">
  				<div id="content">
    				<a href="houtai_caozuo/goxfyz.jsp" target="main">消费验证</a>
    			</div>
  				</div>
    			</div>
  			</td>
  		</tr>
  		<tr align="center" height="50">
  			<td>
  				<div id="foot" align="center" class="leftstyle">
  				<div id="wrap">
  				<div id="content">
    				<a onclick="zilei();">查看消息</a>
    				<script>
						var c=null;
						function zilei(){
							c=window.open("qiantai_chart/fwdchart.jsp","","width=600 height=400 top=200 left=400");
						}
						function ziclose(){
							c.close();
						
						}
					</script>
    			</div>
  				</div>
    			</div>
  			</td>
  		</tr>
  		<tr align="center" height="50">
  			<td>
  				<div id="foot" align="center" class="leftstyle">
  				<div id="wrap">
  				<div id="content">
    				<a href="qiantai_main/main.jsp" target="_top">返回首页</a>
    			</div>
  				</div>
    			</div>
  			</td>
  		</tr>
    </table>
  </body>
</html>
