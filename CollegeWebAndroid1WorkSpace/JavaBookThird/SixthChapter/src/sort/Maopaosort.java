package sort;

public class Maopaosort {
	public static void main(String[] args) {
		int arr[] = { 63, 4, 24, 1, 3, 15 };
		for(int i = 1; i < arr.length; i++){//注意 i = 1  不需要6轮
			for(int j = 0; j < arr.length - i ; j++){//j < arr.length - 1
				if(arr[j] > arr[j + 1]){
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		sort(arr);
	}
	private static void sort(int arr[]){
		for(int x : arr){
			System.out.print(x+" ");
		}
		
	}
}
