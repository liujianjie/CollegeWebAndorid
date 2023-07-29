<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>H+ 后台主题UI框架 - 个人资料</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/style.min.css?v=3.2.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row animated fadeInRight">
			<button class="btn btn-outline btn-primary dim" onclick="location.href='javascript:history.go(-1);'"><i class="fa fa-reply"></i> 返回</button>
        <div class="col-sm-1"></div>
            <div class="col-sm-8">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>车辆详细资料</h5>
                    </div>
                    <div>
                        <div class="ibox-content no-padding border-left-right">
                            <img alt="image" class="img-responsive" src="${pageContext.request.contextPath}/img/cars5.jpg">
                        </div>
                        <div class="ibox-content profile-content">
                        	<input type="hidden" value="${cars.id }"/>
                            <h4><strong>${cars.carsname }</strong></h4>
                            <p><i class="fa fa-map-marker"></i> 隶属仓库:
								<c:forEach items="${warehouses }" var="warehouse">
			                        <c:if test="${cars.warehouseid==warehouse.whid}">${warehouse.whiname }</c:if>
			                    </c:forEach>
							</p>
                            <h3>
                              	 信息
                            </h3>
                            <p>
                              <h4><strong>车牌号：${cars.carsnum}</strong></h4>
                              <h4><strong>车辆载重：${cars.carsweight}（吨）</strong></h4>
                              <h4><strong>车辆容积：${cars.carscubage}（立方米）</strong></h4>
                              <h4><strong>发动机号：${cars.carsenginenum}</strong></h4>
                              <h4><strong>保险单号：${cars.carsinsurancenum}</strong></h4>
                              <h4><strong>购买时间：<fmt:formatDate value="${cars.carsbuydate}" pattern="YYYY-MM-dd"/></strong></h4>
                              <h4>
                              	<strong>车辆状态：
	                              	<c:if test="${cars.carsisvacancy==0}">空闲</c:if>
	                                <c:if test="${cars.carsisvacancy==1}">在途</c:if>
	                                <c:if test="${cars.carsisvacancy==2}">维修</c:if>
								</strong>
							  </h4>
                            
                                           
                            </p>
                            
                            <div class="user-button">
                                <div class="row">
                                 	 <button class="btn btn-info " type="button"
                                 	  onclick="location.href='${pageContext.request.contextPath}/hjx/toupdcars.do?id=${cars.id }'">
                                 	 <i class="fa fa-paste"></i> 编辑</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           
            <div class="col-sm-1"></div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath }/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js?v=3.4.0"></script>



    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath }/js/content.min.js?v=1.0.0"></script>


    <!-- Peity -->
    <script src="${pageContext.request.contextPath }/js/plugins/peity/jquery.peity.min.js"></script>

    <!-- Peity -->
    <script src="${pageContext.request.contextPath }/js/demo/peity-demo.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath }/tajs.qq.com/stats@sId=9051096.html" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>