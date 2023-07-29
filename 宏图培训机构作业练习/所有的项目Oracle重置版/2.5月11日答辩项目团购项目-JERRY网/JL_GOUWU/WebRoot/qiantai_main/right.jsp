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
    
    <title>My JSP 'top.jsp' starting page</title>
	<style>
		#yksgoodsname a{text-decoration: none;color: #008080}
		#yksgoodsname a:hover{text-decoration: none;color: OrangeRed}
		img.curzuo{cursor:url(image/zuo.jpg), url("image/zou.jpg"),auto;}
		img.curyou{cursor:url(image/you.jpg), url("image/you.jpg"),auto;}
		#nav ul {margin:0;padding-left:20px;width:720px}
		#selmored a{text-decoration: none;color: #797979;margin-top:200px;}
		#selmored a:hover{text-decoration: none;color: #CED48A}
		.top p{background:#ffd7d7;margin-left:22px;width:700px;height:20px}
		.toptext{font-size:23px}
		#topfoot a{text-decoration: none;color: white}
		.topljcolor a{text-decoration: none;color:#797979}
		.topljcolor a:hover{text-decoration: none;color:#CED48A}
		.topshouye{
			border-style:solid; 
			border-width:1px;
			border-top-color:#008080;
			border-bottom-color:#008080;
			border-right-color:#008080;
			border-left-color:#008080;
			background-color:#008080;
			height:48px;
			width:70px;
			
		}
		.topshouye:hover{
			border-style:solid; 
			border-width:1px;
			border-top-color:#165A59;
			border-bottom-color:#165A59;
			border-right-color:#165A59;
			border-left-color:#165A59;
			background-color:#165A59;
			height:48px;
			width:90px;
			
		}
		.topxuanze{
			border-style:solid; 
			border-width:1px;
			border-top-color:#008080;
			border-bottom-color:#008080;
			border-right-color:#008080;
			border-left-color:#008080;
			background-color:#008080;
			height:48px;
			width:150px;
			
		}
		.topxuanze:hover{
			border-style:solid; 
			border-width:1px;
			border-top-color:#165A59;
			border-bottom-color:#165A59;
			border-right-color:#165A59;
			border-left-color:#165A59;
			background-color:#165A59;
			height:48px;
			width:150px;
			
		}
		.topljtablestyle{
			border-style:solid; 
			border-width:1px;
			border-top-color:#fefefe;
			border-bottom-color:#ebebeb;
			border-right-color:#fefefe;
			border-left-color:#fefefe;
			background-color:#fefefe;
			height:50px;
			width:700px;
		}
		.centerbottomstyle{
			border-style:solid; 
			border-width:1px;
			border-top-color:#fefefe;
			border-bottom-color:#ebebeb;
			border-right-color:#fefefe;
			border-left-color:#fefefe;
			background-color:#fefefe;
			height:1px;
			width:700px;
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
  
  <body style="margin:0;padding:0px">
	<table width="100%" bgcolor="#008080" border=0 style="margin-top: 1px;">
		<tr align="center">
			<td width="100">
				<div id="topfoot" class="topshouye">
    				<div id="wrap">
  					<div id="content" class="toptext">
					<a href="qiantai_main/main.jsp" target="_top">首页</a>
					</div>
					</div>
				</div>
			</td>
			<td width="120">
				<div id="topfoot" class="topxuanze">
    				<div id="wrap">
  					<div id="content" class="toptext">
					<a href="#" onclick="location.reload()">今日新单</a>
					</div>
					</div>
				</div>
			</td>
			<td width="120">
				<div id="topfoot" class="topxuanze">
    				<div id="wrap">
  					<div id="content" class="toptext">
						<a href="goods?method=qtlist&moldid=8" target="main">购物</a>
					</div>
					</div>
				</div>
			</td>
			<td width="120">
				<div id="topfoot" class="topxuanze">
    				<div id="wrap">
  					<div id="content" class="toptext">
					<a href="#" onclick="location.reload()">热销商品</a>
					</div>
					</div>
				</div>
			</td>
		</tr>
	</table>
	<!-- 这里就是类型的分类,可以挑一些 链接固定的 传的id是类型moldid-->
	<!-- 热门分类开始 -->
	<table width="95%" border=0 align="center">
		<tr height="50">
			<td  class="topljcolor">
				<div class="topljtablestyle">
					<div id="wrap">
  						<div id="content">
							<font size="2" color="red">
								热门分类:&nbsp;&nbsp;&nbsp;&nbsp;</font><font size="2">
								<a href="goods?method=threeqtlist&id=5&moldid=1">西餐</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="goods?method=threeqtlist&id=9&moldid=1">火锅</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="goods?method=threeqtlist&id=10&moldid=7">美发</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="goods?method=threeqtlist&id=18&moldid=4">真人cs</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="goods?method=threeqtlist&id=16&moldid=4">足疗按摩</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="goods?method=threeqtlist&id=21&moldid=5">个性写真</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="goods?method=threeqtlist&id=27&moldid=6">食品</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="goods?method=threeqtlist&id=14&moldid=1">香锅烤鱼</a>&nbsp;&nbsp;&nbsp;&nbsp;
							</font>
						</div>
					</div>
				</div>
			</td>
		</tr>	
	</table>
	<!-- 热门分类结束 -->

	<!-- 当前分类开始 -->
	<table width="95%" border=0 align="center">
	<c:if test="${list!=null}">
	<!-- 去更多需要保存类型id -->
		<tr>
			<td class="topljcolor">
				<div class="topljtablestyle">
					<div id="wrap">
  						<div id="content" >
							<font size="2" color="red">
								当前分类:&nbsp;&nbsp;&nbsp;&nbsp;</font><font size="2">
								<c:forEach items="${list}" var="lists">
									<a href="goods?method=threeqtlist&id=${lists.bottom_id }&moldid=${lists.mold_id }">${lists.bottom }</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</c:forEach>
							</font>
						</div>
					</div>
				</div>
			</td>
		</tr>		
	</c:if>
	</table>
	<!-- 当前分类结束 -->
	
	<!-- 推荐开始 -->
	<c:if test="${list==null}">
	<table width="95%" border=0 align="center">
		<tr>
			<td class="topljcolor">
				<div class="topljtablestyle">
					<div id="wrap">
  						<div id="content" >
							<font size="2" color="red"><font size="2">
								友情提示:&nbsp;&nbsp;&nbsp;&nbsp;</font><font size="2" color="#797979">
								以下为推荐商品,想指定请点分类击左侧
							</font>
						</div>
					</div>
				</div>
			</td>
		</tr>		
	</table>
	</c:if>
	<!-- 推荐结束 -->
	
	<!-- 商品开始 MD一个空格都不能多-->
	<!-- 判断是右还是左 -->
	<c:set var="zuoyoucount" value="0">
	
	</c:set>
	<c:if test="${goodslist!=null}">
	<div class="top">
  		<p><img src="image/3.png"><font size="2" color="#6666">即日起,凡购买商品者可得签名照一张</font></p><!-- 这个以后放后面吧 -->
  	</div>
  	<!-- div id="nav"	距离页面的距离 这个样式先放放 #nav ul {margin:0;padding-left:27px;margin-top:50px; margin-left:90px;}-->
  	<div id="nav">	
  	
  	<ul style="list-style-type:none" >
    	<c:forEach items="${goodslist}" var="goodslists">
    		<li style="width:50%;float:left">
    		<table border="0" style="table-layout:fixed">
    			<tr>
    				<td colspan="2">
   						<c:set var="zuoyoucount" value="${zuoyoucount+1}"></c:set>
   						<!-- 为了区分开来 一个是一开始的商品一个是分类的商品 -->
   						<c:if test="${currPage>0}">
						<!-- 一开始的商品去的是分页 -->
   							<c:if test="${zuoyoucount%2==0}">
   								<a href="goods?method=selstartshouyegoods&currp=${currPage+1 }"><img src="file/${goodslists.g_img }" width="340" height="263" class='curyou' ></a>
   							</c:if>
   							
   							<c:if test="${zuoyoucount%2==1}">
   								<a href="goods?method=selstartshouyegoods&currp=${currPage-1 }"><img src="file/${goodslists.g_img }" width="340" height="263" class='curzuo'></a>
   							</c:if>
   							
   						</c:if>
   						
   						<c:if test="${currPage==null}">
   						<!-- 分类的商品 -->
   							<a href="goods?method=goodsxq&id=${goodslists.g_id }" target="_blank"><img src="file/${goodslists.g_img }" width="340" height="240"></a>		
   						</c:if>
    				</td>
    			</tr>
    			<tr height="30">
    				<td>
    				<!-- 点击商品名字进入商品详细判断是否为一开始的商品 -->
    				<c:if test="${currPage>0}">
    					<div id="yksgoodsname">
	    					<a href="goods?method=goodsxq&id=${goodslists.g_id }" target="_blank">
	    						<font size="4">${goodslists.g_name }</font>
	    					</a>
    					</div>
    				</c:if>
    				<c:if test="${currPage==null}">
    					<font size="4">${goodslists.g_name }</font>
    				</c:if>
    				</td>
    				<td rowspan="2" align="right">
    					<font color="OrangeRed" size="5">￥${goodslists.g_price }</font>
    				</td>
    			</tr>
    			<tr height="30">
    				<td>
    					<font size="3" color="#797979">
	    					<c:set var="testStr" value="${goodslists.g_dec}"></c:set>
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
    		</table>
    		</li>
    	</c:forEach>
    	<li style="width:50%;float:left " >
    	<!-- 分类去更多 -->
	    	<c:if test="${goodssize>0}">
	  			<div id="selmored" style="margin-top:5px;">
	  				<a href="goods?method=selmore&mdid=${moldid}&bottomid=${bottomid}" target="_blank">查看更多</a>
	  			</div>
	 		</c:if>
    	</li>
    </ul>
    </div>
  	</c:if>	
 
  	<!-- 一条横线 -->
	<table width="95%" border=0 align="center" style="margin-top:5px">
		<tr>
			<td>
				<div class="centerbottomstyle">
					<div id="wrap">
  						<div id="content" >
							&nbsp;
						</div>
					</div>
				</div>
			</td>
		</tr>		
	</table>
	<!-- 当前分类结束 -->
  <!-- 商品结束 -->
  

  <!-- 底部图片结束 -->
  </body>
</html>
