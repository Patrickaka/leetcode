package dp.leetcode931;

import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int ans = Arrays.stream(matrix[0]).min().getAsInt();
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            int min = 20000;
            for (int j = 0; j < n; j++) {
                int a = (j - 1 < 0) ? 20000 : dp[i - 1][j - 1];
                int b = (j + 1 >= n) ? 20000 : dp[i - 1][j + 1];
                int c = dp[i - 1][j];
                dp[i][j] = Math.min(a, Math.min(b, c)) + matrix[i][j];
                min = Math.min(min, dp[i][j]);
            }
            ans = min;
        }
        return ans;
    }
}