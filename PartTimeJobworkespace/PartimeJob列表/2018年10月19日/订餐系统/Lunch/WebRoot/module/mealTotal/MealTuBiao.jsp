<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MealTuBiao.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/echarts.common.min.js"></script>
  	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
  </head>
  
  <body>
    <div id="myDiv" style="height: 400px"></div>
    <script type="text/javascript">  
        function loadData(option) {  
            $.ajax({  
                type : 'post',  //传输类型 
                async : false,  //同步执行
                url : '${path}/mealtotal_MealTu.action', //web.xml中注册的Servlet的url-pattern  
                data :null,  
                dataType : 'json', //返回数据形式为json  
                success : function(result) {  
                    if (result) {  
                        //初始化xAxis[0]的data  
                        option.xAxis[0].data = [];
                        for (var i=0; i<result.length; i++) {  
                            option.xAxis[0].data.push(result[i].meal_name);
                        }
                        //初始化series[0]的data  
                        option.series[0].data = [];
                        for (var i=0; i<result.length; i++) {  
                            option.series[0].data.push(result[i].xiadan);
                        }  
                    }  
                },  
                error : function(errorMsg) {  
                    alert("加载数据失败");  
                }  
            });//AJAX  
        }//loadData()  
        var myChart = echarts.init(document.getElementById('myDiv'));  
        var option = {  
            tooltip : {  
                show : true
            },
            legend : {  
                data : [ '下单数' ]  
            },  
            xAxis : [ {  
            	name : '菜名',
                type : 'category',
                axisLabel :{  
				    interval:0   
				}
            } ],  
            yAxis : [ {  
            	name : '个数',
                type : 'value'  
            } ],  
            series : [ {  
                name : '下单数',  
                type : 'bar'  
            }, ]  
        };  
        //加载数据到option  
        loadData(option);  
        //设置option  
        myChart.setOption(option);
      </script>
  </body>
</html>
