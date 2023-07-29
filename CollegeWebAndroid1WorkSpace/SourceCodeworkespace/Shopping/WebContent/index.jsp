<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.zuxia.dao.BulletinDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.zuxia.model.BulletinInfo"%>
<%@page import="com.zuxia.util.StringUtil"%>
<%@page import="com.zuxia.util.DateTimeUtil"%>
<%@page import="com.zuxia.dao.GoodsTypeDao"%>
<%@page import="com.zuxia.model.GoodsType"%>
<%@page import="com.zuxia.model.GoodsInfo"%>
<%@page import="com.zuxia.dao.GoodsInfoDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		out.println("<base href=\""+basePath+"\">");
		%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>在线销售旅游用品 登山攀岩器材、户外服装、户外桌椅、睡袋垫子、野营用品、野营帐篷、运动手表...</title>
<style type="text/css">
body{text-align:center;margin:0px;}
#middle_div{width:980px;text-align:left;margin-left:auto;margin-right:auto;}

/*中部-左边产品导航*/
#middle_left_div{float:left;width:280px;}
#gonggao{border:1px solid #CCE3F1;margin-bottom:3px;padding-bottom:3px;height:155px;}
#gonggao div.title{float:left;background:url(images/gonggao.gif) no-repeat 3px 50% #fff;text-indent:30px;padding:10px 3px 3px 3px;color:#2F85EF;font-weight:bold;}
#gonggao div.more{float:right;padding:10px 3px 3px 3px;}
#gonggao div.more a{border:0px;background-image:none;}
#gonggao a{clear:both;display:block;text-decoration:none;text-align:left;color:#4B8ECE;padding:3px;text-indent:14px;font-size:10pt;border-bottom:1px dashed #CCE3F1;background:url(images/dot.png) no-repeat 8px 5px #fff;}
#gonggao a:hover{border-bottom:1px dashed #E5F0F3;color:#FE8802;background:url(images/dot.jpg) no-repeat 8px 5px #fff;}
#gonggao a span{color:#9D9898;padding-left:20px;}

#product_daohang{border:1px solid #CCE3F1;padding:3px;}
#product_daohang .product_title{text-align:left;color:#2F85EF;margin:0px;padding:3px;font-weight:bold;background:url(images/daohang.png) no-repeat left center #fff;text-indent:27px;}
#product_daohang table{clear:both;border-collapse:collapse;margin-top:3px;}
#product_daohang table .title{font-size:11pt;font-weight:bold;padding:10px 3px 10px 3px;font-family:'宋体';line-height:120%;width:20px;}
#product_daohang table a{display:block;text-decoration:none;text-align:left;color:#4B8ECE;padding:3px;text-indent:10px;font-size:10pt;border-bottom:1px dashed #fff;}
#product_daohang table a.more{text-align:right;padding-right:1em;}

#product_daohang .left_box_normal{border:1px solid #CCE3F1;background-color:#fff;}
#product_daohang .left_box_normal td.title{;color:#000;background:url(images/left_box_bg.png) no-repeat left center #E5F0F3;}

#product_daohang .left_box_hover{border:1px solid #FE8802;background-color:#FFFAE7;}
#product_daohang .left_box_hover td.title{background-color:#FFFAE7;color:#FE8802;}
#product_daohang .left_box_hover td a:hover{border-bottom:1px dashed #E5F0F3;color:#FE8802;}

/*中部-右边*/
#middle_right_div{float:right;width:690px;border:0px solid blue;}

