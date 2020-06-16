package string;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {

    public static String countAndSay(int n) {
        if ( n == 1 ) {
            return "1";
        }
        List<Integer> digits = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        String s = countAndSay(--n);
        int j = 0;
        int tempCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if( i ==0 ) {
                digits.add(Integer.parseInt(String.valueOf(s.charAt(i))));
                count.add(1);
            }
            if ( digits.get(j) == Integer.parseInt(String.valueOf(s.charAt(i)))) {
                count.set(j, ++tempCount);
            } else {
                tempCount = 1;
                j++;
                digits.add(Integer.parseInt(String.valueOf(s.charAt(i))));
                count.add(tempCount);
            }
        }
        String ret = "";
        j = 0;
        while( j<digits.size() ) {
            ret += count.get(j);
            ret += digits.get(j);
            j++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
