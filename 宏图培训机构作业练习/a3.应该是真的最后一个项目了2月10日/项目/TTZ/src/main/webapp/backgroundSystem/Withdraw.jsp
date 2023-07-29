<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>用户提现记录</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=3.2.0" rel="stylesheet">

</head>

<body class="gray-bg" onload="selwithdraw();">
    <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>自定义响应式表格</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="table_basic.jsp#">
                                <i class="fa fa-wrench"></i>
                            </a>
                           
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                    <div class="row">                          
                        <div class="row">
                            <div class="col-sm-2 m-b-xs">
                                <select class="input-sm form-control input-s-sm inline" id="selecttime" onchange="selfortime();">
                                    <option value="6">请选择</option>
                                    <option value="3">昨天</option>
                                    <option value="4">上个星期</option>                                   
                                    <option value="5">上个月</option>
                                </select>
                            </div>
                            <div class="col-sm-4 m-b-xs">
                                <div data-toggle="buttons" class="btn-group">
                                    <label class="btn btn-sm btn-white" id="selectradio1" onclick="selfortime(0);">
                                        <input type="radio" id="option1" value="0" name="options">天</label>
                                    <label class="btn btn-sm btn-white active" id="selectradio2" onclick="selfortime(1);">
                                        <input type="radio" id="option2" value="1" name="options">周</label>
                                    <label class="btn btn-sm btn-white" id="selectradio3" onclick="selfortime(2);">
                                        <input type="radio" id="option3" value="2" name="options">月</label>
                                </div>
                            </div>
                            
                        </div>
                        <div class="table-responsive" id="seltable">
                            
                        </div>
						<div class="ibox-content" id="pagebtn" align="right"></div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    </div>
<script type="text/javascript">

	function selwithdraw(cPage,pcount){
	
		$.getJSON("<%=path%>/moneyrecord/WithdrawList.action",{cPage:cPage},function(data){
				var table = $("<table>",{
				"class":"table table-striped",
				"id":"sample_1"
			});
			var thead=$("<thead>");
			var ttr = $("<tr>");
			var thh=$("<th>",{"text":"序号"});
			var th2=$("<th>",{"text":"用户名"});
			var th3=$("<th>",{"text":"提现金额"});
			var th4=$("<th>",{"text":"类型"});
			var th5=$("<th>",{"text":"备注"});
			var th6=$("<th>",{"text":"时间"});
			 
			ttr.append(thh);
			ttr.append(th2);
			ttr.append(th3);
			ttr.append(th4);
			ttr.append(th5);
			ttr.append(th6);			
			thead.append(ttr);
			table.append(thead);
			var tbody=$("<tbody>",{"id":"tr22"});
			table.append(tbody);
			//提现记录
			var wdlist = data.wdlist;
			var tuserlist = data.tuserlist;
			$.each(wdlist,function(index,wd){
				var tr2=$("<tr>",{
					"id":"sellist"
				});
					var tdd=$("<td>",{"text":index+1});
					var td1=$("<td>");
					$.each(tuserlist,function(index,ttz){
						if(wd.p_userid==ttz.userid){
							td1.text(ttz.username);
						}else{
							td1.text(wd.p_username);
						}
					});
					var td2=$("<td>",{"text":wd.m_yxmoney});
					var td3=$("<td>",{"text":wd.m_jytype});					
					var td4=$("<td>",{"text":wd.m_remark});
					var td5=$("<td>",{"text":wd.m_happentime});
				
					tr2.append(tdd);
					tr2.append(td1);
					tr2.append(td2);
					tr2.append(td3);
					tr2.append(td4);
					tr2.append(td5);								
					tbody.append(tr2);	
					
			});
			//分页
				 var pcount = data.pageCount;
				 var cPage = data.currPage;
				 var trow = data.totalRow;
				 var tpage = data.totalPage;
				 if(data.cpage<1){
					data.cpage=1;
				}
				
				if(data.cPage>data.totalPage){
					data.cPage=data.totalPage;
				}	
			var btndiv =$("<div>",{
				"id":"btndiv",
				"class":"btn-group"
				
			});	
			var pbtn1 =$("<button>",{
				"type":"button",
				"class":"btn btn-white",
				"onclick":"selwithdraw('"+(cPage-1)+"','"+pcount+"')"
			});	
			var pi =$("<i>",{				
				"class":"fa fa-chevron-left"
			});
			pbtn1.append(pi);
			var pbtn2 =$("<button>",{
			"text":"1",
			"class":"btn btn-white",
			"onclick":"selwithdraw(1,'"+pcount+"')"
			});
			var pbtn3 =$("<button>",{
			"text":"2",
			"class":"btn btn-white",
			"onclick":"selwithdraw(2,'"+pcount+"')",
			});
			var pbtn4 =$("<button>",{
			"text":"3",
			"class":"btn btn-white",
			"onclick":"selwithdraw(3,'"+pcount+"')"
			});
			var pbtn5 =$("<button>",{
			"text":"4",
			"class":"btn btn-white",
			"onclick":"selwithdraw(4,'"+pcount+"')"
			});
			var pbtn6 =$("<button>",{
			"class":"btn btn-white",
			"onclick":"selwithdraw('"+(cPage+1)+"','"+pcount+"')",
			});
			var pi2 =$("<i>",{				
				"class":"fa fa-chevron-right"
			});
			pbtn6.append(pi2);
			btndiv.append(pbtn1);
			btndiv.append(pbtn2);
			btndiv.append(pbtn3);
			btndiv.append(pbtn4);
			btndiv.append(pbtn5);
			btndiv.append(pbtn6);
	
			$("#seltable").html(table);	
			$("#pagebtn").html(btndiv);		
			
			
		},"json");	
		
		
		
		
	}
