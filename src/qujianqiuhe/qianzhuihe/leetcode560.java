package qujianqiuhe.qianzhuihe;

import java.util.HashMap;
import java.util.Map;

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0;
        int[] sums = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            int s = sums[i], d = s - k;
            ans += map.getOrDefault(d, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return ans;
    }
}