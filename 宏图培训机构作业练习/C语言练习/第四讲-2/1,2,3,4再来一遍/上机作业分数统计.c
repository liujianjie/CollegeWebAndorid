#include "stdio.h"
void main(){
	int a,g;
	printf("������ķ�����");
	scanf("%d",&a);
	g=a/10;
	switch(g){
		case 10:
		case 9:
		case 8:
		printf("A");
		break;
		case 7:
		case 6:
		case 5:
		printf("B");
		break;
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
		printf("C");
		break;
		default:
		printf("�ܷ���100�֣� ��tm�ǲ���ɵ�������������");
		

		
		}
	

	}