/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    float score[10],sum=0,jige=0;
    int i;
    printf("����10��ѧ����C���Գɼ����ÿո������");
    for(i=0;i<10;i++){
    	scanf("%f",&score[i]);
    	sum+=score[i];
    	if(score[i]>=60){
    		jige++;
    	}
    }
    
   printf("ƽ���ɼ���%.2f \n",sum/10); 
    
   printf("��������%.2f%%  \n",jige/10*100); 
    
}