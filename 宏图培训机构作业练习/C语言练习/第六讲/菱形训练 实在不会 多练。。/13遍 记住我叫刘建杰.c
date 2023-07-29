#include "stdio.h"
int i,j,h,mid,k,x;
void shu();
void main(){
	int z;
	
	do{
		printf("请输入行数：");	
		scanf("%d",&h);
		mid=h/2+1;
		shu();
		printf("按1结束，任意键继续");
		scanf("%d",&z);
	}while(z!=1);

}
void shu(){
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