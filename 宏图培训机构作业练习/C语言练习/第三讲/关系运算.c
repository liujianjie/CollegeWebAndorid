#include "stdio.h"
void main(){
	int a,b,max;
	printf("请输入a和b逗号隔开：");
	scanf("%d,%d",&a,&b);
	printf("其中a>b为：%d\n",a>b);
	max=a>b?a:b;
	printf("其中最大的数是：%d\n",max);
	printf("是否相等：%d",a==b);
	}