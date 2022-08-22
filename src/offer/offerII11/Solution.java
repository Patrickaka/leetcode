package offer.offerII11;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        var n = nums.length;
        var ans = 0;
        var sums = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }
        for (int i = 1; i <= n; i++) {
            int t = sums[i];
            if (map.containsKey(t)) {
                ans = Math.max(ans, i - map.get(t));
            } else {
                map.put(t, i);
            }
        }
        return ans;
    }
}