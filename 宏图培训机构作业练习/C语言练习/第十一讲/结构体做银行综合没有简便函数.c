/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 50
struct ban{
	char name[20];
	float zhang;
	float mima;
	float money;	
}b[N];
int count=0;//ȫ�ֱ���
void kaihu();
void cunkuan();
void qukuan();
void zhuanzhang();
void chaxun();
void xiugai();
void jian();
void main()
{
		int a;
		do{
		printf("\t*************************************************************\n");                   
		printf("\t*                                                           *\n");
		printf("\t*                     ��ӭ�����쳯����                      *\n");
		printf("\t*                                                           *\n");                               
		printf("\t*                                                           *\n");              
		printf("\t*************************************************************\n");
		printf("\n");
		printf("\n");
		printf("\t\t\t   ��ѡ������Ҫ�ķ���\n");
		printf("\t\t\t   1.����\n");
		printf("\t\t\t   2.���\n");
		printf("\t\t\t   3.ȡ��\n");
		printf("\t\t\t   4.ת��\n");
		printf("\t\t\t   5.��ѯ���\n");
		printf("\t\t\t   6.�޸�����\n");
		printf("\t\t\t   7.�˳�\n");
		printf("\t\t\t   ����������Ҫ�ķ���");
	 	scanf("%d",&a);
	 	switch(a){
	 		case 1:
	 			kaihu();	
	 			break;
	 		case 2:
	 			cunkuan();	
	 			break;
			case 3:
				qukuan();
				break;
			case 4:
				zhuanzhang();
				break;
			case 5:
				chaxun();
				break;
			case 6:
				xiugai();
				break;
			case 7:
				printf("\t\t\t   �˳��ɹ�����ӭ�´�������\n");
				break;
			default:
				printf("\t\t\t   �������������ѡ��\n");
				break;
	 	}
	 	printf("\t\t\t   �����������");
	 	getch();
	 	system("cls");
	 	}while(a!=7);	
}
//break;return;�˳�����
void kaihu(){
	float mima;
	if(count+1>=N){
		printf("\t\t\t   �û��ѳ���ϵͳ�洢����ȴ���\n");
		return;
	}
		printf("\t\t\t   ����������û���:");
		scanf("%s",&b[count].name);
	 	printf("\t\t\t   ����������˺�:");
	 	scanf("%f",&b[count].zhang);
	 	printf("\t\t\t   �������������:");
	 	scanf("%f",&b[count].mima);
	 	printf("\t\t\t   ��ȷ��������룺");
	 	scanf("%f",&mima);
	 	if(b[count].mima==mima){
	 		printf("\t\t\t   �����ɹ�\n");
	 	}else{
	 		printf("\t\t\t   ��������������벻һ�£�����ʧ�ܡ�\n");
	 		return;
	 	}
	 	printf("\t\t\t   ��������Ŀ�����");
	 	scanf("%f",&b[count].money);
		count++;
}
void cunkuan(){
	float zhang,mima,m;
	int i,j=0;
	printf("\t\t\t   ����������˺ţ�");
	scanf("%f",&zhang);
	printf("\t\t\t   ������������룺");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
		if(b[i].zhang!=zhang||b[i].mima!=mima){
			do{
				printf("\t\t\t   ���������˺���������������\n");//		if(b[i][1]!=zhang||b[i][2]!=mima){printf("\t\t\t   ��������˻����������\n");return;														
				printf("\t\t\t   ��������%d�Σ�����3�Ρ�\n",j+1);
				printf("\t\t\t   ����������˺ţ�");
				scanf("%f",&zhang);
				printf("\t\t\t   ������������룺");
				scanf("%f",&mima);
				if(b[i].zhang==zhang&&b[i].mima==mima){
					break;
				}
				j++;
			}while(j<2);
		}
	    if(b[i].zhang==zhang&&b[i].mima==mima){
	    	printf("\t\t\t   ����û���Ϊ%s,���Ϊ%.2f",b[i].name,b[i].money);
	    	printf("\n");
	    	printf("\t\t\t   ��������Ҫ���Ľ�");
	  		scanf("%f",&m);
	  		b[i].money=b[i].money+m;
	  		printf("\t\t\t   ����˺�Ϊ%s,���Ϊ%.2f,���Ϊ%.2f\n",b[i].name,m,b[i].money);
	  		break;
		}
	}
	if(i>=count){
	printf("\t\t\t   �����û���Ϣ���󣬴��ʧ��\n");
	}
}
void qukuan(){
	float zhang,mima,m;
	int i;
	printf("\t\t\t   ����������˺ţ�");
	scanf("%f",&zhang);
	printf("\t\t\t   ������������룺");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
	    if(b[i].zhang==zhang&&b[i].mima==mima){
	    	printf("\t\t\t   ����û���Ϊ%s,���Ϊ%.2f\n",b[i].name,b[i].money);
	    	printf("\t\t\t   ��������Ҫȡ��Ľ�");
	  		scanf("%f",&m);
	  		if(m<=b[i].money){
	  			b[i].money=b[i].money-m;
	  			printf("\t\t\t   ����˺�Ϊ%s,ȡ��Ϊ%.2f,���Ϊ%.2f\n",b[i].name,m,b[i].money);
	  		}else{
	  			printf("\t\t\t   ���˺����㣬���\n");
	  			break;
	  		}
	  		
		}
	}
	if(i>=count){
		printf("\t\t\t   �����û���Ϣ���󣬴��ʧ��\n");
	}
}	
void zhuanzhang(){
	float zhang,mima,zhang2,m;
	int i,j;
	printf("\t\t\t   ����������˺ţ�");
	scanf("%f",&zhang);
	printf("\t\t\t   ������������룺");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
		if(b[i].zhang==zhang&&b[i].mima==mima){
				printf("\t\t\t   ������Է����˺ţ�");
				scanf("%f",&zhang2);
				for(j=0;j<count;j++){
				if(b[j].zhang==zhang2){
					printf("\t\t\t   ��������ת�˵Ľ�");
					scanf("%f",&m);
					if(m<=b[i].money){
						b[i].mima=b[i].mima-m;
						b[j].mima=b[j].mima-m;
						printf("\t\t\t   ת�˳ɹ���������Ϊ%.2f\n",b[i].mima);
						return;
					}else{
						printf("\t\t\t   ����˻����㣬���ֵ\n");
						break;
					}
				}
			}
			if(i>=count){
				printf("\t\t\t   ������Է����˺�����,ת��ʧ��\n");
				return;
			}
		}
	}
	if(i>=count){
		printf("\t\t\t   �����û���Ϣ����ת��ʧ��\n");
	}
}
void chaxun(){
	float zhang,mima;
	int i;
	printf("\t\t\t   ����������˺ţ�");
	scanf("%f",&zhang);
	printf("\t\t\t   ������������룺");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
		if(b[i].zhang==zhang&&b[i].mima==mima){
			printf("\t\t\t   ����û���Ϊ%s�����Ϊ%.2f\n",b[i].name,b[i].money);
			return;
		}else{
			printf("\t\t\t   ��������˺Ż���������\n");
			return;
		}
	}
	if(i>=count){
		printf("\t\t\t   ��������û���Ϣ�������������롣\n");
	}
}
void xiugai(){
	float zhang,mima,mima2,mima3;
	int i;
	printf("\t\t\t   �����������˺ţ�");
	scanf("%f",&zhang);
	printf("\t\t\t   �������������룺");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
		if(b[i].zhang==zhang&&b[i].mima==mima){
			printf("\t\t\t   �㵱ǰ����Ϊ%.0f\n",b[i].mima);
			printf("\t\t\t   ��������Ҫ�޸ĵ����룺");
			scanf("%f",&mima2);
			printf("\t\t\t   ���ٴ�ȷ��Ҫ�޸ĵ����룺");
			scanf("%f",&mima3);
			if(mima2==mima3){
				b[i].mima=mima2;
				printf("\t\t\t   �޸ĳɹ�����ǰ����Ϊ%.0f��\n",b[i].mima);
				return;
			}else{
				printf("\t\t\t   ������������벻һ�£��޸�ʧ��\n");
				return;
			}
		}else{
			printf("\t\t\t   ����������˺������޸�����ʧ��\n");
			return;
		}
	}
	if(i>=count){
		printf("\t\t\t   ��������û���Ϣ�������������롣\n");
	}
}
