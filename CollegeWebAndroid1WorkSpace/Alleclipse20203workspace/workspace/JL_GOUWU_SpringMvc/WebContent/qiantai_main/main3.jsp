<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>【JERRY】官方购物网</title>
	<style>
		.ljstyle a{text-decoration:none;color:#797979;}
		.ljstyle a:hover{color:#008080 }
		#nav ul {margin:0;padding-left:0px;}
		.brhengxiang{
			border-style:solid; 
			border-width:1px;
			border-top-color:#ebebeb;
			border-bottom-color:#f8f8f8;
			border-right-color:#f8f8f8;
			border-left-color:#f8f8f8;
			background-color:whilte;
			height:0px;
			width:1170px;
		}	
		
		body{
			margin:0; padding:0; 
		}
		div{
			margin:0 auto;
		}
		form{
			margin:0; padding:0;
		}
		.fl{
			float:left;
		}
		.fr{
			float:right;
		}
		.showgoodsdiv{
			width:100%; min-width:1200px; height:40px; margin-top: 40px;clear:both;font-size:13px;
		}
		.showgoodsdiv .header{
			width:1200px; height:40px; line-height:40px;
		}
		.firsthen{
			clear:both;
			border-style:solid; 
			border-width:1px;
			border-top-color:#ebebeb;
			border-bottom-color:#f8f8f8;
			border-right-color:#f8f8f8;
			border-left-color:#f8f8f8;
			background-color:whilte;
			height:0px;
			width:1200px;
			margin-bottom: 20px;
		}
		.secondhen{
			clear:both;
			border-style:solid; 
			border-width:1px;
			border-top-color:#ebebeb;
			border-bottom-color:#f8f8f8;
			border-right-color:#f8f8f8;
			border-left-color:#f8f8f8;
			background-color:whilte;
			height:0px;
			width:1200px;
			margin-top: 20px;
		}
		.showgoodsdiv .header .gleft{
		
		}
		.showgoodsdiv .header .gright{
		
		}
		.showgoodsdiv .center{
			width:1200px;
			height:auto;
			margin-bottom: 20px;
		}
	</style>
  </head>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0" > 
  	<iframe src="qiantai_main/main2.jsp" style="width:100%;height:750px;border:0px" ></iframe>
  	<br>
  	
  	
  	  	
  	<div class = "showgoodsdiv">
  		<div class = "header">
  			
  			<div class="fl">
  				<div class="fl">
  					<a href="goods/selmore?mdid=1&bottomid=1"><img src="image/meishitp.png"></a>
  				</div>
  				<div class="fr">
  					<font size="4"><b>美食</b></font>
  				</div>
  			</div>
  			<div class="fr ljstyle">
  				<a href="goods/selmore?mdid=1&bottomid=17">自助餐</a> <font color="#797979">|</font>
  				<a href="goods/selmore?mdid=1&bottomid=1">西餐</a> <font color="#797979">|</font>
  				<a href="goods/selmore?mdid=1&bottomid=14">海鲜</a> <font color="#797979">|</font> 
  				<a href="goods/selmore?mdid=1&bottomid=1">全部</a>
  			</div>
  		</div>
  		
  		<div class="firsthen">
  			
  		</div>
  		<div class = "center">
	  		<div id="nav">
	  		<c:set var="meishii" value="0"></c:set>
	  			<c:forEach items="${meishigoods}" var="msgoods">
			  		<ul style="list-style-type:none" >
			    		<li style="width:25%;float:left">
			    			<table align="center" border="0" style="table-layout:fixed">
				    			<tr>
				    				<td colspan="2">
				    					<a href="goods/goodsxq?id=${msgoods.g_id }" target="_top"><img src="file/${msgoods.g_img }" width="260" height="150"></a>
				    				</td>
				    			</tr>
				    			<tr>
				    				<td colspan="2">
				    					<font size="4">${msgoods.g_name }</font>
				    				</td>
				    			</tr>
				    			<tr>
				    				<td colspan="2">
				    					<font size="3" color="#797979">
					    					<c:set var="testStr" value="${msgoods.g_dec}"></c:set>
									    	<c:choose>  
											    <c:when test="${fn:length(testStr) > 18}">  
											        <c:out value="${fn:substring(testStr, 0, 18)}..." />  
											    </c:when>  
											   <c:otherwise>  
											      <c:out value="${testStr}" />  
											    </c:otherwise>  
											</c:choose>
										</font> 
				    				</td>
				    			</tr>
				    			<tr height="35">
									<td><font color="OrangeRed" size="5">¥${msgoods.g_price }</font> <font color="#797979" size="3">门店价:<s>¥${msgoods.g_scj }</s></font></td>
									<td><font color="#797979" size="3">已售 ${msgoods.g_sale }</font>
									</td>
									
				    			</tr>
			    			</table>
			    		</li>
			    	</ul>
		    	</c:forEach>
	   		</div>
	  	</div>
  	</div>
  	<div class="secondhen">
  			
  	</div>
  	<!-- 休闲娱乐图标一些商品开始 -->
  	<div class = "showgoodsdiv">
  		<div class = "header">
  			
  			<div class="fl">
  				<div class="fl">
  					<a href="goods/selmore?mdid=5&bottomid=31"><img src="image/xiuxiantp.png"></a>
  				</div>
  				<div class="fr">
  					<font size="4"><b>休闲娱乐</b></font>
  				</div>
  			</div>
  			<div class="fr ljstyle">
  				<a href="goods/selmore?mdid=5&bottomid=31">足疗按摩</a> <font color="#797979">|</font>
  				<a href="goods/selmore?mdid=5&bottomid=32">温泉</a> <font color="#797979">|</font>
  				<a href="goods/selmore?mdid=5&bottomid=33">真人cs</a> <font color="#797979">|</font> 
  				<a href="goods/selmore?mdid=5&bottomid=31">全部</a>
  			</div>
  		</div>
  		
  		<div class="firsthen">
  			
  		</div>
  		<div class = "center">
	  		<div id="nav">
	  		<c:set var="meishii" value="0"></c:set>
	  			<c:forEach items="${xiuxianyule}" var="msgoods">
			  		<ul style="list-style-type:none" >
			    		<li style="width:25%;float:left">
			    			<table align="center" border="0" style="table-layout:fixed">
			    			<tr>
			    				<td colspan="2">
			    					<a href="goods/goodsxq?id=${msgoods.g_id }" target="_top"><img src="file/${msgoods.g_img }" width="260" height="150"></a>
			    				</td>
			    			</tr>
			    			<tr>
			    				<td colspan="2">
			    					<font size="4">${msgoods.g_name }</font>
			    				</td>
			    			</tr>
			    			<tr>
			    				<td colspan="2">
			    					<font size="3" color="#797979">
				    					<c:set var="testStr" value="${msgoods.g_dec}"></c:set>
								    	<c:choose>  
										    <c:when test="${fn:length(testStr) > 18}">  
										        <c:out value="${fn:substring(testStr, 0, 18)}..." />  
										    </c:when>  
										   <c:otherwise>  
										      <c:out value="${testStr}" />  
										    </c:otherwise>  
										</c:choose>
									</font> 
			    				</td>
			    			</tr>
			    			<tr height="35">
								<td><font color="OrangeRed" size="5">¥${msgoods.g_price }</font> <font color="#797979" size="3">门店价:<s>¥${msgoods.g_scj }</s></font></td>
								<td><font color="#797979" size="3">已售 ${msgoods.g_sale }</font>
								</td>
								
			    			</tr>
			    		</table>
			    		</li>
			    	</ul>
		    	</c:forEach>
	   		</div>
	  	</div>
  	</div>
  	
	<div class="secondhen">
  			
  	</div>
  	
  	<!-- 生活服务图标一些商品开始 -->
  	<div class = "showgoodsdiv">
  		<div class = "header">
  			
  			<div class="fl">
  				<div class="fl">
  					<a href="goods/selmore?mdid=7&bottomid=22"><img src="image/shenghuofuwutp.png"></a>
  				</div>
  				<div class="fr">
  					<font size="4"><b>生活服务</b></font>
  				</div>
  			</div>
  			<div class="fr ljstyle">
  				<a href="goods/selmore?mdid=7&bottomid=22">写真</a> <font color="#797979">|</font>
  				<a href="goods/selmore?mdid=7&bottomid=34">婚纱摄影</a> <font color="#797979">|</font>
  				<a href="goods/selmore?mdid=7&bottomid=36">培训课程</a> <font color="#797979">|</font> 
  				<a href="goods/selmore?mdid=7&bottomid=34">全部</a>
  			</div>
  		</div>
  		
  		<div class="firsthen">
  			
  		</div>
  		<div class = "center">
	  		<div id="nav">
	  		<c:set var="meishii" value="0"></c:set>
	  			<c:forEach items="${shfw}" var="msgoods">
			  		<ul style="list-style-type:none" >
			    		<li style="width:25%;float:left">
			    			<table align="center" border="0" style="table-layout:fixed">
				    			<tr>
				    				<td colspan="2">
				    					<a href="goods/goodsxq?id=${msgoods.g_id }" target="_top"><img src="file/${msgoods.g_img }" width="260" height="150"></a>
				    				</td>
				    			</tr>
				    			<tr>
				    				<td colspan="2">
				    					<font size="4">${msgoods.g_name }</font>
				    				</td>
				    			</tr>
				    			<tr>
				    				<td colspan="2">
				    					<font size="3" color="#797979">
					    					<c:set var="testStr" value="${msgoods.g_dec}"></c:set>
									    	<c:choose>  
											    <c:when test="${fn:length(testStr) > 18}">  
											        <c:out value="${fn:substring(testStr, 0, 18)}..." />  
											    </c:when>  
											   <c:otherwise>  
											      <c:out value="${testStr}" />  
											    </c:otherwise>  
											</c:choose>
										</font> 
				    				</td>
				    			</tr>
				    			<tr height="35">
									<td><font color="OrangeRed" size="5">¥${msgoods.g_price }</font> <font color="#797979" size="3">门店价:<s>¥${msgoods.g_scj }</s></font></td>
									<td><font color="#797979" size="3">已售 ${msgoods.g_sale }</font>
									</td>
									
				    			</tr>
			    			</table>
			    		</li>
			    	</ul>
		    	</c:forEach>
	   		</div>
	  	</div>
  	</div>
  
  	<div class="secondhen">
  			
  	</div>
  	
  	<!-- 购物图标一些商品开始 -->
  	<div class = "showgoodsdiv">
  		<div class = "header">
  			
  			<div class="fl">
  				<div class="fl">
  					<a href="goods/selmore?mdid=8&bottomid=23"><img src="image/gouwutp.png"></a>
  				</div>
  				<div class="fr">
  					<font size="4"><b>购物</b></font>
  				</div>
  			</div>
  			<div class="fr ljstyle">
  				<a href="goods/selmore?mdid=8?bottomid=23">女装</a> <font color="#797979">|</font>
  				<a href="goods/selmore?mdid=8?bottomid=24">男装</a> <font color="#797979">|</font>
  				<a href="goods/selmore?mdid=8?bottomid=28">食品</a> <font color="#797979">|</font> 
  				<a href="goods/selmore?mdid=8?bottomid=23">全部</a>
  			</div>
  		</div>
  		
  		<div class="firsthen">
  			
  		</div>
  		<div class = "center">
	  		<div id="nav">
	  		<c:set var="meishii" value="0"></c:set>
	  			<c:forEach items="${gowuu}" var="msgoods">
			  		<ul style="list-style-type:none" >
			    		<li style="width:25%;float:left">
			    			<table align="center" border="0" style="table-layout:fixed">
				    			<tr>
				    				<td colspan="2">
				    					<a href="goods/goodsxq?id=${msgoods.g_id }" target="_top"><img src="file/${msgoods.g_img }" width="260" height="150"></a>
				    				</td>
				    			</tr>
				    			<tr>
				    				<td colspan="2">
				    					<font size="4">${msgoods.g_name }</font>
				    				</td>
				    			</tr>
				    			<tr>
				    				<td colspan="2">
				    					<font size="3" color="#797979">
					    					<c:set var="testStr" value="${msgoods.g_dec}"></c:set>
									    	<c:choose>  
											    <c:when test="${fn:length(testStr) > 18}">  
											        <c:out value="${fn:substring(testStr, 0, 18)}..." />  
											    </c:when>  
											   <c:otherwise>  
											      <c:out value="${testStr}" />  
											    </c:otherwise>  
											</c:choose>
										</font> 
				    				</td>
				    			</tr>
				    			<tr height="35">
									<td><font color="OrangeRed" size="5">¥${msgoods.g_price }</font> <font color="#797979" size="3">门店价:<s>¥${msgoods.g_scj }</s></font></td>
									<td><font color="#797979" size="3">已售 ${msgoods.g_sale }</font>
									</td>
									
				    			</tr>
			    			</table>
			    		</li>
			    	</ul>
		    	</c:forEach>
	   		</div>
	  	</div>
  	</div>
  
  	<div class="secondhen">
  			
  	</div>
  	
  	<!-- 丽人图标一些商品开始 -->
  	  	<div class = "showgoodsdiv">
  		<div class = "header">
  			
  			<div class="fl">
  				<div class="fl">
  					<a href="goods/selmore?mdid=9&bottomid=26"><img src="image/lirentp.png"></a>
  				</div>
  				<div class="fr">
  					<font size="4"><b>丽人</b></font>
  				</div>
  			</div>
  			<div class="fr ljstyle">
  				<a href="goods/selmore?mdid=9&bottomid=26">美发</a> <font color="#797979">|</font>
  				<a href="goods/selmore?mdid=9&bottomid=27">瑜伽</a> <font color="#797979">|</font>
  				<a href="goods/selmore?mdid=9&bottomid=26">全部</a>
  			</div>
  		</div>
  		
  		<div class="firsthen">
  			
  		</div>
  		<div class = "center">
	  		<div id="nav">
	  		<c:set var="meishii" value="0"></c:set>
	  			<c:forEach items="${liren}" var="msgoods">
			  		<ul style="list-style-type:none" >
			    		<li style="width:25%;float:left">
			    			<table align="center" border="0" style="table-layout:fixed">
				    			<tr>
				    				<td colspan="2">
				    					<a href="goods/goodsxq?id=${msgoods.g_id }" target="_top"><img src="file/${msgoods.g_img }" width="260" height="150"></a>
				    				</td>
				    			</tr>
				    			<tr>
				    				<td colspan="2">
				    					<font size="4">${msgoods.g_name }</font>
				    				</td>
				    			</tr>
				    			<tr>
				    				<td colspan="2">
				    					<font size="3" color="#797979">
					    					<c:set var="testStr" value="${msgoods.g_dec}"></c:set>
									    	<c:choose>  
											    <c:when test="${fn:length(testStr) > 18}">  
											        <c:out value="${fn:substring(testStr, 0, 18)}..." />  
											    </c:when>  
											   <c:otherwise>  
											      <c:out value="${testStr}" />  
											    </c:otherwise>  
											</c:choose>
										</font> 
				    				</td>
				    			</tr>
				    			<tr height="35">
									<td><font color="OrangeRed" size="5">¥${msgoods.g_price }</font> <font color="#797979" size="3">门店价:<s>¥${msgoods.g_scj }</s></font></td>
									<td><font color="#797979" size="3">已售 ${msgoods.g_sale }</font>
									</td>
									
				    			</tr>
			    			</table>
			    		</li>
			    	</ul>
		    	</c:forEach>
	   		</div>
	  	</div>
  	</div>
  
  	<div class="secondhen">
  			
  	</div>
  	<br>
  	<br>
  	<br>
  </body>
</html>
