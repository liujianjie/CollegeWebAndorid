$(function() {
	// 商品详细的缩略图片start---------------
	$(".goodsinfosmallimgdiv .goodsinfosi").click(function() {
		$(this).addClass("goodsinfosiborder").siblings().removeClass("goodsinfosiborder");
	})
	$(".goodsinfosmallimgdiv img").click(function() {
//		for(var i = 0; i < $(".goodsinfosmallimgdiv img").length; i++) {
//			$(this).removeClass("goodsinfosiimgsize");
//		}
//		$(this).addClass("goodsinfosiimgsize");
		// 给添加当点击图片，给大图显式
		$(".goodsinfoimgdiv img").attr("src", $(this)[0].src);
		// 放大镜的大图也要
		$(".goodsimgfdjbigdiv img").attr("src", $(this)[0].src);
	})
	
	// 商品详细的缩略图片end---------------
	// 点击数量按钮 开始-----------------------
	var num=1;
	$(".fourth").click(function(){
		num++;
		$(".third").html(num);
	})
	$(".second").click(function(){
		if (parseInt($(".third").html())>1) {
			num--;
			$(".third").html(num);
		}
	})
	//点击数量按钮 结束-------------------
	
	
	// 你可能喜欢的ul 切换start-------------
	var timer = null;//定时器
	var timer2 = null;
	var $allul = $(".maybeyloveul");
	for(var i = 0; i < $allul.length; i++) {
		$allul.eq(i).hide();
	}
	$allul.eq(0).show();
	var posuli = 0;// 当前选中的是哪个ul显式
	// 下一个ul显式
	// 思路，先让下一个ul的位置定位在1090px上，再让当前ul执行动画往左-1090位置，再让下一个ul执行动画往右1090位置即可
	function nextul(){
		$allul.eq(posuli).show();
		$allul.eq(posuli).css({
			"left": "1090px"
		});
		$allul.eq(posuli - 1).animate({
			left: "-1090px"
		}, 500);
		$allul.eq(posuli).animate({
			left: "0px"
		}, 500);
		$('.ulpos li:eq("'+posuli+'")').addClass('ulposactive').siblings().removeClass('ulposactive');
	}
	// 上一个 思路，和下一个差不多
	function preul(){
		$allul.eq(posuli).css({
			"-left": "1090px"
		});
		$allul.eq(posuli + 1).animate({
			left: "1090px"
		}, 500);
		$allul.eq(posuli).animate({
			left: "0px"
		}, 500);
		// 定位
		$('.ulpos li:eq("'+posuli+'")').addClass('ulposactive').siblings().removeClass('ulposactive');
	}
	// 直接根据下标定位的
	function posbaseindex(index){
		if(posuli < index){
			if(index - posuli == 2){
				
			}else{
				posuli++;
				nextul();
			}
		}else if(posuli > index){
			if(posuli - index == 2){
				
			}else{
				posuli--;
				preul();
			}
		}
	}
	
	$(".maybeylovehotnext").click(function() {
		if(posuli + 1 < $allul.length) {
			posuli++;
			nextul();
		}
	});
	$(".maybeylovehotprev").click(function() {
		if(posuli - 1 >= 0) {
			posuli--;
			preul();
		}
	});
	// 定时移动
	var ultag = 1;
	$('.maybeylove').mouseenter(function(){
		clearInterval(timer);
		clearInterval(timer2);
	}).mouseleave(function(){
		timer = setInterval(function(){  
			autochange();	
		},2000);		 
	});
	timer2 = setInterval(function(){  
		autochange();	
	},2000);
	// 自动执行方法 要判断位置
	function autochange(){
		// 每次得纠正把
		if(posuli >= $allul.length){
			posuli = 2;
		}
		if(posuli < 0){
			posuli = 0;
		}
		if(ultag == 1) {
			posuli++;
			if(posuli == $allul.length - 1){
				ultag = 2;
			}
			nextul();
		}else if(ultag == 2) {
			posuli--;
			if(posuli == 0){
				ultag = 1;
			}
			preul();
		}
	}
	// 点击圆圈
	$('.ulpos li').click(function(){
		var j = $(this).index()
		posbaseindex(j);
	});
	// 你可能喜欢的ul 切换end-------------

	
	// 对可能喜欢的图片 鼠标放上有一种放大的情况start----------------
	$(".maybeylovehotimg").mouseenter(function() {
		// 1.1放大
		var wValue = 1.1 * $(this).children("img").width();
		var hValue = 1.1 * $(this).children("img").height();
		$(this).children("img").css({
			"position": "absolute"
		});
		$(this).children("img").stop().animate({
			width: wValue,
			height: hValue,
			left: ("-" + (0.1 * $(this).children("img").width()) / 2),
			top: ("-" + (0.1 * $(this).children("img").height()) / 2)
		}, 800);
	}).mouseleave(function() {
		$(this).children("img").stop().animate({
			width: "210",
			height: "210",
			left: "0px",
			top: "0px"
		}, 800);
	});
	// 对可能喜欢的图片 鼠标放上有一种放大的情况end----------------
	
	// 放大镜 start-----------------
	var $mid_img_con = document.querySelector(".goodsinfoimgdiv");
	var $float_box = document.querySelector(".goodsimgfdjsmalldiv");
	var $big_img_con = document.querySelector(".goodsimgfdjbigdiv");
	$mid_img_con.onmouseenter = function(){
		$float_box.style.display = "block";
		$big_img_con.style.display = "block";
	}
	
	$mid_img_con.onmouseleave = function(){
		$float_box.style.display = "none";
		$big_img_con.style.display = "none";
	}
	$mid_img_con.onmousemove = function(e){
		// 需要减去父元素基于页面的自身的位置
		var $mid = $(".goodsinfoimgdiv");
		var fx = $mid.offset().left;//元素在当前视窗距离顶部的位置
		var fy = $mid.offset().top;
		var _x = e.pageX - fx - $float_box.offsetWidth / 2;
		var _y = e.pageY - fy - $float_box.offsetHeight / 2;
		if(_x <= 0){
			_x = 0;
		}
		if(_y <= 0){
			_y = 0;
		}
		var max_X = $mid_img_con.offsetWidth - $float_box.offsetWidth;
		var max_Y = $mid_img_con.offsetHeight - $float_box.offsetHeight;
		
		if(_x > max_X){
			_x = max_X;
		}
		if(_y > max_Y){
			_y = max_Y;
		}
		
		$float_box.style.left = _x + "px";
		$float_box.style.top = _y + "px";
		
		$big_img_con.children[0].style.left = -_x*2 + "px";
		$big_img_con.children[0].style.top = -_y*2 + "px";
	}
	
	// 放大镜 end------------------
	
	// 商品详细的不同选项卡 start-------------------
	$(".goodsdeatiltitle li").click(function(){
		$(this).addClass("active").siblings().removeClass("active");
		var index = $(this).index();
		// 当点击详情时 当点击常见问题时切换就完事
		if(index == 0 || index == 2){
			$(".goodsdeatilquestiondiv").toggle();
			$(".goodsdeatiltext").toggle();
		}
	});

	// 商品详细的不同选项卡 end-------------------
});

