#include "stdio.h"
void main(){
	int a,b,s;
	printf("������a,b(�ö��Ÿ���)");
	scanf("%d,%d",&a,&b);
	printf("����ǰ  %d,%d\n",a,b);
	s=a;
	a=b;
	b=s;
	
	printf("�����  %d,%d\n",a,b);
	//printf("�����  %d,%d",b,a);
	
	}