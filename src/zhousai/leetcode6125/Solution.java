package zhousai.leetcode6125;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, ans = 0;
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        for (int[] ints : grid) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(ints[j]).append(",");
            }
            int step = m1.getOrDefault(sb.toString(), 0);
            m1.put(sb.toString(), step + 1);
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int[] ints : grid) {
                sb.append(ints[i]).append(",");
            }
            int step = m2.getOrDefault(sb.toString(), 0);
            m2.put(sb.toString(), step + 1);
        }
        for (String s : m2.keySet()) {
            if (m1.containsKey(s)) {
                ans += (m1.get(s) * m2.get(s));
            }
        }
        return ans;
    }
}