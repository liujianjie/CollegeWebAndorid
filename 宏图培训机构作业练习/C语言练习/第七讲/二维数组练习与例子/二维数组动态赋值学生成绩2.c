#include "stdio.h"
void main(){
	int i,j,a[3][2];
	for(i=0;i<3;i++){
		printf("请输入第%d个学生的两个学期的分数：",i+1);
		for(j=0;j<2;j++){
			scanf("%d",&a[i][j]);
		}
	}
	printf("\n");
	printf("\t学生\t第一学期\t第二学期\n");
	for(i=0;i<3;i++){
		printf("\t%d",i+1);
		for(j=0;j<2;j++){
		printf("\t  %d  \t  ",a[i][j]);;
		}
		printf("\n");
	}
	
	
	
	
	
	
	
}