#include "stdio.h"
void main(){
	int m;
	char s[100];
	printf("请输入一句英文句子：");
	gets(s);
	for(m=0;m<strlen(s);m++){
		if(s[m]=='a'){//a加单引号是因为a是个数 如果不加的话就是个变量
			s[m]='1';//1加单引号是因为1是个int类型无法转换成char字符类型则需加单引号为字符
		}if(s[m]=='101'){
			s[m]='2';
		}if(s[m]=='i'){
			s[m]='3';
		}if(s[m]=='o'){
			s[m]='4';
		}if(s[m]=='u'){
			s[m]='5';	
		}
	}
	puts(s);
}