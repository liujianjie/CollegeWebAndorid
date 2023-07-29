<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>H+ 后台主题UI框架 - FooTable</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="${pageContext.request.contextPath }/backgroundSystem/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/backgroundSystem/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/backgroundSystem/css/plugins/footable/footable.core.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath }/backgroundSystem/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/backgroundSystem/css/style.min.css?v=3.2.0" rel="stylesheet">
<!-- jQuery Validation plugin javascriptform提示-->
	<script src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/validate/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/validate/messages_zh.min.js"></script>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">

            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>网站公告</h5>

                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="table_foo_table.jsp#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="table_foo_table.jsp#">选项 01</a>
                                    </li>
                                    <li><a href="table_foo_table.jsp#">选项 02</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                        	<div class="form-group">
								<div class="col-sm-4">
									 <input type="text" class="form-control input-sm m-b-xs" id="filter"
	                                   placeholder="搜索表格...">
								</div>
		                        <div class="col-sm-2">
									<a href="${pageContext.request.contextPath }/backgroundSystem/noticeadd.jsp"  class="btn btn-primary ">添加公告</a>
								</div>
	                        </div>
                            <table class="footable table table-stripped" data-page-size="8" data-filter=#filter>
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>发表人</th>
                                    <th>标题</th>
                                    <th>时间</th>
                                    <th>浏览次数</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
	                                <tbody>
	                                	<c:forEach items="${list }" var = "notice" varStatus="i">
		                                	<tr>
			                                    <td>${i.index+1 }
			                                    	 <span id="n_body${i.index+1 }" style="display: none">${notice.n_body }</span>
			                                    </td>
			                                    <td>${notice.n_author }
			                                    	<input type="hidden" id="n_author${i.index+1 }" value="${notice.n_author }">
			                                    </td>
			                                    <td>${notice.n_title }
			                                    	<input type="hidden" id="n_title${i.index+1 }" value="${notice.n_title }">
			                                    </td>
			                                    <td><fmt:formatDate value="${notice.n_date }" pattern="yyyy-MM-dd HH:mm:ss"/>
			                                    	<input type="hidden" id="n_date${i.index+1 }" value="<fmt:formatDate value="${notice.n_date }" pattern="yyyy-MM-dd HH:mm:ss"/>">
			                                    </td>
			                                    <td>${notice.n_count }
			                                    	<input type="hidden" id="n_count${i.index+1 }" value="${notice.n_count }">
			                                    </td>
			                                    <td><a href="${pageContext.request.contextPath}/notice/noticetoalert.action?id=${notice.n_id}"><i class="fa fa-check text-navy"></i> 编辑</a>
			                                    	<a href="${pageContext.request.contextPath}/notice/noticedelete.action?id=${notice.n_id}" onclick="return confirm('你确定删除吗？');"><i class="fa fa-check text-navy"></i> 删除</a>
			                                    	<a id="${i.index+1 }" onclick="fuzhi(this.id);" href="noticelist.jsp#gonggao" data-toggle="modal"><i class="fa fa-check text-navy"></i> 预览</a>
			                                    </td>
			                                </tr>
	                                	
	                                	</c:forEach>
		                               
	                                </tbody>
                                <tfoot>
	                                <tr>
	                                    <td colspan="6">
	                                        <ul class="pagination pull-right"></ul>
	                                    </td>
	                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     <!-- 弹出框 -->
     <div id="gonggao" class="modal fade" aria-hidden="false">
        <div class="modal-dialog">
            <div class="modal-content">
            	<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">小窗口</h4>
                </div>
                <div class="modal-body">
                	<!-- 自动增长 -->
                	<form class="form-horizontal m-t" id="signupForm">
                		<div class="form-group">
							<div class="col-sm-7 control-label">
								<a href="#"><span id="title"></span></a>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10 control-label">
								<span class="item">作者：<a rel="category tag">
										<span id="author"></span>
								</a></span>
								<span class="item">发布时间：<a rel="category tag">
										<span id="dates"></span>
								</a></span> <span
									class="item post-views">阅读(<span id="count"></span>)</span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10 control-label">
								<textarea rows="10" cols="95" id="texts">
								
								</textarea>
							</div>
						</div>
					</form>
				</div>
            </div>
        </div>
    </div>
      
    <script type="text/javascript">
    	function fuzhi(id){
    		var n_body = $("#n_body"+id).html();
    		var n_author = $("#n_author"+id).val();
    		var n_count = $("#n_count"+id).val();
    		var n_title = $("#n_title"+id).val();
    		var n_date = $("#n_date"+id).val();
    		$("#texts").html(n_body);
    		$("#author").html(n_author);
    		$("#count").html(n_count);
    		$("#title").html(n_title);
    		$("#dates").html(n_date);
    		
    	}
    
    </script>
        
    <!-- 全局js -->
    <script src="${pageContext.request.contextPath }/backgroundSystem/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/backgroundSystem/js/bootstrap.min.js?v=3.4.0"></script>
    <script src="${pageContext.request.contextPath }/backgroundSystem/js/plugins/footable/footable.all.min.js"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath }/backgroundSystem/js/content.min.js?v=1.0.0"></script>
    <script>
        $(document).ready(function() {

            $('.footable').footable();
            $('.footable2').footable();

        });

    </script>

    <script type="${pageContext.request.contextPath }/backgroundSystem/text/javascript" src="../../../tajs.qq.com/stats@sId=9051096.jsp" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>