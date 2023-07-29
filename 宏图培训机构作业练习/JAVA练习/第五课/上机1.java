public class 上机1
{
	//5.1.	编写程序实现输出1到1000之间，所有能被3整除又可以被7整除的数
	public static void main(String lkd[]){
		for(int i=1;i<=1000;i++){
			if(i%3==0){
				if(i%7==0){
					System.out.print(i+"\t");
				}		
			}
		}
	}
}