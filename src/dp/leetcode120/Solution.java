package dp.leetcode120;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        int ans = triangle.get(0).get(0);
        for (int i = 2; i <= n; i++) {
            int[] dps = new int[n];
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                int a = (j - 1 < 0) ? Integer.MAX_VALUE : dp[j - 1];
                int b = j == i - 1 ? Integer.MAX_VALUE : dp[j];
                dps[j] = Math.min(a, Math.min(a, b)) + triangle.get(i - 1).get(j);
                min = Math.min(min, dps[j]);
            }
            dp = dps;
            ans = min;
        }
        return ans;
    }
}