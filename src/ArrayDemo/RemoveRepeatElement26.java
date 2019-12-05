package ArrayDemo;

public class RemoveRepeatElement26
{
    public static void main(String[] args) {

        System.out.printf("\n" + removeRepeatElement(new int[]{0,1,2,3,3,4,4,0,6,1,2},2));
    }

    public static int removeRepeatElement(int[] nums,int val){
        int i = 0; //i指针

        //j指针
        for (int j = 1; j < nums.length; j++) {
            //将当前i指针与j指针的数据对比一下，如果重复（不相同），则将j指针的数值赋给i指针的后一位。
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
                System.out.print(nums[i] + ",");
            }
        }
        return i;
    }
}
