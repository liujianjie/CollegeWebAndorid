/* Note:Your choice is C IDE */
#include "stdio.h"
void shoushui(){
	float a,b,c,d;
	printf("��������Ĺ���(��ȷ����λС��)��");
	scanf("%f",&a);
	
	printf("�������㵱�صĸ�˰��㣺");
	scanf("%f",&b);
	
	if(a>=b){
		printf("��Ĺ����ǣ�%.2f\n",a);
		c=a*0.043;
		printf("��ĸ�������˰�ǣ�%.2f\n",c);
		d=a-c;
		printf("���˰�������Ϊ��%.2f\n",d);
	}else{
		printf("˵���ǹ��ʻ��ǲ�Ҫ�Ǻ��أ�");
	
	}
}
void gongsi(){
	int a=1,b=0,c=0;
	while(a<13){
		printf("��%d���µĹ�˾����Ϊ��",a);
		scanf("%d",&b);
		a++;
		c=c+b;
	}
	printf("��˾��������Ϊ��%d",c);
}
void pingfeng(){
	float a[5][9],max,temp;
    int i,j,c=0,k;
    for(i=0;i<5;i++){
    	a[i][6]=0;
     	a[i][7]=10086;
     	a[i][8]=0;
    	printf("ѡ���Ѿ��ݳ���ϣ�����б�Ų��Ҵ��\n");
    	for(j=0;j<6;j++){
    		scanf("%f",&a[i][j]);
    		if(j>0){
    			if(a[i][6]<a[i][j]){
    				a[i][6]=a[i][j];
    			}
    			if(a[i][7]>a[i][j]){
    				a[i][7]=a[i][j];
    			}
    			a[i][8]+=a[i][j];
    		}
    	}
    	a[i][8]=(a[i][8]-a[i][6]-a[i][7])/3;
    }
    printf("ѡ�ֺ�\t��ί1\t��ί2\t��ί3\t��ί4\t��ί5\t��߷�\t��ͷ�\tƽ����\n");
     for(i=0;i<5;i++){
     	printf("%.0f\t",a[i][0]);
     	for(j=1;j<9;j++){
     		printf("%.1f\t",a[i][j]);
     	}
     	printf("\n");
     }
     max=a[0][8];
     for(i=1;i<5;i++){
     	if(max<a[i][8]){
     		max=a[i][8];
     		c=i;	
     	}
     }
     printf("%.0f��ѡ���ǹھ������÷�Ϊ%.1f\n",a[c][0],max);
     printf("����ǰ��\n");
     for(i=0;i<5;i++){
        printf("%.1f\t",a[i][8]);
     }
     printf("\n");
     for(i=0;i<5;i++){
     	for(j=i+1;j<5;j++){ 
     		if(a[i][8]<a[j][8]){
     			for(k=0;k<9;k++){
     				temp=a[i][k];
     				a[i][k]=a[j][k];
     				a[j][k]=temp;
     			}
     		}
     	}
     }
     printf("�����\n");
     for(i=0;i<5;i++){
        printf("%.1f\t",a[i][8]);
     }
     printf("\n");
     printf("ѡ�ֺ�\t��ί1\t��ί2\t��ί3\t��ί4\t��ί5\t��߷�\t��ͷ�\tƽ����\n");
     for(i=0;i<5;i++){
     	printf("%.0f\t",a[i][0]);
     	for(j=1;j<9;j++){
     		printf("%.1f\t",a[i][j]);
     	}
     	printf("\n");
     }
}
void main()
{
	int z;
    printf("\t\t**********************��*************************\n");
	printf("\t\t*                                               *\n");
	printf("\t\t*              ��   ϵͳ�����ȫ                *\n");
	printf("\t\t*                                               *\n");
	printf("\t\t**********************��*************************\n");
	printf("\n\n");
	do{
		printf("\n");
		printf("\t\t\t����������Ҫ�����ϵͳ��\n");
		printf("\t\t\t1.��������˰ϵͳ\n");
		printf("\t\t\t2.��˾����ϵͳ\n");
		printf("\t\t\t3.����OK����ϵͳ\n");
		printf("\t\t\t4.�˳�\n");
		printf("\t\t\t��ѡ��");
		scanf("%d",&z);
	switch(z){
		case 1:
			system("cls");
			shoushui();
			break;
			
		case 2:
			system("cls");
			gongsi();
			break;
		case 3:		
			system("cls");
			pingfeng();
			break;
		case 4:
			printf("\t\t\t�˳��ɹ���");
			break;
		default:
			printf("\t\t\t����������������롣\n");
			
	}
	}while(z!=4);
	
}