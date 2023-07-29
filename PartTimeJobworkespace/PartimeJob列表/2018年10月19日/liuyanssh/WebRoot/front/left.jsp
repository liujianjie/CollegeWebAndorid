<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<!-- saved from url=(0062)http://www.17sucai.com/preview/847335/2018-03-08/cd/index.html -->
<html  lang="en"  style="font-size: 100px;">
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta  charset="UTF-8">
   
    <meta  http-equiv="X-UA-Compatible"  content="ie=edge">
    <title>信息维护菜单</title>
	
    <script  src="<%=basePath%>js/adapter.js"></script> 
	

<script type="text/javascript" src="<%=basePath %>js/jquery1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/easing.js"></script>
<style>
	/*
			author :前端一枚  努力学习中 qq：815183231;
	*/

	/*简单粗暴重置默认样式===============================*/
		*{ margin: 0; padding: 0; }
		img{border:0;}
        ul,li{list-style-type:none;}
		a {color:#00007F;text-decoration:none;}
		a:hover {color:#bd0a01;text-decoration:underline;}
		.treebox{ width: 200px; margin: 0 auto; background-color:#1a6cb9; }
		.menu{ overflow: hidden; border-color: #ddd; border-style: solid ; border-width: 0 1px 1px ; }
		/*第一层*/
		.menu li.level1>a{ 
			display:block;
			height: 45px;
			line-height: 45px;
			color: #fff;
			padding-left: 50px;
			border-bottom: 1px solid #000; 
			font-size: 16px;
			position: relative;
		 }
		 .menu li.level1 a:hover{ text-decoration: none;background-color:#326ea5;   }
		 .menu li.level1 a.current{ background: #0f4679; }

		/*============修饰图标*/
		 .ico{ width: 20px; height: 20px; display:block;   position: absolute; left: 20px; top: 10px; background-repeat: no-repeat; background-image: url(../imgs/ico1.png); }

		 /*============小箭头*/
		 .level1 i{ width: 20px; height: 10px; background-image:url(../imgs/arrow.png); background-repeat: no-repeat; display: block; position: absolute; right: 20px; top: 20px; }
		.level1 i.down{ background-position: 0 -10px; }

		 .ico1{ background-position: 0 0; }
		 .ico2{ background-position: 0 -20px; }
		 .ico3{ background-position: 0 -40px; }
		 .ico4{ background-position: 0 -60px; }
                 .ico5{ background-position: 0 -80px; }

		 /*第二层*/
		 .menu li ul{ overflow: hidden; }
		 .menu li ul.level2{ display: none;background: #0f4679;  }
		 .menu li ul.level2 li a{
		 	display: block;
			height: 45px;
			line-height: 45px;
			color: #fff;
			text-indent: 60px;
			/*border-bottom: 1px solid #ddd; */
			font-size: 14px;
		 }

	</style>

</head>
<body >

<div class="treebox">
		<ul class="menu">
			<c:if test = '${fn:contains(UserpreReallist,"1")?"true":"false" }'>
				<li class="level1">
				<a href="#none"><em class="ico ico1"></em>基本信息维护<i class="down"></i></a>
				<ul class="level2">
					<c:if test = '${fn:contains(UserpreReallist,"2")?"true":"false" }'><li><a href="comment.jsp" target="main">评论管理</a></li></c:if>
					<c:if test = '${fn:contains(UserpreReallist,"3")?"true":"false" }'><li><a href="count.jsp" target="main">统计管理</a></li></c:if>
				</ul>
			
			</li>
			</c:if>
			<c:if test = '${fn:contains(UserpreReallist,"4")?"true":"false" }'><li class="level1">
				<a href="#none"><em class="ico ico1"></em>管理员管理<i class="down"></i></a>
				<ul class="level2">
					<c:if test = '${fn:contains(UserpreReallist,"5")?"true":"false" }'><li><a href="deptlist.jsp" target="main">职位管理</a></li></c:if>
					<c:if test = '${fn:contains(UserpreReallist,"6")?"true":"false" }'><li><a href="departmentlist.jsp" target="main">部门管理</a></li></c:if>
					
				</ul>
			</li>
			</c:if>
			<c:if test = '${fn:contains(UserpreReallist,"7")?"true":"false" }'><li class="level1">
				<a href="#none"><em class="ico ico2"></em>用户管理<i></i></a>
				<ul class="level2">
					<c:if test = '${fn:contains(UserpreReallist,"8")?"true":"false" }'><li><a href="javascript:;">用户权限管理</a></li></c:if>
				</ul>
			</li>  
			</c:if>
		</ul>
	</div>



</body></html>
<script>
//等待dom元素加载完毕.
	$(function(){
		$(".treebox .level1>a").click(function(){
			$(this).addClass('current')   //给当前元素添加"current"样式
			.find('i').addClass('down')   //小箭头向下样式
			.parent().next().slideDown('slow','easeOutQuad')  //下一个元素显示
			.parent().siblings().children('a').removeClass('current')//父元素的兄弟元素的子元素去除"current"样式
			.find('i').removeClass('down').parent().next().slideUp('slow','easeOutQuad');//隐藏
			 return false; //阻止默认时间
		});
	})
</script>
