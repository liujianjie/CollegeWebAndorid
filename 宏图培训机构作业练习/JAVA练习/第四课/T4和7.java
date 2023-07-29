public class T4和7
{
	public static void main(String[] args) 
	{
		int a=0,b=0,c=0,sum=0;
		System.out.println("因为水仙花数固定在100至1000所以所有的水仙花数为：");
		for(int i=100;i<=1000;i++){
			sum=0;
			a=i/100%10;
			b=i/10%10;
			c=i/1%10;
			sum=a*a*a+b*b*b+c*c*c;
			if(i==sum){
			System.out.println(sum+"\t");
			}
		}
	}
}
