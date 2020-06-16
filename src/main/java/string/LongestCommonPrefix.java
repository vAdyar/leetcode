package string;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String ret = "";
        if( strs.length == 0)
            return ret;

        int i = 0;
        int j = 0;
        char c;

        while ( strs[j].length() > i ) {
            j = 0;
            if( strs[j].length() <= i)
                return ret;
            c = strs[j].charAt(i);
            while( j < strs.length - 1) {
                j++;
                if(  strs[j].length() <= i || c != strs[j].charAt(i) )
                    return ret;
            }
            i++;
            ret += c;
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] strs = {"a", "ac"};
        System.out.println(longestCommonPrefix(strs));
    }
}
