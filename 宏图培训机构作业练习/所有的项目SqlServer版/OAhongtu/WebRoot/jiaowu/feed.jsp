<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE  html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<base href="<%=basePath%>">

		<title>Free HTML5 Bootstrap Admin Template</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description"
			content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
		<meta name="author" content="Muhammad Usman">

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


		<!-- The styles -->
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<!--		<style type="text/css">-->
<!--* {-->
<!--	margin: 0;-->
<!--	padding: 0;-->
<!--}-->
<!---->
<!--.wrapper {-->
<!--	height: 30px;-->
<!--	padding: 5px;-->
<!--	width: 230px;-->
<!--	margin: 0 0 0 10px;-->
<!--}-->
<!---->
<!--a {-->
<!--	float: left;-->
<!--	width: 26px;-->
<!--	height: 20px;-->
<!--	background: url(img/star.png) 0 -20px no-repeat;-->
<!--}-->
<!---->
<!--p {-->
<!--	font: 20px SimSun;-->
<!--	width: 200px;-->
<!--	margin-left: 200px;-->
<!--	margin-right: auto;-->
<!--}-->
<!--</style>-->

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

		<form
			action="chenru/feedsave.action?stuid=${stu.intenid }&classid=${cs.classid }&empid=${emp.eid }&year=${fed.fedtime }&month=${fed.fedmonth }&stuclassid=${cs.classid }"
			method="post" enctype="multipart/form-data">
			<input type="hidden" class="form-con0trol" name="fed.fedid"
				value="${fed.fedid }">
			<div class="ch-container">
				<center>
					<h3 class="animated rubberBand">
						<b><font color="black">教员月度反馈表</font>
						</b>
					</h3>
				</center>
				<table
					class="table table-striped table-bordered bootstrap-datatable datatable responsive">
					<thead>
						<tr>
							<th width="10%">
							<input type="hidden" name="feedid" value="${fdid }"/>
								班级
							</th>
							<th>
								<input type="text" name="feedback.cid" class="form-control"
									style="width: 140px;" value="${cs.classname }" disabled="disabled">
							</th>
							<th width="10%">
								教员
							</th>
							<th>
								<input type="text" name="feedback.empid" class="form-control"
									style="width: 140px;" value="${emp.ename }" disabled="disabled"/>
							</th>

							<th colspan="5" width="55%">
								得分
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th colspan="4">
								反馈项
							</th>
							<th class="center">
								5
							</th>
							<th class="center">
								4
							</th>
							<th class="center">
								3
							</th>
							<th class="center">
								2
							</th>
							<th class="center">
								1
							</th>
						</tr>
												<tr>
													<th colspan="4">
													课堂准备充分，授课思路清晰
													</th>
													<td class="center">
													<input type="radio" name="feedback.s1" value="5" style="width:17px;height:17px;" checked="checked"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s1" value="4" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s1" value="3" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s1" value="2" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s1" value="1" style="width:17px;height:17px;"/>
													</td>
												</tr>
											<tr>
													<th colspan="4">
														案例丰富实用，讲解与实战演示结合
													</th>
													<td class="center">
													<input type="radio" name="feedback.s2" value="5" style="width:17px;height:17px;"checked="checked"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s2" value="4" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s2" value="3" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s2" value="2" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s2" value="1" style="width:17px;height:17px;"/>
													</td>
												</tr>
												<tr>
													<th colspan="4">
														课堂气氛活跃，语言生动活泼
													</th>
														<td class="center">
													<input type="radio" name="feedback.s3" value="5" style="width:17px;height:17px;" checked="checked"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s3" value="4" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s3" value="3" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s3" value="2" style="width:17px;height:17px;"/>
													<td class="center">
													<input type="radio" name="feedback.s3" value="1" style="width:17px;height:17px;"/>
													</td>
												</tr>
												<tr>
													<th colspan="4">
														技术实力强，知识面广，经验丰富
													</th>
													<td class="center">
													<input type="radio" name="feedback.s4" value="5" style="width:17px;height:17px;"checked="checked"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s4" value="4" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s4" value="3" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s4" value="2" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s4" value="1" style="width:17px;height:17px;"/>
													</td>
												</tr>
												<tr>
													<th colspan="4">
														辅导学员耐心细致、解决问题能力强
													</th>
														<td class="center">
													<input type="radio" name="feedback.s5" value="5" style="width:17px;height:17px;"checked="checked"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s5" value="4" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s5" value="3" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s5" value="2" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s5" value="1" style="width:17px;height:17px;"/>
													</td>
												</tr>
												<tr>
													<th colspan="4">
														及时讲解练习中普遍存在的问题
													</th>
														<td class="center">
													<input type="radio" name="feedback.s6" value="5" style="width:17px;height:17px;"checked="checked"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s6" value="4" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s6" value="3" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s6" value="2" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s6" value="1" style="width:17px;height:17px;"/>
													</td>
												</tr>
												<tr>
													<th colspan="4">
														课堂纪律管理是否严格
													</th>
														<td class="center">
													<input type="radio" name="feedback.s7" value="5" style="width:17px;height:17px;"checked="checked"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s7" value="4" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s7" value="3" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s7" value="2" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s7" value="1" style="width:17px;height:17px;"/>
													</td>
												</tr>
												<tr>
													<th colspan="4">
														作业检查是否认真、到位
													</th>
														<td class="center">
													<input type="radio" name="feedback.s8" value="5" style="width:17px;height:17px;"checked="checked"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s8" value="4" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s8" value="3" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s8" value="2" style="width:17px;height:17px;"/>
													</td>
													<td class="center">
													<input type="radio" name="feedback.s8" value="1" style="width:17px;height:17px;"/>
													</td>
												</tr>
						<tr>
							<th colspan="2">
								问题与建议
							</th>
							<td class="center" colspan="7">
								<textarea rows="5" cols="120" class="autogrow"
									name="feedback.fpro" id="kind_editor"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
