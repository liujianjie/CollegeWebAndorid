#include "stdio.h"
void main(){
	int a,b,c,d;
	for(a=100;a<1000;a++){
		b=a/100%10;
		c=a/10%10;
		d=a/1%10;
		if(a==b*b*b+c*c*c+d*d*d){
			printf("%d\n",a);
		}
	}	
}