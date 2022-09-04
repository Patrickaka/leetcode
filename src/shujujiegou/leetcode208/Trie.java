package shujujiegou.leetcode208;


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class Trie {

    Node root = new Node();

    public Trie() {

    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (node.tr[u] == null) {
                node.tr[u] = new Node();
            }
            node = node.tr[u];
        }
        node.end = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (node.tr[u] == null) {
                return false;
            }
            node = node.tr[u];
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (node.tr[u] == null) {
                return false;
            }
            node = node.tr[u];
        }
        return true;
    }

    static class Node {
        Node[] tr = new Node[26];
        boolean end;
    }
}

