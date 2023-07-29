#include "stdio.h"
void main(){
	int a,b,c;
	for(a=100;a<=200;a++){
		c=0;
		for(b=2;b<a;b++){
			if(a%b==0){
				c=1;
				break;
			}
		}
		if(c==0){
			printf("%d\t",a);
		}
	}
}