#include "stdio.h"
void main(){
	int a,b,c,d=0;
	printf("��������ݣ��·ݣ����ڣ��ո��������");
	scanf("%d %d %d",&a,&b,&c);
	if((a%4==0&&a%100!=0)||a%400==0){
		switch(b){
			case 12://����
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 11:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 10:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 9:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 8:
				if(c>0&&c<=31){
				d+=31;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 7:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("�������");
				break;
				}		
			case 6:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 5:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("�������");
				break;
				}
			case 4:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("�������ڴ���");
				break;
				}		
			case 3:
				if(c>0&&c<=31){
				d+=29;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 2:
				if(c>0&&c<=29){
				d+=30;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 1:
				if(c>0&&c<=31){
				d+=b;
				}else{
				printf("�������ڴ���");
				break;
				}
				printf("��������������%d",d);
				break;
			default:
				printf("�����·�����");
	 	}	
	}else{
			switch(b){
			case 12:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 11:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 10:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 9:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 8:
				if(c>0&&c<=31){
				d+=31;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 7:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("�������ڴ���");
				break;
				}		
			case 6:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 5:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 4:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("�������ڴ���");
				break;
				}		
			case 3:
				if(c>0&&c<=31){
				d+=29;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 2:
				if(c>0&&c<=29){
				d+=30;
				}else{
				printf("�������ڴ���");
				break;
				}
			case 1:
				if(c>0&&c<=31){
				d+=b;
				}else{
				printf("�������ڴ���");
				break;
				}
				printf("��������������%d",d);
				break;
			default:
				printf("�����·�����");
	 	}	

	}

}