/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
/*
		*
	   ***
	  *****
	 *******
	  *****
	   ***
	    *
	1���кŵ����ַ���
	2���Ǻŵĸ���������*2-1
	3���ո���������ַ���-�Ǻ�����/2
*/
	//������� 
    int line,start,space,i,j,mid;
    printf("�������кţ���������");
    scanf("%d",&line);
    mid=line/2+1;
    for(i=1;i<=mid;i++){ //�������ε�����
    	//�����ǺŸ���
    	start=i*2-1;
    	//��ӡ�ո�
    	space=(line-start)/2;
    	for(j=1;j<=space;j++){
    		printf(" ");	
    	}
    	//��ӡ�Ǻ�
    	for(j=1;j<=start;j++){
    		printf("*");	
    	}
    	printf("\n");
    }
    //
    for(i=mid-1;i>0;i--){ //�������ε�����
    	//�����ǺŸ���
    	start=i*2-1;
    	//��ӡ�ո�
    	space=(line-start)/2;
    	for(j=1;j<=space;j++){
    		printf(" ");	
    	}
    	//��ӡ�Ǻ�
    	for(j=1;j<=start;j++){
    		printf("*");	
    	}
    	printf("\n");
    }
}