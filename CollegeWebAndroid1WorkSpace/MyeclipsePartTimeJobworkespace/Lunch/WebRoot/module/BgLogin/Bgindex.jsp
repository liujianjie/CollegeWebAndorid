<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>后台</title>
  <link rel="stylesheet" href="${path }/resource/css/houtai.css" type="text/css"></link>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript">
	$(document).ready(function(){
		var width=document.body.scrollWidth;
		var height=document.body.scrollHeight;
		//alert(width+":"+height);
		$("#all").css({"width":width+"px","height":height+"px"});
		$(".menu_list").hide();
		$(".menu_list_first").show();
		$(".a_list").click(function(){
			var len = $('.a_list').length;
			var index = $(".a_list").index(this);
			for(var i=0;i<len;i++){
				if(i == index){
					$('.menu_list').eq(i).slideToggle(300);
					}else{
						$('.menu_list').eq(i).slideUp(300);
					}
				}
			});			
	});
	function checkNotNull(str){
         if(str!=null&&str!=''&&str!='undefined'&&str!='null')
           return true;
         else
           return false;
      }
      function openUrl(url){
         if(checkNotNull(url)){
            $("#conifr").attr("src",'${path}'+url);
         }
      }
  </script>
 </head>
 <body>
	<div id="all">
		<div id="menu">
			<label class="logo-title">网上订餐系统</label>
			<ul class="inline">
				<li>
					<img src="${path }/resource/img/99.png" />欢迎您,${userinfo.emp_user }
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle mymsg" data-toggle="dropdown" href="${path }/dc/ChangeEmp?empid=+${userinfo.emp_id}" target="main1">
						<img src="${path }/resource/img/154.png" value="${userinfo.emp_id }"/>修改个人信息
						<b class="caret"></b>
					</a>
				</li>
				<li>
					<a href="${path }/dc/ExistBg"><img src="${path }/resource/img/tui.png" /><a><a class="loginout" href="${path }/dc/ExistBg">退出</a>
				</li>
		    </ul>
		</div>
		<div id="con">
			<div id="con1">
				<div id="con12">
					<ul>
						<li>
							<%-- <a href="${path}/module/Login/Menu.jsp" >
								<span style="margin-left:20px"></span><img src="${path }/resource/img/home.png">首页
							</a> --%>
						</li>
						<c:if test="${!empty functionlist}">
							<c:forEach items="${functionlist }" var="map">
								<li>
									<a class="a_list a_list1">&nbsp;&nbsp;
										<span onclick="openUrl('${map.function_url}')" ><img src="${path }/resource/img/20.png">${map.function_name}</span>
									</a>
									<div class="menu_list">
										<c:if test="${!empty map.sons }">
										<ul>										
										<c:forEach items="${map.sons }" var="son">
											<li><p  onclick="openUrl('${son.function_url}')">${son.function_name}</p></li>
										</c:forEach>
										</ul>
										</c:if>
									</div>
								</li>
							</c:forEach>
						</c:if>					
					</ul>
				</div> 
			</div>
			<div id="con2">
				 <iframe id="conifr" name="main1" src="${path }/index.jsp">
         
         		</iframe> 
			</div>
			<div class="fooster">
				<p>技术支持:最帥我男神-马岗岗</p>
				<span>本公司不接受任何订单，总统，主席来了也不干</span>
			</div>
		</div>
	</div>
 </body>
</html>

