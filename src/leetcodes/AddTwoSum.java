package leetcodes;

public class AddTwoSum {

	public static void main(String[] args) {
		int p = 9; Integer[] nums = new Integer[] {2,11,15,7,7};
		System.out.println("hey man >");
		run(nums, p);
	}

	//give nums =[2,7,11,15],target = 9;
			//be nums nums[0] + nums[1] = 2 + 7 = 9
			//so return [0,1]
			/*
			 * int p = 9; Integer[] nums = new Integer[] {2,11,15,7,7};
			 */
	public static void run(Integer[] src,int target) {
		
		for (int i = 0; i < src.length - 1; i++) {
			
			for (int j = i + 1; j < src.length; j++) {
				if(src[i] + src[j] == target)
					System.out.println("find :" + target + "src1:" + src[i] + "src2:" + src[i+1]);
			}

		}
	}
}
