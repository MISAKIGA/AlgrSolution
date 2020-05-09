package sort.radix;

import java.util.Arrays;

import testtool.TestTime;

public class RadixSort {

	public static void main(String[] args) {
		
		/**
		 * 稳定性排序定义：假定待排序的记录序列中，存在多个相同关键字，经过排序，这些记录的相对
		 * 次序保持不变，即在原序列中。r[i] = r[j] ，且r[i]在r[j]之前，而且在排序后仍r[i]在r[j]之前,
		 * 则称这种排序是稳定的。 
		 * 基数排序（桶子法）,效率高的稳定性排序法，空间换时间，占用内存大	
		 * 思想：把所有最大的位数取出来，遍历取出每一个数的对应位数，存入桶中
		 * 位数依次按照 0-9 存储在对应的 0-9号桶里，最后按照顺序0-9取出数据放入到原数组中 
		 */
		
		int[] arr  = {53,3,542,748,14,214};
		
		int[] arr1 = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr1[i] = (int)(Math.random() * 8000000);
		}
		
		long testTime = TestTime.testTime(() -> {
			raidxSort(arr1);
		});
		
		System.out.println("time " + testTime + "::" + Arrays.toString(arr1));
		/*
		 *  速度比快排要快
		 *  但内存耗的比较厉害
		 * 80000000 * 11（数组） * 4（int 4 字节） {/ 1024  / 1024 / 1024} （单位转换为GB） = 3.27 GB
		 *  数据量过大，容易堆溢出
		 */
	}

	
	public static void raidxSort(int[] arr) {
		
		// 得到数组最大数的位数
		int max = arr[0];
		for (int i = 1 ; i < arr.length; i++) {
			if (arr[i] > max ) {
				max = arr[i];
			}
		}
		//得到最大数是几位数
		int maxLength = (max + "").length();		
		
		//定义一个二维数组，表示10个桶，每个桶就是一个一维数组
		//1. 为了防止再放入数的时候，数据溢出，则每一个一维数据（桶）大小定位arr.length
		//2. 空间换时间算法
		
		int[][]  bucket = new int[10][arr.length];
		
		//为了记录每个桶中，实际存放了多少个数据，需要定义一个一维数组来记录每个桶的每次放入的数据个数
		//bec[0] = bucket[0]
		int[] bucketElementCounts = new int[10];
		
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			//针对每个元素的对应位进行排序处理
			for (int j = 0; j < arr.length; j++) {
				//取出每个元素对应位的值
				int digitOfElement = (arr[j] / n) % 10; 
				//放入对应桶中
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				//对应桶的存储指针++
				bucketElementCounts[digitOfElement]++;
			}
			
			
			//按照这个桶的顺序
			int index = 0;
			//遍历每一桶
			for (int k = 0; k < bucketElementCounts.length; k++) {
				//如果桶中，有数据，才取数据放入原数组
				if(bucketElementCounts[k] != 0) {
					//循环该桶（k），取数据放入到arr
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						//取出元素放入到arr
						arr[index++] = bucket[k][l];
					}
				}
				
				//i+1轮过后，桶需要清零
				bucketElementCounts[k] = 0;
			}
		}
	}
}
