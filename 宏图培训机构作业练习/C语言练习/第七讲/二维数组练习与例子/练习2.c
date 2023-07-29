#include "stdio.h"
void main(){
	int i,j,a[5][4],b=0,c;
	for(i=0;i<5;i++){
		printf("请输入第%d个学生的三门分数：",i+1);
		for(j=0;j<3;j++){
			scanf("%d",&a[i][j]);
		}
	}
	a[0][3]=a[0][0]+a[0][1]+a[0][2];
	a[1][3]=a[1][0]+a[1][1]+a[1][2];
	a[2][3]=a[2][0]+a[2][1]+a[2][2];
	a[3][3]=a[3][0]+a[3][1]+a[3][2];
	a[4][3]=a[4][0]+a[4][1]+a[4][2];
	printf("\n");
	printf("表格为:\n");
	printf("\t学号\t语文\t数学\t英语\t总分\n");
	for(i=0;i<5;i++){
		printf("\t%d",i+100);
		for(j=0;j<4;j++){

			printf("\t%d",a[i][j]);
			if(b<=a[i][3]){
				b=a[i][3];
				c=i+100;
			}
		}
		printf("\n");
	}
	printf("最高的分数是:%d,学号为：%d",b,c);
	
	
	
	
}