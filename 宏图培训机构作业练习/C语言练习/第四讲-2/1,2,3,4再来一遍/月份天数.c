#include "stdio.h"
void main(){
	int a;
	printf("������������");
	scanf("%d",&a);
	switch(a){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
		    printf("����µ�������31�졣");
			break;
		case 2:
		    printf("����µĵ�������28�졣");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			printf("����µ�������30�졣");
			break;
		default:
			printf("������ ɧ��������������");
	}
	
	}