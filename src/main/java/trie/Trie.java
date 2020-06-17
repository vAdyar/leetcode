package trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if( !node.containsKey(word.charAt(i)) )
                node.put(word.charAt(i), new TrieNode());
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if ( !node.containsKey(prefix.charAt(i)) )
                return null;
            node = node.get(prefix.charAt(i));
        }
        return node;

    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public String commonPrefix(String str) {
        TrieNode node = root;
        int i = 0;
        String ret = "";

        while( node.containsKey(str.charAt(i)) && node.getLinks() == 1 && !node.isEnd() && i < str.length() ) {
            node = node.get(str.charAt(i));
            ret += str.charAt(i);
            i++;
        }

        return ret;

    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("hello");
        System.out.println(t.search("hello"));
    }
}
