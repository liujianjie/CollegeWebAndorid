#include "stdio.h"
void main(){
	int a;
	printf("                          ��ʾ�������λ��1-100֮��\n\n");
	do{
		
		printf("\t������һ��λ��1-100֮�������");
		scanf("%d",&a);
		if(a>=1&&a<56){
			printf("\t���������С��\n");
		}else if(a>56&&a<=100){
			printf("\t�������������\n");
		}
	}while(a!=56);
	printf("\t��ϲ��¶���");
}