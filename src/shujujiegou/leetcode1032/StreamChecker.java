package shujujiegou.leetcode1032;


/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
class StreamChecker {

    Trie root = new Trie();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for (String word : words) {
            add(word);
        }
    }

    void add(String s) {
        Trie node = root;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int u = s.charAt(i) - 'a';
            if (node.tr[u] == null) {
                node.tr[u] = new Trie();
            }
            node = node.tr[u];
        }
        node.end = true;
    }

    boolean query(StringBuilder s) {
        Trie node = root;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int u = s.charAt(i) - 'a';
            if (node.tr[u] == null) {
                return false;
            }
            if (node.tr[u].end) {
                return true;
            }
            node = node.tr[u];
        }
        return false;
    }

    public boolean query(char letter) {
        sb.append(letter);
        return query(sb);
    }

    static class Trie {
        Trie[] tr = new Trie[26];
        boolean end;
    }
}
