<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 学费添加页面 -->

<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->
		<meta charset="utf-8">
		<title>Free HTML5 Bootstrap Admin Template</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description"
			content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
		<meta name="author" content="Muhammad Usman">

		<!-- The styles -->
		<link id="bs-css" href="css/bootstrap-cerulean.min.css"
			rel="stylesheet">

		<link href="css/charisma-app.css" rel="stylesheet">
		<link href='bower_components/fullcalendar/dist/fullcalendar.css'
			rel='stylesheet'>
		<link href='bower_components/fullcalendar/dist/fullcalendar.print.css'
			rel='stylesheet' media='print'>
		<link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
		<link href='bower_components/colorbox/example3/colorbox.css'
			rel='stylesheet'>
		<link href='bower_components/responsive-tables/responsive-tables.css'
			rel='stylesheet'>
		<link
			href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
			rel='stylesheet'>
		<link href='css/jquery.noty.css' rel='stylesheet'>
		<link href='css/noty_theme_default.css' rel='stylesheet'>
		<link href='css/elfinder.min.css' rel='stylesheet'>
		<link href='css/elfinder.theme.css' rel='stylesheet'>
		<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
		<link href='css/uploadify.css' rel='stylesheet'>
		<link href='css/animate.min.css' rel='stylesheet'>

		<!-- jQuery -->
		<script src="bower_components/jquery/jquery.min.js"></script>

		<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

		<!-- The fav icon -->
		<link rel="shortcut icon" href="img/favicon.ico">

<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>


<script type="text/javascript">

//默认加载选中班级的学生
$(function(){
	var banji=$("#selectError").val();
	//alert("班级是： "+banji);
	$.post("lcy/json!selStuByClass",{cid:banji},function(data){
		list=data.st_list;
		//alert("数据大小："+list.length);
		var sele=$("#stuname");
		$.each(list,function(index,op){
			var option=$("<option>",{
				"value":op.INTENID,
				"text":op.INTENNAME
			});
			sele.append(option);
		});
	},"json");
});

//查询某班级的学生
function selstu(sel){
	$("#stuname").html("");
	//alert("下拉框的值： "+sel.value);
	var val=sel.value;
	$.post("lcy/json!selStuByClass",{cid:val},function(data){
		list=data.st_list;
		//alert("数据大小："+list.length);
		var sele=$("#stuname");
		$.each(list,function(index,op){
			var option=$("<option>",{
				"value":op.INTENID,
				"text":op.INTENNAME
			});
			sele.append(option);
		});
	},"json");
}


function yzStu(){
	//alert("进来了");
	var selectError=$("#selectError").val();
	var f2=$("#f2").val();
	$.post("lcy/json!yanzheng.action?",{id1:selectError,id2:f2},function(data){
		var yz=data.yz;
		var stuid=data.stuid;
		//alert(data);
		if(yz==0){
			alert("没有此学生的信息!");
		}
		if(yz==1){
		
			$("#stuid").val(stuid);
		}
		
	},"json");
}


function check(){
		var f2=$("#f2").val();
		var t2=$("#t2").val();
		var t3=$("#t3").val();
		var b=$("#b").val();
		
		if(f2==""){
			alert("请输入学生姓名！");
			return false;
		}
		
		if(t2==""){
			alert("请输入实际缴费！");
			return false;
		}
		if(isNaN(t2)){
			alert("请输入数字金额！");
			return false;
		}
		
		if(t3==""){
			alert("请登录！");
			return false;
		}
		
		if(b==""){
			alert("请输入收费时间！");
			return false;
		}
		
		return true;
}
</script>
	</head>

	<body>
	<div class="ch-container">
    <div class="row"> 

				<noscript>
					<div class="alert alert-block col-md-12">
						<h4 class="alert-heading">
							Warning!
						</h4>

						<p>
							You need to have
							<a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
							enabled to use this site.
						</p>
					</div>
				</noscript>

				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="index.jsp" target="_blank">主页</a>
							</li>
							<li>
								<a href="javascript:history.go(-1);">返回上一页</a>
							</li>
						</ul>
					</div>
	            <!-- content starts -->
