/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int j[50],o[51],i,m=0,n=0;
    
    for(i=100;i>=0;i--){
    	if(i%2==0){
    		//��ż��
    		o[m]=i;
    		m++;
    	}else{
    		j[n]=i;
    		n++;
    	}
    }
    printf("������: \n");
    for(i=0;i<50;i++){
    	printf("%d ",j[i]);
    	if((i+1)%13==0){
    		printf("\n");
    	}
    }
       printf("\nż����: \n");
     for(i=0;i<51;i++){
    	printf("%d ",o[i]);
    	if((i+1)%13==0){
    		printf("\n");
    	}
    }
}