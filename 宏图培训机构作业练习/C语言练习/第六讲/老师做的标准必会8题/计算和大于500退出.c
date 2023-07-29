/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //用for循环计算sum=1+2+3+4+....,直到sum>500时退出
    int i,sum=0;
    for(i=1;i<100;i++){
    	sum+=i;
    	if(sum>500)	
    		break;
    
    }
    	printf("%d\n",sum);
   
}