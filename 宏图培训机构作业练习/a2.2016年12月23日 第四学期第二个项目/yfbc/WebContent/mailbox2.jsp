<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>H+ 后台主题UI框架 - 收件箱</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-content mailbox-content">
                        <div class="file-manager">
                            <a class="btn btn-block btn-primary compose-mail" href="mail_compose.jsp">写通知</a>
                            <div class="space-25"></div>
                            <h5>文件夹</h5>
                            <ul class="folder-list m-b-md" style="padding: 0">
                                <li>
                                    <a href="findpagemsglist.do"> <i class="fa fa-inbox "></i> 通知列表 
                                    </a>
                                </li>
                                <li>
                                    <a href="findpagemsgmylist.do?msgstatu=1&v=whm"> <i class="fa fa-envelope-o"></i> 发送的通知</a>
                                </li>
                                <li>
                                    <a href="findpagemsgmylist.do?msgstatu=0&v=whm"> <i class="fa fa-file-text-o"></i> 草稿 
                                    </a>
                                </li>
                                <li>
                                    <a href="findpagemsgmylist.do?msgstatu=2&v=whm"> <i class="fa fa-trash-o"></i> 垃圾箱</a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-9 animated fadeInRight">
                <div class="mail-box-header">

                 
                    <h2>
                    	草稿箱
                	</h2>
                    <div class="mail-tools tooltip-demo m-t-md">
                        <div class="btn-group pull-right">
                            

                        </div>
                        <button onclick="javasrcipt:location.href='findpagemsgmylist.do?msgstatu=0&v=whm'" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" title="刷新通知列表"><i class="fa fa-refresh"></i> 刷新</button>
                        

                    </div>
                </div>
                <div class="mail-box">

                    <table class="table table-hover table-mail">
                        <tbody>
                            <tr class="unread">
                                <td class="check-mail">
                                 
                                </td>
                                <td class="mail-ontact"><a href="mail_detail.jsp">发送人</a>
                                </td>
                                <td class="mail-subject"><a href="mail_detail.jsp">通知主题</a>
                                </td>
                                <td class="">
                                </td>
                                <td class="text-right mail-date">时间</td>
                            </tr>
                            
                            <c:forEach items="${msglist }" var="msg">
                            <tr class="read">
                                <td class="check-mail">
                                    <input type="checkbox" class="i-checks">
                                </td>
                                <td class="mail-ontact"><a href="mail_detail.jsp">${msg.msgpeople }</a>
                                </td>
                                <td class="mail-subject"><a href="todetil.do?id=${msg.id }&v=whm">${msg.msgtitle }</a>
                                </td>
                                <td class=""></td>
                                <td class="text-right mail-date">
                                	<fmt:formatDate value="${msg.msgtime }" pattern="yyyy-MM-dd hh:mm:ss"/>
                                </td>
                            </tr>
                           </c:forEach>
                        </tbody>
                    </table>
                </div>
                
                <div class="row">
				<div class="btn-group col-sm-7"><input type="hidden" value="${currPage }" id="currPage"></div>
				<div class="btn-group col-sm-5">
					共${totalRow }条记录 ${currPage }/${totalPage }页 <a><button
							type="button" id="btn1" onclick="userlist(this);"
							class="btn btn-white">
							<i class="fa fa-chevron-left"></i>
						</button></a>
					<c:if test="${currPage-3>0}">
						<a><button id="btn2" onclick="userlist(this);"
								class="btn btn-white">${currPage-3}</button></a>
					</c:if>
					<c:if test="${currPage-2>0}">
						<a><button id="btn3" onclick="userlist(this);"
								class="btn btn-white">${currPage-2}</button></a>
					</c:if>
					<c:if test="${currPage-1>0}">
						<a><button id="btn4" onclick="userlist(this);"
								class="btn btn-white">${currPage-1}</button></a>
					</c:if>
					<a><button id="btn5" onclick="userlist(this);"
							class="btn btn-white  active">${currPage}</button></a>
					<c:if test="${currPage+1<= totalPage}">
						<a><button id="btn6" onclick="userlist(this);"
								class="btn btn-white">${currPage+1}</button></a>
					</c:if>
					<c:if test="${currPage+2<= totalPage}">
						<a><button id="btn7" onclick="userlist(this);"
								class="btn btn-white">${currPage+2}</button></a>
					</c:if>
					<c:if test="${currPage+3<= totalPage}">
						<a><button id="btn8" onclick="userlist(this);"
								class="btn btn-white">${currPage+3}</button></a>
					</c:if>
					<a><button type="button" id="btn9" onclick="userlist(this);"
							class="btn btn-white">
							<i class="fa fa-chevron-right"></i>
						</button></a>
				</div>
			</div>

		</div>
            </div>
        </div>
    </div>


    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>



    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>


    <!-- iCheck -->
    <script src="${pageContext.request.contextPath}/js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>
    
    <script type="text/javascript">
		function userlist(btn) {

			var id = btn.id;


			var currPage = $("#currPage").val();
			
			if (id == "btn1" || id == "btn4") {
				location.href = "findpagemsgmylist.do?msgstatu=0&cpage=" + (currPage - 1)+ "&v=0";
			} else if (id == "btn2") {
				location.href = "findpagemsgmylist.do?msgstatu=0&cpage=" + (currPage - 3)+ "&v=0";
			} else if (id == "btn3") {
				location.href = "findpagemsgmylist.do?msgstatu=0&cpage=" + (currPage - 2)+ "&v=0";
			} else if (id == "btn5") {
				location.href = "findpagemsgmylist.do?msgstatu=0&cpage=" + (currPage)+ "&v=0";
			} else if (id == "btn7") {
				location.href = "findpagemsgmylist.do?msgstatu=0&cpage=" + (currPage + 2)+ "&v=0";
			} else if (id == "btn8") {
				location.href = "findpagemsgmylist.do?msgstatu=0&cpage=" + (currPage + 3)+ "&v=0";
						
			} else if (id == "btn9" || id == "btn6") {
				location.href = "findpagemsgmylist.do?msgstatu=0&cpage=" + (currPage + 1)+ "&v=0";
			}
		}
	</script>

</body>

</html>