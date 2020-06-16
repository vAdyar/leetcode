package string;

public class StringToInt {

    public static int myAtoi(String str) {
        int i = 0;
        int ret = 0;
        boolean sign = true;
        int n = str.length();

        if( n==0 )
            return 0;

        char c = str.charAt(i);
        if ((c < '0' || c > '9') && (c != '-' && c != '+' && c != ' '))
            return 0;

        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        if (i == n)
            return 0;

        if (str.charAt(i) == '+' && i + 1 < n)
            i++;
        else if (str.charAt(i) == '-' && i + 1 < n) {
            sign = false;
            i++;
        } else if ((str.charAt(i) < '0' || str.charAt(i) > '9'))
            return 0;

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > 7))
                return Integer.MAX_VALUE;
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && (str.charAt(i) - '0') > 8))
                return Integer.MIN_VALUE;
            if (sign)
                ret = ret * 10 + (str.charAt(i) - '0');
            else
                ret = ret * 10 - (str.charAt(i) - '0');
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        String str = "-2147483649";

        System.out.println(myAtoi(str));
    }
}
