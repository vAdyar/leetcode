package string;

public class ReverseString {
// Two pointer aproach
    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while( i<j ) {
            char c = s[i];
            s[i++] = s[j];
            s[j--] = c;
        }
    }

//    Single pointer aproach
    public static void reverseString1(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char c = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = c;
        }
    }


    public static void main(String[] args) {
        char[] s = {'h','e','e','l','o'};

//        reverseString(s);
        reverseString1(s);
        for ( char el : s )
            System.out.print(el +" ");

    }
}
