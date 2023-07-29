package four.two.one;

public class Lingxin {
	public static void main(String[] args) {
		
//		int x = 1;
//		for(;x <= 5; x++){
//			if(x <= (5 - 1) / 2){
//				System.out.println();
//			}
//			
//		}
		int i,j,a = 5;
//		printf("请输入一个数（大于3的数）：");
//		scanf("%d",&a);
		//上半部分
		for(i=0;i<a;i++)
		{
			for(j=0;j<a-i;j++)
			{
				System.out.print(" ");
			}

			for(j=0;j<2*i+1;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
