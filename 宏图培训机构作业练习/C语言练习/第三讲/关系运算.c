#include "stdio.h"
void main(){
	int a,b,max;
	printf("������a��b���Ÿ�����");
	scanf("%d,%d",&a,&b);
	printf("����a>bΪ��%d\n",a>b);
	max=a>b?a:b;
	printf("�����������ǣ�%d\n",max);
	printf("�Ƿ���ȣ�%d",a==b);
	}