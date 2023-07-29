#include "stdio.h"
void main(){
	char b;
	printf("输入一个字母：");
	scanf("%c",&b);
	printf("这个符号的小写字母为：%c,它的ascll值为：%d，它的大写字母为%c",b,b,b-32);
	
	}