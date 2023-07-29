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
		
		
		
	<script type="text/javascript">
		$(function(){
			$.post("lcy/json!info",{},function(data){
				var zblist=data.zblist;
				//alert(zblist.length);
				
				var table=$("<table>",{
				
					"class":"table table-striped table-bordered bootstrap-datatable datatable responsive"
				
				});
				
				var tr=$("<tr>");
			
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
				
				table.append(tr);
				
				for(var i=0;i<zblist.length;i++){
					var zb=zblist[i];
					var tr=$("<tr>");
					
					var td1=$("<td>",{
						"text":zb.zdate
					});
					var td2=$("<td>",{
						"text":zb.zteach1
					});
					var td3=$("<td>",{
						"text":zb.zfanwei1
					});
					var td4=$("<td>",{
						"text":zb.zteach2
					});
					var td5=$("<td>",{
						"text":zb.zfanwei2
					});
					var td6=$("<td>",{
						"text":zb.teachs
					});
					var td7=$("<td>",{
						"text":zb.zteachers
					});
					
					tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					tr.append(td4);
					tr.append(td5);
					tr.append(td6);
					tr.append(td7);
					
					table.append(tr);
					
					
				}
				
				var tpage=data.totalPage;
				var cpage=data.currPage;
				var pcount=data.pageCount;
				
				var str="";
				str+="页数<font color=red>"+cpage+"/"+tpage+"</font>";
				str+=" <a href='javascript:void(0)' onclick=topage_zhiban(1,"+pcount+")>首页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_zhiban("+(cpage-1)+","+pcount+")>上一页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_zhiban("+(cpage+1)+","+pcount+")>下一页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_zhiban("+tpage+","+pcount+")>末页</a>";
				
				$("#zhibanbiao").html(table);
				$("#zhibanbiao").append(str);
				
				//通知
				var tzlist=data.tzlist;
				//alert(tzlist.length);
				var ul=$("<ul>");
				for(var j=0;j<tzlist.length;j++){
					var tz=tzlist[j];
					var a=$("<a>",{
						"html":"<font size=3>"+tz.MSGTITLE+"</font>",
						"href":"xiebaolei/xq?id="+tz.MSGID
						
					});
					var li=$("<li>",{
						"class":"biankuang"
					});
					li.append(a);
					
					ul.append(li);
					
				}
				
				$("#tongzhi").html(ul);
				
				
				//查通讯录（教师）
				var phonelist=data.phonelist;
				
				//alert("通讯录size:"+phonelist.length);
				
				var table=$("<table>",{
					"class":"table table-striped table-bordered bootstrap-datatable datatable responsive",
					"width":"100%",
					"align":"center"
				});
				var tr=$("<tr>");
				var td1=$("<th>",{
						"text":"姓名"
					});
				var td2=$("<th>",{
					"text":"联系电话"
				});
				
				tr.append(td1);
				tr.append(td2);
				
				table.append(tr);
				
				for(var x=0;x<phonelist.length;x++){
					var tr=$("<tr>");
					var phone=phonelist[x];
					
					//alert("员工姓名："+phone.TXL_ENAME);
					
					var td1=$("<td>",{
						"text":phone.TXL_ENAME
					});
					var td2=$("<td>",{
						"text":phone.TXL_EPHONE
					});
					
					tr.append(td1);
					tr.append(td2);
					
					table.append(tr);
				}
				
				var tpage=data.totalPage;
				var cpage=data.currPage;
				var pcount=data.pageCount2;
				var str="";
				
				str+="页数<font color=red>"+cpage+"/"+tpage+"</font>";
				str+=" <a href='javascript:void(0)' onclick=topage_dianhua(1,"+pcount+")>首页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_dianhua("+(cpage-1)+","+pcount+")>上一页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_dianhua("+(cpage+1)+","+pcount+")>下一页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_dianhua("+tpage+","+pcount+")>末页</a>";
				
				
				$("#tongxunlu").html(table);
				$("#tongxunlu").append(str);
				
				
				//学生意见
				var yjlist=data.yjlist;
				//alert(yjlist.length);
				var ul=$("<ul>");
				for(var j=0;j<yjlist.length;j++){
					var yj=yjlist[j];
					
					var li=$("<li>",{
						"html":yj.SBACKTITLE
					});
					
					ul.append(li);
					
				}
				
				$("#yijian").html(ul);
				
			},"json");
		});
		
		
		
		//值班分页
		function topage_zhiban(cpage,pcount){
		
			$.post("lcy/json!info",{cpage:cpage,pcount:pcount},function(data){
				
				$("#zhibanbiao").html("");
				
				var zblist=data.zblist;
				//alert(zblist.length);
				
				var table=$("<table>",{
				
					"class":"table table-striped table-bordered bootstrap-datatable datatable responsive"
				
				});
				
				var tr=$("<tr>");
			
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
				
				table.append(tr);
				
				for(var i=0;i<zblist.length;i++){
					var zb=zblist[i];
					var tr=$("<tr>");
					
					var td1=$("<td>",{
						"text":zb.zdate
					});
					var td2=$("<td>",{
						"text":zb.zteach1
					});
					var td3=$("<td>",{
						"text":zb.zfanwei1
					});
					var td4=$("<td>",{
						"text":zb.zteach2
					});
					var td5=$("<td>",{
						"text":zb.zfanwei2
					});
					var td6=$("<td>",{
						"text":zb.teachs
					});
					var td7=$("<td>",{
						"text":zb.zteachers
					});
					
					tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					tr.append(td4);
					tr.append(td5);
					tr.append(td6);
					tr.append(td7);
					
					table.append(tr);
					
					
				}
				
				var tpage=data.totalPage;
				var cpage=data.currPage;
				var pcount=data.pageCount;
				
				var str="";
				str+="页数<font color=red>"+cpage+"/"+tpage+"</font>";
				str+=" <a href='javascript:void(0)' onclick=topage_zhiban(1,"+pcount+")>首页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_zhiban("+(cpage-1)+","+pcount+")>上一页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_zhiban("+(cpage+1)+","+pcount+")>下一页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_zhiban("+tpage+","+pcount+")>末页</a>";
				
				$("#zhibanbiao").html(table);
				$("#zhibanbiao").append(str);
			},"json");
		}
		
		//电话分页
		function topage_dianhua(cpage,pcount){
		//alert("进来电话");
			$.post("lcy/json!info",{cpage:cpage,pcount:pcount},function(data){
				
				$("#tongxunlu").html("");
				var phonelist=data.phonelist;
				
				//alert("通讯录size:"+phonelist.length);
				
				var table=$("<table>",{
					"class":"table table-striped table-bordered bootstrap-datatable datatable responsive",
					"width":"100%",
					"align":"center"
				});
				var tr=$("<tr>");
				var td1=$("<th>",{
						"text":"姓名"
					});
				var td2=$("<th>",{
					"text":"联系电话"
				});
				
				tr.append(td1);
				tr.append(td2);
				
				table.append(tr);
				
				for(var x=0;x<phonelist.length;x++){
					var tr=$("<tr>");
					var phone=phonelist[x];
					
					//alert("员工姓名："+phone.TXL_ENAME);
					
					var td1=$("<td>",{
						"text":phone.TXL_ENAME
					});
					var td2=$("<td>",{
						"text":phone.TXL_EPHONE
					});
					
					tr.append(td1);
					tr.append(td2);
					
					table.append(tr);
				}
				
				var tpage=data.totalPage;
				var cpage=data.currPage;
				var pcount=data.pageCount;
				
				var str="";
				str+="页数<font color=red>"+cpage+"/"+tpage+"</font>";
				str+=" <a href='javascript:void(0)' onclick=topage_dianhua(1,"+pcount+")>首页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_dianhua("+(cpage-1)+","+pcount+")>上一页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_dianhua("+(cpage+1)+","+pcount+")>下一页</a>";
				str+=" <a href='javascript:void(0)' onclick=topage_dianhua("+tpage+","+pcount+")>末页</a>";
				
				
				$("#tongxunlu").html(table);
				$("#tongxunlu").append(str);
				
			},"json");
		}
	</script>
	
	
	
		<style>
		
		
			.biankuang{
				
				margin-bottom: 5px;
			}
		
			#kuaijie ul{
				list-style-type: none;
			}
			#kuaijie ul li{
				float: left;
				margin-right: 25px;
				margin-top: 40px;
			}
		</style>
	
	
	</head>

	<body>
		<jsp:include page="student/common.jsp"></jsp:include>
		

		<div class="row">
		
			<!-- 通知公告 -->
			<div class="box col-md-12" style="width:30%;">
				<div class="box-inner" style="height: 350px;">
					<div class="box-header well">
						<h2>
							<i class="glyphicon glyphicon-info-sign"></i>通知/公告
						</h2>

						
					</div>
					<!-- 通知内容 -->
					<div class="box-content" id="tongzhi">
						
					</div>
				</div>
			</div>
			<!-- 通知公告结束 -->
		
			<!-- 值班开始 -->
			<div class="box col-md-12" style="width:70%;">
				<div class="box-inner" style="height: 350px;">
					<div class="box-header well">
						<h2>
							<i class="glyphicon glyphicon-info-sign"></i>值班表
						</h2>

						
					</div>
					<!-- 内容开始 -->
					<div class="box-content" id="zhibanbiao">
						
						
						
					</div>
				</div>
			</div>
			<!-- 值班结束 -->
			
		</div>


