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
    

    <title>银行卡管理</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=3.2.0" rel="stylesheet">
	<link href="css/bankcard.css?" rel="stylesheet">
</head>

<body class="gray-bg" onload="selUser();">
    <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>用户银行卡管理</h5>
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
                         <div class="col-sm-3" >
                                <div class="input-group">                            	
                                    <input type="text" id="searchUser" placeholder="请输入用户名称" class="input-sm form-control" onkeyup="searchUser();"> 
                                    <div id="Layer1" style="position:absolute; left:0px; top:30px; width:280px; z-index:1; background-color: #FFFFFF; layer-background-color: #FFFFFF; border: gray 1px solid;display: none; "></div>
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> 搜索</button> </span>
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
    <div class="modal inmodal fade" id="myModal5" tabindex="-1" role="dialog"  aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <h4 class="modal-title">银行卡管理</h4>
                                           
                                        </div>
                                       <div class="Withdrawalss clearfix"  id="selectbankcard">
								<ul id="banklist" style="float:left; margin-left: 20px;list-style-type:none">           
           
          						</ul>  
									   </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
    </div>
<script type="text/javascript">
	function selUser(cPage,pcount){
	
		$.getJSON("<%=path%>/bankcardmanage/bkList.action",{cPage:cPage},function(data){
				var table = $("<table>",{
				"class":"table table-striped",
				"id":"sample_1"
			});
			var thead=$("<thead>");
			var ttr = $("<tr>");		
			var thh=$("<th>",{"text":"序号"});
			var th2=$("<th>",{"text":"用户名"});
			var th3=$("<th>",{"text":"余额"});
			var th4=$("<th>",{"text":"是否认证"});
			var th5=$("<th>",{"text":"电话"});
			ttr.append(thh);
			ttr.append(th2);
			ttr.append(th3);
			ttr.append(th4);
			ttr.append(th5);		
			thead.append(ttr);
			table.append(thead);
			var tbody=$("<tbody>",{"id":"tr22"});
			table.append(tbody);
			//提现记录
			var userlist = data.userlist;
			$.each(userlist,function(index,us){
				var tr2=$("<tr>");
					var tdd=$("<td>",{"text":"> "+(index+1)});
					if(us.zsname==null){
					var td1=$("<td>",{"text":us.username});
					}else{
					var td1=$("<td>");
					var modalwindow= $("<a>",{ 
						"style":"color:#ff3333",
						"data-toggle":"modal",
						"data-target":"#myModal5",
						"text":us.username,
						"onclick":"selbank('"+us.userid+"');"
					});
					td1.append(modalwindow);
					}
					var td2=$("<td>",{"text":us.money});
					if(us.zsname==null){
					var td3=$("<td>",{"text":"否"});	
					}else{
					var td3=$("<td>",{"text":"是"});	
					}
									
					var td4=$("<td>",{"text":us.tel});
					tr2.append(tdd);
					tr2.append(td1);
					tr2.append(td2);
					tr2.append(td3);
					tr2.append(td4);								
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
				
				"class":"btn-group"
			});	
			var pbtn1 =$("<button>",{
				"type":"button",
				"class":"btn btn-white",
				"onclick":"selUser('"+(cPage-1)+"','"+pcount+"')"
			});	
			var pi =$("<i>",{				
				"class":"fa fa-chevron-left"
			});
			pbtn1.append(pi);
			var pbtn2 =$("<button>",{
			"text":"1",
			"class":"btn btn-white",
			"onclick":"selUser(1,'"+pcount+"')"
			});
			var pbtn3 =$("<button>",{
			"text":"2",
			"class":"btn btn-white",
			"onclick":"selUser(2,'"+pcount+"')",
			});
			var pbtn4 =$("<button>",{
			"text":"3",
			"class":"btn btn-white",
			"onclick":"selUser(3,'"+pcount+"')"
			});
			var pbtn5 =$("<button>",{
			"text":"4",
			"class":"btn btn-white",
			"onclick":"selUser(4,'"+pcount+"')"
			});
			var pbtn6 =$("<button>",{
			"class":"btn btn-white",
			"onclick":"selUser('"+(cPage+1)+"','"+pcount+"')",
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
	//银行卡弹出层
	function selbank(userid){

	$("#banklist").html("");
  	$.getJSON("<%=path%>/bankcardmanage/selBankcard.action",{userid:userid},function(data){
		
   		var ttzList = data.Ttzlist;

   		$.each(ttzList,function(index,ttz){
   			var li = $("<li>",{
   				"style":"width:30%"
   			});
   			var div1 = $("<div>",{
   				"class":"Withdrawalss clearfix",
   				"onclick":"delbank('"+ttz.tbid+"');",
   				"data-dismiss":"modal"
   			});
   			var div2 = $("<div>",{
   				"class":"item"
   			});
   			var div3 = $("<div>",{
   				"class":"card-num",
   				"html":ttz.bankcard +"  <font color='red'>解除绑定</font>"
   			});
   			var div4 = $("<div>",{
   				"class":"img",
   			});
   			if(ttz.banktype=="工商银行"){
   				var img = $("<img>",{
   				"src":"image/bank1.png"
   				});
   			}else if(ttz.banktype=="农业银行"){
   				var img = $("<img>",{
   				"src":"image/bank2.png"
   				});
   			}else if(ttz.banktype=="招商银行"){
   				var img = $("<img>",{
   				"src":"image/bank3.png"
   				});
   			}else if(ttz.banktype=="建设银行"){
   				var img = $("<img>",{
   				"src":"image/bank4.png"
   				});
   			}else if(ttz.banktype=="中国银行"){
   				var img = $("<img>",{
   				"src":"image/bank5.png"
   				});
   			}else if(ttz.banktype=="中国邮政"){
   				var img = $("<img>",{
   				"src":"image/bank6.png"
   				});
   			}else if(ttz.banktype=="交通银行"){
   				var img = $("<img>",{
   				"src":"images/bank7.png"
   				});
   			}else if(ttz.banktype=="农村信用社"){
   				var img = $("<img>",{
   				"src":"image/bank8.png"
   				});
   			}else if(ttz.banktype=="民生银行"){
   				var img = $("<img>",{
   				"src":"image/bank9.png"
   				});
   			}
   			
   			
   			div4.append(img);
   			div2.append(div3);
   			div2.append(div4);
   			div1.append(div2);
   			li.append(div1);
   			
   			$("#banklist").append(li);
   		});
   },"json");		
  	}
  //解除绑定
  function delbank(tbid){
  	if(confirm("确定解除绑定？")){  	
  	$.getJSON("<%=path%>/bankcardmanage/delTtzbank.action",{tbid:tbid},function(data){
  	alert("解除绑定！");
  	
  	},"json");
  	location.reload();
  	}else {
  		
  	}
  
  
  }
  //搜索内容Layer1 #e3e3e3
  function searchUser(){
  	var username =$("#searchUser").val();
  	$.getJSON("<%=path%>/bankcardmanage/selUserForbank.action",{username:username},function(data){
  		var Ttzuserlist = data.Ttzuserlist;
  		var table =$("<table>",{
  		"style":"width:100%"
  		});
  		$.each(Ttzuserlist,function(index,Ttz){
  			var tr1 =$("<tr>",{
  			"onmouseover":"this.style.background='#e3e3e3'",
  			"onmouseout":"this.style.background='#ffffff'", 
  			}); 
  			
  			if(Ttz.zsname==null){
					var td1=$("<td>",{"text":Ttz.username});
					}else{
					var td1=$("<td>");
					var modalwindow= $("<a>",{ 
						"style":"color:#ff3333",
						"data-toggle":"modal",
						"data-target":"#myModal5",
						"text":Ttz.username,
						"onclick":"selbank('"+Ttz.userid+"');"
					});
						td1.append(modalwindow);
					}
  			tr1.append(td1);
  			table.append(tr1);
  		});
  			$("#Layer1").html(table);
  			$("#Layer1").show();
  	},"json");
  	
  
  	
  }

  //隐藏div
  function hidediv(){
  	$("#Layer1").hide();
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