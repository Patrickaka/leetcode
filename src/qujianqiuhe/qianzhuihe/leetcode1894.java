package qujianqiuhe.qianzhuihe;

class Solution1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + chalk[i - 1];
        }
        long m = k % sum[n];
        int l = 1, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (sum[mid] <= m) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return sum[r] <= m ? r : r - 1;
    }
}