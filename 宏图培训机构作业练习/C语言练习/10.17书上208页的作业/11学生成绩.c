#include "stdio.h"
int a[11][7],sum=0,sum2,b[5],t,k;
void ping();
void ping2();
void paixu();
void main(){
	int i,j;
	for(i=0;i<10;i++){
		printf("�������%d��ѧ����ѧ�ź�5�ſγ̵ĳɼ���",i+1);
		for(j=0;j<6;j++){
			scanf("%d",&a[i][j]);
		}
	}
	printf("10��ѧ���ķ������\n");
	printf("ѧ����\t����\t��ѧ\tӢ��\t����\t��ѧ\n");
	for(i=0;i<10;i++){
		printf("  %d \t",a[i][0]);
		for(j=1;j<6;j++){
			printf("%d\t",a[i][j]);
		}
		printf("\n");
	}
	ping();
	ping2();
	paixu();
}
void ping(){
	int i,j;
	for(i=0;i<10;i++){// ѭ������ѧ��(��)
	  	a[i][6]=0; //ÿ��ѧ����ƽ����
		for(j=1;j<6;j++){ //ѭ�����ǿγ�(��)
			a[i][6]+=a[i][j];
		}
		a[i][6]=a[i][6]/5;
	  }
	printf("ÿ��ѧ����ƽ���ֱ��\n");
	printf("ѧ����\t����\t��ѧ\tӢ��\t����\t��ѧ\tƽ����\n");
	for(i=0;i<10;i++){
		printf("  %d\t ",a[i][0]);
		for(j=1;j<7;j++){
			printf("%d\t",a[i][j]);
		}
		printf("\n");
	}
}
void ping2(){
	int i,c[5]={0,0,0,0,0};
	for(i=1;i<7;i++){
		c[0]+=a[i][1];
		c[1]+=a[i][2];
		c[2]+=a[i][3];
		c[3]+=a[i][4];
		c[4]+=a[i][5];
		
	}
	printf("ÿ�ſγ̵�ƽ���֣�");
	for(i=0;i<5;i++){
		printf("%d\t",c[i]/5);
	}
}
void paixu(){
	int i,j;
	printf("\n");
	for(i=0;i<9;i++){//9������ ��һ�в���
		for(j=i+1;j<10;j++){//��һ�к���һ������һ�к���һ��
			if(a[i][6]<a[j][6]){//�ȵ�ƽ����
				for(k=0;k<7;k++){//һ��һ���Ļ��»���
					t=a[i][k];
     				a[i][k]=a[j][k];
     				a[j][k]=t;
				}
			}
			
		}	
		
	}
	printf("10��ѧ��������ķ������\n");
	printf("ѧ����\t����\t��ѧ\tӢ��\t����\t��ѧ\tƽ����\n");
     for(i=0;i<10;i++){
     	printf("  %d\t ",a[i][0]);
     	for(j=1;j<7;j++){
     		printf("%d\t",a[i][j]);
     	}
     	printf("\n");
     }	
}