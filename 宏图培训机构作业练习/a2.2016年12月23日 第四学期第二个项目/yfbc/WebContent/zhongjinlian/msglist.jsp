<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>消息通知列表显示</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/footable/footable.core.css" rel="stylesheet">
 <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0" rel="stylesheet">
    
    
    <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
  
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>系统通知公告栏</h5>

                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="table_foo_table.jsp#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="zhongjinlian/msgadd.jsp">写通知</a>
                                    </li>
                                    <li><a href="findpagemsglist.do">通知列表</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">

                            <table class="footable table table-stripped toggle-arrow-tiny" data-page-size="8">
                                <thead>
                                <tr>
				
                                    <th data-toggle="true">ID</th>
                                    <th>消息主题</th>
                                    <th>消息内容</th>
                                    <th data-hide="all">发布状态</th>
                                    <th data-hide="all">发布人</th>
                                    <th data-hide="all">发布时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                          
                               <c:forEach items="${msglist }" var="msg" varStatus="status">
                                     <tr>
<%--                                     <td>${status.index+1 }</td> --%>
									<td>${msg.id }</td> 
                                    <td>${msg.msgtitle }</td>
                                    <td>${msg.msgcon }</td>
                                    <td><c:if test="${msg.msgstatu==1}">已发布</c:if>
                                    <c:if test="${msg.msgstatu==0}">未发布</c:if>
                                    </td>
                                            <td>${msg.msgpeople}</td>

<%--                                        <td>${msg.msgtime}</td> --%>
                                       <td><fmt:formatDate value="${msg.msgtime}"
									pattern="yyyy-MM-dd " /></td>
									
                                    <td>
                                    <c:if test="${msg.msgstatu==0}">
                                      <a href="toupdmsg.do?id=${msg.id }"  ><i class="fa fa-check text-navy"></i> 修改</a>
                                       
                                      <a href="tijiao.do?id=${msg.id}" onclick=" return confirm('发布后不能进行修改')"><i class="fa fa-check text-navy"></i> 发布</a>
								</c:if>
							  <a href="zhongjinlian/msgadd.jsp"  ><i class="fa fa-check text-navy"></i>添加</a>
								<a href="del.do?id=${msg.id}"  onclick="return confirm('确定要删除吗')"><i class="fa fa-check text-navy"></i> 删除</a>
								
                                    </td>
                                      </tr>
                          </c:forEach>
                              
         
		
			<tr >
			<td colspan="7"  align="right" >
	每页显示${pageCount}条数据&nbsp&nbsp&nbsp共
			<font color=#1b77c2>${totalRow}</font> 条&nbsp&nbsp&nbsp当前第
			<font color=#1b77c2>${currPage }/${totalPage }</font>页
			&nbsp&nbsp<a href="findpagemsglist.do?cpage=1">首页</a>
			&nbsp&nbsp<a href="findpagemsglist.do?cpage=${currPage-1 }">上一页</a>
			&nbsp&nbsp<a href="findpagemsglist.do?cpage=${currPage+1 }">下一页</a>
			&nbsp&nbsp<a href="findpagemsglist.do?cpage=${totalPage }">末页</a>
			</td>
			</tr>
                                </tbody>
                                </table>
                                </div>
                           
                                         
    <!-- 全局js -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js?v=3.4.0"></script>
    <script src="js/plugins/footable/footable.all.min.js"></script>

    <!-- 自定义js -->
    <script src="js/content.min.js?v=1.0.0"></script>
    <script>
        $(document).ready(function() {

            $('.footable').footable();
            $('.footable2').footable();

        });

    </script>

    <script type="text/javascript" src="../../../tajs.qq.com/stats@sId=9051096.jsp" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>