#include "stdio.h"
void main(){
	int h,x,k,mid,a,b;
	printf("«Î ‰»Î–– ˝");
	scanf("%d",&h);
	mid=h/2+1;
	for(a=1;a<=mid;a++){
		x=2*a-1;
		k=(h-x)/2;
		for(b=1;b<=k;b++){
			printf(" ");
		}
		for(b=1;b<=x;b++){
			printf("*");
		}
		printf("\n");
	}
	for(a=mid-1;a>0;a--){
		x=2*a-1;
		k=(h-x)/2;
		for(b=1;b<=k;b++){
			printf(" ");
		}
		for(b=1;b<=x;b++){
			printf("*");
		}
		printf("\n");
	}
}