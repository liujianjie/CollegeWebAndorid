public class T18 
{
	public static void main(String[] args) 
	{
		System.out.println("8的倍数且1位数+2位数等于第2位数加第3位数的4位数：");
		int a=0,b=0,c=0,d=0;
		for(int i=1000;i<=9999;i++){
			a=i/1000%10;//千
			b=i/100%10;//百
			c=i/10%10;//十
			d=i/1%10;//个
			if(i%8==0){
				if(a+b==b+c){
					System.out.print(i+"\t");
				}else{}
			
			}else{}
			
		}
	}
}
