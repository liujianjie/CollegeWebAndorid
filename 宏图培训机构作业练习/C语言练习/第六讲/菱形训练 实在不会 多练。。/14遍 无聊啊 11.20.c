//11��20�� ���ֻ���д������
#include "stdio.h"
void main(){
	int h,x,k,i,j,mid;
	printf("���������������");	
	scanf("%d",&h);
	mid=h/2+1;
	for(i=1;i<=mid;i++){
		x=2*i-1;
		k=(h-x)/2;	
		for(j=1;j<=k;j++){
			printf(" ");
		}
		for(j=1;j<=x;j++){
			printf("*");
		}
		printf("\n");
	}
	for(i=mid-1;i>0;i--){//�����i>0�е�Сʧ�� ����i=1����������˼Ϊʽ�� ����Ϊ����
		x=2*i-1;
		k=(h-x)/2;	
		for(j=1;j<=k;j++){
			printf(" ");
		}
		for(j=1;j<=x;j++){
			printf("*");
		}
		printf("\n");
	}

}