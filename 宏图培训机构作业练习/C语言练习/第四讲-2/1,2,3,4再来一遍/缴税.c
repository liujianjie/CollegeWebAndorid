#include "stdio.h"
void main(){
	float a,b,c,d;
	printf("��������Ĺ��ʣ�");
	scanf("%f",&a);
	printf("�������㵱�صĸ������˰��");
	scanf("%f",&b);
	if(a>=b){
		c=a*0.043;
		d=a-c;
		printf("��Ĺ���Ϊ��%.2f\n",a);
		printf("�������˰��%.2f\n",c);
		printf("��˰�����������Ϊ��%.2f\n",d);

		
	}else {

		printf("ɧ�꣬Ŭ����Ҫ�ɷѰ�");
	
	}	

	
	}