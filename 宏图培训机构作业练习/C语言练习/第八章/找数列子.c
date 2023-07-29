#include "stdio.h"
void main(){
	int a[5],i,b;
	printf("请输入5个数空格隔开：");
	for(i=0;i<5;i++){
		scanf("%d",&a[i]);
	}
	printf("请输入你要找的数：");
	scanf("%d",&b);
	for(i=0;i<5;i++){
		if(a[i]==b){
			printf("恭喜你！在第%d个数中找到了",i+1);
			break;	
		}
	}
	if(i>=5){
		printf("很遗憾，没有找到");
	}
	
}