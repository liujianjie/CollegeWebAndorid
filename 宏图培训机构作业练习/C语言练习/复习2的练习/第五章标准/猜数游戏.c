/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //������Ϸ 
    int a=66,b;
    do{
    	printf("������һ������");
    	scanf("%d",&b);
    	if(b>a){
    		printf("�´��ˣ�\n");
    	}
    	if(b<a){
    		printf("��С�ˣ�\n");
    	}
    }while(b!=66);
    printf("��ϲ�㣬������ˣ�����");
}