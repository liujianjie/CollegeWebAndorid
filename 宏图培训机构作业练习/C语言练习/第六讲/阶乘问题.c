#include "stdio.h"
void main(){
	int a,b=1;
		printf("请输入一个数:");
		scanf("%d",&a);
	while(a>0){
		b*=a;
		a--;	
	}
	printf("这个数的阶乘是：%d",b);
}