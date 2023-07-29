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
		a{text-decoration: none;color:#4b4b4b;cursor:pointer;}
		a:hover{text-decoration: none;color:#95361A;cursor:pointer;}
		body{
			margin:0; padding:0; 
		}
		div{
			margin:0 auto;
		}
		.fl{
			float:left;
		}
		.fr{
			float:right;
		}
		form{
			margin:0; padding:0;
		}
		/*---------------header---------------*/
		.soubg{
			width:100%; min-width:1200px; height:42px; background-color:#f8f8f8;font-size:13px;
		}
		.sou{
			width:1200px; height:42px; line-height:42px;
		}
		.s_city_b{
			width:450px; height:35px; float:left;
		}
		.s_city{
			height:35px; float:left; padding-left:15px; cursor:pointer; position:relative;
		}
		.s_rightpadding{
			padding-right:30px;
		}
	</style>
	
  </head>
  
<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"> 
	<div class="soubg">
		<div class="sou">
			<span class="s_city_b">
				<span class="fl"><a href="javascript:void(0);" onclick="AddFavorite('http://localhost:8080/JL_GOUWU_SpringMvc/qiantai_main/main.jsp','杰瑞购物网');">
                收藏Jerry网</a></span>
                
                <c:if test="${jruser==null}">
                	<span class="s_city">
						<span><a href="qiantai_admin/login.jsp" target="_top"><font color="red">登录</font></a></span>
					</span>
					<span class="s_city">
						<span><a href="qiantai_admin/zhuce.jsp" target="_top">注册</a></span>
					</span>
				</c:if>
				<c:if test="${jruser!=null }">
					<span class="s_city">
						<span>欢迎您,亲爱的<font color="red">${jruser.uname  }</font>&nbsp;<a href="index/deljruser" target="_top">退出</a></span>
					</span>
				</c:if>
			</span>
			<span class="fr s_rightpadding">
				<span class="fl">
					&nbsp;&nbsp;
				
					<c:if test="${jruser!=null}">
						<a href="index/selorders" target="_top">我的订单</a>
					</c:if>
					<c:if test="${jruser==null}">
						<a href="qiantai_admin/login.jsp" target="_top">我的订单</a>
					</c:if>
				
					&nbsp;&nbsp;|
				</span>
				<span class="fl">&nbsp;&nbsp;<a>我的Jerry</a>&nbsp;&nbsp;|</span>
				<span class="fl">&nbsp;&nbsp;<a>最近浏览</a>&nbsp;&nbsp;|</span>
				<span class="fl">
					&nbsp;&nbsp;
					<a href="qiantai_sel/GoodsGouWuChe.jsp" target="_top">
						购物车<font color="red">${chartcount }</font>件
					</a>
					&nbsp;&nbsp;|
				</span>
				<span class="fl">&nbsp;&nbsp;<a>联系客服</a>&nbsp;&nbsp;|</span>
				<span class="fl">&nbsp;&nbsp;<a href="http://www.360kan.com/ct/OULlcM7lLICuDj.html" target="_blank">多来看看我</a>&nbsp;&nbsp;</span>
			</span>
		</div>
	</div>
	
	<form action="goods/selxsgoods" target="_blank" method="post" >
	    <table align="center" width="87%" border=0>
	    	<tr height="150">
	    		<td align="left">
	    		<div style="position:relative; margin-left: 0px;margin-right: 0px;" >
	    			<img src="image/zhuti.png"   height="105" width="85">
	    			<div style="position:absolute; z-index:2; left:85px; top:83px">
	    				<font size="3" color="#95361A"></font>
	    			</div>
	    			</div>
	    		</td>
	    	
	    		<td align="left">
	    			<div style="margin-left:200px">
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
