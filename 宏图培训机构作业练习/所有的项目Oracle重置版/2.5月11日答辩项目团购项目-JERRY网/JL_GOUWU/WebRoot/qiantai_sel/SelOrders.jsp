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
    
    <title>${jr.uname }的订单</title>
    <style>	
    	.trbottomstyle{
			border-style:solid; 
			border-width:1px;
			border-top-color:#95361A;
			border-bottom-color:#f8f8f8;
			border-right-color:#f8f8f8;
			border-left-color:#f8f8f8;
			background-color:white;
			height:20px;
			width:1085px;
		}	

		.top p{background:#FFFFE0;margin-left:150px;}
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
			width:1470px;
		}	

	</style>
  </head>
  
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"> 
<table align="center" width="100%" border=0 bgcolor="#f8f8f8" >
	
	<tr height="35">
		<td align="right" width="12%" id="topziti">
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
			<a href="qiantai_sel/GoodsGouWuChe.jsp" target="_blank">购物车<font color="red">${chartcount }</font></a><font color="#4b4b4b">件</font> <font color="#4b4b4b">|</font>
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
		<td align="left" width="8%">
	
			<a><font color="#4b4b4b"></font></a>

		</td>
	</tr>
</table>
	<!-- 为了顶层的颜色深一点 -->
	<div class="toptablestyle">

	</div>
	<!-- 3个br 杰瑞图片 -->
	
	<form action="goods?method=selxsgoods" target="_blank" method="post" >
	    <table align="center" width="75%" border=0>
	    	<tr height="150">
	    		<td align="left">
	    		<div style="position:relative; margin-left: 0px;margin-right: 0px;" >
	    			<img src="image/zhuti.png" height="105" width="85">
	    			<div style="position:absolute; z-index:2; left:85px; top:83px">
	    				<font size="3" color="#95361A">jerry.com</font>
	    			</div>
	    			</div>
	    		</td>
	    	
	    		<td align="left">
	    			<div style="margin-left:320px">
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
    <form action="goods?method=selmore&id=${goods.g_id}" method="post">
    <table width="75%" align="center" border=0 cellpadding="0" cellspacing="0" bgcolor="#6B6068"><!-- 汤姆的颜色 -->
        		
  		<tr align="center" height="50">
  			<td width="43%" align="left"><font color="white" size="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品</font></td>
			<td width="8%" align="center"><font color="white" size="4">单价</font></td>
			<td width="8%" align="center"><font color="white" size="4">数量</font></td>
			<td width="8%" align="center"><font color="white" size="4">小计</font></td>	
			<td width="9%" align="center"><font color="white" size="4">操作</font></td>
  		</tr>
  		<tr bgcolor="white" height="25">
  			<td colspan="5">&nbsp;</td>
  		</tr>
    	<c:forEach items="${orderslist}" var="order">
    		<tr bgcolor="#bfbfbf" height="30">
    			<td colspan="4" align="left">
    				&nbsp;&nbsp;&nbsp;订单编号:${order.orders_id }&nbsp;下单时间:${order.gtime }&nbsp;消费码:${order.xfm }
    			</td>
    			<td align="center">
    				<c:if test="${order.statu eq 0}">
    					未付款<a href="">去付款</a>
    				</c:if>
    				<c:if test="${order.statu eq 1}">
    					未使用
    				</c:if>
    				<c:if test="${order.statu eq 2}">
    					已使用<a href="goods?method=goodsxq&id=${order.g_id }"><font color="#008080" >去评价</font></a>
    				</c:if>
    			</td>
    		</tr>

    		<tr height="90" bgcolor="white">
	    		<td align="left">
	    			<div style="position:relative; margin-left: 0px;margin-right: 0px;" >
						<img src="file/${order.gimg }" width="65" height="42">
						　　	<div style="position:absolute; z-index:2; left:30px; top:10px">						
						　　　　	${order.gname }:<font size="2">${order.gdec }</font>
						　　</div>		
					</div>
	    		</td>
				<td align="center" ><font color="red">${order.gprice }</font></td>
				<td align="center">${order.gwccount }</td>
				<td align="center"><font color="red">${order.gprice*order.gwccount }</font></td>	
				<td align="center"><a href="goods?method=goodsxq&id=${order.g_id }"><font color="#008080" >查看详情</font></a></td>
    		</tr>
			<!-- 来一条横线 -->
			<tr bgcolor="white" height="30">
				<td colspan="5">
					<div class="trbottomstyle">
			
					</div>
				</td>
			</tr>
    	</c:forEach>
    	<tr bgcolor="white" height="30">
				<td colspan="5">
					<font color="#008080">
	    			<a href="index?method=selorders&currp=1">首页</a>	
	    			<a href="index?method=selorders&currp=${currPage-1 }">上一页</a>

			    	<c:forEach begin="${currPage}" end="${currPage+2}" var="i" step="1">
			   			<c:if test="${i<=totalPage}">
			    			<a href="index?method=selorders&currp=${i }">${i }</a>
			    		</c:if>
			    	</c:forEach>
	    			<a href="index?method=selorders&currp=${currPage+1}">下一页</a>	
	    			<a href="index?method=selorders&currp=${totalPage}">尾页</a>
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
	    			location.href="index?method=selorders&currp="+page;
	    		}
	    	}
    	</script>
  </body>
</html>
