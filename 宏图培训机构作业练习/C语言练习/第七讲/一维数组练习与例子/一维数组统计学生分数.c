#include "stdio.h"
void main(){
	int a[5],c=0,b=0,i;
	printf("������5��ѧ���ĳɼ����ո��������");
	for(i=0;i<5;i++){
		scanf("%d",&a[i]);
		if(a[i]<60){
			c++;
		}
		if(a[i]>=80){
			b++;
		}
	}
	printf("\n");
	printf("��5��ѧ���ĳɼ�Ϊ��\n");
	for(i=0;i<5;i++){
		printf("%d\t",a[i]);
	}
	printf("\n");
	printf("С��60�ֵ��У�%d��\n",c);
	printf("����80�ֵ��У�%d��\n",b);
	
	
}