/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 5
struct bank{
	char name[20];
	char zhang[18];
	char mima[6];
	float money;
}b[N];
int count=0;
void kaihu();
void cunkuan();
void qukuan();
void zhuanzhang();
void chaxun();
void xiugai();
int jian();
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
void kaihu(){
	char mima2[6];
	if(count+1>=N){
		printf("\t\t\t   ϵͳ�Ŀ����Ѵ����ߣ���ȴ���\n");
	}else{
		printf("\t\t\t   ��������Ŀ������ƣ�");
		scanf("%s",&b[count].name);
		printf("\t\t\t   ��������Ŀ����˺ţ�");
		scanf("%s",&b[count].zhang);
		printf("\t\t\t   ��������Ŀ������룺");
		scanf("%s",&b[count].mima);
		printf("\t\t\t   ��ȷ��������룺");
		scanf("%s",&mima2);
		if(strcmp(b[count].mima,mima2)==0){
			printf("\t\t\t   �����ɹ���\n");			
		}else{
			printf("\t\t\t   �������벻һ�£�����ʧ�ܡ�");
			return;
		}
		printf("\t\t\t   �����뿪�����");
		scanf("%f",&b[count].money);
		count++;
	}
}
void cunkuan(){
	float m;
	int i;
	i=jian();
	if(i!=-1){
		printf("\t\t\t   ��������Ҫ���Ľ��\n");
		scanf("%f",&m);
		b[i].money=b[i].money+m;
		printf("\t\t\t   ����û��ǣ�%s,���Ϊ��%.2f\n",b[i].name,b[i].money);
	}
}
void qukuan(){
	float m;
	int i;
	i=jian();
	if(i!=-1){
		printf("\t\t\t   ��������Ҫȡ��Ľ��\n");
		scanf("%f",&m);
		b[i].money=b[i].money-m;
		printf("\t\t\t   ����û��ǣ�%s,���Ϊ��%.2f\n",b[i].name,b[i].money);
	}
}
void zhuanzhang(){
	char zhang[16];
	int i,j;
	float m;
	i=jian();
	if(i!=-1){
		printf("\t\t\t   ��������Ҫת�˵��˺ţ�");
		scanf("%s",&zhang);
		for(j=0;j<count;j++){
			if(strcmp(b[j].zhang,zhang)==0){
				printf("\t\t\t   ��������Ҫת�˵Ľ�");
				scanf("%s",&m);
				if(m<b[i].money){
					b[i].money=b[i].money-m;
					b[j].money=b[j].money-m;
					printf("\t\t\t   ����û�Ϊ��%s,������Ϊ��%.2f",b[i].name,b[i].money);
				}else{
					printf("\t\t\t   ������㣬���������롣");
					return;
				}
			}
		}
		if(i>=count){
			printf("\t\t\t   ���������Ϣ�������������롣\n");	
		}
	}
}
void chaxun(){
	int i;
	i=jian();
	if(i!=-1){
	printf("\t\t\t   ����û��ǣ�%s,���Ϊ��%f",b[i].name,b[i].money);	
	}
}
void xiugai(){
	char mima2[6],mima3[6];
	int i;
	i=jian();
	if(i!=-1){
		printf("\t\t\t   ��������������룺");
		scanf("%s",&mima2);
		printf("\t\t\t   ��ȷ��������룺");
		scanf("%s",&mima3);
		if(strcmp(mima3,mima2)==0){
			strcmp(b[i].mima,mima3);
			printf("\t\t\t   ����������ǣ�%s\n",b[i].mima);
		}else{
			printf("\t\t\t   �������벻һ�£��޸�����ʧ�ܣ�������ѡ��\n");
			return;
		}		
	}
}
int jian(){
	int i;
	char zhang[16],mima2[6];
	printf("\t\t\t   ����������˺ţ�");
	scanf("%s",&zhang);
	printf("\t\t\t   ������������룺");
	scanf("%s",&mima2);
	for(i=0;i<count;i++){
		if(strcmp(mima2,b[i].mima)==0&&strcmp(zhang,b[i].zhang)==0){
			return i;
		}
	}
	if(i>=count){
		printf("\t\t\t   ��������û���Ϣ����������ѡ��\n");	
		return -1;
	}
}