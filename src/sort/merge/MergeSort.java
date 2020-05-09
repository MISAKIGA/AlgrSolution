package sort.merge;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 8,4,5,7,1,3,6,2};
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[]arr , int left,int right,int[] temp) {
		if(left < right) {
			int mid = (left + right) /2;
			//向左
			mergeSort(arr, left, mid, temp);
			
			//向右递归分解
			mergeSort(arr, mid + 1, right, temp);

			//合并
			mergeSort(arr, left, mid, right, temp);
		}
	}

	/**
	 * 
	 * @param arr 原始数组
	 * @param left 左边有序序列初始化索引
	 * @param mid 中间
	 * @param right 右边
	 * @param temp 中转数组
	 */
	public static void mergeSort(int[] arr ,int left,int mid,int right,int[] temp) {

		int i = left;	//左边
		int j = mid + 1; //右边有序序列的初始索引
		int t = 0;		//指向temp数组当前索引
		
		//把左右两边的数据按照规则填充到temp数组
		//直到两边有序序列，一边处理完毕
		while(i <= mid	&& j <= right) {
			//如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
			//将左边当前元素，拷贝到temp数组
			//
			if(arr[i] <= arr[j] ) {
				temp[t] = arr[i];
				t += 1;
				i += 1;
				
			} else {
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}
		
		//把剩余数据的一边数据依次全部填充到temp
		//左边的有序序列有剩余的元素，全部填充到temp
		while(i <= mid) {
			temp[t] = arr[i]; 
			t += 1;
			i += 1;
		}
		while(j <= right) {
			temp[t] = arr[j]; 
			t += 1;
			j += 1;
		}
		
		//将temp数组的元素拷贝到arr
		t = 0;
		int tempLeft = left;
		while(tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}
	}
}
