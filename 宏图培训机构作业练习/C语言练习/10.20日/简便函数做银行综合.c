/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 50
float b[N][4];
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
	float mima;
	if(count+1>=N){
		printf("\t\t\t   �û��ѳ���ϵͳ�洢����ȴ���\n");
		return;
	}
		printf("\t\t\t   ����������û���:");
		scanf("%f",&b[count][0]);
	 	printf("\t\t\t   ����������˺�:");
	 	scanf("%f",&b[count][1]);
	 	printf("\t\t\t   �������������:");
	 	scanf("%f",&b[count][2]);
	 	printf("\t\t\t   ��ȷ��������룺");
	 	scanf("%f",&mima);
	 	if(b[count][2]==mima){
	 		printf("\t\t\t   �����ɹ�\n");
	 	}else{
	 		printf("\t\t\t   ��������������벻һ�£�����ʧ�ܡ�\n");
	 		return;
	 	}
	 	printf("\t\t\t   ��������Ŀ�����");
	 	scanf("%f",&b[count][3]);
		count++;
}
void cunkuan(){
	float m;
	int i;
	i=jian();
	    if(i!=-1){
	    	printf("\t\t\t   ����û���Ϊ%.0f,���Ϊ%.2f",b[i][0],b[i][3]);
	    	printf("\n");
	    	printf("\t\t\t   ��������Ҫ���Ľ�");
	  		scanf("%f",&m);
	  		b[i][3]=b[i][3]+m;
	  		printf("\t\t\t   ����˺�Ϊ%.0f,���Ϊ%.2f,���Ϊ%.2f\n",b[i][0],m,b[i][3]);

		}
}
void qukuan(){
	float m;
	int i;
	i=jian();
	    if(i!=-1){
	    	printf("\t\t\t   ����û���Ϊ%.0f,���Ϊ%.2f\n",b[i][0],b[i][3]);
	    	printf("\t\t\t   ��������Ҫȡ��Ľ�");
	  		scanf("%f",&m);
	  		if(m<=b[i][3]){
	  			b[i][3]=b[i][3]-m;
	  			printf("\t\t\t   ����˺�Ϊ%.0f,ȡ��Ϊ%.2f,���Ϊ%.2f\n",b[i][0],m,b[i][3]);
	  		}else{
	  			printf("\t\t\t   ���˺����㣬���\n");
	  		}
	  		
		}
}	
void zhuanzhang(){
	float zhang2,m;
	int i,j;
	i=jian();
		if(i!=-1){
				printf("\t\t\t   ������Է����˺ţ�");
				scanf("%f",&zhang2);
				for(j=0;j<count;j++){
				if(b[j][1]==zhang2){
					printf("\t\t\t   ��������ת�˵Ľ�");
					scanf("%f",&m);
					if(m<=b[i][3]){
						b[i][3]=b[i][3]-m;
						b[j][3]=b[j][3]+m;
						printf("\t\t\t   ת�˳ɹ���������Ϊ%.2f\n",b[i][3]);
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
			printf("\t\t\t   ����û���Ϊ%.2f�����Ϊ%.2f\n",b[i][0],b[i][3]);
			return;
		}
}
void xiugai(){
	float mima2,mima3;
	int i;
	i=jian();
		if(i!=-1){
			printf("\t\t\t   �㵱ǰ����Ϊ%.0f\n",b[i][2]);
			printf("\t\t\t   ��������Ҫ�޸ĵ����룺");
			scanf("%f",&mima2);
			printf("\t\t\t   ���ٴ�ȷ��Ҫ�޸ĵ����룺");
			scanf("%f",&mima3);
			if(mima2==mima3){
				b[i][2]=mima2;
				printf("\t\t\t   �޸ĳɹ�����ǰ����Ϊ%.0f��\n",b[i][2]);
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
	float zhang,mima;
	int i;
	printf("\t\t\t   ����������˺ţ�");
	scanf("%f",&zhang);
	printf("\t\t\t   ������������룺");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
		if(b[i][1]==zhang&&b[i][2]==mima){
			return i;
		}
	}
	if(i>=count){
			printf("\t\t��Ҫ���ҵ��û������ڣ���ȷ�������˻���Ϣ!\n");
			return -1;		
	}
}
	
