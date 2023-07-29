<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>H+ 后台主题UI框架</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
	<jsp:include page="PublicJsp.jsp"></jsp:include>

</head>

<body class="gray-bg">
	
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<c:forEach items="${map.list}" var="user">
				<div class="col-sm-4">
					<div class="contact-box">
						<!-- 去权限页面 -->
						<a href="${pageContext.request.contextPath }/userper/seluserpermissionlist.action?userid=${user.b_id }">
							<div class="col-sm-4">
								<div class="text-center">
									<img alt="image" class="img-circle m-t-xs img-responsive"
										src="${pageContext.request.contextPath }/${user.b_touxiang}">
									<div class="m-t-xs font-bold">
										<c:if test="${user.b_positionid=='待分配'||user.b_positionid=='' }">暂无岗位</c:if>
										<c:forEach items="${map.post }" var="pos">
											<c:if test="${user.b_positionid==pos.p_id }">${pos.p_name }</c:if>
										</c:forEach>
										
									</div>
									
								</div>
							</div>
							<div class="col-sm-8">
								<h3>
									<strong>${user.b_username }</strong>
								</h3>
								<p>
									<i class="fa fa-map-marker"></i>${user.b_address }
								</p>
								<address>
									<strong>一个快乐的工作人员</strong><br>
									<abbr title="Phone">联系方式:</abbr> ${user.b_tel }
								</address>
							</div>
							<div class="clearfix"></div>
						</a>
					</div>
				</div>
			</c:forEach>
			<!-- 		start 页脚	 -->
			<div class="col-sm-1"></div>
			<div class="btn-group col-sm-8">
				共${map.totalCount }条记录 ${map.currPage }/${map.totalPage }页

				<div class="col-sm-2">
					<input type="hidden" id="pageCount" value="${map.pageCount }" class="form-control" />
				</div>
				<a><button type="button" id="btn1" onclick="userlist(this);" class="btn btn-white">
					<i class="fa fa-chevron-left"></i>
				</button></a>
				<c:if test="${map.currPage-3>0}">
					<a><button id="btn2" onclick="userlist(this);" class="btn btn-white">${map.currPage-3}</button></a>
				</c:if>
				<c:if test="${map.currPage-2>0}">
					<a><button id="btn3" onclick="userlist(this);" class="btn btn-white">${map.currPage-2}</button></a>
				</c:if>
				<c:if test="${map.currPage-1>0}">
					<a><button id="btn4" onclick="userlist(this);" class="btn btn-white">${map.currPage-1}</button></a>
				</c:if>
				<a><button id="btn5" onclick="userlist(this);" class="btn btn-white  active">${map.currPage}</button></a>
				<c:if test="${map.currPage+1<=map.totalPage}">
					<a><button id="btn6" onclick="userlist(this);" class="btn btn-white">${map.currPage+1}</button></a>
				</c:if>
				<c:if test="${map.currPage+2<=map.totalPage}">
					<a><button id="btn7" onclick="userlist(this);" class="btn btn-white">${map.currPage+2}</button></a>
				</c:if>
				<c:if test="${map.currPage+3<=map.totalPage}">
					<a><button id="btn8" onclick="userlist(this);" class="btn btn-white">${map.currPage+3}</button></a>
				</c:if>
				<a><button type="button" id="btn9" onclick="userlist(this);" class="btn btn-white">
					<i class="fa fa-chevron-right"></i>
				</button></a>
			</div>
			<!-- 		end 页脚	 -->
		</div>
	

	<script>
	
		function userlist(btn) {
			var id=btn.id;
			var currPage=parseInt('${map.currPage}');//需要强转 不然为String 1+1=11
			if(id=="btn1"||id=="btn4"){
				location.href="userlist.action?cpage="+(currPage-1)+"&v=0";
			}else if(id=="btn2"){
				location.href="userlist.action?cpage="+(currPage-3)+"&v=0";
			}else if(id=="btn3"){
				location.href="userlist.action?cpage="+(currPage-2)+"&v=0";
			}else if(id=="btn5"){
				location.href="userlist.action?cpage="+(currPage)+"&v=0";
			}else if(id=="btn7"){
				location.href="userlist.action?cpage="+(currPage+2)+"&v=0";
			}else if(id=="btn8"){
				location.href="userlist.action?cpage="+(currPage+3)+"&v=0";
			}else if(id=="btn9"||id=="btn6"){
				location.href="userper.action?cpage="+(currPage+1)+"&v=0";
			}
		}
	</script>

	<script>
        $(document).ready(function () {
            $('.contact-box').each(function () {
                animationHover(this, 'pulse');
            });
        });
    </script>
</body>

</html>