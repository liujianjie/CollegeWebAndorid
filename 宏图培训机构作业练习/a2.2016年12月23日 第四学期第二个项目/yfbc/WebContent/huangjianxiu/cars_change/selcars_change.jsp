
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>H+ 后台主题UI框架 - FooTable</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/footable/footable.core.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
	<button type="button" class="btn btn-primary dim" onclick="location.href='${pageContext.request.contextPath}/hjx/toaddcars_change.do'">车辆变更记录添加</button>
         
            <div class="row">
            <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>车辆分配</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <input type="text" class="form-control input-sm m-b-xs" id="filter"
                                   placeholder="搜索表格...">

                            <table class="footable table table-stripped" data-page-size="8" data-filter=#filter>
                                <thead>
                                        <tr>
                                            <th>车辆型号</th>
                                            <th>车辆配送员</th>
                                            <th>所属仓库</th>
                                            <th>变更时间</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                   						<c:forEach items="${cars_changeVolist}" var="cars_changeVo">
                                        <tr class="gradeA">
                                            <td>
                                              ${cars_changeVo.carsname }
		                                     </td>
                                            <td>
                                              ${cars_changeVo.drivername }
                                            </td>
                                            <td>
                                          	  ${cars_changeVo.whname }
                                            </td>
                                            <td>
                                            	<fmt:formatDate value="${cars_changeVo.cars_change.changedate }" pattern="YYYY-MM-dd"/>
                                            </td>
                                            <td>
                                            	<button class="btn btn-info " type="button"
                                 	 				 onclick="location.href='${pageContext.request.contextPath}/hjx/toupdcars_change.do?id=${cars_changeVo.cars_change.id }'">
                                 				 <i class="fa fa-paste"></i>修改</button>
                                            	<button class="btn btn-danger " type="button"
													onclick="location.href='${pageContext.request.contextPath}/hjx/delcars_change.do?id=${cars_changeVo.cars_change.id }'"> 
													<i class="fa fa-trash-o"></i> 删除
												</button>
                                            	
                                            </td>
                                        </tr>
                                        </c:forEach>  
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <td colspan="5">
                                                 <!-- 		start 页脚	 -->
												<div class="col-sm-1"></div>
												<div class="btn-group col-sm-8">
													共${totalRow }条记录 ${currPage }/${totalPage }页
													<div class="col-sm-2">
														<input type="text" id="pageCount" value="${pageCount }" class="form-control" />
													</div>
													<a><button type="button" id="btn1" onclick="cars_changelist(this);" class="btn btn-white">
														<i class="fa fa-chevron-left"></i>
													</button></a>
													<c:if test="${currPage-3>0}">
														<a><button id="btn2" onclick="cars_changelist(this);" class="btn btn-white">${currPage-3}</button></a>
													</c:if>
													<c:if test="${currPage-2>0}">
														<a><button id="btn3" onclick="cars_changelist(this);" class="btn btn-white">${currPage-2}</button></a>
													</c:if>
													<c:if test="${currPage-1>0}">
														<a><button id="btn4" onclick="cars_changelist(this);" class="btn btn-white">${currPage-1}</button></a>
													</c:if>
													<a><button id="btn5" onclick="cars_changelist(this);" class="btn btn-white  active">${currPage}</button></a>
													<c:if test="${currPage+1<=totalPage}">
														<a><button id="btn6" onclick="cars_changelist(this);" class="btn btn-white">${currPage+1}</button></a>
													</c:if>
													<c:if test="${currPage+2<=totalPage}">
														<a><button id="btn7" onclick="cars_changelist(this);" class="btn btn-white">${currPage+2}</button></a>
													</c:if>
													<c:if test="${currPage+3<=totalPage}">
														<a><button id="btn8" onclick="cars_changelist(this);" class="btn btn-white">${currPage+3}</button></a>
													</c:if>
													<a><button type="button" id="btn9" onclick="cars_changelist(this);" class="btn btn-white">
														<i class="fa fa-chevron-right"></i>
													</button></a>
												</div>
												<!-- 		end 页脚	 -->
                                            </td>
                                        </tr>
                                    </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-sm-1"></div>
            </div>
        </div>
        
         <script>
	
		function cars_changelist(btn) {
			var id=btn.id;
			var pageCount=document.getElementById("pageCount").value;
			var currPage=${currPage};
			if(id=="btn1"||id=="btn4"){
				location.href="selcars_change.do?pageCount="+pageCount+"&currPage="+(currPage-1)+"&v=0";
			}else if(id=="btn2"){
				location.href="selcars_change.do?pageCount="+pageCount+"&currPage="+(currPage-3)+"&v=0";
			}else if(id=="btn3"){
				location.href="selcars_change.do?pageCount="+pageCount+"&currPage="+(currPage-2)+"&v=0";
			}else if(id=="btn5"){
				location.href="selcars_change.do?pageCount="+pageCount+"&currPage="+(currPage)+"&v=0";
			}else if(id=="btn7"){
				location.href="selcars_change.do?pageCount="+pageCount+"&currPage="+(currPage+2)+"&v=0";
			}else if(id=="btn8"){
				location.href="selcars_change.do?pageCount="+pageCount+"&currPage="+(currPage+3)+"&v=0";
			}else if(id=="btn9"||id=="btn6"){
				location.href="selcars_change.do?pageCount="+pageCount+"&currPage="+(currPage+1)+"&v=0";
			}
		}
	</script>
        
    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/tajs.qq.com/stats@sId=9051096.html" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>