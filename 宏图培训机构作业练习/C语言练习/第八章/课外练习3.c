#include "stdio.h"
void main(){
	int a[15]={34,32,30,28,26,24,22,20,18,16,14,12,10,8,6},i,b;	
	printf("请输入一个数：");
	scanf("%d",&b);
	for(i=0;i<15;i++){
		if(b==a[i]){
			printf("这个数是数组中的第%d个元素",i+1);	
			break;
		}
	}
	if(i>=15){
		printf("无此数。。。");
	}
	
	
	
	
	
	
}