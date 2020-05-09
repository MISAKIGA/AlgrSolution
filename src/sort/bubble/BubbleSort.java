package sort.bubble;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {4,5,8,9,3,0,1,2,7};
		sort(arr);
		System.out.println(Arrays.toString(arr));
		

	}

	public static void sort(int[] arr) {
		boolean flag = false;
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					arr[j] ^= arr[j+1];
					arr[j+1] ^= arr[j];
					arr[j] ^= arr[j+1];
					
				}
			}
			System.out.println("第:" + (i + 1));
			if(!flag) {
				break;
			} else {
				flag = false;
			}
		}
		
	}
}

