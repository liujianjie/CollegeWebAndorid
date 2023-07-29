#include "stdio.h"
void main(){
	int a,b=0;
	printf("1900到2010的闰年年份有:\n");
	for(a=1900;a<=2010;a++){
		if((a%4==0&&a%100!=0)||a%400==0){ 
			printf("%d\t\t",a);
			b++;

			}

		}	printf("闰年共有：%d个",b);

	}