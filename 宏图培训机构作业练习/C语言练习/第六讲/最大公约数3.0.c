#include "stdio.h"
void main(){
	int a,b,c;
	printf("���������������ո������");
	scanf("%d %d",&a,&b);
	for(c=a;c>0;c--){
		if(a%c==0&&b%c==0){
			printf("%d",c);
			break;
		}
	}
}