function selfortime(selnum){
//按时间查询
				
		$("#seltable").html("");
		$("#btndiv").remove();
		$("#sample_1").remove();
		var slecttime = $("#selecttime").val();
		if(selnum==0){
		var seltime =$("#option1").val();
		}else if(selnum==1){
		var seltime =$("#option2").val();
		}else if(selnum==2){
		var seltime =$("#option3").val();
		}else if(slecttime==3){
			var seltime=slecttime;
		}else if(slecttime==4){
			var seltime=slecttime;
		}else if(slecttime==5){
			var seltime=slecttime;
		}else if(slecttime==6){
			alert("请选择时间！");
			return false;
		}
		
			$.getJSON("<%=path%>/moneyrecord/selforTime.action",{seltime:seltime},function(data){				
				var table = $("<table>",{
				"class":"table table-striped",
				"id":"sample_1"
			});
			var thead=$("<thead>");
			var ttr = $("<tr>");
			
			var th2=$("<th>",{"text":"用户名"});
			var th3=$("<th>",{"text":"提现金额"});
			var th4=$("<th>",{"text":"类型"});
			var th5=$("<th>",{"text":"备注"});
			var th6=$("<th>",{"text":"时间"});
			 
			
			ttr.append(th2);
			ttr.append(th3);
			ttr.append(th4);
			ttr.append(th5);
			ttr.append(th6);			
			thead.append(ttr);
			table.append(thead);
			var tbody=$("<tbody>",{"id":"tr22"});
			table.append(tbody);
			//提现记录
			
			if(selnum==0){
			var todaylist = data.todaylist;
		}else if(selnum==1){
			var todaylist = data.weeklist;
		}else if(selnum==2){
			var todaylist = data.monthlist;
		}else if(seltime==3){
			var todaylist = data.lastdaylist;
		}else if(seltime==4){
			var todaylist = data.lastweeklist;
		}else if(seltime==5){
			var todaylist = data.lastmonthlist;
		}
			var tuserlist = data.tuserlist;
			$.each(todaylist,function(index,wd){
				var tr2=$("<tr>",{
					"id":"sellist"
				});
					
					var td1=$("<td>");
					$.each(tuserlist,function(index,ttz){
						if(wd.p_userid==ttz.userid){
							td1.text(ttz.username);
						}else{
							td1.text(wd.p_username);
						}
					});
					var td2=$("<td>",{"text":wd.m_yxmoney});
					var td3=$("<td>",{"text":wd.m_jytype});					
					var td4=$("<td>",{"text":wd.m_remark});
					var td5=$("<td>",{"text":wd.m_happentime});
				
		
					tr2.append(td1);
					tr2.append(td2);
					tr2.append(td3);
					tr2.append(td4);
					tr2.append(td5);								
					tbody.append(tr2);	
					
			});
				$("#seltable").html(table);	
		},"json");

}
</script>

    <!-- 全局js -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js?v=3.4.0"></script>



    <!-- Peity -->
    <script src="js/plugins/peity/jquery.peity.min.js"></script>

    <!-- 自定义js -->
    <script src="js/content.min.js?v=1.0.0"></script>


    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>

    <!-- Peity -->
    <script src="js/demo/peity-demo.min.js"></script>

  

    <script type="text/javascript" src="../../../tajs.qq.com/stats@sId=9051096.jsp" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>