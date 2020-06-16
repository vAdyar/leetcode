package string;

public class RevereseInteger {

    public static int reverse(int x) {

        int y = 0;
        boolean flag = false;
        if (x<0) {
            flag = true;
            x *= -1;
        }
        try {
            y = Integer.parseInt(new StringBuffer(String.valueOf(x)).reverse().toString());
        } catch (Exception e) {}
        return (flag) ? (y * -1) : y;
    }

    public static int reverse1(int x) {
        int rev = 0;
        int pos = 0;

        while( x != 0) {
            pos = x % 10;
            if ( rev > (Integer.MAX_VALUE/10) || (rev == Integer.MAX_VALUE/10 && pos > 7)) return 0;
            if ( rev < (Integer.MIN_VALUE/10) || (rev == Integer.MIN_VALUE/10 && pos < -8)) return 0;
            rev = rev * 10 + pos ;
            x /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int x = Integer.MIN_VALUE;

        System.out.println(reverse1(x));
    }

}