<!--				<div style="float: right;">-->
<!--					<input type="checkbox" value="1" name="feedback.states" />-->
<!--					&nbsp;&nbsp;匿名提交-->
<!--				</div>-->
				<br />
				<!-- submit提交按钮样式 -->
				<div class="box-content">

					<div class="form-group"
						style="height: 40px; width: 200px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 738px;">
						<button type="button" class="btn btn-default"
							style="width: 150px;"
							onclick="location.href='chenru/stufedlist.action?stuclassid=${cs.classid }';">
							放 &nbsp;&nbsp; 弃
						</button>
					</div>

					<div class="form-group"
						style="height: 40px; width: 1px; display: inline-block; margin-bottom: 0; vertical-align: middle;">
						<button type="submit" class="btn btn-default"
							style="width: 150px;">
							提 &nbsp;&nbsp; 交
						</button>
					</div>

				</div>
		</form>


<!--		<script type="text/javascript">-->
<!---->
<!--window.onload = function(){-->
<!--	var star = document.getElementsByTagName('a');-->
<!--	var oDiv = document.getElementsByTagName('div')[0];-->
<!--	var temp = 0;-->
<!--	for(var i = 0, len = star.length; i < len; i++){-->
<!--		star[i].index = i;-->
<!--		star[i].onmouseover = function(){-->
<!--			clear();-->
<!--			for(var j = 0; j < this.index + 1; j++){-->
<!--				star[j].style.backgroundPosition = '0 0';-->
<!--			}-->
<!--		}-->
<!--		star[i].onmouseout = function(){-->
<!--			for(var j = 0; j < this.index + 1; j++){-->
<!--				star[j].style.backgroundPosition = '0 -20px';-->
<!--			}-->
<!--			current(temp);-->
<!--		}-->
<!--		star[i].onclick = function(){-->
<!--			temp = this.index + 1;-->
<!--			document.getElementsByTagName('p')[0].innerHTML = temp + ' 分';-->
<!--			current(temp);-->
<!--		}-->
<!--	}-->
<!--	//清除所有-->
<!--	function clear(){-->
<!--		for(var i = 0, len = star.length; i < len; i++){-->
<!--			star[i].style.backgroundPosition = '0 -20px';-->
<!--		}-->
<!--	}-->
<!--	//显示当前第几颗星-->
<!--	function current(temp){-->
<!--		for(var i = 0; i < temp; i++){-->
<!--			star[i].style.backgroundPosition = '0 0';-->
<!--		}-->
<!--	}-->
<!--	-->
<!--/*第二行*/-->
<!--	var star2 = document.getElementById('a2');-->
<!--	var oDiv2 = document.getElementById('div2')[0];-->
<!--	var temp2 = 0;-->
<!--	for(var i = 0, len = star2.length; i < len; i++){-->
<!--		star2[i].index = i;  -->
<!--		star2[i].onmouseover = function(){-->
<!--			clear2();-->
<!--			for(var j = 0; j < this.index + 1; j++){-->
<!--				star2[j].style.backgroundPosition = '0 0';-->
<!--			}-->
<!--		}-->
<!--		star2[i].onmouseout = function(){-->
<!--			for(var j = 0; j < this.index + 1; j++){-->
<!--				star2[j].style.backgroundPosition = '0 -20px';-->
<!--			}-->
<!--			current2(temp2);-->
<!--		}-->
<!--		star2[i].onclick = function(){-->
<!--			temp2 = this.index + 1;-->
<!--			document.getElementById('p2')[0].innerHTML = temp2 + ' 分';-->
<!--			current2(temp2);-->
<!--		}-->
<!--	}-->
<!--	//清除所有-->
<!--	function clear2(){-->
<!--		for(var i = 0, len = star2.length; i < len; i++){-->
<!--			star2[i].style.backgroundPosition = '0 -20px';-->
<!--		}-->
<!--	}-->
<!--	//显示当前第几颗星-->
<!--	function current2(temp2){-->
<!--		for(var i = 0; i < temp2; i++){-->
<!--			star2[i].style.backgroundPosition = '0 0';-->
<!--		}-->
<!--	}-->
<!--};-->
<!---->
<!--</script>-->

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

