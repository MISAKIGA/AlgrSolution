package sort.insert;

import java.util.Arrays;

import org.junit.Test;

import testtool.TestTime;

public class InsertSort {

	static int[] test = {99,22,99,9,9,9,9,9,8,9,467,567,4567,435,2345,5,4536,436,346,346,3456,436,456,456,3456,54,134,1324,1234,2134,543,6,5,4,2,341,1,234,32,54,545,65,456,456,765,765,786,8789,90,70,7680,54758,9808,33,44,55,66,77,11,1,1,1,1,1,1,2,3,3,4,5,6,6,7,8,9,67,65,53,423,234,435,4645,123,342,213,325,436,1,1,1,1,1,1,1,1,1,1,1,1,1};
	
	//int[] test = {1,0,5,6,3,4,2,8,9};


	@Test
	public void runAlgorithmicMethod() {
		
		System.out.println("start");
		long runTime = TestTime.testTime(
				()->{
					
					insertSort(test);
					//Arrays.sort(test);
				});
		
		System.out.println("RunTime: " + runTime + " ms");
		System.out.println(Arrays.toString(test));
	}

	private void insertSort(int[] src) {

		int temp = 0;
		int leftIndex = 0;
		int currentIndex = 0;
		int length = src.length;
		for(currentIndex = 1;currentIndex < length;currentIndex++) {
			
			temp = src[currentIndex];
			leftIndex = currentIndex -1;
			while(leftIndex >= 0 && src[leftIndex] > temp) {
				src[leftIndex+1] = src[leftIndex];
				leftIndex--;
			}
			
			src[leftIndex+1] = temp;
		}
	}

	private void swap(int[] src, int i, int j) {

		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}
}
