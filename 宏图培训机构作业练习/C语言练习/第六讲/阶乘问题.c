#include "stdio.h"
void main(){
	int a,b=1;
		printf("������һ����:");
		scanf("%d",&a);
	while(a>0){
		b*=a;
		a--;	
	}
	printf("������Ľ׳��ǣ�%d",b);
}