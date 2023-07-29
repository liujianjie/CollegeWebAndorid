package six.four;

public class ForeachShuzu {
	public static void main(String[] args) {
		int arr2[][] = {{4,3},{1,2}};
		
		for(int x[] : arr2){
			for(int e : x){
//				System.out.println(x.length);
				System.out.println(e);
			}
			
		}
	}
}
