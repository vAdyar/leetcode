package array;


import java.util.Arrays;

//Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
public class RemoveDuplicatesSortedArray {
    private static int[] nums = {0,0,1,2,3,4,4};

    private static int evaluate(int[] nums) {
        if( nums.length ==0 || nums.length ==1)
            return nums.length;

        int flag = 0;

        for (int i = 1; i < nums.length; i++) {
            if( nums[flag]!=nums[i]) {
                nums[++flag] = nums[i];
            }
        }
        return flag + 1;
    }

    public static void main(String[] args) {
        int count = evaluate(nums);

        for (int i = 0; i < count; i++) {
            System.out.print(nums[i]);
        }
    }
}
