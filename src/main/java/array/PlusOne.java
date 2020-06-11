package array;

import utils.ArrayUtils;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int[] sum ;
        boolean flag = true;
        for(int el : digits) {
            if (el != 9) {
                flag = false;
                break;
            }
        }
        if(flag)
            sum = new int[digits.length + 1];
        else
            sum = new int[digits.length];

        int carry = 0;
        for (int i = digits.length-1; i >= 0; i--) {
            int temp = 0;

            if( i==digits.length -1 )
                temp = 1;
            temp += digits[i] + carry;
            if( temp > 9 ) {
                carry = 1;
                sum[i] = 0;
            } else {
                carry = 0;
                sum[i] = temp;
            }
        }
        if(flag)
            sum[0] = carry;

        return sum;
    }

    public static void main(String[] args) {
        int[] digits = {2,4,9,3,9};

        int[] ret = plusOne(digits);
        ArrayUtils.print(ret);
    }
}