.product_table{clear:both;width:100%;margin:3px;}
.product_table a.img{float:left;text-decoration:none;}
.product_table img {width:100px;height:100px;border:0px;}
.product_table ul{float:left;list-style:none;width:110px;margin:3px;padding:3px;font-size:10pt;}
.product_table li .discount {font-size:12pt;font-family:Georgia,Times new roman,serif;color:#FF6600;font-weight:bold;}
.product_table li{padding-top:5px;}
.product_table li a{color:#1A66B3;text-decoration:none;}
.product_table li a:hover{text-decoration:underline;}
.product_table .before_price{text-decoration:line-through;color:#878787;font-size:11pt;}
.product_table .discount_price{color:#CC3300;margin-left:10px;font-size:11pt;}
</style>
<script type="text/javascript">
function table_mouse_over(t){
	t.className="left_box_hover";
}

function table_mouse_out(t){
	t.className="left_box_normal";
}

function loadImage(){
	var images = ["images/dot.png","images/dot.jpg"];
	for(var i=0;i<images.length;i++){
		var image = new Image();
		image.src=images[i];
	}
}
</script>
	</head>
	<body onload="loadImage()">
		<iframe src="top_index.jsp" name="topFrame" width="100%" height="150px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
		<div id="middle_div">
			<div id="middle_left_div">
				<div id="gonggao">
					<div class="title">网站公告</div>
					<div class="more"><a href="showBulletinList.jsp?pageNo=1">更多&gt;&gt;</a></div>
					<%
					BulletinDao dao = new BulletinDao();
					ArrayList<BulletinInfo> five_bulletin = dao.getTopFiveBulletinInfo();
					if (null != five_bulletin) {
						BulletinInfo item = null;
						for (int i = 0; i < five_bulletin.size(); i++) {
							item = five_bulletin.get(i);
							String title = item.getTitle();
							out.println("<a href=\"bulletin.jsp?id=" + item.getId() + "\" title=\""+title+"\">"
									+ StringUtil.omitString(title,28) + "<span>" 
									+ DateTimeUtil.convertDateNoTime(item.getCreateTime())
									+ "</span></a>");
						}
					}
					%>
				</div>
				<div id="product_daohang">
				<div class="product_title">产品导航</div>
<%
				GoodsTypeDao typeDao = new GoodsTypeDao();
				ArrayList<GoodsType> types = typeDao.getAllGoodsTypesAndGoods();
				
				if(null != types){
					GoodsType type = null;
					ArrayList<GoodsInfo> goodsList = null;
					for(int i=0;i<types.size();i++){
						type = types.get(i);
						goodsList = type.getItems();
						if(goodsList.isEmpty()){
							continue;
						}
%>
				<table class="left_box_normal" onmouseover="table_mouse_over(this)" onmouseout="table_mouse_out(this)">
					<tr>
						<td class="title"><%=type.getTypeName() %></td>
						<td width="250px">
							<%
							for(int j=0;j<goodsList.size();j++){
								GoodsInfo goods = goodsList.get(j);
								String goodsName = goods.getGoodsName();
								
								out.println("<a href=\"product.jsp?id="+goods.getGoodsId()+"\">"
										+StringUtil.omitString(goodsName,34)+"</a>");
							}
							%><a class="more" href="products.jsp?id=<%=type.getTypeId()%>">更多&gt;&gt;</a>
						</td>
					</tr>
				</table>							
<%
					}
				}
%>
				</div>
			</div>
			<div id="middle_right_div">
				<div style="margin-bottom:10px;">
					<div style="height:38px;border-bottom:1px solid #888888;">
						<img src="images/recommend2.gif" height="33"></img>
					</div>
					<table class="product_table">
						<tr>
					<%
					GoodsInfoDao goodsDao = new GoodsInfoDao();
					ArrayList<GoodsInfo> goodsList =  null;
					
					goodsList = goodsDao.getRecommendGoods();
					GoodsInfo goods = null;
					boolean flag = false;
					for(int i=0;i<goodsList.size();i++){
						goods = goodsList.get(i);
						flag = goods.getDiscount()!=10;
					%>
					<td>
						<a class="img" href="product.jsp?id=<%=goods.getGoodsId()%>"><img src="product/<%=goods.getPhoto()%>" /></a>
						<ul>
							<%if(flag){%>
							<li><span class="discount"><%=goods.getDiscount()%></span>折</li>
							<%}%>
							<li><a href="product.jsp?id=<%=goods.getGoodsId()%>"><%=goods.getGoodsName()%></a></li>
							<li>
							<%if(flag){%>
								<span class="before_price">&yen;<%=goods.getPrice()%></span>
							<%}%>
								<span class="discount_price">&yen;<%=String.valueOf(goods.getDiscountPrice())%></span>
							</li>
						</ul>
					</td>
					<%
						if((i+1)%3==0){
							out.println("</tr><tr>");
						}
					}
					%>
					</tr>
					</table>
				</div>
				<div style="margin-bottom:15px;">
					<div style="height:27px;border-bottom:1px solid #53BEE6;">
						<img src="images/newproduct5.gif" height="22px"></img>
					</div>
					<table class="product_table">
						<tr>
					<%
					goodsList =  goodsDao.getNewGoods();
					flag = false;
					for(int i=0;i<goodsList.size();i++){
						goods = goodsList.get(i);
						flag = goods.getDiscount()!=10;
					%>
					<td>
						<a class="img" href="product.jsp?id=<%=goods.getGoodsId()%>">
							<img src="product/<%=goods.getPhoto()%>" /></a>
						<ul>
							<%if(flag){%>
							<li><span class="discount"><%=goods.getDiscount()%></span>折</li>
							<%}%>
							<li><a href="product.jsp?id=<%=goods.getGoodsId()%>">
								<%=goods.getGoodsName()%></a></li>
							<li>
							<%if(flag){%>
								<span class="before_price">&yen;<%=goods.getPrice()%></span>
							<%}%>
								<span class="discount_price">&yen;<%=String.valueOf(goods.getDiscountPrice())%></span>
							</li>
						</ul>
					</td>
					<%
						if((i+1)%3==0){
							out.println("</tr><tr>");
						}
					}
					%>
					</tr>
					</table>
				</div>
			
				<div style="margin-bottom:10px;">
					<div style="height:25px;border-bottom:1px solid #5FCB95;">
						<img src="images/specilproduct2.gif" height="20"></img>
					</div>
					<table class="product_table">
					<tr>
					<%
					goodsList =  goodsDao.getDiscountGoods();
					for(int i=0;i<goodsList.size();i++){
						goods = goodsList.get(i);
					%>
					<td>
						<a class="img" href="product.jsp?id=<%=goods.getGoodsId()%>">
							<img src="product/<%=goods.getPhoto()%>" /></a>
						<ul>
							<li><span class="discount"><%=goods.getDiscount()%></span>折</li>
							<li><a href="product.jsp?id=<%=goods.getGoodsId()%>"><%=goods.getGoodsName()%></a></li>
							<li>
								<span class="before_price">&yen;<%=goods.getPrice()%></span>
								<span class="discount_price">&yen;<%=String.valueOf(goods.getDiscountPrice())%></span>
							</li>
						</ul>
					</td>
					<%
						if((i+1)%3==0){
							out.println("</tr><tr>");
						}
					}
					%>
					</tr>
					</table>
				</div>
			</div>
		</div>
		<iframe src="bottom_index.jsp" name="bottomFrame" width="100%" height="180px" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
	</body>
</html>