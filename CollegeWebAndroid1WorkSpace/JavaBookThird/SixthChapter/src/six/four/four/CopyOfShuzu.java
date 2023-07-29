package six.four.four;

import java.util.Arrays;

public class CopyOfShuzu {	
	public static void main(String[] args) {
//		int arr1[] = new int[]{3,2,4,6,7};
//		int arr2[];
//		arr2 = Arrays.copyOfRange(arr1, 0,3);
//		for(int x : arr2){
//			System.out.println(x);
//		}
		int arr[] = new int[]{3,25,10,9,6};
//		Arrays.sort(arr);
		int index = Arrays.binarySearch(arr, 8);
		System.out.println(index);
	}

}
