/* Note:Your choice is C IDE */
#include "stdio.h"
//����������
//�۰����
void find();
//����ok����ϵͳ
void ok();
//��ӡ����
void prt();
void main()
{
    /*
    	�����ȫ  1���۰����
    			  2������ok����ϵͳ
    			  3����ӡ����
    			  4���˳�
 	*/
 	int n;
	do{
		printf("\t\t**************************************\n"); 
 		printf("\t\t		ϵͳ�����ȫ\n"); 
 		printf("\t\t**************************************\n"); 
	 	printf("\t\t**************************************\n"); 
	 	printf("\t\t��ѡ����Ҫ�����ϵͳ��\n"); 
		printf("\t\t\t1���۰����\n"); 
		printf("\t\t\t2����ӡ����\n"); 
		printf("\t\t\t3����ͼ�İ��������������ϵͳ\n"); 
		printf("\t\t\t4���˳�\n"); 
		scanf("%d",&n);
		if(n==4){
			break;
		}
		switch(n){
			case 1:
				find();
				break;
			case 2:
				prt();
				break; 
			case 3:
				ok();
				break;
			case 4:
				break;
			default:
				printf("��������������1-4֮�������");
				break;
		}
		printf("\t\t�����������");
		getch();//��ͣ
		system("cls");
	}while(n!=4);
 	//find();
 	//prt();
 	//ok();
}
void find(){
	/*
		�۰���ң�
			1�������ж��ٸ�Ԫ�أ�����ĳ��ȣ�
			2��������������ͽ���
	*/
	int a[10]={10,9,8,7,6,5,4,3,2,1};
	int left=0,right=9,mid,num,c=0;
	printf("��������Ҫ���ҵ�����");
	scanf("%d",&num);
	while(left<=right){
		mid=(left+right)/2;//�������ֳ�������
		//����м�����Ҫ���ҵ���С���ұ������������
		if(a[mid]<num){
			right=mid-1;
		}	
		//����м�����Ҫ���ҵ�������ߵ�����������
		if(a[mid]>num){
			left=mid+1;
		}
		//�ҵ������������
		if(a[mid]==num){
			printf("���ڵ�%d��λ���ҵ���%d\n",mid+1,num);	 
			c=1;
			break;	
		}	
	}
	if(c==0){
		printf("���ź�����Ҫ���ҵ��������ڣ�\n");
	}
}

void prt(){
/*
	*
   ***	
  *****
 *******
  *****
   ***
    *
	1�������͵����ַ���
	2��ÿһ�е�*��=�к�*2-1
	3���ո���=���ַ���-�Ǻ�����/2
*/	
	int line,star,space,i,j,mid;
	printf("��������Ҫ��ӡ���ε�������");
	scanf("%d",&line);
	mid=line/2+1;
	//�ϰ벿��
	for(i=1;i<=mid;i++){  //ѭ����
		star=i*2-1;
		//��ӡ�ո�
		space=(line-star)/2;
		for(j=1;j<=space;j++){
			printf(" ");
		}
		//��ӡ�Ǻ�
		for(j=1;j<=star;j++){
			printf("*");
		}
		printf("\n");
	}
	//��ӡ�°벿��
	for(i=mid-1;i>0;i--){  //ѭ����
		star=i*2-1;
		//��ӡ�ո�
		space=(line-star)/2;
		for(j=1;j<=space;j++){
			printf(" ");
		}
		//��ӡ�Ǻ�
		for(j=1;j<=star;j++){
			printf("*");
		}
		printf("\n");
	}
}
//��ͼ4���������������ϵͳ
void ok(){
	/*
		5��ѡ�֣�5�����У�ȥ����߷֣�ȥ����ͷ֣���ƽ����
		1���ҹھ�
		2������
	*/
	float a[5][9],temp,max;
	int i,j,k,c=0;
	//����
	for(i=0;i<5;i++){ //ѭ��ѡ�� 
		a[i][6]=0; 	    //��߷�
		a[i][7]=100;	//��ͷ�
		a[i][8]=0;	    //ƽ����
		printf("����ί����ѡ�ֺźͷ�����");
		for(j=0;j<6;j++){ //ѭ�����У��������룩
			scanf("%f",&a[i][j]);
			if(j>0){
				//ÿһλ���и�����߷�
				if(a[i][6]<a[i][j]){
					a[i][6]=a[i][j];
				}
				//ÿһλ���и�����ͷ�
				if(a[i][7]>a[i][j]){
					a[i][7]=a[i][j];
				}
				a[i][8]+=a[i][j];
			}
		}
		//��ѡ�ֵ�ƽ����
		a[i][8]=(a[i][8]-a[i][6]-a[i][7])/3;
	}
	//���
	printf("ѡ�ֺ�\t��ί1\t��ί2\t��ί3\t��ί4\t��ί5\t��߷�\t��ͷ�\tƽ����\n");
	for(i=0;i<5;i++){
		printf("%.0f\t",a[i][0]);
		for(j=1;j<9;j++){
			printf("%.1f\t",a[i][j]);
		}
		printf("\n");
	}
	//�ҹھ�
	max=a[0][8];
	for(i=1;i<5;i++){
		if(max<a[i][8]){
			max=a[i][8];
			c=i;	
		}	
	}
	printf("�ھ��ǵ�%.0f��ѡ�֣����÷���%.1lf\n",a[c][0],max);
	//����(ð������)
	for(i=0;i<4;i++){
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
	printf("ѡ�ֺ�\t��ί1\t��ί2\t��ί3\t��ί4\t��ί5\t��߷�\t��ͷ�\tƽ����\n");
	for(i=0;i<5;i++){
		printf("%.0f\t",a[i][0]);
		for(j=1;j<9;j++){
			printf("%.1f\t",a[i][j]);
		}
		printf("\n");
	}
}