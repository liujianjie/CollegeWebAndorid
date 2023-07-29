#include "stdio.h"
void main(){
	int a;
	printf("                          提示：这个数位于1-100之间\n\n");
	do{
		
		printf("\t请输入一个位于1-100之间的数：");
		scanf("%d",&a);
		if(a>=1&&a<56){
			printf("\t你输入的数小了\n");
		}else if(a>56&&a<=100){
			printf("\t你输入的数大了\n");
		}
	}while(a!=56);
	printf("\t恭喜你猜对了");
}