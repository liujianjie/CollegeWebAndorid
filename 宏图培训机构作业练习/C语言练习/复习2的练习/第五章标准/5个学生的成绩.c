/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //�����ѧ���ɼ��е���߷֣���ͷ֣�ƽ����
    int i,max=0,min=10086,sum=0,score;
    for(i=0;i<5;i++){
    	printf("�������%d��ѧ���ĳɼ�:",i+1);
    	scanf("%d",&score);
    	if(max<score){ //�����ֵ
    		max=score;
    	}
    	if(min>score){ //����Сֵ
    		min=score;	
    	}
    	sum+=score;
    }
    printf("��߷֣�%d\t��ͷ֣�%d\tƽ����%0.2f",max,min,sum/5.0);
}