package sort;

import java.util.Arrays;

import org.junit.Test;

import testtool.TestTime;


public class QuickSort {

	@Test
	public void main1() {

		long runTime = TestTime.testTime(
				()->{
					
					quickSort(test);
					//Arrays.sort(test);
				});
		
		System.out.println("RunTime: " + runTime + " ms");
		System.out.println(Arrays.toString(test));
		
	}

	static int[] test = {99,22,99,9,9,9,9,9,8,9,467,567,4567,435,2345,5,4536,436,346,346,3456,436,456,456,3456,54,134,1324,1234,2134,543,6,5,4,2,341,1,234,32,54,545,65,456,456,765,765,786,8789,90,70,7680,54758,9808,33,44,55,66,77,11,1,1,1,1,1,1,2,3,3,4,5,6,6,7,8,9,67,65,53,423,234,435,4645,123,342,213,325,436,1,1,1,1,1,1,1,1,1,1,1,1,1};
	
	void quickSort(int[] src){
		
		if(src.length > 2) {
			quickSort(src,0,src.length -1);
		}
	}
	
	 void quickSort(int[]src,int low,int high){
			
			if(low > high) 
				return;
			
			int key = src[low];
			int current = low;
			
			for(int i = low + 1;i <= high; i++) 
				if(src[i] < key)
					swap(src,++current,i);
			
			swap(src,low,current);
			
			quickSort(src,low,current - 1);
			quickSort(src,current + 1,low);
		}

	/*private void quickSort(int[] src, int left, int right) {

		if(left > right) {
			return;
		}
		
		int key = src[left];
		int low = left;
		int high = right;
		
		while(low < high) {
			
			
			while(low < high && key < src[high]) {
				high--;
			}
			
			while(low < high && key >= src[low]) {
				low++;
			}
			
			swap(src,low,high);
		}
		
		swap(src,left,high);
		
		quickSort(src,left,low - 1);
		quickSort(src,low + 1,right);
		
	}*/

	
	
	
	
	private void swap(int[] src, int i, int j) {

		if(i < j) {
			int current = src[i];
			src[i] = src[j];
			src[j] = current;
		}
	}

}
