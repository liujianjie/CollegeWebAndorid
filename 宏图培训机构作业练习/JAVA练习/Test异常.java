import java.util.Scanner;
public class Test异常{
	
	public static void main(String dffs[]){
	int i;
	System.out.println("请输入一个数：");
	Scanner a=new Scanner(System.in);
	i=a.nextInt();
	try{
		if(i==0){
			throw new 异常("分母不能为0");
			
		}
		System.out.println(5/i);


	}catch(异常 e){
	
		System.out.println(""+e.getMessage());

	}

	}

}