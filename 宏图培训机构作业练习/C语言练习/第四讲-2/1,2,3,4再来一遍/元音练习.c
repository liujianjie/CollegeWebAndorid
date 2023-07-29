#include "stdio.h"
void main(){
	char c;
	printf("请输入一个字母：");
	scanf("%c",&c);
	switch(c){
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			printf("这个数是元音");
		break;
		default:
			printf("这个数是辅音");
		}
	
	
	}