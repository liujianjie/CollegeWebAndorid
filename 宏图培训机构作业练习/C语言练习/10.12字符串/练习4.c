/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  	int i,c=0,d=0,e=0,f=0,g=0;
  	char a[100];
  	printf("请输入一段话：");
  	gets(a);
  	for(i=0;i<strlen(a);i++){
  		if(a[i]>=65&&a[i]<=90){
  			c=c+1;
  		}
  		else if(a[i]>=97&&a[i]<=122){
  			d=d+1;
  		}
  		else if(a[i]>='0'&&a[i]<'10'){// 49 57
  			e=e+1;
  		}
  		else if(a[i]==32){
  			f=f+1;
  		}else
  		g=g++;  		
  	}
  	printf("大写字母有%d\n",c);
  	printf("小写字母有%d\n",d);
  	printf("空格有%d\n",f);
  	printf("数字有%d\n",e);
  	printf("其它有%d\n",g);
  	
}