package array;

import utils.ArrayUtils;

public class RotateArray {

//    Doesn't work for all conditions
//    Moving the elements from end of the array to the beginning
    public static void rotate0(int[] nums, int k) {
        int n = nums.length;
        int temp = 0;
        k %= n;
        int i = 0;

        int piot = nums[n-k-1];
        while( k > 0 ) {
            temp = nums[i];
            nums[i] = nums[n-k];
            nums[n-k-1] = temp;

            i++;
            k--;
        }
        if (n>2)
            nums[n-1] = piot;
    }

//    Using a temp array to store the sorted array
    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        int i = 0;
        int j = k;
        while( i < k ) {
            temp[i] = nums[n-j];
            i++; j--;
        }
        while( i< n) {
            temp[i] = nums[j];
            i++; j++;
        }
        for (int l = 0; l < n; l++) {
            nums[l] = temp[l];
        }
    }

//    rotating the array with the number of times defined, one element at a time.
    public static void rotate2(int[] nums, int k) {

        for (int j = 0; j < k; j++) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }

//    cyclic rotation
    public static void rotate3(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while ( start!=current );
        }
    }

    public static void rotate4(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }

    public static int[] reverse(int[] nums, int start, int end) {
        while( start < end ){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
        return nums;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;
        int[] nums = {1};
        int k =2;

//        rotate0(nums, k);
//        rotate1(nums, k);
//        rotate2(nums, k);
//        rotate3(nums, k);
        rotate4(nums, k);
        ArrayUtils.print(nums);
    }
}
