/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	/*
		1*1=1
		1*2=2	2*2=4
		1*3=3	2*3=6	3*3=9
	*/
    //����˷��ھ��� 
    int i,j;
    for(i=1;i<10;i++){ //������
    	for(j=1;j<=i;j++){	//������
    		printf("%d*%d=%d\t",j,i,j*i);
    	}
    	printf("\n");
    }
}