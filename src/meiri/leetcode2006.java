package meiri;

import java.util.HashMap;
import java.util.Map;

class Solution2006 {
    public int countKDifference(int[] nums, int k) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>(100);
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
            if (num > max) {
                max = num;
            }
        }
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            int a = map.getOrDefault(i, 0);
            int b = map.getOrDefault(i + k, 0);
            ans += a * b;
        }
        return ans;
    }
}