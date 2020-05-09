package sort.quick;

import java.util.Arrays;
import java.util.Random;


import testtool.TestTime;

public class QuickSortse02 {

	public static void main(String[] args) {

		int[] source = new int[] 
				{12,32,4,31,8,7,99,99,99,887,676,5436,99999,9999999};
		
		QuickSortDemo qsd = new QuickSortDemo(source);
		
		System.out.println(Arrays.toString(source));
		
		TestTime tt = new TestTime();
		
		long speed = tt.testTime(() ->{
			
			qsd.sort();
		});
		
		
		System.out.println("after that:" + Arrays.toString(source) + "and speed  :" + speed);
		
	}

	
}

class QuickSortDemo{
	
	private static int[] src;
	
	public QuickSortDemo(int[] src) {
		
		this.src= src;
	}
			
	
	public void sort() {
		if(src.length >= 2) {
			sort(src,0,src.length - 1);
		}
	}


	private static Random rand = new Random();
	private void sort(int[] s, int left, int right) {
		
		if(s == null || s.length == 0)
			return;
		
		if(left >= right) 
			return;
		
		int count = right - left;
		
		//insert sort
		if(count <= 7) {
			insertionSort(s);
		}
		
		//random key;
		
		
		
		//int randkey = (right - left) > 0 ? left + rand.nextInt(right - left) : left; 
		int randKey = left + count / 2;
		
		
		int indexKey = s[randKey];
		
		//swap(s,left,randkey);
		
		int i = left,j = right;
		
		while(i <= j) {
			while(s[i] < indexKey) {
				i++;
			}
			while(s[j] > indexKey) {
				j--;
			}
			
			if(i <= j) {
				swap(s, i, j);
				i++;j--;
			}
		}
		
		//swap(s, left, j);
		
		if(left < j)
			sort(s,left,j);
		
		if(right > i)
			sort(s,i,right);
	}


	private void insertionSort(int[] s) {

		for(int i = 0;i < s.length;i ++) {
			int key = s[i];
			int j = i - 1;
			while(j >= 0 && s[j] > key) {
				s[j + 1] = s[j];
				j--;
			}
			s[j + 1] = key;
		}
		
	}


	private void swap(int[] s, int i, int j) {
		
		if(i != j) {
			
			//int temp = s[i];
			//s[i] = s[j];
			//s[j] = temp;
			
			
			s[i] = s[i] ^ s[j];
			s[j] = s[i] ^ s[j];
			s[i] = s[i] ^ s[j];
		}
	}
}