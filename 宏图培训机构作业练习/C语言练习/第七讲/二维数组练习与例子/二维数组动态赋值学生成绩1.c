#include "stdio.h"
void main(){
	int i,j,a[2][5];	
	for(i=0;i<2;i++){
		printf("�������%d����5��ѧ���ĳɼ���",i+1);
		for(j=0;j<5;j++){
			scanf("%d",&a[i][j]);
		}
	}
	printf("\n");
	printf("\t�༶\tѧ��1\tѧ��2\tѧ��3\tѧ��4\tѧ��5\n");
	for(i=0;i<2;i++){
		printf("\t%d",i+1);
		for(j=0;j<5;j++){
			printf("\t%d",a[i][j]);
		}
		printf("\n");
	}
	
	
	
	
}