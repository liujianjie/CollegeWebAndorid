#include "stdio.h"
void main(){
		int a;
		printf("       *************************************************************\n");
		                   
		printf("       *                                                           *\n");
		                                                       
		printf("       *                                                           *\n");
		printf("       *                     ��ӭ�����쳯����                      *\n");
		printf("       *                                                           *\n");
		                                  
		printf("       *                                                           *\n");
		                 
		printf("       *                                                           *\n");
		
		printf("       *************************************************************\n");
		printf("\n");
		printf("\n");
		printf("\n");
		printf("                           ��ѡ������Ҫ�ķ���\n");
		printf("                             1.���\n");
		printf("                             2.ȡ��\n");
		printf("                             3.����\n");
		printf("                             4.��ѯ���\n");
		printf("                             5.ת��\n");
		printf("                             6.�˳�\n");
		printf("                           ����������Ҫ�ķ���");
	 	scanf("%d",&a);
	 	switch(a){
	 		case 1:
	 			printf("                           ��ѡ���˴��ҵ��");
	 			break;
			case 2:
				printf("                           ��ѡ����ȡ��ҵ��");
				break;
			case 3:
				printf("                           ��ѡ���˿���ҵ��");
				break;
			case 4:
				printf("                           ������Ϊ...�Բ���ϵͳ����");
				break;
			case 5:
				printf("                           ת��...��ʱ�޷�ʵ�ִ˲�����");
				break;
			case 6:
				printf("                           �˳��ɹ�����ӭ�´�������");
				break;
			default:
				printf("                           �������������ѡ��");
	 	}
	}