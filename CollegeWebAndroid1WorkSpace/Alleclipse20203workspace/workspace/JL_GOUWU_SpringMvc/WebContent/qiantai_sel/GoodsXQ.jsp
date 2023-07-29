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
    <title>${goods.g_name }-JERRY网</title>
    <style>
    	.topbottomtrstyle{
			border-style:solid; 
			border-width:1px;
			border-top-color:#ebebeb;
			border-bottom-color:#f8f8f8;
			border-right-color:#f8f8f8;
			border-left-color:#f8f8f8;
			background-color:#f8f8f8;
			height:0px;
			width:250px;
		}
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
			width:1445px;
		}	
		.toptext{font-size:23px}
		#topfoot a{text-decoration: none;color: white}
		.topxuanze{
			border-style:solid; 
			border-width:1px;
			border-top-color:#008080;
			border-bottom-color:#008080;
			border-right-color:#008080;
			border-left-color:#008080;
			background-color:#008080;
			height:48px;
			width:100px;
			
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
			width:100px;
			
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
			width:1043px;
		}
		.topljcolor a{text-decoration: none;color:#797979}
		.topljcolor a:hover{text-decoration: none;color:#CED48A}
		
		.toppinglunxian{border:1px dashed #c2c2c2; height:0px;width:1000px}
		#nav ul {margin:0;padding-left:155px;width:760px}
		#wrap {
  			height:50px;
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
			width:100%; min-width:1000px; height:42px; background-color:#f8f8f8;clear:both;font-size:13px;
		}
		.sou{
			width:1000px; height:42px; line-height:42px;
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
			width:100%; min-width:1000px; height:105px; clear:both;margin-top:30px;
		}
		.imgdivone {
			width: 100%;
			min-width: 1000px;
			height: 105px;
			clear: both;
			margin-top: 10px;
		}
		.divtwo{
			width:1000px;height:105px; line-height:105px;
		}
		.divtwoimg{
			width:320px; float:left;padding-bottom: 20px;
		}
		.divtwoinput{
			float:left; padding-left:15px; padding-top: 15px;
		}
		
		.divshouyeone{
			width:100%; min-width:1000px;height:auto; clear:both;margin-top:20px;
		}
		.divshouyetwo{
			width:1000px;clear:both;
		}
		.firsthen{
			clear:both;
			float:left;
			border-style:solid; 
			border-width:1px;
			border-top-color:#ebebeb;
			border-bottom-color:#f8f8f8;
			border-right-color:#f8f8f8;
			border-left-color:#f8f8f8;
			width:1000px;
			margin-top: 20px;
		}
	</style>
  </head>
  
 <BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"> 
 
 	
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
			<form action="goods/selxsgoods" target="_blank" name="frm" method="post" >
			<span class="divtwoimg">
				<span class="fl">
	    			<img src="image/zhuti.png"   height="105" width="85">
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
  	<!-- 头部开始 -->
  	<div class="divshouyeone">
		<div class="divshouyetwo">
   			<table width="100%" bgcolor="#008080" border=0 style="margin-top: 1px;">
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
							<a href="goods/selmore&mdid=8&bottomid=23" target="_top">购物</a>
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
		  					<div id="content" class="toptext">
							&nbsp;
							</div>
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
					位置:&nbsp;&nbsp;
				</font>
				<font size="3" color="black">${mold.mold } » ${bottom.bottom } »</font> <font size="3" color="#7d7d7d">${goods.g_name }</font>
			</div>
		</div>
	</div>
	<div class="divshouyeone">
		<div class="divshouyetwo">
			<div class="firsthen">
			
			</div>
		</div>
	</div>
  	<!-- 位置结束 -->

    <div class="divshouyeone">
		<div class="divshouyetwo">
			<table width="100%" border="0">
		    	<tr align="left" height="40">
		    		<td><font size="6"><b>${goods.g_name }</b></font><br><br>
		    			<font color="#666666" size="4">${goods.g_dress }</font><br><br>
		    			<font color="#666666" size="4">${goods.g_dec }</font>
		    			
		    		</td>
		    	</tr>
		    	<tr align="left" height="8">
		    		<td>
		    			&nbsp;
		    		</td>
		    	</tr>
		   		<tr align="left">
		    		<td>
		    			<div style="position:relative; margin-left: 0px;margin-right: 0px;" >
			    			<img src="file/${goods.g_img }" width="460" height="280">
			    			<div class="topbottomtrstyle" style="position:absolute; z-index:2; left:490px; top:5px">
		
							</div>
			    			<div style="position:absolute; z-index:2; left:490px; top:15px">						
			    				<font color="#666666">单价</font>   <font color="OrangeRed" size="4">¥</font> <font color="OrangeRed" size="6">${goods.g_price  }</font> <br>
			    				<br><br>
			    				<font color="#797979" size="3">门店价:<s>¥${goods.g_scj }</s></font><br>
			    				<br><br>
			    				<font color="#797979" size="3">已售</font>   <font color="OrangeRed" size="3">${goods.g_sale }</font>  <font color="#797979" size="3">|</font>  <font color="OrangeRed" size="3">${totalRow}</font><font color="#797979" size="3">人评价</font><br>
			    				<br><br>
			    				<c:if test="${jruser!=null}">
			    					<a href="index/saveoneorders?id=${goods.g_id }"><img src="image/tjdd.png"></a>
				    			</c:if>
				    			<c:if test="${jruser==null}">
				    				<a href="qiantai_admin/login.jsp" onclick="return confirm('你好,请先登录')"><img src="image/tjdd.png"></a>
				    			</c:if>	
				    			<a href="goods/gouwuche?id=${goods.g_id }"><img src="image/addgwc.png"></a>
							</div>
						</div>
						<div class="topbottomtrstyle" style=" margin-left:490px">
		
						</div>
		    		</td>
		    	</tr>
		    </table>
		</div>
	</div>
    <!-- 商品说明开始 -->
    <div class="divshouyeone">
		<div class="divshouyetwo">
			
		    <table width="100%" align="center" border=0 cellspacing="1.5" bgcolor="#929292">
		    	<tr bgcolor="white" >
		    		<td colspan="2">
		    			<font size="5">商品说明:</font>
		    		</td>  		
		    	</tr>
		    	<tr bgcolor="white" height="30">
		    		<td align="left" colspan=2>
		    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${goods.g_descrip }
		    		</td>
		    	</tr>
		    </table>
		</div>
	</div>
    <!-- 商品说明结束 -->
    <!-- 评价开始 -->
    <div class="divshouyeone">
		<div class="divshouyetwo">
			
		    <table width="100%" align="center" border=0 cellspacing="0" cellpadding="0">
		    	<tr>
		    		<td align="left">
		   				<font size="5" color="#95361A">消费评价</font>
		    		</td>
		    		<td align="right">
		    			我买过本单，我要<a href="#laipingjia" ><font color="#008080 ">评价</font></a>
		    		</td>
		    	</tr>
			</table>
			
						<hr width="100%">
		    <c:if test="${commentlistsize==0}">
			    <table width="100%" align="center" border=0 cellspacing="0">
				    <tr>
				   		<td colspan="2" align="center">
				    		<h3>暂无评论,赶快抢占沙发吧！</h3>
				    	</td>
				    </tr>		
				</table>
		   </c:if>	 
		    <c:if test="${commentlistsize!=0}">
				<table width="100%" align="center" border=0 cellspacing="0">
					<c:forEach items="${commentlist}" var="list">
			    		<tr>
			    			<!-- 头像和昵称 -->
			    			<td width="10%" align="center">
			    				<img src="image/${list.jr_img }.jpg" width="71" height="53"><br>
			    				${list.uname }
			    			</td>
			    			<!-- 时间和评论 -->
			   				<td width="62%">
				    			${list.c_time }
								<br><br>
				    			${list.c_comment }
				    		</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">
			    				<br>
			    				<div class="toppinglunxian">
			    				
			    				</div>	
			    				<br>
			    			</td>
			    		</tr>
					</c:forEach>
				</table>
				<form action="goods/goodsxq?id=${goods.g_id}" method="post">
					<table width="100%" align="center" border=0 cellspacing="0">
						<tr align="left" height="40">
							<td>
								<font color="#008080">
				    			<a href="goods/goodsxq?id=${goods.g_id}&currp=1">首页</a>	
				    			<a href="goods/goodsxq?id=${goods.g_id}&currp=${currPage-1 }">上一页</a>
		
						    	<c:forEach begin="${currPage}" end="${currPage+2}" var="i" step="1">
						   			<c:if test="${i<=totalPage}">
						    			<a href="goods/goodsxq?id=${goods.g_id}&currp=${i }">${i }</a>
						    		</c:if>
						    	</c:forEach>
				    			<a href="goods/goodsxq?id=${goods.g_id}&currp=${currPage+1}">下一页</a>	
				    			<a href="goods/goodsxq?id=${goods.g_id}&currp=${totalPage}">尾页</a>
				    			跳转到<input type="text" size=3 id="tx1" value="${currPage}"><input type="button" value="GO" onclick="fangfa();"> 
		    					当前页为 <font color="red">${currPage}</font>/<font color="red">${totalPage }</font>
		    					</font>	
				    		</td>	
			    		 </tr>
			    	</table>
		    	</form>
		    </c:if>
			<hr width="100%">
		</div>
	</div>
    <!-- 评价结束 -->
    
    <!-- 写下评价 -->
    <a name="laipingjia"></a>
    <div class="divshouyeone">
		<div class="divshouyetwo">
		    <c:if test="${meigoumai!=null}">
		    	<div style="margin-left:200px;">
		    		<font color="red">${meigoumai }</font>
		    	</div>
		    </c:if>
		    <form action="index/shifouxiaofei?id=${goods.g_id}" name="fame" method="post" >
		    <table width="100%" align="center" border=0 cellspacing="0">
		    	<tr>
		    		<td width="35%" align="left">
		    		    <textarea rows="7" cols="60" name="comment">请写下你的评价...</textarea>
		    		</td>
		    		<td align="center" width="30%">
						<!-- 联系客服 要账号-->
						<c:if test="${jruser!=null}">		
							<a onclick="zilei()"><img src="image/11fuben.jpg" width="150" height="62"></a>
							<script>
								var b=null;
									function zilei(){
										b=window.open("qiantai_chart/khdchart.jsp","","width=600 height=400 top=200 left=400");
									}
									function ziclose(){
										b.close();
									
									}
							</script>
						</c:if>
						<c:if test="${jruser==null}">
							<a href="qiantai_admin/login.jsp" onclick="return confirm('你好,请先登录')"><img src="image/11fuben.jpg" width="150" height="62"></a>
						</c:if>
						<!-- 结束 -->
						<br>
		    			<c:if test="${jruser!=null}">
		    				<a href="javascript:checcomment();"><img src="image/tijiao2.png"></a>
		    			</c:if>
						<c:if test="${jruser==null}">
							<a href="qiantai_admin/login.jsp" onclick="return confirm('你好,请先登录')"><img src="image/tijiao2.png"></a>
						</c:if>
						
					</td>
					<td align="left" width="35%">
						<img src="image/b2.jpg" width="310" height="110" >
					</td>
		    	</tr>
		    </table>
		    </form>
		</div>
	</div>
    
    
    <script>
    	function fangfa(){
    		var page=document.getElementById("tx1").value;
    		if(isNaN(page)){
    			alert("请输入正确的数字");
    			document.getElementById("tx1").value="";
    			document.getElementById("tx1").focus();
    		}else{
    			location.href="goods/goodsxq?id=${goods.g_id}&currp="+page;
    		}
    	}
   	</script>
    <script>
    	function checcomment(){
    		var text=document.fame.comment.value;
    		if(text==""||text.trim()==""){
    			alert("评价不能为空");
    		}else{
    			document.fame.submit();
    		}
    		
    	}
    	
    </script>
    <!-- 评价结束 -->
    
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
   
  </body>
</html>
