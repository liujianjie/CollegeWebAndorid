/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //����һ�������ж��Ƿ�Ϊ5��7�ı������û�����ѭ�����룬ֱ����n�˳�
    int num;
    char c;
    do{
    	printf("��������Ҫ�жϵ�����");
    	scanf("%d",&num);
    	if(num%5==0 && num%7==0){//�ж��������5�ı�����Ҳ��7�ı���
    		printf("%d�������5��7�ı�����\n",num);
    	}else{
    		printf("%d���������5��7�ı�����\n",num);
    	}
    	printf("���������������n�˳�");
    	fflush(stdin);
    	scanf("%c",&c);
    }while(c!='n');
}