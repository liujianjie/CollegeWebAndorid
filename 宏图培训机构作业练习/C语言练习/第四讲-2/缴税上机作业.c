#include "stdio.h"
void main(){
	float a,b,c,d;
	printf("��������Ĺ���(��ȷ����λС��)��");
	scanf("%f",&a);
	
	printf("�������㵱�صĸ�˰��㣺");
	scanf("%f",&b);
	
	if(a>=b){
		printf("��Ĺ����ǣ�%.2f\n",a);
		c=a*0.043;
		printf("��ĸ�������˰�ǣ�%.2f\n",c);
		d=a-c;
		printf("���˰�������Ϊ��%.2f\n",d);
	}else{
		printf("˵���ǹ��ʻ��ǲ�Ҫ�Ǻ��أ�");
	
	}
	
	
	
	
	
	}