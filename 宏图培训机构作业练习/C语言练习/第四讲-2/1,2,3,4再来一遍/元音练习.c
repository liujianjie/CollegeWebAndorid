#include "stdio.h"
void main(){
	char c;
	printf("������һ����ĸ��");
	scanf("%c",&c);
	switch(c){
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			printf("�������Ԫ��");
		break;
		default:
			printf("������Ǹ���");
		}
	
	
	}