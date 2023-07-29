#include "stdio.h"
void main(){
	int a,b,c,max;
	printf("请输入三个数逗号隔开：");
	scanf("%d,%d,%d",&a,&b,&c);
	if(a>b){
		max=a;
		
	}else{
		max=b;
	}
	if(max>c){
			printf("三个数中最大的是：%d",max);
	}else{
			printf("三个数中最大的是：%d",c);
	}
	}