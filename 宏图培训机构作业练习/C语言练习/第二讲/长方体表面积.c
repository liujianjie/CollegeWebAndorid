#include "stdio.h"
void main(){
	float c,k,h,s;
	printf("�����볤 �� �͸�(�ö��Ÿ���)");
	scanf("%f,%f,%f", &c,&k,&h,&s);
	s=(c*k+k*h+c*h)*2;
	printf("������ı����Ϊ%0.2f",s);
	}