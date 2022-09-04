package zhousai.danzhou302.t1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] numberOfPairs(int[] nums) {
        int ans1 = 0, ans2 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0);
            map.put(num, cnt + 1);
        }
        for (int v : map.values()) {
            ans1 += (v / 2);
            ans2 += (v % 2);
        }
        return new int[]{ans1, ans2};
    }
}