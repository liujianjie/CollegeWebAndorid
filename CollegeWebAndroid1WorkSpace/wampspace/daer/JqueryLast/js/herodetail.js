$(function() {
	// 点击皮肤图像，显示相应皮肤
	$('.heroskinheadul li').on('click',function(){
		// 皮肤层的ul
		var $ul = $('.heroskinul');
		var w = 1240;
		// 1.获取到这个li的下标
		var idx = $(this).index();
		var left = -idx * w
		if(idx == 0){
			left = 0;
		}
		// 2.让ul往左移动多少left
		$ul.stop().animate({'left':left}, 500);
		
		// 3.让兄弟取消选中的样式，自己选中的样式
		$(this).addClass("current").siblings().removeClass("current");
	});
	
});