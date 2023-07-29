package paixu;

public class Maopao {
	public static void sort(int arr[]) {
		int n = arr.length;
		for(int i = 1; i < n; i++){
			for(int j = n - 1; j >= i; j--){
				if(arr[j - 1] > arr[j]){
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {49, 27, 13, 76, 97, 65, 38, 49, 23, 45, 65};
		sort(arr);
		for(Integer in : arr) {
			System.out.print(in+" ");
		}
	}
}
