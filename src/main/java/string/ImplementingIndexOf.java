package string;

//Implement strStr().
//
//Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
public class ImplementingIndexOf {

    public static int strStr(String haystack, String needle) {
        if ( needle == null || needle.length() == 0 ) {
            return 0;
        }
        int k = 0;

        while( k<= haystack.length() - needle.length()) {
            int i = 0;
            int j = 0;
            i = k;
            while( i < haystack.length() && j < needle.length() ) {
                if( haystack.charAt(i) == needle.charAt(j) ) {
                    if( j != needle.length() - 1 ) {
                        j++;
                    } else {
                        return i - (needle.length() - 1);
                    }
                } else {
                    if( j > 0) {
                        break;
                    }
                }
                i++;
            }
            k++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "pi";

        System.out.println(strStr(haystack, needle));
    }
}
