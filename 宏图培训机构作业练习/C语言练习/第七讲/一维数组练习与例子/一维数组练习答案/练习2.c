/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int a[10],i,j=0,o=0;
    printf("请输入10个整数： ");
    for(i=0;i<10;i++){
    	scanf("%d",&a[i]);
    	if(a[i]%2==0){
    		o++;
    	}else{
    		j++;
    	}
    }
    
    printf("奇数有%d个 偶数有%d个",j,o);
    
    
}