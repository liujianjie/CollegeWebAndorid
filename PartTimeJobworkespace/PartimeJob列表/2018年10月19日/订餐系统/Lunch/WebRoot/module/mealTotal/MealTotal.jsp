<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MealTotal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css">
    <script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
    <script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
	function goTo(i){
				$("#searchForm").attr("action","${path }/mealtotal_MealTotal.action?nowpage="+i);
				$("#searchForm").submit();
	}
	</script>
    </head>
  <body>
  <center>
      <form id="searchForm" action="${path}/mealtotal_MealTotal.action" method="post">
	        起始日期:<input name="dateA" value="${map.dateA }" type="text" onClick="WdatePicker({Date:'%y-%M-%d'})" class="form-control" style="width:125px;display:inline;" placeholder="请选择日期"/>       
	        截止日期:<input name="dateB" value="${map.dateB }" type="text" onClick="WdatePicker({Date:'%y-%M-%d'})" class="form-control" style="width:125px;display:inline;" placeholder="请选择日期"/>       
	    <input type="submit" class="btn btn-info" value="查询" id="seachBtn"/>
      </form>
    </center>
      <table class="table table-bordered table-hover table-striped">
      <caption><center><h3>菜品下单统计</h3></center></caption>
        <tr align="center">
           <td>序号</td>
           <td>菜品名</td>
           <td>下单数</td>
           <td>完成数</td>
           <td>退单数</td>
           <td>应收金额</td>
           <td>实收金额</td>
           <td>预计收入</td>
           <td>好评率</td>
        </tr>
        <c:if test="${!empty list }">
            <c:forEach items="${list }" var="son" varStatus="map">
               <tr align="center">
                  <td>${map.count }</td>
                  <td>${son.meal_name }</td>
                  <td>${son.xiadan }</td>
                  <td>${son.wancheng }</td>
                  <td>${son.tuidan }</td>
                  <td>${son.ymoney}</td>
                  <td>${son.smoney }</td>
                  <td>${son.yuji }</td>
                  <td>${son.pl }</td>
               </tr>
            </c:forEach>
        </c:if>
        	<tr align="center">
                  <td colspan="2">总计</td>
                  <td>${mapall.xiadan }</td>
                  <td>${mapall.wancheng }</td>
                  <td>${mapall.tuidan }</td>
                  <td>${mapall.ymoney}</td>
                  <td>${mapall.smoney }</td>
                  <td>${mapall.yuji }</td>
                  <td>无</td>
               </tr>
      </table>
      <div id="page" align="center">
		         <ul class="pagination pagination-lg">
	  			<li><a>当前第${page.nowpage }页</a></li>
				<li><a href="javascript:goTo(1)">首页</a></li>
				
		    	<c:if test="${page.nowpage!=1&&page.sumpage!=0 }">
		  			<li><a href="javascript:goTo(${page.nowpage-1 })">上一页</a></li>
		  		</c:if>
		  		
		    	<c:if test="${page.nowpage!=page.sumpage&&page.sumpage!=0 }">
		  			<li><a href="javascript:goTo(${page.nowpage+1 })">下一页</a></li>
		  		</c:if>
		    	<c:if test="${page.sumpage!=0 }">
		  			<li><a href="javascript:goTo(${page.sumpage })">尾页</a></li>
		  			<li><a>总共${page.sumpage }页</a></li>
		  		</c:if>
		  		<c:if test="${page.sumpage==0 }">
		  			<li><a href="javascript:goTo(1)">尾页</a></li>
		  			<li><a>总共1页</a></li>
		  		</c:if>
		  		<li><a>共${page.sumcount }条记录</a></li>
			</ul><br>
      </div>
      <a href="${path}/module/mealTotal/MealTuBiao.jsp">图表</a>
  </body>
</html>
              