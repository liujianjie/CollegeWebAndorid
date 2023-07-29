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
	<style>
		.top p{background:#FFFFE0;margin-left:150px;}
		#topziti{font-size:13px}
		a{text-decoration: none;color:#4b4b4b}
		a:hover{color:#95361A}
		#topuser a:hover{
			border-style:solid; 
			border-width:1px;
			border-top-color:#f8f8f8;
			border-bottom-color:#666666;
			border-right-color:#f8f8f8;
			border-left-color:#f8f8f8;
			background-color:#f8f8f8;
			height:0px;
			width:60px;
		}
		.toptablestyle{
			border-style:solid; 
			border-width:1px;
			border-top-color:#ebebeb;
			border-bottom-color:#f8f8f8;
			border-right-color:#f8f8f8;
			border-left-color:#f8f8f8;
			background-color:#f8f8f8;
			height:0px;
			width:1470px;
		}	
	</style>
	
  </head>
  
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"> 
<table align="center" width="100%" border=0 bgcolor="#f8f8f8" >
	
	<tr height="35">
		<td align="right" width="11%" id="topziti">
			<a href="javascript:void(0);" onclick="AddFavorite('http://localhost:8080/JL_GOUWU/qiantai_main/main.jsp','杰瑞购物网');">
                收藏Jerry网</a>
		</td>
		<td align="left" width="46%" id="topziti">
			
				<c:if test="${jruser==null}">
					<div id="topuser">
					 &nbsp;&nbsp;<a href="qiantai_admin/login.jsp" target="_top"><font color="red">登录</font></a>&nbsp;
					<a href="qiantai_admin/zhuce.jsp" target="_top">注册</a>
					</div>
				</c:if>
				<c:if test="${jruser!=null }">
					<div id="topuser">
					&nbsp;&nbsp;欢迎您,亲爱的<font color="red">${jruser.uname  }</font>&nbsp;<a href="index?method=deljruser" target="_top">退出</a>
					</div>
				</c:if>
				
		</td>
		<td align="left" width="5%" id="topziti">
			<div id="topuser">
				<c:if test="${jruser!=null}">
					<a href="index?method=selorders" target="_top">我的订单</a>
				</c:if>
				<c:if test="${jruser==null}">
					<a href="qiantai_admin/login.jsp" target="_top">我的订单</a>
				</c:if>
			</div>
		</td>
		<td align="left" width="5%" id="topziti">
			<div id="topuser">
				<a>我的Jerry</a> |
			</div>
		</td>
		<td align="left" width="5%" id="topziti">
			<div id="topuser">
				<a>最近浏览</a> |
			</div>
		</td>
		<td align="left" width="5%" id="topziti">
		  	<div id="topuser">
			<a href="qiantai_sel/GoodsGouWuChe.jsp" target="_blank">购物车<font color="red">${chartcount }</font></a><font color="#4b4b4b">件</font> <font color="#4b4b4b">|</font>
			</div>
		</td>
		<td align="left" width="5%" id="topziti">
			<div id="topuser">
				<a>联系客服</a> |
			</div>
		</td>
		<td align="left" width="5%" id="topziti">
			<div id="topuser">
				<a href="http://www.360kan.com/ct/OULlcM7lLICuDj.html" target="_blank">多来看看我</a>
			</div>
		</td>
		<td align="left" width="8%">
	
			<a><font color="#4b4b4b"></font></a>

		</td>
	</tr>
</table>
	<!-- 为了顶层的颜色深一点 -->
	<div class="toptablestyle">

	</div>
	<!-- 3个br 杰瑞图片 -->
	
	<form action="goods?method=selxsgoods" target="_blank" method="post" >
	    <table align="center" width="87%" border=0>
	    	<tr height="150">
	    		<td align="left">
	    		<div style="position:relative; margin-left: 0px;margin-right: 0px;" >
	    			<img src="image/zhuti.png" height="105" width="85">
	    			<div style="position:absolute; z-index:2; left:85px; top:83px">
	    				<font size="3" color="#95361A">jerry.com</font>
	    			</div>
	    			</div>
	    		</td>
	    	
	    		<td align="left">
	    			<div style="margin-left:320px">
	    				<input type="text" name="uname" style="width:300px; height:28px;">
	    				<input type="submit" value="搜索" style="width:50px; height:28px;">
	    			</div>
	    		</td>
	    	</tr>
	    </table>
    </form>
    
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
