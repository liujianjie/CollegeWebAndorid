#include "stdio.h"
void main(){
	int a[5],i,max=0,min=10000;	
	printf("������5λ���ո������");
	for(i=0;i<5;i++){
		scanf("%d",&a[i]);
	}
	for(i=0;i<5;i++){
		if(max<a[i]){
			max=a[i];
		}
		if(min>a[i]){
			min=a[i];
		}
	}
	printf("����ֵΪ��%d",max);
	printf("��С��ֵΪ��%d",min);
}