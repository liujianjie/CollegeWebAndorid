/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 50  //����һ������
float bank[N][4];
int count=0;
//��������
//����
void kaihu();
//���
void cunkuan();
//ȡ��
void qukuan();
//ת��
void zhuanzhang();
//��ѯ���
void chaxun();
//�޸�����
void xiugai();
void main()
{
	int n;
	do{
		printf("\t\t**********************��*************************\n");
		printf("\t\t*                                               *\n");
		printf("\t\t*                                               *\n");
		printf("\t\t*          ��   ��ӭ�����й�����                *\n");
		printf("\t\t*                                               *\n");
		printf("\t\t*                                               *\n");
		printf("\t\t**********************��*************************\n");
	 	printf("\t\t��ѡ����Ҫ�����ҵ��\n"); 
		printf("\t\t\t1������\n"); 
		printf("\t\t\t2�����\n"); 
		printf("\t\t\t3��ȡ��\n"); 
		printf("\t\t\t4��ת��\n"); 
		printf("\t\t\t5����ѯ���\n");
		printf("\t\t\t6���޸�����\n");
		printf("\t\t\t7���˳�\n");
		scanf("%d",&n);
		if(n==7){
			break;
		}
		switch(n){
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
			default:
				printf("��������������1-7֮�������");
				break;
		}
		printf("\t\t�����������");
		getch();//��ͣ
		system("cls");
	}while(n!=7);
}
//����
void kaihu(){
	float psw;
	if(count+1>=N){
		printf("\t\t���������Ѿ��ﵽϵͳ���ޣ���ȴ�...");
		return ;
	}
	printf("\t\t\t�����뿪�����ƣ�");
	scanf("%f",&bank[count][0]);
	printf("\t\t\t�������ʺţ�");
	scanf("%f",&bank[count][1]);
	printf("\t\t\t���������룺");
	scanf("%f",&bank[count][2]);
	printf("\t\t\t��ȷ�����룺");
	scanf("%f",&psw);
	if(psw!=bank[count][2]){
		printf("\t\t\t�����������벻һ�£�����ʧ�ܣ�\n");	
		return ;
	}
	printf("\t\t\t�����뿪����");
	scanf("%f",&bank[count][3]);
	count++;
}
//���
void cunkuan(){
	float zh,psw,money;
	int i;
	printf("\t\t�����������ʺ�:");
	scanf("%f",&zh);
	printf("\t\t����������:");
	scanf("%f",&psw);
	for(i=0;i<count;i++){
		if(bank[i][1]==zh && bank[i][2]==psw){
			printf("\t\t��������Ϊ:%.0f,���Ϊ:%.2f\n",bank[i][0],bank[i][3]);	
			printf("\t\t���������");
			scanf("%f",&money);			
			bank[i][3]=bank[i][3]+money;
			printf("\t\t���ɹ������Ĵ����Ϊ��%.2f,���Ϊ��%.2f\n",money,bank[i][3]);
			break;
		}	
	}
	if(i>=count){
		printf("\t\t�����û���Ϣ������ȷ�������˻���Ϣ!\n");	
	}
}
//ȡ��
void qukuan(){
	float zh,psw,money;
	int i;
	printf("\t\t�����������ʺ�:");
	scanf("%f",&zh);
	printf("\t\t����������:");
	scanf("%f",&psw);
	for(i=0;i<count;i++){
		if(bank[i][1]==zh && bank[i][2]==psw){
			printf("\t\t��������Ϊ:%.0f,���Ϊ:%.2f\n",bank[i][0],bank[i][3]);	
			printf("\t\t������ȡ���");
			scanf("%f",&money);
			if(bank[i][3]<money){
				printf("\t\t�˻����㣡");	
			}else{
				bank[i][3]=bank[i][3]-money;
				printf("\t\tȡ��ɹ�������ȡ����Ϊ��%.2f,���Ϊ��%.2f\n",money,bank[i][3]);
			}
			break;
		}	
	}
	if(i>=count){
		printf("\t\t�����û���Ϣ������ȷ�������˻���Ϣ!\n");	
	}
}
//ת��
void zhuanzhang(){
	float zh,psw,money,zh2;
	int i,j;
	printf("\t\t�����������ʺ�:");
	scanf("%f",&zh);
	printf("\t\t����������:");
	scanf("%f",&psw);
	for(i=0;i<count;i++){
		if(bank[i][1]==zh && bank[i][2]==psw){
			printf("\t\t�û�����Ϊ:%.0f,���Ϊ:%.2f\n",bank[i][0],bank[i][3]);	
			printf("\t\t��������Ҫת�����ʺţ�");
			scanf("%f",&zh2);
			for(j=0;j<count;j++){
				if(bank[j][1]==zh2){
					printf("\t\t������ת�˽��:");
					scanf("%f",&money);	
					if(bank[i][3]<money){
						printf("\t\t���㣬ת��ʧ�ܣ�");
					}else{
						//�Լ��ʺſ�Ǯ
						bank[i][3]=bank[i][3]-money;
						//ת���ʺż�Ǯ
						bank[j][3]+=money;
						printf("\t\tת�˳ɹ�������ת�˽��Ϊ��%.2f,���Ϊ��%.2f \n",money,bank[i][3]);
					}
					break;
				}
			}
			if(j>=count){
				printf("\t\tת���ʺŲ�����!\n");	
			}
			break;
		}	
	}
	if(i>=count){
		printf("\t\t�����û���Ϣ������ȷ�������˻���Ϣ!\n");	
	}
}
//��ѯ���
void chaxun(){
	float zh,psw;
	int i;
	printf("\t\t��������Ҫ���ҵ��ʺ�:");
	scanf("%f",&zh);
	printf("\t\t����������:");
	scanf("%f",&psw);
	for(i=0;i<count;i++){
		if(bank[i][1]==zh && bank[i][2]==psw){
			printf("\t\t��������Ϊ:%.0f,���Ϊ:%.2f\n",bank[i][0],bank[i][3]);	
			break;
		}	
	}
	if(i>=count){
		printf("\t\t��Ҫ���ҵ��û������ڣ���ȷ�������˻���Ϣ!\n");	
	}
}
//�޸�����
void xiugai(){
	float zh,psw,psw2,psw3;
	int i;
	printf("\t\t�����������ʺ�:");
	scanf("%f",&zh);
	printf("\t\t����������:");
	scanf("%f",&psw);
	for(i=0;i<count;i++){
		if(bank[i][1]==zh && bank[i][2]==psw){
			printf("\t\t�����������룺");
			scanf("%f",&psw2);
			printf("\t\t��ȷ�����룺");
			scanf("%f",&psw3);
			if(psw2==psw3){
				bank[i][2]=psw2;
				printf("\t\t�����޸ĳɹ�,�޸ĺ������Ϊ%.0f,�����Ʊ���!\n",bank[i][2]);
			}else{
				printf("\t\t��������������벻һ�£�\n");
			}
			break;
		}	
	}
	if(i>=count){
		printf("\t\t�����û���Ϣ������ȷ�������˻���Ϣ!\n");	
	}
}