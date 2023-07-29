/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //求五个学生成绩中的最高分，最低分，平均分
    int i,max=0,min=10086,sum=0,score;
    for(i=0;i<5;i++){
    	printf("请输入第%d个学生的成绩:",i+1);
    	scanf("%d",&score);
    	if(max<score){ //求最大值
    		max=score;
    	}
    	if(min>score){ //求最小值
    		min=score;	
    	}
    	sum+=score;
    }
    printf("最高分：%d\t最低分：%d\t平均分%0.2f",max,min,sum/5.0);
}