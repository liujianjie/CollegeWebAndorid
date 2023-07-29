public class 菱形
{
	public static void main(String dls[]){
		System.out.println("固定的行数的菱形");
		int h=17,mid=h/2+1,i=1,j=1,k=1,x=1;
		for(i=1;i<=mid;i++){
			x=2*i-1;
			k=(h-x)/2;
			for(j=1;j<=k;j++){
				System.out.print(" ");
			}
			for(j=1;j<=x;j++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
		for(i=mid-1;i>0;i--){
			x=2*i-1;
			k=(h-x)/2;
			for(j=1;j<=k;j++){
				System.out.print(" ");
			}
			for(j=1;j<=x;j++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}