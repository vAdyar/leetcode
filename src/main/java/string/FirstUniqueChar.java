package string;

import java.util.*;

public class FirstUniqueChar {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            map.put(c[i],map.getOrDefault(c[i], 0) + 1);
        }
        for (int i = 0; i < c.length; i++) {
            if (map.get(c[i]) == 1) {
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        String s = "leetcodel";

        System.out.println(firstUniqChar(s));
    }
}
