#include "stdio.h"
void main(){
	int i,j,k,x,mid,h;
	printf("«Î ‰»Î–– ˝£∫");
	scanf("%d",&h);
	mid=h/2+1;
	for(i=0;i<=mid;i++){
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