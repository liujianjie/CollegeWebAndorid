#include "stdio.h"
void he();
void main(){
	he();
}
void he(){
	int a,b,c;	
	printf("请输入两个数（空格隔开）");
	scanf("%d %d",&a,&b);
	c=a+b;
	printf("这两个数的和为：%d",c);
	
}