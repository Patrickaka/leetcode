package meiri.leetcode593;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int[] p1 = {0, 0}, p2 = {0, 0}, p3 = {0, 0}, p4 = {0, 0};
        Solution solution = new Solution();
        System.out.println(solution.validSquare(p1, p2, p3, p4));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        Map<String, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int[] a1 = p[i], a2 = p[j];
                String key = String.valueOf(Math.sqrt((a2[0] - a1[0]) * (a2[0] - a1[0]) + (a2[1] - a1[1]) * (a2[1] - a1[1])));
                if ("0.0".equals(key)) {
                    return false;
                }
                int value = map.getOrDefault(key, 0);
                map.put(key, ++value);
            }
        }
        String max = "0", len = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 4) {
                len = entry.getKey();
            }
            if (Double.parseDouble(entry.getKey()) > Double.parseDouble(max)) {
                max = entry.getKey();
            }
        }
        if ("".equals(len) || "0,0".equals(len)) {
            return false;
        }
        Double l = Double.parseDouble(len), r = Double.parseDouble(max);
        String s1 = String.format("%.8f", l * l * 2);
        String s2 = String.format("%.8f", r * r);
        return s1.equals(s2);
    }
}