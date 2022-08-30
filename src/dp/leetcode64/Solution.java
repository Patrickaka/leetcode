package dp.leetcode64;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 200;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int a = j - 1 < 0 ? max : dp[i][j - 1];
                int b = i - 1 < 0 ? max : dp[i - 1][j];
                dp[i][j] = Math.min(a, b) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}