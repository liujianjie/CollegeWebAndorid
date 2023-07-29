<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	
	<title>H+ 后台主题UI框架</title>
	<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
	<meta name="description"
		content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
	<jsp:include page="PublicJsp.jsp"></jsp:include>

	<!-- 定义的样式 -->
	<style type="text/css">
	body {
		margin: 0;
		padding: 0;
		font: 12px/1.5 Tahoma, Helvetica, Arial, sans-serif;
	}
	
	ul
	,
	li
	,
	{
	margin
	:
	0;padding
	:
	0;
	}
	ul {
		list-style: none;
	}
	
	#root {
		margin: 10px;
		width: 200px;
		overflow: hidden;
	}
	
	#root li {
		line-height: 25px;
	}
	
	#root .rem {
		padding-left: 16px;
	}
	
	#root .add {
		background: url(201010122130_add.gif) -4px -31px no-repeat;
	}
	
	#root .ren {
		background: url(201010122130_add.gif) -4px -7px no-repeat;
	}
	
	#root li a {
		color: #666666;
		padding-left: 5px;
		outline: none;
		blr: expression(this.onFocus = this.blur ());
	}
	
	#root li input {
		vertical-align: middle;
		margin-left: 5px;
	}
	
	#root .two {
		padding-left: 20px;
		display: none;
	}
	</style>


</head>

<body class="gray-bg">
	<ul id="root">
		<li><label><a href="javascript:;"
				_fcksavedurl="javascript:;">校讯通</a></label>
			<ul class="two">
				<li><label><a href="javascript:;"
						_fcksavedurl="javascript:;">沈阳市</a></label>
					<ul class="two">
						<li><label><input type="checkbox" value="123456"><a
								href="javascript:;" _fcksavedurl="javascript:;">二小</a></label>
							<ul class="two">
								<li><label><input type="checkbox" value="123456"><a
										href="javascript:;" _fcksavedurl="javascript:;">二年级</a></label></li>
								<li><label><input type="checkbox" value="123456"><a
										href="javascript:;" _fcksavedurl="javascript:;">三年级</a></label>
									<ul class="two">
										<li><label><input type="checkbox" value="123456"><a
												href="javascript:;" _fcksavedurl="javascript:;">一班</a></label>
											<ul class="two">
												<li><label><input type="checkbox"
														value="123456"><a href="javascript:;"
														_fcksavedurl="javascript:;">张三</a></label></li>
												<li><label><input type="checkbox"
														value="123456"><a href="javascript:;"
														_fcksavedurl="javascript:;">王五</a></label></li>
											</ul></li>
										<li><label><input type="checkbox" value="123456"><a
												href="javascript:;" _fcksavedurl="javascript:;">实验班</a></label></li>
									</ul></li>
							</ul></li>
					</ul></li>
				<li><label><a href="javascript:;"
						_fcksavedurl="javascript:;">抚顺市</a></label>
					<ul class="two">
						<li><label><input type="checkbox" value="123456"><a
								href="javascript:;" _fcksavedurl="javascript:;">二小</a></label></li>
						<li><label><input type="checkbox" value="123456"><a
								href="javascript:;" _fcksavedurl="javascript:;">一中</a></label></li>
					</ul></li>
			</ul></li>
	</ul>
	
	<script type="text/javascript">
		function addEvent(el,name,fn){//绑定事件
			if(el.addEventListener) return el.addEventListener(name,fn,false);
			return el.attachEvent('on'+name,fn);
		}
		function nextnode(node){//寻找下一个兄弟并剔除空的文本节点
			if(!node)return ;
			if(node.nodeType == 1)
				return node;
			if(node.nextSibling)
				return nextnode(node.nextSibling);
		} 
		function prevnode(node){//寻找上一个兄弟并剔除空的文本节点
			if(!node)return ;
			if(node.nodeType == 1)
				return node;
			if(node.previousSibling)
				return prevnode(node.previousSibling);
		} 
		function parcheck(self,checked){//递归寻找父亲元素，并找到input元素进行操作
			var par =  prevnode(self.parentNode.parentNode.parentNode.previousSibling),parspar;
			if(par&&par.getElementsByTagName('input')[0]){
				par.getElementsByTagName('input')[0].checked = checked;
				parcheck(par.getElementsByTagName('input')[0],sibcheck(par.getElementsByTagName('input')[0]));
			}			
		}
		function sibcheck(self){//判断兄弟节点是否已经全部选中
			var sbi = self.parentNode.parentNode.parentNode.childNodes,n=0;
			for(var i=0;i<sbi.length;i++){
				if(sbi[i].nodeType != 1)//由于孩子结点中包括空的文本节点，所以这里累计长度的时候也要算上去
					n++;
				else if(sbi[i].getElementsByTagName('input')[0].checked)
					n++;
			}
			return n==sbi.length?true:false;
		}
		addEvent(document.getElementById('root'),'click',function(e){//绑定input点击事件，使用root根元素代理
			e = e||window.event;
			var target = e.target||e.srcElement;
			var tp = nextnode(target.parentNode.nextSibling);
			switch(target.nodeName){
				case 'A'://点击A标签展开和收缩树形目录，并改变其样式会选中checkbox
					if(tp&&tp.nodeName == 'UL'){
						if(tp.style.display != 'block' ){
							tp.style.display = 'block';
							prevnode(target.parentNode.previousSibling).className = 'ren'
						}else{
							tp.style.display = 'none';
							prevnode(target.parentNode.previousSibling).className = 'add'
						}	
					}
					break;
				case 'SPAN'://点击图标只展开或者收缩
					var ap = nextnode(nextnode(target.nextSibling).nextSibling);
					if(ap.style.display != 'block' ){
						ap.style.display = 'block';
						target.className = 'ren'
					}else{
						ap.style.display = 'none';
						target.className = 'add'
					}
					break;
				case 'INPUT'://点击checkbox，父亲元素选中，则孩子节点中的checkbox也同时选中，孩子结点取消父元素随之取消
					if(target.checked){
						if(tp){
							var checkbox = tp.getElementsByTagName('input');
							for(var i=0;i<checkbox.length;i++)
								checkbox[i].checked = true;
						} 
					}else{
						if(tp){
							var checkbox = tp.getElementsByTagName('input');
							for(var i=0;i<checkbox.length;i++)
								checkbox[i].checked = false;
						}
					}
					parcheck(target,sibcheck(target));//当孩子结点取消选中的时候调用该方法递归其父节点的checkbox逐一取消选中
					break;
			}
		});
		window.onload = function(){//页面加载时给有孩子结点的元素动态添加图标
			var labels = document.getElementById('root').getElementsByTagName('label');
			for(var i=0;i<labels.length;i++){
				var span = document.createElement('span');
				span.style.cssText ='display:inline-block;height:18px;vertical-align:middle;width:16px;cursor:pointer;';
				span.innerHTML = ' '
				span.className = 'add';
				if(nextnode(labels[i].nextSibling)&&nextnode(labels[i].nextSibling).nodeName == 'UL')
					labels[i].parentNode.insertBefore(span,labels[i]);
				else
					labels[i].className = 'rem'
			}
		}
	</script>

</body>

</html>