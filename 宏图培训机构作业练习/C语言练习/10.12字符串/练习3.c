#include "stdio.h"
void main(){
	int m;
	char s[100];
	printf("������һ��Ӣ�ľ��ӣ�");
	gets(s);
	for(m=0;m<strlen(s);m++){
		if(s[m]=='a'){//a�ӵ���������Ϊa�Ǹ��� ������ӵĻ����Ǹ�����
			s[m]='1';//1�ӵ���������Ϊ1�Ǹ�int�����޷�ת����char�ַ���������ӵ�����Ϊ�ַ�
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