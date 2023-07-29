#include "stdio.h"
void main(){
	int n,a,b,c,d,e;
	printf("请输入一个5位数：");
	scanf("%d",&n);
	a=n/10000;
	b=n/1000%10;
	c=n/100%10;
	d=n/10%10;
	e=n/1%10;
	printf("如果这个数是回文数则结果为1\n如果这个数不是回文数结果为0\n结果为：%d",a==e&&b==d);
	
	}