<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
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
		
		.toppinglunxian{border:1px dashed #c2c2c2; height:0px;width:1043px}
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
  </head>
  
 <BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"> 
<table align="center" width="100%" border=0 bgcolor="#f8f8f8" >

	<tr height="35">
		<td align="right" width="14%" id="topziti">
			<a href="javascript:void(0);" onclick="AddFavorite('http://localhost:8080/JL_GOUWU/qiantai_main/main.jsp','杰瑞购物网');">
                收藏Jerry网</a>
		</td>
		<td align="left" width="25%" id="topziti">
			
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
		<td align="left" width="4%" id="topziti">
			<div id="topuser">
				<a href="http://www.360kan.com/ct/OULlcM7lLICuDj.html" target="_blank">多来看看我</a>
			</div>
		</td>
		<td align="left" width="10%">
	
			<a><font color="#4b4b4b"></font></a>

		</td>
	</tr>
</table>
	<!-- 为了顶层的颜色深一点 -->
	<div class="toptablestyle">

	</div>
	<!-- 3个br 杰瑞图片 -->
	
	<form action="goods?method=selxsgoods" target="_blank" name="frm" method="post" >
	    <table align="center" width="73%" border=0>
	    	<tr height="150">
	    		<td align="left">
	    		<div style="position:relative; margin-left: 0px;margin-right: 0px;" >
	    			<img src="image/zhuti.png" height="105" width="85">
	    			<div style="position:absolute; z-index:2; left:85px; top:83px">
	    				<font size="3" color="#95361A">jerry.com</font>
	    			</div>
	    			</div>
	    		</td>
	    	
	    		<td>
	    			<div style="margin-left:210px">
	    				<input type="text" name="uname" style="width:300px; height:28px;">
	    				<input type="submit" value="搜索" style="width:50px; height:28px;">
	    			</div>
	    		</td>
	    	</tr>
	    </table>
    </form>
    
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
    
  <!-- 头部开始 -->
  <table width="72%" align="center" bgcolor="#008080" border=0 style="margin-top: 1px;">
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
					<a href="#" onclick="location.reload()">今日新单</a>
					</div>
					</div>
				</div>
			</td>
			<td width="13%">
				<div id="topfoot" class="topxuanze">
    				<div id="wrap">
  					<div id="content" class="toptext">
					<a href="goods?method=selmore&mdid=8&bottomid=23" target="_top">购物</a>
					</div>
					</div>
				</div>
			</td>
			<td width="13%">
				<div id="topfoot" class="topxuanze">
    				<div id="wrap">
  					<div id="content" class="toptext">
					<a href="#" onclick="location.reload()">热销商品</a>
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
  
  <!-- 头部结束 -->
  
  <!-- 位置开始 -->
	<table width="72%" border=0 align="center">
	<!-- 去更多需要保存类型id -->
		<tr>
			<td class="topljcolor">
			<div class="topljtablestyle">
				<div id="wrap">
 					<div id="content" >
						<font size="3" color="red">
							位置:&nbsp;&nbsp;
						</font>
						<font size="3" color="black">${mold.mold } » ${bottom.bottom } »</font> <font size="3" color="#7d7d7d">${goods.g_name }</font>
					</div>
				</div>
			</div>
			</td>
		</tr>		
	</table>
  	<!-- 位置结束 -->

    <div style="height:10px">

    </div>
    	
    <table width="72%" align="center" border="0">
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
	    					<a href="index?method=saveoneorders&id=${goods.g_id }"><img src="image/tjdd.png"></a>
		    			</c:if>
		    			<c:if test="${jruser==null}">
		    				<a href="qiantai_admin/login.jsp" onclick="return confirm('你好,请先登录')"><img src="image/tjdd.png"></a>
		    			</c:if>	
		    			<a href="goods?method=gouwuche&id=${goods.g_id }"><img src="image/addgwc.png"></a>
					</div>
				</div>
				<div class="topbottomtrstyle" style=" margin-left:490px">

				</div>
    		</td>
    	</tr>
    </table>
    <br><br><br>
    <!-- 商品说明开始 -->
    <table width="72%" align="center" border=0 cellspacing="1.5" bgcolor="#929292">
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
    <!-- 商品说明结束 -->
    
	<br><br><br>
	
    <!-- 评价开始 -->
    <table width="72%" align="center" border=0 cellspacing="0" cellpadding="0">
    	<tr>
    		<td align="left">
   				<font size="5" color="#95361A">消费评价</font>
    		</td>
    		<td align="right">
    			我买过本单，我要<a href="#laipingjia" ><font color="#008080 ">评价</font></a>
    		</td>
    	</tr>
	</table>
    <hr width="72%">
    <br>
    <c:if test="${commentlistsize==0}">
	    <table width="72%" align="center" border=0 cellspacing="0">
		    <tr>
		   		<td colspan="2" align="center">
		    		<h3>暂无评论,赶快抢占沙发吧！</h3>
		    	</td>
		    </tr>		
		</table>
   </c:if>	 
    <c:if test="${commentlistsize!=0}">
		<table width="72%" align="center" border=0 cellspacing="0">
			<c:forEach items="${commentlist}" var="list">
    		<tr>
    			<!-- 头像和昵称 -->
    			<td width="10%" align="center">
    				<img src="file/${list.jr_img }.jpg" width="71" height="53"><br>
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
		<form action="goods?method=goodsxq&id=${goods.g_id}" method="post">
			<table width="72%" align="center" border=0 cellspacing="0">
				<tr align="left" height="40">
					<td>
						<font color="#008080">
		    			<a href="goods?method=goodsxq&id=${goods.g_id}&currp=1">首页</a>	
		    			<a href="goods?method=goodsxq&id=${goods.g_id}&currp=${currPage-1 }">上一页</a>

				    	<c:forEach begin="${currPage}" end="${currPage+2}" var="i" step="1">
				   			<c:if test="${i<=totalPage}">
				    			<a href="goods?method=goodsxq&id=${goods.g_id}&currp=${i }">${i }</a>
				    		</c:if>
				    	</c:forEach>
		    			<a href="goods?method=goodsxq&id=${goods.g_id}&currp=${currPage+1}">下一页</a>	
		    			<a href="goods?method=goodsxq&id=${goods.g_id}&currp=${totalPage}">尾页</a>
		    			跳转到<input type="text" size=3 id="tx1" value="${currPage}"><input type="button" value="GO" onclick="fangfa();"> 
    					当前页为 <font color="red">${currPage}</font>/<font color="red">${totalPage }</font>
    					</font>	
		    		</td>	
	    		 </tr>
	    	</table>
    	</form>
    	<script>
	    	function fangfa(){
	    		var page=document.getElementById("tx1").value;
	    		if(isNaN(page)){
	    			alert("请输入正确的数字");
	    			document.getElementById("tx1").value="";
	    			document.getElementById("tx1").focus();
	    		}else{
	    			location.href="goods?method=goodsxq&id=${goods.g_id}&currp="+page;
	    		}
	    	}
    	</script>
    </c:if>
	<hr width="72%">

    <!-- 评价结束 -->
    
    <br>
    
    <!-- 写下评价 -->
    <a name="laipingjia"></a>
    
    <c:if test="${meigoumai!=null}">
    	<div style="margin-left:200px;">
    		<font color="red">${meigoumai }</font>
    	</div>
    	
    </c:if>
    
    <br>
    <form action="index?method=shifouxiaofei&id=${goods.g_id}" name="fame" method="post" >
    <table width="72%" align="center" border=0 cellspacing="0">
    	<tr>
    		<td width="35%" align="left">
    		    <textarea rows="7" cols="70" name="comment">请写下你的评价...</textarea>
    		</td>
    		<td align="center" width="10">
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
			<td align="left" >
				<img src="image/2.jpg" width="400" height="110">
			</td>
    	</tr>
    </table>
    </form>
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
    
   
  </body>
</html>
