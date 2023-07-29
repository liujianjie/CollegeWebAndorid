<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>宏图软件办公系统</title>
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
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		
		<style>
			.newlist li a{
				color:#8e8e8e;
			}
			.newlist li a:hover{
				color:#c8c8c8;
			}
			.newlist2 li{
				margin-left:15px
			}
			.newlist2 li a{
				color:#8e8e8e;
			}
			.newlist2 li a:hover{
				color:#c8c8c8;
			}
			.tooli{padding:30px 20px;}
			.tooli li{float:left;padding-left:15px; padding-right:10px;margin-bottom:20px;}
			.tooli li span{text-align:center;}
			.tooli li p{line-height:35px; text-align:left;}
			.pagin .paginList{position:absolute;right:16px;top:0px;}
			.pagin .paginList .paginItem{float:left;}
			.pagin .paginList .paginItem a{float:left;width:37px;height:37px;border:1px solid #DDD; text-align:center;line-height:30px;border-left:none;color:#3399d5;}

			.pagin .paginList .paginItem.current,.pagin .paginList .paginItem.current a{background:#f5f5f5; cursor:default;color:#737373;}
		</style>
		
	</head>

	<body>
	
		<jsp:include page="student/common.jsp"></jsp:include>

		<div class="row">
			
			<!-- 值班表开始 -->
			
			<div class="box col-md-12" style="width:67%;">
				<div class="box-inner" style="height:360px">
					<div class="box-header well">
						<h2>
							<i class="glyphicon glyphicon-info-sign"></i>值班表
						</h2>

						<div class="box-content" >
							
						</div>
					</div>
					<!-- 表格开始 -->
					<div class="box-content" id="div1">	
					
					</div>
					<div id="ddiv" style="position:absolute;top:0px;display:none;
    					left:0px;width:735px;height:360px;background-color:#f6f6f6">
    				</div>
				</div>
			</div>
			<!-- 值班表结束 -->
			<!-- 通知公告 -->
			<div class="box col-md-12" style="width:33%">
				<div class="box-inner">
					<div class="box-header well">
						<h2>
							<i class="glyphicon glyphicon-info-sign"></i>通知/公告
						</h2>

						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round btn-default"><i
								class="glyphicon glyphicon-chevron-up"></i>
							</a>
							<a href="#" class="btn btn-close btn-round btn-default"><i
								class="glyphicon glyphicon-remove"></i>
							</a>
						</div>
					</div>
					<div class="box-content row">
						<div  style="height: 250px">
							<ul class="newlist" id="div2">
								
							</ul>
														
						</div>
						<!-- Ads, you can remove these -->
						<div class="col-lg-5 col-md-12 hidden-xs center-text"
							style="height: 50px">
							<script async
								src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
							<!-- Charisma Demo 4 -->
							<ins class="adsbygoogle"
								style="display: inline-block; width: 336px; height: 280px"
								data-ad-client="ca-pub-5108790028230107"
								data-ad-slot="9467443105"></ins>
							<script>
                        (adsbygoogle = window.adsbygoogle || []).push({});
                    </script>
						</div>

						<div class="col-lg-5 col-md-12 visible-xs center-text"
							style="height: 30px">
							<script async
								src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
							<!-- Charisma Demo 5 -->
							<ins class="adsbygoogle"
								style="display: inline-block; width: 250px; height: 250px"
								data-ad-client="ca-pub-5108790028230107"
								data-ad-slot="8957582309"></ins>
							<script>
                        (adsbygoogle = window.adsbygoogle || []).push({});
                    </script>
						</div>
						<!-- Ads end -->

					</div>
				</div>
			</div>
			<!-- 通知公告结束 -->
		</div>
		
		
		
		<!-- 教师通讯录开始 -->
		<div class="row">
			
			<div class="box col-md-4">
				<div class="box-inner homepage-box" style="height:238px">
					<div class="box-header well">
						<h2>
							<i class="glyphicon glyphicon-th"></i>教师通讯录
						</h2>

						<div class="box-icon" >
							
						</div>
					</div>
					<div class="box-content" id="div4" >
					
					</div>
					<div id="ddivs" style="position:absolute;top:0px;display:none;
						left:0px;width:735px;height:240px;background-color:#f6f6f6">
					</div>
				</div>
			</div>
			<!-- 教师通讯录结束 -->
	
			<!-- 快捷入口开始 -->
			<div class="box col-md-4" id="div5">
				<div class="box-inner">
					<div class="box-header well" data-original-title="">
						<h2>
							<i class="glyphicon glyphicon-user"></i>快捷入口
						</h2>

					</div>
					<div class="box-content" class="inforight" style="height:200px">
						<div style="margin-top:-15px">
							<ul style="list-style-type:none" class="tooli">
							    <li><span><img src="images/d01.png" width="32" height="32"/></span><p><a href="stu/seldan2?intenid=${stu.intenid }">个人信息</a></p></li>
							    <li><span><img src="images/d02.png" width="32" height="32"/></span><p><a href="score/scosx2">成绩</a></p></li>
							    <li><span><img src="images/d03.png" width="32" height="32"/></span><p><a href="prj/prjsx2">项目</a></p></li>
							    <li><span><img src="images/d04.png" width="32" height="32"/></span><p><a href="says/sayssx2">谈心</a></p></li>
							    <li><span><img src="images/d05.png" width="32" height="32"/></span><p><a href="lev/levsx2">请假</a></p></li>
							    <li><span><img src="images/d06.png" width="32" height="32"/></span><p><a href="sbk/sbksx2">意见</a></p></li>
							    <li><span><img src="images/d07.png" width="32" height="32"/></span><p><a href="summary/smysx2">总结</a></p></li>    
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- 快捷入口结束 -->
			<!-- 快捷入口开始 偷天换日-->
			<div class="box col-md-4" id="div6" style="display: none">
				
			</div>
			<!-- 快捷入口结束 -->
			<!-- 意见反馈开始 -->
			<div class="box col-md-4">
				<div class="box-inner homepage-box" style="height:238px">
					<div class="box-header well" data-original-title="">
						<h2>
							<i class="glyphicon glyphicon-list-alt"></i>意见反馈
						</h2>

						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round btn-default"><i
								class="glyphicon glyphicon-chevron-up"></i>
							</a>
							<a href="#" class="btn btn-close btn-round btn-default"><i
								class="glyphicon glyphicon-remove"></i>
							</a>
						</div>
						
					</div>
					<div class="box-content row">
						<ul class="newlist" id="div3">
								
						</ul>
					</div>

				</div>
			</div>
			<!--/span-->
		</div>
		<!-- 意见反馈结束 -->
		
		<!-- json -->
		<script type="text/javascript">
			function gofen(val,val2){
				//先隐藏
				document.getElementById("div1").style.display="none";
				document.getElementById("div2").style.display="none";
				document.getElementById("div3").style.display="none";
				document.getElementById("div4").style.display="none";
				
				$.post("stumain/sellist",{cpage:val,cpage2:val2},function(data){
					//值班
					var zblist=data.zblist;
					//公告
					var tzlist=data.tzlist;
					//意见反馈
					var yjlist=data.yjlist;
					var lxlist=data.lxlist;
					
					var table=$("<table>",{
						"class":"table table-striped table-bordered",
						"id":"table"
					});
					var thead=$("<thead>",{
					});
					var tr=$("<tr>",{
					});
					var th1=$("<th>",{
						"text":"时间"
					});
					var th2=$("<th>",{
						"text":"值班老师"
					});
					var th3=$("<th>",{
						"text":"值班范围"
					});
					var th4=$("<th>",{
						"text":"值班老师"
					});
					var th5=$("<th>",{
						"text":"值班范围"
					});
					var th6=$("<th>",{
						"text":"值班班主任"
					});
					var th7=$("<th>",{
						"text":"总值班"
					});
					tr.append(th1);
					tr.append(th2);
					tr.append(th3);
					tr.append(th4);
					tr.append(th5);
					tr.append(th6);
					tr.append(th7);
					thead.append(tr);
					table.append(thead);
					
					var tbody=$("<tbody>",{
					});
					$.each(zblist,function(index,obj){
						var tr2=$("<tr>",{
						});
						var td1=$("<td>",{
							"text":obj.zdate
						});
						var td2=$("<td>",{
							"text":obj.zteach1
						});
						var td3=$("<td>",{
							"text":obj.zfanwei1
						});
						var td4=$("<td>",{
							"text":obj.zteach2
						});
						var td5=$("<td>",{
							"text":obj.zfanwei2
						});
						var td6=$("<td>",{
							"text":obj.teachs
						});
						var td7=$("<td>",{
							"text":obj.zteachers
						});
						tr2.append(td1);
						tr2.append(td2);
						tr2.append(td3);
						tr2.append(td4);
						tr2.append(td5);
						tr2.append(td6);
						tr2.append(td7);
						tbody.append(tr2);
					});
					table.append(tbody);
					$("#div1").html(table);
					
					//淡入
					$("#div1").fadeIn(600);
					
					var currPage=data.currPage;
					var pageCount=data.pageCount;
					var totalCount=data.totalCount;
					var totalPage=data.totalPage;
					var currPage2=data.currPage2;
					var pageCount2=data.pageCount2;
					var totalCount2=data.totalCount2;
					var totalPage2=data.totalPage2;
					
					var zbdiv=$("<div>",{
						"class":"pagin"
					});
					var zbul=$("<ul>",{
						"class":"paginList",
						"style":"list-style-type:none"
					});
					for(var i=1;i<totalPage+1;i++){
						if(i==currPage){
							var li=$("<li>",{
								"class":"paginItem current"
							});
						}else{
							var li=$("<li>",{
								"class":"paginItem"
							});
						}
						
						var a=$("<a>",{
							"href":"javascript:",
							"text":i,
							"onclick":"zbfy("+i+")"
						});
						li.append(a);
						zbul.append(li);
					}
					zbdiv.append(zbul);
					$("#div1").append(zbdiv);
					
					//通知
					var ui=$("<ui>",{
						"class":"newlist"
					});
					$.each(tzlist,function(index,obj){
						var li=$("<li>",{
							
						});
						var a=$("<a>",{
							"href":"xiebaolei/xq?id="+obj.MSGID,
							"text":obj.MSGTITLE,
							"onmouseover":"xq("+obj.MSGID+")",
							"onmouseout":"none()"
						});
						li.append(a);
						ui.append(li);
					});
					$("#div2").html(ui);
					//淡入
					$("#div2").fadeIn(600);
					
					//意见
					$.each(yjlist,function(index,obj){
						var li=$("<li>",{
							
						});
						var a=$("<a>",{
							"html":obj.SBACKTITLE,
							"onmouseover":"xq2("+obj.SBACKID+")",
							"onmouseout":"nones()"
						});
						li.append(a);
						$("#div3").append(li);
					});
					//淡入
					$("#div3").fadeIn(600);
					
					//联系电话
					var table2=$("<table>",{
							"class":"table table-striped table-bordered"
					});
					var tbody2=$("<tbody>",{
							
					});
					$.each(lxlist,function(index,obj){
						
						var tr=$("<tr>",{
							
						});
						var td2=$("<td>",{
							"text":obj.ENAME,
							"width":"30%"
						});
						var td=$("<td>",{
							"text":obj.EPHONE,
							"width":"70%"
						});
						tr.append(td2);
						tr.append(td);
						tbody2.append(tr);
					});
					table2.append(tbody2);
					$("#div4").html(table2);
					//淡入
					$("#div4").fadeIn(600);
										
					var zbdiv=$("<div>",{
						"class":"pagin"
					});
					var zbul=$("<ul>",{
						"class":"paginList",
						"style":"list-style-type:none"
					});
					for(var i=1;i<totalPage2+1;i++){
						if(i==currPage2){
							var li=$("<li>",{
								"class":"paginItem current"
							});
						}else{
							var li=$("<li>",{
								"class":"paginItem"
							});
						}
						
						var a=$("<a>",{
							"href":"javascript:",
							"text":i,
							"onclick":"lxfy("+i+")"
						});
						li.append(a);
						zbul.append(li);
					}
					zbdiv.append(zbul);
					$("#div4").append(zbdiv);
					
				},"json");
			}
			gofen(1,1);
			//值班分页
			function zbfy(val){
				//清空
				document.getElementById("div1").style.display="none";
				$.post("stumain/zblist",{cpage:val},function(data){
					//值班
					var zblist=data.zblist;
					
					var table=$("<table>",{
						"class":"table table-striped table-bordered",
						"id":"table"
					});
					var thead=$("<thead>",{
					});
					var tr=$("<tr>",{
					});
					var th1=$("<th>",{
						"text":"时间"
					});
					var th2=$("<th>",{
						"text":"值班老师"
					});
					var th3=$("<th>",{
						"text":"值班范围"
					});
					var th4=$("<th>",{
						"text":"值班老师"
					});
					var th5=$("<th>",{
						"text":"值班范围"
					});
					var th6=$("<th>",{
						"text":"值班班主任"
					});
					var th7=$("<th>",{
						"text":"总值班"
					});
					tr.append(th1);
					tr.append(th2);
					tr.append(th3);
					tr.append(th4);
					tr.append(th5);
					tr.append(th6);
					tr.append(th7);
					thead.append(tr);
					table.append(thead);
					
					var tbody=$("<tbody>",{
					});
					$.each(zblist,function(index,obj){
						var tr2=$("<tr>",{
						});
						var td1=$("<td>",{
							"text":obj.zdate
						});
						var td2=$("<td>",{
							"text":obj.zteach1
						});
						var td3=$("<td>",{
							"text":obj.zfanwei1
						});
						var td4=$("<td>",{
							"text":obj.zteach2
						});
						var td5=$("<td>",{
							"text":obj.zfanwei2
						});
						var td6=$("<td>",{
							"text":obj.teachs
						});
						var td7=$("<td>",{
							"text":obj.zteachers
						});
						tr2.append(td1);
						tr2.append(td2);
						tr2.append(td3);
						tr2.append(td4);
						tr2.append(td5);
						tr2.append(td6);
						tr2.append(td7);
						tbody.append(tr2);
					});
					table.append(tbody);
					
					$("#div1").html(table);
					var currPage=data.currPage;
					var pageCount=data.pageCount;
					var totalCount=data.totalCount;
					var totalPage=data.totalPage;
					
					var zbdiv=$("<div>",{
						"class":"pagin"
					});
					var zbul=$("<ul>",{
						"class":"paginList",
						"style":"list-style-type:none"
					});
					for(var i=1;i<totalPage+1;i++){
						if(i==currPage){
							var li=$("<li>",{
								"class":"paginItem current"
							});
						}else{
							var li=$("<li>",{
								"class":"paginItem"
							});
						}
						
						var a=$("<a>",{
							"href":"javascript:",
							"text":i,
							"onclick":"zbfy("+i+")"
						});
						li.append(a);
						zbul.append(li);
					}
					zbdiv.append(zbul);
					
					$("#div1").append(zbdiv);
					$("#div1").fadeIn(600);
				},"json");
			}
			//联系分页
			function lxfy(val){
				//清空
				document.getElementById("div4").style.display="none";
				$.post("stumain/lxlist",{cpage2:val},function(data){
					var lxlist=data.lxlist;
					//联系电话
					var table2=$("<table>",{
							"class":"table table-striped table-bordered"
					});
					var tbody2=$("<tbody>",{
							
					});
					$.each(lxlist,function(index,obj){
						
						var tr=$("<tr>",{
							
						});
						var td2=$("<td>",{
							"text":obj.ENAME,
							"width":"30%"
						});
						var td=$("<td>",{
							"text":obj.EPHONE,
							"width":"70%"
						});
						tr.append(td2);
						tr.append(td);
						tbody2.append(tr);
					});
					table2.append(tbody2);
					$("#div4").html(table2);
					var currPage2=data.currPage2;
					var pageCount2=data.pageCount2;
					var totalCount2=data.totalCount2;
					var totalPage2=data.totalPage2;
					
					//头上的
					var zbdiv=$("<div>",{
						"class":"pagin"
					});
					var zbul=$("<ul>",{
						"class":"paginList",
						"style":"list-style-type:none"
					});
					for(var i=1;i<totalPage2+1;i++){
						if(i==currPage2){
							var li=$("<li>",{
								"class":"paginItem current"
							});
						}else{
							var li=$("<li>",{
								"class":"paginItem"
							});
						}
						
						var a=$("<a>",{
							"href":"javascript:",
							"text":i,
							"onclick":"lxfy("+i+")"
						});
						li.append(a);
						zbul.append(li);
					}
					zbdiv.append(zbul);
					$("#div4").append(zbdiv);	
					$("#div4").fadeIn(600);
					
				},"json");
			}
			function xq(id){
				
				var showdiv=document.getElementById("ddiv");
			
				$.post("stumain/xq",{msgid:id},function(data){
					var msg=data.msg;
					//margin-left:60px
					var str="<br>";
					str+="<div style='text-align:center'><font color='red' size='5'>"+msg.msgtitle+"</font></div><br>";
					str+="<div style='margin-left:65px;height:230px;width:600px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+msg.msgcon+"</div>";
					str+="<div style='margin-left:580px'>"+msg.faburen+"</div>";
					str+="<div style='margin-left:500px'>"+msg.fabutime+"</div>";
					showdiv.innerHTML=str;
				},"json");
				showdiv.style.left="0px";
				showdiv.style.top="0px";
				showdiv.style.display="inline";
			
			}
			function xq2(id){
				
				var showdiv=document.getElementById("ddivs");
				//获取当前鼠标坐标 好像不能放在回调方法中
			
				$.post("stumain/xq2",{sbackid:id},function(data){
					var sback=data.sback;
					var stulist=data.stulist;
					var str="<br>";
					str+="<div style='text-align:center'><font color='red' size='5'>"+sback.sbacktitle+"</font></div><br>";
					str+="<div style='margin-left:65px;height:130px;width:600px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+sback.sbackcon+"</div>";
					str+="<div style='margin-left:525px'>"+sback.sdate+"</div>";
					showdiv.innerHTML=str;
					
					showdiv.style.left="0px";
					showdiv.style.top="0px";
					showdiv.style.display="inline";
					document.getElementById("div5").style.display="none";
					document.getElementById("div6").style.display="";
				},"json");
			
			}
			function none(){
				var showdiv=document.getElementById("ddiv");
				showdiv.style.display="none";
			}
			function nones(){
				var showdiv=document.getElementById("ddivs");
				showdiv.style.display="none";
				document.getElementById("div5").style.display="";
				document.getElementById("div6").style.display="none";
			}
		</script>


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
