(function ($) {
	$.fn.extend({
		'baifunc' : function(){
			$(this).children('li').click(function(){
				// 本身li的宽度增加，兄弟的宽度减少
				$(this).animate({'width' : 640}, 1000);
				$(this).siblings().animate({'width':40},1000);
			});
		}
	});
})(jQuery);