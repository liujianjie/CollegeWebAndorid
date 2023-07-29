#include "stdio.h"
void main(){
	int max,a,b,c;
	printf("请输入三个数逗号隔开：");
	scanf("%d,%d,%d",&a,&b,&c);
	if(a>b){
		max=a;
	}else{
		max=b;
	}if(max>c){
		printf("着三个数最大的是：%d",max);
	}else{
		printf("着三个数最大的是：%d",c);
	}
	
	}