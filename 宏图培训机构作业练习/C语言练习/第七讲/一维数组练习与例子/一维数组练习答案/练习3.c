/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    float score[10],sum=0,jige=0;
    int i;
    printf("输入10个学生的C语言成绩，用空格隔开：");
    for(i=0;i<10;i++){
    	scanf("%f",&score[i]);
    	sum+=score[i];
    	if(score[i]>=60){
    		jige++;
    	}
    }
    
   printf("平均成绩是%.2f \n",sum/10); 
    
   printf("及格率是%.2f%%  \n",jige/10*100); 
    
}