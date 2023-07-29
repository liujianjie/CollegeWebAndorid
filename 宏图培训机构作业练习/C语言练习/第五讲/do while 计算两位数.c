#include "stdio.h"
void main(){
	int a,b;
	char c;
	do{
		printf("请输入两位数，逗号隔开：");
		scanf("%d,%d",&a,&b);
		printf("两位数的和为：%d\n",a+b);
		printf("还要继续吗？继续请按任意键，退出按“n”键：%c");
		fflush(stdin);
		scanf("%c",&c);
	}while(c!='n');
		printf("退出成功");
	
	}
