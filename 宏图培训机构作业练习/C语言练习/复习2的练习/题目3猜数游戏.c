#include "stdio.h"
void main(){
	int a,b=50;
	printf("                              提示:这个数介于1-100之间\n");
	do {
		printf("\t请输入你的数：");
		scanf("%d",&a);
		if(1<=a&&a<50){
			printf("\t你输入的数小了请重新输入\n");
		}else if(a<=100&&a>50){
			printf("\t你输入的数大了请重新输入\n");
		}else{printf("\t输入错误请重新输入\n");}
		
		
	}while(a!=b);
	printf("\t恭喜你猜对了");
}