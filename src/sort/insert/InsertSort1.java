package sort.insert;

import java.util.Arrays;

public class InsertSort1 {

	public static void main(String[] args) {
	
		int[] arr = {7,8,9,4,5,2,32,1,0,25,4,78};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void insertSort(int[] arr) {
	
		 for (int i = 1; i < arr.length; i++) {
			
			 int val = arr[i];
			 int current = i - 1;
			 
			 //拿下一个数遍历之前排序好的 i-1数组
			 while(current >= 0 && arr[current] > val) {
				 arr[current + 1] = arr[current];
				 current--;
			 }
			 
			 arr[current + 1] = val;
		}
	}
}
