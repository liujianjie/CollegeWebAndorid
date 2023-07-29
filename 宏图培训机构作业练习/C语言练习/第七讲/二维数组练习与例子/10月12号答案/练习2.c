/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int a[2][4],i,j,sum=0,max=0;
    for(i=0;i<2;i++){
    	printf("请输入第%d个同学的学号，语文、数学、英语，用空格隔开：",i+1);
    	 for(j=0;j<4;j++){
    		scanf("%d",&a[i][j]);
    	}
    }
    
    printf("\t学号\t语文\t数学\t英语\t总分\n");
    for(i=0;i<2;i++){
    	sum=0;
    	 for(j=0;j<4;j++){
    	 		printf("\t%d",a[i][j]);
    	 		if(j>0){
    	 			sum+=a[i][j];
    	 		}
    	 		
    	 }
    	
    	 printf("\t%d",sum);
    	 if(max<sum){
    	 	max=sum;
    	 }
    	 printf("\n");
    }
    
  for(i=0;i<2;i++){
    	sum=0;
    	 for(j=0;j<4;j++){
   				if(j>0){
    	 			sum+=a[i][j];
    	 		}
    	 }
    	 if(sum==max){
    	 	printf("总分最高的同学是：%d",a[i][0]);
    	 }
   
  }
   
}