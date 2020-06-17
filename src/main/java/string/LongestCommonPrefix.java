package string;

import trie.Trie;

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

    public static String longestCommonPrefixTrie(String[] strs) {
        Trie trie = new Trie();
        for (int i = 0; i < strs.length; i++) {
            trie.insert(strs[i]);
        }
        return trie.commonPrefix(strs[0]);
    }

    public static void main(String[] args) {
        String[] strs = {"leet", "leed"};
        System.out.println(longestCommonPrefixTrie(strs));
    }
}
