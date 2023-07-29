/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 5
struct bank{
	char name[20];
	char zhang[18];
	char mima[6];
	float money;
}b[N];
int count=0;
void kaihu();
void cunkuan();
void qukuan();
void zhuanzhang();
void chaxun();
void xiugai();
int jian();
void main()
{
		int a;
		do{
		printf("\t*************************************************************\n");                   
		printf("\t*                                                           *\n");
		printf("\t*                     欢迎来到天朝银行                      *\n");
		printf("\t*                                                           *\n");                               
		printf("\t*                                                           *\n");              
		printf("\t*************************************************************\n");
		printf("\n");
		printf("\n");
		printf("\t\t\t   请选择你需要的服务\n");
		printf("\t\t\t   1.开户\n");
		printf("\t\t\t   2.存款\n");
		printf("\t\t\t   3.取款\n");
		printf("\t\t\t   4.转账\n");
		printf("\t\t\t   5.查询余额\n");
		printf("\t\t\t   6.修改密码\n");
		printf("\t\t\t   7.退出\n");
		printf("\t\t\t   请输入你需要的服务：");
	 	scanf("%d",&a);
	 	switch(a){
	 		case 1:
	 			kaihu();	
	 			break;
	 		case 2:
	 			cunkuan();	
	 			break;
			case 3:
				qukuan();
				break;
			case 4:
				zhuanzhang();
				break;
			case 5:
				chaxun();
				break;
			case 6:
				xiugai();
				break;
			case 7:
				printf("\t\t\t   退出成功，欢迎下次再来。\n");
				break;
			default:
				printf("\t\t\t   输入错误，请重新选择。\n");
				break;
	 	}
	 	printf("\t\t\t   按任意键继续");
	 	getch();
	 	system("cls");
	 	}while(a!=7);	
}
void kaihu(){
	char mima2[6];
	if(count+1>=N){
		printf("\t\t\t   系统的开户已达上线，请等待。\n");
	}else{
		printf("\t\t\t   请输入你的开户名称：");
		scanf("%s",&b[count].name);
		printf("\t\t\t   请输入你的开户账号：");
		scanf("%s",&b[count].zhang);
		printf("\t\t\t   请输入你的开户密码：");
		scanf("%s",&b[count].mima);
		printf("\t\t\t   请确认你的密码：");
		scanf("%s",&mima2);
		if(strcmp(b[count].mima,mima2)==0){
			printf("\t\t\t   开户成功！\n");			
		}else{
			printf("\t\t\t   两次密码不一致，开户失败。");
			return;
		}
		printf("\t\t\t   请输入开户金额");
		scanf("%f",&b[count].money);
		count++;
	}
}
void cunkuan(){
	float m;
	int i;
	i=jian();
	if(i!=-1){
		printf("\t\t\t   请输入你要存款的金额\n");
		scanf("%f",&m);
		b[i].money=b[i].money+m;
		printf("\t\t\t   你的用户是：%s,余额为：%.2f\n",b[i].name,b[i].money);
	}
}
void qukuan(){
	float m;
	int i;
	i=jian();
	if(i!=-1){
		printf("\t\t\t   请输入你要取款的金额\n");
		scanf("%f",&m);
		b[i].money=b[i].money-m;
		printf("\t\t\t   你的用户是：%s,余额为：%.2f\n",b[i].name,b[i].money);
	}
}
void zhuanzhang(){
	char zhang[16];
	int i,j;
	float m;
	i=jian();
	if(i!=-1){
		printf("\t\t\t   请输入你要转账的账号：");
		scanf("%s",&zhang);
		for(j=0;j<count;j++){
			if(strcmp(b[j].zhang,zhang)==0){
				printf("\t\t\t   请输入你要转账的金额：");
				scanf("%s",&m);
				if(m<b[i].money){
					b[i].money=b[i].money-m;
					b[j].money=b[j].money-m;
					printf("\t\t\t   你的用户为：%s,你的余额为：%.2f",b[i].name,b[i].money);
				}else{
					printf("\t\t\t   你的余额不足，请重新输入。");
					return;
				}
			}
		}
		if(i>=count){
			printf("\t\t\t   你输入的信息有误，请重新输入。\n");	
		}
	}
}
void chaxun(){
	int i;
	i=jian();
	if(i!=-1){
	printf("\t\t\t   你的用户是：%s,余额为：%f",b[i].name,b[i].money);	
	}
}
void xiugai(){
	char mima2[6],mima3[6];
	int i;
	i=jian();
	if(i!=-1){
		printf("\t\t\t   请输入你的新密码：");
		scanf("%s",&mima2);
		printf("\t\t\t   请确认你的密码：");
		scanf("%s",&mima3);
		if(strcmp(mima3,mima2)==0){
			strcmp(b[i].mima,mima3);
			printf("\t\t\t   你的新密码是：%s\n",b[i].mima);
		}else{
			printf("\t\t\t   两次密码不一致，修改密码失败，请重新选择。\n");
			return;
		}		
	}
}
int jian(){
	int i;
	char zhang[16],mima2[6];
	printf("\t\t\t   请输入你的账号：");
	scanf("%s",&zhang);
	printf("\t\t\t   请输入你的密码：");
	scanf("%s",&mima2);
	for(i=0;i<count;i++){
		if(strcmp(mima2,b[i].mima)==0&&strcmp(zhang,b[i].zhang)==0){
			return i;
		}
	}
	if(i>=count){
		printf("\t\t\t   你输入的用户信息有误，请重新选择\n");	
		return -1;
	}
}