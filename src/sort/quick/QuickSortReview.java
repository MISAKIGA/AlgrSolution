package sort.quick;

import java.util.Arrays;

public class QuickSortReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {-9,78,0,-1,20,-569,78};
		
		quickSort(arr, 0, arr.length -1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr,int left, int right) {
		 
		int l = left;	//左边
		int r = right;	//右边 
		int pivot = arr[(left + right) / 2];	//中间值，中轴
		int temp = 0;
		while( l < r ) {
			while( arr[l] < pivot) {
				l += 1;
			}
			while( arr[r] > pivot) {
				r -= 1;
			}
			
			//l >= r 说明pivot
			//左边全部小于等于pivot值，右边全部大于等于pivot值
			if(l >= r) {
				break;
			}
			
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			//如果交换完后发现这个arr[l] = pivot。
			if(arr[l] == pivot) {
				r -= 1;
			}
			
			if(arr[r] == pivot) {
				l += 1;
			}
			
			// 如果 l == r,必须l++,r--
			if(l == r) {
				l += 1;
				r -= 1;
			}
			
			if(left < r) {
				quickSort(arr, left, r);
				quickSort(arr, l, right);
			}
		}
	}
}
