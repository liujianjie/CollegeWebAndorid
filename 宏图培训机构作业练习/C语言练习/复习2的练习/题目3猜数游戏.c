#include "stdio.h"
void main(){
	int a,b=50;
	printf("                              ��ʾ:���������1-100֮��\n");
	do {
		printf("\t�������������");
		scanf("%d",&a);
		if(1<=a&&a<50){
			printf("\t���������С������������\n");
		}else if(a<=100&&a>50){
			printf("\t�����������������������\n");
		}else{printf("\t�����������������\n");}
		
		
	}while(a!=b);
	printf("\t��ϲ��¶���");
}