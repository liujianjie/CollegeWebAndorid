/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 50
struct bank{
	char name[20];
	char zhang[16];
	char mima[6];	
	float money;
}b[N];
int count=0;//ȫ�ֱ���
void kaihu();
void cunkuan();
void qukuan();
void zhuanzhang();
void chaxun();
void xiugai();
int jian();//�޲����з�ֵ
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
	char psw2[6];
	if(count+1>=N){
		printf("\t\t\t   �û��ѳ���ϵͳ�洢����ȴ���\n");
		return;
	}
		printf("\t\t\t   ����������û���:");
		scanf("%s",&b[count].name);
	 	printf("\t\t\t   ����������˺�:");
	 	scanf("%s",&b[count].zhang);
	 	printf("\t\t\t   �������������:");
	 	scanf("%s",&b[count].mima);
	 	printf("\t\t\t   ��ȷ��������룺");
	 	scanf("%s",&psw2);
	 	if(strcmp(b[count].mima,psw2)==0){
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
	float m;
	int i;
	i=jian();
	    if(i!=-1){
	    	printf("\t\t\t   ����û���Ϊ%s,���Ϊ%.2f",b[i].name,b[i].money);
	    	printf("\n");
	    	printf("\t\t\t   ��������Ҫ���Ľ�");
	  		scanf("%f",&m);
	  		b[i].money=b[i].money+m;
	  		printf("\t\t\t   ����˺�Ϊ%s,���Ϊ%.2f,���Ϊ%.2f\n",b[i].name,m,b[i].money);

		}
}
void qukuan(){
	float m;
	int i;
	i=jian();
	    if(i!=-1){
	    	printf("\t\t\t   ����û���Ϊ%s,���Ϊ%.2f\n",b[i].name,b[i].money);
	    	printf("\t\t\t   ��������Ҫȡ��Ľ�");
	  		scanf("%f",&m);
	  		if(m<=b[i].money){
	  			b[i].money=b[i].money-m;
	  			printf("\t\t\t   ����˺�Ϊ%s,ȡ��Ϊ%.2f,���Ϊ%.2f\n",b[i].name,m,b[i].money);
	  		}else{
	  			printf("\t\t\t   ���˺����㣬���\n");
	  		}
	  		
		}
}	
void zhuanzhang(){
	char zhang2[16];
	float m;
	int i,j;
	i=jian();
		if(i!=-1){
				printf("\t\t\t   ������Է����˺ţ�");
				scanf("%s",&zhang2);
				for(j=0;j<count;j++){
				if(strcmp(zhang2,b[j].zhang)==0){
					printf("\t\t\t   ��������ת�˵Ľ�");
					scanf("%f",&m);
					if(m<=b[i].money){
						b[i].money=b[i].money-m;
						b[j].money=b[j].money+m;
						printf("\t\t\t   ת�˳ɹ���������Ϊ%.2f\n",b[i].money);
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
void chaxun(){
	int i;
	i=jian();
		if(i!=-1){
			printf("\t\t\t   ����û���Ϊ%s�����Ϊ%.2f\n",b[i].name,b[i].money);
		}
}
void xiugai(){
	char mima2[6],mima3[6];
	int i;
	i=jian();
		if(i!=-1){
			printf("\t\t\t   �㵱ǰ����Ϊ%s\n",b[i].mima);
			printf("\t\t\t   ��������Ҫ�޸ĵ����룺");
			scanf("%s",&mima2);
			printf("\t\t\t   ���ٴ�ȷ��Ҫ�޸ĵ����룺");
			scanf("%s",&mima3);
			if(strcmp(mima3,b[i].mima)==0){
				strcpy(b[i].mima,mima3);
				printf("\t\t\t   �޸ĳɹ�����ǰ����Ϊ%s��\n",b[i].mima);
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
int jian(){
	char zhang[16],psw[16];
	int i;
	printf("\t\t\t   ����������˺ţ�");
	scanf("%s",&zhang);
	printf("\t\t\t   ������������룺");
	scanf("%s",&psw);
	for(i=0;i<count;i++){
		if(strcmp(zhang,b[i].zhang)==0 && strcmp(psw,b[i].mima)==0){
			return i;
		}
	}
	if(i>=count){
			printf("\t\t��Ҫ���ҵ��û������ڣ���ȷ�������˻���Ϣ!\n");
			return -1;		
	}
}
	
