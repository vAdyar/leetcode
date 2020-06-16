package array;

import utils.ArrayUtils;

import java.util.HashMap;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int index = -1;
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            index = find(nums, target-nums[i]);
            if( index != -1 && index!=i ) {
                start = i;
                break;
            }
        }
        int[] ret = new int[2];
        ret[0] = start;
        ret[1] = index;

        return ret;
    }

    public static int find(int[] nums, int ele) {
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] == ele )
                return i;
        }
        return -1;
    }

    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if( map.containsKey(complement))
                return new int[] { map.get(complement), i};

            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;

        ArrayUtils.print(twoSum1(nums, target));
    }


}
