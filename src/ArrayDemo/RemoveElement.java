package ArrayDemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveElement {

    public static void main(String[] args) {
        int[] mums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;

        int reslut = remove(mums,val);
    }

    /**
     * we give a array nums[3,2,2,3]and give a target int number val = 3
     * method should be return new array length,array data has not repeat
     * @param mums
     * @param val
     * @return
     */
    private static int remove(int[] mums, int val) {

        Set<Integer> ints = new HashSet<>();
        int[] temp = new int[mums.length -1];
        for (int i = 0; i < mums.length; i++) {

            for (int j = i + 1; j < mums.length; j++) {

                if(mums[i] != mums[j] && mums[j] != val)
                {
                    ints.add(mums[j]);
                    //temp[j] = mums[j];
                }
            }
            if (i == mums.length -1)
            {
                //System.out.println(Arrays.toString(temp));
                System.out.println(Arrays.toString(ints.toArray()));
            }
        }
        return 0;
    }
}