<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i> 添加学费缴纳记录</h2>

               
            </div>
            <div class="box-content">
                <form role="form" action="lcy/xuefei_add.action" method="post">
		
					<div>
					
						<b>收费标准：</b>
						<table border="1" width="300px">
							<tr>
								<td>第一学期</td>
								<td>&yen;10000</td>
							</tr>
							<tr>
								<td>第二学期</td>
								<td>&yen;7800</td>
							</tr>
							<tr>
								<td>第三学期</td>
								<td>&yen;8800</td>
							</tr>
						</table>
						
					</div>
 					
 					<br/>
 				
 					
 					<div class="box-content">
 						<div class="control-group">
 							<b>班级：</b>
 							<select id="selectError"  style="width: 100px;" onchange="selstu(this);">
		 						<c:forEach items="${listAllClass}" var="obj">
		 							<option value="${obj.CLASSID }">${obj.CLASSNAME }</option>
		 						</c:forEach>
							</select>
 					
 							
 						
 							<b>姓名：</b>
 						
 							<select id="stuname"  style="width: 100px;" name="xu.stuid">
		 						
							</select>
 						
 						</div>
 					</div>
 					
 					      
 					  <div class="box-content">
						<div class="control-group">
						<label class="control-label" for="selectError">学期</label>
							<div class="controls">
							<select id="selectError" data-rel="chosen" style="width: 100px;"  name="xu.xueqiId">
								<option value="1">第一学期</option>
								<option value="2">第二学期</option>
								<option value="3">第三学期</option>							
							</select>
							</div>
						</div>
                   	</div>
                    
                     <div class="box-content">
						<div class="control-group">
                        	<label for="exampleInputEmail1">实际缴费</label>
                        	<input type="text" id="t2" class="form-control" id="ename" style="width: 300px;"  name="xu.jine">
                    	</div>
                    </div>
                    
                     <div class="box-content">
						<div class="control-group">
                        	<label for="exampleInputEmail1">经手人</label>
                        	<input value="${teacher.ename }" readonly="readonly" type="text" id="t3" class="form-control" id="ename" style="width: 300px;"  name="xu.jingshouren">
                    	</div>
                    </div>
 					          
                   <div class="box-content">
						<div class="control-group">
						<label class="control-label" for="selectError">缴费方式</label>
							<div class="controls">
							<select id="selectError" data-rel="chosen" style="width: 100px;"  name="xu.jiaofeiFangshi">
								<option value="0">现金</option>
								<option value="1">银行转账</option>
								<option value="2">支付宝转账</option>
								<option value="3">支票</option>								
							</select>
							</div>
						</div>
                   	</div>
                    
                   
					 <div class="box-content">
						<div class="control-group">
                        	<label for="exampleInputEmail1">收费时间</label>
                        	<input class="form-control" style="width: 300px;" type="text" id="b" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"   name="xu.xuefeiTime"/>
                    	</div>
                    </div>

  <!-- submit提交按钮样式 -->                    
                    <div class="box-content">
						<div class="control-group">
                    		<button type="submit" onclick="return check();" class="btn btn-default"><b>添加</b></button>
                    	</div>
                    </div>
                </form>


            </div>
        </div>
    </div>
    <!--/span-->

</div><!--/row-->

    <!-- content ends -->
	
 		<!-- external javascript -->

		<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

		<!-- library for cookie management -->
		<script src="js/jquery.cookie.js"></script>
		<!-- calender plugin -->
		<script src='bower_components/moment/min/moment.min.js'></script>
		<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
		<!-- data table plugin -->
		<script src='js/jquery.dataTables.min.js'></script>

		<!-- select or dropdown enhancer -->
		<script src="bower_components/chosen/chosen.jquery.min.js"></script>
		<!-- plugin for gallery image view -->
		<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
		<!-- notification plugin -->
		<script src="js/jquery.noty.js"></script>
		<!-- library for making tables responsive -->
		<script src="bower_components/responsive-tables/responsive-tables.js"></script>
		<!-- tour plugin -->
		<script
			src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
		<!-- star rating plugin -->
		<script src="js/jquery.raty.min.js"></script>
		<!-- for iOS style toggle switch -->
		<script src="js/jquery.iphone.toggle.js"></script>
		<!-- autogrowing textarea plugin -->
		<script src="js/jquery.autogrow-textarea.js"></script>
		<!-- multiple file upload plugin -->
		<script src="js/jquery.uploadify-3.1.min.js"></script>
		<!-- history.js for cross-browser state change on ajax -->
		<script src="js/jquery.history.js"></script>
		<!-- application script for Charisma demo -->
		<script src="js/charisma.js"></script>


	</body>
</html>
