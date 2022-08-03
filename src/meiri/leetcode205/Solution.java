package meiri.leetcode205;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] c1 = s.toCharArray(), c2 = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < c1.length; i++) {
            if (!map.containsKey(c1[i])) {
                if (map.containsValue(c2[i])) {
                    return false;
                }
                map.put(c1[i], c2[i]);
            } else if (map.get(c1[i]) != c2[i]) {
                return false;
            }
        }
        return true;
    }
}