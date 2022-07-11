package review.zhousai.leetcode6115;

class Solution {
    static final int mod = (int) 1e9 + 7;
    static final int[][] c = new int[10001][14];

    static {
        for (int i = 0; i <= 10000; i++) {
            for (int j = 0; j <= i && j < 14; j++) {
                if (j == 0) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
                }
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        int[][] f = new int[maxValue + 1][15];
        for (int i = 0; i <= maxValue; i++) {
            f[i][1] = 1;
        }
        for (int j = 1; j < 14; j++) {
            for (int k = 1; k <= maxValue; k++) {
                for (int m = 2; m * k <= maxValue; m++) {
                    f[m * k][j + 1] = (f[m * k][j + 1] + f[k][j]) % mod;
                }
            }
        }

        long res = 0;
        for (int i = 1; i <= maxValue; i++) {
            for (int j = 1; j <= 14 && j <= n; j++) {
                res = (res + (long) f[i][j] * c[n - 1][j - 1]) % mod;
            }
        }
        return (int) res;
    }
}
