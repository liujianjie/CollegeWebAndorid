#include "stdio.h"
void main(){
	int a;
	printf("��������ķ�����");
	scanf("%d",&a);
	if(a>=90&&a<=100){
		printf("����ô�� ˵�ǲ��ǳ���");
		
	}else if(60<=a&&a<90){
		printf("�ܿ�����������");
	
	}else if(a>=0&&a<60){
		printf("�����������Ҫ�����Ͳ��ܵ�");
	}else if(a<0){
		printf("��ʦ���������˰ɣ�");
	}else {
		printf("���׶�û�㼼������");
		}
	
	
	
	
	
	}