#include "stdio.h"
void main(){
		float r,v;
		printf("请输入球体的半径");
		scanf("%f",&r);
		v=3.14*4/3.0*r*r*r;
		printf("球体的体积为%.2f",v);
	}
