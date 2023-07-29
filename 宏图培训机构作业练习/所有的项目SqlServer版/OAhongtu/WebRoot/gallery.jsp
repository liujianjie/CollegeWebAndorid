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
								<a href="#">Gallery</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-picture"></i> Gallery
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-setting btn-round btn-default"><i
											class="glyphicon glyphicon-cog"></i>
										</a>
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i>
										</a>
										<a href="#" class="btn btn-close btn-round btn-default"><i
											class="glyphicon glyphicon-remove"></i>
										</a>
									</div>
								</div>
								<div class="box-content">
									<br>
									<ul class="thumbnails gallery">
										<li id="image-1" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/1.jpg)"
												title="Sample Image 1"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/1.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/1.jpg"
													alt="Sample Image 1">
											</a>
										</li>
										<li id="image-2" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/2.jpg)"
												title="Sample Image 2"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/2.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/2.jpg"
													alt="Sample Image 2">
											</a>
										</li>
										<li id="image-3" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/3.jpg)"
												title="Sample Image 3"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/3.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/3.jpg"
													alt="Sample Image 3">
											</a>
										</li>
										<li id="image-4" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/4.jpg)"
												title="Sample Image 4"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/4.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/4.jpg"
													alt="Sample Image 4">
											</a>
										</li>
										<li id="image-5" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/5.jpg)"
												title="Sample Image 5"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/5.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/5.jpg"
													alt="Sample Image 5">
											</a>
										</li>
										<li id="image-6" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/6.jpg)"
												title="Sample Image 6"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/6.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/6.jpg"
													alt="Sample Image 6">
											</a>
										</li>
										<li id="image-7" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/7.jpg)"
												title="Sample Image 7"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/7.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/7.jpg"
													alt="Sample Image 7">
											</a>
										</li>
										<li id="image-8" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/8.jpg)"
												title="Sample Image 8"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/8.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/8.jpg"
													alt="Sample Image 8">
											</a>
										</li>
										<li id="image-9" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/9.jpg)"
												title="Sample Image 9"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/9.jpg">
												<img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/9.jpg"
													alt="Sample Image 9">
											</a>
										</li>
										<li id="image-10" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/10.jpg)"
												title="Sample Image 10"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/10.jpg">
												<img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/10.jpg"
													alt="Sample Image 10">
											</a>
										</li>
										<li id="image-11" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/11.jpg)"
												title="Sample Image 11"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/11.jpg">
												<img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/11.jpg"
													alt="Sample Image 11">
											</a>
										</li>
										<li id="image-12" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/12.jpg)"
												title="Sample Image 12"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/12.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/12.jpg"
													alt="Sample Image 12">
											</a>
										</li>
										<li id="image-13" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/13.jpg)"
												title="Sample Image 13"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/13.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/13.jpg"
													alt="Sample Image 13">
											</a>
										</li>
										<li id="image-14" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/14.jpg)"
												title="Sample Image 14"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/14.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/14.jpg"
													alt="Sample Image 14">
											</a>
										</li>
										<li id="image-15" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/15.jpg)"
												title="Sample Image 15"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/15.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/15.jpg"
													alt="Sample Image 15">
											</a>
										</li>
										<li id="image-16" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/16.jpg)"
												title="Sample Image 16"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/16.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/16.jpg"
													alt="Sample Image 16">
											</a>
										</li>
										<li id="image-17" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/17.jpg)"
												title="Sample Image 17"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/17.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/17.jpg"
													alt="Sample Image 17">
											</a>
										</li>
										<li id="image-18" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/18.jpg)"
												title="Sample Image 18"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/18.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/18.jpg"
													alt="Sample Image 18">
											</a>
										</li>
										<li id="image-19" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/19.jpg)"
												title="Sample Image 19"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/19.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/19.jpg"
													alt="Sample Image 19">
											</a>
										</li>
										<li id="image-20" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/20.jpg)"
												title="Sample Image 20"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/20.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/20.jpg"
													alt="Sample Image 20">
											</a>
										</li>
										<li id="image-21" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/21.jpg)"
												title="Sample Image 21"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/21.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/21.jpg"
													alt="Sample Image 21">
											</a>
										</li>
										<li id="image-22" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/22.jpg)"
												title="Sample Image 22"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/22.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/22.jpg"
													alt="Sample Image 22">
											</a>
										</li>
										<li id="image-23" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/23.jpg)"
												title="Sample Image 23"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/23.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/23.jpg"
													alt="Sample Image 23">
											</a>
										</li>
										<li id="image-24" class="thumbnail">
											<a
												style="background: url(https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/24.jpg)"
												title="Sample Image 24"
												href="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/24.jpg"><img
													class="grayscale"
													src="https://raw.githubusercontent.com/usmanhalalit/charisma/1.x/img/gallery/thumbs/24.jpg"
													alt="Sample Image 24">
											</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<!--/span-->

					</div>
					<!--/row-->

					<!-- content ends -->
				</div>
				<!--/#content.col-md-0-->
			

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

