/* Note:Your choice is C IDE */
#include "stdio.h"
void studentavg(float a[3][7]);
void avg(float a[3][7]);
void paixu(float a[3][7]);
void main()
{
    /*
    	����3��ѧ��5�ųɼ����ú���ʵ�����¹���
    	1������ÿ��ѧ��ƽ����
    	2������γ�ƽ����
    	3������ÿ��ѧ��ƽ��������
    */
    ///����ѧ���ɼ�
    int i,j;
    float score[3][7];
    for(i=0;i<3;i++){ //ѭ������ѧ��(��)
    	printf("�������%d��ѧ���ĳɼ�",i+1);
    	for(j=0;j<6;j++){ //ѭ�����ǿγ�(��)
    		scanf("%f",&score[i][j]);
    	}
    }
    studentavg(score);
    avg(score);
    paixu(score);
}
//����ѧ����ƽ����
void studentavg(float a[3][7]){
	  int i,j;
	  for(i=0;i<3;i++){ //ѭ������ѧ��(��)
	  	a[i][6]=0; //ÿ��ѧ����ƽ����
		for(j=1;j<6;j++){ //ѭ�����ǿγ�(��)
			a[i][6]+=a[i][j];
		}
		a[i][6]=a[i][6]/5;
	  }
	  printf("ѧ��\t��Ŀ1\t��Ŀ2\t��Ŀ3\t��Ŀ4\t��Ŀ5\tƽ����\n");
	  for(i=0;i<3;i++){
	  	printf("%.0f\t",a[i][0]);
	  	for(j=1;j<7;j++){
	  		printf("%.1f\t",a[i][j]);
	  	}
	  	printf("\n");
	  }
}
//����ÿ����Ŀ��ƽ����
void avg(float a[3][7]){
	  int i,j;
	  float s[5]={0,0,0,0,0};
	  for(i=0;i<3;i++){
		s[0]+=a[i][1];
		s[1]+=a[i][2];
		s[2]+=a[i][3];
		s[3]+=a[i][4];
		s[4]+=a[i][5];
	  }
	  printf("ƽ���֣�%.1f\t%.1f\t%.1f\t\%.1f\t%.1f\n",s[0]/3,s[1]/3,s[2]/3,s[3]/3,s[4]/3);
}
//����ð������
void paixu(float a[3][7]){
	int i,j,k;
	float temp;
	for(i=0;i<2;i++){
		for(j=i+1;j<3;j++){
			if(a[i][6]<a[j][6]){
				for(k=0;k<7;k++){
					temp=a[i][k];
					a[i][k]=a[j][k];
					a[j][k]=temp;	
				}	
			}	
		}	
	}
	printf("�����\n");
	printf("ѧ��\t��Ŀ1\t��Ŀ2\t��Ŀ3\t��Ŀ4\t��Ŀ5\tƽ����\n");
	for(i=0;i<3;i++){
		printf("%.0f\t",a[i][0]);
		for(j=1;j<7;j++){
			printf("%.1f\t",a[i][j]);
		}
		printf("\n");
	}
}
