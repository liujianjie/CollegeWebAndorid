#include "stdio.h"
void main(){
	
	int a,b;
	char c;
	do{
		printf("请输入两位数用逗号隔开：");
		scanf("%d,%d",&a,&b);
		printf("这两位数的和是：%d\n",a+b);
		printf("是否继续？n键退出，任意键继续：");
		fflush(stdin);
		scanf("%c",&c);
		}while(c!='n');
	
	
	
	
	
	
	
	
	
	
	
	}