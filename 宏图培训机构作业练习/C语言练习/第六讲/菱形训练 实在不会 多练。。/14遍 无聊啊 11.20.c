//11月20日 我又回来写菱形了
#include "stdio.h"
void main(){
	int h,x,k,i,j,mid;
	printf("请输入你的行数：");	
	scanf("%d",&h);
	mid=h/2+1;
	for(i=1;i<=mid;i++){
		x=2*i-1;
		k=(h-x)/2;	
		for(j=1;j<=k;j++){
			printf(" ");
		}
		for(j=1;j<=x;j++){
			printf("*");
		}
		printf("\n");
	}
	for(i=mid-1;i>0;i--){//这里的i>0有点小失误 不能i=1，这样的意思为式子 而不为条件
		x=2*i-1;
		k=(h-x)/2;	
		for(j=1;j<=k;j++){
			printf(" ");
		}
		for(j=1;j<=x;j++){
			printf("*");
		}
		printf("\n");
	}

}