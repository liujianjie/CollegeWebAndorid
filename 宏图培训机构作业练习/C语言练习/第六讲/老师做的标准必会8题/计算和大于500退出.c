/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //��forѭ������sum=1+2+3+4+....,ֱ��sum>500ʱ�˳�
    int i,sum=0;
    for(i=1;i<100;i++){
    	sum+=i;
    	if(sum>500)	
    		break;
    
    }
    	printf("%d\n",sum);
   
}