#include "stdio.h"
void main(){
	int a,b,c,d;
	for(a=1000;a<10000;a++){
		b=a/1000%10;
		c=a/100%10;
		d=a/10%10;
		if(a%8==0){
			if(b+c==c+d){
			printf("%d\t",a);
			}
		}
	}
}