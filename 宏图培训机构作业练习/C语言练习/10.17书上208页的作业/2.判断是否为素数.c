#include "stdio.h"
int sushu(int x){
	int i,y;
	for(i=2;i++;i<x){
		if(x%i==0){
			y=0;//��������
			break;//����	
		}else{
			y=1;
		}
	}
	return y;
}
void main(){
	int a,b;
	printf("������һ��������");
	scanf("%d",&a);
	b=sushu(a);
	if(b==1){
		printf("�����������");
	}else{
		printf("�������������");
	}	
}