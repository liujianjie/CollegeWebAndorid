#include "stdio.h"
void main(){
	int a;
	char b;
	do{
		printf("������һ������");
		scanf("%a",&a);
		if(a%5==0&&a%7==0){
			printf("�������5��7�ı���\n");
		}
		else{
			printf("���������5��7�ı���\n");
		}
		printf("��Ҫ�����𣿼����밴��������˳��밴n��");
		fflush(stdin);
		scanf("%c",&b);		
	}while(b!='n');
	printf("�˳��ɹ�");
}