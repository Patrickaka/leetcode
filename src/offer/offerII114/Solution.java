package offer.offerII114;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.alienOrder(new String[]{"zx", "zy"}));
    }

    public String alienOrder(String[] words) {
        int sum = 0;
        int[][] grid = new int[26][26];
        int[] in = new int[26];
        int[] out = new int[26];
        for (int i = 0; i < words.length; i++) {
            String prev = words[i];
            for (char c : prev.toCharArray()) {
                out[c - 'a'] = 1;
            }
            for (int j = i + 1; j < words.length; j++) {
                String cnt = words[j];
                if (!cnt.contains(prev)) {
                    for (int k = 0; k < 100; k++) {
                        if (k >= cnt.length()) {
                            return "";
                        }
                        char a = prev.charAt(k), b = cnt.charAt(k);
                        if (a != b) {
                            if (grid[a - 'a'][b - 'a'] != 1) {
                                grid[a - 'a'][b - 'a'] = 1;
                                in[b - 'a']++;
                            }
                            break;
                        }
                    }
                }
            }
        }
        for (int k : out) {
            if (k == 1) {
                sum++;
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        boolean flag = false;
        for (int i = 0; i < in.length; i++) {
            if (out[i] == 1 && in[i] == 0) {
                deque.addLast(i);
            }
            if (in[i] != 0) {
                flag = true;
            }
        }
        if (deque.isEmpty() && flag) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int poll = deque.poll();
            char c = (char) ('a' + poll);
            sb.append(c);
            out[c - 'a'] = 0;
            for (int j = 0; j < grid[poll].length; j++) {
                if (grid[poll][j] == 1 && --in[j] == 0) {
                    deque.addLast(j);
                }
            }
        }
        return sb.length() == sum ? sb.toString() : "";
    }
}