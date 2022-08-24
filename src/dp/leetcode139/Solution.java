package dp.leetcode139;

import java.util.List;

class Solution {

    Trie root = new Trie();

    void add(String s) {
        Trie node = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int t = s.charAt(i) - 'a';
            if (node.tries[t] == null) {
                node.tries[t] = new Trie();
            }
            node = node.tries[t];
        }
        node.end = true;
    }

    boolean check(String s) {
        Trie node = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int t = s.charAt(i) - 'a';
            if (node.tries[t] == null) {
                return false;
            }
            node = node.tries[t];
        }
        return node.end;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        for (String word : wordDict) {
            add(word);
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && check(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    private static class Trie {
        Trie[] tries;
        boolean end;
    }
}