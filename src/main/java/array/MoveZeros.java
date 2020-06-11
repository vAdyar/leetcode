package array;

import utils.ArrayUtils;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        int n = nums.length - 1;
        int zero = 0;
        int nzero = 0;

        while( zero<n && nzero<n ) {
            while( zero < n && nums[zero] != 0 )
                zero++;
            nzero = zero;
            while( nzero < n && nums[nzero] == 0 )
                nzero++;
            if( zero < nzero )
                swap(nums, zero, nzero);
        }
    }

    public static int[] swap(int[] nums, int from, int to) {
        int temp = nums[to];
        nums[to] = nums[from];
        nums[from] = temp;
        return nums;
    }

    public static void moveZeroes1(int[] nums) {
        int nzero = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if( nums[i] !=0 )
                nums[nzero++] = nums[i];
        }
        for (int i = nzero; i < n; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] in = {1,2,3,4,5,6,7,8,9,0,11};

//        moveZeroes(in);
        moveZeroes1(in);
        ArrayUtils.print(in);
    }
}
