	//��ͨ�ĵ���
//	alert("�ҽ�����");

	/*�����ݴ�ӡ��body��*/
	document.write("��ӭ��ʹ�� javascript");

	//�Ի���
	function test2(){
		if(confirm("�Ƿ�Ҫ�˳�")){
			window.close();//�ر���ҳ
		}else{
			alert("������ë");
		}
	}

	function test(){
		alert("�ű�������")
	}  

	//���� û����������֮��
	var a=10;
	var b="�Ǻ�";
	var c=false;
//	alert(c);
//	alert(a+""+b);//�ַ���ƴ��

	//�������� �� ����ֵ ����������������
	function ff(a,b){
		var sum=a+b;
		return sum
	}
	var sum=ff(1,4);//����
//	alert(sum);

	//��Ŀ����� �ж� 
	if(a>5){
		alert("�Ҵ���5");
	}
//	alert(a>5?"��tm������":"�Ҳ���");

	//������������ number,boolean,string,null
//	alert(typeof(a));
	
	//һά����
	arrs=new Array(111,222,333);
//	arrs[0]=3;
//	arrs[1]=2;
//	arrs[2]=1;
//	arrs.sort();	//����
//	alert(arrs[2]);

	//��ά����
	arrss=new Array(5,5);
	arrss[0,0]=00;
	arrss[0,1]=01;
	arrss[0,2]=02;
	arrss[0,3]=03;
	arrss[0,4]=04;
//	alert(arrss[0,4]);
	
	//eval����
	var s="alert('�Ǻ�');";
	alert(s);
	eval(s);

	//isNaN����
	var n=9;
	alert(isNaN(n));//�����־ͷ���false ���Ǿͷ���true
	
	//return
	function test3(){
		if(n>6){
			alert("����ɧ");
			return;
		}
		alert("��ͭ��");
	}
	test3();