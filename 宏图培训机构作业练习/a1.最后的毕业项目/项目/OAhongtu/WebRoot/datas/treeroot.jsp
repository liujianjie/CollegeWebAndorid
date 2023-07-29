<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'treeroot.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="StyleSheet" href="css/dtree.css" type="text/css" />
	<script type="text/javascript" src="js/dtree.js"></script>

  </head>
  
  <body>
	
														
							<div class="dtree">
							
								<p><a href="javascript: d.openAll();">全部展开</a> |
								<a href="javascript: d.closeAll();">全部收起</a></p>
							
								<script type="text/javascript">
									d = new dTree('d');
										
									d.add(0,-1,'员工权限');
									d.add(1 ,0,'authority','1','首页 ');
									d.add(2,0,'authority','2','日常办公 ');
									d.add(3,2,'authority','3','部门管理 ');
									d.add(4,2,'authority','4','员工管理 ');
									d.add(5,2,'authority','5','员工日志 ');
									d.add(6,2,'authority','81','我的日志 ');
									d.add(7,2,'authority','38','考勤管理 ');
									d.add(8,2,'authority','6','值班管理 ');
									d.add(9,2,'authority','7','我的值班 ');
									d.add(10,2,'authority','43','请假/加班管理 ');
									d.add(11,2,'authority','46','巡查管理 ');
									d.add(22,2,'authority','8','值班安排 ');
									
										
									d.add(72,7,'authority','63','查看考勤 ');
									d.add(73,7,'authority','62','我的考勤');
									d.add(74,7,'authority','39','考勤异议申报 ');
							
									d.add(102,10,'authority','44','请休/假申请 ');
									d.add(103,10,'authority','80','我的请休/假申请');
									d.add(104,10,'authority','61','我的加班申请 ');
									d.add(105,10,'authority','45','加班申请 ');
							
									d.add(112,11,'authority','47','班级巡查 ');
									d.add(113,11,'authority','48','我的班级巡查');
									d.add(114,11,'authority','49','宿舍巡查 ');
									d.add(115,11,'authority','50','我的宿舍巡查 ');
										
									
									d.add(12,0,'authority','10','教务管理 ');
									d.add(122,12,'authority','11','课程管理 ');
									d.add(123,12,'authority','12','教员反馈 ');
									d.add(124,12,'authority','13','领导查看反馈 ');
									d.add(125,12,'authority','14','教员查看反馈 ');
									d.add(126,12,'authority','15','研讨会管理 ');
									d.add(127,12,'authority','16','领导查看研讨会 ');
									d.add(128,12,'authority','17','课程进度管理 ');
									d.add(129,12,'authority','18','领导查看课程进度 ');
							
									d.add(13,0,'authority','19','学生管理 ');
									d.add(132,13,'authority','20','班级管理 ');
									d.add(133,13,'authority','21','宿舍管理 ');
									d.add(134,13,'authority','22','学生信息管理 ');
									d.add(135,13,'authority','23','成绩管理 ');
									d.add(136,13,'authority','24','项目答辩管理 ');
									d.add(137,13,'authority','25','谈心记录管理 ');
									d.add(138,13,'authority','26','学生总结管理 ');
									d.add(139,13,'authority','27','就业管理 ');
									d.add(1310,13,'authority','28','请假管理 ');
									d.add(1311,13,'authority','51','电脑领用管理 ');
									d.add(1312,13,'authority','29','意见反馈 ');
							
									d.add(13112,1311,'authority','52','备用电脑领用 ');
							
									d.add(14,0,'authority','30','财务管理 ');
									d.add(142,14,'authority','31','收入管理 ');
									d.add(143,14,'authority','32','支出管理 ');
									d.add(144,14,'authority','33','学生收费 ');
									d.add(145,14,'authority','34','工资管理 ');
									
									d.add(15,0,'authority','35','招生管理 ');
									d.add(152,15,'authority','36','招生名单 ');
									d.add(153,15,'authority','37','预定报名学生 ');
							
									d.add(16,0,'authority','53','通知公告 ');
									d.add(162,16,'authority','54','发布员工公告 ');
									d.add(163,16,'authority','55','查看员工公告 ');
									d.add(164,16,'authority','56','发布学生公告 ');
									d.add(165,16,'authority','57','查看学生公告 ');
									
									d.add(17,0,'authority','58','权限管理 ');
									d.add(172,17,'authority','59','员工权限 ');
									d.add(173,17,'authority','60','学生权限 ');
							
									document.write(d);
									
									
									d.openAll();
									
								</script>
							
							</div>
							<div>
							<input type='button' name='bTest' value='test' onclick='test();'>
							</div>
							
		
		
	<script type="text/javascript">
		<!--
		function test(){
			var count = 0;
			var obj = document.all.authority;	
			
			for(i=0;i<obj.length;i++){
				if(obj[i].checked){					
					alert(obj[i].value);
					count ++;				
				}
			}	
		}
		//-->
	</script>

  </body>
</html>
