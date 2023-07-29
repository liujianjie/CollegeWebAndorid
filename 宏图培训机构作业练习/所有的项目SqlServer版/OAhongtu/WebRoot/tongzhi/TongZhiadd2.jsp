<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 添加学生公告页面 -->

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

<!-- 

	<script type="text/javascript">

	$(function(){
	
		$.post("xiebaolei/json!selAllEmp.action",{},function(data){
			//alert("aaaaaaaaaaaa");
			var list=data.listEmp;
			for(var i=0;i<list.length;i++){
				var obj=list[i];
				//alert(obj.EID);
				var option=$("<option>",{
					text:obj.ENAME,
					val:obj.ENAME
				});
				$("#selectError").append(option);
			}
		},"json");
	});
</script>
 -->

<link rel="stylesheet"
			href="kindeditor-4.1.10/themes/default/default.css" />
		<script charset="utf-8" src="kindeditor-4.1.10/kindeditor-min.js"></script>

		<script type="text/javascript">
		var editor;
		KindEditor.ready(function(k){
			 editor=k.create("#kind_editor", {
				items : [
							'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
							'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
							'insertunorderedlist', '|', 'emoticons']
					});
		});
		
</script>
	</head>

	<body>
	<div class="ch-container">
    <div class="row"> 

				

				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">&nbsp; 
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="homepage(tea).jsp">首页</a>
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
                <h2><i class="glyphicon glyphicon-edit"></i> 
	              
	              
	                	添加学生公告
	            
                </h2>

            </div>
            <div class="box-content">
                <form role="form" action="xiebaolei/add.action" method="post">
 <!-- 普通框样式 -->     
 				    <input type="hidden" value="2" name="msg.msgface">       
                    
                   <div class="box-content">
						<label for="exampleInputEmail1">
							公告标题： &nbsp;&nbsp;
						</label>
						<div class="control-group"
							style="height: 30px; width: 140px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 8px">               	
                        	<input type="text" class="form-control" placeholder="请输入公告标题" id="ename" style="width: 300px;"  name="msg.msgtitle">
                    	</div>
                    </div>
                    
                    <div class="box-content">
						<label for="exampleInputEmail1">
							公告内容： &nbsp;&nbsp;
						</label>
						<div class="control-group"
							style="height: 30px; width: 140px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 8px">
							<textarea rows="10" cols="100" name="sbk.sbackcon" id="kind_editor"> 
                   						</textarea>
						</div>
                    </div>
                    <br/><br/><br/><br/><br/><br/><br/>
                    <div class="box-content">
						<div class="control-group">
						<br/><br/>
						<label class="control-label" for="selectError">发布人： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<div class="controls"
								style="height: 30px; width: 140px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 8px">
							<!-- 
								<select id="selectError"  style="width: 100px;"  name="msg.faburen">
														
							</select>
							 -->
							 <input  class="form-control" value="${teacher.ename }" readonly="readonly" type="text" name="msg.faburen">
							</div>
							<div class="controls"
							style="height: 30px; width: 140px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 8px">							
                    			<button type="submit" class="btn btn-default"><b>添加</b></button>
                    		</div>
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
