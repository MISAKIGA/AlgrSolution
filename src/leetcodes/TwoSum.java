package leetcodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		//give nums =[2,7,11,15],target = 9;
		//be nums nums[0] + nums[1] = 2 + 7 = 9
		//so return [0,1]
		/*
		 * int p = 9; Integer[] nums = new Integer[] {2,11,15,7,7};
		 */
		
		int p = 6;
		Integer[] nums = new Integer[] {3,3};
		/* fistE(nums,p); */
		
		int[] result = fistF(nums,p);
		
		
		
		System.out.println("done!" + Arrays.toString(result));
	}
	
	public static int[] fistF(Integer[] nums,int target) {
		 
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0;i < nums.length;i ++) {
			
			
			int key = target - nums[i];
			
            map.put(nums[i], i);
            
            if(map.containsKey(key) && map.get(key) != i) {
				
				return new int[] {nums[i],key};
			}
			
		}
		
		throw new IllegalArgumentException("not find int arrays for target nums!!!"); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void fistE(Integer[] nums,int p) {
		
		Map<Integer,Integer[]> map = new HashMap<Integer, Integer[]>();
		
		for(int i = 0;i < nums.length;i++) {
			
			int key = nums[i];
			int j = i - 1;
			while(j >= 0) {
				if(nums[j] + nums[i] == p) {
					map.put(1, new Integer[]{j , i});
					System.out.println(Arrays.toString(map.get(1)));
				}
				
				j--;
			}
		}
	}

}
