/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    	int a,b[5],c[5],i,d=1,e=1;
    	b[2]=0;
    	b[3]=0;
    	b[4]=0;
		printf("\t*************************************************************\n");
		                   
		printf("\t*                                                           *\n");
		                                                       
		printf("\t*                                                           *\n");
		printf("\t*                     ��ӭ�����쳯����                      *\n");
		printf("\t*                                                           *\n");
		                                  
		printf("\t*                                                           *\n");
		                 
		printf("\t*                                                           *\n");
		
		printf("\t*************************************************************\n");
		printf("\n");
		printf("\n");
		printf("\n");
		do{
		printf("\t\t\t   ��ѡ������Ҫ�ķ���\n");
		printf("\t\t\t   1.����ע��\n");
		printf("\t\t\t   2.����\n");
		printf("\t\t\t   3.���\n");
		printf("\t\t\t   4.ȡ��\n");
		printf("\t\t\t   5.ת��\n");
		printf("\t\t\t   6.��ѯ���\n");
		printf("\t\t\t   7.�˳�\n");
		printf("\t\t\t   ����������Ҫ�ķ���");
	 	scanf("%d",&a);
	 	switch(a){
	 		case 1:
	 			system("cls");
	 			printf("\t\t\t   ��ѡ���˿���ע��ҵ��\n");
	 			printf("\t\t\t   ����������˺�:");
	 			scanf("\t\t\t   %d",&b[0]);
	 			printf("\t\t\t   �������������:");
	 			scanf("\t\t\t   %d",&b[1]);
				printf("\t\t\t   �����ɹ�,��ѡ�������档\n");	
	 			break;
	 		case 2:
				system("cls");
				printf("\t\t\t   ��ѡ���˵�����档\n");
				for(i=1;i<=3;i++){
	 				printf("\t\t\t   ����������˺ţ�");
	 				scanf("\t\t\t   %d",&c[0]);
	 				if(b[0]!=c[0]){
	 				printf("\t\t\t   �˺Ŵ�������������(���Ѿ�������%d�Σ��ܹ�����3��)��\n",i);
	 				d=0;
	 				}
	 				if(c[0]==b[0]){
	 				printf("\t\t\t   �˺���ȷ��\n");
	 				d=1;
	 				break;
	 				}
				}
				if(d==1){
				for(i=1;i<=3;i++){
	 				printf("\t\t\t   ������������룺");
	 				scanf("\t\t\t   %d",&c[1]);
	 				if(b[1]!=c[1]){
	 				printf("\t\t\t   �����������������(���Ѿ�������%d�Σ��ܹ�����3��)��\n",i);
	 				}
	 				if(c[1]==b[1]){
	 				printf("\t\t\t   ������ȷ��\n");
	 				break;
	 				}
				}
				printf("\t\t\t   ����ɹ�����ѡ������ҵ��\n");
				e=0;
				}	
	 			break;
			case 3:
				system("cls");
				if(e==0){
					printf("\t\t\t   ��ѡ���˴��ҵ��\n");
					printf("\t\t\t   ����������Ľ�");
					scanf("\t\t\t   %d",&b[2]);
					printf("\t\t\t   ���ɹ�����ѡ������ҵ��\n");
					
				}
				if(e==1){
					printf("\n");
					printf("\n");
					printf("\t\t\t   ��ע�Ტ�ҵ��룬лл������\n\n");
				}
				break;
			case 4:
				system("cls");
				if(e==0){
					printf("\t\t\t   ��ѡ����ȡ��ҵ��\n");
					printf("\t\t\t   ���������ȡ���");
					scanf("\t\t\t   %d",&b[3]);
					if(b[2]>=b[3]){
					printf("\t\t\t   ȡ��ɹ�����ѡ������ҵ��\n");
					}
				if(b[2]<=b[3]){
					printf("\t\t\t   �Բ������㣬���������롣");
				}
				}
				if(e==1){
					printf("\n");
					printf("\n");
					printf("\t\t\t   ��ע�Ტ�ҵ��룬лл������\n\n");
				}
				break;
			case 5:
				system("cls");
				if(e==0){
					printf("\t\t\t   ��ӭ����ת�˽���\n");
					printf("\t\t\t   ������Է��˺�:");
					scanf("%d",&c[4]);
					printf("\t\t\t   ��������:");
					scanf("%d",&b[4]);
				}
				
				if(e==1){
					printf("\n");
					printf("\n");
					printf("\t\t\t   ��ע�Ტ�ҵ��룬лл������\n\n");
				}
				break;
			case 6:
				system("cls");
				if(e==0){
					printf("\t\t\t   ��ѡ���˲�ѯ���\n");
					printf("\t\t\t   ������Ϊ��%d\n",b[2]-b[3]-b[4]);
				}
				if(e==1){
					printf("\n");
					printf("\n");
					printf("\t\t\t   ��ע�Ტ�ҵ��룬лл������\n\n");
				}
				break;
			case 7:
				printf("\t\t\t   �˳��ɹ�����ӭ�´�������\n");
				break;
			default:
				printf("\t\t\t   �������������ѡ��\n");
	 	}
	 	}while(a!=7);
		
}