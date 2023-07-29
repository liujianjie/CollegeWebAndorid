#include "stdio.h"
void main(){
	int a,b,c,max;
	printf("请输入3个数（用逗号隔开）:");
	scanf("%d,%d,%d",&a,&b,&c);
	max=a>b?a:b;
	max=max>c?max:c;
	printf("其中最大的数为：%d",max);
	
	}