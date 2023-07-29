#include "stdio.h"
void main(){
	 int a,b,c;
	 printf("请输入三个数逗号隔开：");
	 scanf("%d,%d,%d",&a,&b,&c);
	 printf("其中a>b为：%d\n",a>b);
	 printf("其中a>b且b<c为：%d\n",a>b&&a>c);
	 printf("其中a<b且b<c为：%d\n",a>b||c<b);
	
	
	}