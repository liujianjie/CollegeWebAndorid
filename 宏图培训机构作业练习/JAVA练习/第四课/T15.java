public class T15 
{
	public static void main(String[] args) 
	{
//计算10以内的两个数和等于10有哪些情况，输出：加数+被加数=10。
		System.out.println("10以内的两个数和等于10有:");
		for(int i=0;i<10;i++){
			
			for(int j=0;j<10;j++){
				if(i+j==10){
					System.out.println(i+"+"+j+"="+(i+j));//输出
				
				}
				
			}
		
		}
	}
}
