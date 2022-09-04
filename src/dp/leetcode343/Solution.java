package dp.leetcode343;

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(Math.max(j * (i - j), dp[j] * (i - j)), max);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}