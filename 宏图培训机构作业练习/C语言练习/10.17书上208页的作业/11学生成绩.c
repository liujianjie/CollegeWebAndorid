#include "stdio.h"
int a[11][7],sum=0,sum2,b[5],t,k;
void ping();
void ping2();
void paixu();
void main(){
	int i,j;
	for(i=0;i<10;i++){
		printf("请输入第%d个学生的学号和5门课程的成绩：",i+1);
		for(j=0;j<6;j++){
			scanf("%d",&a[i][j]);
		}
	}
	printf("10个学生的分数表格\n");
	printf("学生号\t语文\t数学\t英语\t物理\t化学\n");
	for(i=0;i<10;i++){
		printf("  %d \t",a[i][0]);
		for(j=1;j<6;j++){
			printf("%d\t",a[i][j]);
		}
		printf("\n");
	}
	ping();
	ping2();
	paixu();
}
void ping(){
	int i,j;
	for(i=0;i<10;i++){// 循环的是学生(行)
	  	a[i][6]=0; //每个学生的平均分
		for(j=1;j<6;j++){ //循环的是课程(列)
			a[i][6]+=a[i][j];
		}
		a[i][6]=a[i][6]/5;
	  }
	printf("每个学生的平均分表格\n");
	printf("学生号\t语文\t数学\t英语\t物理\t化学\t平均分\n");
	for(i=0;i<10;i++){
		printf("  %d\t ",a[i][0]);
		for(j=1;j<7;j++){
			printf("%d\t",a[i][j]);
		}
		printf("\n");
	}
}
void ping2(){
	int i,c[5]={0,0,0,0,0};
	for(i=1;i<7;i++){
		c[0]+=a[i][1];
		c[1]+=a[i][2];
		c[2]+=a[i][3];
		c[3]+=a[i][4];
		c[4]+=a[i][5];
		
	}
	printf("每门课程的平均分：");
	for(i=0;i<5;i++){
		printf("%d\t",c[i]/5);
	}
}
void paixu(){
	int i,j;
	printf("\n");
	for(i=0;i<9;i++){//9行数据 第一行不用
		for(j=i+1;j<10;j++){//第一行和下一行再下一行和下一行
			if(a[i][6]<a[j][6]){//比的平均分
				for(k=0;k<7;k++){//一个一个的换下换上
					t=a[i][k];
     				a[i][k]=a[j][k];
     				a[j][k]=t;
				}
			}
			
		}	
		
	}
	printf("10个学生排序完的分数表格\n");
	printf("学生号\t语文\t数学\t英语\t物理\t化学\t平均分\n");
     for(i=0;i<10;i++){
     	printf("  %d\t ",a[i][0]);
     	for(j=1;j<7;j++){
     		printf("%d\t",a[i][j]);
     	}
     	printf("\n");
     }	
}