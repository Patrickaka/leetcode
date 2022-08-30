package meiri.leetcode1297;

import java.util.*;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i <= n - minSize; i++) {
            String str = s.substring(i, i + minSize);
            Set<Character> set = new HashSet<>();
            for (int k = 0; k < str.length(); k++) {
                set.add(str.charAt(k));
            }
            if (set.size() <= maxLetters) {
                map.merge(str, 1, Integer::sum);
            }
        }
        return map.values().stream().max(Comparator.comparingInt(a -> a)).orElse(0);
    }
}