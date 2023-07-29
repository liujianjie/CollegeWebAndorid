#include "stdio.h"
void main(){
	int a;
	char b;
	do{
		printf("请输入一个数：");
		scanf("%a",&a);
		if(a%5==0&&a%7==0){
			printf("这个数是5和7的倍数\n");
		}
		else{
			printf("这个数不是5和7的倍数\n");
		}
		printf("还要继续吗？继续请按任意键，退出请按n键");
		fflush(stdin);
		scanf("%c",&b);		
	}while(b!='n');
	printf("退出成功");
}