//下滑显示
let headTag = $('.head-tag');
$(window).scroll(function(){
  var wScrollTop = $(window).scrollTop();
  if(wScrollTop > 176){
    headTag.slideDown();
  } else {
    headTag.hide();
  }
});

//轮播图
var $topImg = $('.top_b_img');
var $topLi = $('.top_b_ul');
var i = 0;
for(let y = 0; y < $topLi.children.length; y++){
	$topLi.children().eq(y).click(function(){
		console.log(y)
		clearInterval(timer);
		if(y == 0){
			timer0();
		}else {
			timer1();
		}
	});
}
$topImg.mouseenter(function(){
	clearInterval(timer);
});
$topImg.mouseout(function(){
	timer = setInterval(setTimer,2000);
});
var timer = setInterval(setTimer,2000);
function setTimer(){
	if(i == 0){
		timer0();
		i++;
	}else if(i == 1){
		timer1();
		i = 0;
	}
}
function timer0(){
	$topImg.children().eq(0).css('display','block');
	$topImg.children().eq(1).css('display','none');
	$topLi.children().eq(0).addClass('show');
	$topLi.children().eq(1).removeClass('show');
}
function timer1(){
	$topImg.children().eq(0).css('display','none');
	$topImg.children().eq(1).css('display','block');
	$topLi.children().eq(0).removeClass('show');
	$topLi.children().eq(1).addClass('show');
}

//样式显隐
var $cupImg = $('.content_c_img img');
var $ss = $('.ss');
for(let a = 0; a <$cupImg.length;a++){
	$cupImg.eq(a).mouseenter(function(){
		$ss.eq(a).css('display','block');
	});
	$ss.eq(a).mouseenter(function(){
		$ss.eq(a).css('display','block');
	});
	$cupImg.eq(a).mouseleave(function(){
		$ss.eq(a).css('display','none');
	});
}

var $eventB = $('.content_c_img div .event_b');
var $eventN = $('.content_c_img div .event_n');
for(let b = 0;b < $eventB.length;b++){
	$eventB.eq(b).mouseenter(function(){
		$eventB.eq(b).css('display','none');
		$eventN.eq(b).css('display','block');
	});
	$eventN.eq(b).mouseenter(function(){
		$eventB.eq(b).css('display','none');
		$eventN.eq(b).css('display','block');
	});
	$eventB.eq(b).mouseleave(function(){
		$eventB.eq(b).css('display','block');
		$eventN.eq(b).css('display','none');
		console.log(b)
	});
	$eventN.eq(b).mouseleave(function(){
		$eventB.eq(b).css('display','block');
		$eventN.eq(b).css('display','none');
		console.log(b)
	});
}
