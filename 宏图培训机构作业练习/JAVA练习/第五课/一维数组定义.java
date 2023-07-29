public class 一维数组定义
{
	public static void main(String dskl[])
	{
		//1
		int a[];
		a=new int[3];
		a[1]=2;
		a[2]=3;
		System.out.println(""+a[2]);
			
		//2
		int b[]=new int[3];
		b[1]=1;
		b[2]=4;
		System.out.println(""+b[2]);

		//3
		int c[]=new int[]{1,2,5};
		System.out.println(""+c[2]);

		//4
		int d[]={1,2,7};
		System.out.println(""+d[2]);
	}
}