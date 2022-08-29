package dp.leetcode63;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
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