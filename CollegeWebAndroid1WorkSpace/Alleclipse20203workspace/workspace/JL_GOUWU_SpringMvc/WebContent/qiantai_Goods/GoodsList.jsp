<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>${bottom }-JERRY网</title>
<style>
.top p {
	background: #FFFFE0;
	width: 100%
}

#topziti {
	font-size: 13px
}

a {
	text-decoration: none;
	color: #4b4b4b
}

a:hover {
	color: #95361A
}

#topuser a:hover {
	border-style: solid;
	border-width: 1px;
	border-top-color: #f8f8f8;
	border-bottom-color: #666666;
	border-right-color: #f8f8f8;
	border-left-color: #f8f8f8;
	background-color: #f8f8f8;
	height: 0px;
	width: 60px;
}

.toptablestyle {
	border-style: solid;
	border-width: 1px;
	border-top-color: #ebebeb;
	border-bottom-color: #f8f8f8;
	border-right-color: #f8f8f8;
	border-left-color: #f8f8f8;
	background-color: #f8f8f8;
	height: 0px;
	width: 1445px;
}

.toptext {
	font-size: 23px
}

#topfoot a {
	text-decoration: none;
	color: white
}

.topxuanze {
	border-style: solid;
	border-width: 1px;
	border-top-color: #008080;
	border-bottom-color: #008080;
	border-right-color: #008080;
	border-left-color: #008080;
	background-color: #008080;
	height: 48px;
	width: 100px;
}

.topxuanze:hover {
	border-style: solid;
	border-width: 1px;
	border-top-color: #165A59;
	border-bottom-color: #165A59;
	border-right-color: #165A59;
	border-left-color: #165A59;
	background-color: #165A59;
	height: 48px;
	width: 100px;
}

.topljtablestyle {
	
}
#nav{
width: 100%;
margin: 0;
padding:0;
}
#nav ul {
	margin: 0;
	width: 100%;
}

#box_relative {
	position: relative;
	left: 100px;
	top: 100px;
}

#wrap {
	height: 50px;
	display: table;
}

#content {
	vertical-align: middle;
	display: table-cell;
}
</style>
<style>
a {
	text-decoration: none;
	color: #4b4b4b;
	cursor: pointer;
}

a:hover {
	text-decoration: none;
	color: #95361A;
	cursor: pointer;
}

body {
	margin: 0;
	padding: 0;
}

div {
	margin: 0 auto;
}

.fl {
	float: left;
}

.fr {
	float: right;
}

form {
	margin: 0;
	padding: 0;
}
/*---------------header---------------*/
.soubg {
	width: 100%;
	min-width: 1000px;
	height: 42px;
	background-color: #f8f8f8;
	clear: both;
	font-size:13px;
}

.sou {
	width: 1000px;
	height: 42px;
	line-height: 42px;
}

.s_city_b {
	width: 370px;
	height: 35px;
	float: left;
}

.s_city {
	height: 35px;
	float: left;
	padding-left: 15px;
	cursor: pointer;
	position: relative;
}

.s_rightpadding {
	padding-right: 30px;
}

.divone {
	width: 100%;
	min-width: 1000px;
	height: 105px;
	clear: both;
	margin-top: 30px;
}
.imgdivone {
	width: 100%;
	min-width: 1000px;
	height: 105px;
	clear: both;
	margin-top: 10px;
}
.divtwo {
	width: 1000px;
	height: 105px;
	line-height: 105px;
}

.divtwoimg {
	width: 320px;
	float: left;
	padding-bottom: 20px;
}

.divtwoinput {
	float: left;
	padding-top:  15px;
	padding-left: 15px;
}

.divshouyeone {
	width: 100%;
	min-width: 1000px;
	height: auto;
	clear: both;
	margin-top: 20px;
}

.divshouyetwo {
	width: 1000px;
	clear: both;
}

.firsthen {
	clear: both;
	float: left;
	border-style: solid;
	border-width: 1px;
	border-top-color: #ebebeb;
	border-bottom-color: #f8f8f8;
	border-right-color: #f8f8f8;
	border-left-color: #f8f8f8;
	width: 1000px;
	margin-top: 20px;
}
.divgoodsleft {
	width: 76%;
	height: auto;
	float: left;
}
.divgoodsggright {
	width: 24%;
	height: auto;
	float: right;
}
</style>
</head>

