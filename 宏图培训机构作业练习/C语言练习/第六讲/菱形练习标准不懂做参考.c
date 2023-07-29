#include "stdio.h"
void main(){
	int h,x,k,z,mid,i,j;
	printf("请输入行数（大于3且为奇数）：");
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
	for(i=mid-1;i>0;i--){
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