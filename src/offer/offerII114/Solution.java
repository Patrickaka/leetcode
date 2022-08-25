package offer.offerII114;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    int[][] grid = new int[26][26];
    int[] in = new int[26];

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(solution.alienOrder(words));
    }

    public String alienOrder(String[] words) {
        int n = words.length;
        boolean[] vis = new boolean[26];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                if (!vis[c - 'a'] && ++cnt >= 0) {
                    vis[c - 'a'] = true;
                }
            }
            for (int j = 0; j < i; j++) {
                if (!build(words[j], words[i])) {
                    return "";
                }
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (vis[i] && in[i] == 0) {
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            sb.append((char) ('a' + poll));
            for (int i = 0; i < 26; i++) {
                if (grid[poll][i] == 1) {
                    if (--in[i] == 0) {
                        deque.addLast(i);
                    }
                }
            }
        }
        return sb.length() == cnt ? sb.toString() : "";
    }

    boolean build(String a, String b) {
        int n = a.length(), m = b.length(), len = Math.min(n, m);
        for (int i = 0; i < len; i++) {
            int c1 = a.charAt(i) - 'a', c2 = b.charAt(i) - 'a';
            if (c1 != c2) {
                if (grid[c1][c2] != 1) {
                    grid[c1][c2] = 1;
                    in[c2]++;
                }
                return true;
            }
        }
        return n <= m;
    }
}