/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 50
float b[N][4];
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
	float mima;
	if(count+1>=N){
		printf("\t\t\t   用户已超过系统存储，请等待。\n");
		return;
	}
		printf("\t\t\t   请输入你的用户名:");
		scanf("%f",&b[count][0]);
	 	printf("\t\t\t   请设置你的账号:");
	 	scanf("%f",&b[count][1]);
	 	printf("\t\t\t   请设置你的密码:");
	 	scanf("%f",&b[count][2]);
	 	printf("\t\t\t   请确认你的密码：");
	 	scanf("%f",&mima);
	 	if(b[count][2]==mima){
	 		printf("\t\t\t   开户成功\n");
	 	}else{
	 		printf("\t\t\t   您两次输入的密码不一致，开户失败。\n");
	 		return;
	 	}
	 	printf("\t\t\t   请输入你的开户金额：");
	 	scanf("%f",&b[count][3]);
		count++;
}
void cunkuan(){
	float m;
	int i;
	i=jian();
	    if(i!=-1){
	    	printf("\t\t\t   你的用户名为%.0f,余额为%.2f",b[i][0],b[i][3]);
	    	printf("\n");
	    	printf("\t\t\t   请输入你要存款的金额：");
	  		scanf("%f",&m);
	  		b[i][3]=b[i][3]+m;
	  		printf("\t\t\t   你的账号为%.0f,存款为%.2f,余额为%.2f\n",b[i][0],m,b[i][3]);

		}
}
void qukuan(){
	float m;
	int i;
	i=jian();
	    if(i!=-1){
	    	printf("\t\t\t   你的用户名为%.0f,余额为%.2f\n",b[i][0],b[i][3]);
	    	printf("\t\t\t   请输入你要取款的金额：");
	  		scanf("%f",&m);
	  		if(m<=b[i][3]){
	  			b[i][3]=b[i][3]-m;
	  			printf("\t\t\t   你的账号为%.0f,取款为%.2f,余额为%.2f\n",b[i][0],m,b[i][3]);
	  		}else{
	  			printf("\t\t\t   你账号余额不足，请存款。\n");
	  		}
	  		
		}
}	
void zhuanzhang(){
	float zhang2,m;
	int i,j;
	i=jian();
		if(i!=-1){
				printf("\t\t\t   请输入对方的账号：");
				scanf("%f",&zhang2);
				for(j=0;j<count;j++){
				if(b[j][1]==zhang2){
					printf("\t\t\t   请输入你转账的金额：");
					scanf("%f",&m);
					if(m<=b[i][3]){
						b[i][3]=b[i][3]-m;
						b[j][3]=b[j][3]+m;
						printf("\t\t\t   转账成功，你的余额为%.2f\n",b[i][3]);
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
			printf("\t\t\t   你的用户名为%.2f，余额为%.2f\n",b[i][0],b[i][3]);
			return;
		}
}
void xiugai(){
	float mima2,mima3;
	int i;
	i=jian();
		if(i!=-1){
			printf("\t\t\t   你当前密码为%.0f\n",b[i][2]);
			printf("\t\t\t   请输入你要修改的密码：");
			scanf("%f",&mima2);
			printf("\t\t\t   请再次确认要修改的密码：");
			scanf("%f",&mima3);
			if(mima2==mima3){
				b[i][2]=mima2;
				printf("\t\t\t   修改成功，当前密码为%.0f：\n",b[i][2]);
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
	float zhang,mima;
	int i;
	printf("\t\t\t   请输入你的账号：");
	scanf("%f",&zhang);
	printf("\t\t\t   请输入你的密码：");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
		if(b[i][1]==zhang&&b[i][2]==mima){
			return i;
		}
	}
	if(i>=count){
			printf("\t\t您要查找的用户不存在，请确认您的账户信息!\n");
			return -1;		
	}
}
	
