package sort.select;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,23,434,2,3,0,23,8};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void selectSort(int[] arr) {
		
	
		for (int i = 0; i < arr.length; i++) {
			
			int minIndex = i;
			int min = arr[i];
					
			//遍历查找最小值
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			
			//交换
			if(minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min; 
			}
		}
	}
}
