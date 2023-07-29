#include "stdio.h"
void main(){
	int x;
	printf("请输入一个数：");
	scanf("%d",&x);
	printf("奇数为1\n偶数为0\n输出数的结果为：%d",x%2);
	}