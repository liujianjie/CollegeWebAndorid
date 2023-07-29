#include "stdio.h"
int he();
void main(){
	int c;
	c=he();
	printf("%d",c);
}
int he(){
	int a,b,sum;
	printf("请输入两个数（空格隔开）");	
	scanf("%d %d",&a,&b);
	sum=a+b;
	return sum;
}