<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书城首页</title>

<link type="text/css" href="css/main.css" rel="stylesheet"/>
 <link type="text/css" href="css/autoplay.css" rel="stylesheet"/>
    <style type="text/css" >
        *{
            margin: 0;
            padding: 0;
        }
        img{
            /* display: block; */ /*解决图片之间3px的bug问题*/
        }
        #container{
            width:890px;
            height:470px;
            margin:0 auto;
            margin-top: 0px;
            position: relative;
        }
        #container>#imgs{
            position: absolute;
            top: 0px;
        }
        #container>#imgs>li{
            list-style: none;
            float: left;
            display: none;
        }
        #container>#imgs>li.active{
            display: block;
        }
        #container>#circles{
            width: 152px;
            height: 18px;
            position: absolute;
            left: 46px;
            bottom: 20px;
            display: flex;
            justify-content: space-around;
            align-items: center;
        }
        #container>#circles>li{
            list-style: none;
            width: 14px;
            height: 14px;
            border-radius: 50%;
            background: #fff;
        }
        #container>#circles>li.active{
            background: red;
        }
        #container>div.arrow{
            width: 24px;
            height: 40px;
            position: absolute;
            margin-top: -20px;
            background: rgba(0,0,0,.2);
            font-size: 20px;
            color: #fff;
            line-height: 40px;
            text-align: center;
            user-select: none;
            cursor: pointer;
        }
        #container>div.arrow:hover{
            background: rgba(0,0,0,.5);
        }
        #container>div#left{
            top: 50%;
            left: 0;
        }
        #container>div#right{
            top: 50%;
            left: 877px;
        }
    </style>
<script type="text/javascript" src="js/autoplay.js"></script>

</head>
<body>
<!--1.LOGO --> 
<%@include  file="head.jsp"  %>
<!-- 2.网站菜单列表 -->
<%@include  file="nav.jsp"  %>
<div id="left" style="float:left;height: 351px;width: 300px;margin:0 auto;margin-top: 5px;border-left-width: 90px;background-color: #f1f3f0;">
    <table border="0" cellspacing="0" width="100%">
        <tbody style="text-align: center">
            <tr style="text-align: center">
                <td>
                    <img src="images/hottitle.gif" width="126" height="29"><!-- 热卖图标 -->
                </td>
            </tr>
            <tr>
                <td width="50px">
                    《Effective Java》
                </td>
                <td width="">
                    109.99 元
                </td>
                <td width="">
                    已有82人购买
                </td>
            </tr>
            <tr>
                <td  width="50px">
                    《代码整洁之道》
                </td>
                <td width="">
                    109.99 元
                </td>
                <td width="">
                    已有69人购买
                </td>
            </tr>
            <tr>
                <td  width="50px">
                    《JavaWeb技术》
                </td>
                <td width="">
                    89.99 元
                </td>
                <td width="">
                    已有58人购买
                </td>
            </tr>
            <tr>
                <td  width="50px">
                    《Head First Java》
                </td>
                <td width="">
                    79.99 元
                </td>
                <td width="">
                    已有54人购买
                </td>
            </tr>
            <tr>
                <td  width="50px">
                    《分布式 Java 应用》
                </td>
                <td width="">
                    79.99 元
                </td>
                <td width="">
                    已有46人购买
                </td>
            </tr>
            <tr>
                <td  width="50px">
                    《http权威指南》
                </td>
                <td width="">
                    69.99 元
                </td>
                <td width="">
                    已有34人购买
                </td>
            </tr>
            <tr>
                <td  width="50px">
                    《Java 虚拟机》
                </td>
                <td width="">
                    69.99 元
                </td>
                <td width="">
                    已有29人购买
                </td>
            </tr>
            <tr>
                <td  width="50px">
                    《java编程思想》
                </td>
                <td width="">
                    69.99 元
                </td>
                <td width="">
                    已有23人购买
                </td>
            </tr>
            <tr>
                <td  width="50px">
                    《数据库基础概论》
                </td>
                <td width="">
                    29.99 元
                </td>
                <td width="">
                    已有19人购买
                </td>
            </tr>
        </tbody>
    </table>
