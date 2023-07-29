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
		#nav ul {margin:0;padding-left:0px;width:1170px}
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
	</style>
  </head>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"> 
  	<iframe src="qiantai_main/main2.jsp" style="width:100%;height:750px;border:0px" ></iframe>
  	<br>
  	<!-- 美食图标一些商品开始 -->
  	<table border=0 width="87%" align="center">
  		<tr>
  			<td >
	  			<div style="position:relative;">
	  				<a href="goods?method=selmore&mdid=1&bottomid=1"><img src="image/meishitp.png"></a>
	  				<div style="position:absolute; z-index:2; left:42px; top:9px">
	  					<font size="4"><b>美食</b></font>
	  				</div>
  				</div>
  			</td>
  			<td width="26%" class="ljstyle">
  				<a href="goods?method=selmore&mdid=1&bottomid=8">自助餐</a> <font color="#797979">|</font>
  				<a href="goods?method=selmore&mdid=1&bottomid=5">西餐</a> <font color="#797979">|</font>
  				<a href="goods?method=selmore&mdid=1&bottomid=2">海鲜</a> <font color="#797979">|</font> 
  				<a href="goods?method=selmore&mdid=1&bottomid=1">全部</a>
  			</td>
  		</tr>
  	</table>
  	
  	<div style="margin-left:100px;">
  		<div id="nav">
  		<!-- 横线 -->
  		<div class="brhengxiang">
  		</div>
  		<br>
  		<c:set var="meishii" value="0"></c:set>
  		<c:forEach items="${meishigoods}" var="msgoods">
  		<ul style="list-style-type:none" >
    		<li style="width:25%;float:left">
    			<table align="center" border="0" style="table-layout:fixed">
    			<tr>
    				<td colspan="2">
    					<a href="goods?method=goodsxq&id=${msgoods.g_id }" target="_top"><img src="file/${msgoods.g_img }" width="260" height="150"></a>
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
  	
  	<!-- 横线 -->
  	<div class="brhengxiang" style="margin-left:100px;margin-top:460px">
  	
  	</div>
  	<br>
  	<!-- 休闲娱乐图标一些商品开始 -->
  	<table border=0 width="87%" align="center">
  		<tr>
  			<td >
	  			<div style="position:relative;">
	  				<a href="goods?method=selmore&mdid=4&bottomid=16"><img src="image/xiuxiantp.png"></a>
	  				<div style="position:absolute; z-index:2; left:42px; top:9px">
	  					<font size="4"><b>休闲娱乐</b></font>
	  				</div>
  				</div>
  			</td>
  			<td width="26%" class="ljstyle">
  				<a href="goods?method=selmore&mdid=4&bottomid=16">足疗按摩</a> <font color="#797979">|</font>
  				<a href="goods?method=selmore&mdid=4&bottomid=19">温泉</a> <font color="#797979">|</font>
  				<a href="goods?method=selmore&mdid=4&bottomid=18">真人cs</a> <font color="#797979">|</font> 
  				<a href="goods?method=selmore&mdid=4&bottomid=16">全部</a>
  			</td>
  		</tr>
  	</table>
  	
  	  	<div style="margin-left:100px;">
  		<div id="nav">
  		<!-- 横线 -->
  		<div class="brhengxiang">
  		</div>
  		<br>
  		<c:set var="meishii" value="0"></c:set>
  		<c:forEach items="${xiuxianyule}" var="msgoods">
  		<ul style="list-style-type:none" >
    		<li style="width:25%;float:left">
    			<table align="center" border="0" style="table-layout:fixed">
    			<tr>
    				<td colspan="2">
    					<a href="goods?method=goodsxq&id=${msgoods.g_id }" target="_top"><img src="file/${msgoods.g_img }" width="260" height="150"></a>
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
  	
  	<!-- 横线 -->
  	<div class="brhengxiang" style="margin-left:100px;margin-top:250px">
  	
  	</div>
  	
  	<!-- 生活服务图标一些商品开始 -->
  	<table border=0 width="87%" align="center">
  		<tr>
  			<td >
	  			<div style="position:relative;">
	  				<a href="goods?method=selmore&mdid=5&bottomid=21"><img src="image/shenghuofuwutp.png"></a>
	  				<div style="position:absolute; z-index:2; left:42px; top:9px">
	  					<font size="4"><b>生活服务</b></font>
	  				</div>
  				</div>
  			</td>
  			<td width="30%" class="ljstyle">
  				<a href="goods?method=selmore&mdid=5&bottomid=21">写真</a> <font color="#797979">|</font>
  				<a href="goods?method=selmore&mdid=5&bottomid=22">婚纱摄影</a> <font color="#797979">|</font>
  				<a href="goods?method=selmore&mdid=5&bottomid=23">培训课程</a> <font color="#797979">|</font> 
  				<a href="goods?method=selmore&mdid=5&bottomid=21">全部</a>
  			</td>
  		</tr>
  	</table>
  	
  	  	<div style="margin-left:100px;">
  		<div id="nav">
  		<!-- 横线 -->
  		<div class="brhengxiang">
  		</div>
  		<br>
  		<c:set var="meishii" value="0"></c:set>
  		<c:forEach items="${shfw}" var="msgoods">
  		<ul style="list-style-type:none" >
    		<li style="width:25%;float:left">
    			<table align="center" border="0" style="table-layout:fixed">
    			<tr>
    				<td colspan="2">
    					<a href="goods?method=goodsxq&id=${msgoods.g_id }" target="_top"><img src="file/${msgoods.g_img }" width="260" height="150"></a>
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
  	
  	<!-- 横线 -->
  	<div class="brhengxiang" style="margin-left:100px;margin-top:250px">
  	
  	</div>
  	
  	<!-- 购物图标一些商品开始 -->
  	<table border=0 width="87%" align="center">
  		<tr>
  			<td >
	  			<div style="position:relative;">
	  				<a href="goods?method=selmore&mdid=6&bottomid=28"><img src="image/gouwutp.png"></a>
	  				<div style="position:absolute; z-index:2; left:42px; top:9px">
	  					<font size="4"><b>购物</b></font>
	  				</div>
  				</div>
  			</td>
  			<td width="23%" class="ljstyle">
  				<a href="goods?method=selmore&mdid=6&bottomid=26">女装</a> <font color="#797979">|</font>
  				<a href="goods?method=selmore&mdid=6&bottomid=25">男装</a> <font color="#797979">|</font>
  				<a href="goods?method=selmore&mdid=6&bottomid=27">食品</a> <font color="#797979">|</font> 
  				<a href="goods?method=selmore&mdid=6&bottomid=28">全部</a>
  			</td>
  		</tr>
  	</table>
  	
  	  	<div style="margin-left:100px;">
  		<div id="nav">
  		<!-- 横线 -->
  		<div class="brhengxiang">
  		</div>
  		<br>
  		<c:set var="meishii" value="0"></c:set>
  		<c:forEach items="${gowuu}" var="msgoods">
  		<ul style="list-style-type:none" >
    		<li style="width:25%;float:left">
    			<table align="center" border="0" style="table-layout:fixed">
    			<tr>
    				<td colspan="2">
    					<a href="goods?method=goodsxq&id=${msgoods.g_id }" target="_top"><img src="file/${msgoods.g_img }" width="260" height="150"></a>
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
  	
  	<!-- 横线 -->
  	<div class="brhengxiang" style="margin-left:100px;margin-top:250px">
  	
  	</div>
  	
  	<!-- 丽人图标一些商品开始 -->
  	<table border=0 width="87%" align="center">
  		<tr>
  			<td >
	  			<div style="position:relative;">
	  				<a href="goods?method=selmore&mdid=7&bottomid=11"><img src="image/lirentp.png"></a>
	  				<div style="position:absolute; z-index:2; left:42px; top:9px">
	  					<font size="4"><b>丽人</b></font>
	  				</div>
  				</div>
  			</td>
  			<td width="23%" class="ljstyle">
  				<a href="goods?method=selmore&mdid=7&bottomid=10">美发</a> <font color="#797979">|</font>
  				<a href="goods?method=selmore&mdid=7&bottomid=11">瑜伽</a> <font color="#797979">|</font>
  				<a href="goods?method=selmore&mdid=7&bottomid=11">全部</a>
  			</td>
  		</tr>
  	</table>
  	
  	  	<div style="margin-left:100px;">
  		<div id="nav">
  		<!-- 横线 -->
  		<div class="brhengxiang">
  		</div>
  		<br>
  		<c:set var="meishii" value="0"></c:set>
  		<c:forEach items="${liren}" var="msgoods">
  		<ul style="list-style-type:none" >
    		<li style="width:25%;float:left">
    			<table align="center" border="0" style="table-layout:fixed">
    			<tr>
    				<td colspan="2">
    					<a href="goods?method=goodsxq&id=${msgoods.g_id }" target="_top"><img src="file/${msgoods.g_img }" width="260" height="150"></a>
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
  	
  	<!-- 横线 -->
  	<div class="brhengxiang" style="margin-left:100px;margin-top:250px">
  	
  	</div>
  	
  	<br>
  	<br>
  	<br>
  </body>
</html>
