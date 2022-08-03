package meiri;

class Solution522 {
    public int findLUSlength(String[] strs) {
        int n = strs.length, ans = -1;
        for (int i = 0; i < n; i++) {
            if (strs[i].length() <= ans) {
                continue;
            }
            boolean ok = true;
            for (int j = 0; j < n && ok; j++) {
                if (i == j) {
                    continue;
                }
                if (check(strs[i], strs[j])) {
                    ok = false;
                }
            }
            if (ok) {
                ans = strs[i].length();
            }
        }
        return ans;
    }

    private boolean check(String a, String b) {
        int n = a.length(), m = b.length();
        if (m < n) {
            return false;
        }
        a = " " + a;
        b = " " + b;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i <= m; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
                }
                if ((f[i][j] - 1) == n) {
                    return true;
                }
            }
        }
        return false;
    }
}