/* Note:Your choice is C IDE */
#include "stdio.h"
void studentavg(float a[3][7]);
void avg(float a[3][7]);
void paixu(float a[3][7]);
void main()
{
    /*
    	输入3个学生5门成绩，用函数实现以下功能
    	1、计算每个学生平均分
    	2、计算课程平均分
    	3、根据每个学生平均分排序
    */
    ///输入学生成绩
    int i,j;
    float score[3][7];
    for(i=0;i<3;i++){ //循环的是学生(行)
    	printf("请输入第%d个学生的成绩",i+1);
    	for(j=0;j<6;j++){ //循环的是课程(列)
    		scanf("%f",&score[i][j]);
    	}
    }
    studentavg(score);
    avg(score);
    paixu(score);
}
//计算学生的平均分
void studentavg(float a[3][7]){
	  int i,j;
	  for(i=0;i<3;i++){ //循环的是学生(行)
	  	a[i][6]=0; //每个学生的平均分
		for(j=1;j<6;j++){ //循环的是课程(列)
			a[i][6]+=a[i][j];
		}
		a[i][6]=a[i][6]/5;
	  }
	  printf("学号\t科目1\t科目2\t科目3\t科目4\t科目5\t平均分\n");
	  for(i=0;i<3;i++){
	  	printf("%.0f\t",a[i][0]);
	  	for(j=1;j<7;j++){
	  		printf("%.1f\t",a[i][j]);
	  	}
	  	printf("\n");
	  }
}
//计算每个科目的平均分
void avg(float a[3][7]){
	  int i,j;
	  float s[5]={0,0,0,0,0};
	  for(i=0;i<3;i++){
		s[0]+=a[i][1];
		s[1]+=a[i][2];
		s[2]+=a[i][3];
		s[3]+=a[i][4];
		s[4]+=a[i][5];
	  }
	  printf("平均分：%.1f\t%.1f\t%.1f\t\%.1f\t%.1f\n",s[0]/3,s[1]/3,s[2]/3,s[3]/3,s[4]/3);
}
//排序（冒泡排序）
void paixu(float a[3][7]){
	int i,j,k;
	float temp;
	for(i=0;i<2;i++){
		for(j=i+1;j<3;j++){
			if(a[i][6]<a[j][6]){
				for(k=0;k<7;k++){
					temp=a[i][k];
					a[i][k]=a[j][k];
					a[j][k]=temp;	
				}	
			}	
		}	
	}
	printf("排序后：\n");
	printf("学号\t科目1\t科目2\t科目3\t科目4\t科目5\t平均分\n");
	for(i=0;i<3;i++){
		printf("%.0f\t",a[i][0]);
		for(j=1;j<7;j++){
			printf("%.1f\t",a[i][j]);
		}
		printf("\n");
	}
}
