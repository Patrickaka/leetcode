import java.util.Arrays;

class Solution {
    int mod = (int) (1e9 + 7);

    public int countVowelPermutation(int n) {
        long ans = 0;
        long[][] f = new long[n][5];
        Arrays.fill(f[0], 1);
        for (int i = 1; i < n; i++) {
            f[i][1] += f[i - 1][0];
            f[i][0] += f[i - 1][1];
            f[i][2] += f[i - 1][1];
            f[i][0] += f[i - 1][2];
            f[i][1] += f[i - 1][2];
            f[i][3] += f[i - 1][2];
            f[i][4] += f[i - 1][2];
            f[i][2] += f[i - 1][3];
            f[i][4] += f[i - 1][3];
            f[i][0] += f[i - 1][4];
            for (int j = 0; j < 5; j++) {
                f[i][j] %= mod;
            }
        }
        for (int j = 0; j < 5; j++) {
            ans += f[n - 1][j];
        }
        return (int) (ans % mod);
    }
}
