package zidianshu.leetcode208;

class Trie {

    TreeNode root = new TreeNode();

    public Trie() {

    }

    public void insert(String word) {
        TreeNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.tns[u] == null) {
                p.tns[u] = new TreeNode();
            }
            p = p.tns[u];
        }
        p.end = true;
    }

    public boolean search(String word) {
        TreeNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.tns[u] == null) {
                return false;
            }
            p = p.tns[u];
        }
        return p.end;
    }

    public boolean startsWith(String prefix) {
        TreeNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (p.tns[u] == null) {
                return false;
            }
            p = p.tns[u];
        }
        return true;
    }

    static class TreeNode {
        boolean end;
        TreeNode[] tns = new TreeNode[26];
    }
}