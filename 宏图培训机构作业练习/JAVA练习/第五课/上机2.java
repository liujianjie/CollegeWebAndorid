public class 上机2
{
	//5.2.	编写程序实现数组的定义及使用
	/*	定义一个多行多列的数组，通过循环来给数组赙值，然后在分别打印出数组中的每个值
*/
	public static void main(String []ddf){
		int a[][]=new int[2][5];
		//赋值
		for(int i=0;i<2;i++){
			for(int j=0;j<5;j++){
				a[i][j]=i+j+2;
			}
		
		}
		//输出
		for(int i=0;i<2;i++){
			for(int j=0;j<5;j++){
				System.out.print("a["+i+"]["+j+"]="+(a[i][j])+"\t");
			
			}
		}
	}
}