</div>
<!-- 网站首页轮播图 -->
<div id="container" style="float:left;right: 0px;left: 200px;">
    　　　　　　<!--定义图片列表-->
    　　　　　　<ul id="imgs">
    　　　　　　　　<li class="active"><img src="ad/index_ad1.jpg" width="900" height="335" alt=""></li>
    　　　　　　　　<li><img src="ad/index_a.jpg" width="900" height="335" alt=""/> </li>
                    <li><img src="ad/index_ad2.jpg" width="900" height="335" alt=""/> </li>
                    <li><img src="ad/index_ad3.jpg" width="900" height="335" alt=""/> </li>
                    <li><img src="ad/index_ad4.jpg" width="900" height="335" alt=""/> </li>
    　　　　　　</ul>
    　　　　　　<!--定义圆点列表-->
    　　　　　　<ul id="circles">
    　　　　　　　　<li class="active"></li>
    　　　　　　　　<li></li>
    　　　　　　　　<li></li>
    　　　　　　　　<li></li>
    　　　　　　　　<li></li>
    　　　　　　　　<li></li>
    　　　　　　　　<li></li>
    　　　　　　　　<li></li>
    　　　　　　</ul>
    　　　　　　<!--左右箭头-->
    　　　　　　<div id="left" class="arrow"><</div>
    　　　　　　<div id="right" class="arrow">></div>
</div>
<div id="right" style="float:right;height: 351px;width: 300px;margin:0 auto;margin-top: 5px;border-left-width: 90px;background-color: #f1f3f0;">
    <table border="0" cellspacing="0" width="100%">
        <tbody style="text-align: center">
        <table width="900px" border="0" cellspacing="0" style="margin: auto">
            <tr>
                <td width="497px">
                    <img src="images/billboard.gif" width="100" height="38"/>
                    <table cellspacing="0">
                        <tr>
                            <td width="485" height="29" style="padding-left:5px">
                                尊敬的书城用户:<br/>
                                大家好！本周五本书城部分图书折扣力度较大，<br />欢迎选购！祝大家购物愉快！3月25日<br />
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        </tbody>
    </table>
</div>
<%--<!-- 公告板和本周热卖 ，一个表格一行两个单元格，左边这个放公告板，右边的放本周热卖-->
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
</div>--%>
<br /><br /><br />
<!-- 底部版权栏 -->
	<%@include  file="foot.jsp"  %>
<script>

    //获取元素
    var container = document.getElementById('container');
    var lis = container.children[0].children;
    var circles = container.children[1].children;
    var left = document.getElementById('left');
    var right = document.getElementById('right');
    var len = lis.length;
    //index表示当前所显示图片的下标
    var index = 0;
    var run;
    //将图片轮播封装为一个函数
    function turn(){
        run = setInterval(function(){
            lis[index].removeAttribute('class');
            circles[index].removeAttribute('class');
            index++;
            if(index == len){
                index = 0;
            }
            lis[index].setAttribute('class','active');
            circles[index].setAttribute('class','active');
        },2000);
    }
    //启动时，调用函数
    turn();
    //设置鼠标移入移出容器事件
    container.onmouseenter = function(){
        //当鼠标移入容器中，停止轮播
        clearInterval(run);
    }
    container.onmouseleave = function(){
        //当鼠标移出容器时，继续开始轮播
        turn();
    }
    //设置鼠标移动到圆点上的悬浮事件
    for(var i = 0; i < len; i++){
        circles[i].onmouseover = (function(i){
            return function(){
                lis[index].removeAttribute('class');
                circles[index].removeAttribute('class');
                index = i;
                lis[i].setAttribute('class','active');
                circles[i].setAttribute('class','active');
            }

        })(i);
    }
    //设置左箭头单击事件
    left.onclick = function(){
        lis[index].removeAttribute('class');
        circles[index].removeAttribute('class');
        index--;
        if(index < 0){
            index = len - 1;
        }
        lis[index].setAttribute('class','active');
        circles[index].setAttribute('class','active');
    }
    //设置右箭头单击事件
    right.onclick = function(){
        lis[index].removeAttribute('class');
        circles[index].removeAttribute('class');
        index++;
        if(index == len){
            index = 0;
        }
        lis[index].setAttribute('class','active');
        circles[index].setAttribute('class','active');
    }
    //自动播放图片
    var i=0;
    var t=setInterval(autoplay,1000);
    function autoplay(){
        i++;
        if(i>5)i=0;
        $(".btn ul li").eq(i).addClass("one").siblings().removeClass("one");
        $(".pic a").eq(i).stop().fadeIn(500).show().siblings().stop().fadeIn(500).hide();
    }

    $("#banner").hover(function(){
        clearInterval(t);
    },function(){
        t=setInterval(autoplay,500);
    });
</script>
</body>
</html>