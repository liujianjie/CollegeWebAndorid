#include "stdio.h"
void main(){
	int a[10],i;	
	for(i=0;i<10;i++){
		printf("请输入第%d个数：",i+1);
		scanf("%d",&a[i]);
	}
	printf("你输入的数是：");
	for(i=0;i<10;i++){
		printf("%d\t ",a[i]);
	}
}