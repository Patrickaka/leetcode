package qujianqiuhe.qianzhuihe;

class Solution661 {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length, m = n == 0 ? 0 : img[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x1 = Math.max(0, i - 1) + 1, y1 = Math.max(0, j - 1) + 1;
                int x2 = Math.min(m - 1, i + 1) + 1, y2 = Math.min(n - 1, j + 1) + 1;
                int num = (x2 - x1 + 1) * (y2 - y1 + 1);
                int s = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
                ans[i][j] = s / num;
            }
        }
        return ans;
    }
}