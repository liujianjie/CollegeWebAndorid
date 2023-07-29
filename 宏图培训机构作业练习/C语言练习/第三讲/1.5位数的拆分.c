#include "stdio.h"
void main(){
	int a,b,c,d,e,f;
	printf("请输入这个数：");
	scanf("%d",&f);
	a=f/10000;
	b=f/1000%10;
	c=f/100%10;
	d=f/10%10;
	e=f/1%10;
	printf("%d         %d          %d          %d          %d",a,b,c,d,e);
	
	}