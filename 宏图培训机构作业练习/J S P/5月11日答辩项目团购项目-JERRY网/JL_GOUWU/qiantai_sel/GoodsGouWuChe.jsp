<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的购物车-JERRY网</title>
	<style>
		#topziti{font-size:13px}
		a{text-decoration: none;color:#4b4b4b }
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
		.goodstrstyle{
			border-style:solid; 
			border-width:1px;
			border-top-color:#ebebeb;
			border-bottom-color:#ebebeb;
			border-right-color:#ebebeb;
			border-left-color:#ebebeb;
			background-color:#ebebeb;
			height:0px;
			width:1180px;
		}
		.goodstablestyle{
			border-style:solid; 
			border-width:1px;
			border-top-color:#FF8C00;
			border-bottom-color:#FF8C00;
			border-right-color:#FF8C00;
			border-left-color:#FF8C00;
			background-color:#FF8C00;
			height:0px;
			width:800px;
		}
		 #wrap {
  			height:30px;
  			display:table;
 		}
 		#content {
  			vertical-align:middle;
  			display:table-cell;
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
		<td align="left" width="30%" id="topziti">
			
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
		<td align="left" width="4%" id="topziti">
			<div id="topuser">
				<c:if test="${jruser!=null}">
					<a href="index?method=selorders" target="_top">我的订单</a>
				</c:if>
				<c:if test="${jruser==null}">
					<a href="qiantai_admin/login.jsp" target="_top">我的订单</a>
				</c:if>
			</div>
		</td>
		<td align="left" width="4%" id="topziti">
			<div id="topuser">
				<a>我的Jerry</a> |
			</div>
		</td>
		<td align="left" width="4%" id="topziti">
			<div id="topuser">
				<a>最近浏览</a> |
			</div>
		</td>
		<td align="left" width="4%" id="topziti">
		  	<div id="topuser">
			<a href="qiantai_sel/GoodsGouWuChe.jsp" target="_blank">购物车<font color="red">${chartcount }</a><font color="#4b4b4b">件</font> <font color="#4b4b4b">|</font>
			</div>
		</td>
		<td align="left" width="4%" id="topziti">
			<div id="topuser">
				<a>联系客服</a> |
			</div>
		</td>
		<td align="left" width="5%" id="topziti">
			<div id="topuser">
				<a href="http://www.360kan.com/ct/OULlcM7lLICuDj.html" target="_blank">多来看看我</a>
			</div>
		</td>
		<td align="left" width="5%">
	
			<a><font color="#4b4b4b"></font></a>

		</td>
	</tr>
</table>
	<!-- 为了顶层的颜色深一点 -->
	<div class="toptablestyle">

	</div>
   	<br/><br><br>

    <form action="goods?method=selxsgoods" name="frm" target="_blank" method="post" >
	    <table align="center" width="80%">
	    	<tr align="center">
	    		<td>
	    			<input type="text" name="uname" style="width:300px; height:28px;">
	    			<input type="submit" value="搜索" style="width:50px; height:28px;">
	    		</td>
	    	</tr>
	    </table>
    </form>
        
    <br>
    <br>
    <script>
    	document.frm.uname.focus();
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
    <hr width="80%">
      <c:set var="size" value="0"></c:set>
      <c:set var="money" value="0"></c:set>
    <br>
    <c:if test="${gwcgoods!=null}">
    <table width="80%" align="center" border=0 cellpadding="0" cellspacing="0" bgcolor="DarkOrange"><!-- 橙红 -->
    	<tr align="center" height="50" >
    		<td width="40%" align="left"><font color="white" size="4">&nbsp&nbsp&nbsp&nbsp&nbsp项目</font></td>
			<td width="10%" align="center"><font color="white" size="4">单价</font></td>
			<td width="10%" align="center"><font color="white" size="4">数量</font></td>
			<td width="10%" align="center"><font color="white" size="4">小计</font></td>	
			<td width="10%" align="center"><font color="white" size="4">操作</font></td>
    	</tr>

    	<c:forEach items="${gwcgoods}" var="goods">
    		<tr height="90" bgcolor="white">
	    		<td align="left">
	    			<div style="position:relative; margin-left: 0px;margin-right: 0px;" >
						　　<img src="file/${goods.g_img }" width="65" height="42">
						　　		<div style="position:absolute; z-index:2; left:30px; top:10px">						
						　　　　		${goods.g_name }:<font size="2">${goods.g_dec }</font>
						　　</div>		
						</div>
	    		</td>
				<td align="center" ><font color="red">${goods.g_price }</font></td>
				<td align="center">${goods.gwccount }</td>
				<td align="center"><font color="red">${goods.g_price*goods.gwccount }</font></td>	
				<td align="center"><a href="goods?method=delgwcgoods&id=${goods.g_id }"><font color="#008080">删除</font></a></td>
				<c:set var="size" value="${size+goods.gwccount}"></c:set>
				<c:set var="money" value="${money+goods.g_price*goods.gwccount}"></c:set>

    		</tr>
    		<!-- 一根浅色的横线 -->
	    	<tr>
	    		<td colspan="5">
	    			<div class="goodstrstyle">
	    			</div>
	    		</td>
	    	</tr>
    	</c:forEach>
    	<!-- 一根橙色的横线 -->
    	<tr>
    		<td colspan="5">
    			<div class="goodstablestyle">
    			</div>
    		</td>
    	</tr>
    	<tr align="right"  bgcolor="white" height="60">
	    	<td>&nbsp</td>
	    	<td>&nbsp</td>
	    	<td>&nbsp</td>
    		<td colspan="2" > 已选<font color="#95361A" size="3">${size }</font>件商品，应付金额:<font color="OrangeRed" size="5">${money }</font>元</td>
    	</tr>
    	<tr align="right"  bgcolor="white" height="60">
	    	<td>&nbsp</td>
	    	<td>&nbsp</td>
	    	<td>&nbsp</td>
	    	<td>&nbsp</td>
    		<td align="center">
    			<c:if test="${jruser!=null}">
    				<a href="qiantai_sel/tjdd.jsp">提交订单</a>
    			</c:if>
    			<c:if test="${jruser==null}">
    				<a href="qiantai_admin/login.jsp" onclick="return confirm('你好,请先登录')"><font color="#008080">提交订单</font></a>
    			</c:if>	
    		</td>
    	</tr>
    </table>
    <hr width="80%">
    </c:if>
    
    <c:if test="${gwcgoods==null}">
    	<table width="80%" align="center">
    		<tr>
    			<td align="left">
    				<img src="image/meigoods.png">
    			</td>
    		</tr>
    	</table>

    	<div align="center">
    		购物车空空如也，去<a href="qiantai_main/main.jsp"><font color="#008080">首页</font></a>看看
    		<img src="image/jrmeigwc.png">
    	</div>
    </c:if>
    
  </body>
</html>
