/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int a[2][4],i,j,sum=0,max=0;
    for(i=0;i<2;i++){
    	printf("�������%d��ͬѧ��ѧ�ţ����ġ���ѧ��Ӣ��ÿո������",i+1);
    	 for(j=0;j<4;j++){
    		scanf("%d",&a[i][j]);
    	}
    }
    
    printf("\tѧ��\t����\t��ѧ\tӢ��\t�ܷ�\n");
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
    	 	printf("�ܷ���ߵ�ͬѧ�ǣ�%d",a[i][0]);
    	 }
   
  }
   
}