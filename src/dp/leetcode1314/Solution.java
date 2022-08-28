package dp.leetcode1314;

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int row1 = Math.max(i - k, 1);
                int col1 = Math.max(j - k, 1);
                int row2 = Math.min(i + k, m);
                int col2 = Math.min(j + k, n);
                ans[i - 1][j - 1] = sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
            }
        }
        return ans;
    }
}