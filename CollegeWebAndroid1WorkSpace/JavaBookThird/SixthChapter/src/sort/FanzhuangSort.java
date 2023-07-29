package sort;

public class FanzhuangSort {
	public static void main(String[] args) {
//		int arr[] = { 10, 20, 30, 40, 50, 60 };
		int arr[] = { 63, 4, 24, 1, 3, 15 };
		int len = arr.length;
		for(int  i = 0; i < len / 2 ; i++){
			int temp = arr[i];
			arr[i] = arr[len - i - 1];
			arr[len - i - 1] = temp;
			
		}
		
//		int arr[] = { 63, 4, 24, 1, 3, 15 };
//		
//		for(int i = 1; i < arr.length; i++){
//			int index = 0;
//			for(int j = 1; j <= arr.length - i; j++){ // 因为是动态的
//				if(arr[j] > arr[index]){
//					index = j;
//				}
//			}
//			int temp = arr[arr.length - i];//arr.leng- i 是当前最后的下标
//			arr[arr.length - i] = arr[index];
//			arr[index] = temp;
//		}
		sort(arr);
	}
	private static void sort(int arr[]){
		for(int x : arr){
			System.out.print(x+" ");
		}
		
	}
}
