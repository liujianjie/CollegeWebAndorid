let headTag = $('.head-tag');
$(window).scroll(function(){
  var wScrollTop = $(window).scrollTop();
  if(wScrollTop > 176){
    headTag.slideDown();
  } else {
    headTag.hide();
  }
})