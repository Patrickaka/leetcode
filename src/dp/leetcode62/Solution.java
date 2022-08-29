package dp.leetcode62;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int a = j - 1 < 0 ? 0 : dp[i][j - 1];
                int b = i - 1 < 0 ? 0 : dp[i - 1][j];
                dp[i][j] = a + b;
            }
        }
        return dp[m - 1][n - 1];
    }
}