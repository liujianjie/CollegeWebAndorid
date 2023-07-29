<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书城首页</title>

<link type="text/css" href="css/main.css" rel="stylesheet"/>
 <link type="text/css" href="css/autoplay.css" rel="stylesheet"/> 
<script type="text/javascript" src="js/autoplay.js"></script>

</head>
<body>
<!--1.LOGO --> 
<%@include  file="head.jsp"  %>
<!-- 2.网站菜单列表 -->
<%@include  file="nav.jsp"  %>
<!-- 网站首页轮播图 -->
<div id="box_autoplay">
<div class="list">
  <ul>
    <li><img src="ad/index_ad3.jpg" width="900" height="335" /> </li>
    <li><img src="ad/index_ad2.jpg" width="900" height="335" /> </li>
    <li><img src="ad/index_a.jpg" width="900" height="335" /> </li>
    <li><img src="ad/index_ad4.jpg" width="900" height="335" /> </li>
    <li><img src="ad/index_ad1.jpg" width="900" height="335" /> </li>
  </ul>
</div>
</div>
<!-- 公告板和本周热卖 ，一个表格一行两个单元格，左边这个放公告板，右边的放本周热卖-->
<div style="margin:10px 0px 10px 50px"> 
   <table width="900px" border="0" cellspacing="0" style="margin: auto">
   <tr>
     <td width="497px">
       <img src="images/billboard.gif" width="497" height="38"/>
       <table cellspacing="0">
         <tr>
         <td width="485" height="29" style="padding-left:50px">
                  尊敬的书城用户:<br/>
         大家好！本周五本书城部分图书折扣力度较大，欢迎选购！祝大家购物愉快！<br />3月25日<br />           
         </td>
         </tr>
       </table>
     </td>
     <td style="padding:5px 15px 10px 40px">
         <table border="0" cellspacing="0" width="100%">
            <tr>
              <td>
                <img src="images/hottitle.gif" width="126" height="29"/><!-- 热卖图标 -->
              </td>
            </tr>
         </table>
         <table border="0" cellspacing="0" width="100%">
          <tr>
           <td style="with:80;text-align:center">
              <img src="bookcover/107.jpg" width="102" height="130" border="0" />
           </td>
           <td style="with:80;text-align:center">
                <img src="bookcover/106.jpg" width="102" height="130" border="0" />
           </td>
           
          </tr>
         </table>
     </td>
   </tr>     
   </table>
</div>
<br /><br /><br />
<!-- 底部版权栏 -->
	<%@include  file="foot.jsp"  %>
</body>
</html>