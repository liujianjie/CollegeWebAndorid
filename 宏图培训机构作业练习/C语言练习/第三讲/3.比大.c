#include "stdio.h"
void main(){
	int a,b,c,max;
	printf("������3�������ö��Ÿ�����:");
	scanf("%d,%d,%d",&a,&b,&c);
	max=a>b?a:b;
	max=max>c?max:c;
	printf("����������Ϊ��%d",max);
	
	}