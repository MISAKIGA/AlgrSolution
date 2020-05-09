package sort.shell;

import java.util.Arrays;

import ease.exchange;
import testtool.TestTime;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]  arr = {8,9,1,7,2,3,5,4,1,0};
		
		int[] arr1 = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr1[i] = (int)(Math.random() * 8000000);
		}
		
		long testTime = TestTime.testTime(() -> {
			shellSort2(arr1);
		});
		
		System.out.println("time " + testTime + "::" + Arrays.toString(arr1));
		
		
	}
	
	 public static void shellSort(int[] arr) {
		 
		// 分成 len / 2 组，直到 len / 2 = 1为止
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {

			int temp = 0;
			// 遍历每一组
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					// 与第五（步长gap）个元素进行交换
					if (arr[j] > arr[j + gap]) {
						
						arr[j] ^= arr[j + gap];
						arr[j + gap] ^= arr[j];
						arr[j] ^= arr[j + gap]; 
						//temp = arr[j];
						//arr[j] = arr[j + gap];
						//arr[j + gap] = temp;
					}
				}
			}

		}
	}
	 
	 public static void shellSort2(int[] arr) {
		 for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if(arr[j] < arr[j - gap]) {
					while(j - gap >= 0 && temp < arr[j - gap]) {
						arr[j] = arr[j - gap];
						j -= gap;
					}
					arr[j] = temp; 
				}
			}
		}
	 }
	 
	 public static void shellSort3(int[] arr) {
		 int i,j,gap;
		 for (gap = arr.length; gap > 0 ; gap /= 2)
			for (i = 0; i < arr.length; i++) 
				for(j = i - gap; j >= 0 && arr[j] > arr[j + gap];j -= gap)
						exchange.exchange(arr, j, j + gap);
	 }

}
