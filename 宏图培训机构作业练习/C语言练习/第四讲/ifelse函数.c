#include "stdio.h"
void main(){
	int x,y;
	printf("������һλ������");
	scanf("%d",&x);
	if(3<=x&&x<10){
		y=x*x;
		printf("����ֵΪ��%d",y);
	}else if(0<=x&&x<3){
		y=x*x-3*x+1;
		printf("����ֵΪ��%d",y);	
	}else if(x<0){
		y=x*x+6*x-1;
		printf("����ֵΪ��%d",y);
	}else{
		y=x*x-x-1;
		printf("����ֵΪ��%d",y);
	}
	
	
	
	
	
	
	

	
	}