#include "stdio.h"
void main(){
	int a[20],i,o=0,j=0;
	printf("请输入20个整数：\n");
	for(i=0;i<20;i++){
	scanf("%d",&a[i]);
	if(a[i]%2==0){
		o++;
	}
	else{
		j++;
		
	}
	}
	printf("你输入的偶数有%d个，奇数有%d个",o,j);
}