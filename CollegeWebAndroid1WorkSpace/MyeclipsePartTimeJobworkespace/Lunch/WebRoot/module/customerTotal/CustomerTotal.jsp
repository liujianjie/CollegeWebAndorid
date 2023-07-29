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
    
    <title>My JSP 'CustomerTotal.jsp' starting page</title>
    
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
				$("#searchForm").attr("action","${path }/total_CustomerTotal.action?nowpage="+i);
				$("#searchForm").submit();
	}
	</script>
    </head>
  <body>
        <center><form id="searchForm" action="${path}/total_CustomerTotal.action" method="post">
	        起始日期:<input name="dateA" value="${map.dateA }" type="text" onClick="WdatePicker({Date:'%y-%M-%d'})" class="form-control" style="width:125px;display:inline;" placeholder="请选择日期"/>       
	        截止日期:<input name="dateB" value="${map.dateB }" type="text" onClick="WdatePicker({Date:'%y-%M-%d'})" class="form-control" style="width:125px;display:inline;" placeholder="请选择日期"/>       
	    <input type="submit" class="btn btn-info" value="查询" id="seachBtn"/>
        </form></center>
      <table class="table table-bordered table-hover table-striped">
      <caption><center><h3>顾客统计</h3></center></caption>
        <tr align="center">
           <td>序号</td>
           <td>姓名</td>
           <td>下单数</td>
           <td>菜品数</td>
           <td>付款数</td>
           <td>退单数</td>
           <td>退菜数</td>
           <td>未付款数</td>
        </tr>
        <c:if test="${!empty list }">
            <c:forEach items="${list }" var="son" varStatus="map">
               <tr align="center">
                  <td>${map.count }</td>
                  <td>${son.aname }</td>
                  <td>${son.acoun }</td>
                  <td>${son.asum}</td>
                  <td>${son.amoney }</td>
                  <td>${son.bcoun }</td>
                  <td>${son.bsum }</td>
                  <td>${son.bmoney }</td>
               </tr>
            </c:forEach>
        </c:if>
        <c:if test="${!empty usermap }">
             <tr align="center">
                  <td colspan="2">总计</td>
                  <td>${usermap.acoun }</td>
                  <td>${usermap.asum}</td>
                  <td>${usermap.amoney }</td>
                  <td>${usermap.bcoun }</td>
                  <td>${usermap.bsum }</td>
                  <td>${usermap.bmoney }</td>
               </tr>
        </c:if>   
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
  </body>
</html>
              