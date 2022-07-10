package tulun.leetcode741;

class Solution {

    static int INF = Integer.MIN_VALUE, N = 55;
    static int[][][] dp = new int[2 * N][N][N];

    public static void main(String[] args) {
        int[][] grid = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        Solution solution = new Solution();
        System.out.println(solution.cherryPickup(grid));
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i <= 2 * n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }
        dp[2][1][1] = grid[0][0];
        for (int k = 3; k <= 2 * n; k++) {
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    int c1 = k - i1, c2 = k - i2;
                    if (c1 <= 0 || c2 <= 0 || c1 > n || c2 > n) {
                        continue;
                    }
                    int A = grid[i1 - 1][c1 - 1], B = grid[i2 - 1][c2 - 1];
                    if (A == -1 || B == -1) {
                        continue;
                    }
                    int a = dp[k - 1][i1 - 1][i2 - 1], b = dp[k - 1][i1 - 1][i2], c = dp[k - 1][i1][i2 - 1], d = dp[k - 1][i1][i2];
                    int t = Math.max(Math.max(a, b), Math.max(c, d)) + A;
                    if (i1 != i2) {
                        t += B;
                    }
                    dp[k][i1][i2] = t;
                }
            }
        }
        return Math.max(dp[2 * n][n][n], 0);
    }
}