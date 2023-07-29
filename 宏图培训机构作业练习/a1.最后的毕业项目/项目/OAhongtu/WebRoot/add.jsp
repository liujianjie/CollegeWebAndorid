<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
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
								<a href="#">Home</a>
							</li>
							<li>
								<a href="#">添加界面样式参考</a>
							</li>
						</ul>
					</div>
	            <!-- content starts -->
<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i> 添加界面</h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-setting btn-round btn-default"><i
                            class="glyphicon glyphicon-cog"></i></a>
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
            <div class="box-content">
                <form role="form">
 <!-- 普通框样式 -->                 
                    <div class="box-content">
                      <label for="exampleInputEmail1">姓名</label>
						<div class="control-group" style="height:30px;width:300px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:35px">
                        <input type="email" class="form-control" id="ename" placeholder="请输入姓名" style="width:170px;">
                    </div>
                    </div>
  <!-- 密码框样式 -->                    
                    <div class="box-content">
							<div class="control-group">
                         <label for="exampleInputPassword1" >密码</label>
	                   <div class="control-group" style="height:30px;width:300px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:35px">
	                        <input type="password" class="form-control" id="pwd" placeholder="请输入密码"  style="width:170px;">
	                    </div>
                    </div>
 <!-- 下拉框样式 --> 
						<div class="box-content">
							<div class="control-group">
								<label class="control-label" for="selectError">员工状态（下拉框）</label>
								<div class="controls">
									<select id="selectError" data-rel="chosen"  style="width:100px;">
										<option>试用期</option>
										<option>已转正</option>
										<option>已离职</option>								
									</select>
								</div>
							</div>
                  	  </div>
<!-- 文件上传（可上传头像图片） -->
                    <div class="box-content">
						<div class="control-group">
	                        <label for="exampleInputFile">文件上传（可上传头像图片）</label>
	                        <input type="file" id="photo">
	                    </div>
                    </div>
 <!-- 复选框样式 -->                   
                     <label class="checkbox-inline">
	                    <input type="checkbox" id="inlineCheckbox1" value="option1"> 1
	                </label>
	                <label class="checkbox-inline">
	                    <input type="checkbox" id="inlineCheckbox2" value="option2"> 2
	                </label>
	                <label class="checkbox-inline">
	                    <input type="checkbox" id="inlineCheckbox3" value="option3"> 3
	                </label>
                
                <br/>
                
 <!-- 单选框样式 --> 
                <label class="radio-inline">
                    <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 1
                </label>
                <label class="radio-inline">
                    <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 2
                </label>
                <label class="radio-inline">
                    <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> 3
                </label>
                
                
                <br/>
                
 <!-- 下拉删除框样式 -->               
                     <div class="box-content" style="width:800px;">
						<div class="control-group">
                    <label class="control-label" for="selectError1">下拉删除框</label>
                    <div class="controls">
                        <select id="selectError1" multiple class="form-control" data-rel="chosen">
                            <option>选项 1</option>
                            <option selected>选项 2</option>
                            <option>选项 3</option>
                            <option>选项 4</option>
                            <option>选项 5</option>
                        </select>
                    </div>
                    </div>
                </div>
                
<!-- 分组选择下拉框样式 -->   
                <div class="box-content">
						<div class="control-group"">
                    <label class="control-label" for="selectError2">分组选择下拉框</label>
                    <div class="controls">
                        <select data-placeholder="请选择" id="selectError2" data-rel="chosen">
                            <option value=""></option>
                            <optgroup label="分组名称一">
                                <option>成员一</option>
                                <option>成员二</option>
                                <option>成员三</option>
                                <option>成员四</option>
                            </optgroup>
                            <optgroup label="分组名称二">
                                <option>成员一</option>
                                <option>成员二</option>
                                <option>成员三</option>
                            </optgroup>
                        </select>
                    </div>
                </div>
                </div>
                
                
                <br/>

<!-- 禁止选择复选框样式 -->
                <div class="checkbox" selected>
                    <label>
                        <input type="checkbox" value="">
                        选项一
                    </label>
                    </div>
                    <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">
                        选项二
                    </label>
                </div>
                <div class="checkbox disabled">
                    <label>
                        <input type="checkbox" value="" disabled>
                        选项二（禁选）
                    </label>
                </div>
                
                <br/>
                
                
<!-- 禁止选择单选框样式 -->
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                        选项一
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                        选项二
                    </label>
                </div>
                <div class="radio disabled">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3" disabled>
                        选项三（禁选）
                    </label>
                </div>
                
  <!-- submit提交按钮样式 -->                    
                    <div class="box-content">
						<div class="control-group">
                    		<button type="submit" class="btn btn-default">添加</button>
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
