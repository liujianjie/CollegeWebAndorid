public class T21
{
	public static void main(String[] args) 
	{
		System.out.println("打印乘法口诀表");
		for(int i=1;i<10;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+(i*j)+"\t");
			
			}
				System.out.print("\n");
		}
	}
}
