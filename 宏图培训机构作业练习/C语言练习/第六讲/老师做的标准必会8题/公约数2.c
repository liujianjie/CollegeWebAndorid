/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //�������������������Լ��
    int a,b,i,min;
    printf("������Ҫ��������������ո������");
    scanf("%d %d",&a,&b);
    min=a>b?b:a;
    for(i=min;i>0;i--){
    	if(a%i==0 && b%i==0){
    		printf("%d��%d���Ĺ�Լ��Ϊ��%d",a,b,i);
    		break;	
    	}
    }
}