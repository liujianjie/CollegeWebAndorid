#include "stdio.h"
void main(){
	int a[30],i,j=0;
	float l,sum=0;
	printf("������30��c����ͬѧ�ĳɼ�(�ո����)��\n");
	for(i=0;i<30;i++){
		scanf("%d",&a[i]);
		sum+=a[i];
		if(a[i]>=60){
			j++;
		}
		
	}
	printf("�����ļ�������Ϊ��%d",j);
	l=j/30.0*100;
	printf("������ƽ���ɼ�Ϊ��%.2f,������Ϊ��%.2f%%",sum/30,l);
	
}