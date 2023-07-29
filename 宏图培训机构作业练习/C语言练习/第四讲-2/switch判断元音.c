#include "stdio.h"
void main(){
	char d;
	printf("请输入字母：");
	scanf("%c",&d);
	switch(d){
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			printf("这个字母是元音");
			break;
		default:
		printf("这个字母是辅音");
		

		
		}
	
	}