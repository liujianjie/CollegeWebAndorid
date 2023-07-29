/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	int i,d=0;
    char a[100],b[100],c[100];
    printf("请输入第一段字符：");
    scanf("%s",&a);
    printf("请输入第二段字符：");
    scanf("%s",&b);
    for(i=0;i<strlen(a);i++){
		if(b[i]=97){
			c[d]='a';
			d++;
		}
		if(b[i]=105){
			c[d]='i';
			d++;
		}
		if(b[i]=111){
			c[d]='o';
			d++;
		}
		if(b[i]=117){
			c[d]='u';
			d++;
		}
		if(b[i]=101){
			c[d]='e';
			d++;
		}
		c[d];
    	} 
    printf("%s\n",c);
    printf("%s",strcat(a,c));
}