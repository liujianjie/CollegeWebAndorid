package sort;

public class OnemoreMaopaoandXuanze {
	public static void main(String[] args) {
		int arr[] = { 63, 4, 24, 1, 3, 15 };
		
//		for(int i = 1; i < arr.length; i++){
//			for(int j = 0; j < arr.length - i; j++){
//				if(arr[j] > arr[j + 1]){
//					int temp = arr[j + 1];
//					arr[j + 1] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		}
		
//		for(int i = 1; i < arr.length; i++){
//			int index = 0;
//			for(int j = 1; j <= arr.length - i; j++){
//				if(arr[j] > arr[index]){
//					index = j;
//				}
//			}
//			int  temp = arr[arr.length - i];
//			arr[arr.length - i] = arr[index];
//			arr[index] = temp;
//		}
//		sort(arr);
		
//		for(int i = 1; i < arr.length; i++){
//			for(int j = 0; j < arr.length - i; j++){
//				if(arr[j] > arr[j + 1]){
//					int temp = arr[j + 1];
//					arr[j + 1] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		}
		
		for(int i = 1; i < arr.length; i ++){
			int index =0;
			for(int j = 1; j <= arr.length - i; j++){
				if(arr[j] > arr[0]){
					index = j;
				}
			}
			int temp = arr[arr.length - i];
			arr[arr.length - i] = arr[index];
			arr[index] = temp;
		}
		sort(arr);
	}
	private static void sort(int arr[]){
		for(int x : arr){
			System.out.print(x+" ");
		}
		
	}
}
