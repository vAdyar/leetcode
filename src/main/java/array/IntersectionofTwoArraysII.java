package array;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();

        if (nums1.length > nums2.length) {
            int j = 0;
            for (int i = 0; i < nums2.length; i++) {
                if( find(nums1, nums2[i]) )
                    intersection.add(nums2[i]);
            }
        } else {
            int j = 0;
            for (int i = 0; i < nums1.length; i++) {
                if (find(nums2, nums1[i]))
                    intersection.add(nums1[i]);
            }
        }
        int[] ret = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            ret[i] = intersection.get(i);
        }
        return ret;
    }

    public static boolean find(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] == key) {
                nums[i] = -1;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        long start = System.currentTimeMillis();
        int[] inter = intersect(nums1, nums2);
        System.out.println("Time taken (ms): "+(System.currentTimeMillis() - start));
        ArrayUtils.print(inter);
    }
}
