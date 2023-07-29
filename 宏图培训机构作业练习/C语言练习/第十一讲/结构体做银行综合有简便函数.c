/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 50
struct bank{
	char name[20];
	char zhang[16];
	char mima[6];	
	float money;
}b[N];
int count=0;//全局变量
void kaihu();
void cunkuan();
void qukuan();
void zhuanzhang();
void chaxun();
void xiugai();
int jian();//无参数有返值
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
//break;return;退出函数
void kaihu(){
	char psw2[6];
	if(count+1>=N){
		printf("\t\t\t   用户已超过系统存储，请等待。\n");
		return;
	}
		printf("\t\t\t   请输入你的用户名:");
		scanf("%s",&b[count].name);
	 	printf("\t\t\t   请设置你的账号:");
	 	scanf("%s",&b[count].zhang);
	 	printf("\t\t\t   请设置你的密码:");
	 	scanf("%s",&b[count].mima);
	 	printf("\t\t\t   请确认你的密码：");
	 	scanf("%s",&psw2);
	 	if(strcmp(b[count].mima,psw2)==0){
	 		printf("\t\t\t   开户成功\n");
	 	}else{
	 		printf("\t\t\t   您两次输入的密码不一致，开户失败。\n");
	 		return;
	 	}
	 	printf("\t\t\t   请输入你的开户金额：");
	 	scanf("%f",&b[count].money);
		count++;
}
void cunkuan(){
	float m;
	int i;
	i=jian();
	    if(i!=-1){
	    	printf("\t\t\t   你的用户名为%s,余额为%.2f",b[i].name,b[i].money);
	    	printf("\n");
	    	printf("\t\t\t   请输入你要存款的金额：");
	  		scanf("%f",&m);
	  		b[i].money=b[i].money+m;
	  		printf("\t\t\t   你的账号为%s,存款为%.2f,余额为%.2f\n",b[i].name,m,b[i].money);

		}
}
void qukuan(){
	float m;
	int i;
	i=jian();
	    if(i!=-1){
	    	printf("\t\t\t   你的用户名为%s,余额为%.2f\n",b[i].name,b[i].money);
	    	printf("\t\t\t   请输入你要取款的金额：");
	  		scanf("%f",&m);
	  		if(m<=b[i].money){
	  			b[i].money=b[i].money-m;
	  			printf("\t\t\t   你的账号为%s,取款为%.2f,余额为%.2f\n",b[i].name,m,b[i].money);
	  		}else{
	  			printf("\t\t\t   你账号余额不足，请存款。\n");
	  		}
	  		
		}
}	
void zhuanzhang(){
	char zhang2[16];
	float m;
	int i,j;
	i=jian();
		if(i!=-1){
				printf("\t\t\t   请输入对方的账号：");
				scanf("%s",&zhang2);
				for(j=0;j<count;j++){
				if(strcmp(zhang2,b[j].zhang)==0){
					printf("\t\t\t   请输入你转账的金额：");
					scanf("%f",&m);
					if(m<=b[i].money){
						b[i].money=b[i].money-m;
						b[j].money=b[j].money+m;
						printf("\t\t\t   转账成功，你的余额为%.2f\n",b[i].money);
						return;
					}else{
						printf("\t\t\t   你的账户余额不足，请充值\n");
						break;
					}
					}
				}
			if(i>=count){
				printf("\t\t\t   你输入对方的账号有误,转账失败\n");
				return;
			}
		}
	}
void chaxun(){
	int i;
	i=jian();
		if(i!=-1){
			printf("\t\t\t   你的用户名为%s，余额为%.2f\n",b[i].name,b[i].money);
		}
}
void xiugai(){
	char mima2[6],mima3[6];
	int i;
	i=jian();
		if(i!=-1){
			printf("\t\t\t   你当前密码为%s\n",b[i].mima);
			printf("\t\t\t   请输入你要修改的密码：");
			scanf("%s",&mima2);
			printf("\t\t\t   请再次确认要修改的密码：");
			scanf("%s",&mima3);
			if(strcmp(mima3,b[i].mima)==0){
				strcpy(b[i].mima,mima3);
				printf("\t\t\t   修改成功，当前密码为%s：\n",b[i].mima);
				return;
			}else{
				printf("\t\t\t   两次输入的密码不一致，修改失败\n");
				return;
			}
		}else{
			printf("\t\t\t   您的密码或账号有误，修改密码失败\n");
			return;
		}
	}
int jian(){
	char zhang[16],psw[16];
	int i;
	printf("\t\t\t   请输入你的账号：");
	scanf("%s",&zhang);
	printf("\t\t\t   请输入你的密码：");
	scanf("%s",&psw);
	for(i=0;i<count;i++){
		if(strcmp(zhang,b[i].zhang)==0 && strcmp(psw,b[i].mima)==0){
			return i;
		}
	}
	if(i>=count){
			printf("\t\t您要查找的用户不存在，请确认您的账户信息!\n");
			return -1;		
	}
}
	
