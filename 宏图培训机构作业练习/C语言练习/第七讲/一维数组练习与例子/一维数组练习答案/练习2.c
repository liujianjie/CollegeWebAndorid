/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int a[10],i,j=0,o=0;
    printf("������10�������� ");
    for(i=0;i<10;i++){
    	scanf("%d",&a[i]);
    	if(a[i]%2==0){
    		o++;
    	}else{
    		j++;
    	}
    }
    
    printf("������%d�� ż����%d��",j,o);
    
    
}