package dp.leetcode279;

class Solution {
    public int numSquares(int n) {
        int[] sq = new int[100];
        for (int i = 1; i <= 100; i++) {
            sq[i - 1] = i * i;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = 10000;
            for (int num : sq) {
                if (num <= i) {
                    min = Math.min(dp[i - num] + 1, min);
                } else {
                    break;
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }
}