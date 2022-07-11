package zidianshu.leetcode720;

class Solution {

    TreeNode root = new TreeNode();
    String ans = "";

    void add(String str) {
        TreeNode node = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (node.tr[idx] == null) {
                node.tr[idx] = new TreeNode();
            }
            node = node.tr[idx];
        }
        node.end = true;
    }

    public String longestWord(String[] words) {
        for (String word : words) {
            add(word);
        }
        for (String word : words) {
            TreeNode node = root;
            if (word.length() < ans.length()) {
                continue;
            }
            if (word.length() == ans.length() && word.compareTo(ans) > 0) {
                continue;
            }
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.tr[idx] != null && node.tr[idx].end) {
                    node = node.tr[idx];
                    if (i == word.length() - 1) {
                        if (word.length() > ans.length()) {
                            ans = word;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    static class TreeNode {
        TreeNode[] tr = new TreeNode[26];
        boolean end;
    }
}