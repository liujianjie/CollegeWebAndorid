#include "stdio.h"
void main(){
	int i,j,a[3][2];
	for(i=0;i<3;i++){
		printf("�������%d��ѧ��������ѧ�ڵķ�����",i+1);
		for(j=0;j<2;j++){
			scanf("%d",&a[i][j]);
		}
	}
	printf("\n");
	printf("\tѧ��\t��һѧ��\t�ڶ�ѧ��\n");
	for(i=0;i<3;i++){
		printf("\t%d",i+1);
		for(j=0;j<2;j++){
		printf("\t  %d  \t  ",a[i][j]);;
		}
		printf("\n");
	}
	
	
	
	
	
	
	
}