<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
	<div class="soubg">
		<div class="sou">
			<span class="s_city_b"> <span class="fl"><a
					href="javascript:void(0);"
					onclick="AddFavorite('http://localhost:8080/JL_GOUWU_SpringMvc/qiantai_main/main.jsp','杰瑞购物网');">
						收藏Jerry网</a></span> <c:if test="${jruser==null}">
					<span class="s_city"> <span><a
							href="qiantai_admin/login.jsp" target="_top"><font
								color="red">登录</font></a></span>
					</span>
					<span class="s_city"> <span><a
							href="qiantai_admin/zhuce.jsp" target="_top">注册</a></span>
					</span>
				</c:if> <c:if test="${jruser!=null }">
					<span class="s_city"> <span>欢迎您,亲爱的<font color="red">${jruser.uname  }</font>&nbsp;<a
							href="index/deljruser" target="_top">退出</a></span>
					</span>
				</c:if>
			</span> <span class="fr s_rightpadding"> <span class="fl">
					&nbsp;&nbsp; <c:if test="${jruser!=null}">
						<a href="index/selorders" target="_top">我的订单</a>
					</c:if> <c:if test="${jruser==null}">
						<a href="qiantai_admin/login.jsp" target="_top">我的订单</a>
					</c:if> &nbsp;&nbsp;|
			</span> <span class="fl">&nbsp;&nbsp;<a href="#">我的Jerry</a>&nbsp;&nbsp;|
			</span> <span class="fl">&nbsp;&nbsp;<a href="#">最近浏览</a>&nbsp;&nbsp;|
			</span> <span class="fl"> &nbsp;&nbsp; <a
					href="qiantai_sel/GoodsGouWuChe.jsp" target="_blank"> 购物车<font
						color="red">${chartcount }</font>件
				</a> &nbsp;&nbsp;|
			</span> <span class="fl">&nbsp;&nbsp;<a href="#">联系客服</a>&nbsp;&nbsp;|
			</span> <span class="fl">&nbsp;&nbsp;<a
					href="http://www.360kan.com/ct/OULlcM7lLICuDj.html" target="_blank">多来看看我</a>&nbsp;&nbsp;
			</span>
			</span>
		</div>
	</div>

	<div class="imgdivone">
		<div class="divtwo">
			<form action="goods/selxsgoods" target="_blank" name="frm"
				method="post">
				<span class="divtwoimg"> <span class="fl"> 
						<img src="image/zhuti.png"  height="105" width="85">
						<font size="3" color="#95361A"></font>
				</span>
				</span> <span class="divtwoinput"> <span class="fl"> <input
						type="text" name="uname" style="width: 300px; height: 28px;">
						<input type="submit" value="搜索" style="width: 50px; height: 28px;">
				</span>
				</span>
			</form>
		</div>
	</div>
	<!-- 头部开始 -->
	<div class="divshouyeone">
		<div class="divshouyetwo">
			<table width="100%" bgcolor="#008080" border=0
				style="margin-top: 1px;">
				<tr align="center">
					<td width="5%">
						<div id="topfoot" class="topxuanze">
							<div id="wrap">
								<div id="content" class="toptext">
									<a href="qiantai_main/main.jsp" target="_top">首页</a>
								</div>
							</div>
						</div>
					</td>
					<td width="13%">
						<div id="topfoot" class="topxuanze">
							<div id="wrap">
								<div id="content" class="toptext">
									<a>今日新单</a>
								</div>
							</div>
						</div>
					</td>
					<td width="13%">
						<div id="topfoot" class="topxuanze">
							<div id="wrap">
								<div id="content" class="toptext">
									<a href="goods/selmore?mdid=8&bottomid=23" target="_top">购物</a>
								</div>
							</div>
						</div>
					</td>
					<td width="13%">
						<div id="topfoot" class="topxuanze">
							<div id="wrap">
								<div id="content" class="toptext">
									<a>热销商品</a>
								</div>
							</div>
						</div>
					</td>
					<td>
						<div id="topfoot" class="topxuanze">
							<div id="wrap">
								<div id="content" class="toptext">&nbsp;</div>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 头部结束 -->
	<!-- 位置开始 -->
	<div class="divshouyeone">
		<div class="divshouyetwo">
			<div class="fl">
				<font size="3" color="red">
					位置:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font> <font size="3"
					color="#797979"> ${mold } » ${bottom } </font>
			</div>
		</div>
	</div>
	<div class="divshouyeone">
		<div class="divshouyetwo">
			<div class="firsthen"></div>
		</div>
	</div>
	<!-- 位置结束 -->

	<!-- 相关分类开始 -->
	<div class="divshouyeone">
		<div class="divshouyetwo">
			<div class="fl">
				<table width="100%" border=0 align="center">
					<!-- 去更多需要保存类型id -->
					<tr>
						<td class="topljcolor">
							<div class="topljtablestyle">
								<div id="wrap">
									<div id="content">
										<font size="3" color="red"> 相关分类:&nbsp;&nbsp;</font><font
											size="3"> <c:forEach items="${list}" var="lists">
												<a
													href="goods/selmore?mdid=${moldid}&bottomid=${lists.bottom_id}"
													target="_top">${lists.bottom }</a>&nbsp;&nbsp;
											</c:forEach>
										</font>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="divshouyeone">
		<div class="divshouyetwo">
			<div class="firsthen"></div>
		</div>
	</div>
	<!-- 相关分类结束 -->

	<!-- 商品开始 -->
	<div class="divshouyeone">
		<div class="divshouyetwo top">
			<p class="">
				<img src="image/3.png"><font size="2" color="#6666">即日起,凡购买商品者可得签名照一张</font>
			</p>
		</div>
	</div>
	
	<div class="divshouyeone">
		<div class="divshouyetwo">
			<div class="divgoodsleft">
				<div id="nav">
					<ul style="list-style-type: none;margin:0px;padding:0px">
						<c:forEach items="${goodslist}" var="list">
							<li style="width: 45%; float: left;margin-left:25px">
								<table align="center" border="0" style="table-layout: fixed">
									<tr>
										<td colspan="2"><a
											href="goods/goodsxq?id=${list.g_id }" target="_top"><img
												src="file/${list.g_img }" width="350" height="250"></a></td>
									</tr>
									<tr>
										<td colspan="2"><font size="4">${list.g_name }</font></td>
									</tr>
									<tr>
										<td colspan="2"><font size="3" color="#797979"> <c:set
													var="testStr" value="${list.g_dec}"></c:set> <c:choose>
													<c:when test="${fn:length(testStr) > 22}">
														<c:out value="${fn:substring(testStr, 0, 22)}..." />
													</c:when>
													<c:otherwise>
														<c:out value="${testStr}" />
													</c:otherwise>
												</c:choose>
										</font></td>
									</tr>
									<tr>
										<td><font color="OrangeRed" size="5">¥${list.g_price }</font>
											<font color="#797979" size="3">门店价:<s>¥${list.g_scj }</s></font></td>
										<td><font color="#797979" size="3">已售 ${list.g_sale }</font></td>
									</tr>
								</table>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="divgoodsggright">
				<!-- 图片开始 -->
				<c:if test="${size!=0}">
					
						<img src="image/guanggao1.png">
						<img src="image/youbiangg.png">
				</c:if>
				<!-- 图片结束 -->
			</div>
		</div>
	</div>
	<!-- 商品结束 -->

	<!-- 分页开始 -->
	<div class="divshouyeone">
		<div class="divshouyetwo top">
			<c:if test="${size!=0}">
				<form action="goods/selmore?id=${goods.g_id}" method="post">
					<table width="68%" align="center" border=0 cellspacing="0">
						<tr align="left" height="50">
							<td><font color="#008080"> <a
									href="goods/selmore?mdid=${moldid}&bottomid=${bottomid}&currp=1">首页</a>
									<a
									href="goods/selmore?mdid=${moldid}&bottomid=${bottomid}&currp=${currPage-1 }">上一页</a>
		
									<c:forEach begin="${currPage}" end="${currPage+2}" var="i"
										step="1">
										<c:if test="${i<=totalPage}">
											<a
												href="goods/selmore?mdid=${moldid}&bottomid=${bottomid}&currp=${i }">${i }</a>
										</c:if>
									</c:forEach> <a
									href="goods/selmore?mdid=${moldid}&bottomid=${bottomid}&currp=${currPage+1}">下一页</a>
									<a
									href="goods/selmore?mdid=${moldid}&bottomid=${bottomid}&currp=${totalPage}">尾页</a>
									跳转到<input type="text" size=3 id="tx1" value="${currPage}"><input
									type="button" value="GO" onclick="fangfa();"> 当前页为 <font
									color="red">${currPage}</font>/<font color="red">${totalPage }</font>
							</font></td>
						</tr>
					</table>
				</form>
				
			</c:if>
		</div>
	</div>
	


	<!-- 分页结束 -->


	<!-- 空的商品 -->
	<c:if test="${size==0}">
		<table width="68%" align="center">
			<tr>
				<td>
					<h1>对不起!当前分类暂无商品,请查看其它分类</h1>
				</td>
			</tr>
		</table>

	</c:if>

	<!-- 空的相似商品 -->
	<c:if test="${listsize==0}">
		<table width="68%" align="center">
			<tr>
				<td>
					<h1>对不起!未找到商品,请重新搜索</h1>
				</td>
			</tr>
		</table>

	</c:if>
	<script>
		function fangfa() {
			var page = document.getElementById("tx1").value;
			if (isNaN(page)) {
				alert("请输入正确的数字");
				document.getElementById("tx1").value = "";
				document.getElementById("tx1").focus();
			} else {
				location.href = "goods/selmore?mdid=${moldid}&bottomid=${bottomid}&currp="
						+ page;
			}
		}
	</script>
	<script>
		document.frm.uname.focus();
		function AddFavorite(sURL, sTitle) {
			try {
				window.external.addFavorite(sURL, sTitle);
			} catch (e) {
				try {
					window.sidebar.addPanel(sTitle, sURL, "");
				} catch (e) {
					alert("对不起当前浏览器不支持,加入收藏失败,请使用Ctrl+D进行添加");
				}
			}
		}
	</script>
</body>
</html>
