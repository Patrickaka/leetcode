package meiri.leetcode1460;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> m1 = new HashMap<>();
        var m2 = new HashMap<Integer, Integer>();
        for (int num : target) {
            m1.merge(num, 1, Integer::sum);
        }
        for (int num : arr) {
            m2.merge(num, 1, Integer::sum);
        }
        if (m1.keySet().size() == m2.keySet().size()) {
            for (int num : m1.keySet()) {
                if (!m1.get(num).equals(m2.get(num))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}