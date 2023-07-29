#include "stdio.h"
void main(){
	int h,x,k,mid,i,j;	
	printf("请输入行数（大于3且为奇数）");
	scanf("%d",&h);
	mid=h/2+1;//一半的行数
	//上半部分
	for(i=1;i<=mid;i++){//计算打印行数
		x=2*i-1;//计算星数
		k=(h-x)/2;//计算空格数
		//打印空格
		for(j=1;j<=k;j++){
			printf(" ");
		}//打印星号
		for(j=1;j<=x;j++){
			printf("*");
		}
		printf("\n");
	}
	//下半部分
	for(i=mid-1;i>0;i--){//计算打印行数
		x=2*i-1;//计算星数
		k=(h-x)/2;//计算空格数
		//打印空格
		for(j=1;j<=k;j++){
			printf(" ");
		}//打印星号
		for(j=1;j<=x;j++){
			printf("*");
		}
		printf("\n");
	}	
}