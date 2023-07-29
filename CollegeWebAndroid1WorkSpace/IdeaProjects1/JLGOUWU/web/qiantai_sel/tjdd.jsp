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
    
    <title>支付-JERRY网</title>
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
			width:100%;
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
			width:100%; min-width:1200px; height:42px; background-color:#f8f8f8;clear:both;font-size:13px;
		}
		.sou{
			width:1200px; height:42px; line-height:42px;
		}
		.s_city_b{
			width:370px; height:35px; float:left;
		}
		.s_city{
			height:35px; float:left; padding-left:15px; cursor:pointer; position:relative;
		}
		.s_rightpadding{
			padding-right:20px;
		}
		
		.divone{
			width:100%; min-width:1200px; height:80px; clear:both;margin-top:30px;
		}
		.imgdivone {
			width: 100%;
			min-width: 1000px;
			height: 105px;
			clear: both;
		}
		.divtwo{
			width:1200px;height:80px; line-height:80px;
		}
		.divtwoimg{
			width:400px; float:left;padding-bottom: 20px;
		}
		.divtwoinput{
			float:left; padding-left:15px; padding-top: 15px;
		}
		
		.divshouyeone{
			width:100%; min-width:1200px;height:auto; clear:both;margin-top:20px;
		}
		.divshouyeoneone{
			width:100%; min-width:1200px;height:auto; clear:both;
		}
		.divshouyetwo{
			width:1200px;clear:both;
		}
		.firsthen{
			clear:both;
			float:left;
			border-style:solid; 
			border-width:1px;
			border-top-color:#000000;
			border-bottom-color:#f8f8f8;
			border-right-color:#f8f8f8;
			border-left-color:#f8f8f8;
			width:1200px;
		}
	</style>
  </head>
  
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"> 
	<div class="soubg">
		<div class="sou">
			<span class="s_city_b">
				<span class="fl"><a href="javascript:void(0);" onclick="AddFavorite('http://localhost:8080/JL_GOUWU/qiantai_main/main.jsp','杰瑞购物网');">
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
						<span>欢迎您,亲爱的<font color="red">${jruser.uname  }</font>&nbsp;<a href="index?method=deljruser" target="_top">退出</a></span>
					</span>
				</c:if>
			</span>
			<span class="fr s_rightpadding">
				<span class="fl">
					&nbsp;&nbsp;
				
					<c:if test="${jruser!=null}">
						<a href="index?method=selorders" target="_top">我的订单</a>
					</c:if>
					<c:if test="${jruser==null}">
						<a href="qiantai_admin/login.jsp" target="_top">我的订单</a>
					</c:if>
				
					&nbsp;&nbsp;|
				</span>
				<span class="fl">&nbsp;&nbsp;<a href="#">我的Jerry</a>&nbsp;&nbsp;|</span>
				<span class="fl">&nbsp;&nbsp;<a href="#">最近浏览</a>&nbsp;&nbsp;|</span>
				<span class="fl">
					&nbsp;&nbsp;
					<a href="qiantai_sel/GoodsGouWuChe.jsp" target="_blank">
						购物车<font color="red">${chartcount }</font>件
					</a>
					&nbsp;&nbsp;|
				</span>
				<span class="fl">&nbsp;&nbsp;<a href="#">联系客服</a>&nbsp;&nbsp;|</span>
				<span class="fl">&nbsp;&nbsp;<a href="http://www.360kan.com/ct/OULlcM7lLICuDj.html" target="_blank">多来看看我</a>&nbsp;&nbsp;</span>
			</span>
		</div>
	</div>

	<div class="imgdivone">
		<div class="divtwo">
			<form action="goods?method=selxsgoods" target="_blank" name="frm" method="post" >
			<span class="divtwoimg">
				<span class="fl">
	    			<img src="image/b3.jpg" height="105" width="85"/>
	    			<font size="3" color="#95361A"></font>
			   	</span>
			</span>
			<span class="divtwoinput">
				<span class="fl">
		    			<input type="text" name="uname" style="width:300px; height:28px;">
		    			<input type="submit" value="搜索" style="width:50px; height:28px;">
		    	</span>
			</span>
			</form>
		</div>
	</div>

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
    <div class="divshouyeoneone">
		<div class="divshouyetwo">
			<div class="firsthen">
			
			</div>
		</div>
	</div>
	
    <c:set var="size" value="0"></c:set>
    <c:set var="money" value="0"></c:set>
    
     <div class="divshouyeone">
		<div class="divshouyetwo">
			<table width="100%" align="center" border=0>
		   		<tr height="40">
		   			<td>
		   				<font size="5">亲爱的用户:${jruser.uname }以下是你选择的商品，请确认。。。</font>
		   			</td>
		   		</tr>
		   	</table>
		 	
		    <table width="100%" align="center" border=0 cellpadding="0" cellspacing="0" bgcolor="DarkOrange"><!-- 橙红 -->
		    	<tr align="center" height="50" >
		    		<td width="45%" align="left"><font color="white" size="4">&nbsp&nbsp&nbsp&nbsp&nbsp项目</font></td>
					<td width="10%" align="center"><font color="white" size="4">单价</font></td>
					<td width="10%" align="center"><font color="white" size="4">数量</font></td>
					<td width="10%" align="center"><font color="white" size="4">小计</font></td>	
					<td width="15%" align="center"><font color="white" size="4">操作</font></td>
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
		    	<tr align="left"  bgcolor="white" height="70">
			    	<td colspan="5" >
			    		<font size="5">请选择支付方式</font>
		    			<br><br>
		   				<input type="radio" name="zhifu" checked>支付宝
		    			<input type="radio" name="zhifu">余额宝（可用${jruser.moneys }）
		    			<input type="radio" name="zhifu">QQ钱包
		    			<br>
					</td>
		    	</tr>
			</table>
			<hr width="100%">
		   	<table width="100%" align="center">
		   		<tr>
		   			<td width="40%">&nbsp;</td>
		   			<td width="10%">&nbsp;</td>
		   			<td width="10%">&nbsp;</td>
		   			<td width="10%">&nbsp;</td>
		   			<td width="10%"align="center">
						<a href="index?method=saveorders&gid=${g_id }"><img src="image/ljgm.png"></a><!-- 保存订单 -->
					</td>
		   		</tr>
		   	</table>
		</div>
	</div>
   
  </body>
</html>
