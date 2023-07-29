#include "stdio.h"
void main(){
	int x,y;
	printf("请输入一位整数：");
	scanf("%d",&x);
	if(3<=x&&x<10){
		y=x*x;
		printf("函数值为：%d",y);
	}else if(0<=x&&x<3){
		y=x*x-3*x+1;
		printf("函数值为：%d",y);	
	}else if(x<0){
		y=x*x+6*x-1;
		printf("函数值为：%d",y);
	}else{
		y=x*x-x-1;
		printf("函数值为：%d",y);
	}
	
	
	
	
	
	
	

	
	}