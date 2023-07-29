#include "stdio.h"
int sushu(int x){
	int i,y;
	for(i=2;i++;i<x){
		if(x%i==0){
			y=0;//不是素数
			break;//跳出	
		}else{
			y=1;
		}
	}
	return y;
}
void main(){
	int a,b;
	printf("请输入一个整数：");
	scanf("%d",&a);
	b=sushu(a);
	if(b==1){
		printf("这个数是素数");
	}else{
		printf("这个数不是素数");
	}	
}