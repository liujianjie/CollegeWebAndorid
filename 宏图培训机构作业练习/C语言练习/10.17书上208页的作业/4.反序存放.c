/* Note:Your choice is C IDE */
#include "stdio.h"
char a[100];
int i;
void fan();
void main()
{
    printf("ÇëÊäÈëÒ»¶Î×Ö·û£º");
    scanf("%s",&a);
    fan();
}
void fan(){
	for(i=strlen(a);i>=0;i--){
	
		printf("%c",a[i]);
	
	}
}