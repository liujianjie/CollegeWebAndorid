#include "stdio.h"
void main(){
	float a,b,c=0,max=0,min=200000003;
	for(a=1;a<6;a++){
		printf("�������%.0fλͬѧ�ɼ���",a);
		scanf("%f",&b);
		c+=b;
		if(max<=b){
			max=b;
		}
		if(min>=b){
			min=b;
		}
	}
	printf("�������������%.0f\n",max);
	printf("���������С����%.0f\n",min);
	printf("�������ƽ�����ǣ�%.2f\n",c/5);
}