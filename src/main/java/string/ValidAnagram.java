package string;

import java.util.ArrayList;
import java.util.List;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        List<Character> list = new ArrayList<>();
        for(char el: s.toCharArray())
            list.add(el);
        for(char el: t.toCharArray())
            list.remove(Character.valueOf(el));

        return list.size() == 0 ? true : false;
    }

    public static boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length())
            return false;

        int[] set = new int[26];
        for (int i = 0; i < s.length(); i++) {
            set[s.charAt(i) - 'a']++;
            set[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < set.length; i++) {
            if (set[i] != 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagarama";

        System.out.println(isAnagram1(s,t));
    }
}
