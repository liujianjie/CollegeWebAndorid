#include "stdio.h"
void main(){
	//
	int i=0,s,a[20];	
	printf("������һ��ʮ���Ƶ�������");
	scanf("%d",&s);
	while(s>0){
		a[i]=s%2;
		s=s/2;
		i++;
	}
	for(i=i-1;i>=0;i--){
		printf("%d",a[i]);
	}
}