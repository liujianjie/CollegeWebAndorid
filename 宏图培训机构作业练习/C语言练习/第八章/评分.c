#include "stdio.h"
void main(){
	int i,j,a[5][5],sum=0,max=0,min=1000,x=0,z,y;
	float b;
	printf("             *                好声音决赛评分系统                 *\n");
	printf("             =====================================================\n");
	printf("             宏图04班好声音大赛（决赛）决战之夜\n");
	printf("             =====================================================\n");
	for(i=0;i<5;i++){
		printf("             5位裁判给第%d位同学的打分：",i+1);
		for(j=0;j<5;j++){
			scanf("%d",&a[i][j]);
		}
	}
	printf("             各裁判的评分如下\n");
	printf("选手号\t评委1\t评委2\t评委3\t评委4\t评委5\t总分\t最高分\t最低分\t平均分\n");
	for(i=0;i<5;i++){
		sum=0;
		max=0;
		min=1000;
		printf(" %d",i+1);
		for(j=0;j<5;j++){
			printf("   \t%d",a[i][j]);
			if(j>=0){
				sum=sum+a[i][j];
			}
			if(max<a[i][j]){
				max=a[i][j];
			}
			if(min>a[i][j]){
				min=a[i][j];
			}
			b=(sum-max-min)/3;
			y=sum-max-min;
			if(x<=y){
				x=y;
				z=i+1;
			}
		}
		printf("\t%d",sum);
		printf("\t%d",max);
		printf("\t%d",min);
		printf("\t%.2f",b);
		printf("\n");
	}	
	printf("             冠军是%d同学，去掉一个最高分和最低分的最后分数是%d",z,x);
}