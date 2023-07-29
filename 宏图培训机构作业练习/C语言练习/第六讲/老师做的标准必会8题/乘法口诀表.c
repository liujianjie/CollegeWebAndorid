/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	/*
		1*1=1
		1*2=2	2*2=4
		1*3=3	2*3=6	3*3=9
	*/
    //输出乘法口诀表 
    int i,j;
    for(i=1;i<10;i++){ //控制行
    	for(j=1;j<=i;j++){	//控制列
    		printf("%d*%d=%d\t",j,i,j*i);
    	}
    	printf("\n");
    }
}