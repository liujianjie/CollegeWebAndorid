#include "stdio.h"
void main(){
	int a,b,c=0;
	printf("�������·ݺ����ڣ��ո��������");
	scanf("%d %d",&a,&b);
	switch(a){
		case 12:
			c+=30;
		case 11:
			c+=31;
		case 10:
			c+=30;
		case 9:
			c+=31;
		case 8:
			c+=31;
		case 7:
			c+=30;		
		case 6:
			c+=31;
		case 5:
			c+=30;
		case 4:
			c+=31;		
		case 3:
			c+=29;
		case 2:
			c+=30;
		case 1:
			c+=b;
			break;
		default:
			printf("�����������������");
			break;
	}
		printf("������%d",c);
}