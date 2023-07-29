#include "stdio.h"
void main(){
	int i,j,a[5][5],sum=0,max=0,min=1000,x=0,z,y,c[5],mid,t;
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
		c[i]=0;
		max=0;
		min=1000;
		printf(" %d",i+1);
		for(j=0;j<5;j++){
			printf("   \t%d",a[i][j]);
			if(j>=0){
				c[i]=c[i]+a[i][j];
			}
			if(max<a[i][j]){
				max=a[i][j];
			}
			if(min>a[i][j]){
				min=a[i][j];
			}
			b=(c[i]-max-min)/3;
			y=c[i]-max-min;
			if(x<=y){
				x=y;
				z=i+1;
			}
		}
		printf("\t%d",c[i]);
		printf("\t%d",max);
		printf("\t%d",min);
		printf("\t%.2f",b);
		printf("\n");
	}	
	printf("             冠军是%d同学，去掉一个最高分和最低分的最后分数是%d\n",z,x);
	//第一种：书上144页for(j=0;j<4;j++){
		//for(i=0;i<4-j;i++){
			//if(c[i]>c[i+1]){
				//t=c[i];//把大的换前面 一一个比
				//c[i]=c[i+1];
				//c[i+1]=t;
			//}
		//}
	//}这样排的话会从低到高而非从高到低
	for(i=0;i<5;i++){//一排的数
		for(j=i+1;j<5;j++){//一个数后面的数6666
			if(c[i]<c[j]){//第一个数比后面的数
				t=c[j];//如果第一个数小于第二个数就换位置如此循环下去
				c[j]=c[i];
				c[i]=t;
			}
		}
	}

	printf("             成绩从高到低的排序为：");//输出
	for(i=0;i<5;i++){
		printf("%d\t",c[i]);
	}
}
/*
	再来一次冒泡循环；
	for(i=0;i<5;i++){
		for(j=i+1;j<5;j++){
			if(c[i]<c[j]){
				t=c[j];
				c[j]=c[i];
				c[i]=t;
			}
		}
	}
*/