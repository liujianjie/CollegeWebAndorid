/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //��д���򣬼���10���ڵ��������͵���10����Щ��������������+������=10
    int i,j;
    for(i=0;i<=10;i++){
    	for(j=0;j<=10;j++){
    		if(i+j==10){
    			printf("%d+%d=%d \n",i,j,i+j);
    		}
    	}
    }
}