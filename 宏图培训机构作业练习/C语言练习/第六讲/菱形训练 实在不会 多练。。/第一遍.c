#include "stdio.h"
void main(){
	int h,x,k,mid,i,j;	
	printf("����������������3��Ϊ������");
	scanf("%d",&h);
	mid=h/2+1;//һ�������
	//�ϰ벿��
	for(i=1;i<=mid;i++){//�����ӡ����
		x=2*i-1;//��������
		k=(h-x)/2;//����ո���
		//��ӡ�ո�
		for(j=1;j<=k;j++){
			printf(" ");
		}//��ӡ�Ǻ�
		for(j=1;j<=x;j++){
			printf("*");
		}
		printf("\n");
	}
	//�°벿��
	for(i=mid-1;i>0;i--){//�����ӡ����
		x=2*i-1;//��������
		k=(h-x)/2;//����ո���
		//��ӡ�ո�
		for(j=1;j<=k;j++){
			printf(" ");
		}//��ӡ�Ǻ�
		for(j=1;j<=x;j++){
			printf("*");
		}
		printf("\n");
	}	
}