#include "stdio.h"
void main(){
	int a=1,b,max=0,min=123123,sum=0;
	while(a<6){
		printf("�������%dͬѧ�ĳɼ���",a);
		scanf("%d",&b);
		a++;
		sum+=b;
		if(max<=b){
			max=b;
		}
		if(min>=b){
			min=b;	
		}
	}	printf("ƽ������%d�����ķ�����%d����С�ķ�����%d",sum/5,max,min);
}