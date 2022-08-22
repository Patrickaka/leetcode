package offer.offerII10;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int subarraySum(int[] nums, int k) {
        var ans = 0;
        var n = nums.length;
        var sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            int t = sums[i];
            int d = t - k;
            ans += map.getOrDefault(d, 0);
            map.merge(t, 1, Integer::sum);
        }
        return ans;
    }
}