#include "stdio.h"
void main(){
	int a,b;
	char c;
	do{
		printf("��������λ�������Ÿ�����");
		scanf("%d,%d",&a,&b);
		printf("��λ���ĺ�Ϊ��%d\n",a+b);
		printf("��Ҫ�����𣿼����밴��������˳�����n������%c");
		fflush(stdin);
		scanf("%c",&c);
	}while(c!='n');
		printf("�˳��ɹ�");
	
	}
