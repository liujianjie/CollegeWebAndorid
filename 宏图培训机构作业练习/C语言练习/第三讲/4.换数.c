#include "stdio.h"
void main(){
	int a,b,s;
	printf("请输入a,b(用逗号隔开)");
	scanf("%d,%d",&a,&b);
	printf("输入前  %d,%d\n",a,b);
	s=a;
	a=b;
	b=s;
	
	printf("输入后  %d,%d\n",a,b);
	//printf("输入后  %d,%d",b,a);
	
	}