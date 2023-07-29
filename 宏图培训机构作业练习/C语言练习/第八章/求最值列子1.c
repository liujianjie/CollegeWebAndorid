#include "stdio.h"
void main(){
	int a[5],i,max=0,min=10000;	
	printf("请输入5位数空格隔开：");
	for(i=0;i<5;i++){
		scanf("%d",&a[i]);
	}
	for(i=0;i<5;i++){
		if(max<a[i]){
			max=a[i];
		}
		if(min>a[i]){
			min=a[i];
		}
	}
	printf("最大的值为：%d",max);
	printf("最小的值为：%d",min);
}