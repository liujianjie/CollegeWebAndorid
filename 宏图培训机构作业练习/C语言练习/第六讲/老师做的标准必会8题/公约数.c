/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //�������������������Լ��
    int a,b,max=0,min,i;
    printf("������Ҫ��������������ո������");
    scanf("%d %d",&a,&b);
    //�Ƚϻ��a b���������õ�a b�и�С�������Ա��ڼ�Сѭ������
    min=a>b?b:a;
    for(i=1;i<=min;i++){
    	if(a%i==0 && b%i==0){ //�ж�i�Ƿ�Ϊa b�Ĺ�Լ��
    		if(max<=i){
    			max=i;
    		}
    	}
    }
    printf("%d��%d���Ĺ�Լ��Ϊ��%d",a,b,max);
}