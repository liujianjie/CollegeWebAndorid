import java.util.Scanner;
public class Test�쳣{
	
	public static void main(String dffs[]){
	int i;
	System.out.println("������һ������");
	Scanner a=new Scanner(System.in);
	i=a.nextInt();
	try{
		if(i==0){
			throw new �쳣("��ĸ����Ϊ0");
			
		}
		System.out.println(5/i);


	}catch(�쳣 e){
	
		System.out.println(""+e.getMessage());

	}

	}

}