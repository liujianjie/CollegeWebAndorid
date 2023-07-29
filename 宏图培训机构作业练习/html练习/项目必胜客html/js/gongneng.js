    (   var btn=document.getElementById("btn");
		var box=document.getElementById("box");
		var xz1=document.getElementById("xz1");
		var xz2=document.getElementById("xz2");
		var box1=document.getElementById("box1");
			xz2.onclick=function(){
					if(xz2.checked==true){
					box.placeholder="请输入你的姓名"
					box1.removeChild(box1.firstChild);
					box1.removeChild(box1.firstChild);
					var ipt=document.createElement("input");
					ipt.placeholder="请输入你手机号";
					ipt.className="text";
					box1.appendChild(ipt);
					}
				}
			xz1.onclick=function(){
					  box.placeholder="请输入手机号码或邮箱";
					  var ipt=document.createElement("input");
					  var span=document.createElement("span");
					  box1.removeChild(box1.firstChild);
					  span.innerHTML="记住我";
					  ipt.type="checkbox";
					  ipt.checked="checked";
					  ipt.className="dian";
			          box1.appendChild(ipt);
					  box1.appendChild(span);
					}
			box.onblur=function(){
			var txt=document.getElementById("box").value;
		    var reg=new RegExp("([a-z]|[A-Z]|[0-9])([a-z]|[A-Z]|[0-9]|[\._]){0,}@([a-z]|[A-Z]|[0-9]){1,}\.(com|net|cn|(com\.cn))","g");
		   if(txt==""){
		   	alert("aa")
		   }
			
			}
			) 