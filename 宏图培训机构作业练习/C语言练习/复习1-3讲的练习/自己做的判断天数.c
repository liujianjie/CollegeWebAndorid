#include "stdio.h"
void main(){
	int a,b,c,d=30,e=31,f=29;
	printf("�������·ݣ�");
	scanf("%d",&a);
	printf("���������ڣ�");
	scanf("%d",&b);
	if(a<=12&&b<=31){
		switch(a){
			case 1: 
			    printf("������2000��ĵ�%d��",b);
				break;
			case 2:
				c=e+b;
				printf("������2000��ĵ�%d��",c);
				break;
			case 3:
				c=e+f+b;
				printf("������2000��ĵ�%d��",c);
				break;	
			case 4:
				c=e+f+e+b;
				printf("������2000��ĵ�%d��",c);
				break;
			case 5:
				c=e+f+e+d+b;
				printf("������2000��ĵ�%d��",c);
				break;	
			case 6:
				c=e+f+e+d+f+b;
				printf("������2000��ĵ�%d��",c);
				break;	
			case 7:
				c=e+f+e+d+f+d+b;
				printf("������2000��ĵ�%d��",c);
				break;
			case 8:
				c=e+f+e+d+f+d+f+b;
				printf("������2000��ĵ�%d��",c);
				break;	
			case 9:
				c=e+f+e+d+f+d+f+f+b;
				printf("������2000��ĵ�%d��",c);
				break;	
			case 10:
				c=e+f+e+d+f+d+f+f+d+b;
				printf("������2000��ĵ�%d��",c);
				break;
			case 11:
				c=e+f+e+d+f+d+f+f+d+f+b;
				printf("������2000��ĵ�%d��",c);
				break;
			case 12:
				c=e+f+e+d+f+d+f+f+d+f+d+b;
				printf("������2000��ĵ�%d��",c);
				break;		
		}
	}else{
		printf("������󣬳����޷�ִ����ȥ");
	}

}