<div style="height: 20px;"></div>
		
		<div class="row">
		
		
		
			<!-- 代办事项开始 -->
<!--			<div class="box col-md-12" style="width:30%">-->
<!--				<div class="box-inner" style="height: 320px;">-->
<!--					<div class="box-header well">-->
<!--						<h2>-->
<!--							<i class="glyphicon glyphicon-info-sign"></i>代办事项-->
<!--						</h2>-->
<!---->
<!--						-->
<!--					</div>-->
					<!-- 内容开始 -->
<!--					<div class="box-content" id="  ">-->
<!--						-->
<!--						-->
<!--						-->
<!--					</div>-->
<!--				</div>-->
<!--			</div>-->
			<!-- 代办事项结束-->
			
			
			<!-- 快捷入口开始 -->
			<div class="box col-md-12" style="width:30%">
				<div class="box-inner" style="height: 320px;">
					<div class="box-header well">
						<h2>
							<i class="glyphicon glyphicon-info-sign"></i>快捷入口
						</h2>

						
					</div>
					<!-- 内容开始 -->
					<div class="box-content" id="kuaijie" >
						
							<ul>
							    
							    <li><a href="javascript:void(0)"><span><img src="images/d02.png" width=32 height=32/></span><p><a href="score/scosx2">成绩</p></a></li>
							    <li><a href="javascript:void(0)"><span><img src="images/d03.png" width=32 height=32/></span><p>项目</p></a></li>
							    <li><a href="javascript:void(0)"><span><img src="images/d04.png" width=32 height=32/></span><p>谈心</p></a></li>
							    <li><a href="javascript:void(0)"><span><img src="images/d05.png" width=32 height=32/></span><p>请假</p></a></li>
							    <li><a href="javascript:void(0)"><span><img src="images/d01.png" width=32 height=32/></span><p>个人信息</p></a></li>
							    <li><a href="javascript:void(0)"><span><img src="images/d06.png" width=32 height=32/></span><p>意见</p></a></li>
							    <li><a href="javascript:void(0)"><span><img src="images/d07.png" width=32 height=32/></span><p>总结</p></a></li>    
							</ul>
						
					</div>
				</div>
			</div>
			<!--快捷入口结束 -->	
			
			
			<!-- 学生反馈开始 -->
			<div class="box col-md-12" style="width:35%">
				<div class="box-inner" style="height: 320px;">
					<div class="box-header well">
						<h2>
							<i class="glyphicon glyphicon-info-sign"></i>学生意见反馈
						</h2>

						
					</div>
					<!-- 内容开始 -->
					<div class="box-content" id="yijian">
						上课不够有趣
					</div>
				</div>
			</div>
			<!-- 学生反馈结束-->
			
			<!-- 联系教职工开始 -->
			<div class="box col-md-12" style="width:35%">
				<div class="box-inner" style="height: 320px;">
					<div class="box-header well">
						<h2>
							<i class="glyphicon glyphicon-info-sign"></i>联系教职工
						</h2>

						
					</div>
					<!-- 内容开始 -->
					<div class="box-content" id="tongxunlu">
						
					</div>
				</div>
			</div>
			<!-- 联系教职工结束 -->
		
		</div>
		
		
		<div class="row">
			
		
			
			
			
			
		</div>


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
