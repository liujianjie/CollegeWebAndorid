#include "stdio.h"
void main(){
	int a;
	printf("�������·ݣ�");
	scanf("%d",&a);
	switch(a){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			printf("����µ�����Ϊ31");
			break;
		case 2:
			printf("����µ�����Ϊ28");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			printf("����µ�����Ϊ30");
			break;
		default:
			printf("�������");
		
		
		
		
		}


	}