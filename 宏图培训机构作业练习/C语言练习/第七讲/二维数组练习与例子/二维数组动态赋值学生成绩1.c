#include "stdio.h"
void main(){
	int i,j,a[2][5];	
	for(i=0;i<2;i++){
		printf("请输入第%d个班5个学生的成绩：",i+1);
		for(j=0;j<5;j++){
			scanf("%d",&a[i][j]);
		}
	}
	printf("\n");
	printf("\t班级\t学生1\t学生2\t学生3\t学生4\t学生5\n");
	for(i=0;i<2;i++){
		printf("\t%d",i+1);
		for(j=0;j<5;j++){
			printf("\t%d",a[i][j]);
		}
		printf("\n");
	}
	
	
	
	
}