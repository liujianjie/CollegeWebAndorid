#include "stdio.h"
void main(){
	int a[15]={34,32,30,28,26,24,22,20,18,16,14,12,10,8,6},i,b;	
	printf("������һ������");
	scanf("%d",&b);
	for(i=0;i<15;i++){
		if(b==a[i]){
			printf("������������еĵ�%d��Ԫ��",i+1);	
			break;
		}
	}
	if(i>=15){
		printf("�޴���������");
	}
	
	
	
	
	
	
}