package zhousai.shuangzhou84.t2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countBadPairs(new int[]{4, 1, 3, 3}));
    }

    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long ans = (long) n * (n - 1) / 2;
        for (int i = 0; i < n; i++) {
            int t = nums[i] - i;
            int cnt = map.getOrDefault(t, 0);
            ans -= cnt;
            map.put(t, cnt + 1);
        }
        return ans;
    }
}