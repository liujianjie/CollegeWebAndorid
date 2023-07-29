#include "stdio.h"
void main(){
	int a,b,c,d=0;
	printf("请输入年份，月份，日期（空格隔开）：");
	scanf("%d %d %d",&a,&b,&c);
	if((a%4==0&&a%100!=0)||a%400==0){
		switch(b){
			case 12://错了
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("输入日期错误");
				break;
				}
			case 11:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("输入日期错误");
				break;
				}
			case 10:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("输入日期错误");
				break;
				}
			case 9:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("输入日期错误");
				break;
				}
			case 8:
				if(c>0&&c<=31){
				d+=31;
				}else{
				printf("输入日期错误");
				break;
				}
			case 7:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("输入错误");
				break;
				}		
			case 6:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("输入日期错误");
				break;
				}
			case 5:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("输入错误");
				break;
				}
			case 4:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("输入日期错误");
				break;
				}		
			case 3:
				if(c>0&&c<=31){
				d+=29;
				}else{
				printf("输入日期错误");
				break;
				}
			case 2:
				if(c>0&&c<=29){
				d+=30;
				}else{
				printf("输入日期错误");
				break;
				}
			case 1:
				if(c>0&&c<=31){
				d+=b;
				}else{
				printf("输入日期错误");
				break;
				}
				printf("这是闰年天数是%d",d);
				break;
			default:
				printf("输入月份有误");
	 	}	
	}else{
			switch(b){
			case 12:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("输入日期错误");
				break;
				}
			case 11:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("输入日期错误");
				break;
				}
			case 10:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("输入日期错误");
				break;
				}
			case 9:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("输入日期错误");
				break;
				}
			case 8:
				if(c>0&&c<=31){
				d+=31;
				}else{
				printf("输入日期错误");
				break;
				}
			case 7:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("输入日期错误");
				break;
				}		
			case 6:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("输入日期错误");
				break;
				}
			case 5:
				if(c>0&&c<=31){
				d+=30;
				}else{
				printf("输入日期错误");
				break;
				}
			case 4:
				if(c>0&&c<=30){
				d+=31;
				}else{
				printf("输入日期错误");
				break;
				}		
			case 3:
				if(c>0&&c<=31){
				d+=29;
				}else{
				printf("输入日期错误");
				break;
				}
			case 2:
				if(c>0&&c<=29){
				d+=30;
				}else{
				printf("输入日期错误");
				break;
				}
			case 1:
				if(c>0&&c<=31){
				d+=b;
				}else{
				printf("输入日期错误");
				break;
				}
				printf("这是闰年天数是%d",d);
				break;
			default:
				printf("输入月份有误");
	 	}	

	}

}