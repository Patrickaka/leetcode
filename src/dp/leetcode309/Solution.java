package dp.leetcode309;

/**
 * 买卖股票的最佳冷冻期
 */
class Solution {

    /**
     * dp[i][0]表示第i天持有股票的最大利润
     * dp[i][1]表示第i天不持有股票 并且当天卖出的最大利润
     * dp[i][2]表示第i天不持有股票 并且不是当天卖出的最大利润
     */
    public int maxProfit(int[] price) {
        int n = price.length;
        int[][] dp = new int[n + 1][3];
        dp[0][0] = -1 * price[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - price[i]);
            dp[i][1] = dp[i - 1][0] + price[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}