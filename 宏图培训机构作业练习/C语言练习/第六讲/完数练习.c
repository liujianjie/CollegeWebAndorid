#include "stdio.h"
void main(){
	int a,b,c=0;
	for(a=1;a<=1000;a++){//����Ҫ�ҵ������ķ�Χ
		c=0;//Ҫ��ʼc ����������
		for(b=1;b<a;b++){//��������֮��
			if(a%b==0){ //�ж�j�Ƿ�Ϊi������
				c+=b;
			}	
		}
		if(a==c){
		printf("%d\n",a);
		}
	}
}