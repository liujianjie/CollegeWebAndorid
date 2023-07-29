/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    /*
    	5个评委，5个选手，去掉评委给的最高分，最低分，求选手的平均分
    		1、输出冠军
    		2、平均分排序
    */
    float a[5][9],max,temp;
    int i,j,c=0,k;
	//输入
    for(i=0;i<5;i++){ //循环行（选手）
    	a[i][6]=0;
     	a[i][7]=10086;
     	a[i][8]=0;
     	//a[i][9]=0;  报错，数组越界，数组的下标是从0开始的
    	printf("选手已经演唱完毕，请裁判编号并且打分\n");
    	for(j=0;j<6;j++){
    		scanf("%f",&a[i][j]);
    		if(j>0){
    			//每一个人裁判给的最高分
    			if(a[i][6]<a[i][j]){
    				a[i][6]=a[i][j];
    			}
    			//每一个人裁判给的最低分
    			if(a[i][7]>a[i][j]){
    				a[i][7]=a[i][j];
    			}
    			//计算总分
    			a[i][8]+=a[i][j];
    		}
    	}
    	//求平均分
    	a[i][8]=(a[i][8]-a[i][6]-a[i][7])/3;
    }
    //输出
    printf("选手号\t评委1\t评委2\t评委3\t评委4\t评委5\t最高分\t最低分\t平均分\n");
     for(i=0;i<5;i++){ //循环行（选手）
     	printf("%.0f\t",a[i][0]);
     	for(j=1;j<9;j++){
     		printf("%.1f\t",a[i][j]);
     	}
     	printf("\n");
     }
     //找冠军（平均分最高的选手）
     max=a[0][8];
     for(i=1;i<5;i++){
     	if(max<a[i][8]){
     		max=a[i][8];
     		c=i;	
     	}
     }
     printf("%.0f号选手是冠军，最后得分为%.1f\n",a[c][0],max);
     printf("排序前：\n");
     for(i=0;i<5;i++){
        printf("%.1f\t",a[i][8]);
     }
     printf("\n");
     //排序（冒泡排序）
     for(i=0;i<5;i++){  //i=0
     	for(j=i+1;j<5;j++){ //j=1
     		if(a[i][8]<a[j][8]){
     			//对每一列都更换位置
     			for(k=0;k<9;k++){
     				temp=a[i][k];
     				a[i][k]=a[j][k];
     				a[j][k]=temp;
     			}
     		}
     	}
     }
     printf("排序后：\n");
     for(i=0;i<5;i++){
        printf("%.1f\t",a[i][8]);
     }
     printf("\n");
      //输出
     printf("选手号\t评委1\t评委2\t评委3\t评委4\t评委5\t最高分\t最低分\t平均分\n");
     for(i=0;i<5;i++){ //循环行（选手）
     	printf("%.0f\t",a[i][0]);
     	for(j=1;j<9;j++){
     		printf("%.1f\t",a[i][j]);
     	}
     	printf("\n");
     }
}