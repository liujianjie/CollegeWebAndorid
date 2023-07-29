#include "stdio.h"
void main(){
	int a,b,c;
	printf("请输入两个数（空格隔开）");
	scanf("%d %d",&a,&b);
	for(c=a;c>0;c--){
		if(a%c==0&&b%c==0){
			printf("%d",c);
			break;
		}
	}
}