#include "stdio.h"
void main(){
	int a,b,c=0;
	for(a=1;a<=1000;a++){
		c=0;//���¸�ֵ
		for(b=1;b<a;b++){
			if(a%b==0){//��������
				c+=b;
			}
		}
		if(a==c){
			printf("%d\t",a);
		}
	}
}