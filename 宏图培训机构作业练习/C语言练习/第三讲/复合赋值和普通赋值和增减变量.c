#include "stdio.h"
void main(){
	int a=2,b=4,c,d;
	a+=5;
	b++;
	c=++b;
	d=b++;
	printf("%d,%d,%d,%d",a,b,c,d);
	
	}