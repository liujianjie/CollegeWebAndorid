/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //编写程序，计算10以内的两个数和等于10有哪些情况，输出：加数+被加数=10
    int i,j;
    for(i=0;i<=10;i++){
    	for(j=0;j<=10;j++){
    		if(i+j==10){
    			printf("%d+%d=%d \n",i,j,i+j);
    		}
    	}
    }
}