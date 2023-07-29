// JavaScript Document
window.onload=function(){
	
var show=document.getElementById('show');
var div1=document.getElementById('div1');
var bt1=document.getElementById('bt1');
var bt2=document.getElementById('bt2');
var u1=document.querySelector('ul.list-ul');
//添加的显示与隐藏
show.onclick=function(){
	div1.classList.remove('list-hide');	
	}
bt2.onclick=function(){
	div1.classList.add('list-hide');
	}
//添加列表
bt1.onclick=function(){
	var li=document.createElement('li');
	li.setAttribute('class','list-option');
	var inp=document.createElement('input');
	inp.setAttribute('class','list-input');
	inp.setAttribute('type','text');
	inp.setAttribute('value',document.querySelector('input.list-add-input').value);
	document.querySelector('input.list-add-input').value='';
	li.appendChild(inp);
	var span=document.createElement('span');
	span.setAttribute('class','list-btn');
	var span1=document.createElement('span');
	span1.setAttribute('class','list-up');
	span1.innerHTML='[上移]';
	span.appendChild(span1);
	var span2=document.createElement('span');
	span2.setAttribute('class','list-down');
	span2.innerHTML='[下移]';
	span.appendChild(span2);
	var span3=document.createElement('span');
	span3.setAttribute('class','list-del');
	span3.innerHTML='[删除]';
	span.appendChild(span3);
	li.appendChild(span);
	u1.appendChild(li);	
		}
	//上移
	var up=document.querySelectorAll('span.list-up');
	for(var i=0;i<up.length;i++)
	up[i].onclick=function(){
		var li=this.parentNode.parentNode;		
		u1.insertBefore(li,li.previousSibling.previousSibling);		
		}
		
	var down=document.querySelectorAll('span.list-down');
	for(var i=0;i<down.length;i++)
	down[i].onclick=function(){
		var li=this.parentNode.parentNode;	
		u1.insertBefore(li,li.nextSibling.nextSibling.nextSibling);		
		}
	var del=document.querySelectorAll('span.list-del');
	for(var i=0;i<del.length;i++)
	del[i].onclick=function(){
		var li=this.parentNode.parentNode;	
		u1.removeChild(li);		
		}
/*	u1.addEventListener('click',function(e){
   e=e || window.event;
  // alert(e.target.innerHTML);
  if(e.target.innerHTML=='[上移]')
  var li=e.target.parentNode.parentNode;		
		u1.insertBefore(li,li.previousSibling.previousSibling);
  
  }, false);*/
	
	  

	
	
	}