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
			width:100%;
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
			width:100%;
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
			width:100%; min-width:1200px; height:42px; background-color:#f8f8f8;clear:both;
			font-size:13px;
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
			margin-top: 10px;
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
	
	<div class="divone">
		<div class="divtwo">
			<form action="goods?method=selmore&id=${goods.g_id}" method="post">
			    <table width="100%" align="center" border=0 cellpadding="0" cellspacing="0" bgcolor="#6B6068"><!-- 汤姆的颜色 -->
			        		
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
	    			location.href="index?method=selorders&currp="+page;
	    		}
	    	}
    	</script>
    	
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
