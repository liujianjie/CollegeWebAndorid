#include "stdio.h"
void lianjie(){
	char a[100],b[100];	
	printf("�������һ�λ���");
	gets(a);
	printf("������ڶ��λ�:");
	gets(b);
	printf("��������Ϊ��%s",strcat(a,b));
}
void main(){
	
	lianjie();
		
	
}